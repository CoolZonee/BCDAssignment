/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bcdassignment.Entities;

/**
 *
 * @author coolzone
 */
public class Patient {
    private String patientName;
    private String IC;
    private String dob;
    private char gender;
    private String address;
    private String ethnicity;
    private String contactDetail;
    private String emergencyContact;
    public static String[] confidential = {
        "dob",
        "gender",
        "address",
        "ethnicity",
        "contactDetail",
        "emergencyContact",
    };

    public Patient(String patientName, String IC, String dob, char gender, String address, String ethnicity, String contactDetail, String emergenyContact) {
        this.patientName = patientName;
        this.IC = IC;
        this.dob = dob;
        this.gender = gender;
        this.address = address;
        this.ethnicity = ethnicity;
        this.contactDetail = contactDetail;
        this.emergencyContact = emergenyContact;
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

    public String getEmergenyContact() {
        return emergencyContact;
    }

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

    public void setEmergenyContact(String emergenyContact) {
        this.emergencyContact = emergenyContact;
    }

    @Override
    public String toString() {
        return "Patient{" + "patientName=" + patientName + ", IC=" + IC + ", dob=" + dob + ", gender=" + gender + ", address=" + address + ", ethnicity=" + ethnicity + ", contactDetail=" + contactDetail + ", emergenyContact=" + emergencyContact + '}';
    }
}
