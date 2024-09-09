package model;
import java.util.List;
import java.util.*;

public class CustomerController {

    private final UserDAO customerDAO;

    public CustomerController(UserDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    // Create new customer
    public String addCustomer(Customer customer) {
        if (validateCustomer(customer)) {
            customerDAO.addCustomer(customer);
            return "Customer added successfully!";
        }
        return "Customer validation failed. Check the input data.";
    }

    // Retrieve by ID
    public Optional<Customer> getCustomerById(int customerID) {
        return customerDAO.getCustomerById(customerID);
    }

    // Update customer
    public String updateCustomer(int customerID, Customer updatedCustomer) {
        Optional<Customer> existingCustomerOpt = customerDAO.getCustomerById(customerID);

        if (existingCustomerOpt.isPresent() && validateCustomer(updatedCustomer)) {
            // Use the ID of the existing customer to ensure it's not changed
            updatedCustomer = new Customer(customerID, 
                                           updatedCustomer.getUsername(), 
                                           updatedCustomer.getFirstName(), 
                                           updatedCustomer.getLastName(),
                                           updatedCustomer.getEmail(), 
                                           updatedCustomer.getPassword(), 
                                           updatedCustomer.getGender(), 
                                           updatedCustomer.getHouseAddress(), 
                                           updatedCustomer.getPhoneNum());
            customerDAO.updateCustomer(updatedCustomer);
            return "Customer updated successfully!";
        }
        return "Customer not found or validation failed.";
    }

    // Delete by ID
    public String deleteCustomer(int customerID) {
        Optional<Customer> customerOpt = customerDAO.getCustomerById(customerID);
        if (customerOpt.isPresent()) {
            customerDAO.deleteCustomer(customerID);
            return "Customer deleted successfully!";
        }
        return "Customer not found.";
    }

    // Retrieve all
    public List<Customer> getAllCustomers() {
        return customerDAO.getAllCustomers();
    }

    // Validate customer 
    private boolean validateCustomer(Customer customer) {
        return Customer.validateUsername(customer.getUsername()) &&
               Customer.validateFirstName(customer.getFirstName()) &&
               Customer.validateLastName(customer.getLastName()) &&
               Customer.validateEmail(customer.getEmail()) &&
               Customer.validatePassword(customer.getPassword()) &&
               Customer.validateGender(customer.getGender()) &&
               Customer.validateHouseAddress(customer.getHouseAddress()) &&
               Customer.validatePhoneNum(customer.getPhoneNum());
    }
}
