package com.nmr.nmp.domain;

public class Motorhome {

    private int id;
    private String model, brand;

    public Motorhome(int id, String model, String brand) {
        this.id = id;
        this.model = model;
        this.brand = brand;
    }

    public Motorhome(String model, String brand) {
        this.model = model;
        this.brand = brand;
    }

    public Motorhome() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
