package com.nmr.nmp.data.mappers;

import com.nmr.nmp.domain.models.Customer;
import com.nmr.nmp.domain.models.DomainEntity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerMapper extends DataMapper{

    @Override
    public String insertStatement() {
        return "INSERT INTO customers (firstname, lastname, phone, email)" +
                "VALUES (?, ?, ?, ?)";
    }

    @Override
    public String selectSingleStatement() {
        return "SELECT customer_id, firstname, lastname, phone, email FROM customers WHERE customer_id=?";
    }

    @Override
    public String selectAllStatement() {
        return "SELECT * FROM customers";
    }

    @Override
    public String selectAvailableStatement() {
        return null;
    }

    @Override
    public String updateStatement() {
        return "UPDATE customers SET customer_id, firstname, lastname, phone, email WHERE customer_id=?";
    }

    @Override
    public String deleteStatement() {
        return "DELETE FROM customers WHERE customer_id=?";
    }

    @Override
    public void doCreateInsert(DomainEntity domainEntity, PreparedStatement ps) {
        Customer customer = (Customer) domainEntity;
        try {
            ps.setString(1, customer.getFirstname());
            ps.setString(2, customer.getLastname());
            ps.setString(3, customer.getPhone());
            ps.setString(4, customer.getEmail());
        } catch (SQLException e) { e.printStackTrace(); }
    }

    @Override
    public DomainEntity loadEntity(ResultSet resultSet) {
        try {
            int customerID = rs.getInt("customer_id");
            String firstname = rs.getString("firstname");
            String lastname = rs.getString("lastname");
            String phone = rs.getString("phone");
            String email = rs.getString("email");
            return new Customer(customerID, firstname, lastname, phone, email);
        } catch (SQLException e) { e.printStackTrace(); }
        return null;
    }

    @Override
    public void doUpdateInsert(DomainEntity domainEntity, PreparedStatement ps) {
        Customer customer = (Customer) domainEntity;
        doCreateInsert(customer, ps);
        try {
            ps.setString(5, customer.getLastname());
        } catch (SQLException e) { e.printStackTrace(); }
    }
//
//    public void create(Customer customer){
//        try {
//            String sql_cust = "INSERT INTO customers (firstname, lastname, phone, email)" +
//                    "VALUES (?, ?, ?, ?)";
//            ps = connection.prepareStatement(sql_cust);
//            ps.setString(1, customer.getFirstname());
//            ps.setString(2, customer.getLastname());
//            ps.setString(3, customer.getPhone());
//            ps.setString(4, customer.getEmail());
//            ps.execute();
//        } catch (SQLException e) { e.printStackTrace(); }
//        finally {
//            if (ps != null) { try { ps.close(); } catch (SQLException e) { e.printStackTrace(); } }
//        }
//
//    }
//
//
//    public Customer read(int customerId){
//        try {
//            String sql = "SELECT customer_id, firstname, lastname, phone, email FROM customers WHERE customer_id=?";
//            ps = connection.prepareStatement(sql);
//            ps.setInt(1, customerId);
//            rs = ps.executeQuery();
//            if (rs.next()) {
//                int customerID = rs.getInt("customer_id");
//                String firstname = rs.getString("firstname");
//                String lastname = rs.getString("lastname");
//                String phone = rs.getString("phone");
//                String email = rs.getString("email");
//                return new Customer(customerID, firstname, lastname, phone, email);
//            }
//        } catch (SQLException e) { e.printStackTrace(); }
//        finally {
//            if (ps != null) { try { ps.close(); } catch (SQLException e) { e.printStackTrace(); } }
//        }
//        return new Customer();
//    }
//
//    public ArrayList<Customer> read(){
//        ArrayList<Customer> customers = new ArrayList<>();
//        try {
//            String sql = "SELECT * FROM customers";
//            ps = connection.prepareStatement(sql);
//            rs = ps.executeQuery();
//
//            while (rs.next()) {
//                int customerID = rs.getInt("customer_id");
//                String firstname = rs.getString("firstname");
//                String lastname = rs.getString("lastname");
//                String phone = rs.getString("phone");
//                String email = rs.getString("email");
//
//                Customer customer = new Customer(customerID, firstname, lastname, phone, email);
//
//                customers.add(customer);
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return customers;
//    }

}
