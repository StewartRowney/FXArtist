module com.example.fxartist2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.fxartist2 to javafx.fxml;
    exports com.example.fxartist2;
}