/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bcdassignment.Entities;

import java.util.ArrayList;
import java.util.List;

public class Patient {
    private String UUID;
    private String patientName;
    private String IC;
    private String dob;
    private char gender;
    private String address;
    private String ethnicity;
    private String contactDetail;

    public static Integer[] confidential = {};

    public Patient(String UUID, String patientName, String IC, String dob, char gender, String address, String ethnicity, String contactDetail) {
        this.UUID = UUID;
        this.patientName = patientName;
        this.IC = IC;
        this.dob = dob;
        this.gender = gender;
        this.address = address;
        this.ethnicity = ethnicity;
        this.contactDetail = contactDetail;
    }

    public String getUUID() {
        return UUID;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getIC() {
        return IC;
    }

    public String getDob() {
        return dob;
    }

    public char getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }

    public String getEthnicity() {
        return ethnicity;
    }

    public String getContactDetail() {
        return contactDetail;
    }

    public void setUUID(String UUID) {this.UUID= UUID; }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public void setIC(String IC) {
        this.IC = IC;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity;
    }

    public void setContactDetail(String contactDetail) {
        this.contactDetail = contactDetail;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "UUID='" + UUID + '\'' +
                ", patientName='" + patientName + '\'' +
                ", IC='" + IC + '\'' +
                ", dob='" + dob + '\'' +
                ", gender=" + gender +
                ", address='" + address + '\'' +
                ", ethnicity='" + ethnicity + '\'' +
                ", contactDetail='" + contactDetail + '\'' +
                '}';
    }

    public List<String> toList() {
        return List.of(new String[]{UUID, patientName, IC, dob, String.valueOf(gender), address, ethnicity, contactDetail});
    }
}
