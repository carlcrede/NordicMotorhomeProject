package com.nmr.nmp.data.mappers;

import com.nmr.nmp.data.DBManager;
import com.nmr.nmp.domain.models.Customer;
import com.nmr.nmp.domain.models.Order;
import com.nmr.nmp.domain.models.OrderLine;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.sql.Date;

public class OrderMapper {

    Connection connection = DBManager.getConnection();
    PreparedStatement ps = null;
    ResultSet rs = null;

    public void create(Order order) {
        try {
            String sql = "INSERT INTO orders (customer_id, startDate, returnDate, orderStatus)" +
                    "VALUES (?, ?, ?, ?); ";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, order.getCustomerId());
            ps.setString(2, order.getStartDate());
            ps.setString(3, order.getReturnDate());
            ps.setString(4, order.getStatus());
            ps.execute();
        } catch (SQLException e) { e.printStackTrace(); }
        finally {
            if (ps != null) { try { ps.close(); } catch (SQLException e) { e.printStackTrace(); } }
        }
    }

    public Order read(int orderId){
        try {
            String sql = "SELECT * FROM orders WHERE order_id=?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, orderId);
            rs = ps.executeQuery();
            if (rs.next()) {
                int order_id = rs.getInt("order_id");
                int customerId = rs.getInt("customer_id");
                Timestamp _orderDate = rs.getTimestamp("orderDate");
                LocalDateTime orderDate = _orderDate.toLocalDateTime();
                String startDate = rs.getString("startDate");
                String returnDate = rs.getString("returnDate");
                String status = rs.getString("orderStatus");
                return new Order(order_id, customerId, orderDate, startDate, returnDate, status);
            }
        } catch (SQLException e) { e.printStackTrace(); }
        finally {
            if (ps != null) { try { ps.close(); } catch (SQLException e) { e.printStackTrace(); } }
        }
        return new Order();
    }

    public ArrayList<Order> read() {
        ArrayList<Order> orders = new ArrayList<>();
        try {
            String sql = "SELECT * FROM orders ORDER BY orderDate DESC";
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                int orderId = rs.getInt("order_id");
                int customerId = rs.getInt("customer_id");
                Timestamp _orderDate = rs.getTimestamp("orderDate");
                LocalDateTime orderDate = _orderDate.toLocalDateTime();
                String startDate = rs.getString("startDate");
                String returnDate = rs.getString("returnDate");
                String status = rs.getString("orderStatus");

                Order order = new Order(orderId, customerId, orderDate, startDate, returnDate, status);
                orders.add(order);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) { try { ps.close(); } catch (SQLException e) { e.printStackTrace(); } }
            if (rs != null) { try { rs.close(); } catch (SQLException e) { e.printStackTrace(); } }
        }
        return orders;
    }

    public void update(Order order) {
    }

    public void delete(int id) {
    }

}
