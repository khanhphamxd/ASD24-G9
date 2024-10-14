package view;

import dao.CustomerDAO;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Customer;

import java.util.List;

public class AdminCustomerView {
    private CustomerDAO customerDAO = new CustomerDAO();
    private ListView<Customer> customerListView;
    private Scene scene;

    public AdminCustomerView() {
        customerListView = new ListView<>();
        updateCustomerList();

        Button addButton = new Button("Add Customer");
        addButton.setOnAction(e -> openCustomerForm(null));

        Button editButton = new Button("Edit Customer");
        editButton.setOnAction(e -> {
            Customer selectedCustomer = customerListView.getSelectionModel().getSelectedItem();
            if (selectedCustomer != null) {
                openCustomerForm(selectedCustomer);
            } else {
                showAlert("No customer selected", "Please select a customer to edit.");
            }
        });

        Button deleteButton = new Button("Delete Customer");
        deleteButton.setOnAction(e -> deleteCustomer());

        GridPane grid = new GridPane();
        grid.add(customerListView, 0, 0, 3, 1);
        grid.add(addButton, 0, 1);
        grid.add(editButton, 1, 1);
        grid.add(deleteButton, 2, 1);

        grid.setPadding(new Insets(10, 10, 10, 10));

        scene = new Scene(grid, 600, 400);
    }

    public void updateCustomerList() {
        customerListView.getItems().clear();
        List<Customer> customers = CustomerDAO.getAllCustomers();
        customerListView.getItems().addAll(customers);
    }

    private void deleteCustomer() {
        Customer selectedCustomer = customerListView.getSelectionModel().getSelectedItem();
        if (selectedCustomer != null) {
            customerDAO.deleteCustomer(selectedCustomer.getCustomerID());
            updateCustomerList();
        } else {
            showAlert("No customer selected", "Please select a customer to delete.");
        }
    }

    private void openCustomerForm(Customer customer) {
    CustomerFormView customerFormView = new CustomerFormView(customer, this);
    Stage currentStage = (Stage) scene.getWindow(); // Get the current window (Stage)
    currentStage.setScene(customerFormView.getScene()); // Switch to the form view
}


    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public Scene getScene() {
        return scene;
    }
}

