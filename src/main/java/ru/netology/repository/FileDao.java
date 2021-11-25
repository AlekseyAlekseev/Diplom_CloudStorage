package ru.netology.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.netology.entity.File;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public interface FileDao extends JpaRepository<File, Long> {


    @Query(value = "select f.filename, f.size " +
            "from File f " +
            "INNER JOIN FETCH CloudUser u on u.id = f.user.id" +
            " where u.login = :login")
    //List<File> findFileByUser(@Param("login") String login);//@Param("login") String login);
    List<File> findFileByUser(@Param("login") String login, Pageable pageable);//@Param("login") String login);

//    @Param("limit") int limit
    // List<File> findFileByUser_LoginContaining(String login);
}
