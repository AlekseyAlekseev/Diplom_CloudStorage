package ru.netology.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.netology.entity.CloudUser;

@Repository
public interface UserDao extends JpaRepository<CloudUser, Long> {

    CloudUser findByLogin(String login);
}
