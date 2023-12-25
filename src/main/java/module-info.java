module com.example.project2d {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.project2d to javafx.fxml;
    exports com.example.project2d;
}