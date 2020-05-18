package com.nmr.nmp.data;

import com.nmr.nmp.domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper {

    public User login(String username, String password) {
        try (Connection connection = DBManager.getConnection()) {
            String sql = "SELECT username AND role FROM nmrdb.user WHERE username=? AND pass=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String _username = rs.getString("username");
                String role = rs.getString("role");
                User user = new User(_username, role);
                return user;
            } else {
                throw new Exception("Loginfejl");
            }

        } catch (SQLException e) {
            e.getMessage();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new User("John", "Hitler", "Owner", "JH1234");
    }
}
