module com.example.htttprequest {
    requires javafx.controls;
    requires javafx.fxml;
    requires httpcore;
    requires httpclient;

    opens com.example.htttprequest to javafx.fxml;
    exports com.example.htttprequest;
}