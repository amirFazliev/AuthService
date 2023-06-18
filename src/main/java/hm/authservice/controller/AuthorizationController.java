package hm.authservice.controller;

import hm.authservice.authorities.Authorities;
import hm.authservice.service.AuthorizationService;
import hm.authservice.users.Users;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthorizationController {
    @Autowired
    private final AuthorizationService service;

    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@Valid Users users) {
        return service.getAuthorities(users);
    }
}