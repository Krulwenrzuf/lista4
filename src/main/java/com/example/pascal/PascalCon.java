package com.example.pascal;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.TextFlow;

public class PascalCon {
    @FXML
    public TextField Pole;
    @FXML
    public TextFlow displayed;



    @FXML
    protected void onButtonClick() {
        //displayd.setText(PascalGen.generate(Pole.getText()));
        displayed.getChildren().clear();
        PascalGen.betterGenerate(displayed, Pole.getText());
    }
}