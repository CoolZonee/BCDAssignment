/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bcdassignment.Blockchain;

/**
 *
 * @author coolzone
 */

import com.mycompany.bcdassignment.Constant;
import com.mycompany.bcdassignment.Cryptography.Asymmetric;
import com.mycompany.bcdassignment.Cryptography.KPKeyPair;
import java.io.IOException;
import java.io.Serial;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import static com.mycompany.bcdassignment.Cryptography.Asymmetric.decryptData;
import static com.mycompany.bcdassignment.Cryptography.Asymmetric.encryptData;

public class TransactionCollection implements Serializable {

    @Serial
    private static final long serialVersionUID = 3526685098573657690L;
    public List<String> tranxList = new ArrayList<>();

    public TransactionCollection(List<String> tranxList, Integer[] confidential) {
        for (int i = 0; i < tranxList.size(); i++) {
            final int current = i;
            String value;
            if (Arrays.stream(confidential).anyMatch(e -> e == current)) {
                value = encryptData(tranxList.get(i));
            } else {
                value = tranxList.get(i);
            }
            this.tranxList.add(value);
        }
    }

    public void add (String record) {
        tranxList.add(encryptData(record));
    }


    
    public List<String> getDecryptedData() {
        return tranxList
                .stream()
                .map(Asymmetric::decryptData)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "TransactionRecords {" +
                "records=" + tranxList +
                '}';
    }
}

