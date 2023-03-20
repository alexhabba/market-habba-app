package market.habba.controller;

import lombok.RequiredArgsConstructor;
import market.habba.api.UserAuthApi;
import market.habba.model.UserRequestDto;
import market.habba.model.UserTokenDto;
import market.habba.service.UserService;
import market.habba.service.impl.AuthenticationUserServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequiredArgsConstructor
public class UserAuthApiController implements UserAuthApi {

    private final PasswordEncoder passwordEncoder;
    private final UserService userService;
    private final AuthenticationUserServiceImpl authenticationUserService;

    @Override
    public ResponseEntity<UserTokenDto> authenticationUser(UserRequestDto userRequestDto) {
        return ResponseEntity.ok().body(authenticationUserService.authenticationUser(userRequestDto));
    }

    @Override
    public ResponseEntity<UserTokenDto> registrationUser(UserRequestDto userRequestDto) {
        userRequestDto.setPassword(passwordEncoder.encode(userRequestDto.getPassword()));
        userService.addNewUser(userRequestDto);
        return ResponseEntity.ok(new UserTokenDto().token("success"));
    }
}
