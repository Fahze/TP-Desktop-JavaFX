module com.fahze.demojavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires eu.hansolo.tilesfx;
    requires org.xerial.sqlitejdbc;

    requires org.slf4j;
    requires org.apache.logging.log4j;
    requires org.apache.logging.log4j.core;

    requires java.sql;

    opens com.fahze.demojavafx to javafx.fxml;
    exports com.fahze.demojavafx;
    exports com.fahze.demojavafx.utils;
    opens com.fahze.demojavafx.utils to javafx.fxml;
}