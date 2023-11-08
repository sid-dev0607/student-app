package com.studentapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "application", schema = "student")
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer applicationId;
    @Column(name = "student_name")
    public String studentName;
    @Column(name = "university_name")
    public String universityName;

    @Column(name = "university_course")
    public String universityCourse;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "user_id")
    private User user;

    public Application() {
    }

    public Application(Integer applicationId, String studentName, String universityName, String universityCourse) {
        this.applicationId = applicationId;
        this.studentName = studentName;
        this.universityName = universityName;
        this.universityCourse = universityCourse;
    }

    public Integer getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Integer applicationId) {
        this.applicationId = applicationId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public String getUniversityCourse() {
        return universityCourse;
    }

    public void setUniversityCourse(String universityCourse) {
        this.universityCourse = universityCourse;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
