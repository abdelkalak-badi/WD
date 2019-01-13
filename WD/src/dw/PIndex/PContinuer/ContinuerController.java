/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dw.PIndex.PContinuer;

import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;



import com.WD.DAOimpl.ReclamationDao;
import com.WD.entities.Object;
import com.WD.entities.Personne;
import com.WD.entities.Reclamation;




import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;



/**
 * FXML Controller class
 *
 * @author BADI-PC
 */
public class ContinuerController implements Initializable {
	@FXML
    private AnchorPane root;
    @FXML
    private TableView<Reclamation> tabcont;
    @FXML
    private TableColumn<Reclamation, Personne> cllcin;
    @FXML
    private TableColumn<Reclamation, Date> celldateR;
    @FXML
    private TableColumn<Reclamation, String> cellTypeR;
    @FXML
    private TableColumn<Reclamation, Object> cellTypeO;
   

    /**
     * Initializes the controller class.
     */

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    	ReclamationDao reclamationDao=new ReclamationDao();
    	List<Reclamation> clients =reclamationDao.listerTous();
		//System.out.println(clients);
		for(Reclamation r :clients){
			if (r.getCenter().getIdcenter()==7) {
				System.out.println(r);
			}	
		}

		ObservableList<Reclamation> data = FXCollections.observableArrayList(clients);
    	tabcont.setItems(data);
    	cllcin.setCellValueFactory(new PropertyValueFactory<Reclamation,Personne>("personne"));
    	celldateR.setCellValueFactory(new PropertyValueFactory<Reclamation,Date>("datereclamation"));
    	cellTypeR.setCellValueFactory(new PropertyValueFactory<Reclamation,String>("typereclamation"));
    	cellTypeO.setCellValueFactory(new PropertyValueFactory<Reclamation,Object>("object"));
    	
    }    
    
}
