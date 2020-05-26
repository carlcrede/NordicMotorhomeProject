package com.nmr.nmp.data.mappers;

import com.nmr.nmp.data.DBManager;
import com.nmr.nmp.domain.models.Motorhome;

import java.sql.*;
import java.util.ArrayList;

public class MotorhomeMapper {

    Connection connection = DBManager.getConnection();
    PreparedStatement ps = null;
    ResultSet rs = null;

    public void create(Motorhome motorhome) {
        try {
            String sql = "INSERT INTO products (category, type, price, brand, model) VALUES ('motorhome', ?, ?, ?, ?)";
            ps = connection.prepareStatement(sql);
            ps.setString(1, motorhome.getType());
            ps.setInt(2, motorhome.getPrice());
            ps.setString(3, motorhome.getBrand());
            ps.setString(4, motorhome.getModel());
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) { try { ps.close(); } catch (SQLException e) { e.printStackTrace(); } }
        }
    }

    public Motorhome read(int motorhomeId) {
        try {
            String sql = "SELECT product_id, type, price, brand, model FROM products WHERE product_id=? AND category='motorhome'";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, motorhomeId);
            rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("product_id");
                String type = rs.getString("type");
                int price = rs.getInt("price");
                String model = rs.getString("model");
                String brand = rs.getString("brand");
                return new Motorhome(id, type, price, brand, model);
            }
        } catch (SQLException e) { e.printStackTrace(); }
        finally {
            if (ps != null) { try { ps.close(); } catch (SQLException e) { e.printStackTrace(); } }
            if (rs != null) { try { rs.close(); } catch (SQLException e) { e.printStackTrace(); } }

        }
        // TODO: exception handling needs to be implemented
        return new Motorhome();
    }

    public ArrayList<Motorhome> read() {
        ArrayList<Motorhome> motorhomes = new ArrayList<>();
        String sql = "SELECT product_id, type, price, brand, model FROM products WHERE category='motorhome' ORDER BY type";
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("product_id");
                String type = rs.getString("type");
                int price = rs.getInt("price");
                String model = rs.getString("model");
                String brand = rs.getString("brand");
                Motorhome motorhome = new Motorhome(id, type, price, brand, model);
                motorhomes.add(motorhome);
            }
        } catch (SQLException e) { e.getMessage(); }
        finally {
            // TODO: maybe create class for handling closing of db objects
            if (ps != null) { try { ps.close(); } catch (SQLException e) { e.printStackTrace(); } }
            if (rs != null) { try { rs.close(); } catch (SQLException e) { e.printStackTrace(); } }
        }
        return motorhomes;
    }

    public void update(Motorhome motorhome) {
        try {
            String sql = "UPDATE products SET type = ?, price = ?, brand = ?, model = ? WHERE product_id=?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, motorhome.getType());
            ps.setInt(2, motorhome.getPrice());
            ps.setString(3, motorhome.getBrand());
            ps.setString(4, motorhome.getModel());
            ps.setInt(5, motorhome.getId());
            ps.executeUpdate();
        } catch (SQLException e) { e.getMessage(); }
        finally {
            if (ps != null) { try { ps.close(); } catch (SQLException e) { e.printStackTrace(); } }
        }
    }

    public void delete(int id) {
        try {
            String sql = "DELETE FROM products WHERE category='motorhome' AND product_id=?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) { e.getMessage(); }
        finally {
            if (ps != null) { try { ps.close(); } catch (SQLException e) { e.printStackTrace(); } }
        }
    }
}
