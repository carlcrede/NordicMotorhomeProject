package com.nmr.nmp.controller;

import com.nmr.nmp.data.implementations.LoginFacadeImpl;
import com.nmr.nmp.domain.exceptions.DatabaseException;
import com.nmr.nmp.domain.exceptions.LoginException;
import com.nmr.nmp.domain.handlers.LoginHandler;
import com.nmr.nmp.domain.models.User;
import com.nmr.nmp.utility.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController extends ExceptionController {

    LoginHandler loginHandler = new LoginHandler(new LoginFacadeImpl());

    @GetMapping("/")
    public String index(HttpSession session) {
        if (session.getAttribute("user") != null) {
            return "login/user";
        } else {
            return "login/index";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "login/index";
    }

    @PostMapping("/login")
    public String login(HttpServletRequest request) throws LoginException, DatabaseException {
        String username = request.getParameter("uname");
        String pass = request.getParameter("psw");
        User user = loginHandler.login(username, PasswordEncoder.encode(pass));
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        session.setAttribute("role", user.getRole());
        return "redirect:/";
    }
}
