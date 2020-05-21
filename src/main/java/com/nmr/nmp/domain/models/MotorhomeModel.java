package com.nmr.nmp.domain.models;

public class MotorhomeModel extends Product {

    private String model, brand;

    public MotorhomeModel(int id, String brand, String model) {
        super(id);
        this.brand = brand;
        this.model = model;
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
}
