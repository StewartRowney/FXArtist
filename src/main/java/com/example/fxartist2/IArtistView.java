package com.example.fxartist2;

import javafx.stage.Stage;

public interface IArtistView {

    void start(Stage stage);

    void showArt(String art, boolean includeSignature);
}
