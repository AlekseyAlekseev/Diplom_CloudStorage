package ru.netology.controller;


import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.netology.security.AuthRequest;
import ru.netology.security.AuthResponse;
import ru.netology.security.JWTUtil;
import ru.netology.service.AuthenticationService;

@RestController
public class AuthenticationController {

    AuthResponse authResponse;
    AuthenticationService authenticationService;
    JWTUtil jwtUtil;

    @Autowired
    public AuthenticationController(AuthenticationService authenticationService, JWTUtil jwtUtil) {
        this.authenticationService = authenticationService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    @ResponseBody
    public AuthResponse login(@RequestBody AuthRequest authRequest) {
        return authenticationService.login(authRequest);
    }

    @PostMapping("/logout")
    public void logout(@JsonProperty("auth-token") String token) {
        authenticationService.deleteTokenByUser(jwtUtil.extractUsername(token));
        System.out.println(authenticationService.getTokenByUser(token));
    }
}
