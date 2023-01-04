/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bcdassignment.Cryptography;

import com.mycompany.bcdassignment.Constant;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;

/**
 *
 * @author coolzone
 */
public class Asymmetric {
    // Cipher object is used to facilitate the en/de encryption
    private Cipher cipher;

    public Asymmetric() {
        this(Constant.CIPHER_ALG);
    }

    public Asymmetric (String algorithm) {
        try {
            cipher = Cipher.getInstance(algorithm);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    // encrypt (String, Key)
    public String encrypt (String data, PublicKey key){
        var cipherText = "";
        try {
            // init
            cipher.init(Cipher.ENCRYPT_MODE, key);

            // encrypt
            byte[] cipherBytes = cipher.doFinal(data.getBytes());

            // convert to string
            cipherText = Base64.getEncoder().encodeToString(cipherBytes);
            return cipherText;
        } catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
            throw new RuntimeException(e);
        }
    }

    // decrypt (String, Key)
    public String decrypt(String cipherText, PrivateKey key) throws Exception{
        // init
        cipher.init(Cipher.DECRYPT_MODE, key);
        // convert to byte[]
        byte[] cipherBytes = Base64.getDecoder().decode(cipherText);
        //decrypt
        byte[] dataBytes = cipher.doFinal(cipherBytes);
        return new String(dataBytes);
    }
}
