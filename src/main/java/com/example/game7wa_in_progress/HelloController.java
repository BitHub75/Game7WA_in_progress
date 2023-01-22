package com.example.game7wa_in_progress;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.scene.image.ImageView;
public class HelloController {


    public void clickbutton(ActionEvent Buttontap) {
        try {
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(("scene2.fxml")));
            Scene scene = new Scene(fxmlLoader.load(), 555, 357);
            stage.setTitle("menu");
            stage.setScene(scene);
            stage.show();
            ((Node) (Buttontap.getSource())).getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private Button buttonRules;
    @FXML
    private ImageView imageViewRules;

    @FXML
    public void buttonRules(ActionEvent event) {
        // charge l'image des règles à partir d'un fichier
        Image image = new Image(getClass().getResourceAsStream("/Images/images/fond/rules7wonders.jpg"));

        Dialog<Void> dialog = new Dialog<>();
        dialog.setTitle("Game rules");

        ImageView imageview = new ImageView(image);
        imageview.setFitHeight(600);
        imageview.setPreserveRatio(true);
        imageview.fitHeightProperty();
        imageview.fitWidthProperty();
        dialog.getDialogPane().setContent(imageview);
        dialog.setResizable(true);
        dialog.setOnCloseRequest(e -> {
            dialog.close();
        });
        ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
        //Adding buttons to the dialog pane
        dialog.getDialogPane().getButtonTypes().add(type);
        dialog.showAndWait();
    }

}
