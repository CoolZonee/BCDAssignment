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
import java.io.Serializable;
import java.sql.Timestamp;

public class Block implements Serializable {

    public Header header;

    public Header getHeader() {
        return header;
    }

    public TransactionCollection tranxRecord;

    public void setTranxRecord(TransactionCollection tranxRecord) {
        this.tranxRecord = tranxRecord;
    }
    
    @Override
    public String toString() {
        return "Block [body=" + tranxRecord + ", header=" + header + "]";
    }

    public Block (String previousHash) {
        header = new Header();
        header.setPrevHash(previousHash);
        header.setTimestamp(new Timestamp(System.currentTimeMillis()).getTime());

        String info = String.join("+", Integer.toString(header.getIndex()), Long.toString(header.getTimestamp()), header.getPrevHash());
        String blockHash = Hasher.sha256(info);
        header.setCurrHash(blockHash);
    }

    private byte[] getBytes() {
        try (
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(baos);
        ) {
            out.writeObject(this);
            return baos.toByteArray();
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static class Header implements Serializable {
        private int index;
        private String currHash, prevHash;
        private long timestamp;

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

        @Override
        public String toString() {
            return "Header{" +
                    "index=" + index +
                    ", currHash='" + currHash + '\'' +
                    ", prevHash='" + prevHash + '\'' +
                    ", timestamp=" + timestamp +
                    '}';
        }
    }
}

