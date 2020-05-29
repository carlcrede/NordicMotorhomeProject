package com.nmr.nmp.domain.handlers;

import com.nmr.nmp.domain.ILoginFacade;
import com.nmr.nmp.domain.models.User;

public class LoginHandler {

    private ILoginFacade loginFacade;

    public LoginHandler(ILoginFacade loginFacade) { this.loginFacade = loginFacade; }

    public User login(String userName, String password) {
        return loginFacade.login(userName, password);
    }

}
