package com.nmr.nmp.data.mappers;

import com.nmr.nmp.data.DBManager;
import com.nmr.nmp.domain.models.Customer;
import com.nmr.nmp.domain.models.Motorhome;
import com.nmr.nmp.domain.models.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerMapper {

    Connection connection = DBManager.getConnection();
    PreparedStatement ps = null;
    ResultSet rs = null;

    public void create(Customer customer){
        try {
            String sql_cust = "INSERT INTO customers (firstname, lastname, phone, email)" +
                    "VALUES (?, ?, ?, ?)";
            ps = connection.prepareStatement(sql_cust);
            ps.setString(1, customer.getFirstname());
            ps.setString(2, customer.getLastname());
            ps.setString(3, customer.getPhone());
            ps.setString(4, customer.getEmail());
            ps.execute();
        } catch (SQLException e) { e.printStackTrace(); }
        finally {
            if (ps != null) { try { ps.close(); } catch (SQLException e) { e.printStackTrace(); } }
        }

    }

    public Customer read(int customerId){
        try {
            String sql = "SELECT customer_id, firstname, lastname, phone, email FROM customers WHERE customer_id=?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, customerId);
            rs = ps.executeQuery();
            if (rs.next()) {
                int customerID = rs.getInt("customer_id");
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                String phone = rs.getString("phone");
                String email = rs.getString("email");
                return new Customer(customerID, firstname, lastname, phone, email);
            }
        } catch (SQLException e) { e.printStackTrace(); }
        finally {
            if (ps != null) { try { ps.close(); } catch (SQLException e) { e.printStackTrace(); } }
        }
        return new Customer();
    }

    public ArrayList<Customer> read(){
        ArrayList<Customer> customers = new ArrayList<>();
        try {
            String sql = "SELECT * FROM customers";
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                int customerID = rs.getInt("customer_id");
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                String phone = rs.getString("phone");
                String email = rs.getString("email");

                Customer customer = new Customer(customerID, firstname, lastname, phone, email);

                customers.add(customer);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

}
