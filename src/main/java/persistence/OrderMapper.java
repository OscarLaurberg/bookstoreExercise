/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import persistence.DB;
import businessLogic.Customer;
import businessLogic.Book;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Oscar
 */
public class OrderMapper {

    public void createOrder(List <Book> books) {
        
        String updateSql = "INSERT INTO orders (cust_id,ebook_id,price) VALUES (?,?,?)";
        
        for (Book book : books) {
            int customerId = 1;
            int bookId = book.getId();
            int price = book.getPrice();
            try {
                PreparedStatement stmt = DB.getConnection().prepareStatement(updateSql);
                stmt.setInt(1, customerId);
                stmt.setInt(2, bookId);
                stmt.setInt(3, price);
                stmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
