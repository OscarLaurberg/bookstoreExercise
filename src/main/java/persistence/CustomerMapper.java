/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import businessLogic.Customer;
import java.sql.ResultSet;

/**
 *
 * @author oscar
 */
public class CustomerMapper {

    public void createCustomer(Customer customer) {
        int id = customer.getId();
        String name = customer.getName();
        String email = customer.getEmail();
        String phone = customer.getPhonenumber();
        String insertSql = "INSERT INTO customers (cust_id, cust_name, email, phone) VALUES (?,?,?,?)";
        try {
            PreparedStatement ps = DB.getConnection().prepareStatement(insertSql);
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, email);
            ps.setString(4, phone);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();;
        }
    }

    public int getNextCustomerID() {
        String sql = "Select max (cust_id) from customers";
        ResultSet rs = null;
        int cust_id = 0;
        try {
            PreparedStatement ps = DB.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            while (rs.next()) {
                cust_id = rs.getInt("max(cust_id)");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cust_id + 1;
    }

    public int getCustomerIdFromName(String name) {
        String sql = "Select * from customers WHERE cust_name = ?";
        ResultSet rs = null;
        int custId = 0;
        try {
            PreparedStatement ps = DB.getConnection().prepareStatement(sql);
            ps.setString(1, name);
            rs = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            while (rs.next()) {
                custId = rs.getInt("cust_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return custId;
    }

}
