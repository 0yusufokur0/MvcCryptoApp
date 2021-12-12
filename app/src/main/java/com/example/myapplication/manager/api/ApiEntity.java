package com.example.myapplication.manager.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.Serializable;

public abstract class ApiEntity implements Serializable {

    private static Gson mGson;

    @Override
    public String toString() {

        if (mGson == null) {
            mGson = new GsonBuilder().disableHtmlEscaping().create();
        }
        return mGson.toJson(this);
    }
}
