/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bcdassignment.Entities;

import java.util.List;

/**
 *
 * @author coolzone
 */
public class MedicalAppointment {
    private String UUID;
    private String patientUUID;
    private String date;
    private String time;
    private String doctorInCharge;
    private String reason;
    private String signedBy;
    private String signatureValue;

    public static Integer[] confidential = {};

    public MedicalAppointment(String UUID, String patientUUID, String date, String time, String doctorInCharge, String reason, String signedBy, String signatureValue) {
        this.UUID = UUID;
        this.patientUUID = patientUUID;
        this.date = date;
        this.time = time;
        this.doctorInCharge = doctorInCharge;
        this.reason = reason;
        this.signedBy = signedBy;
        this.signatureValue = signatureValue;
    }

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public String getPatientUUID() {
        return patientUUID;
    }

    public void setPatientUUID(String patientUUID) {
        this.patientUUID = patientUUID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDoctorInCharge() {
        return doctorInCharge;
    }

    public void setDoctorInCharge(String doctorInCharge) {
        this.doctorInCharge = doctorInCharge;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getSignedBy() {
        return signedBy;
    }

    public void setSignedBy(String signedBy) {
        this.signedBy = signedBy;
    }

    public String getSignatureValue() {
        return signatureValue;
    }

    public void setSignatureValue(String signatureValue) {
        this.signatureValue = signatureValue;
    }

    @Override
    public String toString() {
        return "MedicalAppointment{" +
                "UUID='" + UUID + '\'' +
                ", patientUUID='" + patientUUID + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", doctorInCharge='" + doctorInCharge + '\'' +
                ", reason='" + reason + '\'' +
                ", signedBy='" + signedBy + '\'' +
                ", signatureValue='" + signatureValue + '\'' +
                '}';
    }

    public List<String> toList() {
        return List.of(new String[] {
           UUID,
           patientUUID,
           date,
           time,
           doctorInCharge,
           reason,
           signedBy,
           signatureValue
        });
    }
}
