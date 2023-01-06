/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author coolzone
 */
package com.mycompany.bcdassignment.Blockchain;

import com.mycompany.bcdassignment.Hashing.Hasher;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serial;
import java.io.Serializable;
import java.sql.Timestamp;

public class Block implements Serializable {

    @Serial
    private static final long serialVersionUID = 6529685098267757690L;
    public Header header;
    public TransactionCollection tranxRecord;

    public Block (String previousHash, String merkleRoot) {
        header = new Header();
        header.setPrevHash(previousHash);
        header.setTimestamp(new Timestamp(System.currentTimeMillis()).getTime());
        header.setMerkleRoot(merkleRoot);
        String info = String.join("+",
                Integer.toString(header.getIndex()),
                Long.toString(header.getTimestamp()),
                header.getPrevHash(),
                merkleRoot);
        String blockHash = Hasher.sha256(info);
        header.setCurrHash(blockHash);
    }

    public Header getHeader() {
        return header;
    }

    public void setTranxRecord(TransactionCollection tranxRecord) {
        this.tranxRecord = tranxRecord;
    }
    
    @Override
    public String toString() {
        return "Block [body=" +
                tranxRecord +
                ", header=" +
                header + "]";
    }

    public static class Header implements Serializable {
        @Serial
        private static final long serialVersionUID = 637568598567015690L;

        private int index;
        private String currHash, prevHash;
        private long timestamp;
        private String merkleRoot;

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public String getCurrHash() {
            return currHash;
        }

        public void setCurrHash(String currHash) {
            this.currHash = currHash;
        }

        public String getPrevHash() {
            return prevHash;
        }

        public void setPrevHash(String prevHash) {
            this.prevHash = prevHash;
        }

        public long getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(long timestamp) {
            this.timestamp = timestamp;
        }
        
        public String getMerkleRoot() {
            return merkleRoot;
        }
        
        public void setMerkleRoot(String merkleRoot) {
            this.merkleRoot = merkleRoot;
        }

        @Override
        public String toString() {
            return "Header{" +
                    "index=" + index +
                    ", merkleRoot='" + merkleRoot+ '\'' +
                    ", currHash='" + currHash + '\'' +
                    ", prevHash='" + prevHash + '\'' +
                    ", timestamp=" + timestamp +
                    '}';
        }
    }
}

