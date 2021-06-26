package com.internproject.springpr.domain;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="gur_query")
public class GurQuery {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String gurFname;
    private String gurMname;
    private String gurLname;
    private String gurEmail;
    private String gurQueryContent;
    private String reply;

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public GurQuery() {

    }
    
    public GurQuery(String gurFname, String gurMname, String gurLname, String gurEmail, String gurQueryContent) {
        this.gurFname = gurFname;
        this.gurMname = gurMname;
        this.gurLname = gurLname;
        this.gurEmail = gurEmail;
        this.gurQueryContent = gurQueryContent;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getGurFname() {
        return gurFname;
    }
    public void setGurFname(String gurFname) {
        this.gurFname = gurFname;
    }
    public String getGurMname() {
        return gurMname;
    }
    public void setGurMname(String gurMname) {
        this.gurMname = gurMname;
    }
    public String getGurLname() {
        return gurLname;
    }
    public void setGurLname(String gurLname) {
        this.gurLname = gurLname;
    }
    public String getGurEmail() {
        return gurEmail;
    }
    public void setGurEmail(String gurEmail) {
        this.gurEmail = gurEmail;
    }

    public String getGurQueryContent() {
        return gurQueryContent;
    }

    public void setGurQueryContent(String gurQueryContent) {
        this.gurQueryContent = gurQueryContent;
    }
}