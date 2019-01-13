/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dw;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author BADI-PC
 */
public class SplashUIController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    Timer timer = new Timer();
    @FXML
    private Pane root;
    @FXML
    private Label lawding;
  


    @Override
    public void initialize(URL url, ResourceBundle rb) {
      timer.schedule(new TimerTask() {
          @Override
          public void run() {
               try {
                Parent fxml = FXMLLoader.load(getClass().getResource("Login.fxml"));
                root.getChildren().setAll(fxml);
                   System.out.println("0000000000000000000000000000000000000000000");
            } catch (IOException ex) {
                   System.out.println(".run()55555555555555555555555555");
            }
          }
      },2000);
      }


      
    }

    
    

