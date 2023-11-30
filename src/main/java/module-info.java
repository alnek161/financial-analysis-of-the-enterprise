module com.example.courseproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    requires org.controlsfx.controls;
    requires java.sql;
    requires lombok;
    requires java.persistence;
//    requires jakarta.persistence;
    requires org.hibernate.orm.core;
    opens com.example.courseproject.Controllers to javafx.fxml;
    opens com.example.courseproject to javafx.fxml;
    exports com.example.courseproject;
    exports com.example.courseproject.Server;
}

