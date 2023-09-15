package com.polije.sem3.data.model;

public class ItemMahasiswa {

    private String nama;
    private String npm;
    private String nohp;

    public ItemMahasiswa(String nama, String npm, String nohp){
        setNama(nama);
        setNpm(npm);
        setNohp(nohp);
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNpm() {
        return npm;
    }

    public void setNpm(String npm) {
        this.npm = npm;
    }

    public String getNohp() {
        return nohp;
    }

    public void setNohp(String nohp) {
        this.nohp = nohp;
    }

}
