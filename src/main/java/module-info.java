module com.example.choreslist {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.choreslist to javafx.fxml;
    exports com.example.choreslist;
}