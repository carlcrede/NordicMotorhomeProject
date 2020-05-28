package com.nmr.nmp.domain.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Cart {

    ArrayList<Integer> products = new ArrayList<>();

    public Cart(){
    }

    public ArrayList<Integer> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Integer> products) {
        this.products = products;
    }

}
