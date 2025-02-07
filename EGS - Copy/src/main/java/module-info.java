module com.egs.egs {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.egs.egs to javafx.fxml;
    exports com.egs.egs;
}