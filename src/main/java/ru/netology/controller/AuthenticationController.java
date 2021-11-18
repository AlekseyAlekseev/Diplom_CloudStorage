package ru.netology.controller;


import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.security.AuthRequest;
import ru.netology.security.AuthResponse;
import ru.netology.service.AuthenticationService;

@RestController
public class AuthenticationController {

    AuthResponse authResponse;
    AuthenticationService authenticationService;

    @Autowired
    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/login")
    @ResponseBody
    public AuthResponse login(@RequestBody AuthRequest authRequest) {
        return authenticationService.login(authRequest);
    }

    @PostMapping("/logout")
    public void logout(@JsonProperty("auth-token") String token) {
        System.out.println(authResponse.getJwtToken());
        authResponse.setJwtToken("");
    }
}
