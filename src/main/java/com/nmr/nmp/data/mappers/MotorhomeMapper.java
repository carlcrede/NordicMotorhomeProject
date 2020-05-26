package com.nmr.nmp.data.mappers;

import com.nmr.nmp.domain.models.DomainEntity;
import com.nmr.nmp.domain.models.Motorhome;

import java.sql.*;

public class MotorhomeMapper extends DataMapper {

    @Override
    public String insertStatement(){
        return "INSERT INTO products (category, type, price, brand, model, status) VALUES ('motorhome', ?, ?, ?, ?)";
    }

    @Override
    public String selectSingleStatement(){
        return "SELECT product_id, type, price, brand, model, status FROM products WHERE product_id = ? AND category='motorhome'";
    }

    @Override
    public String selectAllStatement() {
        return "SELECT product_id, type, price, brand, model, status FROM products WHERE category='motorhome' ORDER BY type";
    }

    @Override
    public String selectAvailableStatement() {
        return "SELECT product_id, type, price, brand, model, status FROM products WHERE category='motorhome' AND status='available' ORDER BY type";
    }

    @Override
    public String updateStatement() {
        return "UPDATE products SET type = ?, price = ?, brand = ?, model = ?, status = ? WHERE product_id = ?";
    }

    @Override
    public String deleteStatement() {
        return "DELETE FROM products WHERE product_id = ? AND category='motorhome'";
    }

    @Override
    public void doCreateInsert(DomainEntity domainEntity, PreparedStatement ps){
        Motorhome motorhome = (Motorhome)domainEntity;
        try {
            ps.setString(1, motorhome.getType());
            ps.setInt(2, motorhome.getPrice());
            ps.setString(3, motorhome.getBrand());
            ps.setString(4, motorhome.getModel());
            ps.setString(5, motorhome.getStatus());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public DomainEntity loadEntity(ResultSet rs){
        try {
            int id = rs.getInt("product_id");
            String type = rs.getString("type");
            int price = rs.getInt("price");
            String model = rs.getString("model");
            String brand = rs.getString("brand");
            String status = rs.getString("status");
            return new Motorhome(id, type, price, brand, model, status);
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void doUpdateInsert(DomainEntity domainEntity, PreparedStatement ps) {
        Motorhome motorhome = (Motorhome)domainEntity;
        try {
            ps.setString(1, motorhome.getType());
            ps.setInt(2, motorhome.getPrice());
            ps.setString(3, motorhome.getBrand());
            ps.setString(4, motorhome.getModel());
            ps.setString(5, motorhome.getStatus());
            ps.setInt(6, motorhome.getId());
        } catch (SQLException e) { e.getMessage(); }
    }

}
