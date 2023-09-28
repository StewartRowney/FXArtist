package com.example.fxartist2;


import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;

public class ArtistController {

    private final ArtistView ui = new ArtistView(this);
    private final ArtistFactory factory = new ArtistFactory();

    public void run(Stage stage){
        ui.start(stage);
    }

    public void draw(String artistName, String art) {
        IArtist artist = factory.generateArtist(artistName);
        ui.showArt(artist, artist.draw(art));
    }

}