package ru.netology.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.netology.entity.File;

import java.util.List;


@Repository
public interface FileDao extends JpaRepository<File, Long> {

    @Query("select top 3 f.filename, f.size " +
            "from File f " +
            "INNER JOIN USERS U on U.ID = f.USER_ID " +
            "where U.LOGIN = :login")
    List<File> findFileByUser(@Param("login") String login, @Param("limit") int limit);
}
