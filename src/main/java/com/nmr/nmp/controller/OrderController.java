package com.nmr.nmp.controller;

import com.nmr.nmp.data.implementations.DataFacadeImpl;
import com.nmr.nmp.data.mappers.*;
import com.nmr.nmp.domain.models.*;
import com.nmr.nmp.domain.uccontrollers.CustomerUC;
import com.nmr.nmp.domain.uccontrollers.OrderUC;
import com.nmr.nmp.domain.uccontrollers.ProductUC;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class OrderController {

    OrderUC orderController = new OrderUC(new DataFacadeImpl(new OrderMapper()));
    OrderUC orderlineController = new OrderUC(new DataFacadeImpl(new OrderlineMapper()));
    ProductUC motorhomeController = new ProductUC(new DataFacadeImpl(new MotorhomeMapper()));
    ProductUC extraController = new ProductUC(new DataFacadeImpl(new ExtraMapper()));
    CustomerUC getCustomerController = new CustomerUC(new DataFacadeImpl(new CustomerMapper()));
    Order order;

    @GetMapping("/order")
    public String index(Model model) {
        order = new Order();
        model.addAttribute("orders", orderController.readAll());
        return "/order/index";
    }

    @GetMapping("/order/new")
    public String create(Model model) {
        model.addAttribute("cart", new Cart());
        model.addAttribute("allMotorhomes", motorhomeController.readAvailable());
        model.addAttribute("allExtras", extraController.readAvailable());
        return "order/new";
    }

    @PostMapping("/order/new")
    public String create(@ModelAttribute("cart") Cart cart){
        ArrayList<Integer> products = cart.getProducts();
        for(int i = 0; i < products.size(); i++){
            int product_id = products.get(i);
            order.addOrderline(new Orderline(product_id));
        }
        return "redirect:/order/pickcustomer";
    }

    @GetMapping("/order/pickcustomer")
    public String customer(Model model){
        model.addAttribute("customer", new Customer());
        model.addAttribute("allCustomers", getCustomerController.readAll());
        return "/order/pickcustomer";
    }

    @PostMapping("/order/pickcustomer")
    public String customer(@ModelAttribute("customer") Customer customer){
        order.setCustomerId(customer.getId());
        orderController.create(order);
        int order_id = orderController.readLastInsertID();
        ArrayList<Orderline> orderlines = order.getOrderlines();
        for(Orderline orderline : orderlines){
            orderline.setOrderId(order_id);
            orderlineController.create(orderline);
        }
        return "redirect:/order";
    }

//    @GetMapping("/order/createCustomer")
//    public String createCustomer(Model model){
//        model.addAttribute("customer", new Customer());
//        return "/order/createCustomer";
//    }
//
//    @PostMapping("/order/createCustomer")
//    public String createCustomer(HttpServletRequest request){
//        String firstname = request.getParameter("firstname");
//        String lastname = request.getParameter("lastname");
//        String phone = request.getParameter("phone");
//        String email = request.getParameter("email");
//        Customer customer = new Customer(firstname, lastname, phone, email);
//        customerController.create(customer);
//        ArrayList<DomainEntity> customers = customerController.readAll();
//        int customerId = customers.get(customers.size() - 1).getId();
//        return "redirect:/order/createOrder" + "?id=" + customerId;
//    }
//
//    @GetMapping("/order/createOrder")
//    public String createOrder(Model model, @RequestParam("id") int customerId){
//        model.addAttribute("order", new Order(customerId));
//        return "/order/createOrder";
//    }
//
//    @PostMapping("/order/createOrder")
//    public String createOrder(HttpServletRequest request){
//        String customerId = request.getParameter("customerId");
//        String startDate = request.getParameter("startDate");
//        String returnDate = request.getParameter("returnDate");
//        String status = request.getParameter("status");
//        Order order = new Order(Integer.parseInt(customerId), startDate, returnDate, status);
//        controller.create(order);
//        return "redirect:/order/productselection";
//    }
//
//    @GetMapping("/order/productselection")
//    public String productselection(Model model){
//        model.addAttribute("orderlines", new ArrayList<OrderLine>());
//        model.addAttribute("motorhomes", motorhomeController.readAvailable());
//        return "/order/productselection";
//    }

//    @PostMapping("/order/productselection/")
//    public String productselection(HttpServletRequest request){
//        request.getParameterMap("productId", quantity);
//    }
//
////    @GetMapping("/order/delete")
////    public String deleteOrder(Model model, @RequestParam("id") int id){
////        model.addAttribute(orderController.read(id));
////        return "/order/delete";
////    }


}
