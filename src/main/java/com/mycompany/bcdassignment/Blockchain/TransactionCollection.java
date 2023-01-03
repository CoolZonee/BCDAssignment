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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class TransactionCollection implements Serializable {

    @Serial
    private static final long serialVersionUID = 3526685098573657690L;
    public List<String> tranxList;

    public TransactionCollection(List<String> tranxList) {
        this.tranxList = tranxList.stream().map(this::encryptData).toList();
    }

    public void add (String record) {
        tranxList.add(encryptData(record));
    }

    private String encryptData (String input) {
        // encrypt the record
        Path path = Paths.get(Constant.PUBLIC_KEY_PATH);
        if (Files.exists(path)) {
            try {
                KPKeyPair.setPublicKey(Files.readAllBytes(path));
            } catch (IOException ex) {
                Logger.getLogger(TransactionCollection.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            KPKeyPair.create();
            KPKeyPair.put(KPKeyPair.getPublicKey().getEncoded(), Constant.PUBLIC_KEY_PATH);
            KPKeyPair.put(KPKeyPair.getPrivateKey().getEncoded(), Constant.PRIVATE_KEY_PATH);
        }
        Asymmetric asym = new Asymmetric();
        return asym.encrypt(input, KPKeyPair.getPublicKey());
    }
    
    private String decryptData (String input) {
        try {
            // decrypt the record
            Path path = Paths.get(Constant.PRIVATE_KEY_PATH);
            if (Files.exists(path)) {
                try {
                    KPKeyPair.setPrivateKey(Files.readAllBytes(path));
                } catch (IOException ex) {
                    Logger.getLogger(TransactionCollection.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            Asymmetric asym = new Asymmetric();
            return asym.decrypt(input, KPKeyPair.getPrivateKey());
        } catch (Exception ex) {
            Logger.getLogger(TransactionCollection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
    
    public List<String> getDecryptedData () {
        return tranxList
                .stream()
                .map(this::decryptData)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "TransactionRecords {" +
                "records=" + tranxList +
                '}';
    }

}

