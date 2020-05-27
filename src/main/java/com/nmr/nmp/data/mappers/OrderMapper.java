package com.nmr.nmp.data.mappers;

import com.nmr.nmp.domain.models.*;
import java.sql.*;
import java.time.LocalDateTime;

public class OrderMapper extends DataMapper {

    @Override
    public String insertStatement() {
        return "INSERT INTO orders (customer_id, startDate, returnDate, orderStatus)" +
                "VALUES (?, ?, ?, ?)";
    }

    @Override
    public String selectSingleStatement() {
        return "SELECT * FROM orders WHERE order_id=?";
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
            ps.setString(4, order.getStatus());
        } catch (SQLException e) { e.printStackTrace(); }
    }

    @Override
    public DomainEntity loadEntity(ResultSet resultSet) {
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
    public void doUpdateInsert(DomainEntity domainEntity, PreparedStatement ps) {
        Order order = (Order) domainEntity;
        doCreateInsert(domainEntity, ps);
        try {
            ps.setInt(5, order.getId());
        } catch (SQLException e) { e.getMessage(); }
    }

    //    public void create(Order order) {
//        try {
//            String sql = "INSERT INTO orders (customer_id, startDate, returnDate, orderStatus)" +
//                    "VALUES (?, ?, ?, ?); ";
//            ps = connection.prepareStatement(sql);
//            ps.setInt(1, order.getCustomerId());
//            ps.setString(2, order.getStartDate());
//            ps.setString(3, order.getReturnDate());
//            ps.setString(4, order.getStatus());
//            ps.execute();
//        } catch (SQLException e) { e.printStackTrace(); }
//        finally {
//            if (ps != null) { try { ps.close(); } catch (SQLException e) { e.printStackTrace(); } }
//        }
//    }

//    public Order read(int orderId){
//        try {
//            String sql = "SELECT * FROM orders WHERE order_id=?";
//            ps = connection.prepareStatement(sql);
//            ps.setInt(1, orderId);
//            rs = ps.executeQuery();
//            if (rs.next()) {
//                int order_id = rs.getInt("order_id");
//                int customerId = rs.getInt("customer_id");
//                Timestamp _orderDate = rs.getTimestamp("orderDate");
//                LocalDateTime orderDate = _orderDate.toLocalDateTime();
//                String startDate = rs.getString("startDate");
//                String returnDate = rs.getString("returnDate");
//                String status = rs.getString("orderStatus");
//                return new Order(order_id, customerId, orderDate, startDate, returnDate, status);
//            }
//        } catch (SQLException e) { e.printStackTrace(); }
//        finally {
//            if (ps != null) { try { ps.close(); } catch (SQLException e) { e.printStackTrace(); } }
//            if (rs != null) { try { rs.close(); } catch (SQLException e) { e.printStackTrace(); } }
//
//        }
//        return new Order();
//    }
//
//    public ArrayList<Order> read() {
//        ArrayList<Order> orders = new ArrayList<>();
//        try {
//            String sql = "SELECT * FROM orders ORDER BY orderDate DESC";
//            ps = connection.prepareStatement(sql);
//            rs = ps.executeQuery();
//
//            while (rs.next()) {
//                int orderId = rs.getInt("order_id");
//                int customerId = rs.getInt("customer_id");
//                Timestamp _orderDate = rs.getTimestamp("orderDate");
//                LocalDateTime orderDate = _orderDate.toLocalDateTime();
//                String startDate = rs.getString("startDate");
//                String returnDate = rs.getString("returnDate");
//                String status = rs.getString("orderStatus");
//
//                Order order = new Order(orderId, customerId, orderDate, startDate, returnDate, status);
//                orders.add(order);
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            if (ps != null) { try { ps.close(); } catch (SQLException e) { e.printStackTrace(); } }
//            if (rs != null) { try { rs.close(); } catch (SQLException e) { e.printStackTrace(); } }
//        }
//        return orders;
//    }
//
//    public void update(Order order) {
//    }
//
//    public void delete(int id) {
//    }

}
