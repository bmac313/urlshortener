package com.github.urlshortener.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class UrlManager {

    /*
     *  ** URL Manager **
     *  This class holds information about short URLs and their corresponding long URLs.
     */

    @Id
    @GeneratedValue
    private int id;

    // This field holds the string that will be used as part of the short URL.
    // e.g.: [domain]/SomeString
    @NotNull
    @Size(min = 1, max = 255)
    private String shortUrlCode = "";

    // This field holds the long URL that the short URL will redirect to.
    @NotNull
    @Size(min = 1, max = 10000)
    private String longURL = "";

    public UrlManager() {}

    public UrlManager(String shortUrlCode, String longURL) {
        this.shortUrlCode = shortUrlCode;
        this.longURL = longURL;
    }

    public String getShortUrlCode() {
        return shortUrlCode;
    }

    public void setShortUrlCode(String shortUrlCode) {
        this.shortUrlCode = shortUrlCode;
    }

    public String getLongURL() {
        return longURL;
    }

    public void setLongURL(String longURL) {
        this.longURL = longURL;
    }
}
