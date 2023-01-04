/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.bcdassignment;

import com.mycompany.bcdassignment.Blockchain.Block;
import com.mycompany.bcdassignment.Blockchain.Blockchain;
import com.mycompany.bcdassignment.Blockchain.MerkleTree;
import com.mycompany.bcdassignment.Blockchain.TransactionCollection;
import static com.mycompany.bcdassignment.Constant.*;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author coolzone
 */
public class BCDAssignment {

    public static void main(String[] args) {
        // Patient Record
//        String patientUUID = UUID.randomUUID().toString();
        String healthRecordUUID = UUID.randomUUID().toString();
//        String[] patient = {patientUUID, "John","763111482174","03/03/1976","M","XADDRESS","Chinese","0182325423"};
//        String[] patient = {, "Debbie", "863111482174","02/05/1986", "F", "XADDRESS", "Indian", "0122123423", "0182342137"};

        // Health Record
        String[] health = {healthRecordUUID, "6353b6fd-b2c0-4497-80dd-daec41ec8568", "170", "50.5", "A+", "allergies", "immunization", "familyhealthhistory"};


//        Blockchain patientBc = new Blockchain(PATIENT_RECORD);
        Blockchain healthBc = new Blockchain(HEALTH_RECORD);

//        patientBc.addNewBlock(Arrays.asList(patient));
//        healthBc.addNewBlock(Arrays.asList(health));
    }
}
