package hm.authservice.controller;

import hm.authservice.annotations.AppAnnotation;
import hm.authservice.authorities.Authorities;
import hm.authservice.exception.InvalidCredentials;
import hm.authservice.exception.UnauthorizedUser;
import hm.authservice.service.AuthorizationService;
import hm.authservice.users.Users;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthorizationController {
    AuthorizationService service = new AuthorizationService();

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@Valid @AppAnnotation("user") Users users) {
        try {
            return service.getAuthorities(users);
        } catch (InvalidCredentials e) {
            throw new InvalidCredentials(e.getMessage());
        } catch (UnauthorizedUser e) {
            throw new UnauthorizedUser(e.getMessage());
        } catch (RuntimeException e) {
            throw new RuntimeException("RuntimeException - ошибка");
        }
    }
}