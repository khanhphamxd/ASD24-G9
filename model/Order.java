package model;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class Order {
    // Static ID tracker for Order
    private static int orderIDTracker = 1;

    // Fields
    private int orderID;                    // Primary Key
    private int paymentID;                  // Foreign Key to Payment
    private int shippingID;                 // Foreign Key to Shipping
    private List<Integer> productIDList;    // List of Product IDs (Multiple items can be purchased)
    private Date orderDate;
    private String orderStatus;
    private Map<Integer, Integer> productAmountMap;  // Map of ProductID to Quantity (ProductID -> Amount)

    // Constructor for creating a new Order (auto-incremented orderID)
    public Order(int paymentID, int shippingID, List<Integer> productIDList, Map<Integer, Integer> productAmountMap, Date orderDate, String orderStatus) {
        this.orderID = orderIDTracker;      // Auto-incremented orderID
        orderIDTracker++;                   // Increment for the next Order

        this.paymentID = paymentID;
        this.shippingID = shippingID;
        this.productIDList = productIDList;
        this.productAmountMap = productAmountMap;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
    }

    // Constructor for extracting Order details from the database (orderID provided)
    public Order(int orderID, int paymentID, int shippingID, List<Integer> productIDList, Map<Integer, Integer> productAmountMap, Date orderDate, String orderStatus) {
        this.orderID = orderID;
        this.paymentID = paymentID;
        this.shippingID = shippingID;
        this.productIDList = productIDList;
        this.productAmountMap = productAmountMap;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
    }

    // Getters and Setters
    public int getOrderID() {
        return orderID;
    }

    public int getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    public int getShippingID() {
        return shippingID;
    }

    public void setShippingID(int shippingID) {
        this.shippingID = shippingID;
    }

    public List<Integer> getProductIDList() {
        return productIDList;
    }

    public void setProductIDList(List<Integer> productIDList) {
        this.productIDList = productIDList;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Map<Integer, Integer> getProductAmountMap() {
        return productAmountMap;
    }

    public void setProductAmountMap(Map<Integer, Integer> productAmountMap) {
        this.productAmountMap = productAmountMap;
    }

    // toString method for logging or debugging purposes
    @Override
    public String toString() {
        return "Order [orderID=" + orderID + ", paymentID=" + paymentID + ", shippingID=" + shippingID
                + ", productIDList=" + productIDList + ", orderDate=" + orderDate + ", orderStatus=" + orderStatus
                + ", productAmountMap=" + productAmountMap + "]";
    }
}

