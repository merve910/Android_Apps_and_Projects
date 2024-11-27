package com.deneme.Urlshorten;

public class shortenRequest {

    private String long_url;

    public shortenRequest(String longUrl) {
        this.long_url = longUrl;
    }

    public String getLongUrl() {
        return long_url;
    }

    public void setLongUrl(String longUrl) {
        this.long_url = longUrl;
    }
}
