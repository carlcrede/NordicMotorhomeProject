package com.nmr.nmp.data.mappers;

import com.nmr.nmp.domain.models.DomainEntity;
import com.nmr.nmp.domain.models.Orderline;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderlineMapper extends DataMapper {

    @Override
    public String insertStatement() {
        return "INSERT INTO orderlines(order_id, product_id, quantity) VALUES (?, ?, ?)";
    }

    @Override
    public String selectSingleStatement() {
        return "SELECT * FROM orderline WHERE orderline_id=?";
    }

    @Override
    public String selectAllStatement() {
        return null;
    }

    @Override
    public String selectAvailableStatement() {
        return null;
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
    public String selectLastInsertID() {
        return null;
    }

    @Override
    public void doCreateInsert(DomainEntity domainEntity, PreparedStatement ps) {
        Orderline orderline = (Orderline) domainEntity;
        try {
            ps.setInt(1, orderline.getOrderId());
            ps.setInt(2, orderline.getProductId());
            ps.setInt(3, orderline.getQuantity());
        } catch (SQLException e) { e.printStackTrace(); }
    }

    @Override
    public DomainEntity loadEntity(ResultSet resultSet) {
        return null;
    }

    @Override
    public int loadLastInsertID(ResultSet resultSet) {
        return 0;
    }

    @Override
    public void doUpdateInsert(DomainEntity domainEntity, PreparedStatement ps) {

    }
}
