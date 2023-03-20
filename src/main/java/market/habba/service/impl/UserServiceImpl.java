package market.habba.service.impl;

import lombok.RequiredArgsConstructor;
import market.habba.entity.Role;
import market.habba.entity.User;
import market.habba.mapper.UserMapper;
import market.habba.model.UserRequestDto;
import market.habba.repository.UserRepository;
import market.habba.service.UserService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

import static market.habba.entity.enums.RoleEnum.USER;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;
    private final MailSenderServiceImpl mailSenderService;

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() ->
                new UsernameNotFoundException("User with email: " + email + " not found"));
    }

    @Override
    public User addNewUser(UserRequestDto userRequestDto) {
        //todo реализовать отправку на почту подтверждение почты
        // и добавить проверку на существующий e-mail
        mailSenderService.sendEmail(userRequestDto.getEmail(), "Вам необходимо зарегаться", "this is body");

        Role role = Role.builder().name(USER).build();
        User user = userMapper.toUser(userRequestDto);
        user.setRoles(List.of(role));
        role.setUser(user);
        return userRepository.save(user);
    }
}
