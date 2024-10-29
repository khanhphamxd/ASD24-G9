package advanced.software.dev;

public class Vendor {
    // ID tracker for Vendor
    private static int vendorIDTracker = 1;

    // Fields
    private int vendorID;
    private String vendorName;

    // Getters and Setters
    public int getVendorID() {
        return vendorID;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    // Constructor for creating a new vendor (auto-increment VendorID)
    public Vendor(String vendorName) {
        this.vendorID = vendorIDTracker;
        vendorIDTracker++;  // Increment the vendor ID tracker for the next vendor
        this.vendorName = vendorName;
    }

    // Constructor for retrieving an existing vendor from the database (VendorID provided)
    public Vendor(int vendorID, String vendorName) {
        this.vendorID = vendorID;
        this.vendorName = vendorName;
    }

    // toString method for logging or debugging purposes
    @Override
    public String toString() {
        return "Vendor [vendorID=" + vendorID + ", vendorName=" + vendorName + "]";
    }
}
