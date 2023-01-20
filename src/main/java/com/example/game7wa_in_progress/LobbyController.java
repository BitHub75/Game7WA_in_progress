package com.example.game7wa_in_progress;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;

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
}
