/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interftext;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import org.kohsuke.rngom.digested.DAttributePattern;

import com.WD.DAOimpl.AutreDao;
import com.WD.DAOimpl.CarteCinDao;
import com.WD.DAOimpl.ObjectDao;
import com.WD.DAOimpl.PassportDao;
import com.WD.DAOimpl.ReclamationDao;
import com.WD.entities.Autre;
import com.WD.entities.Cartecin;
import com.WD.entities.DadeP;
import com.WD.entities.Object;
import com.WD.entities.Passeport;
import com.WD.entities.Personne;
import com.WD.entities.Reclamation;
import com.WD.tab.tabSuivi;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author khale
 */
public class Suivi_documentController implements Initializable {

	@FXML
    private AnchorPane root;
 
    @FXML
    private TableView<tabSuivi> tabcont;

    @FXML
    private TableColumn<tabSuivi, String> cllcinReclamateur;

    @FXML
    private TableColumn<tabSuivi, String> cellnomReclamateur;

    @FXML
    private TableColumn<tabSuivi, String> cellprenomReclamateur;

    @FXML
    private TableColumn<tabSuivi, String> celltellReclamateur;

    @FXML
    private TableColumn<tabSuivi, String> celldateR;

    @FXML
    private TableColumn<tabSuivi, String> cellTypeR;

    @FXML
    private TableColumn<tabSuivi, String> cellTypeO;
    

    String id;

    /**
     * Initializes the controller class.
     */

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    	
    	ReclamationDao reclamationDao=new ReclamationDao();
    	List<Reclamation> center =reclamationDao.listerTous();
    	List<tabSuivi> clients =new ArrayList<tabSuivi>();
		//System.out.println(clients);
    	try {
			FileReader fr=new FileReader("center.wd");
			BufferedReader br = new BufferedReader(fr);
			id =br.readLine();
			br.close();
			fr.close();
		} catch (Exception e) {
			// TODO: handle exception
		} 
    	
		for(Reclamation r :center){
			if (r.getCenter().getIdcenter()==Integer.parseInt(id)) {
				tabSuivi suivi=new tabSuivi();
				suivi.setCinPersonne(r.getPersonne().getCin());
				suivi.setNomPersonne(r.getPersonne().getNom());
				suivi.setPrenomPersonne(r.getPersonne().getPrenom());
				suivi.setTelePersonne(r.getPersonne().getTele());
				suivi.setDatereclamation(	r.getDatereclamation().getDate()+"-"+
											(r.getDatereclamation().getMonth()+1)+"-"+
											(r.getDatereclamation().getYear()+1900));
				suivi.setTypereclamation(r.getTypereclamation());
				suivi.setTypeObject(r.getObject().getTypeobject());
				suivi.setIDObject(r.getIdreclamation());
				clients.add(suivi);
			}	
		}

		ObservableList<tabSuivi> data = FXCollections.observableArrayList(clients);
    	tabcont.setItems(data);
    	 cllcinReclamateur.setCellValueFactory(new PropertyValueFactory<tabSuivi,String>("cinPersonne"));
    	 cellnomReclamateur.setCellValueFactory(new PropertyValueFactory<tabSuivi,String>("nomPersonne"));
    	 cellprenomReclamateur.setCellValueFactory(new PropertyValueFactory<tabSuivi,String>("prenomPersonne"));
    	 celltellReclamateur.setCellValueFactory(new PropertyValueFactory<tabSuivi,String>("telePersonne"));
    	 celldateR.setCellValueFactory(new PropertyValueFactory<tabSuivi,String>("datereclamation"));
    	 cellTypeR.setCellValueFactory(new PropertyValueFactory<tabSuivi,String>("typereclamation"));
    	 cellTypeO.setCellValueFactory(new PropertyValueFactory<tabSuivi,String>("typeObject"));

    } 
    
    @FXML
    public void deleteButton() {
    	Alert alert = new Alert(AlertType.WARNING,"", ButtonType.YES, ButtonType.NO);  //new alert object
        alert.setTitle("Warning!");  //warning box title
        alert.setHeaderText("WARNING!!!");// Header
        alert.setContentText("File already exists. Overwrite?"); //Discription of warning
        alert.getDialogPane().setPrefSize(200, 100); //sets size of alert box 

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.YES){
        	
        	tabSuivi selectedItem = tabcont.getSelectionModel().getSelectedItem();
        	ReclamationDao dao =new ReclamationDao();
        	ObjectDao objectDao=new ObjectDao();
        	CarteCinDao carteCinDao=new CarteCinDao();
        	PassportDao passportDao=new PassportDao();
        	AutreDao autreDao =new AutreDao();
        	Cartecin cartecin= new Cartecin();
        	Passeport passeport=new Passeport();
        	Autre autre=new Autre();
        	Reclamation reclamation=(Reclamation) dao.consulter(new Reclamation(), selectedItem.getIDObject());
        	
        	Object object=new Object();
        	/*System.out.println("00000000000000000000000000000000000000000000");
        	if (selectedItem.getTypereclamation().equals("carte d'identité")) {
        		List<Cartecin> lists=object.getCartecins();
        		for (Cartecin c:lists){
        			System.out.println(c);
        			carteCinDao.supprimer(c);
        		}
        		
			}
        	if (selectedItem.getTypereclamation().equals("Passeport")) {
        		List<Passeport> lists=object.getPasseports();
        		for (Passeport c:lists){
        			System.out.println(c);
        			passportDao.supprimer(c);
        		}
        		
			}
        	if (selectedItem.getTypereclamation().equals("Autre...")) {
        		List<Autre> lists=object.getAutres();
        		for (Autre c:lists){
        			System.out.println(c);
        			autreDao.supprimer(c);
        		}
        		
        	}
        	*/
        	objectDao.supprimer(reclamation.getObject());
        	//dao.supprimer(reclamation);
        	tabcont.getItems().remove(selectedItem);
        	
        } 
    	
	}
    
    
}
