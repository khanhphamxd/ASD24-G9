module com.asd {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.asd to javafx.fxml;
    exports com.asd;
}
