package com.nmr.nmp.controller;

import com.nmr.nmp.data.CustomerFacadeImpl;
import com.nmr.nmp.data.OrderFacadeImpl;
import com.nmr.nmp.domain.models.Customer;
import com.nmr.nmp.domain.models.Order;
import com.nmr.nmp.domain.uccontrollers.CustomerUC;
import com.nmr.nmp.domain.uccontrollers.OrderUC;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class OrderController {

    OrderUC controller = new OrderUC(new OrderFacadeImpl());
    CustomerUC customerController = new CustomerUC(new CustomerFacadeImpl());

    @GetMapping("/order")
    public String index(Model model) {
        model.addAttribute("orders", controller.read());
        return "/order/index";
    }

    @GetMapping("/order/create")
    public String create(Model model) {
        model.addAttribute("customers", customerController.read());
        return "order/create";
    }

    @GetMapping("/order/createOrder")
    public String createOrder(Model model, @RequestParam("id") int customerId){
        model.addAttribute("order", new Order(customerId));
        return "/order/createOrder";
    }

    @PostMapping("/order/createOrder")
    public String createOrder(HttpServletRequest request){
        String customerId = request.getParameter("customerId");
        String orderDate = request.getParameter("orderDate");
        String startDate = request.getParameter("startDate");
        String returnDate = request.getParameter("returnDate");
        String status = request.getParameter("status");
        Order order = new Order(Integer.parseInt(customerId), orderDate, startDate, returnDate, status);
        controller.create(order);
        return "redirect:/order";
    }

}
