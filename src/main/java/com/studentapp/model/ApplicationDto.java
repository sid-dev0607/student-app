package com.studentapp.model;

public class ApplicationDto {
    public String studentName;

    public String universityName;

    public String universityCourse;

    public ApplicationDto() {
    }

    public ApplicationDto(String studentName, String universityName, String universityCourse) {
        this.studentName = studentName;
        this.universityName = universityName;
        this.universityCourse = universityCourse;
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

    @Override
    public String toString() {
        return "ApplicationModel{" +
                "studentName='" + studentName + '\'' +
                ", universityName='" + universityName + '\'' +
                ", universityCourse='" + universityCourse + '\'' +
                '}';
    }
}
