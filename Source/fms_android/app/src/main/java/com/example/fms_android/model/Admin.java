package com.example.fms_android.model;

public class Admin {
    private String userName;
    private String email;
    private String name;
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Admin() {
    }

    public Admin(String userName, String email, String name, String password) {
        this.userName = userName;
        this.email = email;
        this.name = name;
        this.password = password;
    }
}
