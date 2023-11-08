package com.studentapp.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user", schema = "student")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer userId;
    @Column(name = "email_id")
    public String emailId;

    @Column(name = "password")
    public String password;

    @OneToMany(mappedBy = "user")
    public List<Application> applications;

    public User(Integer userId, String emailId, String password, List<Application> applications) {
        this.userId = userId;
        this.emailId = emailId;
        this.password = password;
        this.applications = applications;
    }

    public User() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Application> getApplications() {
        return applications;
    }

    public void setApplications(List<Application> applications) {
        this.applications = applications;
    }
}
