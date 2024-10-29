package com.asd;


import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.geometry.Insets;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.paint.Color;
import javafx.geometry.Pos;


public class HomePageController {
    @FXML
    private Button cartButton;
    @FXML
    private GridPane itemGrid;
    @FXML
    private TextField searchField;

    private ObservableList<Product> products;
    private final ProductDAO productDAO = new ProductDAO();

    @FXML
    public void initialize() {
        // Fetch products from DAO
        products = FXCollections.observableArrayList(productDAO.getAllProducts());
        
        populateGrid(products); // Populate the grid with products

        // Search feature
        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
            itemGrid.getChildren().clear(); // Clear the grid before repopulating with search results
            populateGrid(filterItems(newValue));
        });
    }
    @FXML
    private void changePage()throws IOException {
        App.setRoot("cart");
    }

    private void populateGrid(ObservableList<Product> items) {
        itemGrid.getChildren().clear(); // Clear previous items or messages

        if (items.isEmpty()) {
            // Load and configure the placeholder image
            Image placeholderImage = new Image(getClass().getResource("/com/asd/images/no-product-found.jpg").toExternalForm());
            ImageView placeholderImageView = new ImageView(placeholderImage);
            placeholderImageView.setFitWidth(600); // Set width for the placeholder
            placeholderImageView.setFitHeight(450); // Set height for the placeholder
            placeholderImageView.setPreserveRatio(true); // Maintain aspect ratio
    
            // Center the image in the GridPane
            itemGrid.add(placeholderImageView, 0, 0);
            GridPane.setColumnSpan(placeholderImageView, 3); // Span across columns for centering
            GridPane.setRowSpan(placeholderImageView, 3);    // Span across rows for centering
            itemGrid.setAlignment(Pos.CENTER);               // Center everything in the grid
    
            return;
        }

        int columns = 3; // Number of items per row
        int row = 0;
        int col = 0;

        for (Product product : items) {
            VBox itemBox = createItemBox(product);

            // Add itemBox to GridPane
            itemGrid.add(itemBox, col, row);

            col++;
            if (col >= columns) {
                col = 0;
                row++;
            }
        }
    }
    private VBox createItemBox(Product product) {
        VBox vbox = new VBox(10); // Spacing between elements
        vbox.setPadding(new Insets(15)); // Padding around the VBox
        vbox.setBackground(new Background(new BackgroundFill(Color.ALICEBLUE, new CornerRadii(10), Insets.EMPTY)));
        vbox.setAlignment(Pos.CENTER);
        vbox.setStyle("-fx-border-color: #B3E5FC; -fx-border-radius: 10; -fx-border-width: 2; "
                     + "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.1), 10, 0, 0, 5);");
    
        // Image setup
        Image image = new Image(getClass().getResource("/com/asd/images/" + product.getImageUrl()).toExternalForm());
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(200);
        imageView.setFitHeight(200);
        imageView.setStyle("-fx-border-color: #B3E5FC; -fx-border-width: 1; -fx-border-radius: 5;");
    
        // Product Name Label
        Label nameLabel = new Label(product.getProductName());
        nameLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #0277BD;");
    
        // Price Label
        Label priceLabel = new Label("Price: $" + product.getProductPrice());
        priceLabel.setStyle("-fx-font-size: 16px; -fx-text-fill: #0288D1;");
    
        // Quantity Label
        Label quantityLabel = new Label("Available: " + product.getProductQuantity());
        quantityLabel.setStyle("-fx-font-size: 14px; -fx-text-fill: #555555;");
    
        // Price per unit Label
        Label pricePerLabel = new Label(product.getPricePer100gOr100ml());
        pricePerLabel.setStyle("-fx-font-size: 14px; -fx-text-fill: #555555;");
    
        // Add to Cart Button
        Button addToCart = new Button("Add To Cart");
        addToCart.setPrefWidth(150); // Set preferred width
        addToCart.setPrefHeight(40); // Set preferred height
        addToCart.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-weight: bold; -fx-border-radius: 20; -fx-background-radius: 20;");
        addToCart.setOnAction(event -> {
            Cart.add(product.getProductId());
            System.out.println("added to cart");
        });
    
        // Adding elements to VBox
        vbox.getChildren().addAll(imageView, nameLabel, priceLabel, quantityLabel, pricePerLabel, addToCart);
    
        return vbox;
    }
    

    private ObservableList<Product> filterItems(String searchText) {
        if (searchText == null || searchText.isEmpty()) {
            return products;
        }
        String lowerCaseFilter = searchText.toLowerCase();
        return products.filtered(product -> product.getProductName().toLowerCase().contains(lowerCaseFilter));
    }
}
