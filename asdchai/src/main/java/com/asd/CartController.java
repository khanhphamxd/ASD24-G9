package com.asd;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

import javafx.scene.image.Image;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.util.ArrayList;

public class CartController {

    @FXML
    private ListView<Product> itemListView;
    @FXML
    private TextField searchField;
    @FXML
    private Label total;
    @FXML
    private Label made;
    @FXML
    private Button trackOrderButton;


    private ObservableList<Product> products;
    ProductDAO productDAO = new ProductDAO();


    @FXML
    public void initialize() {
        ArrayList<Product> p  = new ArrayList<Product>();  
        double total1 = 0;
        for (Integer i : Cart.list) {
            p.add(productDAO.getProductById(i));
            total1 += productDAO.getProductById(i).getProductPrice();
        }
        
           products=FXCollections.observableArrayList(p);
        total.setText("$ "+ total1);
        itemListView.setItems(products);

        itemListView.setCellFactory(lv -> new ListCell<>() {
            private HBox hBox;
            private ItemCellController cellController;
            {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("item-cell.fxml"));
                    hBox = loader.load();
                    cellController = loader.getController();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        
            @Override
            protected void updateItem(Product product, boolean empty) {
                super.updateItem(product, empty);
                if (empty || product == null) {
                    setGraphic(null);
                } else {
                    cellController.setData(product);
                    setGraphic(hBox);
                }
            }
        });

        // Search feature
        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
            itemListView.setItems(filterItems(newValue));
        });
    }

    private ObservableList<Product> filterItems(String searchText) {
        if (searchText == null || searchText.isEmpty()) {
            return products;
        }
        String lowerCaseFilter = searchText.toLowerCase();
        return products.filtered(product -> product.getProductName().toLowerCase().contains(lowerCaseFilter));
    }
    @FXML
    private void changePage()throws IOException {
        App.setRoot("order-track");
    }
    @FXML
    private void makeOrder(){
        made.setVisible(true);
        trackOrderButton.setVisible(true);
    }
}
