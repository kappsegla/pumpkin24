module com.example.pumpkin {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens com.example.pumpkin to javafx.fxml;
    exports com.example.pumpkin;
    exports com.example.pumpkin.controls;
    opens com.example.pumpkin.controls to javafx.fxml;
}
