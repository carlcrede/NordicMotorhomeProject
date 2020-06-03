/* Author: Jannick Lücking Espersen */

package com.nmr.nmp.domain.models;

public class Orderline extends DomainEntity{

    private int orderId;
    private int productId;

    public Orderline(){}

    public Orderline(int productId){
        this.productId = productId;
    }

    public Orderline(int orderId, int productId) {
        this.orderId = orderId;
        this.productId = productId;
    }

    public Orderline(int id, int orderId, int productId) {
        super(id);
        this.orderId = orderId;
        this.productId = productId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

}
