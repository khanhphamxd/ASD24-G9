package com.asd;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
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
    ProductDAO products = new ProductDAO();

    @FXML
    private void changePage()throws IOException {
        App.setRoot("order-track");
    }

    @FXML
    private void searchProduct() throws IOException {
        System.out.println("press");
        for (int i= 0; i<20;i++) {
            String Name = searchIDField.getText();
            System.out.println(Name);
            if (Name.equalsIgnoreCase(products.getProductName(i))){
                productname.setText(products.getProductName(i));
                price.setText("Price: $"+ products.getProductPrice(i));
                quantitiy.setText(products.getProductQuantity(i));
                priceper.setText(products.getPricePer100gOr100ml(i));
                itemImage.setImage(new Image(getClass().getResource("/com/asd/images/"+products.getImageUrl(i)).toExternalForm()));
                itemImage.setVisible(true);
            }
        }
    }
    
}