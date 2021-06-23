package com.internproject.springpr.service;
import java.util.List;

import com.internproject.springpr.domain.Faculty;
import com.internproject.springpr.repository.FacultyRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacultyService {
    @Autowired
    private FacultyRepository frepo;

    public List<Faculty> getByEmail(String facEmail) {
        List<Faculty> stubyemail = frepo.findByFacEmail(facEmail);
        return stubyemail;
    }

    public List<Faculty> getallfacad() {
        List <Faculty> getfac = frepo.findAll();
        return getfac;
    }
}