package com.nmr.nmp.data;

import com.nmr.nmp.domain.Motorhome;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MotorhomeMapper {

    public void create(Motorhome motorhome) {
        try (Connection connection = DBManager.getConnection()) {
            String sql = "INSERT INTO motorhome (brand, model) VALUES (?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, motorhome.getBrand());
            ps.setString(2, motorhome.getModel());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Motorhome> read() {
        ArrayList<Motorhome> motorhomes = new ArrayList<>();
        try {
            Connection connection = DBManager.getConnection();
            String sql = "SELECT * FROM motorhome";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String model = rs.getString("model");
                String brand = rs.getString("brand");
                Motorhome motorhome = new Motorhome(model, brand);
                motorhomes.add(motorhome);
            }
        } catch (SQLException e) { e.getMessage(); }
        return motorhomes;
    }
}
