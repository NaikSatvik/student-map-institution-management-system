package com.internproject.springpr.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="faculty_sign_up")
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String facFname;
    private String facMname;
    private String facLname;
    private String facMobile;
    private String facEmail;
    private String facPass;
    private String facAddress;
    private String facPincode;
    private String facDesig;
    private String facQuali;
    private String facExp;
    private String facSpeci;

    public Faculty() {

    }

    public Faculty (String facFname,String facMname,String facLname,String facMobile,String facEmail,String facPass,String facAddress,String facPincode,String facDesig,String facQuali,String facExp,String facSpeci) {
        this.facFname = facFname;
        this.facMname = facMname;
        this.facLname = facLname;
        this.facMobile = facMobile;
        this.facEmail = facEmail;
        this.facPass = facPass;
        this.facAddress = facAddress;
        this.facPincode = facPincode;
        this.facDesig = facDesig;
        this.facQuali = facQuali;
        this.facAddress = facExp;
        this.facSpeci = facSpeci;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFacFname() {
        return this.facFname;
    }

    public void setFacFname(String facFname) {
        this.facFname = facFname;
    }

    public String getFacMname() {
        return this.facMname;
    }

    public void setFacMname(String facMname) {
        this.facMname = facMname;
    }

    public String getFacLname() {
        return this.facLname;
    }

    public void setFacLname(String facLname) {
        this.facLname = facLname;
    }

    public String getFacMobile() {
        return this.facMobile;
    }

    public void setFacMobile(String facMobile) {
        this.facMobile = facMobile;
    }

    public String getFacEmail() {
        return this.facEmail;
    }

    public void setFacEmail(String facEmail) {
        this.facEmail = facEmail;
    }

    public String getFacPass() {
        return this.facPass;
    }

    public void setFacPass(String facPass) {
        this.facPass = facPass;
    }

    public String getFacAddress() {
        return this.facAddress;
    }

    public void setFacAddress(String facAddress) {
        this.facAddress = facAddress;
    }

    public String getFacPincode() {
        return this.facPincode;
    }

    public void setFacPincode(String facPincode) {
        this.facPincode = facPincode;
    }

    public String getFacDesig() {
        return this.facDesig;
    }

    public void setFacDesig(String facDesig) {
        this.facDesig = facDesig;
    }

    public String getFacQuali() {
        return this.facQuali;
    }

    public void setFacQuali(String facQuali) {
        this.facQuali = facQuali;
    }

    public String getFacExp() {
        return this.facExp;
    }

    public void setFacExp(String facExp) {
        this.facExp = facExp;
    }

    public String getFacSpeci() {
        return this.facSpeci;
    }

    public void setFacSpeci(String facSpeci) {
        this.facSpeci = facSpeci;
    }   
}