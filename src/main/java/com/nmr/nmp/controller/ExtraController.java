package com.nmr.nmp.controller;

import com.nmr.nmp.data.implementations.DataFacadeImpl;
import com.nmr.nmp.data.mappers.ExtraMapper;
import com.nmr.nmp.domain.models.Extra;
import com.nmr.nmp.domain.uccontrollers.ProductUC;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ExtraController {

    ProductUC controller = new ProductUC(new DataFacadeImpl(new ExtraMapper()));

    @GetMapping("/extra")
    public String index(Model model) {
        model.addAttribute("extras", controller.readAll());
        return "/extra/index";
    }

    @GetMapping("/extra/create")
    public String create(Model model) {
        model.addAttribute("extra", new Extra());
        return "/extra/create";
    }

    @PostMapping("/extra/create")
    public String create(HttpServletRequest request) {
        String type = request.getParameter("type");
        int price = Integer.parseInt(request.getParameter("price"));
        String model = request.getParameter("model");
        String brand = request.getParameter("brand");
        int stock = Integer.parseInt(request.getParameter("stock"));
        Extra extra = new Extra(type, price, model, brand, stock);
        controller.create(extra);
        return "redirect:/extra";
    }

    @GetMapping("/extra/details")
    public String details(@RequestParam("id") int id, Model model) {
        model.addAttribute("extra", controller.read(id));
        return "/extra/details";
    }

    @GetMapping("/extra/edit")
    public String edit(@RequestParam("id") int id, Model model) {
        model.addAttribute("extra", controller.read(id));
        return "/extra/edit";
    }

    @PostMapping("/extra/edit")
    public String update(HttpServletRequest request) {
        int product_id  = Integer.parseInt(request.getParameter("product_id"));
        String type = request.getParameter("type");
        int price = Integer.parseInt(request.getParameter("price"));
        String brand = request.getParameter("brand");
        String model = request.getParameter("model");
        int stock  = Integer.parseInt(request.getParameter("stock"));
        Extra extra = new Extra(product_id, type, price, brand, model, stock);
        controller.update(extra);
        return "redirect:/extra";
    }

    @PostMapping("/extra/delete")
    public String delete(HttpServletRequest request) {
        String id = request.getParameter("product_id");
        controller.delete(Integer.parseInt(id));
        return "redirect:/extra";
    }

    @GetMapping("/extra/delete")
    public String delete(@RequestParam("product_id") int product_id, Model model) {
        model.addAttribute("extra", controller.read(product_id));
        return "/extra/delete";
    }

}
