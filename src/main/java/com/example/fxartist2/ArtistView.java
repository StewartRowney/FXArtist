package com.example.fxartist2;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ArtistView {

    private final ArtistController controller;
    private final TextField txtUserInput = new TextField();
    private final TextField txtArtistName = new TextField();
    private final Text txtArtistOutput = new Text();
    private Stage stage;

    public ArtistView(ArtistController controller) {
        this.controller = controller;
    }

    public void start(Stage newStage){

        this.stage = newStage;

        Group group = setUpUI();

        stage.setTitle("Artist");
        stage.setScene(new Scene(group));
        stage.show();
    }

    public Group setUpUI() {
        Group group = new Group();
        VBox vbox = generateFormattedVBox();

        HBox hBoxArtistName = generateFormattedHBox();
        hBoxArtistName.getChildren().add(new Label("Enter artist name: "));
        hBoxArtistName.getChildren().add(txtArtistName);

        HBox hBoxUserInput = generateFormattedHBox();
        hBoxUserInput.getChildren().add(new Label("Enter drawing name: "));
        hBoxUserInput.getChildren().add(txtUserInput);

        Button btnShowArt = new Button("Click me");
        btnShowArt.setOnAction(e -> {
            controller.draw(txtArtistName.getText(), txtUserInput.getText());
        });

        HBox hBoxArtistOutput = generateFormattedHBox();
        hBoxArtistOutput.getChildren().add(txtArtistOutput);

        vbox.getChildren().addAll(hBoxArtistName, hBoxUserInput, btnShowArt, hBoxArtistOutput);
        group.getChildren().add(vbox);
        return group;
    }

    public void showArt(IArtist artist, String art) {
        if (!art.isEmpty()) {
            art += "\n " + txtArtistName.getText();
        }
        txtArtistOutput.setText(art);
        txtArtistOutput.setFill(artist.getColour());
        stage.sizeToScene();
    }

    private VBox generateFormattedVBox() {
        VBox vbox = new VBox(10);
        vbox.setPrefWidth(320);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(40,0,0,0));
        return vbox;
    }

    private HBox generateFormattedHBox() {
        HBox hBox = new HBox(5);
        hBox.setPrefWidth(320);
        hBox.setAlignment(Pos.CENTER);
        hBox.setPadding(new Insets(0,20,0,20));
        return hBox;
    }

}