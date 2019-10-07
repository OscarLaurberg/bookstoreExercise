/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogic;

import java.util.List;

/**
 *
 * @author oscar
 */
public class CollectionToHtml {

    public static String bookListToHtmlTable(List<Book> books) {
        String out = "<table bgcolor=\"#2DA2C3\" border=\"4\" cellpadding=\"5\"><thead><tr><th>id</th><th>Title</th><th>Author</th><th>Price</th></tr></thead><tbody>";
        for (Book book : books) {
            out += " <tr><td>" + book.getId() + "</td><td>" + book.getTitle() + "</td><td>" + book.getAuthor() + "</td><td>" + book.getPrice() + "</td><td>" + "<input type=\"number\" maxlength=\"2\" size=\"2\" name=\"" + book.getId() + "qty\" value=\"\" /></td>" + "</td></tr>";
        }

        out += "</tbody></table>";
        out += "<br>";
        out += "<br>";
        out += "<input type='submit' value='ORDER' />";
        return out;
    }

    public static String bookListToHtmlTableShop(List<Book> books) {
        String out = "<table bgcolor=\"#2DA2C3\" border=\"1´4\" cellpadding=\"5\"><thead><tr><th>Title</th><th>Author</th><th>Price</th><th>Quantity</th></tr></thead><tbody>";
        int price = 0;
        for (Book book : books) {
            out += " <tr><td>" + book.getTitle() + "</td><td>" + book.getAuthor() + "</td><td>" + book.getPrice() + "</td><td>" + book.getQty() + "</td></tr>";
            price += book.getPrice() * book.getQty();
        }
        out += "</tbody></table>";
        out += "<table border=\"2\" cellpadding=\"20\"><thead><tr><th>Totalprice</th></tr></thead><tbody>";
        out += " <tr><td>" + price + "</td></tr>";
        out += "</tbody></table>";
        out += "<br>";
        out += "<br>";
        out += "<input type='submit' value='ORDER' />";
        return out;
    }

    public static String bookToHtmlTable(Book book) {
        String out = "<table bgcolor=\"#2DA2C3\" border=\"4\" cellpadding=\"5\"><thead><tr><th>ID</th><th>Title</th><th>Author</th><th>Price</th></tr></thead><tbody>";
        out += " <tr><td>" + book.getId() + "</td><td>" + book.getTitle() + "</td><td>" + book.getAuthor() + "</td><td>" + book.getPrice() + "</td></tr>";
        out += "<input type='submit' value='ORDER' />";
        out += "</tbody></table>";
        return out;
    }

    public static String bookToHtmlForm(Book book) {
        String out = "<form method=\"get\" action=\"ShoppingCardServlet\">";
        out += "<table bgcolor=\"#2DA2C3\" border=\"4\" cellpadding=\"5\"><thead><tr><th> </th><th>Title</th><th>Author</th><th>Price</th><th>Quantity</th></tr></thead><tbody>";
        out += "<tr><td><input type='checkbox' name='id' value="
                + "'" + book.getId() + "' /></td><td>"
                + book.getTitle() + "</td><td>"
                + book.getAuthor() + "</td><td>$"
                + book.getPrice() + "</td><td>"
                + "<input type=\"number\" maxlength=\"2\" size=\"2\" name=\"" + book.getId() + "qty\" value=\"\" /></td>";
        out += "</tr>";
        out += "</tbody></table>";
        out += "<br>";
        out += "<input type='submit' value='ORDER' />";
        out += "</form>";
        return out;
    }

    public static String bookListToHtmlForm(List<Book> books) {
        String out = "<form method=\"get\" action=\"ShoppingCardServlet\">";
        out += "<table bgcolor=\"#085380\" border=\"4\" cellpadding=\"5\"><thead><tr><th> </th><th>Title</th><th>Author</th><th>Price</th><th>Quantity</th></tr></thead><tbody>";
        for (Book book : books) {
            out += "<tr><td><input type='checkbox' name='id' value="
                    + "'" + book.getId() + "' /></td><td>"
                    + book.getTitle() + "</td><td>"
                    + book.getAuthor() + "</td><td>$"
                    + book.getPrice() + "</td><td>"
                    + "<input type=\"number\" maxlength=\"2\" size=\"2\" name=\"" + book.getId() + "qty\" value=\"\" /></td>";
        }
        out += "</tr>";
        out += "</tbody></table>";
        out += "<br>";
        out += "<br>";
        out += "<input type=\"button\" style=\"background-color:#085380;color:white;width:110px;\n"
                + "height:40px;\" value='ORDER' />";
        out += "</form>";
        return out;
    }
}
