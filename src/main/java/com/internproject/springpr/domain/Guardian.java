package com.internproject.springpr.domain;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="guardian_sign_up")
public class Guardian {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String gurFname;
    private String gurMname;
    private String gurLname;
    private String gurMobile;
    private String gurEmail;
    private String gurPass;
    private String gurAddress;
    private String gurPincode;
    private String gurStudentmail;

    public Guardian() {

    }

    public Guardian(Long id, String gurFname, String gurMname, String gurLname, String gurMobile, String gurEmail, String gurPass, String gurAddress, String gurPincode, String gurStudentmail) {
        this.id = id;
        this.gurFname = gurFname;
        this.gurMname = gurMname;
        this.gurLname = gurLname;
        this.gurMobile = gurMobile;
        this.gurEmail = gurEmail;
        this.gurPass = gurPass;
        this.gurAddress = gurAddress;
        this.gurPincode = gurPincode;
        this.gurStudentmail = gurStudentmail;
    }

    public String getGurFname() {
        return this.gurFname;
    }

    public void setGurFname(String gurFname) {
        this.gurFname = gurFname;
    }

    public String getGurMname() {
        return this.gurMname;
    }

    public void setGurMname(String gurMname) {
        this.gurMname = gurMname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGurLname() {
        return this.gurLname;
    }

    public void setGurLname(String gurLname) {
        this.gurLname = gurLname;
    }

    public String getGurMobile() {
        return this.gurMobile;
    }

    public void setGurMobile(String gurMobile) {
        this.gurMobile = gurMobile;
    }

    public String getGurEmail() {
        return this.gurEmail;
    }

    public void setGurEmail(String gurEmail) {
        this.gurEmail = gurEmail;
    }

    public String getGurPass() {
        return this.gurPass;
    }

    public void setGurPass(String gurPass) {
        this.gurPass = gurPass;
    }

    public String getGurAddress() {
        return this.gurAddress;
    }

    public void setGurAddress(String gurAddress) {
        this.gurAddress = gurAddress;
    }

    public String getGurPincode() {
        return this.gurPincode;
    }

    public void setGurPincode(String gurPincode) {
        this.gurPincode = gurPincode;
    }

    public String getGurStudentmail() {
        return this.gurStudentmail;
    }

    public void setGurStudentmail(String gurStudentmail) {
        this.gurStudentmail = gurStudentmail;
    }
}