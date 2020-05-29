package com.nmr.nmp.domain.models;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class OrderTest {

    Order order;

    @BeforeAll
    void init(){
        order = new Order();
    }

    @Test
    void addOrderlineTest(){
        int expected = 1;

        order.addOrderline(new Orderline());
        ArrayList<Orderline> orderlines = order.getOrderlines();

        assertEquals(1, orderlines.size());

    }

}