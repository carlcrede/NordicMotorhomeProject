package com.nmr.nmp.domain.uccontrollers;

import com.nmr.nmp.domain.IDataFacade;
import com.nmr.nmp.domain.models.Order;

import java.util.ArrayList;

public class OrderUC {

    private IDataFacade<Order> dataFacade;

    public OrderUC(IDataFacade<Order> dataFacade) { this.dataFacade = dataFacade; }

    public void create(Order order) {
        dataFacade.create(order);
    }

    public Order read(int id) {
        return dataFacade.read(id);
    }

    public ArrayList<Order> read() {
        return dataFacade.read();
    }

    public void update(Order order) {
        dataFacade.update(order);
    }

    public void delete(int id) {
        dataFacade.delete(id);
    }
}