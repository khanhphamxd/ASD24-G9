package dao;

import model.Customer;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {
    private static final String DB_URL = "jdbc:sqlite:admin(pre-int)/customer/lib/customers.db";

    public void initDatabase() {
        try (Connection connection = DriverManager.getConnection(DB_URL);
             Statement statement = connection.createStatement()) {
            String createTableSQL = "CREATE TABLE IF NOT EXISTS customers (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "name TEXT NOT NULL," +
                    "email TEXT NOT NULL UNIQUE," +
                    "phone TEXT," +
                    "address TEXT);";
            statement.execute(createTableSQL);
            System.out.println("Database initialized and tables created.");
            
        } catch (SQLException e) {
            System.out.println("Error initializing the database: " + e.getMessage());
        }
    }

    public static List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            String sql = "SELECT * FROM customers";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Customer customer = new Customer(rs.getInt("customerID"),
                        rs.getString("username"), rs.getString("firstName"), rs.getString("lastName"),
                        rs.getString("email"), rs.getString("password"), rs.getString("gender"),
                        rs.getString("houseAddress"), rs.getString("phoneNum"), rs.getBoolean("isAdmin"));
                customers.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    public static Customer getCustomerById(int customerId) {
        Customer customer = null;
        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            String sql = "SELECT * FROM customers WHERE customerID=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, customerId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                customer = new Customer(rs.getInt("customerID"), rs.getString("username"),
                        rs.getString("firstName"), rs.getString("lastName"), rs.getString("email"),
                        rs.getString("password"), rs.getString("gender"), rs.getString("houseAddress"),
                        rs.getString("phoneNum"), rs.getBoolean("isAdmin"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    public void updateCustomer(Customer customer) {
        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            String sql = "UPDATE customers SET username=?, firstName=?, lastName=?, email=?, password=?, gender=?, houseAddress=?, phoneNum=?, isAdmin=? WHERE customerID=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, customer.getUsername());
            pstmt.setString(2, customer.getFirstName());
            pstmt.setString(3, customer.getLastName());
            pstmt.setString(4, customer.getEmail());
            pstmt.setString(5, customer.getPassword());
            pstmt.setString(6, customer.getGender());
            pstmt.setString(7, customer.getHouseAddress());
            pstmt.setString(8, customer.getPhoneNum());
            pstmt.setBoolean(9, customer.isAdmin());
            pstmt.setInt(10, customer.getCustomerID());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCustomer(int customerId) {
        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            String sql = "DELETE FROM customers WHERE customerID=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, customerId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createCustomer(Customer customer) {
        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            String sql = "INSERT INTO customers (username, firstName, lastName, email, password, gender, houseAddress, phoneNum, isAdmin) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, customer.getUsername());
            pstmt.setString(2, customer.getFirstName());
            pstmt.setString(3, customer.getLastName());
            pstmt.setString(4, customer.getEmail());
            pstmt.setString(5, customer.getPassword());
            pstmt.setString(6, customer.getGender());
            pstmt.setString(7, customer.getHouseAddress());
            pstmt.setString(8, customer.getPhoneNum());
            pstmt.setBoolean(9, customer.isAdmin());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean validateAdmin(String username, String password) {
        try (Connection connection = DriverManager.getConnection(DB_URL)) {
            String query = "SELECT COUNT(*) FROM customers WHERE username = ? AND password = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    resultSet.next();
                    return resultSet.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}


