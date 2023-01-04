/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bcdassignment.Entities;

/**
 *
 * @author coolzone
 */
public class HealthRecord {
    private String UUID;
    private String patientUUID;
    private double height;
    private double weight;
    private String bloodType;
    private String allergies;
    private String immunization;
    private String familyHealthHistory;

    public static Integer[] confidential = {
        2,
        3,
        4,
        5,
        6,
        7,
    };

    public HealthRecord(String UUID, String patientUUID, double height, double weight, String bloodType, String allergies, String immunization, String familyHealthHistory) {
        this.UUID = UUID;
        this.patientUUID = patientUUID;
        this.height = height;
        this.weight = weight;
        this.bloodType = bloodType;
        this.allergies = allergies;
        this.immunization = immunization;
        this.familyHealthHistory = familyHealthHistory;
    }

    public String getUUID() {
        return UUID;
    }

    public String getPatientUUID() { return patientUUID; }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public String getBloodType() {
        return bloodType;
    }

    public String getAllergies() {
        return allergies;
    }

    public String getImmunization() {
        return immunization;
    }

    public String getFamilyHealthHistory() {
        return familyHealthHistory;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public void setPatientUUID(String patientUUID) {this.patientUUID = patientUUID;}

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public void setImmunization(String immunization) {
        this.immunization = immunization;
    }

    public void setFamilyHealthHistory(String familyHealthHistory) {
        this.familyHealthHistory = familyHealthHistory;
    }

    @Override
    public String toString() {
        return "HealthRecord{" + "UUID=" + UUID + ", patientUUID=" + patientUUID + ", height=" + height + ", weight=" + weight + ", bloodType=" + bloodType + ", allergies=" + allergies + ", immunization=" + immunization + ", familyHealthHistory=" + familyHealthHistory + '}';
    }
}
