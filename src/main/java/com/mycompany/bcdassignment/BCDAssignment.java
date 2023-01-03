/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.bcdassignment;

import com.mycompany.bcdassignment.Blockchain.Block;
import com.mycompany.bcdassignment.Blockchain.Blockchain;
import com.mycompany.bcdassignment.Blockchain.MerkleTree;
import com.mycompany.bcdassignment.Blockchain.TransactionCollection;
import static com.mycompany.bcdassignment.Constant.*;
import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author coolzone
 */
public class BCDAssignment {

    public static void main(String[] args) {
//        String[] arr = {"John","763111482174","03/03/1976","M","XADDRESS","Chinese","0182325423","0169836437"};
        String[] arr = {"Debbie", "863111482174","02/05/1986", "F", "XADDRESS", "Indian", "0122123423", "0182342137"};
//            "Debbie,863111482174,02/05/1986,F,XADDRESS,Indian,0122123423,0182342137",
//            "Ali,023111482174,03/03/1976,M,XADDRESS,Malay,0105625423,0169823437"

        addNewBlock(Arrays.asList(arr), PATIENT_RECORD);
    }
    
    static void addNewBlock(List<String> arr, String moduleName) {
        Blockchain bc = Blockchain.getInstance(moduleName);

        if (!(new File(MASTER_BINARY_DIR).exists())) {
            new File(MASTER_BINARY_DIR).mkdir();
            new File(MASTER_LEDGER_DIR).mkdir();
            bc.genesis();
        }

        TransactionCollection tranxs = new TransactionCollection(arr);
        MerkleTree mt = MerkleTree.getInstance(arr);
        mt.build();
        
        String prevHash = bc.get().getLast().getHeader().getCurrHash();

        Block newBlock = new Block(prevHash, mt.getRoot());
        newBlock.setTranxRecord(tranxs);

        bc.nextBlock(newBlock);
        bc.distribute();
    }
}
