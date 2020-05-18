package com.nmr.nmp.domain;

public class User {

    private String firstName, lastName, role, userName;

    public User(String firstName, String lastName, String role, String userName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.userName = userName;
    }

    public User(String role, String userName) {
        this.role = role;
        this.userName = userName;
    }

    public User() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
