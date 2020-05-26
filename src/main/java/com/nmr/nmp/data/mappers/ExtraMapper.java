package com.nmr.nmp.data.mappers;

import com.nmr.nmp.domain.models.DomainEntity;
import com.nmr.nmp.domain.models.Extra;
import com.nmr.nmp.domain.models.Motorhome;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ExtraMapper extends DataMapper{

    @Override
    public String insertStatement() {
        return "INSERT INTO products (category, type, price, brand, model, stock) VALUES ('extra', ?, ?, ?, ?, ?)";
    }

    @Override
    public String readSingleStatement() {
        return "SELECT product_id, type, price, brand, model, stock FROM products WHERE product_id=? AND category='extra'";
    }

    @Override
    public String readAllStatement() {
        return "SELECT product_id, type, price, brand, model, stock FROM products WHERE category='extra' ORDER BY type";
    }

    @Override
    public String readAvailableStatement() {
        return "SELECT product_id, type, brand, model, stock FROM products WHERE category='extra' AND stock > 0 ORDER BY type";
    }

    @Override
    public String updateStatement() {
        return "UPDATE products SET type = ?, price = ?, brand = ?, model = ? WHERE product_id = ? AND category='extra'";
    }
    @Override
    public String deleteStatement() {
        return "DELETE FROM products WHERE product_id = ? AND category='extra'";
    }

    @Override
    public void doCreateInsert(DomainEntity domainEntity, PreparedStatement ps){
        Extra extra = (Extra) domainEntity;
        try {
            ps.setString(1, extra.getType());
            ps.setInt(2, extra.getPrice());
            ps.setString(3, extra.getBrand());
            ps.setString(4, extra.getModel());
            ps.setInt(5, extra.getStock());
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
            int stock = rs.getInt("stock");
            return new Extra(id, type, price, brand, model, stock);
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void doUpdateInsert(DomainEntity domainEntity, PreparedStatement ps) {
        Extra extra = (Extra) domainEntity;
        doCreateInsert(domainEntity, ps);
        try {
            ps.setInt(5, extra.getId());
        } catch (SQLException e) { e.getMessage(); }
    }

}
