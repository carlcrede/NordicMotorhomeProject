package com.nmr.nmp.controller;

import com.nmr.nmp.data.DataFacadeMotorhomeImplementation;
import com.nmr.nmp.domain.Motorhome;
import com.nmr.nmp.domain.uccontrollers.MotorhomeUC;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MotorhomeController {

    MotorhomeUC controller = new MotorhomeUC(new DataFacadeMotorhomeImplementation());

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("motorhome", new Motorhome());
        return "/Motorhome/create";
    }

    @PostMapping("/create")
    public String create(HttpServletRequest request) {
        String model = request.getParameter("model");
        String brand = request.getParameter("brand");
        Motorhome motorhome = new Motorhome(model, brand);
        controller.create(motorhome);
        return "redirect:/";
    }

}
