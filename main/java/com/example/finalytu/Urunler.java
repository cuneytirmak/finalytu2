package com.example.finalytu;

import java.io.Serializable;

public class Urunler implements Serializable {
    private static final long serialVersionUID = 1L;


    private String name;
    private String amount;
    private String price;

    public Urunler(String name, String amount, String price) {
        this.name = name;
        this.amount = amount;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }




    @Override
    public String toString() {
        return "Urunler{" +
                "name='" + name + '\'' +
                ", amount='" + amount + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
