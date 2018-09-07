package com.easydeliver.ink.app.main;

public class MainTitle {
    private Integer int_txt;

    public MainTitle() {
    }

    public MainTitle(Integer int_txt) {
        this.int_txt = int_txt;
    }

    public Integer getInt_txt() {
        return int_txt;
    }

    public void setInt_txt(Integer int_txt) {
        this.int_txt = int_txt;
    }

    @Override
    public String toString() {
        return "MainTitle{" +
                "int_txt=" + int_txt +
                '}';
    }
}
