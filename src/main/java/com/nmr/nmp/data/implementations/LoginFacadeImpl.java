package com.nmr.nmp.data.implementations;

import com.nmr.nmp.data.mappers.UserMapper;
import com.nmr.nmp.domain.ILoginFacade;
import com.nmr.nmp.domain.exceptions.DatabaseException;
import com.nmr.nmp.domain.exceptions.LoginException;
import com.nmr.nmp.domain.models.User;

public class LoginFacadeImpl implements ILoginFacade {

    private UserMapper userMapper = new UserMapper();

    public User login(String userName, String password) throws LoginException, DatabaseException {
        return userMapper.login(userName, password);
    }
}
