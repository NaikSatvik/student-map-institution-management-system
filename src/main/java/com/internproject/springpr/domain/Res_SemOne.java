package com.internproject.springpr.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="res_sem_one")
public class Res_SemOne {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String emailid;
    private String branch;
    private String year;
    private String semester;
    private String enroll;
    private String ip;
    private String esfpi;
    private String de;
    private String be;
    private String calculus;
    private String sgpa;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailid() {
        return this.emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getBranch() {
        return this.branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getYear() {
        return this.year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getSemester() {
        return this.semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getEnroll() {
        return this.enroll;
    }

    public void setEnroll(String enroll) {
        this.enroll = enroll;
    }

    public String getIp() {
        return this.ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getEsfpi() {
        return this.esfpi;
    }

    public void setEsfpi(String esfpi) {
        this.esfpi = esfpi;
    }

    public String getDe() {
        return this.de;
    }

    public void setDe(String de) {
        this.de = de;
    }

    public String getBe() {
        return this.be;
    }

    public void setBe(String be) {
        this.be = be;
    }

    public String getCalculus() {
        return this.calculus;
    }

    public void setCalculus(String calculus) {
        this.calculus = calculus;
    }

    public String getSgpa() {
        return this.sgpa;
    }

    public void setSgpa(String sgpa) {
        this.sgpa = sgpa;
    }

    public Res_SemOne() {

    }

    public Res_SemOne(Long id,String name,String emailid,String branch,String year,String semester,String enroll,String ip,String esfpi,String de,String be,String calculus,String sgpa) {
        super();
        this.id = id;
        this.name = name;
        this.emailid = emailid;
        this.branch = branch;
        this.year = year;
        this.semester = semester;
        this.enroll = enroll;
        this.ip = ip;
        this.esfpi = esfpi;
        this.de = de;
        this.be = be;
        this.calculus = calculus;
        this.sgpa = sgpa;
    }
}
