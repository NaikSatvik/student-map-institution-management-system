package com.internproject.springpr.service;
import com.internproject.springpr.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.internproject.springpr.domain.User;
@Service
public class UserService {
    @Autowired
    private UserRepository repo;
    public User login(String stuEmail, String stuPass, String stuSem) {
        User user = repo.findByStuEmailAndStuPassAndStuSem(stuEmail,stuPass,stuSem);
        return user;
    }
}