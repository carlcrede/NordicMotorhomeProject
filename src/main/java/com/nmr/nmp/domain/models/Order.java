package com.nmr.nmp.domain.models;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Order extends DomainEntity {

    private int customerId;
    private Customer customer;
    private String startDate, returnDate, status;
    private LocalDateTime orderDate;
    private ArrayList<Orderline> orderlines = new ArrayList<Orderline>();

    public Order(){
    }

    public Order(int orderId, int customerId, LocalDateTime orderDate, String startDate, String returnDate, String status) {
        super(orderId);
        this.customerId = customerId;
        this.orderDate = orderDate;
        this.startDate = startDate;
        this.returnDate = returnDate;
        this.status = status;
    }

    public Order(int customerId, String startDate, String returnDate, String status){
        this.customerId = customerId;
        this.startDate = startDate;
        this.returnDate = returnDate;
        this.status = status;
    }

    public Order(int customerId) {
        this.customerId = customerId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setOrderlines(ArrayList<Orderline> orderlines) {
        this.orderlines = orderlines;
    }
}
