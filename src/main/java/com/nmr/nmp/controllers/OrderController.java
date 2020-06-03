package com.nmr.nmp.controllers;

import com.nmr.nmp.data.implementations.DataFacadeImpl;
import com.nmr.nmp.data.mappers.*;
import com.nmr.nmp.domain.models.*;
import com.nmr.nmp.domain.handlers.CustomerHandler;
import com.nmr.nmp.domain.handlers.OrderHandler;
import com.nmr.nmp.domain.handlers.ProductHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Controller
public class OrderController {

    OrderHandler orderHandler = new OrderHandler(new DataFacadeImpl(new OrderMapper()));
    OrderHandler orderlineHandler = new OrderHandler(new DataFacadeImpl(new OrderlineMapper()));
    ProductHandler productHandler = new ProductHandler(new DataFacadeImpl(new MotorhomeMapper()));
    ProductHandler extraHandler = new ProductHandler(new DataFacadeImpl(new ExtraMapper()));
    CustomerHandler customerHandler = new CustomerHandler(new DataFacadeImpl(new CustomerMapper()));
    Order order;

    @GetMapping("/order")
    public String index(Model model) {
        order = new Order();
        model.addAttribute("orders", orderHandler.readAll());
        return "/order/index";
    }

    @GetMapping("/order/new")
    public String newOrder(Model model) {
        model.addAttribute("cart", new Cart());
        model.addAttribute("allMotorhomes", productHandler.readAvailable());
        model.addAttribute("allExtras", extraHandler.readAvailable());
        return "order/new";
    }

    @PostMapping("/order/new")
    public String newOrder(@ModelAttribute("cart") Cart cart){
        ArrayList<Integer> products = cart.getProducts();
        for(int i = 0; i < products.size(); i++){
            int product_id = products.get(i);
            order.addOrderline(new Orderline(product_id));
        }
        return "redirect:/order/pickcustomer";
    }

    @GetMapping("/order/pickcustomer")
    public String pickCustomer(Model model){
        model.addAttribute("customer", new Customer());
        model.addAttribute("allCustomers", customerHandler.readAll());
        return "/order/pickcustomer";
    }

    @PostMapping("/order/pickcustomer")
    public String pickCustomer(@ModelAttribute("customer") Customer customer){
        order.setCustomerId(customer.getId());
        orderHandler.create(order);
        int order_id = orderHandler.readLastInsertID();
        ArrayList<Orderline> orderlines = order.getOrderlines();
        for(Orderline orderline : orderlines){
            orderline.setOrderId(order_id);
            orderlineHandler.create(orderline);
        }
        return "redirect:/order";
    }

    @GetMapping("/order/createCustomer")
    public String createCustomer(Model model){
        model.addAttribute("customer", new Customer());
        return "/order/createCustomer";
    }

    @PostMapping("/order/createCustomer")
    public String createCustomer(@ModelAttribute("customer") Customer customer){
        customerHandler.create(customer);
        order.setCustomerId(customerHandler.readLastInsertID());
        orderHandler.create(order);
        int order_id = orderHandler.readLastInsertID();
        ArrayList<Orderline> orderlines = order.getOrderlines();
        for(Orderline orderline : orderlines){
            orderline.setOrderId(order_id);
            orderlineHandler.create(orderline);
        }
        return "redirect:/order";
    }

}
