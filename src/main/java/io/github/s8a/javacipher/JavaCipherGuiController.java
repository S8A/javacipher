package io.github.s8a.javacipher;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;


/**
 * Controller class for the JavaCipher GUI. Provides functionality 
 * to the buttons that apply the ciphers and the clear button of the 
 * results area.
 */
public class JavaCipherGuiController {

    @FXML
    private TextArea atbashText;

    @FXML
    private ToggleGroup caesarCipherMode;
    @FXML
    private Spinner<Integer> caesarKey;
    @FXML
    private TextArea caesarText;

    @FXML
    private ToggleGroup vigenereCipherMode;
    @FXML
    private TextField vigenereKeyword;
    @FXML
    private TextArea vigenereText;

    @FXML
    private TextArea resultsText;

    @FXML
    private Button clearResultsButton;


    /**
     * Applies the Atbash cipher to the text input and appends the 
     * output to the results area.
     */
    @FXML
    protected void executeAtbashCipher(ActionEvent e) {
        appendResult(AtbashCipher.encrypt(atbashText.getText()));
    }

    /**
     * Applies the Caesar cipher to the text input with the current 
     * key and appends the output to the results area.
     */
    @FXML
    protected void executeCaesarCipher(ActionEvent e) {
        int key = caesarKey.getValue();
        String text = caesarText.getText();
        Toggle mode = caesarCipherMode.getSelectedToggle();

        switch (mode.getUserData().toString()) {
            case "encrypt":
                appendResult(CaesarCipher.encrypt(text, key));
                break;
            case "decrypt":
                appendResult(CaesarCipher.decrypt(text, key));
                break;
        }
    }

    /**
     * Applies the Vigenere cipher to the text input with the current 
     * keyword and appends the output to the results area.
     */
    @FXML
    protected void executeVigenereCipher(ActionEvent e) {
        String keyword = vigenereKeyword.getText();
        String text = vigenereText.getText();
        Toggle mode = vigenereCipherMode.getSelectedToggle();

        switch (mode.getUserData().toString()) {
            case "encrypt":
                appendResult(VigenereCipher.encrypt(text, keyword));
                break;
            case "decrypt":
                appendResult(VigenereCipher.decrypt(text, keyword));
                break;
        }
    }

    /** Clears the results area. */
    @FXML
    protected void clearResults(ActionEvent e) {
        resultsText.clear();
    }

    /** Appends given string with a newline to the results area. */
    private void appendResult(String s) {
        resultsText.appendText(s + "\n");
    }

}