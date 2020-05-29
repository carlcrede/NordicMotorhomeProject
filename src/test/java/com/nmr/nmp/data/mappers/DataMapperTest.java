package com.nmr.nmp.data.mappers;

import com.nmr.nmp.data.DBManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DataMapperTest {

    private Connection connection;
    private PreparedStatement ps;
    private ResultSet rs;

    @BeforeEach
    void init(){
        connection = DBManager.getConnection();
        ps = null;
        rs = null;
    }

    @Test
    void connectionIsClosedPreparedStatementSQLException(){
        String expected = "No operations allowed after connection closed.";

        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Exception exception = assertThrows(SQLException.class, () -> connection.prepareStatement("SELECT * FROM orders"));

        String actual = exception.getMessage();

        assertEquals(expected, actual);

    }

    @Test
    void connectionIsClosedResultSetSQLException(){
        String expected = "No operations allowed after statement closed.";

        try {
            ps = connection.prepareStatement("SELECT * FROM orders");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Exception exception = assertThrows(SQLException.class, () -> rs = ps.executeQuery());

        String actual = exception.getMessage();

        assertEquals(expected, actual);

    }


}