package com.yourproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Controller class for the TableView displaying game data.
 * @author jenil
 */
public class TableViewController {

    @FXML
    private TableView<Game> tableView;

    @FXML
    private TableColumn<Game, String> gameNameColumn;

    @FXML
    private TableColumn<Game, String> aspectColumn;

    @FXML
    private TableColumn<Game, Double> valueColumn;

    @FXML
    private TableColumn<Game, String> releaseDateColumn;

    @FXML
    private TableColumn<Game, String> platformsColumn;

    /**
     * Initializes the TableView and sets up column cell value factories.
     */
    @FXML
    public void initialize() {
        gameNameColumn.setCellValueFactory(new PropertyValueFactory<>("gameName"));
        aspectColumn.setCellValueFactory(new PropertyValueFactory<>("aspect"));
        valueColumn.setCellValueFactory(new PropertyValueFactory<>("value"));
        releaseDateColumn.setCellValueFactory(new PropertyValueFactory<>("releaseDate"));
        platformsColumn.setCellValueFactory(new PropertyValueFactory<>("platforms"));

        ObservableList<Game> gameList = FXCollections.observableArrayList();
        loadGameData(gameList);
        tableView.setItems(gameList);
    }

    /**
     * Loads game data from the database and populates the TableView.
     *
     * @param gameList The ObservableList to which the loaded games will be added.
     */
    private void loadGameData(ObservableList<Game> gameList) {
        String query = "SELECT * FROM games";

        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/game_compare", "root", "A1234b1234");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                String gameName = resultSet.getString("game_name");
                String aspect = resultSet.getString("aspect");
                double value = resultSet.getDouble("value");
                String releaseDate = resultSet.getDate("release_date").toString();
                String platforms = resultSet.getString("platforms");

                Game game = new Game(gameName, aspect, value, releaseDate, platforms);
                gameList.add(game);
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Handle SQL exceptions
        }
    }
}
