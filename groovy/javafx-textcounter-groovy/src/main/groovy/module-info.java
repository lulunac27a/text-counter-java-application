module com.example.javafxtextcountergroovy {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.apache.groovy;


    opens com.example.javafxtextcountergroovy to javafx.fxml;
    exports com.example.javafxtextcountergroovy;
}