package hm.authservice.controller;

import hm.authservice.authorities.Authorities;
import hm.authservice.exception.InvalidCredentials;
import hm.authservice.exception.UnauthorizedUser;
import hm.authservice.service.AuthorizationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthorizationController {
    AuthorizationService service = new AuthorizationService() ;

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@RequestParam("user") String user, @RequestParam("password") String password) {
        try {
            return service.getAuthorities(user, password);
        } catch (InvalidCredentials e) {
            throw new InvalidCredentials(e.getMessage());
        } catch (UnauthorizedUser e) {
            throw new UnauthorizedUser(e.getMessage());
        } catch (RuntimeException e) {
            throw new RuntimeException("Error - ошибка");
        }
    }
}