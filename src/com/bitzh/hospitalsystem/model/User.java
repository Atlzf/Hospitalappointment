package com.bitzh.hospitalsystem.model;

public class User {
    private int id;
    private String username;
    private String password;
    private String contactInfo;

    public User(){

    }

    public User(int id, String username, String password, String contactInfo) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.contactInfo = contactInfo;
    }
    // get和set方法
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }
}