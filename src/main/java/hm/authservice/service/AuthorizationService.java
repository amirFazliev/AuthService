package hm.authservice.service;

import hm.authservice.annotations.AppAnnotation;
import hm.authservice.authorities.Authorities;
import hm.authservice.exception.InvalidCredentials;
import hm.authservice.exception.UnauthorizedUser;
import hm.authservice.repository.UserRepository;
import hm.authservice.users.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorizationService {
    @Autowired
    private final UserRepository userRepository;

    public AuthorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Authorities> getAuthorities(Users users) {

        if (isEmpty(users.getUser()) || isEmpty(users.getPassword())) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(users);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + users.getUser());
        }
        return userAuthorities;

    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}
