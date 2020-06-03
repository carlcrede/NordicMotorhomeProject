/* Author: Philip Bretlau Specht, Jannick Lücking Espersen */

package com.nmr.nmp.domain.models;

public class Extra extends DomainEntity{

    private String type;
    private int price;
    private String brand;
    private String model;
    private int stock;

    public Extra(){
        super();
    }

    public Extra(int id, String type, int price, String brand, String model, int stock) {
        super(id);
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
