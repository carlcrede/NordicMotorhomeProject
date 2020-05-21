package com.nmr.nmp.data;

import com.nmr.nmp.domain.ILoginFacade;
import com.nmr.nmp.domain.models.User;

public class LoginFacadeUsersImplementationI implements ILoginFacade {

    private UserMapper userMapper = new UserMapper();

    public User login(String userName, String password) {
        return userMapper.login(userName, password);
    }
}
