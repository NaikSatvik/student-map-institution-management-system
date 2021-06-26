// package demo.demo;
// here follow file is having table for follow_unfollow functionality where email id and session email id and fields required
package com.internproject.springpr.domain;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="follow_unfollow")
public class follow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String stuName;
    private String sEmail;//session email
    private String status;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getStuName() {
        return stuName;
    }
    public follow(Long id, String stuName, String sEmail, String status) {
        this.id = id;
        this.stuName = stuName;
        this.sEmail = sEmail;
        this.status = status;
    }
    public follow()
    {
        
    }
    public void setStuName(String stuName) {
        this.stuName = stuName;
    }
    public String getsEmail() {
        return sEmail;
    }
    public void setsEmail(String sEmail) {
        this.sEmail = sEmail;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    
}