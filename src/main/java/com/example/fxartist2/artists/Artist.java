package com.example.fxartist2.artists;

import com.example.fxartist2.IArtist;
import javafx.scene.paint.Color;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Artist implements IArtist {
    @Override
    public String draw(String file) {
        String filePath = String.format("src/main/resources/%s.txt", file);
        StringBuilder art = new StringBuilder();
        try (Scanner fileScanner = new Scanner(new File(filePath))) {
            while (fileScanner.hasNextLine()) {
                art.append(fileScanner.nextLine()).append("\n");
            }
            return art.toString();

        } catch (FileNotFoundException fnfe) {
            return "";
        }
    }

    @Override
    public Color getColour() {
        return Color.BLACK;
    }
}
