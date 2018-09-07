package com.easydeliver.ink.app.main;

public class MainNew  {
    private String uri;
    private String name;

    public MainNew() {
    }

    public MainNew(String uri, String name) {
        this.uri = uri;
        this.name = name;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
