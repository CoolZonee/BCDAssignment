/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bcdassignment.DigSignature;

import com.mycompany.bcdassignment.Constant;

import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/**
 *
 * @author chuwei11
 */
public class DigSignature {
    private Signature signature;
    PublicKey pubKey;
    PrivateKey priKey;
    String signatureAlg = "SHA256WithRSA";

    public DigSignature(String publicKey, String privatekey) {
        try{
            signature = Signature.getInstance(signatureAlg);
            pubKey = stringToPublicKey(publicKey);
            priKey = stringToPrivateKey(privatekey);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public PublicKey stringToPublicKey(String encodedPubKey) {
        try {
            byte[] decoded = Base64.getDecoder().decode(encodedPubKey);
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(decoded);
            KeyFactory keyFac = KeyFactory.getInstance(Constant.CIPHER_ALG);
            return keyFac.generatePublic(keySpec);
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public PrivateKey stringToPrivateKey(String encodedPriKey) {
        try {
            byte[] decoded = Base64.getDecoder().decode(encodedPriKey);
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(decoded);
            KeyFactory keyFac = KeyFactory.getInstance(Constant.CIPHER_ALG);
            return keyFac.generatePrivate(keySpec);
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // use priKey to sign
    public String sign(String data) {
        try {
            signature.initSign(priKey);
            signature.update(data.getBytes());
            return Base64.getEncoder().encodeToString(signature.sign());
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // verify with pubKey
    public boolean verify(String data, String signatureString){
        try{
            signature.initVerify(pubKey);
            signature.update(data.getBytes());
            return signature.verify(Base64.getDecoder().decode(signatureString));
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }

    }

}
