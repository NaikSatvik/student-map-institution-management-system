package com.internproject.springpr.domain;
import javax.persistence.*;

@Entity
@Table(name = "signup_data")
public class SignUp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String role;
    private String username;
    private String mailid;
    private String stumailid;
    private String pass;
    // This is a comment
    public SignUp() {

    }

    public SignUp(String role, String username, String mailid, String pass) {
        this.role = role;
        this.username = username;
        this.mailid = mailid;
        this.pass = pass;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStumailid() {
        return stumailid;
    }

    public void setStumailid(String stumailid) {
        this.stumailid = stumailid;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMailid() {
        return this.mailid;
    }

    public void setMailid(String mailid) {
        this.mailid = mailid;
    }

    public String getPass() {
        return this.pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
