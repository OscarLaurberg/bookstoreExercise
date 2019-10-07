<%-- 
    Document   : SearchPage
    Created on : Oct 2, 2019, 11:18:37 AM
    Author     : oscar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Search for your favorite book:</h1>
        <br>
        <form action="FrontController">

            Search book from full title:<br> <input type="text" name="searchFullTitle" value="Troels og de travle heste" />
            <input type="hidden" name="cmd" value="showBooksByFullTitle" />
            <input type="submit" value="search" />
        </form>
        <br>
        <br>
        <form action="FrontController">
            Search book from part of title:<br> <input type="text" name="searchPartOfTitle" value="travle" />
            <input type="hidden" name="cmd" value="showBooksByPartOfTitle" />
            <input type="submit" value="search" />
        </form>
        <br>
        <br>
        <form action="FrontController">
            <input type="hidden" name="cmd" value="showAllBooks" />
            <input type="submit" value="Show all books" />
        </form>
        
    </body>
</html>
