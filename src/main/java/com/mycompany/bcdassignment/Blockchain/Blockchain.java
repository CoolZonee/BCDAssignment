/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bcdassignment.Blockchain;

/**
 *
 * @author coolzone
 */

import com.google.gson.GsonBuilder;
import com.mycompany.bcdassignment.Constant;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.LinkedList;
import java.util.List;

import static com.mycompany.bcdassignment.Constant.MASTER_BINARY_DIR;
import static com.mycompany.bcdassignment.Constant.MASTER_LEDGER_DIR;

public class Blockchain {
    private static LinkedList<Block> chain = new LinkedList<>();
    private final String ledgerFileName, chainFileName;

    public Blockchain (String moduleName) {
        this.chainFileName = Constant.MASTER_BINARY_DIR + "/" + moduleName + ".bin";
        this.ledgerFileName = Constant.MASTER_LEDGER_DIR + "/" + moduleName + ".txt";
    }

    public void genesis() {
        Block genesis = new Block("0", "");
        chain.add(genesis);
        // persist to the binary file
        persist();
        // show ledger
        distribute();
    }

    public void nextBlock(Block newBlock) {
        // obtain existing blockchain binary
        chain = get();
        newBlock.getHeader().setIndex(chain.getLast().getHeader().getIndex() + 1);
        chain.add(newBlock);
        // persist to the binary file
        persist();
    }

    public void addNewBlock(List<String> arr, Integer[] confidential) {
        if (!(new File(MASTER_BINARY_DIR).exists())) {
            new File(MASTER_BINARY_DIR).mkdir();
            new File(MASTER_LEDGER_DIR).mkdir();
        }

        if (!(new File(this.chainFileName).exists())) {
            genesis();
        }

        TransactionCollection tranxs = new TransactionCollection(arr, confidential);
        MerkleTree mt = new MerkleTree(arr);
        mt.build();

        String prevHash = get().getLast().getHeader().getCurrHash();

        Block newBlock = new Block(prevHash, mt.getRoot());
        newBlock.setTranxRecord(tranxs);

        nextBlock(newBlock);
        distribute();
    }

    public LinkedList<Block> get() {
        try (
                FileInputStream fis = new FileInputStream(this.chainFileName);
                ObjectInputStream in = new ObjectInputStream(fis)
        ) {
            return (LinkedList<Block>)in.readObject();
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void persist() {
        try (
                FileOutputStream fos = new FileOutputStream(this.chainFileName);
                ObjectOutputStream out = new ObjectOutputStream(fos)
        ) {
            out.writeObject(chain);
            System.out.println(this.chainFileName + " file is updated!");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void distribute() {
        // convert the chain to String using gson api
        try {
            String chain = new GsonBuilder().setPrettyPrinting().create().toJson(Blockchain.chain);
            System.out.println(chain);

            // write to file
            Files.write(Paths.get(this.ledgerFileName), chain.getBytes(), StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
