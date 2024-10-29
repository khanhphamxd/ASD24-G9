package com.asd;

public class Product {
    private String productName;
    private int productId;
    private String productQuantity; // e.g., "500g", "1L", etc.
    private double productPrice;
    private String pricePer100gOr100ml; // e.g., "2.00 /100g" or "1.50 / 100ml"
    private String imageUrl;

    // Constructor
    public Product(String productName, int productId, String productQuantity, double productPrice, String pricePer100gOr100ml,String imageUrl) {
        this.productName = productName;
        this.productId = productId;
        this.productQuantity = productQuantity;
        this.productPrice = productPrice;
        this.pricePer100gOr100ml = pricePer100gOr100ml;
        this.imageUrl=imageUrl;
    }

    // Getter methods
    public String getProductName() {
        return productName;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductQuantity() {
        return productQuantity;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public String getPricePer100gOr100ml() {
        return pricePer100gOr100ml;
    }
    public String getImageUrl(){
        return imageUrl;
    }
}
