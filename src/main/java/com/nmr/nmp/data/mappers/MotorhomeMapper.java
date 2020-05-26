package com.nmr.nmp.data.mappers;

import com.nmr.nmp.domain.models.DomainEntity;
import com.nmr.nmp.domain.models.Motorhome;

import java.sql.*;

public class MotorhomeMapper extends DataMapper {

    @Override
    public String insertStatement(){
        return "INSERT INTO products (category, type, price, brand, model) VALUES ('motorhome', ?, ?, ?, ?)";
    }

    @Override
    public String readSingleStatement(){
        return "SELECT product_id, type, brand, model, price FROM products WHERE product_id = ? AND category='motorhome'";
    }

    @Override
    public String readAllStatement() {
        return "SELECT product_id, type, price, brand, model FROM products WHERE category='motorhome' ORDER BY type";
    }

    @Override
    public String readAvailableStatement() {
        return "SELECT product_id, type, brand, model FROM products WHERE category='motorhome' AND status='available' ORDER BY type";
    }

    @Override
    public String updateStatement() {
        return "UPDATE products SET type = ?, price = ?, brand = ?, model = ? WHERE product_id = ?";
    }

    @Override
    public String deleteStatement() {
        return "UPDATE products SET type = ?, price = ?, brand = ?, model = ? WHERE product_id = ?";
    }

    @Override
    public void doInsert(DomainEntity domainEntity, PreparedStatement ps){
        Motorhome motorhome = (Motorhome)domainEntity;
        try {
            ps.setString(1, motorhome.getType());
            ps.setInt(2, motorhome.getPrice());
            ps.setString(3, motorhome.getBrand());
            ps.setString(4, motorhome.getModel());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) { try { ps.close(); } catch (SQLException e) { e.printStackTrace(); } }
        }
    }

    @Override
    public DomainEntity load(ResultSet rs){
        try {
            int id = rs.getInt("product_id");
            String type = rs.getString("type");
            int price = rs.getInt("price");
            String model = rs.getString("model");
            String brand = rs.getString("brand");
            return new Motorhome(id, type, price, brand, model);
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void doUpdate(DomainEntity domainEntity, PreparedStatement ps) {
        Motorhome motorhome = (Motorhome)domainEntity;
        try {
            ps.setString(1, motorhome.getType());
            ps.setInt(2, motorhome.getPrice());
            ps.setString(3, motorhome.getBrand());
            ps.setString(4, motorhome.getModel());
            ps.setInt(5, motorhome.getId());
        } catch (SQLException e) { e.getMessage(); }
    }

}
