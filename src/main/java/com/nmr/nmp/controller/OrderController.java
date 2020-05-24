package com.nmr.nmp.controller;

import com.nmr.nmp.data.OrderFacadeImpl;
import com.nmr.nmp.domain.models.Customer;
import com.nmr.nmp.domain.models.Order;
import com.nmr.nmp.domain.uccontrollers.OrderUC;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class OrderController {

    OrderUC controller = new OrderUC(new OrderFacadeImpl());

    @GetMapping("/order")
    public String index(Model model) {
        model.addAttribute("orders", controller.read());
        return "/order/index";
    }

    @GetMapping("/order/create")
    public String create(Model model) {
        model.addAttribute("order", new Order());
        return "/order/create";
    }

    @PostMapping("/order/create")
    public String create(HttpServletRequest request) {
        String firstname = request.getParameter("customer.firstname");
        String lastname = request.getParameter("customer.lastname");
        String phone = request.getParameter("customer.phone");
        String email = request.getParameter("customer.email");
        String orderDate = request.getParameter("orderDate");
        String startDate = request.getParameter("startDate");
        String returnDate = request.getParameter("returnDate");
        String status = request.getParameter("status");

        Customer customer = new Customer(firstname, lastname, phone, email);
        Order order = new Order(orderDate, startDate, returnDate, status, customer);
        controller.create(order);
        return "redirect:/order";
    }

}
