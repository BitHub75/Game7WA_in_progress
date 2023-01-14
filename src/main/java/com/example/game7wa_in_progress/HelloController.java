package com.example.game7wa_in_progress;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController{



    public void clickbutton(ActionEvent Buttontap) {
        try {
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(("scene2.fxml")));
            Scene scene = new Scene(fxmlLoader.load(), 515, 292);
            stage.setTitle("menu");
            stage.setScene(scene);
            stage.show();
            ((Node) (Buttontap.getSource())).getScene().getWindow().hide();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }

    //


}
