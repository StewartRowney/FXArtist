package com.example.fxartist2.artists;

import com.example.fxartist2.ArtistController;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage){
        ArtistController controller = new ArtistController();
        controller.run(stage);
    }
}
