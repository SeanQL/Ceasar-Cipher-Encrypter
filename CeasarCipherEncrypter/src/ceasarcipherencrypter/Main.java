/*
 * Java program intended to use a ceasar cipher txt file to encrpt/decrypt
 * txt file
 *
 * @author Sean Lawson
 */

package ceasarcipherencrypter;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.stage.Stage;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

public class Main  extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
        JList list = new JList();
        JScrollPane scrollPane = new JScrollPane();
        
    public void start(Stage primaryStage)  {
        //Creates the frame of the application
        JFrame frame = new JFrame("Ceasar Cipher Encrypter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        
        //Creates Buttons for the user to browse the direcotory to select files
        JButton nkButton = new JButton("Browse...");
        JButton fileButton = new JButton("Browse...");
        
        //Text fields for the file paths
        JTextField nkTF = new JTextField("Enter new Key File here... \t\t");
        JTextField fileTF = new JTextField("Enter file to encrypt here...\t\t");
        
        //JButtons for the user to encrypt/decrypt file or give data collected from the file
        JButton rfButton = new JButton("Read File");
        JButton efButton = new JButton("Encrypt File");
        JButton dfButton = new JButton("Display freequencies of characters");
        JButton afButton = new JButton("Analyze frequencies");
        JButton bwButton = new JButton("Break words");
        
        //Label for the frequency analysis of the text file
        JLabel label = new JLabel("key analysis", SwingConstants.CENTER);
        
        //adds the the buttons and textfields to a panel
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, label, p2);
        
        //layout of panels
        p1.add(nkTF);
        p1.add(nkButton);
        p1.add(fileTF);
        p1.add(fileButton);
        p2.add(rfButton);
        p2.add(efButton);
        p2.add(dfButton);
        p2.add(afButton);
        p2.add(bwButton);
        
        list = new JList();
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setLayoutOrientation(JList.VERTICAL);
        list.setVisibleRowCount(-1);
        
        scrollPane = new JScrollPane(list);
        
        // Buttons grabs the file paths to be used for encrypting/decrypting
        nkButton.addActionListener((ActionEvent e) -> {
            JFileChooser chooser = new JFileChooser();
            chooser.setCurrentDirectory(new java.io.File("."));
            chooser.setDialogTitle("Choose key file");
            
            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                nkTF.setText(chooser.getSelectedFile().getPath());
              }
        });
        fileButton.addActionListener((ActionEvent e) -> {
            JFileChooser chooser = new JFileChooser();
            chooser.setCurrentDirectory(new java.io.File("."));
            chooser.setDialogTitle("Choose file to Encrypt");
            
            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                fileTF.setText(chooser.getSelectedFile().getPath());
              }
        });
        
        // reads the file and splits it into separate strings
        rfButton.addActionListener((ActionEvent e)  -> {
            ReadFile rf = new ReadFile();
            String[] str = null;
            DefaultListModel model = new DefaultListModel();
            
            try {
                str = rf.readFile(fileTF.getText());
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            list.setModel(model);
            for(int i = 0; i < str.length; i++) {
                model.addElement(str[i]);
            }
        });
        
        
        //frame layout
        frame.getContentPane().add(BorderLayout.PAGE_START, p1);
        frame.getContentPane().add(BorderLayout.CENTER, scrollPane);
        frame.getContentPane().add(BorderLayout.PAGE_END, splitPane);
        
        frame.setVisible(true);
    }
}