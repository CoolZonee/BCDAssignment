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

public class MerkleTree {
    private List<String> tranxLst;
    private String root = "0";

    public MerkleTree(List<String> tranxLst) {
        super();
        this.tranxLst = tranxLst;
    }

    public String getRoot() {
        return root;
    }

    public void build() {
        List<String> tempLst = new ArrayList<>(this.tranxLst);
        List<String> hashes = genTranxHashLst( tempLst );
        while(  hashes.size() != 1 ) {
            hashes = genTranxHashLst( hashes );
        }
        this.root = hashes.get(0);
    }

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