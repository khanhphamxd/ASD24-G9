package com.asd;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    // Save a new product to the database
    public void saveProduct(Product product) {
        String sql = "INSERT INTO products (id, name, quantity, price, unitPrice, image) VALUES (?, ?, ?, ?, ?, ?)";
        
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

                pstmt.setInt(1, product.getProductId());
                pstmt.setString(2, product.getProductName());
                pstmt.setString(3, product.getProductQuantity());
                pstmt.setDouble(4, product.getProductPrice());
                pstmt.setString(5, product.getPricePer100gOr100ml());
                pstmt.setString(6, product.getImageUrl());
            
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Retrieve a product by name
    public Product getProductByName(String name) {
        Product product = null;
        String sql = "SELECT * FROM products WHERE name = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, name);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    product = new Product(
                        rs.getString("name"),
                        rs.getInt("id"),
                        rs.getString("quantity"),
                        rs.getDouble("price"),
                        rs.getString("unitPrice"),
                        rs.getString("image")
                    );
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    public Product getProductById(int id) {
        Product product = null;
        String sql = "SELECT * FROM products WHERE id = ?";
    
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
    
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    product = new Product(
                        rs.getString("name"),
                        rs.getInt("id"),
                        rs.getString("quantity"),
                        rs.getDouble("price"),
                        rs.getString("unitPrice"),
                        rs.getString("image")
                    );
                }
            }
    
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }
    

    // Retrieve a list of all products
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM products";

        try (Connection connection = DBConnection.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Product product = new Product(
                    rs.getString("name"),
                    rs.getInt("id"),
                    rs.getString("quantity"),
                    rs.getDouble("price"),
                    rs.getString("unitPrice"),
                    rs.getString("image")
                );
                products.add(product);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
}
