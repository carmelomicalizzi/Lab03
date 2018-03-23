package it.polito.tdp.spellchecker.controller;

import java.util.*;

import it.polito.tdp.spellchecker.model.Dictionary;
import it.polito.tdp.spellchecker.model.RichWord;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;



public class SpellCheckerController {
	
	private Dictionary dizionario;
	List<String> inputTextList = new LinkedList<String>();
	
    @FXML
    private ComboBox<String> menuLanguage;

    @FXML
    private TextField txtInserted;

    @FXML
    private Button btnSpell;

    @FXML
    private TextArea txtResult;

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
	void doActivation(ActionEvent event) {
		if (menuLanguage.getValue() != null) {
			txtInserted.setDisable(false);
			txtResult.setDisable(false);
			
			txtInserted.clear();
			txtResult.clear();
		}
	}

    @FXML
    void doSpellCheck(ActionEvent event) {
    	
    	int i;
    	
    	txtResult.clear();
		inputTextList.clear();
		
		dizionario.loadDictionary(menuLanguage.getValue());
		
		String testoDaCorreggere = txtInserted.getText();
    	
    	String[] elencoDaCorreggere = testoDaCorreggere.split(" ");
    	for(i=0; i < elencoDaCorreggere.length; i++)
    		inputTextList.add(elencoDaCorreggere[i].trim().toLowerCase());
    	
    	List<RichWord> listaCorretta = dizionario.spellCheckText(inputTextList);
    	String elenco = "";
    	for(RichWord r : listaCorretta)
    		elenco += r.getParola() + " \n";
    	this.txtResult.setText(elenco);
    }
    
    @FXML
    void initialize() {
    	assert menuLanguage != null : "fx:id=\"boxLingua\" was not injected: check your FXML file 'SpellChecker.fxml'.";
		assert txtInserted != null : "fx:id=\"txtDaCorreggere\" was not injected: check your FXML file 'SpellChecker.fxml'.";
		assert txtResult != null : "fx:id=\"txtCorretto\" was not injected: check your FXML file 'SpellChecker.fxml'.";
		assert labelError != null : "fx:id=\"lblErrori\" was not injected: check your FXML file 'SpellChecker.fxml'.";
		assert labelTime != null : "fx:id=\"lblStato\" was not injected: check your FXML file 'SpellChecker.fxml'.";
		
		txtInserted.setText("Selezionare una lingua");
		txtInserted.setDisable(true);
		txtResult.setDisable(true);
		menuLanguage.getItems().addAll("Italian", "English");		
		
		labelError.setText("");
		labelTime.setText("");
		
		this.dizionario = new Dictionary();
    	
    	
    }

}

