module com.freaver.goBang2 {
    requires  javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.bootstrapfx.core;
    requires org.kordamp.ikonli.core;
    requires eu.hansolo.tilesfx;
    requires org.apache.commons.io;
    requires fastjson;
    requires hutool.all;

    opens com.freaver.goBang2 to javafx.fxml;
    exports com.freaver.goBang2;
    exports com.freaver.goBang2.view;
    opens com.freaver.goBang2.view to javafx.fxml;
    exports com.freaver.goBang2.controller;
    opens com.freaver.goBang2.controller to javafx.fxml;
    exports com.freaver.goBang2.view.controller;
    opens com.freaver.goBang2.view.controller to javafx.fxml;
    exports com.freaver.goBang2.view.tableBean;
    opens com.freaver.goBang2.view.tableBean to javafx.fxml;
}