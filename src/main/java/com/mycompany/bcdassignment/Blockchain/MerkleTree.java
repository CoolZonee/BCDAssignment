/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bcdassignment.Blockchain;

/**
 *
 * @author coolzone
 */

import com.mycompany.bcdassignment.Hashing.Hasher;
import java.util.ArrayList;
import java.util.List;

/**
 * @author kimlee
 * * @implNote
 * To generate merkle root based on the given transaction-list. */
public class MerkleTree {
    private List<String> tranxLst;
    private String root = "0";
    public String getRoot() {
        return root;
    }
    /**
     * @implNote
     * Set the transaction list to the MerkleTree object.
     @param tranxLst
     */
    public MerkleTree(List<String> tranxLst) {
        super();
        this.tranxLst = tranxLst;
    }
    /**
     * @implNote
     * Build merkle tree
     * @implSpec
     * + build() : void
     */
    public void build() {
        List<String> tempLst = new ArrayList<>(this.tranxLst);
        List<String> hashes = genTranxHashLst( tempLst );
        while(  hashes.size() != 1 ) {
            hashes = genTranxHashLst( hashes );
        }
        this.root = hashes.get(0);
    }
    /**
     * @implNote
     * Generate hashes of transactions
     * @implSpec
     * - genTranxHashLst(List<String>) : List<String>
     */
    private List<String> genTranxHashLst(List<String> tranxLst) {
        List<String> hashLst = new ArrayList<>();
        int i = 0;
        while( i < tranxLst.size() ) {
            String left = tranxLst.get(i);
            i++;
            String right = "";
            if(i != tranxLst.size()) {
                right = tranxLst.get(i);
                i++;
            }
            String hash = Hasher.sha256(left.concat(right));
            hashLst.add(hash);
        }
        return hashLst;
    }
}