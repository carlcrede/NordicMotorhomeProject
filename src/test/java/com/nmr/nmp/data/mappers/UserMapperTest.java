package com.nmr.nmp.data.mappers;

import com.nmr.nmp.data.DBManager;
import com.nmr.nmp.domain.models.User;
import com.nmr.nmp.utility.PasswordEncoder;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.*;

class UserMapperTest {



    @Test
    void loginTest() {
        //User user = new User();

        UserMapper um = new UserMapper();
        User actual = um.login("jd1234", PasswordEncoder.encode("MitKodeord123!"));
        //User expected = new User("John", "Doe", "Owner","jd1234");
        assertEquals("John", actual.getFirstName());


    }
}