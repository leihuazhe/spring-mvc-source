package com.maple.mvc.controller.vo;

public class AppRequest {
    private String appSecret;
    private String appId;

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    @Override
    public String toString() {
        return "AppRequest{" +
                "appSecret='" + appSecret + '\'' +
                ", appId='" + appId + '\'' +
                '}';
    }
}
