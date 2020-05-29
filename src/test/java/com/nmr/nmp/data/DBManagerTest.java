package com.nmr.nmp.data;

import org.junit.jupiter.api.Test;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.*;

class DBManagerTest {

    @Test
    public void connectionIsOpenTest(){

    }

    @Test
    void getConnectionTest() {
        Connection connection = DBManager.getConnection();
        assertEquals(connection!=null, true);
    }
}