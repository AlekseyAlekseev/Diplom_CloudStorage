package ru.netology.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.netology.security.AuthResponse;

@RestController
public class FileController {

    AuthResponse authResponse;


    @PostMapping("/file")
    public void postFile(String fileName) {

    }

    @DeleteMapping("/file")
    public void deleteFile(String fileName) {

    }

    @GetMapping("/file")
    public void getFile(String fileName) {

    }

    @PutMapping("/file")
    public void putFile(String fileName) {

    }

    @GetMapping("/list")
    public void getList(@JsonProperty("auth-token") String token, int limit) {
        if (authResponse.getJwtToken().equals(token)) {
//            return fileSearchService.findFileName(token, limit);
        } else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Username or password is incorrect");
        }
    }

}
