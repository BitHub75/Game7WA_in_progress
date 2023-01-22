package com.example.game7wa_in_progress;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import java.io.IOException;

public class LobbyController {
    ObservableList<Integer> numbers = FXCollections.observableArrayList(2, 3, 4, 5, 6, 7);

    @FXML
    private ChoiceBox<Integer> choiceBoxNumbers;

    @FXML
    public void initialize() {
        // Initialisation de la ChoiceBox

        choiceBoxNumbers.setItems(numbers);
        choiceBoxNumbers.setValue(2);
    }

    @FXML
    public void onChoiceBoxSelectionChanged(ActionEvent choiceboxtap) {
        int selectedNumber = choiceBoxNumbers.getValue();
    }

    public void clickbutton2(ActionEvent Buttontap2) {
        try {
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(("scene3.fxml")));
            Scene scene = new Scene(fxmlLoader.load(), 728, 477);
            stage.setTitle("Plateau de Jeu");
            stage.setScene(scene);
            stage.show();
            ((Node) (Buttontap2.getSource())).getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
