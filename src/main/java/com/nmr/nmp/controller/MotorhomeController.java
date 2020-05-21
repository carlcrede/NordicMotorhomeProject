package com.nmr.nmp.controller;

import com.nmr.nmp.data.DataFacadeMotorhomeImplementation;
import com.nmr.nmp.domain.models.Motorhome;
import com.nmr.nmp.domain.uccontrollers.MotorhomeUC;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MotorhomeController {

    MotorhomeUC controller = new MotorhomeUC(new DataFacadeMotorhomeImplementation());

    @GetMapping("/motorhome")
    public String index(Model model) {
        model.addAttribute("motorhomes", controller.read());
        return "/motorhome/index";
    }

    @GetMapping("/motorhome/create")
    public String create(Model model) {
        model.addAttribute("motorhome", new Motorhome());
        return "/motorhome/create";
    }

    @PostMapping("/motorhome/create")
    public String create(HttpServletRequest request) {
        String model = request.getParameter("model");
        String brand = request.getParameter("brand");
        Motorhome motorhome = new Motorhome(model, brand);
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
        String id  = request.getParameter("id");
        String brand = request.getParameter("brand");
        String model = request.getParameter("model");
        Motorhome motorhome = new Motorhome(Integer.parseInt(id), brand, model);
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
