package com.projects.blockchainproject.model;

import java.util.Date;

import com.projects.blockchainproject.util.StringUtil;

public class Block {
    public String hash;
    public String previousHash;
    public String data;
    public Long timestamp;
    public int nonce;

    public Block(String hash, String previousHash, String data, Long timestamp, int nonce) {
        this.hash = calculateHash();
        this.previousHash = previousHash;
        this.data = data;
        this.timestamp = new Date().getTime();
        this.nonce = nonce;
    }
    public final String calculateHash() {
        String calculatedHash = StringUtil.applySha256(
                previousHash + 
                Long.toString(timestamp) + 
                data 
                );
        return calculatedHash;
    }
    public String mineBlock(int prefix) {
        String prefixString = new String(new char[prefix]).replace('\0', '0');
        while(!this.hash.substring( 0, prefix).equals(prefixString)) {
            this.nonce++;
            this.hash = calculateHash();
        }
        return this.hash;
    }
    public String getHash() {
        return hash;
    }
    public String getPreviousHash() {
        return previousHash;
    }
    public String getData() {
        return data;
    }
    public Long getTimestamp() {
        return timestamp;
    }
    public int getNonce() {
        return nonce;
    }
    public void setHash(String hash) {
        this.hash = hash;
    }
    public void setPreviousHash(String previousHash) {
        this.previousHash = previousHash;
    }
    public void setData(String data) {
        this.data = data;
    }
    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
    public void setNonce(int nonce) {
        this.nonce = nonce;
    }
}