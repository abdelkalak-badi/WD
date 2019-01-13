/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interftext;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import com.WD.DAOimpl.CentreDao;
import com.WD.entities.Center;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author khale
 */
public class IndexController implements Initializable {

	 @FXML
	    private Label info_center;

	    @FXML
	    private Pane root;

	    
    CentreDao center =new CentreDao();
    String id="";
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    	
    
    	try {
    		AnchorPane fxml = FXMLLoader.load(getClass().getResource("document_trouver.fxml"));
            root.getChildren().setAll(fxml);
		} catch (Exception e) {
			// TODO: handle exception
		}
    	
    }    


    @FXML
    void NewCenter(ActionEvent event) throws IOException {
    	AnchorPane fxml = FXMLLoader.load(getClass().getResource("interface1.fxml"));
    	Stage stage1 = (Stage) info_center.getScene().getWindow();
    	Scene scene = new Scene(fxml);  
        Stage primaryStage=new Stage();
        primaryStage.setTitle("index");
        primaryStage.setScene(scene);
        primaryStage.show();
        stage1.close();

    }

    @FXML
    private void reclamer_document(ActionEvent event) throws IOException {
    	
    	try {
			FileReader fr=new FileReader("center.wd");
			BufferedReader br = new BufferedReader(fr);
			id =br.readLine();
			br.close();
			fr.close();
			info_center.setText("Center : "+center.consulter(new Center(), Integer.valueOf(id)));
		} catch (Exception e) {
			// TODO: handle exception
		} 
          AnchorPane fxml = FXMLLoader.load(getClass().getResource("document_perdu.fxml"));
                           root.getChildren().setAll(fxml);
                         
                           
        
    }

    @FXML
    private void suivi_document(ActionEvent event) throws IOException {
    	try {
			FileReader fr=new FileReader("center.wd");
			BufferedReader br = new BufferedReader(fr);
			id =br.readLine();
			br.close();
			fr.close();
			info_center.setText("Center : "+center.consulter(new Center(), Integer.valueOf(id)));
		} catch (Exception e) {
			// TODO: handle exception
		} 
    	AnchorPane fxml = FXMLLoader.load(getClass().getResource("suivi_document.fxml"));
    	root.getChildren().setAll(fxml);
    }

    @FXML
    private void document_trouver(ActionEvent event) throws IOException {
    	try {
			FileReader fr=new FileReader("center.wd");
			BufferedReader br = new BufferedReader(fr);
			id =br.readLine();
			br.close();
			fr.close();
			info_center.setText("Center : "+center.consulter(new Center(), Integer.valueOf(id)));
		} catch (Exception e) {
			// TODO: handle exception
		} 
    	AnchorPane fxml = FXMLLoader.load(getClass().getResource("document_trouver.fxml"));
    	root.getChildren().setAll(fxml);
    }
    
    

    
}
