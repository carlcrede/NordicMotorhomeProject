package com.nmr.nmp.domain;


import com.nmr.nmp.domain.models.User;

public interface ILoginFacade {

    User login(String userName, String password);
}
