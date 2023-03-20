package market.habba.service.impl;

import lombok.RequiredArgsConstructor;
import market.habba.entity.Role;
import market.habba.entity.User;
import market.habba.mapper.UserMapper;
import market.habba.model.UserRequestDto;
import market.habba.model.UserTokenDto;
import market.habba.security.JwtTokenProvider;
import market.habba.service.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AuthenticationUserServiceImpl {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserService userService;
    private final UserMapper userMapper;

    public UserTokenDto authenticationUser(UserRequestDto userRequestDto) {
        try {
            String email = userRequestDto.getEmail();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, userRequestDto.getPassword()));
            User user = userService.getUserByEmail(email);
            return new UserTokenDto()
                    .token(jwtTokenProvider.createToken(email, user.getRoles()))
                    .roles(getRoles(user));
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username or password");
        }
    }

    private List<market.habba.model.Role> getRoles(User user) {
        return userMapper.toRolesDto(user.getRoles().stream().map(Role::getName).collect(Collectors.toList()));
    }
}
