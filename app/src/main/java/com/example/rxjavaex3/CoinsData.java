package com.example.rxjavaex3;

public class CoinsData {

    private String name;
    private String coinImage;
    private double price;


    public CoinsData(String name, String coinImage, double price) {
        this.name = name;
        this.coinImage = coinImage;
        this.price = price;
    }

    public CoinsData() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCoinImage() {
        return coinImage;
    }

    public void setCoinImage(String coinImage) {
        this.coinImage = coinImage;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
