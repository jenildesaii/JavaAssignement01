package com.yourproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;

import java.io.IOException;

/**
 * The main class that starts the JavaFX application.
 * @author jenil
 */
public class Main extends Application {

    /**
     * The main entry point for all JavaFX applications.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        launch();
    }

    /**
     * Starts the JavaFX application.
     *
     * @param stage The primary stage for this application.
     * @throws IOException If the main-view.fxml file or style.css file cannot be loaded.
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/com/yourproject/main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        scene.getStylesheets().add(getClass().getResource("/com/yourproject/style.css").toExternalForm());
        stage.setTitle("Game Comparison: Valorant vs PUBG");
        stage.getIcons().add(new Image(Main.class.getResourceAsStream("/com/yourproject/icon.png"))); // Add your custom icon
        stage.setScene(scene);
        stage.show();
    }
}
