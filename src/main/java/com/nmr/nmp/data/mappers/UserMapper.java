/* Author: Carl Christian Hasselbalch, Jannick Lücking Espersen */

package com.nmr.nmp.data.mappers;

import com.nmr.nmp.data.DBManager;
import com.nmr.nmp.domain.exceptions.DatabaseException;
import com.nmr.nmp.domain.exceptions.LoginException;
import com.nmr.nmp.domain.models.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper {

    Connection connection = DBManager.getConnection();
    PreparedStatement ps = null;
    ResultSet rs = null;

    public User login(String username, String password) throws LoginException, DatabaseException {
        try {
            String sql = "SELECT * FROM users WHERE username=? AND pass=?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String _username = rs.getString("username");
                String firstName = rs.getString("firstname");
                String lastName = rs.getString("lastname");
                String role = rs.getString("role");
                return new User(firstName, lastName, role, _username);
            } else {
                throw new LoginException("Wrong username or password.");
            }
        } catch (SQLException e) {
            throw new DatabaseException(e.getMessage(), "Database error. Please contact system admin.");
        } finally {
            if (ps != null) { try { ps.close(); } catch (SQLException e) { e.printStackTrace(); } }
            if (rs != null) { try { rs.close(); } catch (SQLException e) { e.printStackTrace(); } }
        }
    }
}
