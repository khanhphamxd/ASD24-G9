package controller;

import model.Order;
import model.Cart;
import model.Customer;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class OrderController {
    
    private OrderDAO orderDAO;  // Assuming there's an OrderDAO for database operations

    // Constructor initializing the DAO
    public OrderController(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    // Method to place an order
    public Order placeOrder(Cart cart, Customer customer, int paymentID, int shippingID) {
        // Transfer the itemList and itemAmountList info from Cart to Order
        List<Integer> productIDList = cart.getItemList();
        Map<Integer, Integer> productAmountMap = cart.getItemAmountList();

        // Create a new Order with the transferred data, current date, and default status (e.g., "Processing")
        Order newOrder = new Order(paymentID, shippingID, productIDList, productAmountMap, new Date(), "Processing");

        // Notify the customer that the order belongs to them (log or notification system can be added here)
        System.out.println("Order placed by customer: " + customer.getUsername());

        // Save the order to the database using OrderDAO
        orderDAO.saveOrder(newOrder);

        // Return the created order
        return newOrder;
    }

    // Method to view an order by ID
    public Order viewOrder(int orderID) {
        // Retrieve the order details from the database using OrderDAO
        return orderDAO.getOrderByID(orderID);
    }

    // Method to view all orders (for customers/admins)
    public List<Order> viewAllOrders() {
        // Retrieve the list of all orders from the database using OrderDAO
        return orderDAO.getAllOrders();
    }
}

