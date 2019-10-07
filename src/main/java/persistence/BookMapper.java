/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import businessLogic.Book;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author oscar
 */

        
public class BookMapper implements BookMapperInterface {


    @Override
    public Book getBookByFullTitle(String title) {
        String sql = "SELECT * FROM ebooks where title = ?";
        ResultSet rs = null;
        try {
            PreparedStatement stmt = DB.getConnection().prepareStatement(sql);
            stmt.setString(1, title);
            rs = stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Book book = null;
        try {
            while (rs.next()) {
                int id = rs.getInt("ebook_id");
                String bookTitle = rs.getString("title");
                String author = rs.getString("author");
                int price = rs.getInt("price");
                book = new Book(id, bookTitle, author, price);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }
    
   
   @Override
    public List<Book> getBookByPartOfTitle(String title) {
        String sql = "SELECT * FROM ebooks where title like \"%" + title + "%\"";
        List <Book> books = new ArrayList<>();
        ResultSet rs = null;
        try{
            PreparedStatement ps = DB.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            
        }catch(SQLException e) {
            e.printStackTrace();
        }
        Book book = null;
        try{
            while (rs.next()) {
                int id = rs.getInt("ebook_id");
                String bookTitle = rs.getString("title");
                String author = rs.getString("author");
                int price = rs.getInt("price");
                book = new Book (id, bookTitle, author, price);
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
               return books;
    }

    
    @Override
    public List<Book> getAllBooks() {
        String sql = "SELECT * FROM ebooks";
        List<Book> ebooks = new ArrayList<>();
        ResultSet rs = null;
        try {
            rs = DB.getConnection().prepareStatement(sql).executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Book book = null;
        try {
            while (rs.next()) {
                int id = rs.getInt("ebook_id");
                String title = rs.getString("title");
                String author = rs.getString("author");
                int price = rs.getInt("price");
                book = new Book(id, title, author, price);
                ebooks.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ebooks;
    }

    public static void main(String[] args) {
        BookMapper mapper = new BookMapper();
        List<Book> books = new ArrayList<>();
        books = mapper.getAllBooks();
        System.out.println(books.get(0).getTitle());
    }
    @Override
    public Book getBookByID(int id) {
        String sql = "SELECT * FROM ebooks where ebook_id = ?";
        ResultSet rs = null;
        try {
            PreparedStatement ps = DB.getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Book book = null;
        try {
            while (rs.next()) {
                int bookId = rs.getInt("ebook_id");
                String bookTitle = rs.getString("title");
                String author = rs.getString("author");
                int price = rs.getInt("price");
                book = new Book(bookId, bookTitle, author, price);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }
}

