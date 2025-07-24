module com.example.herogame {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.example.herogame to javafx.fxml;
    exports com.example.herogame;
}