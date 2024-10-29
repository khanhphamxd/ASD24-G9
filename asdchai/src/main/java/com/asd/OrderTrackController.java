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
        App.setRoot("home");
    }
    
    @FXML
    private void findOrder() throws IOException {
       
            String ID = orderIDField.getText();
            int orderId = Integer.parseInt(ID);
            Order order = orders.getOrderById(orderId);
                details.setText("Order details: " + order.getOrderDetails());
                date.setText("Estimated order arrival: " + order.getOrderDate());
                status.setText("Order Status: "+ order.getOrderStatus());
                orderid.setText("Order " + order.getOrderId());
                System.out.println(order.getOrderStatus());
                if(order.getOrderStatus().equals("Delivered")){
                    circle.setFill(Color.GREEN);
                    circle.setVisible(true);
                } else if(order.getOrderStatus().equals("Shipped")){
                    circle.setFill(Color.RED);
                    circle.setVisible(true);
                } else if(order.getOrderStatus().equals("Processing")){
                    circle.setFill(Color.ORANGE);
                    circle.setVisible(true);
                }
                else{
                    circle.setFill(Color.RED);
                    circle.setVisible(false);
                }
    
        
    }
}
 