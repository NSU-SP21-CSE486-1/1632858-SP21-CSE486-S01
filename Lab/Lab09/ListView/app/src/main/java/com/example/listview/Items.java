package com.example.listview;

public class Items {
    private String name;
    private int price;
    private final int thumbnail;
    private final int image;

    public Items(String name, int price, int thumbnail, int image) {
        this.name = name;
        this.price = price;
        this.thumbnail = thumbnail;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public int getImage() {
        return image;
    }
}
