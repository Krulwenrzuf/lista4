module com.example.lista4_1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.pascal to javafx.fxml;
    exports com.example.pascal;
}