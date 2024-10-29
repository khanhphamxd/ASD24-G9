package com.asd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBInitialize {

    public static void initialize() {
        try (Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement()) {

            String checkProductsTableSQL = "SELECT 1 FROM SYS.SYSTABLES WHERE TABLENAME = 'PRODUCTS'";
            ResultSet rs = statement.executeQuery(checkProductsTableSQL);
            if (!rs.next()) {
                // Create products table if it doesn't exist
                String createProductsTableSQL = "CREATE TABLE products ("
                        + "id INT PRIMARY KEY, "
                        + "name VARCHAR(255), "
                        + "quantity VARCHAR(50), "
                        + "price DECIMAL(10, 2), "
                        + "unitPrice VARCHAR(50), "
                        + "image VARCHAR(255))";
                statement.executeUpdate(createProductsTableSQL);
            }
            
            // Check if orders table exists
            String checkOrdersTableSQL = "SELECT 1 FROM SYS.SYSTABLES WHERE TABLENAME = 'ORDERS'";
            rs = statement.executeQuery(checkOrdersTableSQL);
            if (!rs.next()) {
                // Create orders table if it doesn't exist
                String createOrdersTableSQL = "CREATE TABLE orders ("
                        + "id INT PRIMARY KEY, "
                        + "items VARCHAR(1000), "
                        + "status VARCHAR(50), "
                        + "deliveryDate VARCHAR(50))";
                statement.executeUpdate(createOrdersTableSQL);
            }

            String checkCustomersTableSQL = "SELECT 1 FROM SYS.SYSTABLES WHERE TABLENAME = 'CUSTOMERS'";
            rs = statement.executeQuery(checkCustomersTableSQL);
            if (!rs.next()) {
                String createCustomersTableSQL = "CREATE TABLE customers ("
                + "customerId INT PRIMARY KEY, "
                + "firstName VARCHAR(255), "
                + "lastName VARCHAR(255), "
                + "email VARCHAR(255), "
                + "password VARCHAR(255), "
                + "address VARCHAR(500), "
                + "phoneNumber VARCHAR(50))";
                statement.executeUpdate(createCustomersTableSQL);
            }

            // Check if products data exists
            String checkProductsDataSQL = "SELECT COUNT(*) FROM products";
            rs = statement.executeQuery(checkProductsDataSQL);
            if (rs.next() && rs.getInt(1) == 0) {
                // Insert sample product data if table is empty
                insertSampleProducts();
            }

            // Check if orders data exists
            String checkOrdersDataSQL = "SELECT COUNT(*) FROM orders";
            rs = statement.executeQuery(checkOrdersDataSQL);
            if (rs.next() && rs.getInt(1) == 0) {
                // Insert sample order data if table is empty
                insertSampleOrders();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void insertSampleProducts() {
        // Sample data
        Product[] products = new Product[20];
        products[0] = new Product("Frozen Pizza", 120, "350g", 4.00, "1.14$ / 100g", "No_Image_Available.jpg");
        products[1] = new Product("Carrots", 103, "1kg", 2.50, "0.25$ / 100g", "No_Image_Available.jpg");
        products[2] = new Product("Eggs", 104, "12 pack", 3.60, "0.30$ / egg", "eggs.jpg");
        products[3] = new Product("Rice", 105, "2kg", 5.00, "0.25$ / 100g", "Rice.jpeg");
        products[4] = new Product("Olive Oil", 106, "500ml", 6.00, "1.20$ / 100ml", "Olive oil.jpg");
        products[5] = new Product("Shampoo", 107, "250ml", 3.50, "1.40$ / 100ml", "Shampoo-HNS.jpg");
        products[6] = new Product("Chicken Breast", 109, "500g", 7.00, "1.40$ / 100g", "No_Image_Available.jpg");
        products[7] = new Product("Tomato", 110, "250g", 4.50, "0.60$ / 100g", "tomato.jpg");
        products[8] = new Product("Orange Juice", 112, "1L", 2.80, "0.28$ / 100ml", "No_Image_Available.jpg");
        products[9] = new Product("Yogurt", 113, "500g", 3.00, "0.60$ / 100g", "Yoghurt.jpeg");
        products[10] = new Product("Cereal", 114, "400g", 3.50, "0.88$ / 100g", "No_Image_Available.jpg");
        products[11] = new Product("Toothpaste", 115, "100ml", 2.00, "2.00$ / 100ml", "No_Image_Available.jpg");
        products[12] = new Product("Ground Beef", 116, "1kg", 9.00, "0.90$ / 100g", "No_Image_Available.jpg");
        products[13] = new Product("Dish Soap", 118, "500ml", 2.20, "0.44$ / 100ml", "No_Image_Available.jpg");
        products[14] = new Product("Bananas", 119, "1kg", 2.80, "0.28$ / 100g", "banana.jpg");
        products[15] = new Product("Milk", 102, "1L", 1.50, "0.15$ / 100ml", "Milk.png");
        products[16] = new Product("Butter", 101, "250g", 4.00, "1.60$ / 100g", "Butter.png");
        products[17] = new Product("Apples", 108, "1kg", 3.00, "0.30$ / 100g", "Apples.png");
        products[18] = new Product("Pasta", 111, "500g", 2.20, "0.44$ / 100g", "Pasta.png");
        products[19] = new Product("Ice Cream", 117, "1L", 5.50, "0.55$ / 100ml", "Ice Cream.png");
        
        // Insert each product into the database
        String insertSQL = "INSERT INTO products (id, name, quantity, price, unitPrice, image) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(insertSQL)) {

            for (Product product : products) {
                pstmt.setInt(1, product.getProductId());
                pstmt.setString(2, product.getProductName());
                pstmt.setString(3, product.getProductQuantity());
                pstmt.setDouble(4, product.getProductPrice());
                pstmt.setString(5, product.getPricePer100gOr100ml());
                pstmt.setString(6, product.getImageUrl());
                pstmt.addBatch();
            }
            pstmt.executeBatch();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private static void insertSampleOrders() {
        // Sample orders data
        Order[] orders = new Order[16];
        orders[0] = new Order(101, "\n Butter 250g\n Carrot 1kg\n Jasmine Rice", "Shipped","12 Desember");
        orders[1] = new Order(102, "\n Mineral Water 24", "Processing", "25 September");
        orders[2] = new Order(103, "\n Doritos Chips\n Hummus Dips\n Coke1L", "Delivered", "5 Febuary");
        orders[3] = new Order(104, "\n Apples 2kg\n Bananas 1kg\n Oranges 1kg", "Shipped", "18 October");
        orders[4] = new Order(105, "\n Whole Wheat Bread\n Peanut Butter 500g", "Processing", "20 September");
        orders[5] = new Order(106, "\n Chicken Breast 1kg\n Ground Beef 500g\n Salmon Fillet 300g", "Delivered", "10 February");
        orders[6] = new Order(107, "\n Milk 1L\n Eggs 12 pack\n Butter 500g", "Shipped", "7 October");
        orders[7] = new Order(108, "\n Pasta 500g\n Tomato Sauce 2 jars\n Parmesan Cheese", "Processing", "2 September");
        orders[8] = new Order(109, "\n Cereal 500g\n Almond Milk 1L\n Honey", "Delivered", "12 December");
        orders[9] = new Order(110, "\n Shampoo\n Soap 2 bars\n Toothpaste", "Shipped", "30 November");
        orders[10] = new Order(111, "\n Frozen Pizza\n Ice Cream 1L\n Garlic Bread", "Delivered", "15 January");
        orders[11] = new Order(112, "\n Rice 2kg\n Lentils 1kg\n Olive Oil 500ml", "Processing", "28 October");
        orders[12] = new Order(113, "\n Coffee Beans 250g\n Green Tea 20 bags\n Sugar 1kg", "Shipped", "5 November");
        orders[13] = new Order(114, "\n Tissues 4 pack\n Toilet Paper 6 pack", "Delivered", "20 August");
        orders[14] = new Order(115, "\n Dish Soap\n Sponge 2 pack\n Garbage Bags", "Shipped", "25 September");
        orders[15] = new Order(116, "\n Orange Juice 1L\n Bagels 6 pack\n Cream Cheese", "Processing", "10 October");

        String insertOrderSQL = "INSERT INTO orders (id, items, status, deliveryDate) VALUES (?, ?, ?, ?)";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(insertOrderSQL)) {

            for (Order order : orders) {
                pstmt.setInt(1, order.getOrderId());
                pstmt.setString(2, order.getOrderDetails());
                pstmt.setString(3, order.getOrderStatus());
                pstmt.setString(4, order.getOrderDate());
                pstmt.addBatch();
            }
            pstmt.executeBatch();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
