package com.polije.sem3.data.model;

public class ItemTugasModel {

    private String namaTugas;
    private Listener listener;

    public ItemTugasModel(String namaTugas, Listener listener){
        setNamaTugas(namaTugas);
        setListener(listener);
    }

    public String getNamaTugas() {
        return namaTugas;
    }

    public void setNamaTugas(String namaTugas) {
        this.namaTugas = namaTugas;
    }

    public Listener getListener() {
        return listener;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public interface Listener{
        void onItemClicked();
    }
}
