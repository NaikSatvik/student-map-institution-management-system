package com.internproject.springpr.repository;
import java.util.List;
import com.internproject.springpr.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByStuEmailAndStuPassAndStuSem(String stuEmail, String stuPass, String stuSem);
    List<User> findByStuSem(String stuSem);
    List<User> findAll();
    User findById(String id);

    @Modifying
    @Query("UPDATE User u SET u.stuSem = :stuSem WHERE u.stuEmail = :stuEmail")
    int update(@Param("stuEmail") String stuEmail, @Param("stuSem") String stuSem);
}