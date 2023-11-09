module com.example.javafxtextcounterkotlin {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;


    opens com.example.javafxtextcounterkotlin to javafx.fxml;
    exports com.example.javafxtextcounterkotlin;
}