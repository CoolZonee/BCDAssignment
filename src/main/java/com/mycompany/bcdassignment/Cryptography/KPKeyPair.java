/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bcdassignment.Cryptography;

import com.mycompany.bcdassignment.Constant;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 *
 * @author coolzone
 */
public class KPKeyPair {
    private KeyPairGenerator keygen;
    private KeyPair keyPair;
    public static PublicKey publicKey;
    public static PrivateKey privateKey;

    public static PublicKey getPublicKey() {
        return publicKey;
    }

    public static PrivateKey getPrivateKey() {
        return privateKey;
    }

    public KPKeyPair() {
        try {
            keygen = KeyPairGenerator.getInstance(Constant.ENCRYPTION_ALG);
            keygen.initialize(1024);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void create() {
        KPKeyPair myKeyPair = new KPKeyPair();
        // generate keypair
        myKeyPair.keyPair = myKeyPair.keygen.generateKeyPair();
        // get public key
        publicKey = myKeyPair.keyPair.getPublic();
        // get private key
        privateKey = myKeyPair.keyPair.getPrivate();
    }
    
    public static void setPublicKey(byte[] publicKeyBytes) {
        try {
            KeyFactory kf = KeyFactory.getInstance(Constant.ENCRYPTION_ALG);
            publicKey = kf.generatePublic(new X509EncodedKeySpec(publicKeyBytes));
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
    }

    public static void setPrivateKey(byte[] privateKeyBytes) {
        try {
            KeyFactory kf = KeyFactory.getInstance(Constant.ENCRYPTION_ALG);
            privateKey = kf.generatePrivate(new PKCS8EncodedKeySpec(privateKeyBytes));
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
    }
    
    public static void put( byte[] keyBytes, String path )  {
        File f = new File(path);
        f.getParentFile().mkdirs();
        try {
            Files.write(Paths.get(path), keyBytes, StandardOpenOption.CREATE);
            System.out.println("Key is exported to '" + path + "'");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
