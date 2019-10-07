package businessLogic;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author oscar
 */
public class ShoppingCart {

    List<Book> cart;

    public ShoppingCart() {
        this.cart = new ArrayList<>();
    }

    public List<Book> getCart() {
        return cart;
    }

    public void setCart(List<Book> cart) {
        this.cart = cart;
    }

    public void addBook(Book chosenBook) {
        for (Book book : cart) {
            if (book.equals(chosenBook)) {
                int qty = book.getQty() + chosenBook.getQty();
                book.setQty(qty);
                return;
            }
        }
        cart.add(chosenBook);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Book book : cart) {
            builder.append(book).append("\n");
        }
        return builder.toString();
    }
}
