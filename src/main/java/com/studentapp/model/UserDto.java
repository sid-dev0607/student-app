package com.studentapp.model;

public class UserDto {
    public String emailId;

    public String password;

    public UserDto() {
    }

    public UserDto(String emailId, String password, Long enrolmentNo) {
        this.emailId = emailId;
        this.password = password;
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
}
