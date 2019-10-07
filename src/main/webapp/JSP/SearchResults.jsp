<%-- 
    Document   : SearchResults
    Created on : Oct 2, 2019, 11:19:25 AM
    Author     : oscar
--%>

<%@page import="java.util.List"%>
<%@page import="businessLogic.Book"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Search results:</h1>
        <% List<Book> books = (List) request.getAttribute("books"); %>
        <table bgcolor="#085380" border="4" cellpadding="5">
            <thead><tr>
                    <th> </th>
                    <th>Title</th>
                    <th>Author</th>
                    <th>Price</th>
                    <th>Quantity</th>
                </tr>
            </thead><tbody>

                <%
                    for (Book book : books) {
                %>


                <tr>
                    <td> <%=book.getId()%> </td>
                    <td> <%=book.getTitle()%> </td>
                    <td> <%=book.getAuthor()%>  </td>
                    <td><%=book.getPrice()%>  </td>
                    <td><input type="number" maxlength="2" size="2" name=""<%=book.getId()%> value="" /></td>
                </tr>
                <%
                    }
                %>

            </tbody></table>
        <br>
        <br>
        <input type=\"button\" style=\"background-color:#085380;color:blue;width:110px
               height:40px value='ORDER' />
        
        
    </form>


</body>
</html>
