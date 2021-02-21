/*
 * Java program intended to use a ceasar cipher txt file to encrpt/decrypt
 * txt file
 */

/**
 *
 * @author Sean Lawson
 */

package ceasarcipherencrypter;


import javafx.scene.control.Button;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage)  {
        
        //adding button that will open a dirctory to select an new Key file
        TextField tf = new TextField("Enter new Key File here...");        
        Button nkButton = new Button("Browse...");
        
        HBox hBox1 = new HBox(tf, nkButton);
        
        hBox1.setAlignment(Pos.TOP_CENTER);
        
        // buttons to give the uer options to encrypt/decrypt or display data of text files
        Button efButton = new Button("Encrypt File");
        Button dfButton = new Button("Display freequencies of characters");
        Button afButton = new Button("Analyze frequencies");
        Button bwButton = new Button("Break words");
        
        HBox hBox2 = new HBox(10, efButton, dfButton, afButton, bwButton);
        
        hBox2.setAlignment(Pos.BOTTOM_CENTER);
        
        VBox vBox = new VBox(hBox1, hBox2);
        
        Scene scene = new Scene(vBox, 800, 800);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Ceasar Cipher Encrypter");
        primaryStage.show();
    }
}