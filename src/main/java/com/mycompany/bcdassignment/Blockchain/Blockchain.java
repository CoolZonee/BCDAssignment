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

public class Blockchain {
    private static LinkedList<Block> chain = new LinkedList<>();
    private final String ledgerFileName, chainFileName;

    // Singleton pattern
    private static Blockchain _instance;
    public static Blockchain getInstance(String moduleName) {
        if (_instance == null) {
            _instance = new Blockchain(moduleName);
        }
        return _instance;
    }

    private Blockchain (String moduleName) {
        this.chainFileName = Constant.MASTER_BINARY_DIR + "/" + moduleName + ".bin";
        this.ledgerFileName = Constant.MASTER_LEDGER_DIR + "/" + moduleName + ".txt";
    }
    // Singleton pattern

    /**
     * genesis()
     */
    public void genesis() {
        Block genesis = new Block("0", "");
        chain.add(genesis);
        // persist to the binary file
        persist();
        // show ledger
        distribute();
    }

    /**
     * nextBlock()
     */
    public void nextBlock(Block newBlock) {
        // obtain existing blockchain binary
        chain = get();
        newBlock.getHeader().setIndex(chain.getLast().getHeader().getIndex() + 1);
        chain.add(newBlock);
        // persist to the binary file
        persist();
    }

    /**
     * get()
     */
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

    /**
     * persist()
     */
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

    /**
     * distribute() - display the ledger file
     */
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
