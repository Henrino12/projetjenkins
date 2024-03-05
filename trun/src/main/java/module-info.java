module com.example.trun {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.trun to javafx.fxml;
    exports com.example.trun;
    exports com.example.trun.model;
    exports com.example.trun.repository;
}