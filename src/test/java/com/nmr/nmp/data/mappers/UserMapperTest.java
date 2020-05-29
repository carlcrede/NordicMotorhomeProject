package com.nmr.nmp.data.mappers;

import com.nmr.nmp.domain.exceptions.LoginException;
import com.nmr.nmp.domain.models.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserMapperTest {



    @Test
    void loginTest() throws LoginException {
        UserMapper um = new UserMapper();
        um.login("jd1234","MitKodeord123!");

    }
}