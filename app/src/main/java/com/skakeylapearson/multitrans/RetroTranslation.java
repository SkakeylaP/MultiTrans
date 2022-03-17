package com.skakeylapearson.multitrans;

import com.google.gson.annotations.SerializedName;

public class RetroTranslation {
    @SerializedName("translatedText")
    private String translatedText;
    @SerializedName("url")
    private String url;

    public RetroTranslation(String translatedText, String url) {
        this.translatedText = translatedText;
        this.url = url;
    }
    public String getTranslatedText() { return translatedText; }
    public String getUrl() { return url; }

    public void setTranslatedText(String translatedText) { this.translatedText = translatedText; }
    public void setUrl(String url) { this.url = url; }
}
