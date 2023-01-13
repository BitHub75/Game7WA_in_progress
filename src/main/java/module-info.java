module com.example.game7wa_in_progress {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.game7wa_in_progress to javafx.fxml;
    exports com.example.game7wa_in_progress;
}