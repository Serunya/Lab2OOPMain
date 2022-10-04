module com.example.lab2oop5 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml.bind;


    exports com.example.lab2oop5;
    opens com.example.lab2oop5.xml.valcode to java.xml.bind;
    opens com.example.lab2oop5.xml to java.xml.bind;
    opens com.example.lab2oop5.xml.oneval to java.xml.bind;
    opens com.example.lab2oop5.xml.allval to java.xml.bind;
    opens com.example.lab2oop5 to java.xml.bind, javafx.fxml;
    exports com.example.lab2oop5.Table;
    opens com.example.lab2oop5.Table to java.xml.bind, javafx.fxml;
}