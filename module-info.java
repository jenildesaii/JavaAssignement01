module game.compare {
    // Requires JavaFX modules for graphics, controls, and FXML
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;

    // Requires Java SQL module for database operations
    requires java.sql;

    // Exports the com.yourproject package to javafx.graphics
    exports com.yourproject to javafx.graphics;

    // Opens the com.yourproject package to javafx.fxml and javafx.base for reflection
    opens com.yourproject to javafx.fxml, javafx.base;
}
