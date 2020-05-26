package com.nmr.nmp.data.mappers;

import com.nmr.nmp.domain.models.DomainEntity;
import com.nmr.nmp.domain.models.Extra;
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
        return null;
    }
    @Override
    public String readAllStatement() {
        return "SELECT product_id, type, price, brand, model, stock FROM products WHERE category = 'extra' ORDER BY type";
    }
    @Override
    public String readAvailableStatement() {
        return "SELECT product_id, type, brand, model, stock FROM products WHERE category = 'extra' AND stock > 0 ORDER BY type";
    }
    @Override
    public String updateStatement() {
        return null;
    }
    @Override
    public String deleteStatement() {
        return null;
    }

    @Override
    public void doInsert(DomainEntity domainEntity, PreparedStatement ps) {
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
    public DomainEntity load(ResultSet resultSet) {
        return null;
    }

    @Override
    protected void doUpdate(DomainEntity domainEntity, PreparedStatement ps) {

    }

    public void create(Extra extra) {
        try {
            String sql = "INSERT INTO products (category, type, price, brand, model, stock) VALUES ('extra', ?, ?, ?, ?, ?)";
            ps = connection.prepareStatement(sql);
            ps.setString(1, extra.getType());
            ps.setInt(2, extra.getPrice());
            ps.setString(3, extra.getBrand());
            ps.setString(4, extra.getModel());
            ps.setInt(5, extra.getStock());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) { try { ps.close(); } catch (SQLException e) { e.printStackTrace(); } }
        }
    }

    public Extra read(int productId) {
        try {
            String sql = "SELECT product_id, type, price, brand, model, stock FROM products WHERE product_id=? AND category='extra'";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, productId);
            rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("product_id");
                String type = rs.getString("type");
                int price = rs.getInt("price");
                String model = rs.getString("model");
                String brand = rs.getString("brand");
                int stock = rs.getInt("stock");
                return new Extra(id, type, price, brand, model, stock);
            }
        } catch (SQLException e) { e.printStackTrace(); }
        finally {
            if (ps != null) { try { ps.close(); } catch (SQLException e) { e.printStackTrace(); } }
            if (rs != null) { try { rs.close(); } catch (SQLException e) { e.printStackTrace(); } }
        }
        // TODO: exception handling needs to be implemented
        return new Extra();
    }

    public ArrayList<Extra> read() {
        ArrayList<Extra> motorhomes = new ArrayList<>();
        String sql = "SELECT product_id, type, price, brand, model, stock FROM products WHERE category = 'extra' ORDER BY type";
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("product_id");
                String type = rs.getString("type");
                int price = rs.getInt("price");
                String model = rs.getString("model");
                String brand = rs.getString("brand");
                int stock = rs.getInt("stock");
                motorhomes.add(new Extra(id, type, price, brand, model, stock));
            }
        } catch (SQLException e) { e.getMessage(); }
        finally {
            // TODO: maybe create class for handling closing of db objects
            if (ps != null) { try { ps.close(); } catch (SQLException e) { e.printStackTrace(); } }
            if (rs != null) { try { rs.close(); } catch (SQLException e) { e.printStackTrace(); } }
        }
        return motorhomes;
    }

    public void update(Extra extra) {
    }

    public void delete(int id) {
    }
}
