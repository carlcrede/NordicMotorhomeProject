/* Author: Peter Helle Hartmann, Philip Bretlau Specht */

package com.nmr.nmp.controllers;

import com.nmr.nmp.data.implementations.DataFacadeImpl;
import com.nmr.nmp.data.mappers.MotorhomeMapper;
import com.nmr.nmp.domain.models.Motorhome;
import com.nmr.nmp.domain.handlers.ProductHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MotorhomeController {

    ProductHandler handler = new ProductHandler(new DataFacadeImpl(new MotorhomeMapper()));

    @GetMapping("/motorhome")
    public String index(Model model) {
        model.addAttribute("motorhomes", handler.readAll());
        return "/motorhome/index";
    }

    @GetMapping("/motorhome/create")
    public String create(Model model) {
        model.addAttribute("motorhome", new Motorhome());
        return "/motorhome/create";
    }

    @PostMapping("/motorhome/create")
    public String create(@ModelAttribute("motorhome") Motorhome motorhome) {
        handler.create(motorhome);
        return "redirect:/motorhome";
    }

    @GetMapping("/motorhome/details")
    public String details(@RequestParam("id") int id, Model model) {
        model.addAttribute("motorhome", handler.read(id));
        return "/motorhome/details";
    }

    @GetMapping("/motorhome/edit")
    public String edit(@RequestParam("id") int id, Model model) {
        model.addAttribute("motorhome", handler.read(id));
        return "/motorhome/edit";
    }

    @PostMapping("/motorhome/edit")
    public String update(@ModelAttribute("motorhome") Motorhome motorhome) {
        handler.update(motorhome);
        return "redirect:/motorhome";
    }

    @GetMapping("/motorhome/delete")
    public String delete(@RequestParam("id") int id, Model model) {
        model.addAttribute("motorhome", handler.read(id));
        return "/motorhome/delete";
    }

    @PostMapping("/motorhome/delete")
    public String delete(HttpServletRequest request) {
        String id = request.getParameter("id");
        handler.delete(Integer.parseInt(id));
        return "redirect:/motorhome";
    }

}
