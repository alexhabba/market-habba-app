package market.habba.controller;

import lombok.RequiredArgsConstructor;
import market.habba.api.AdminApi;
import market.habba.api.UserAuthApi;
import market.habba.entity.User;
import market.habba.model.ProductDto;
import market.habba.model.UserRequestDto;
import market.habba.model.UserTokenDto;
import market.habba.security.JwtTokenProvider;
import market.habba.service.MailSenderServiceImpl;
import market.habba.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
public class AdminApiController implements AdminApi {


    @Override
    public ResponseEntity<UserTokenDto> addImages(String productName, List<MultipartFile> images) {
        System.out.println();
        return null;
    }

    @Override
    public ResponseEntity<UserTokenDto> addProduct(ProductDto productDto) {
        return null;
    }
}
