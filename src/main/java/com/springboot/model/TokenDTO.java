package com.springboot.model;


public class TokenDTO {

    private String tokenId;
    private String tokenVal;
    private String dummy;

    public TokenDTO(String tokenId, String tokenVal, String dummy) {
        this.tokenId = tokenId;
        this.tokenVal = tokenVal;
        this.dummy = dummy;
    }

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    public String getTokenVal() {
        return tokenVal;
    }

    public void setTokenVal(String tokenVal) {
        this.tokenVal = tokenVal;
    }

    public String getDummy() {
        return dummy;
    }

    public void setDummy(String dummy) {
        this.dummy = dummy;
    }
}
