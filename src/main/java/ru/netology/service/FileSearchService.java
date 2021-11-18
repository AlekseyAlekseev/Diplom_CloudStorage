package ru.netology.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ru.netology.entity.File;
import ru.netology.repository.FileDao;
import ru.netology.security.JWTUtil;

import java.util.List;

@Service
public class FileSearchService {

    FileDao fileRepository;

    JWTUtil jwtUtil;

    AuthenticationService authenticationService;

    @Autowired
    public FileSearchService(FileDao fileRepository, JWTUtil jwtUtil, AuthenticationService authenticationService) {
        this.fileRepository = fileRepository;
        this.jwtUtil = jwtUtil;
        this.authenticationService = authenticationService;
    }

    public List<File> findFileName(String token, int limit) {
        if (authenticationService.getTokenByUser(token)) {
            String login = jwtUtil.extractUsername(token);
            //List<File> files = fileRepository.findFileByUser(login, limit);
            return fileRepository.findFileByUser_LoginContaining(login);
        } else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Username or password is incorrect");
        }
    }
}
