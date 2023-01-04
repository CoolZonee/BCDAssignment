/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bcdassignment.Entities;

/**
 *
 * @author User
 */
public class User {
    private String UUID;
    private String name;
    private char gender;
    private String email;
    private String contactNumber;
    private String role;
    private String username;
    private String password;

    public User(String UUID, String name, char gender, String email, String contactNumber, String role, String username, String password) {
        this.UUID = UUID;
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.contactNumber = contactNumber;
        this.role = role;
        this.username = username;
        this.password = password;
    }

    public String getUUID() {
        return UUID;
    }

    public String getName() {
        return name;
    }

    public char getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getRole() {
        return role;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "UUID='" + UUID + '\'' +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", role='" + role + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
