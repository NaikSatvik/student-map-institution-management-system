package com.internproject.springpr.service;

import java.util.List;

import com.internproject.springpr.domain.Guardian;
import com.internproject.springpr.repository.GuardianRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuardianService {
    @Autowired
    private GuardianRepository grepo;
    public Guardian glogin(String gurEmail,String gurPass,String gurStudentmail) {
        Guardian guardian = grepo.findByGurEmailAndGurPassAndGurStudentmail(gurEmail, gurPass, gurStudentmail);
        return guardian;
    }

    public List<Guardian> getallparentad() {
        List <Guardian> getparent = grepo.findAll();
        return getparent;
    }
}