package model;
import java.util.List;
import java.util.*;

public interface CustomerDAO {
    //private ArrayList<Customer> customers;
        void addCustomer(Customer customer);
        Optional<Customer> getCustomerById(int customerID);
        void updateCustomer(Customer customer);
        void deleteCustomer(int customerID);
        List<Customer> getAllCustomers();
}
