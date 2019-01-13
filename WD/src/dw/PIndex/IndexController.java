/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dw.PIndex;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.WD.DAOimpl.CentreDao;
import com.WD.entities.Center;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author BADI-PC
 */
public class IndexController implements Initializable {

	@FXML
	private Label Labelnomcenter;
	@FXML
	private Label LabelID;
    
    @FXML
    private Pane root;
    
    private Pane RefreshPane=root;
    @FXML
    private TableView<?> tab;
    @FXML
    private TableColumn<?, ?> colnom;
    @FXML
    private TableColumn<?, ?> colprenom;
    @FXML
    private TableColumn<?, ?> coldatep;
    @FXML
    private TableColumn<?, ?> colzonep;
    @FXML
    private TableColumn<?, ?> coltypep;

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    	CentreDao centreDao =new CentreDao();
    	Center center =new Center();
        // TODO
        try {
        	center=(Center) centreDao.consulter(center, 7);
        	LabelID.setText(center.getIdcenter()+"");
        	Labelnomcenter.setText(center.getNoncenter());
            Parent fxml = FXMLLoader.load(getClass().getResource("PTrouve/Trouve.fxml"));
            root.getChildren().setAll(fxml);
        } catch (IOException ex) {
          
        }
    }    

    @FXML
    private void ObjetPerdu(ActionEvent event) {
        try {
            Parent fxml = FXMLLoader.load(getClass().getResource("Signaler/Signaler_D_existants.fxml"));
            root.getChildren().setAll(fxml);
        } catch (IOException ex) {
           
        }
    }


    @FXML
    private void Consulter(ActionEvent event) {
        try {
            Parent fxml = FXMLLoader.load(getClass().getResource("PContinuer/Continuer.fxml"));
            root.getChildren().setAll(fxml);
        } catch (IOException ex) {
          
        }
    }

    @FXML
    private void Refresh(ActionEvent event) {
         try {
            Parent fxml = FXMLLoader.load(getClass().getResource("PTrouve/Trouve.fxml"));
            root.getChildren().setAll(fxml);
        } catch (IOException ex) {
          
        }
    }
    
}
