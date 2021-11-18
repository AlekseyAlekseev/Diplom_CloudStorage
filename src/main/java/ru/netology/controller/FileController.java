package ru.netology.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.netology.entity.File;
import ru.netology.security.AuthResponse;
import ru.netology.service.AuthenticationService;
import ru.netology.service.FileSearchService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FileController {

    FileSearchService fileSearchService;
    AuthenticationService authenticationService;

    @Autowired
    public FileController(FileSearchService fileSearchService, AuthenticationService authenticationService) {
        this.fileSearchService = fileSearchService;
        this.authenticationService = authenticationService;
    }

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
    public String getList(@RequestHeader("auth-token") String token, int limit) {
            //return fileSearchService.findFileName(token, limit);
        return "hello";
    }
}
