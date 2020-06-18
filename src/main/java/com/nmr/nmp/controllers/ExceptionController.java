/* Author: Carl Christian Hasselbalch */

package com.nmr.nmp.controllers;

import com.nmr.nmp.domain.exceptions.DatabaseException;
import com.nmr.nmp.domain.exceptions.LoginException;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ExceptionController implements ErrorController {

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

    @GetMapping("/error")
    public String handleError(HttpServletRequest request, Model model) {
        Integer status_code = (Integer) request.getAttribute("javax.servlet.error.status_code");
        model.addAttribute("status_code", status_code);
        return "error/index";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}