package com.nmr.nmp.data;

import com.nmr.nmp.domain.IDataFacade;
import com.nmr.nmp.domain.IOrderFacade;
import com.nmr.nmp.domain.models.Order;

import java.util.ArrayList;

public class OrderFacadeImpl implements IDataFacade<Order> {

    private OrderMapper orderMapper = new OrderMapper();

    @Override
    public void create(Order order) {
        orderMapper.create(order);
    }


    @Override
    public ArrayList<Order> read() {
        return orderMapper.read();
    }

    @Override
    public Order read(int id) {
        return orderMapper.read(id);
    }

    @Override
    public void update(Order order) {
        orderMapper.update(order);
    }

    @Override
    public void delete(int id) {
        orderMapper.delete(id);
    }

}
