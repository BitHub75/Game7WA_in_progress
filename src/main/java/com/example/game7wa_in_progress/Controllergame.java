package com.example.game7wa_in_progress;


import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.scene.image.ImageView;
public class Controllergame {

    public void initialize(Game game) throws FileNotFoundException{

    }
    @FXML
    void labelanyprogresstoken (MouseEvent event){
        helplabel.setText("pile de jetons progrès");
    }

}
