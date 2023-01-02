/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bcdassignment.Blockchain;

/**
 *
 * @author coolzone
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TransactionCollection implements Serializable {
    public static final int SIZE = 10;

    public String merkleRoot = "";

    public List<String> patientRecordList;

    public TransactionCollection() {
        this.patientRecordList = new ArrayList<>(SIZE);
    }

    public TransactionCollection(String merkleRoot, List<String> patientRecordList) {
        this.merkleRoot = merkleRoot;
        this.patientRecordList = patientRecordList;
    }

    public void add (String record) {
        patientRecordList.add(record);
    }

    public void setMerkleRoot(String merkleRoot) {
        this.merkleRoot = merkleRoot;
    }

    @Override
    public String toString() {
        return "TransactionRecords {" +
                "merkleRoot='" + merkleRoot + '\'' +
                ", records=" + patientRecordList +
                '}';
    }

}

