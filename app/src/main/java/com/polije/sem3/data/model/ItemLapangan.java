package com.polije.sem3.data.model;

import androidx.annotation.DrawableRes;

public class ItemLapangan {

    private final String nama;
    private final int imgLapangan;

    public ItemLapangan(String nama, @DrawableRes int imgLapangan){
        this.nama = nama;
        this.imgLapangan = imgLapangan;
    }

    public String getNama() {
        return nama;
    }

    @DrawableRes
    public int getImgLapangan() {
        return imgLapangan;
    }


}
