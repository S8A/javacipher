package io.github.s8a.javacipher;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * Graphical user interface for the JavaCipher program. The GUI is 
 * defined in an FXML file to separate the presentation from the 
 * program logic.
 */
public class JavaCipherGui extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getClassLoader()
                                      .getResource("JavaCipherGui.fxml"));
        Scene scene = new Scene(root, 600, 400);
        stage.setTitle("JavaCipher");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String args[]) {
        launch(args);
    }
}