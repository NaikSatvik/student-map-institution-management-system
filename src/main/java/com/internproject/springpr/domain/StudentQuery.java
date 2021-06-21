package com.internproject.springpr.domain;
import javax.persistence.*;

@Entity
@Table(name = "StuQuery")
public class StudentQuery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String stuFname;
    private String stuLname;
    private String stuMname;
    private String stuEmail;
    public String getStuEmail() {
        return stuEmail;
    }

    public void setStuEmail(String stuEmail) {
        this.stuEmail = stuEmail;
    }

    private String stuSem;
    private String stuQuery;

    public StudentQuery(String stuEmail) {
        this.stuEmail = stuEmail;
    }

    // This is a comment
    public StudentQuery() {

    }

    public StudentQuery(Long id, String stuFname, String stuLname, String stuMname, String stuSem, String stuQuery) {
        this.id = id;
        this.stuFname = stuFname;
        this.stuLname = stuLname;
        this.stuMname = stuMname;
        this.stuSem = stuSem;
        this.stuQuery = stuQuery;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStuFname() {
        return stuFname;
    }

    public void setStuFname(String stuFname) {
        this.stuFname = stuFname;
    }

    public String getStuLname() {
        return stuLname;
    }

    public void setStuLname(String stuLname) {
        this.stuLname = stuLname;
    }

    public String getStuMname() {
        return stuMname;
    }

    public void setStuMname(String stuMname) {
        this.stuMname = stuMname;
    }

    public String getStuSem() {
        return stuSem;
    }

    public void setStuSem(String stuSem) {
        this.stuSem = stuSem;
    }

    public String getStuQuery() {
        return stuQuery;
    }

    public void setStuQuery(String stuQuery) {
        this.stuQuery = stuQuery;
    }

}