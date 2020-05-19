package com.nmr.nmp.data;

import com.nmr.nmp.domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper {
    PreparedStatement ps = null;
    ResultSet rs = null;
    public User login(String username, String password) {
        try (Connection connection = DBManager.getConnection()) {
            String sql = "SELECT username FROM user WHERE username=? AND pass=?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String _username = rs.getString("username");
//                String role = rs.getString("role");
                return new User("mechanic", _username);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) { try { ps.close(); } catch (SQLException e) { e.printStackTrace(); } }
            if (rs != null) { try { rs.close(); } catch (SQLException e) { e.printStackTrace(); } }
        }
        return new User();
    }
}
