package com.asd;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ItemCellController {
    @FXML
    private ImageView itemImage;
    @FXML
    private Label productName;
    @FXML
    private Label price;
    @FXML
    private Label quantitiy;
    @FXML
    private Label priceper;


    public void setData(Product product) {
        productName.setText(product.getProductName());
        price.setText("Price: $"+ product.getProductPrice());
        quantitiy.setText(product.getProductQuantity());
        priceper.setText(product.getPricePer100gOr100ml());
        itemImage.setImage(new Image(getClass().getResource("/com/asd/images/"+product.getImageUrl()).toExternalForm()));
    }
}
