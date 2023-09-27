package com.example.fxartist2;


import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;

public class ArtistController {

    private IArtistView ui = new ArtistView(this);

    public void run(Stage stage){
        ui.start(stage);
    }

    public boolean readFileInputAndDisplayArt(String userInput) {
        return draw(String.format("src/main/resources/%s.txt", userInput));
    }
    public boolean draw(String filePath) {
        StringBuilder art = new StringBuilder();
        try (Scanner fileScanner = new Scanner(new File(filePath))) {
            while (fileScanner.hasNextLine()) {
                art.append(fileScanner.nextLine()).append("\n");
            }
            ui.showArt(art.toString(), true);
            return true;
        } catch (FileNotFoundException fnfe) {
            ui.showArt("Sorry, I cannot draw that", false);
            return false;
        }
    }

    public void displayFolder(){
        File actual = new File("src/main/resources");
        for( File f : Objects.requireNonNull(actual.listFiles())){
            System.out.println( f.getName() );
        }
    }
}