package advanced.software.dev;

import advanced.software.dev.Order;
import advanced.software.dev.Cart;
import advanced.software.dev.Customer;


import java.util.Date;
import java.util.List;
import java.util.Map;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;


public class OrderController {
    @FXML
    private TextField orderIDField;
    @FXML
    private Label infoLabel;
    
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
    public Order viewOrder(String orderID) {
        // Retrieve the order details from the database using OrderDAO
        return orderDAO.getOrderByID(orderID);
    }

    // Method to view all orders (for customers/admins)
    public List<Order> viewAllOrders() {
        // Retrieve the list of all orders from the database using OrderDAO
        return orderDAO.getAllOrders();
    }
    @FXML
    public void trackOrder(){
        Order shipping = viewOrder(orderIDField.getText());
        statusLabel.setText(shipping.getShippingStatus());
        dateLabel..setText(shipping.getShippingStatus());
}

