package com.nmr.nmp.controller;

import org.springframework.stereotype.Controller;

@Controller
public class OrderController {

//    OrderUC orderController = new OrderUC(new OrderFacadeImpl());
//    CustomerUC customerController = new CustomerUC(new CustomerFacadeImpl());
//    MotorhomeUC motorhomeController = new MotorhomeUC(new MotorhomeFacadeImpl());
//
//    @GetMapping("/order")
//    public String index(Model model) {
//        model.addAttribute("orders", orderController.read());
//        return "/order/index";
//    }
//
//    @GetMapping("/order/create")
//    public String create(Model model) {
//        model.addAttribute("customers", customerController.read());
//        return "order/create";
//    }
//
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
//        ArrayList<Customer> customers = customerController.read();
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
//        orderController.create(order);
//        return "redirect:/order/productselection";
//    }
//
//    @GetMapping("/order/productselection")
//    public String productselection(Model model){
//        model.addAttribute("orderlines", new ArrayList<OrderLine>());
//        model.addAttribute("motorhomes", motorhomeController.read());
//        return "/order/productselection";
//    }
//
////    @PostMapping("/order/productselection/")
////    public String productselection(HttpServletRequest request){
////        request.getParameterMap("productId", quantity);
////    }
//
////    @GetMapping("/order/delete")
////    public String deleteOrder(Model model, @RequestParam("id") int id){
////        model.addAttribute(orderController.read(id));
////        return "/order/delete";
////    }


}
