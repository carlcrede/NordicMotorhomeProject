package com.nmr.nmp.domain.models;

public class Orderline extends DomainEntity{

    private int orderId;
    private int productId;
    private int quantity;

    public Orderline(){}

    public Orderline(int productId){
        this.productId = productId;
    }

    public Orderline(int productId, int quantity){
        this.productId = productId;
        this.quantity = quantity;
    }

    public Orderline(int orderId, int productId, int quantity) {
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
    }

    public Orderline(int id, int orderId, int productId, int quantity) {
        super(id);
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
