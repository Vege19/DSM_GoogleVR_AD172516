package com.example.dsm_complementario4_ad172516.Models;

import java.io.Serializable;

public class Image implements Serializable {

    private int id;
    private int image;

    public Image(int id, int image) {
        this.id = id;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
