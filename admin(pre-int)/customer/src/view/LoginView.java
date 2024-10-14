package view;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import dao.CustomerDAO;
import javafx.stage.Stage;

public class LoginView {
    private TextField usernameField;
    private PasswordField passwordField;
    private Button loginButton;
    private Label messageLabel;
    private CustomerDAO customerDAO;
    private Scene scene; // Store the scene

    public LoginView(Stage primaryStage) {
        System.out.println("LoginView started!");
        customerDAO = new CustomerDAO(); // Initialize CustomerDAO

        usernameField = new TextField();
        usernameField.setPromptText("Username");
        
        passwordField = new PasswordField();
        passwordField.setPromptText("Password");
        
        loginButton = new Button("Login");
        messageLabel = new Label();

        loginButton.setOnAction(e -> handleLogin(primaryStage));

        VBox layout = new VBox(10);
        layout.getChildren().addAll(usernameField, passwordField, loginButton, messageLabel);
        
        scene = new Scene(layout, 300, 200); 
    }

    public Scene getScene() {
        return scene; // Return the scene for the main application to use
    }

    private void handleLogin(Stage primaryStage) {
        String username = usernameField.getText().trim();
        String password = passwordField.getText().trim();

        // Validation Logic
        if (username.isEmpty() || password.isEmpty()) {
            messageLabel.setText("Username and Password cannot be empty!");
            return;
        }

        // Check credentials in the database using CustomerDAO
        if (customerDAO.validateAdmin(username, password)) {
            messageLabel.setText("Login successful!");

            // Create a new instance of CustomerView
            AdminCustomerView customerView = new AdminCustomerView();
            primaryStage.setScene(customerView.getScene()); // Switch to CustomerView

        } else {
            messageLabel.setText("Invalid Username or Password.");
        }
    }
}
