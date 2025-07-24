package org.exampleherogame.controller;

import com.example.herogame.dao.NationalDAO;
import com.example.herogame.dao.PlayerDAO;
import com.example.herogame.model.National;
import com.example.herogame.model.Player;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {

    @FXML private TableView<Player> playerTableView;
    @FXML private TableColumn<Player, Integer> colPlayerId;
    @FXML private TableColumn<Player, String> colPlayerName;
    @FXML private TableColumn<Player, Integer> colHighScore;
    @FXML private TableColumn<Player, Integer> colLevel;
    @FXML private TableColumn<Player, String> colNational;

    @FXML private TextField tfPlayerName;
    @FXML private TextField tfHighScore;
    @FXML private TextField tfLevel;
    @FXML private ComboBox<National> cbNational;

    // Search Field
    @FXML private TextField tfSearch;

    // DAOs for database access
    private final PlayerDAO playerDAO = new PlayerDAO();
    private final NationalDAO nationalDAO = new NationalDAO();

    private final ObservableList<Player> playerList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // 1. Setup Table Columns
        colPlayerId.setCellValueFactory(new PropertyValueFactory<>("playerId"));
        colPlayerName.setCellValueFactory(new PropertyValueFactory<>("playerName"));
        colHighScore.setCellValueFactory(new PropertyValueFactory<>("highScore"));
        colLevel.setCellValueFactory(new PropertyValueFactory<>("level"));
        colNational.setCellValueFactory(new PropertyValueFactory<>("nationalName"));

        // 2. Load Nationals into ComboBox
        cbNational.setItems(FXCollections.observableArrayList(nationalDAO.getAllNationals()));

        // 3. Load initial data
        handleShowAll();
    }

    @FXML
    void handleAddPlayer(ActionEvent event) {
        try {
            String name = tfPlayerName.getText();
            int score = Integer.parseInt(tfHighScore.getText());
            int level = Integer.parseInt(tfLevel.getText());
            National selectedNational = cbNational.getValue();

            if (name.isEmpty() || selectedNational == null) {
                showAlert(Alert.AlertType.ERROR, "Form Error!", "Please enter player name and select a national.");
                return;
            }

            Player newPlayer = new Player(name, score, level, selectedNational.getNationalId());
            if (playerDAO.insertPlayer(newPlayer)) {
                showAlert(Alert.AlertType.INFORMATION, "Success", "Player added successfully!");
                handleShowAll(); // Refresh table
                clearInputFields();
            } else {
                showAlert(Alert.AlertType.ERROR, "Database Error", "Failed to add player.");
            }
        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR, "Form Error!", "Please enter valid numbers for High Score and Level.");
        }
    }

    @FXML
    void handleDeletePlayer(ActionEvent event) {
        Player selectedPlayer = playerTableView.getSelectionModel().getSelectedItem();
        if (selectedPlayer == null) {
            showAlert(Alert.AlertType.WARNING, "Selection Error", "Please select a player to delete.");
            return;
        }

        Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION, "Delete " + selectedPlayer.getPlayerName() + "?", ButtonType.YES, ButtonType.NO);
        confirmation.showAndWait();

        if (confirmation.getResult() == ButtonType.YES) {
            if (playerDAO.deletePlayer(selectedPlayer.getPlayerId())) {
                showAlert(Alert.AlertType.INFORMATION, "Success", "Player deleted successfully!");
                handleShowAll(); // Refresh table
            } else {
                showAlert(Alert.AlertType.ERROR, "Database Error", "Failed to delete player.");
            }
        }
    }

    @FXML
    void handleSearch(ActionEvent event) {
        String name = tfSearch.getText();
        playerList.setAll(playerDAO.findPlayersByName(name));
        playerTableView.setItems(playerList);
    }

    @FXML
    void handleShowTop10() {
        playerList.setAll(playerDAO.getTop10Players());
        playerTableView.setItems(playerList);
    }

    @FXML
    void handleShowAll() {
        playerList.setAll(playerDAO.getAllPlayers());
        playerTableView.setItems(playerList);
    }

    private void clearInputFields() {
        tfPlayerName.clear();
        tfHighScore.clear();
        tfLevel.clear();
        cbNational.getSelectionModel().clearSelection();
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
