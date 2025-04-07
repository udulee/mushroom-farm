module lk.ijse.mushroom {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens lk.ijse.mushroom to javafx.fxml;
    exports lk.ijse.mushroom;
}