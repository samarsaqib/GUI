module com.example.gui {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;

    opens com.example.gui to javafx.fxml;
    exports com.example.gui;
}