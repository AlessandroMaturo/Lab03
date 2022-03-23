/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.spellchecker;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.spellchecker.model.Dictionary;
import it.polito.tdp.spellchecker.model.RichWord;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Dictionary dictionary;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btnClearText"
    private Button btnClearText; // Value injected by FXMLLoader

    @FXML // fx:id="btnSpellCheck"
    private Button btnSpellCheck; // Value injected by FXMLLoader

    @FXML // fx:id="cmbBox"
    private ComboBox<String> cmbBox; // Value injected by FXMLLoader

    @FXML // fx:id="txtAreaDown"
    private TextArea txtAreaDown; // Value injected by FXMLLoader

    @FXML // fx:id="txtAreaUp"
    private TextArea txtAreaUp; // Value injected by FXMLLoader

    @FXML // fx:id="lblErrors"
    private Label lblErrors; // Value injected by FXMLLoader

    @FXML // fx:id="lblTime"
    private Label lblTime; // Value injected by FXMLLoader

    @FXML
    void doClearText(ActionEvent event) {
    	txtAreaUp.setText("");
    	txtAreaDown.setText("");
    	cmbBox.setValue(null);
    }

    //ogni volta dovrai pulire il dizionario
    @FXML
    void doSpellCheck(ActionEvent event) {
    	
    	long time_start=System.currentTimeMillis();
    	
    	List<String> textList = new LinkedList<String>();
    	List<RichWord> richWords = new LinkedList<RichWord>();
    	
    	String file="";
    	
    	if(cmbBox.getValue().compareTo("Italiano")==0) {
    		file="C:\\Users\\User\\git\\Lab03\\src\\main\\resources\\Italian.txt";
    	}
    	if(cmbBox.getValue().compareTo("English")==0) {
    		file="C:\\Users\\User\\git\\Lab03\\src\\main\\resources\\English.txt";
    	}
    	
    	dictionary.loadDictionary(file);
    	String text1=txtAreaUp.getText();
    	
    	String text2 = text1.replaceAll("[.,?\\/#!$%\\^&\\*;:{}=\\-_`~()\\[\\]\"]", "");
    	String text3= text2.toLowerCase();
    	
    	
    	
    	String[] textVet = text3.split(" ");
    	
    	for(int i=0;i<textVet.length;i++) {
    		textList.add(textVet[i]);
    		//System.out.println(textVet[i]);
    	}
    	
    	
    	
    	richWords = dictionary.spellCheckText(textList);
    	
    	int nErrori=0;
    	String textDown="";
    	for(RichWord ri:richWords) {
    		if(!ri.isCorrect()) {
    			textDown=textDown+ri.getWord()+"\n";
    			nErrori++;
    		}
    	}

    	long time_end=System.currentTimeMillis();
    	
    	long time_in_second=(time_end-time_start);
    	
    	txtAreaDown.setText(textDown);
    	lblErrors.setText("The text contains " +nErrori+" errors");
    	lblTime.setText("Spell check completed in "+time_in_second+" milliseconds");
    	
    	
    	
    }
    
    public void setModel(Dictionary dictionary) {
    	this.dictionary=dictionary;
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btnClearText != null : "fx:id=\"btnClearText\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnSpellCheck != null : "fx:id=\"btnSpellCheck\" was not injected: check your FXML file 'Scene.fxml'.";
        assert cmbBox != null : "fx:id=\"cmbBox\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtAreaDown != null : "fx:id=\"txtAreaDown\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtAreaUp != null : "fx:id=\"txtAreaUp\" was not injected: check your FXML file 'Scene.fxml'.";
        assert lblErrors != null : "fx:id=\"lblErrors\" was not injected: check your FXML file 'Scene.fxml'.";
        assert lblTime != null : "fx:id=\"lblTime\" was not injected: check your FXML file 'Scene.fxml'.";

        cmbBox.getItems().clear();
        cmbBox.getItems().add("English");
        cmbBox.getItems().add("Italiano");
        
    }

}


