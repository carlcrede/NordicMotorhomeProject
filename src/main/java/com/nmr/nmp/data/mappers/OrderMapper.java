package com.nmr.nmp.data.mappers;

import com.nmr.nmp.domain.models.*;
import java.sql.*;
import java.time.LocalDateTime;

public class OrderMapper extends DataMapper {

    @Override
    public String insertStatement() {
        return "INSERT INTO orders (customer_id, startDate, returnDate)" +
                "VALUES (?, ?, ?)";
    }

    @Override
    public String selectSingleStatement() {
        return "SELECT * FROM orders WHERE order_id=?";
    }

    @Override
    public String selectLastInsertID() {
        return "SELECT MAX(order_id) FROM orders";
    }

    @Override
    public String selectAllStatement() {
        return "SELECT * FROM orders ORDER BY orderDate DESC";
    }

    @Override
    public String selectAvailableStatement() {
        return null;
    }

    @Override
    public String updateStatement() {
        return "UPDATE orders" +
                "SET customer_id, startDate, returnDate, orderStatus" +
                "WHERE order_id=?";
    }

    @Override
    public String deleteStatement() {
        return "DELETE FROM order WHERE product_id=?";
    }

    @Override
    public void doCreateInsert(DomainEntity domainEntity, PreparedStatement ps) {
        Order order = (Order) domainEntity;
        try {
            ps.setInt(1, order.getCustomerId());
            ps.setString(2, order.getStartDate());
            ps.setString(3, order.getReturnDate());
        } catch (SQLException e) { e.printStackTrace(); }
    }

    @Override
    public DomainEntity loadEntity(ResultSet rs) {
        try {
            int orderId = rs.getInt("order_id");
            int customerId = rs.getInt("customer_id");
            Timestamp _orderDate = rs.getTimestamp("orderDate");
            LocalDateTime orderDate = _orderDate.toLocalDateTime();
            String startDate = rs.getString("startDate");
            String returnDate = rs.getString("returnDate");
            String status = rs.getString("orderStatus");
            return new Order(orderId, customerId, orderDate, startDate, returnDate, status);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int loadLastInsertID(ResultSet rs) {
        try {
            return rs.getInt("MAX(order_id)");
        } catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public void doUpdateInsert(DomainEntity domainEntity, PreparedStatement ps) {
        Order order = (Order) domainEntity;
        doCreateInsert(domainEntity, ps);
        try {
            ps.setInt(5, order.getId());
        } catch (SQLException e) { e.getMessage(); }
    }

}
