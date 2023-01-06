/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bcdassignment.Hashing;

import java.security.MessageDigest;

import com.mycompany.bcdassignment.Constant;
import org.apache.commons.codec.binary.Hex;
/**
 *
 * @author coolzone
 */
public class Hasher {
    public static String sha256(String input) {
        return hash(input, Constant.HASHING_ALG);
    }
    
    private static String hash(String input, String algo) {

        // implementation of hashing the string based on the algo
        MessageDigest md = null;

        try {
            // instantiate md based on the algorithm
            md = MessageDigest.getInstance(algo);
            // adding security value using salt
            byte[] salt = Constant.SALT.getBytes();
            md.update(salt);
            // fetch input to md
            md.update(input.getBytes());
            // digest it into array of bytes
            byte[] hashBytes = md.digest();
            // byte[] to hex
            return Hex.encodeHexString(hashBytes);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
