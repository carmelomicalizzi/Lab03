package it.polito.tdp.spellchecker.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;

public class SpellCheckerController {

    @FXML
    private MenuButton menuLanguage;

    @FXML
    private TextField txtInserted;

    @FXML
    private Button btnSpell;

    @FXML
    private TextField txtResult;

    @FXML
    private Label labelError;

    @FXML
    private Button btnClear;

    @FXML
    private Label labelTime;

    @FXML
    void doClearText(ActionEvent event) {

    }

    @FXML
    void doSpellCheck(ActionEvent event) {

    }

}

