package com.internproject.springpr.service;
import com.internproject.springpr.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.internproject.springpr.domain.User;
@Service
public class UserService {
    @Autowired
    private UserRepository repo;

    public List<User> getBySem(String stuSem) {
        List <User> userbysem = repo.findByStuSem(stuSem);
        return userbysem;
    }

    public List<User> getallstu() {
        List <User> getstu = repo.findAll();
        return getstu;
    }

    public List<User> getallstuad() {
        List <User> getstu = repo.findAll();
        return getstu;
    }
}