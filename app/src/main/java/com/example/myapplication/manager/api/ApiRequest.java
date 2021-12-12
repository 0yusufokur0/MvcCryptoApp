package com.example.myapplication.manager.api;

import com.example.myapplication.constant.ApiMethod;

public abstract class ApiRequest {
    private transient Object mSender;
    private transient boolean mIsShowProgressAllowed;

    public boolean isShowProgressAllowed() {
        return mIsShowProgressAllowed;
    }

    public void setShowProgressAllowed(boolean showProgressAllowed) {
        mIsShowProgressAllowed = showProgressAllowed;
    }

    public Object getSender() {
        return mSender;
    }

    public void setSender(Object sender) {
        mSender = sender;
    }

    public ApiMethod getApiMethod() {
        for (ApiMethod method : ApiMethod.values()) {
            if (this.getClass() == method.getRequestClass()) {
                return method;
            }
        }
        throw new RuntimeException("Bu request modeli ApiMethod'da tanımlanmamış");
    }
}
