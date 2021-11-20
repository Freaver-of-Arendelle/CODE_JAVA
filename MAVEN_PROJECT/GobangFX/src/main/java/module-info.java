module com.example.gobangfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires org.apache.commons.io;
    requires fastjson;
    requires hutool.all;


    opens com.example.goBangFx to javafx.fxml;
    exports com.example.goBangFx;
    exports com.example.goBangFx.view;
    opens com.example.goBangFx.view to javafx.fxml;
    exports com.example.goBangFx.controller;
    opens com.example.goBangFx.controller to javafx.fxml;
    exports com.example.goBangFx.view.controller;
    opens com.example.goBangFx.view.controller to javafx.fxml;
    exports com.example.goBangFx.view.tableBean;
    opens com.example.goBangFx.view.tableBean to javafx.fxml;
}