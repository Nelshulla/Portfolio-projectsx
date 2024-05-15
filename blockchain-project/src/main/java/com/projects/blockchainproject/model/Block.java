package com.projects.blockchainproject.model;

public class Block {
    public String hash;
    public String previousHash;
    public String data;
    public Long timestamp;
    public int nonce;

    public Block(String hash, String previousHash, String data, Long timestamp, int nonce) {
        this.hash = hash;
        this.previousHash = previousHash;
        this.data = data;
        this.timestamp = timestamp;
        this.nonce = nonce;
    }
}