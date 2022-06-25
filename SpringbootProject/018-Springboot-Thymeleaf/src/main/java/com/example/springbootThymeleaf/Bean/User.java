package com.example.springbootThymeleaf.Bean;

public class User {
    private Integer id;
    private String username;
    private String userpassword;
    private String useraddress;

    public User() {
    }

    public User(Integer id, String username, String userpassword, String useraddress) {
        this.id = id;
        this.username = username;
        this.userpassword = userpassword;
        this.useraddress = useraddress;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public String getUseraddress() {
        return useraddress;
    }

    public void setUseraddress(String useraddress) {
        this.useraddress = useraddress;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", userpassword='" + userpassword + '\'' +
                ", useraddress='" + useraddress + '\'' +
                '}';
    }
}
