/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bcdassignment.Entities;

/**
 *
 * @author coolzone
 */
public class Payment {
    private double amount;
    private String paymentDetails;
    private String paymentStatus;
    public static String[] confidential = {};

    public Payment(double amount, String paymentDetails, String paymentStatus) {
        this.amount = amount;
        this.paymentDetails = paymentDetails;
        this.paymentStatus = paymentStatus;
    }

    public double getAmount() {
        return amount;
    }

    public String getPaymentDetails() {
        return paymentDetails;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setPaymentDetails(String paymentDetails) {
        this.paymentDetails = paymentDetails;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    @Override
    public String toString() {
        return "Payment{" + "amount=" + amount + ", paymentDetails=" + paymentDetails + ", paymentStatus=" + paymentStatus + '}';
    }
    
    
}
