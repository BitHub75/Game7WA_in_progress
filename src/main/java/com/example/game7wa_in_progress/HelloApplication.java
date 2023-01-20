package com.example.game7wa_in_progress;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;



public class HelloApplication extends Application{

    @Override
    public void start(Stage stage) throws IOException {
     FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("7wonders.fxml"));
     Scene scene = new Scene(fxmlLoader.load(),515,292);

     stage.setTitle("Lobby");
     stage.setScene(scene);
     stage.show();
     stage.setResizable(false);
     stage.setFullScreen(false);

    }

}
