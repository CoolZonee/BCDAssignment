/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bcdassignment;

import com.mycompany.bcdassignment.Blockchain.Block;
import com.mycompany.bcdassignment.Blockchain.Blockchain;
import com.mycompany.bcdassignment.Entities.Patient;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author coolzone
 */
public class Test {
    public static void main(String[] args) {
        Blockchain bc = Blockchain.getInstance(Constant.PATIENT_RECORD);
        LinkedList<Block> list = bc.get();
        List<Patient> patientList = new ArrayList<>();
        list.forEach(e -> {
            if(e.tranxRecord != null) {
                e.tranxRecord.getDecryptedData().forEach(line -> {
                    String[] details = line.split(",");
                    patientList.add(new Patient(
                            details[0], 
                            details[1],
                            details[2],
                            details[3].charAt(0),
                            details[4],
                            details[5],
                            details[6],
                            details[7]
                    ));
                });
            }
        });
        
        patientList.forEach(e -> {
            System.out.println(e);
        });
    }
}
