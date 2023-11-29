module com.example.javafxtextcounter {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javafxtextcounter to javafx.fxml;
    exports com.example.javafxtextcounter;
}