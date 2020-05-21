package com.nmr.nmp.controller;

import com.nmr.nmp.data.LoginFacadeUsersImplementationI;
import com.nmr.nmp.domain.models.User;
import com.nmr.nmp.domain.uccontrollers.LoginUC;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Controller
public class LoginController {

    LoginUC loginController = new LoginUC(new LoginFacadeUsersImplementationI());

    @GetMapping("/")
    public String index(HttpSession session) {
        if (session.getAttribute("user") != null) {
            return "login/user";
        } else {
            return "login/index";
        }
    }

    @PostMapping("/login")
    public String login(HttpServletRequest request) throws NoSuchAlgorithmException {
        String username = request.getParameter("uname");
        String pass = request.getParameter("psw");

        // TODO: move to another class or method
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] encodedHash = messageDigest.digest(pass.getBytes(StandardCharsets.UTF_8));
        String passString = bytesToHex(encodedHash);

        User user = loginController.login(username, passString);
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        session.setAttribute("role", user.getRole());
        return "redirect:/";
    }

    private String bytesToHex(byte[] hash) {
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
