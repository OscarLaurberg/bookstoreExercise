/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import businessLogic.Customer;
import java.util.List;

/**
 *
 * @author Oscar
 */
public class Order {
    Customer customer;

    public Order(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }
    
    

    
}
