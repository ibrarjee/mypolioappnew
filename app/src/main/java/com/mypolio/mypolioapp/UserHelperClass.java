package com.mypolio.mypolioapp;

public class UserHelperClass {
    String name ,username, phoneno, email, password;

    public UserHelperClass() {

    }

    public UserHelperClass(String name, String username, String phoneno, String email, String password) {
        this.name = name;
        this.username = username;
        this.phoneno = phoneno;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

