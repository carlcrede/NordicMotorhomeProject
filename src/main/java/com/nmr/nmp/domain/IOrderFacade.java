package com.nmr.nmp.domain;

import com.nmr.nmp.domain.models.Order;

import java.util.ArrayList;

public interface IOrderFacade {
    void create(Order order);
    ArrayList<Order> read();
}
