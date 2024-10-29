package com.asd;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class OrderTrackController {
    OrderDAO orders = new OrderDAO();

    @FXML
    private Circle circle;
    @FXML
    private Label date;
    @FXML
    private Label orderid;
    @FXML
    private Label status;
    @FXML
    private Label details;
    @FXML
    private TextField orderIDField;
    
    @FXML
    private void changePage()throws IOException {
        App.setRoot("search");
    }
    
    @FXML
    private void findOrder() throws IOException {
       for (int i= 0; i<16;i++) {
            String ID = orderIDField.getText();
            int orderId = Integer.parseInt(ID);
            if (orderId == orders.getOrderId(i)){
                details.setText("Order details: " + orders.getOrderDetails(i));
                date.setText("Estimated order arrival: " + orders.getOrderDate(i));
                status.setText("Order Status: "+ orders.getOrderStatus(i));
                orderid.setText("Order " + orders.getOrderId(i));
                if(orders.getOrderStatus(i)=="Delivered"){
                    circle.setFill(Color.GREEN);
                    circle.setVisible(true);
                } else if(orders.getOrderStatus(i)=="Shipped"){
                    circle.setFill(Color.RED);
                    circle.setVisible(true);
                } else if(orders.getOrderStatus(i)=="Processing"){
                    circle.setFill(Color.ORANGE);
                    circle.setVisible(true);
                }
                else{
                    circle.setFill(Color.RED);
                    circle.setVisible(false);
                }
                break;

            }
        }
    }
}
 