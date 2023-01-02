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
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TransactionCollection implements Serializable {
    public static final int SIZE = 10;

    public String merkleRoot = "";

    public List<String> tranxList;

    public TransactionCollection() {
        this.tranxList = new ArrayList<>(SIZE);
    }

    public TransactionCollection(String merkleRoot, List<String> tranxList) {
        this.merkleRoot = merkleRoot;
        this.tranxList = tranxList;
    }

    public void add (String record) {
        tranxList.add(encryptData(record));
    }

    public void setMerkleRoot(String merkleRoot) {
        this.merkleRoot = merkleRoot;
    }
    
    private String encryptData (String input) {
        // encrypt the record
        if (Files.exists(Paths.get(Constant.PUBLIC_KEY_PATH))) {
            try {
                KPKeyPair.setPublicKey(Files.readAllBytes(Paths.get(Constant.PUBLIC_KEY_PATH)));
            } catch (IOException ex) {
                Logger.getLogger(TransactionCollection.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            KPKeyPair.create();
        }
        Asymmetric asym = new Asymmetric();
        return asym.encrypt(input, KPKeyPair.getPublicKey());
    }
    
    private String decryptData (String input) {
        try {
            // decrypt the record
            if (Files.exists(Paths.get(Constant.PRIVATE_KEY_PATH))) {
                try {
                    KPKeyPair.setPrivateKey(Files.readAllBytes(Paths.get(Constant.PRIVATE_KEY_PATH)));
                } catch (IOException ex) {
                    Logger.getLogger(TransactionCollection.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                KPKeyPair.create();
            }
            Asymmetric asym = new Asymmetric();
            return asym.decrypt(input, KPKeyPair.getPrivateKey());
        } catch (Exception ex) {
            Logger.getLogger(TransactionCollection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    @Override
    public String toString() {
        return "TransactionRecords {" +
                "merkleRoot='" + merkleRoot + '\'' +
                ", records=" + tranxList +
                '}';
    }

}

