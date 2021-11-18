package ru.netology.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ru.netology.security.AuthRequest;
import ru.netology.security.AuthResponse;
import ru.netology.security.JWTUtil;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthenticationService {


    AuthenticationManager authenticationManager;

    JWTUtil jwtTokenUtil;

    Map<String, String> tokenUser = new HashMap<>();

    @Autowired
    public AuthenticationService(AuthenticationManager authenticationManager, JWTUtil jwtTokenUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    public void setTokenByUser(String login, String token) {
        tokenUser.put(login, token);
    }

    public boolean getTokenByUser(String token) {
        return tokenUser.containsValue(token);
    }

    public void deleteTokenByUser(String login) {
        tokenUser.remove(login);
    }

    public AuthResponse login(AuthRequest authRequest) {
        Authentication authentication;
        try {
            authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getLogin(), authRequest.getPassword()));
        } catch (BadCredentialsException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username or password is incorrect", e);
        }
        String jwt = jwtTokenUtil.generateToken((UserDetails) authentication.getPrincipal());
        setTokenByUser(authRequest.getLogin(), jwt);
        return new AuthResponse(jwt);
    }
}
