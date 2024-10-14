package test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import dao.CustomerDAO;
import model.Customer;

public class CustomerDAOTest {

    private CustomerDAO customerDAO;

    @Before
    public void setUp() throws SQLException {
        customerDAO = new CustomerDAO();
        customerDAO.initDatabase(); // Ensure the database is initialized before tests
    }

    @Test
    public void testCreateCustomer() {
        Customer customer = new Customer(0, "johnDoe", "John", "Doe", "john@example.com", "password123", "Male", "123 Main St", "1234567890", false);
        customerDAO.createCustomer(customer);

        List<Customer> customers = CustomerDAO.getAllCustomers();
        assertEquals(1, customers.size());
        assertEquals("john@example.com", customers.get(0).getEmail());
    }

    @Test
    public void testGetAllCustomers() {
        Customer customer1 = new Customer(0, "johnDoe", "John", "Doe", "john@example.com", "password123", "Male", "123 Main St", "1234567890", false);
        Customer customer2 = new Customer(0, "janeDoe", "Jane", "Doe", "jane@example.com", "password456", "Female", "456 Main St", "0987654321", false);
        customerDAO.createCustomer(customer1);
        customerDAO.createCustomer(customer2);

        List<Customer> customers = CustomerDAO.getAllCustomers();
        assertEquals(2, customers.size());
    }

    @Test
    public void testGetCustomerById() {
        Customer customer = new Customer(0, "johnDoe", "John", "Doe", "john@example.com", "password123", "Male", "123 Main St", "1234567890", false);
        customerDAO.createCustomer(customer);

        Customer retrievedCustomer = customerDAO.getCustomerById(1); // Assuming 1 is the ID
        assertNotNull(retrievedCustomer);
        assertEquals("john@example.com", retrievedCustomer.getEmail());
    }

    @Test
    public void testUpdateCustomer() {
        Customer customer = new Customer(0, "johnDoe", "John", "Doe", "john@example.com", "password123", "Male", "123 Main St", "1234567890", false);
        customerDAO.createCustomer(customer);
        customer.setEmail("john.doe@newemail.com");
        customerDAO.updateCustomer(customer);

        Customer updatedCustomer = customerDAO.getCustomerById(1); // Assuming 1 is the ID
        assertEquals("john.doe@newemail.com", updatedCustomer.getEmail());
    }

    @Test
    public void testDeleteCustomer() {
        Customer customer = new Customer(0, "johnDoe", "John", "Doe", "john@example.com", "password123", "Male", "123 Main St", "1234567890", false);
        customerDAO.createCustomer(customer);
        customerDAO.deleteCustomer(1); // Assuming 1 is the ID

        Customer deletedCustomer = customerDAO.getCustomerById(1); // Assuming 1 is the ID
        assertNull(deletedCustomer);
    }

    @Test
    public void testValidateAdmin() {
        Customer customer = new Customer(0, "admin", "Admin", "User", "admin@example.com", "adminpass", "Male", "123 Admin St", "1234567890", true);
        customerDAO.createCustomer(customer);

        assertTrue(customerDAO.validateAdmin("admin", "adminpass"));
        assertFalse(customerDAO.validateAdmin("admin", "wrongpass"));
    }
}




