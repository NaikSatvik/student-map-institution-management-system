package com.internproject.springpr.domain;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="notice")

public class Notice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String facName;
    private String facEmail;
    private String sub;
    private String content;

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    private String expDate;
    private String expTime;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFacName() {
        return this.facName;
    }

    public void setFacName(String facName) {
        this.facName = facName;
    }

    public String getFacEmail() {
        return this.facEmail;
    }

    public void setFacEmail(String facEmail) {
        this.facEmail = facEmail;
    }

    public String getSub() {
        return this.sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    

    public String getExpDate() {
        return this.expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public String getExpTime() {
        return this.expTime;
    }

    public void setExpTime(String expTime) {
        this.expTime = expTime;
    }


    public Notice() {
    }

    public Notice(String facName, String facEmail, String sub, String content, String expDate, String expTime) {
        this.facName=facName;
        this.facEmail=facEmail;
        this.sub=sub;
        this.content=content;
        this.expDate=expDate;
        this.expTime=expTime;
    }
}