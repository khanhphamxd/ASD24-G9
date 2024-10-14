package view;

import dao.CustomerDAO;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Customer;

public class CustomerFormView {

    private Scene scene;
    private TextField usernameField, firstNameField, lastNameField, emailField, passwordField,
            genderField, houseAddressField, phoneNumField;
    private CheckBox isAdminCheckBox;
    private CustomerDAO customerDAO = new CustomerDAO();
    private Customer customer; // Pass the customer (or null for new)
    private AdminCustomerView adminCustomerView; // Reference to return to

    public CustomerFormView(Customer customer, AdminCustomerView adminCustomerView) {
        this.customer = customer;
        this.adminCustomerView = adminCustomerView;

        // Form Fields
        usernameField = new TextField();
        firstNameField = new TextField();
        lastNameField = new TextField();
        emailField = new TextField();
        passwordField = new TextField();
        genderField = new TextField();
        houseAddressField = new TextField();
        phoneNumField = new TextField();
        isAdminCheckBox = new CheckBox("Admin");

        // If editing, populate fields with the existing customer data
        if (customer != null) {
            populateFields(customer);
        }

        Button saveButton = new Button("Save");
        saveButton.setOnAction(e -> saveCustomer());

        Button cancelButton = new Button("Cancel");
        cancelButton.setOnAction(e -> cancelForm());

        // Layout
        GridPane grid = new GridPane();
        grid.add(new Label("Username:"), 0, 0);
        grid.add(usernameField, 1, 0);
        grid.add(new Label("First Name:"), 0, 1);
        grid.add(firstNameField, 1, 1);
        grid.add(new Label("Last Name:"), 0, 2);
        grid.add(lastNameField, 1, 2);
        grid.add(new Label("Email:"), 0, 3);
        grid.add(emailField, 1, 3);
        grid.add(new Label("Password:"), 0, 4);
        grid.add(passwordField, 1, 4);
        grid.add(new Label("Gender:"), 0, 5);
        grid.add(genderField, 1, 5);
        grid.add(new Label("Address:"), 0, 6);
        grid.add(houseAddressField, 1, 6);
        grid.add(new Label("Phone Number:"), 0, 7);
        grid.add(phoneNumField, 1, 7);
        grid.add(isAdminCheckBox, 0, 8);
        grid.add(saveButton, 0, 9);
        grid.add(cancelButton, 1, 9);

        scene = new Scene(grid, 400, 400); // Create scene
    }

    private void populateFields(Customer customer) {
        usernameField.setText(customer.getUsername());
        firstNameField.setText(customer.getFirstName());
        lastNameField.setText(customer.getLastName());
        emailField.setText(customer.getEmail());
        passwordField.setText(customer.getPassword());
        genderField.setText(customer.getGender());
        houseAddressField.setText(customer.getHouseAddress());
        phoneNumField.setText(customer.getPhoneNum());
        isAdminCheckBox.setSelected(customer.isAdmin());
    }

    private void saveCustomer() {
        // Save or update customer
        if (customer == null) {
            customer = new Customer(
                0,  // New customer, ID will be auto-incremented
                usernameField.getText(),
                firstNameField.getText(),
                lastNameField.getText(),
                emailField.getText(),
                passwordField.getText(),
                genderField.getText(),
                houseAddressField.getText(),
                phoneNumField.getText(),
                isAdminCheckBox.isSelected()
            );
            customerDAO.createCustomer(customer);
        } else {
            customer.setUsername(usernameField.getText());
            customer.setFirstName(firstNameField.getText());
            customer.setLastName(lastNameField.getText());
            customer.setEmail(emailField.getText());
            customer.setPassword(passwordField.getText());
            customer.setGender(genderField.getText());
            customer.setHouseAddress(houseAddressField.getText());
            customer.setPhoneNum(phoneNumField.getText());
            customer.setAdmin(isAdminCheckBox.isSelected());
            customerDAO.updateCustomer(customer);
        }

        // Return to the AdminCustomerView
        adminCustomerView.updateCustomerList();
        Scene adminScene = adminCustomerView.getScene(); 
        Stage currentStage = (Stage) scene.getWindow();
        currentStage.setScene(adminScene); // Switch back to the customer view
    }

    private void cancelForm() {
        // Simply return to the AdminCustomerView without saving
        Scene adminScene = adminCustomerView.getScene();
        Stage currentStage = (Stage) scene.getWindow();
        currentStage.setScene(adminScene);
    }

    public Scene getScene() {
        return scene; // Return this form's scene
    }
}
