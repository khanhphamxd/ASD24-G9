package model;

import java.util.Date;

public class Payment {
    // Fields
    private int paymentID;      // Primary Key
    private int orderID;        // Foreign Key to Order table
    private String paymentMethod;
    private double amount;
    private String cardProvider;
    private Date paymentDate;
    private String paymentStatus;

    // Constructor for creating a new Payment record
    public Payment(int orderID, String paymentMethod, double amount, String cardProvider, Date paymentDate, String paymentStatus) {
        this.orderID = orderID;
        this.paymentMethod = paymentMethod;
        this.amount = amount;
        this.cardProvider = cardProvider;
        this.paymentDate = paymentDate;
        this.paymentStatus = paymentStatus;
    }

    // Constructor for extracting Payment details from the database
    public Payment(int paymentID, int orderID, String paymentMethod, double amount, String cardProvider, Date paymentDate, String paymentStatus) {
        this.paymentID = paymentID;
        this.orderID = orderID;
        this.paymentMethod = paymentMethod;
        this.amount = amount;
        this.cardProvider = cardProvider;
        this.paymentDate = paymentDate;
        this.paymentStatus = paymentStatus;
    }

    // Getters and Setters
    public int getPaymentID() {
        return paymentID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCardProvider() {
        return cardProvider;
    }

    public void setCardProvider(String cardProvider) {
        this.cardProvider = cardProvider;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    // toString method for logging or debugging purposes
    @Override
    public String toString() {
        return "Payment [paymentID=" + paymentID + ", orderID=" + orderID + ", paymentMethod=" + paymentMethod
                + ", amount=" + amount + ", cardProvider=" + cardProvider + ", paymentDate=" + paymentDate
                + ", paymentStatus=" + paymentStatus + "]";
    }
}

