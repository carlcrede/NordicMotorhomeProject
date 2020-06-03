/* Author: Carl Christian Hasselbalch, Peter Helle Hartmann */

package com.nmr.nmp.data;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBManager {
    private static String user;
    private static String password;
    private static String url;
    private static Connection connection = null;

    public static Connection getConnection() {
        try {
            if (connection != null && !connection.isClosed()) return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try (InputStream input = new FileInputStream("src/main/resources/application.properties")) {
            Properties properties = new Properties();
            properties.load(input);
            url = properties.getProperty("url");
            user = properties.getProperty("user");
            password = properties.getProperty("password");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(url,user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}


