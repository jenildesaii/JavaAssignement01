package com.yourproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.Node;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * Controller class for the main application view.
 * @author jenil
 */
public class MainController {

    @FXML
    private BarChart<String, Number> gameChart;

    @FXML
    private Button switchButton;

    /**
     * Initializes the controller class. This method is automatically called
     * after the FXML file has been loaded.
     */
    @FXML
    public void initialize() {
        loadChartData(); // Load chart data on initialization
    }

    /**
     * Loads data from the database and populates the BarChart.
     */
    private void loadChartData() {
        ObservableList<XYChart.Series<String, Number>> chartData = FXCollections.observableArrayList();

        XYChart.Series<String, Number> valorantSeries = new XYChart.Series<>();
        valorantSeries.setName("Valorant");

        XYChart.Series<String, Number> pubgSeries = new XYChart.Series<>();
        pubgSeries.setName("PUBG");

        String query = "SELECT * FROM games";

        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/game_comparison", "root", "A1234b1234");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            // Fetch data from ResultSet and populate series
            while (resultSet.next()) {
                String gameName = resultSet.getString("game_name");
                String aspect = resultSet.getString("aspect");
                double value = resultSet.getDouble("value");

                if (gameName.equals("Valorant")) {
                    valorantSeries.getData().add(new XYChart.Data<>(aspect, value));
                } else if (gameName.equals("PUBG")) {
                    pubgSeries.getData().add(new XYChart.Data<>(aspect, value));
                }
            }

            // Add series data to the chart
            chartData.addAll(valorantSeries, pubgSeries);
            gameChart.getData().addAll(chartData);

            // Set colors for the series bars
            for (XYChart.Data<String, Number> data : valorantSeries.getData()) {
                data.getNode().setStyle("-fx-bar-fill: red;");
            }

            for (XYChart.Data<String, Number> data : pubgSeries.getData()) {
                data.getNode().setStyle("-fx-bar-fill: orange;");
            }

            // Customize the legend items' colors
            setLegendColor("Valorant", "red");
            setLegendColor("PUBG", "yellow");

        } catch (SQLException e) {
            e.printStackTrace(); // Handle SQL exceptions
        }
    }

    /**
     * Sets the color of the legend item for the specified series.
     *
     * @param seriesName The name of the series whose legend item's color is to be set.
     * @param color      The color to set for the legend item.
     */
    private void setLegendColor(String seriesName, String color) {
        for (Node node : gameChart.lookupAll(".chart-legend-item")) {
            if (node.lookup(".chart-legend-item-symbol") != null && node.lookup(".chart-legend-item-label") != null) {
                Node symbol = node.lookup(".chart-legend-item-symbol");
                Node label = node.lookup(".chart-legend-item-label");
                if (label.getAccessibleText() != null && label.getAccessibleText().equals(seriesName)) {
                    symbol.setStyle("-fx-background-color: " + color + ";");
                }
            }
        }
    }

    /**
     * Switches the application view to a table view when the switchButton is clicked.
     */
    @FXML
    private void switchToTableView() {
        try {
            // Load TableView FXML file
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/com/yourproject/table-view.fxml"));
            Scene tableScene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) switchButton.getScene().getWindow(); // Get current stage
            stage.setScene(tableScene); // Set the new scene in the stage
        } catch (IOException e) {
            e.printStackTrace(); // Handle FXML loading exception
        }
    }
}
