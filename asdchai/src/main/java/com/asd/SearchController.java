package com.asd;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;

public class SearchController {
    @FXML
    private ImageView itemImage;
    @FXML 
    private TextField searchIDField;
    @FXML
    private Label productname;
    @FXML
    private Label price;
    @FXML
    private Label quantitiy;
    @FXML
    private Label priceper;
    ProductDAO productDAO = new ProductDAO();

    @FXML
    private void changePage()throws IOException {
        App.setRoot("order-track");
    }

    @FXML
    private void searchProduct() throws IOException {
            String Name = searchIDField.getText();
            Product product = productDAO.getProductByName(Name);
                productname.setText(product.getProductName());
                price.setText("Price: $"+ product.getProductPrice());
                quantitiy.setText(product.getProductQuantity());
                priceper.setText(product.getPricePer100gOr100ml());
                itemImage.setImage(new Image(getClass().getResource("/com/asd/images/"+product.getImageUrl()).toExternalForm()));
                itemImage.setVisible(true);
    }
}
    
