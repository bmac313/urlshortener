package com.github.urlshortener.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Url {

    /*
     *  ** URL Manager **
     *  This class holds information about short URLs and their corresponding long URLs.
     */

    @Id
    @GeneratedValue
    private int id;

    // This field holds the long URL that the short URL will redirect to.
    @NotNull
    @Size(min = 1, max = 10000, message = "This field is required.")
    private String longUrl;

    // This field holds the string that will be used as part of the short URL.
    // e.g.: [domain]/SomeString
    @NotNull
    @Size(min = 1, max = 255, message = "This field is required.")
    private String shortUrlCode;

    public Url() {}

    public Url(String longUrl, String shortUrlCode) {
        this.longUrl = longUrl;
        this.shortUrlCode = shortUrlCode;
    }

    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }

    public String getShortUrlCode() {
        return shortUrlCode;
    }

    public void setShortUrlCode(String shortUrlCode) {
        this.shortUrlCode = shortUrlCode;
    }
}
