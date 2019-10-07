/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import businessLogic.Book;
import java.util.List;

/**
 *
 * @author oscar
 */
public interface BookMapperInterface {
    
    public Book getBookByFullTitle(String title);
    public List<Book> getBookByPartOfTitle (String title);
    public List<Book> getAllBooks();
    public Book getBookByID(int id);
}
    