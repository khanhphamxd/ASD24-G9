module com.asd {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    
    opens com.asd to javafx.fxml;
    exports com.asd;
}
