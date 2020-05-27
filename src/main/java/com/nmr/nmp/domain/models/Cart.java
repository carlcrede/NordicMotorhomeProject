package com.nmr.nmp.domain.models;

import java.util.ArrayList;

public class Cart {

    ArrayList<Integer> products = new ArrayList<>();

    public Cart(){
    }

    public Cart(ArrayList<Integer> products) {
        this.products = products;
    }

    public ArrayList<Integer> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Integer> products) {
        this.products = products;
    }

}
