package com.nmr.nmp.data.mappers;

import com.nmr.nmp.data.DBManager;
import com.nmr.nmp.domain.exceptions.LoginException;
import com.nmr.nmp.domain.models.User;
import com.nmr.nmp.utility.PasswordEncoder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UserMapperTest {

    UserMapper userMapper;
    User user;

    @BeforeAll
    void init(){
        userMapper = new UserMapper();
        user = new User();
    }

    @Test
    void loginUserFirstnameTest() {
        String expected = "John";

        try {
            user = userMapper.login("jd1234", PasswordEncoder.encode("MitKodeord123!"));
        } catch (LoginException e) {
            e.printStackTrace();
        }

        String actual = user.getFirstName();

        assertEquals(expected, actual);


    }

    @Test
    void loginUserLastnameTest() {
        String expected = "Doe";

        try {
            user = userMapper.login("jd1234", PasswordEncoder.encode("MitKodeord123!"));
        } catch (LoginException e) {
            e.printStackTrace();
        }

        String actual = user.getLastName();

        assertEquals(expected, actual);

    }

    @Test
    void loginUserRoleTest(){
        String expected = "owner";

        try {
            user = userMapper.login("jd1234", PasswordEncoder.encode("MitKodeord123!"));
        } catch (LoginException e) {
            e.printStackTrace();
        }

        String actual = user.getRole();

        assertEquals(expected, actual);

    }

    @Test
    void loginUserUsernameTest(){
        String expected = "jd1234";

        try {
            user = userMapper.login("jd1234", PasswordEncoder.encode("MitKodeord123!"));
        } catch (LoginException e) {
            e.printStackTrace();
        }

        String actual = user.getUserName();

        assertEquals(expected, actual);

    }

}