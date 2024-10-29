package com.asd;

public class Order {
    // Variables
    private int orderId;
    private String orderDetails;
    private String orderStatus;
    private String orderDate;

    // Constructor
    public Order(int orderId, String orderDetails, String orderStatus, String orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.orderDetails = orderDetails;
        this.orderStatus = orderStatus;
    }

    // Getters 
    public int getOrderId() {
        return orderId;
    }

    public String getOrderDetails() {
        return orderDetails;
    }

    public String getOrderStatus() {
        return orderStatus;
    }
    public String getOrderDate() {
        return orderDate;
    }
}
