package market.habba.service;

import lombok.RequiredArgsConstructor;
import market.habba.entity.User;
import market.habba.repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;

    @Override
    public UUID getUserId() {
        User user = userRepository.findByEmail(getAuthentication().getName()).orElseThrow();
        return user.getId();
    }

    private Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

}
