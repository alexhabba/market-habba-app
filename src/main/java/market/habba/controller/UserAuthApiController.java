package market.habba.controller;

import lombok.RequiredArgsConstructor;
import market.habba.api.UserAuthApi;
import market.habba.entity.User;
import market.habba.model.Role;
import market.habba.model.UserRequestDto;
import market.habba.model.UserTokenDto;
import market.habba.security.JwtTokenProvider;
import market.habba.service.impl.MailSenderServiceImpl;
import market.habba.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
public class UserAuthApiController implements UserAuthApi {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;

    private final MailSenderServiceImpl mailSenderService;

    @Override
    public ResponseEntity<UserTokenDto> authenticationUser(UserRequestDto userRequestDto) {
        //todo вынести логику в сервис
        try {
            String email = userRequestDto.getEmail();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, userRequestDto.getPassword()));
            User user = userService.getUserByEmail(email);

            if (user == null) {
                throw new UsernameNotFoundException("User with email: " + email + " not found");
            }

            String token = jwtTokenProvider.createToken(email, user.getRoles());

            String name = user.getRoles().get(0).getName().name();
            return ResponseEntity.ok(new UserTokenDto().token(token).roles(List.of(Role.fromValue(name))));
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username or password");
        }
    }

    @Override
    public ResponseEntity<UserTokenDto> registrationUser(UserRequestDto userRequestDto) {
        userRequestDto.setPassword(passwordEncoder.encode(userRequestDto.getPassword()));
        userService.addNewUser(userRequestDto);
        return ResponseEntity.ok(new UserTokenDto().token("success"));
    }
}
