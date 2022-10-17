module com.example.entorngrafic {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;


    opens com.example.entorngrafic to javafx.fxml;
    exports com.example.entorngrafic;
    exports com.example.entorngrafic.presentacio;
    opens com.example.entorngrafic.presentacio to javafx.fxml;
}