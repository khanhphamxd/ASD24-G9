package com.asd;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.io.IOException;

public class LoginController {



    @FXML
    private TextField firstNameField;

    @FXML
    private TextField lastNameField;

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField addressField;

    @FXML
    private TextField phoneNumberField;

    @FXML
    private Button loginButton;
    
    @FXML
    private Label statusLabel;

    private final CustomerDAO customerDAO = new CustomerDAO(); // Assuming CustomerDAO is already defined

    @FXML
    private void initialize() {
        // Set up any necessary initialization here, if needed
    }

    @FXML
    private void registerCustomer() {
        try {
            // Retrieve values from text fields
            int customerId = 123123;
            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            String email = emailField.getText();
            String password = passwordField.getText();
            String address = addressField.getText();
            String phoneNumber = phoneNumberField.getText();

            // Create a new Customer object
            Customer customer = new Customer(customerId, firstName, lastName, email, password, address, phoneNumber);

            // Save the customer using CustomerDAO
            customerDAO.saveCustomer(customer);

            // Optionally, clear the fields or show a confirmation message
            clearFields();
            System.out.println("Customer registered successfully!");
            //change page
            changePage();
            

        } catch (NumberFormatException e) {
            System.out.println("Invalid customer ID. Please enter a numeric value.");
            statusLabel.setText("Invalid customer ID. Please enter a numeric value.");
            statusLabel.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error registering customer.");
            statusLabel.setText("Error registering customer.");
            statusLabel.setVisible(true);
        }
        
        
        
    }
    
    private void changePage()throws IOException {
        App.setRoot("home");
    }

    private void clearFields() {
        firstNameField.clear();
        lastNameField.clear();
        emailField.clear();
        passwordField.clear();
        addressField.clear();
        phoneNumberField.clear();
    }
}
