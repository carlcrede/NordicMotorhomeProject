package com.nmr.nmp.domain.uccontrollers;

import com.nmr.nmp.domain.ILoginFacade;
import com.nmr.nmp.domain.models.User;

public class LoginUC {

    private ILoginFacade loginFacade;

    public LoginUC(ILoginFacade loginFacade) { this.loginFacade = loginFacade; }

    public User login(String userName, String password) {
        return loginFacade.login(userName, password);
    }
}
