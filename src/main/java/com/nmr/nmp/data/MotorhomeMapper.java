package com.nmr.nmp.data;

import ch.qos.logback.core.db.dialect.DBUtil;
import com.nmr.nmp.domain.Motorhome;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class MotorhomeMapper {

    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection connection = null;

    public void create(Motorhome motorhome) {
        try {
            connection = DBManager.getConnection();
            String sql = "INSERT INTO motorhome (brand, model) VALUES (?, ?)";
            ps = connection.prepareStatement(sql);
            ps.setString(1, motorhome.getBrand());
            ps.setString(2, motorhome.getModel());
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) { try { connection.close(); } catch (SQLException e) { e.printStackTrace(); } }
            if (ps != null) { try { ps.close(); } catch (SQLException e) { e.printStackTrace(); } }
        }

    }

    public Motorhome read(int motorhomeId) {
        try {
            connection = DBManager.getConnection();
            String sql = "SELECT * FROM motorhome WHERE id=?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, motorhomeId);
            rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                String model = rs.getString("model");
                String brand = rs.getString("brand");
                return new Motorhome(id, brand, model);
            }
        } catch (SQLException e) { e.printStackTrace(); }
        finally {
            if (connection != null) { try { connection.close(); } catch (SQLException e) { e.printStackTrace(); } }
            if (ps != null) { try { ps.close(); } catch (SQLException e) { e.printStackTrace(); } }
        }
        // TODO: exception handling needs to be implemented
        return new Motorhome();
    }

    public ArrayList<Motorhome> read() {
        ArrayList<Motorhome> motorhomes = new ArrayList<>();
        String sql = "SELECT * FROM motorhome";
        try {
            connection = DBManager.getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String model = rs.getString("model");
                String brand = rs.getString("brand");
                int id = rs.getInt("id");
                Motorhome motorhome = new Motorhome(id, model, brand);
                motorhomes.add(motorhome);
            }
        } catch (SQLException e) { e.getMessage(); }
        finally {
            // TODO: maybe create class for handling closing of db objects
            if (connection != null) { try { connection.close(); } catch (SQLException e) { e.printStackTrace(); } }
            if (ps != null) { try { ps.close(); } catch (SQLException e) { e.printStackTrace(); } }
            if (rs != null) { try { rs.close(); } catch (SQLException e) { e.printStackTrace(); } }
        }
        return motorhomes;
    }

    public void update(Motorhome motorhome) {
        try {
            connection = DBManager.getConnection();
            String sql = "UPDATE motorhome SET brand = ?, model = ? WHERE id = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, motorhome.getBrand());
            ps.setString(2, motorhome.getModel());
            ps.setInt(3, motorhome.getId());
            ps.executeUpdate();
        } catch (SQLException e) { e.getMessage(); }
        finally {
            if (connection != null) { try { connection.close(); } catch (SQLException e) { e.printStackTrace(); } }
            if (ps != null) { try { ps.close(); } catch (SQLException e) { e.printStackTrace(); } }
        }
    }

    public void delete(int id) {
        try {
            connection = DBManager.getConnection();
            String sql = "DELETE FROM motorhome WHERE id = ?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) { e.getMessage(); }
        finally {
            if (connection != null) { try { connection.close(); } catch (SQLException e) { e.printStackTrace(); } }
            if (ps != null) { try { ps.close(); } catch (SQLException e) { e.printStackTrace(); } }
        }
    }
}
