module vocabvault {
    requires javafx.controls;
    requires javafx.fxml;

    opens vocabvault to javafx.fxml;
    exports vocabvault;
}
