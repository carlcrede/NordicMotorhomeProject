package com.nmr.nmp.data.mappers;

import com.nmr.nmp.data.DBManager;
import com.nmr.nmp.domain.models.Extra;
import com.nmr.nmp.domain.models.Motorhome;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductMapper {

//    Connection connection = DBManager.getConnection();
//    PreparedStatement ps = null;
//    ResultSet rs = null;
//
//    public ArrayList<Motorhome> readMotorhomes() {
////        ArrayList<Motorhome> motorhomes = new ArrayList<>();
//        String sql = "SELECT product_id, type, brand, model FROM products WHERE category='motorhome' AND status='available' ORDER BY model";
//        try {
//            ps = connection.prepareStatement(sql);
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                int product_id = rs.getInt("product_id");
//                String type = rs.getString("type");
//                String brand = rs.getString("brand");
//                String model = rs.getString("model");
//                Motorhome motorhome = new Motorhome(product_id, type, price, model, brand);
//                motorhomes.add(motorhome);
//            }
//        } catch (SQLException e) { e.getMessage(); }
//        finally {
//            // TODO: maybe create class for handling closing of db objects
//            if (ps != null) { try { ps.close(); } catch (SQLException e) { e.printStackTrace(); } }
//            if (rs != null) { try { rs.close(); } catch (SQLException e) { e.printStackTrace(); } }
//        }
//        return motorhomes;
//        return null;
//    }
//
//    public ArrayList<Extra> readExtras() {
//        ArrayList<Extra> motorhomes = new ArrayList<>();
//        String sql = "SELECT product_id, type, brand, model, stock FROM products WHERE category = 'extra' AND stock > 0 ORDER BY model";
//        try {
//            ps = connection.prepareStatement(sql);
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                int id = rs.getInt("product_id");
//                String type = rs.getString("type");
//                String model = rs.getString("model");
//                String brand = rs.getString("brand");
//                int stock = rs.getInt("stock");
//                motorhomes.add(new Extra(id, type, brand, model, stock));
//            }
//        } catch (SQLException e) { e.getMessage(); }
//        finally {
//            // TODO: maybe create class for handling closing of db objects
//            if (ps != null) { try { ps.close(); } catch (SQLException e) { e.printStackTrace(); } }
//            if (rs != null) { try { rs.close(); } catch (SQLException e) { e.printStackTrace(); } }
//        }
//        return motorhomes;
//        return null;
//    }

}
