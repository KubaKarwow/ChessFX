module com.example.chessfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.chessfx to javafx.fxml;
    exports com.example.chessfx;
}