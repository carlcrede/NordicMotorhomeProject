package com.nmr.nmp.data;

import com.nmr.nmp.domain.IOrderFacade;
import com.nmr.nmp.domain.models.Order;

import java.util.ArrayList;

public class OrderFacadeImpl implements IOrderFacade {

    private OrderMapper orderMapper = new OrderMapper();

    @Override
    public void create(Order order) {
        orderMapper.create(order);
    }

    @Override
    public ArrayList<Order> read() {
        return orderMapper.read();
    }


}
