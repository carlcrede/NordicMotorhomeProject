package com.nmr.nmp.controller;

import com.nmr.nmp.data.implementations.DataFacadeImpl;
import com.nmr.nmp.data.mappers.CustomerMapper;
import com.nmr.nmp.data.mappers.ExtraMapper;
import com.nmr.nmp.data.mappers.MotorhomeMapper;
import com.nmr.nmp.data.mappers.OrderMapper;
import com.nmr.nmp.domain.models.*;
import com.nmr.nmp.domain.uccontrollers.CustomerUC;
import com.nmr.nmp.domain.uccontrollers.OrderUC;
import com.nmr.nmp.domain.uccontrollers.ProductUC;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Controller
public class OrderController {

    OrderUC controller = new OrderUC(new DataFacadeImpl(new OrderMapper()));
    CustomerUC customerController = new CustomerUC(new DataFacadeImpl(new CustomerMapper()));
    ProductUC motorhomeController = new ProductUC(new DataFacadeImpl(new MotorhomeMapper()));
    ProductUC extraController = new ProductUC(new DataFacadeImpl(new ExtraMapper()));

    @GetMapping("/order")
    public String index(Model model) {
        model.addAttribute("orders", controller.readAll());
        return "/order/index";
    }

    @GetMapping("/order/new")
    public String create(Model model) {
//        model.addAttribute("order", new Order());
//        model.addAttribute("product_id", new String());
        model.addAttribute("orderline", new Orderline());
        model.addAttribute("orderlineslist", new ArrayList<Orderline>());
        model.addAttribute("motor", new Motorhome());
        model.addAttribute("motorhomes", motorhomeController.readAvailable());
//        model.addAttribute("singleextra", new Extra());
////        model.addAttribute("extras", extraController.readAvailable());

//        model.addAttribute("extras", extraController.readAvailable());
        return "order/new";
    }

    @PostMapping("/order/new")
    public String create(@ModelAttribute("motorhome") Motorhome motorhome){
        ArrayList<Orderline> orderlineslist = new ArrayList();
        Orderline orderline = new Orderline();
        orderline.setProductId(motorhome.getId());
        orderlineslist.add(orderline);
        Order order = new Order();
        order.setOrderlines(orderlineslist);
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
