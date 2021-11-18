package ru.netology.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.netology.entity.CloudUser;
import ru.netology.repository.UserDao;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserDao dao;

//    @Autowired
//    public CustomUserDetailsService(PasswordEncoder passwordEncoder, UserDao dao) {
//        this.passwordEncoder = passwordEncoder;
//        this.dao = dao;
//    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

        CloudUser cloudUser = dao.findByLogin(login);
        if (cloudUser == null) {
            throw new UsernameNotFoundException("Unknown user: " + login);
        }
        return User.builder()
                .username(cloudUser.getLogin())
                .password(passwordEncoder.encode(cloudUser.getPassword()))
                .roles(cloudUser.getRole())
                .build();
    }
}
