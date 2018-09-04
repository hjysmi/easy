package com.easydeliver.ink.app.ui.mefragment;

public class MeText extends MeHeader {
    Integer img;
    Integer int_text;
    public MeText(Integer img, Integer int_text) {
        this.img = img;
        this.int_text = int_text;
    }

    public Integer getImg() {
        return img;
    }

    public void setImg(Integer img) {
        this.img = img;
    }

    public Integer getInt_text() {
        return int_text;
    }

    public void setInt_text(Integer int_text) {
        this.int_text = int_text;
    }
}
