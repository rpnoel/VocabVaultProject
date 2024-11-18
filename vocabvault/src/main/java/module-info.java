module com.vocabvault {
    requires javafx.controls;
    requires javafx.fxml;
    requires junit;
    requires json.simple;
    requires jlayer;
    requires software.amazon.awssdk.core;
    requires software.amazon.awssdk.services.polly;
    requires software.amazon.awssdk.regions;
    requires software.amazon.awssdk.utils;
    requires org.slf4j;
    requires org.slf4j.simple;
    requires software.amazon.awssdk.awscore;
    requires software.amazon.eventstream;

    opens com.vocabvault to javafx.fxml;
    exports com.vocabvault;

    opens com.controllers to javafx.fxml;
    exports com.controllers;

    opens com.narraration to javafx.fxml;
    exports com.narraration;

    opens com.model to javafx.fxml;
    exports com.model;
}