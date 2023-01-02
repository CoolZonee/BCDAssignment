/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bcdassignment.Entities;

/**
 *
 * @author coolzone
 */
public class MedicalAppointment {
    private String UUID;
    private String date;
    private String time;
    private String doctorInCharge;
    private String reason;
    private String diagnosisDetails;
    private String treatment;
    private String medicines;
    private String labTestResult;
    private boolean inpatient;
    public static String[] confidential = {
        "reason",
        "diagnosisDetails",
        "treatment",
        "medicines",
        "labTestResult",
        "inpatient",
    };

    public MedicalAppointment(String UUID, String date, String time, String doctorInCharge, String reason, String diagnosisDetails, String treatment, String medicines, String labTestResult, boolean inpatient) {
        this.UUID = UUID;
        this.date = date;
        this.time = time;
        this.doctorInCharge = doctorInCharge;
        this.reason = reason;
        this.diagnosisDetails = diagnosisDetails;
        this.treatment = treatment;
        this.medicines = medicines;
        this.labTestResult = labTestResult;
        this.inpatient = inpatient;
    }

    public String getUUID() {
        return UUID;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getDoctorInCharge() {
        return doctorInCharge;
    }

    public String getReason() {
        return reason;
    }

    public String getDiagnosisDetails() {
        return diagnosisDetails;
    }

    public String getTreatment() {
        return treatment;
    }

    public String getMedicines() {
        return medicines;
    }

    public String getLabTestResult() {
        return labTestResult;
    }

    public boolean isInpatient() {
        return inpatient;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setDoctorInCharge(String doctorInCharge) {
        this.doctorInCharge = doctorInCharge;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setDiagnosisDetails(String diagnosisDetails) {
        this.diagnosisDetails = diagnosisDetails;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public void setMedicines(String medicines) {
        this.medicines = medicines;
    }

    public void setLabTestResult(String labTestResult) {
        this.labTestResult = labTestResult;
    }

    public void setInpatient(boolean inpatient) {
        this.inpatient = inpatient;
    }

    @Override
    public String toString() {
        return "MedicalAppointment{" + "UUID=" + UUID + ", date=" + date + ", time=" + time + ", doctorInCharge=" + doctorInCharge + ", reason=" + reason + ", diagnosisDetails=" + diagnosisDetails + ", treatment=" + treatment + ", medicines=" + medicines + ", labTestResult=" + labTestResult + ", inpatient=" + inpatient + '}';
    }
    
    
}
