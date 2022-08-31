package com.gs.poi.pojo;

public class DetailUrlInfo {

    private int type;
    private String originalUrl;
    private String url;
    public void setType(int type) {
        this.type = type;
    }
    public int getType() {
        return type;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }
    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    public String getUrl() {
        return url;
    }

}