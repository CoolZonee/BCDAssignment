/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bcdassignment.DigSignature;

import java.security.*;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/**
 *
 * @author Chuwei
 */
public class DigSignature {
    private Signature signature;
    PublicKey pubKey;
    PrivateKey priKey;
    String signatureAlg = "SHA256WithRSA";

//    public DigSignature(String pubKey, String prikey) {
//        try{
//            signature = Signature.getInstance(signatureAlg);
//            pubKey = stringToPublicKey(pubKey);
//            prikey = stringToPrivateKey(prikey);
//        } catch (NoSuchAlgorithmException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public PublicKey stringToPublicKey(String encodedPubKey) {
//        byte[] decoded = Base64.getDecoder().decode(encodedPubKey);
//        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(decoded);
//        KeyFactory keyFac = KeyFactory.getInstance("RSA");
//
//    }
}
