package model;
public class Product {
    // ID tracker for Product
    private static int productIDTracker = 1;

    // Fields
    private int productID;
    private int vendorID;      // Foreign key to vendor table
    private int inventoryID;   // Can be optional or nullable based on your DB schema
    private String category;   // Can be optional based on use case
    private String productName;
    private String productDesc;
    private double productPrice;

    // Getters and Setters
    public int getProductID() {
        return productID;
    }

    public int getVendorID() {
        return vendorID;
    }

    public void setVendorID(int vendorID) {
        this.vendorID = vendorID;
    }

    public int getInventoryID() {
        return inventoryID;
    }

    public void setInventoryID(int inventoryID) {
        this.inventoryID = inventoryID;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    // Constructor for creating a new product (ID will be auto-incremented)
    public Product(int vendorID, int inventoryID, String category, String productName, String productDesc, double productPrice) {
        this.productID = productIDTracker;
        productIDTracker++; // Increment the product ID for the next product

        this.vendorID = vendorID;
        this.inventoryID = inventoryID;
        this.category = category;
        this.productName = productName;
        this.productDesc = productDesc;
        this.productPrice = productPrice;
    }

    // Constructor for extracting product from the database (ID provided by the database)
    public Product(int productID, int vendorID, int inventoryID, String category, String productName, String productDesc, double productPrice) {
        this.productID = productID;
        this.vendorID = vendorID;
        this.inventoryID = inventoryID;
        this.category = category;
        this.productName = productName;
        this.productDesc = productDesc;
        this.productPrice = productPrice;
    }

    // toString method for logging or debugging purposes
    @Override
    public String toString() {
        return "Product [productID=" + productID + ", vendorID=" + vendorID + ", inventoryID=" + inventoryID
                + ", category=" + category + ", productName=" + productName + ", productDesc=" + productDesc
                + ", productPrice=" + productPrice + "]";
    }
    public class ProductController {

        private ProductDAO productDAO;  // Assume there's a ProductDAO for database operations

        // Constructor initializing the DAO
        public ProductController(ProductDAO productDAO) {
            this.productDAO = productDAO;
        }

        // Method to list all products (retrieve from database)
        public List<Product> listProduct() {
            return productDAO.getAllProducts();
        }

        // Method to view a single product based on its ID
        public Product viewProduct(int productID) {
            return productDAO.getProductByID(productID);
        }

        // Method to search for a product by name
        public Product searchProduct(String productName) {
            return productDAO.getProductByName(productName);
        }

        // You can also add other methods like adding, updating, or deleting products
    }

}


