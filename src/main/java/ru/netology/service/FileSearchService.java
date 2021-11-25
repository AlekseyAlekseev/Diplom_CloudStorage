package ru.netology.service;

import org.h2.pagestore.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
//        if (authenticationService.getTokenByUser(token)) {
//            String login = jwtUtil.extractUsername(token);
            String login = "admin";
            System.out.println(login);
            return fileRepository.findFileByUser(login, PageRequest.of(0, limit));
//        } else {
//            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Username or password is incorrect");
//        }
    }
}
