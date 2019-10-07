/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import businessLogic.Book;
import businessLogic.CollectionToHtml;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.BookMapper;
import persistence.BookMapperInterface;

/**
 *
 * @author oscar
 */
@WebServlet(name = "FrontController", urlPatterns = {"/FrontController"})
public class FrontController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cmd = request.getParameter("cmd");
        BookMapperInterface mapper = new BookMapper();
        List<Book> books = null;
        RequestDispatcher rd = null;
        String title;
        Book book = null;

        switch (cmd) {
            case "start":
                rd = request.getRequestDispatcher("JSP/SearchPage.jsp");
                break;
            case "showAllBooks":
                books = mapper.getAllBooks();
                request.setAttribute("books", books);
                rd = request.getRequestDispatcher("JSP/SearchResults.jsp");
                break;
            case "showBooksByFullTitle":
                title = request.getParameter("searchFullTitle");
                book = mapper.getBookByFullTitle(title);
                books.add(book);
                request.setAttribute("books", books);
                rd = request.getRequestDispatcher("JSP/SearchResults.jsp");
                break;
            case "showBooksByPartOfTitle":
                title = request.getParameter("searchPartOfTitle");
                books = mapper.getBookByPartOfTitle(title);
                request.setAttribute("books", books);
                rd = request.getRequestDispatcher("JSP/SearchResults.jsp");
                break;
            default:
                rd = request.getRequestDispatcher("JSP/SearchResults.jsp");

                break;

        }
        rd.forward(request, response);
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
