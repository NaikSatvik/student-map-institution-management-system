package com.internproject.springpr.repository;

import com.internproject.springpr.domain.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByStuEmailAndStuPassAndStuSem(String stuEmail, String stuPass, String stuSem);
}