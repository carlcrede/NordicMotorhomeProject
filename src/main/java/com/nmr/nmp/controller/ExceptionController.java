package com.nmr.nmp.controller;

import com.nmr.nmp.domain.exceptions.LoginException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Controller
public class ExceptionController {

    @ExceptionHandler(LoginException.class)
    public String anotherError(Model model, Exception exception) {
        model.addAttribute("message",exception.getMessage());
        return "/login/index";
    }
}
