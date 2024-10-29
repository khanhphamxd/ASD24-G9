module advanced.software.dev {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.firebase;

    opens advanced.software.dev to javafx.fxml;
    exports advanced.software.dev;
}
