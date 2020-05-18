package com.nmr.nmp.controller;

import com.nmr.nmp.data.DataFacadeUsersImplementationI;
import com.nmr.nmp.domain.uccontrollers.LoginUC;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    LoginUC loginController = new LoginUC(new DataFacadeUsersImplementationI());

    @GetMapping("/")
    public String index() {
        return "/index";
    }
}
