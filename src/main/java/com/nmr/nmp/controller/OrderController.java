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
    public String create(HttpServletRequest request, Model model) {
        String firstname = request.getParameter("order.getCustomer().get");
        String lastname = request.getParameter("order.customer.lastname");
        String phone = request.getParameter("order.customer.phone");
        String email = request.getParameter("order.customer.email");
        String orderDate = request.getParameter("order.orderDate");
        String startDate = request.getParameter("order.startDate");
        String returnDate = request.getParameter("order.returnDate");
        String status = request.getParameter("order.status");

        Customer customer = new Customer(firstname, lastname, phone, email);
        Order order = new Order(orderDate, startDate, returnDate, status, customer);
        controller.create(order);
        return "redirect:/order";
    }

}
