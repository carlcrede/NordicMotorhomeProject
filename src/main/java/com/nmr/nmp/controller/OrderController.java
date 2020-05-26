package com.nmr.nmp.controller;

import com.nmr.nmp.data.implementations.CustomerFacadeImpl;
import com.nmr.nmp.data.implementations.MotorhomeFacadeImpl;
import com.nmr.nmp.data.implementations.OrderFacadeImpl;
import com.nmr.nmp.domain.models.Customer;
import com.nmr.nmp.domain.models.Order;
import com.nmr.nmp.domain.models.OrderLine;
import com.nmr.nmp.domain.uccontrollers.CustomerUC;
import com.nmr.nmp.domain.uccontrollers.MotorhomeUC;
import com.nmr.nmp.domain.uccontrollers.OrderUC;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Controller
public class OrderController {

    OrderUC orderController = new OrderUC(new OrderFacadeImpl());
    CustomerUC customerController = new CustomerUC(new CustomerFacadeImpl());
    MotorhomeUC motorhomeController = new MotorhomeUC(new MotorhomeFacadeImpl());

    @GetMapping("/order")
    public String index(Model model) {
        model.addAttribute("orders", orderController.read());
        return "/order/index";
    }

    @GetMapping("/order/create")
    public String create(Model model) {
        model.addAttribute("customers", customerController.read());
        return "order/create";
    }

    @GetMapping("/order/createCustomer")
    public String createCustomer(Model model){
        model.addAttribute("customer", new Customer());
        return "/order/createCustomer";
    }

    @PostMapping("/order/createCustomer")
    public String createCustomer(HttpServletRequest request){
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        Customer customer = new Customer(firstname, lastname, phone, email);
        customerController.create(customer);
        ArrayList<Customer> customers = customerController.read();
        int customerId = customers.get(customers.size() - 1).getId();
        return "redirect:/order/createOrder" + "?id=" + customerId;
    }

    @GetMapping("/order/createOrder")
    public String createOrder(Model model, @RequestParam("id") int customerId){
        model.addAttribute("order", new Order(customerId));
        return "/order/createOrder";
    }

    @PostMapping("/order/createOrder")
    public String createOrder(HttpServletRequest request){
        String customerId = request.getParameter("customerId");
        String startDate = request.getParameter("startDate");
        String returnDate = request.getParameter("returnDate");
        String status = request.getParameter("status");
        Order order = new Order(Integer.parseInt(customerId), startDate, returnDate, status);
        orderController.create(order);
        ArrayList<Order> orders = orderController.read();
        int orderId = orders.get(orders.size() - 1).getId();
        return "redirect:/order/productselection" + "?id=" + orderId;
    }

    @GetMapping("/order/productselection")
    public String productselection(Model model, @RequestParam("id") int id){
        model.addAttribute("orderlines", new ArrayList<OrderLine>());
        model.addAttribute("motorhomes", motorhomeController.read());
        return "/order/productselection";
    }

//    @PostMapping("/order/productselection/")
//    public String productselection(HttpServletRequest request){
//        request.getParameterMap("productId", quantity);
//    }

//    @GetMapping("/order/delete")
//    public String deleteOrder(Model model, @RequestParam("id") int id){
//        model.addAttribute(orderController.read(id));
//        return "/order/delete";
//    }


}
