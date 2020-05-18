package com.nmr.nmp.domain.uccontrollers;

import com.nmr.nmp.domain.ILoginFacade;

public class LoginUC {

    private ILoginFacade loginFacade;

    public LoginUC(ILoginFacade loginFacade) { this.loginFacade = loginFacade; }
}
