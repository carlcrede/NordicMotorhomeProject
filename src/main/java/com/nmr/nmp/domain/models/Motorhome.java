/* Author: Carl Christian Hasselbalch */

package com.nmr.nmp.domain.models;

public class Motorhome extends DomainEntity{
    private int price;
    private String type;
    private String brand;
    private String model;
    private String status;

    public Motorhome() {
        super();
    }

    public Motorhome(String type, int price, String brand, String model) {
        this.type = type;
        this.price = price;
        this.model = model;
        this.brand = brand;
    }

    public Motorhome(int id, String type, int price, String brand, String model, String status) {
        super(id);
        this.type = type;
        this.price = price;
        this.model = model;
        this.brand = brand;
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
