module com.example.tp4base {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.tp4base to javafx.fxml;
    exports com.example.tp4base;
}