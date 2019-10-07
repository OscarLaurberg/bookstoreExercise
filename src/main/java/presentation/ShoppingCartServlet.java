///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package presentation;
//
//import businessLogic.ShoppingCart;
//import businessLogic.Book;
//import java.io.IOException;
//import java.io.PrintWriter;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import persistence.BookMapper;
//import persistence.BookMapperInterface;
//
///**
// *
// * @author oscar
// */
//@WebServlet(name = "ShoppingCart", urlPatterns = {"/ShoppingCart"})
//public class ShoppingCartServlet extends HttpServlet {
//
//    /**
//     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        HttpSession session = request.getSession(true);
//        ShoppingCartServlet cart;
//        synchronized (session) {
//            cart = (ShoppingCartServlet) session.getAttribute("shoppingCart");
//            if (cart == null) {  
//                cart = new ShoppingCartServlet();
//                session.setAttribute("shoppingCart", cart);
//           // }
////        }
////        BookMapperInterface mapper = new BookMapper();
////        String[] ids = request.getParameterValues("id");
////        if (ids != null) {
////            for (String id : ids) {
////                int bookid = Integer.parseInt(id);
////                String qty = request.getParameter(id + "qty");
////                Book book = mapper.getBookByID(bookid);
////                if(qty.equals("")){
////                    book.setQty(1);
////                } else {
////                    book.setQty(Integer.parseInt(qty));
////                }
////                cart.addBook(book);
////            }
////        }
//
////        String ebookHtmltable = "";
////        switch (cart.getShoppingCard().size()) {
////            case 0:
////                ebookHtmltable = "no ebooks in shoppingcart";
////                break;
////            default:
////                ebookHtmltable = Collection2Html.ebookList2HtmlTableShop(cart.getShoppingCard());
////        }
////        
////        try ( PrintWriter out = response.getWriter()) {
////            /* TODO output your page here. You may use following sample code. */
////            out.println("<!DOCTYPE html>");
////            out.println("<html>");
////            out.println("<head>");
////            out.println("<title>Servlet ShoppingCardServlet</title>");
////            out.println("</head>");
////            out.println("<body>");
////            out.println("<h1>Servlet ShoppingCardServlet at " + request.getContextPath() + "</h1>");
////            out.println(ebookHtmltable);
////            out.println("<form action=\"OrderServlet\">");
////            out.println("<p>Enter your Name: <input type='text' name='cust_name' /></p>");
////            out.println("<p>Enter your Email: <input type='text' name='cust_email' /></p>");
////            out.println("<p>Enter your Phone Number: <input type='text' name='cust_phone' /></p>");
////            out.println("<input type=\"submit\" value=\"buy ebooks\" />");
////            out.println("</form>");
////            out.println("</body>");
////            out.println("</html>");
////        }
////    }
////
////    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
////    /**
////     * Handles the HTTP <code>GET</code> method.
////     *
////     * @param request servlet request
////     * @param response servlet response
////     * @throws ServletException if a servlet-specific error occurs
////     * @throws IOException if an I/O error occurs
////     */
////    @Override
////    protected void doGet(HttpServletRequest request, HttpServletResponse response)
////            throws ServletException, IOException {
////        processRequest(request, response);
////    }
////
////    /**
////     * Handles the HTTP <code>POST</code> method.
////     *
////     * @param request servlet request
////     * @param response servlet response
////     * @throws ServletException if a servlet-specific error occurs
////     * @throws IOException if an I/O error occurs
////     */
////    @Override
////    protected void doPost(HttpServletRequest request, HttpServletResponse response)
////            throws ServletException, IOException {
////        processRequest(request, response);
////    }
////
////    /**
////     * Returns a short description of the servlet.
////     *
////     * @return a String containing servlet description
////     */
////    @Override
////    public String getServletInfo() {
////        return "Short description";
////    }// </editor-fold>
////
////}
