package com.asd;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {

    // Save a new order to the database
    public void saveOrder(Order order) {
        String sql = "INSERT INTO orders (id, items, status, deliveryDate) VALUES (?, ?, ?, ?)";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setInt(1, order.getOrderId());
            pstmt.setString(2, order.getOrderDetails());
            pstmt.setString(3, order.getOrderStatus());
            pstmt.setString(4, order.getOrderDate());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Retrieve an order by ID
    public Order getOrderById(int id) {
        Order order = null;
        String sql = "SELECT * FROM orders WHERE id = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    order = new Order(
                        rs.getInt("id"),
                        rs.getString("items"),
                        rs.getString("status"),
                        rs.getString("deliveryDate")
                    );
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }

    // Retrieve a list of all orders
    public List<Order> getAllOrders() {
        List<Order> orders = new ArrayList<>();
        String sql = "SELECT * FROM orders";

        try (Connection connection = DBConnection.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Order order = new Order(
                    rs.getInt("id"),
                    rs.getString("items"),
                    rs.getString("status"),
                    rs.getString("deliveryDate")
                );
                orders.add(order);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }
}
