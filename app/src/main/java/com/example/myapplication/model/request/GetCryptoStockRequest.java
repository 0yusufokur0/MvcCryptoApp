package com.example.myapplication.model.request;

public class GetCryptoStockRequest extends BaseRequest {

    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
