package com.nmr.nmp.controller;

import com.nmr.nmp.data.implementations.DataFacadeImpl;
import com.nmr.nmp.data.mappers.MotorhomeMapper;
import com.nmr.nmp.domain.models.Motorhome;
import com.nmr.nmp.domain.uccontrollers.ProductUC;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MotorhomeController {

    ProductUC controller = new ProductUC(new DataFacadeImpl(new MotorhomeMapper()));

    @GetMapping("/motorhome")
    public String index(Model model) {
        model.addAttribute("motorhomes", controller.readAll());
        return "/motorhome/index";
    }

    @GetMapping("/motorhome/create")
    public String create(Model model) {
        model.addAttribute("motorhome", new Motorhome());
        return "/motorhome/create";
    }

    @PostMapping("/motorhome/create")
    public String create(HttpServletRequest request) {
        String type = request.getParameter("type");
        int price = Integer.parseInt(request.getParameter("price"));
        String model = request.getParameter("model");
        String brand = request.getParameter("brand");
        String status = request.getParameter("status");
        Motorhome motorhome = new Motorhome(type, price, model, brand, status);
        controller.create(motorhome);
        return "redirect:/motorhome";
    }

    @GetMapping("/motorhome/details")
    public String details(@RequestParam("id") int id, Model model) {
        model.addAttribute("motorhome", controller.read(id));
        return "/motorhome/details";
    }

    @GetMapping("/motorhome/edit")
    public String edit(@RequestParam("id") int id, Model model) {
        model.addAttribute("motorhome", controller.read(id));
        return "/motorhome/edit";
    }

    @PostMapping("/motorhome/edit")
    public String update(HttpServletRequest request) {
        int id  = Integer.parseInt(request.getParameter("id"));
        String type = request.getParameter("type");
        int price = Integer.parseInt(request.getParameter("price"));
        String brand = request.getParameter("brand");
        String model = request.getParameter("model");
        String status = request.getParameter("status");
        Motorhome motorhome = new Motorhome(id, type, price, brand, model, status);
        controller.update(motorhome);
        return "redirect:/motorhome";
    }

    @PostMapping("/motorhome/delete")
    public String delete(HttpServletRequest request) {
        String id = request.getParameter("id");
        controller.delete(Integer.parseInt(id));
        return "redirect:/motorhome";
    }

    @GetMapping("/motorhome/delete")
    public String delete(@RequestParam("id") int id, Model model) {
        model.addAttribute("motorhome", controller.read(id));
        return "/motorhome/delete";
    }

}
