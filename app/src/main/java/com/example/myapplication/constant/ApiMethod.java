package com.example.myapplication.constant;

import com.android.volley.Request;
import com.example.myapplication.manager.api.ContentType;
import com.example.myapplication.manager.api.RequestType;
import com.example.myapplication.manager.api.ResponseFormat;
import com.example.myapplication.model.request.GetCryptoStockRequest;
import com.example.myapplication.model.response.GetCryptoStockResponse;

public enum ApiMethod {


    GET_CRYPTO_STOCK("", GetCryptoStockRequest.class, GetCryptoStockResponse.class, Request.Method.GET, RequestType.QUERY);

    private final String mMethodName;
    private final Class<?> mRequestClass;
    private RequestType mRequestType = ProjectSettings.API_DEFAULT_REQUEST_TYPE;
    private boolean mIsShowErrorResponseMessage = ProjectSettings.API_DEFAULT_SHOW_ERROR_RESPONSE_MESSAGE;
    private int mMethodType = ProjectSettings.API_DEFAULT_METHOD_TYPE;
    private final Class<?> mResponseClass;
    private final ResponseFormat mResponseFormat = ProjectSettings.API_DEFAULT_RESPONSE_FORMAT;
    private ContentType mContentType = ProjectSettings.API_DEFAULT_CONTENT_TYPE;

    ApiMethod(String methodName, Class<?> requestClass, Class<?> responseClass) {
        mMethodName = methodName;
        mRequestClass = requestClass;
        mResponseClass = responseClass;
    }

    ApiMethod(String methodName, Class<?> requestClass, Class<?> responseClass, int methodType) {
        mMethodName = methodName;
        mRequestClass = requestClass;
        mResponseClass = responseClass;
        mMethodType = methodType;
    }

    ApiMethod(String methodName, Class<?> requestClass, Class<?> responseClass, int methodType, RequestType requestType) {
        mMethodName = methodName;
        mRequestClass = requestClass;
        mResponseClass = responseClass;
        mMethodType = methodType;
        mRequestType = requestType;
    }

    ApiMethod(String methodName, Class<?> requestClass, Class<?> responseClass, ContentType contentType, RequestType requestType) {
        mMethodName = methodName;
        mRequestClass = requestClass;
        mResponseClass = responseClass;
        mContentType = contentType;
        mRequestType = requestType;
    }

    ApiMethod(String methodName, Class<?> requestClass, Class<?> responseClass, int methodType, RequestType requestType, boolean isShowErrorResponseMessage) {
        mMethodName = methodName;
        mRequestClass = requestClass;
        mResponseClass = responseClass;
        mMethodType = methodType;
        mRequestType = requestType;
        mIsShowErrorResponseMessage = isShowErrorResponseMessage;
    }

    ApiMethod(String methodName, Class<?> requestClass, Class<?> responseClass, int methodType, RequestType requestType, int errorResponseMessageDuration) {
        mMethodName = methodName;
        mRequestClass = requestClass;
        mResponseClass = responseClass;
        mMethodType = methodType;
        mRequestType = requestType;

    }

    ApiMethod(String methodName, Class<?> requestClass, Class<?> responseClass, boolean isShowErrorResponseMessage, boolean isShowsMessageByToast) {
        mMethodName = methodName;
        mRequestClass = requestClass;
        mResponseClass = responseClass;
        mIsShowErrorResponseMessage = isShowErrorResponseMessage;

    }

    public Class<?> getRequestClass() {
        return mRequestClass;
    }

    public RequestType getRequestType() {
        return mRequestType;
    }

    public boolean isShowErrorResponseMessage() {
        return mIsShowErrorResponseMessage;
    }

    public int getMethodType() {
        return mMethodType;
    }

    public Class<?> getResponseClass() {
        return mResponseClass;
    }

    public String getUrl() {
        if (mMethodName.startsWith("http")) {
            return mMethodName;
        }
        String baseUrl = ProjectSettings.getApiBaseUrl();
        if (!baseUrl.endsWith("/")) {
            baseUrl = baseUrl + "/";
        }
        return baseUrl + mMethodName;
    }

    public ResponseFormat getResponseFormat() {
        return mResponseFormat;
    }

    public ContentType getContentType() {
        return mContentType;
    }
}
