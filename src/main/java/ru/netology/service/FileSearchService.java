package ru.netology.service;

import org.springframework.stereotype.Service;
import ru.netology.repository.FileDao;
import ru.netology.security.JWTUtil;

@Service
public class FileSearchService {

    FileDao fileRepository;

    JWTUtil jwtUtil;

    public FileSearchService(FileDao fileRepository, JWTUtil jwtUtil) {
        this.fileRepository = fileRepository;
        this.jwtUtil = jwtUtil;
    }

    //    public List<File> findFileName(String token, int limit) {
//        String login = jwtUtil.extractUsername(token);
//        List<File> files = fileRepository.findFileByUser(login, limit);
//
//        return files;
//    }
}
