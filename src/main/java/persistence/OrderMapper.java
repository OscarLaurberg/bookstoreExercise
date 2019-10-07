/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import businessLogic.Customer;
import businessLogic.Book;
import businessLogic.Order;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author oscar
 */
public class OrderMapper {
    
    public void createOrder (Order order) {
        Customer customer = order.getCustomer();
        int id = customer.getId();
        String name = customer.getName();
        String phone = customer.getPhonenumber();
        String email = customer.getEmail();
        List <Book> books = order.getBooks();
        String insertSql = "INSERT INTO orders (cust_id, ebook_id, price, qty) VALUES (?,?,?,?)";
        for (Book book : books) {
            int bookId = book.getId();
            int price = book.getPrice();
            int qty = book.getQty();
            try{
                PreparedStatement ps = DB.getConnection().prepareStatement(insertSql);
                ps.setInt(1, id);
                ps.setInt(2, bookId);
                ps.setInt(3, price);
                ps.setInt(4, qty);
                ps.executeUpdate();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        
    }
    
}
