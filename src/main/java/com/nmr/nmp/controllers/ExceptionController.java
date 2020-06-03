package com.nmr.nmp.controllers;

import com.nmr.nmp.domain.exceptions.DatabaseException;
import com.nmr.nmp.domain.exceptions.LoginException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Controller
public class ExceptionController {

    @ExceptionHandler(LoginException.class)
    public String loginError(Model model, Exception exception) {
        model.addAttribute("message",exception.getMessage());
        return "/login/index";
    }

    @ExceptionHandler(DatabaseException.class)
    public String sqlError(Model model, Exception exception) {
        model.addAttribute("exception", exception);
        return "/error/index";
    }

}