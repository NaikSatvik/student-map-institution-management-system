package com.internproject.springpr.repository;
import java.util.List;

import com.internproject.springpr.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByStuEmailAndStuPassAndStuSem(String stuEmail, String stuPass, String stuSem);
    List<User> findByStuSem(String stuSem);
    List<User> findAll();
}