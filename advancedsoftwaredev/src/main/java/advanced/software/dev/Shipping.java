package advanced.software.dev;


import java.util.Date;

public class Shipping {
    // Static ID tracker for Shipping
    private static int shipmentIDTracker = 1;

    // Fields
    private int shipmentID;         // Primary Key
    private int orderID;            // Foreign Key to Order table
    private String shippingAddress;
    private Date estimatedDeliveryDate;
    private String shippingStatus;

    // Constructor for creating a new Shipping record (auto-incremented shipmentID)
    public Shipping(int orderID, String shippingAddress, Date estimatedDeliveryDate, String shippingStatus) {
        this.shipmentID = shipmentIDTracker;  // Auto-incremented shipmentID
        shipmentIDTracker++;                  // Increment for the next Shipping

        this.orderID = orderID;
        this.shippingAddress = shippingAddress;
        this.estimatedDeliveryDate = estimatedDeliveryDate;
        this.shippingStatus = shippingStatus;
    }

    // Constructor for extracting Shipping details from the database (shipmentID provided)
    public Shipping(int shipmentID, int orderID, String shippingAddress, Date estimatedDeliveryDate, String shippingStatus) {
        this.shipmentID = shipmentID;
        this.orderID = orderID;
        this.shippingAddress = shippingAddress;
        this.estimatedDeliveryDate = estimatedDeliveryDate;
        this.shippingStatus = shippingStatus;
    }

    // Getters and Setters
    public int getShipmentID() {
        return shipmentID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public Date getEstimatedDeliveryDate() {
        return estimatedDeliveryDate;
    }

    public void setEstimatedDeliveryDate(Date estimatedDeliveryDate) {
        this.estimatedDeliveryDate = estimatedDeliveryDate;
    }

    public String getShippingStatus() {
        return shippingStatus;
    }

    public void setShippingStatus(String shippingStatus) {
        this.shippingStatus = shippingStatus;
    }

    // toString method for logging or debugging purposes
    @Override
    public String toString() {
        return "Shipping [shipmentID=" + shipmentID + ", orderID=" + orderID + ", shippingAddress=" + shippingAddress
                + ", estimatedDeliveryDate=" + estimatedDeliveryDate + ", shippingStatus=" + shippingStatus + "]";
    }
}
