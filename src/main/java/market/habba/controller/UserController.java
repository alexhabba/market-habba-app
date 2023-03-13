package market.habba.controller;

import lombok.RequiredArgsConstructor;
import market.habba.api.UserApi;
import market.habba.entity.User;
import market.habba.model.CategoryDto;
import market.habba.service.CategoryService;
import market.habba.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user/")
public class UserController implements UserApi {

    private final CategoryService categoryService;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

//    @PostMapping("register")
//    public String registrationUser(@RequestBody User userDto) {
//        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
////        userService.addNewUser(userDto);
//        return "home";
//    }

    @Override
    public ResponseEntity<List<CategoryDto>> getCategories() {
        return ResponseEntity.ok().body(categoryService.getCategories());
    }

}
