/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bcdassignment.Entities;

import java.util.List;

/**
 *
 * @author User
 */
public class MedicalRecord {
    private String UUID;
    private String appointmentUUID;
    private String diagnosis;
    private String treatment;
    private String medicines;
    private String labResult;
    private String signedBy;
    private String signatureValue;

    public static Integer[] confidential = {
            2,
            3,
            4,
            5,
    };

    public MedicalRecord(String UUID, String appointmentUUID, String diagnosis, String treatment, String medicines, String labResult, String signedBy, String signatureValue) {
        this.UUID = UUID;
        this.appointmentUUID = appointmentUUID;
        this.diagnosis = diagnosis;
        this.treatment = treatment;
        this.medicines = medicines;
        this.labResult = labResult;
        this.signedBy = signedBy;
        this.signatureValue = signatureValue;
    }

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public String getAppointmentUUID() {
        return appointmentUUID;
    }

    public void setAppointmentUUID(String appointmentUUID) {
        this.appointmentUUID = appointmentUUID;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public String getMedicines() {
        return medicines;
    }

    public void setMedicines(String medicines) {
        this.medicines = medicines;
    }

    public String getLabResult() {
        return labResult;
    }

    public void setLabResult(String labResult) {
        this.labResult = labResult;
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
        return "MedicalRecord{" +
                "UUID='" + UUID + '\'' +
                ", appointmentUUID='" + appointmentUUID + '\'' +
                ", diagnosis='" + diagnosis + '\'' +
                ", treatment='" + treatment + '\'' +
                ", medicines='" + medicines + '\'' +
                ", labResult='" + labResult + '\'' +
                ", signedBy='" + signedBy + '\'' +
                ", signatureValue='" + signatureValue + '\'' +
                '}';
    }

    public List<String> toList() {
        return List.of(new String[] {
                UUID,
                appointmentUUID,
                diagnosis,
                treatment,
                medicines,
                labResult,
                signedBy,
                signatureValue
        });
    }
}
