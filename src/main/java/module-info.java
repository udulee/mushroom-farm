module lk.ijse.mushroom {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires static lombok;
    requires com.google.protobuf;
    requires jdk.accessibility;

    opens lk.ijse.mushroom.controller to javafx.fxml;
    opens lk.ijse.mushroom.dto.tm to javafx.base;
    opens lk.ijse.mushroom.dto to javafx.base;
    exports lk.ijse.mushroom;
}

