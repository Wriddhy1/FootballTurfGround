module com.oop.footballturfground {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.oop.footballturfground to javafx.fxml;
    exports com.oop.footballturfground;
}