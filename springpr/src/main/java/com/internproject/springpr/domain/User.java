package com.internproject.springpr.domain;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student_sign_up")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String stuEnroll;
    private String stuFname;
    private String stuMname;
    private String stuLname;
    private String stuMobile;
    private String stuEmail;
    private String stuPass;
    private String stuAddress;
    private String stuPincode;
    private String stuSem;
    private String stuHobby;

    public User() {

    }

    public User(String stuEnroll, String stuFname, String stuMname, String stuLname, String stuMobile, String stuEmail, String stuPass, String stuAddress, String stuPincode, String stuSem, String stuHobby) {
        this.stuEnroll = stuEnroll;
        this.stuFname = stuFname;
        this.stuMname = stuMname;
        this.stuLname = stuLname;
        this.stuMobile = stuMobile;
        this.stuEmail = stuEmail;
        this.stuPass = stuPass;
        this.stuAddress = stuAddress;
        this.stuPincode = stuPincode;
        this.stuSem = stuSem;
        this.stuHobby = stuHobby;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStuEnroll() {
        return this.stuEnroll;
    }

    public void setStuEnroll(String stuEnroll) {
        this.stuEnroll = stuEnroll;
    }

    public String getStuFname() {
        return this.stuFname;
    }

    public void setStuFname(String stuFname) {
        this.stuFname = stuFname;
    }

    public String getStuMname() {
        return this.stuMname;
    }

    public void setStuMname(String stuMname) {
        this.stuMname = stuMname;
    }

    public String getStuLname() {
        return this.stuLname;
    }

    public void setStuLname(String stuLname) {
        this.stuLname = stuLname;
    }

    public String getStuMobile() {
        return this.stuMobile;
    }

    public void setStuMobile(String stuMobile) {
        this.stuMobile = stuMobile;
    }

    public String getStuEmail() {
        return this.stuEmail;
    }

    public void setStuEmail(String stuEmail) {
        this.stuEmail = stuEmail;
    }

    public String getStuPass() {
        return this.stuPass;
    }

    public void setStuPass(String stuPass) {
        this.stuPass = stuPass;
    }

    public String getStuAddress() {
        return this.stuAddress;
    }

    public void setStuAddress(String stuAddress) {
        this.stuAddress = stuAddress;
    }

    public String getStuPincode() {
        return this.stuPincode;
    }

    public void setStuPincode(String stuPincode) {
        this.stuPincode = stuPincode;
    }

    public String getStuSem() {
        return this.stuSem;
    }

    public void setStuSem(String stuSem) {
        this.stuSem = stuSem;
    }

    public String getStuHobby() {
        return this.stuHobby;
    }

    public void setStuHobby(String stuHobby) {
        this.stuHobby = stuHobby;
    }
}