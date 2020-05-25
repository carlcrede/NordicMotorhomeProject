package com.nmr.nmp.data;

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

    public ArrayList<Order> read() {
        ArrayList<Order> orders = new ArrayList<>();
        try {
            String sql = "SELECT * FROM orders ORDER BY orderDate DESC";
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                // order data
                int orderId = rs.getInt("order_id");
                int customerId = rs.getInt("customer_id");
                Timestamp _orderDate = rs.getTimestamp("orderDate");
                LocalDateTime orderDate = _orderDate.toLocalDateTime();
                String startDate = rs.getString("startDate");
                String returnDate = rs.getString("returnDate");
                String status = rs.getString("orderStatus");

                Order order = new Order(orderId, customerId, orderDate, startDate, returnDate, status);
                orders.add(order);
                // Orderline data
                //ArrayList<OrderLine> orderLines = loadOrderLines(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) { try { ps.close(); } catch (SQLException e) { e.printStackTrace(); } }
            if (rs != null) { try { rs.close(); } catch (SQLException e) { e.printStackTrace(); } }
        }
        return orders;
    }

    public ArrayList<OrderLine> loadOrderLines (ResultSet rs) throws SQLException {
        ArrayList<OrderLine> orderLines = new ArrayList<>();
        return  null;
    }

//    public Customer loadCustomer(ResultSet rs) throws SQLException {
//        int customerId = rs.getInt("customers.customer_id");
//        String firstname = rs.getString("firstname");
//        String lastname = rs.getString("lastname");
//        String phone = rs.getString("phone");
//        String email = rs.getString("email");
//        return new Customer(customerId, firstname, lastname, phone, email);
//    }
}
