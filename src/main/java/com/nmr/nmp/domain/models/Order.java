package com.nmr.nmp.domain.models;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Order {
    private ArrayList<OrderLine> orderLines;
    private Customer customer;
    private int id;
    private int customerId;
    private String startDate, returnDate, status;
    private LocalDateTime orderDate;


    public Order(){

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

    public ArrayList<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(ArrayList<OrderLine> orderLines) {
        this.orderLines = orderLines;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Order(int orderId, int customerId, LocalDateTime orderDate, String startDate, String returnDate, String status) {
        this.id = orderId;
        this.customerId = customerId;
        this.orderDate = orderDate;
        this.startDate = startDate;
        this.returnDate = returnDate;
        this.status = status;
    }

    public Order(LocalDateTime orderDate, String startDate, String returnDate, String status, Customer customer) {
        this.orderDate = orderDate;
        this.startDate = startDate;
        this.returnDate = returnDate;
        this.status = status;
        this.customer = customer;
    }

    public Order(int customerId, String startDate, String returnDate, String status){
        this.customerId = customerId;
        this.startDate = startDate;
        this.returnDate = returnDate;
        this.status = status;
    }
}
