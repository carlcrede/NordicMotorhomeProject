package com.nmr.nmp.domain.uccontrollers;

import com.nmr.nmp.domain.IOrderFacade;
import com.nmr.nmp.domain.models.Order;

import java.util.ArrayList;

public class OrderUC {

    private IOrderFacade orderFacade;
    public OrderUC (IOrderFacade orderFacade) {
        this.orderFacade = orderFacade;
    }

    public void create(Order order) {
        orderFacade.create(order);
    }

    public ArrayList<Order> read() {
        return orderFacade.read();
    }
}
