package com.nmr.nmp.domain.models;

public class Extra {

    private int product_id;
    private String type;
    private int price;
    private String brand;
    private String model;
    private int stock;

    public Extra(){
    }

    public Extra(int product_id, String type, int price, String brand, String model, int stock) {
        this.product_id = product_id;
        this.type = type;
        this.price = price;
        this.brand = brand;
        this.model = model;
        this.stock = stock;
    }

    public Extra(String type, int price, String brand, String model, int stock) {
        this.type = type;
        this.price = price;
        this.brand = brand;
        this.model = model;
        this.stock = stock;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

}
