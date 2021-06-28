package com.example.finalytu;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Alisveris implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private String market;
    private String tarih;
    private boolean tamamlandi;
    private ArrayList<Urunler> liste;



    public Alisveris(String name, String market, String tarih, ArrayList<Urunler> liste, boolean tamamlandi) {
        this.name = name;
        this.market = market;
        this.tarih = tarih;
        this.tamamlandi = tamamlandi;
        this.liste = liste;

    }

    @Override
    public String toString() {
        return "Alisveris{" +
                "name='" + name + '\'' +
                ", market='" + market + '\'' +
                ", tarih='" + tarih + '\'' +
                ", tamamlandi=" + tamamlandi +
                ", liste=" + liste +
                '}';
    }

    public ArrayList<Urunler> getListe() {
        return liste;
    }

    public void setListe(ArrayList<Urunler> liste) {
        this.liste = liste;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }


    public boolean isTamamlandi() {
        return tamamlandi;
    }

    public void setTamamlandi(boolean tamamlandi) {
        this.tamamlandi = tamamlandi;
    }



}
