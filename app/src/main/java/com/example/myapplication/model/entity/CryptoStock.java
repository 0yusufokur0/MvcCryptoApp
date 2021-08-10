package com.example.myapplication.model.entity;

import com.example.myapplication.manager.api.ApiEntity;

public class CryptoStock extends ApiEntity {

    private String currency;
    private String price;
    private  String market_cap;

    public String getMarket_cap() {
        return market_cap;
    }

    public String getCurrency() {
        return currency;
    }

    public double getPrice() {
        return Double.parseDouble(price);
    }
}
