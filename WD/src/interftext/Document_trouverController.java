/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interftext;


import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.ResourceBundle;

import com.WD.DAOimpl.AutreDao;
import com.WD.DAOimpl.CarteCinDao;
import com.WD.DAOimpl.PassportDao;
import com.WD.DAOimpl.ReclamationDao;
import com.WD.entities.Autre;
import com.WD.entities.Cartecin;
import com.WD.entities.Center;
import com.WD.entities.Object;
import com.WD.entities.Passeport;
import com.WD.entities.Personne;
import com.WD.entities.Reclamation;
import com.WD.tab.tabAutre;
import com.WD.tab.tabCIN;
import com.WD.tab.tabPasseport;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author BADI-PC
 */
public class Document_trouverController implements Initializable {

    @FXML
    private Pane root;
    @FXML
    private TableView<tabCIN> tabCIN;
    @FXML
    private TableColumn<tabCIN, String> cellCINCIN;
    @FXML
    private TableColumn<tabCIN, String> cellNomCIN;
    @FXML
    private TableColumn<tabCIN, String> cellPrenomCIN;
    @FXML
    private TableColumn<tabCIN, Personne> cellPersonneCIN;
    @FXML
    private TableColumn<tabCIN, Center> cellCenterCIN;
    @FXML
    private TextField txtCINCIN;
    @FXML
    private TextField txtNomCIN;
    @FXML
    private TextField txtPrenomCIN;
    @FXML
    private TableView<tabPasseport> tabPASSPORT;
    @FXML
    private TableColumn<tabPasseport, String> cellNumPASSPORT;
    @FXML
    private TableColumn<tabPasseport, String> cellCinPASSPORT;
    @FXML
    private TableColumn<tabPasseport, String> cellNomPASSPORT;
    @FXML
    private TableColumn<tabPasseport, String> cellPrenomPASSPORT;
    @FXML
    private TableColumn<tabPasseport, Personne> cellPresonnePASSPORT;
    @FXML
    private TableColumn<tabPasseport, Center> cellCenterPASSPORT;
    @FXML
    private TextField txtnumPASSPORT;
    @FXML
    private TextField txtcinPASSPORT;
    @FXML
    private TextField txtnonPASSPORT;
    @FXML
    private TextField txtprenomPASSPORT;
    @FXML
    private TableView<tabAutre> tabAUTRE;
    @FXML
    private TableColumn<tabAutre, String> cellNomAUTRE;
    @FXML
    private TableColumn<tabAutre, String> cellDescriptinAUTRE;
    @FXML
    private TableColumn<tabAutre, Personne> cellpesonneAUTRE;
    @FXML
    private TableColumn<tabAutre,Center> cellCenterAUTRE;
    @FXML
    private TextField txtNomAUTRE;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    	/*****************************************CIN************************************************/
    	Cartecin cartecin=new Cartecin();
		Reclamation r=new Reclamation();
		ReclamationDao rd = new ReclamationDao();
		CarteCinDao carteCinDao=new CarteCinDao();
		List<Cartecin> lists=carteCinDao.listerTous();
		List<tabCIN>listTabCIN =new ArrayList<tabCIN>();
		for (Cartecin c:lists){
			tabCIN tabcin =new tabCIN();
	
			List<Reclamation> listsR=rd.listerTous();
			for (Reclamation rr:listsR){
				if (rr.getObject().getIdo()==c.getObject().getIdo()&&rr.getTypereclamation().equals("Trouver")) {
					tabcin.setPersonne(rr.getPersonne());
					tabcin.setCenter(rr.getCenter());
					tabcin.setCin(c.getNumcin());
					tabcin.setNom(c.getNom());
					tabcin.setPrenom(c.getPrenom());
					listTabCIN.add(tabcin);
				}
			}
			
		}
		
		
		
		ObservableList<tabCIN> data = FXCollections.observableArrayList(listTabCIN);
		tabCIN.setItems(data);
    	cellCINCIN.setCellValueFactory(new PropertyValueFactory<tabCIN,String>("cin"));
    	cellNomCIN.setCellValueFactory(new PropertyValueFactory<tabCIN,String>("nom"));
    	cellPrenomCIN.setCellValueFactory(new PropertyValueFactory<tabCIN,String>("prenom"));
    	cellPersonneCIN.setCellValueFactory(new PropertyValueFactory<tabCIN,Personne>("personne"));
		cellCenterCIN.setCellValueFactory(new PropertyValueFactory<tabCIN,Center>("center"));
		
		txtCINCIN.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				// TODO Auto-generated method stub
				List<Cartecin> lists=carteCinDao.listerParCin(newValue);
				List<tabCIN>listTabCIN =new ArrayList<tabCIN>();
				for (Cartecin c:lists){
					tabCIN tabcin =new tabCIN();
					
					List<Reclamation> listsR=rd.listerTous();
					for (Reclamation rr:listsR){
						if (rr.getObject().getIdo()==c.getObject().getIdo()&&rr.getTypereclamation().equals("Trouver")) {
							tabcin.setPersonne(rr.getPersonne());
							tabcin.setCenter(rr.getCenter());
							tabcin.setCin(c.getNumcin());
							tabcin.setNom(c.getNom());
							tabcin.setPrenom(c.getPrenom());
							listTabCIN.add(tabcin);
						}
					}
					
				}
				
				
				
				ObservableList<tabCIN> data = FXCollections.observableArrayList(listTabCIN);
				tabCIN.setItems(data);
		    	cellCINCIN.setCellValueFactory(new PropertyValueFactory<tabCIN,String>("cin"));
		    	cellNomCIN.setCellValueFactory(new PropertyValueFactory<tabCIN,String>("nom"));
		    	cellPrenomCIN.setCellValueFactory(new PropertyValueFactory<tabCIN,String>("prenom"));
		    	cellPersonneCIN.setCellValueFactory(new PropertyValueFactory<tabCIN,Personne>("personne"));
				cellCenterCIN.setCellValueFactory(new PropertyValueFactory<tabCIN,Center>("center"));
			}
		});
		

		txtNomCIN.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				// TODO Auto-generated method stub
				List<Cartecin> lists=carteCinDao.listerParNom(newValue);
				List<tabCIN>listTabCIN =new ArrayList<tabCIN>();
				for (Cartecin c:lists){
					tabCIN tabcin =new tabCIN();
					
					List<Reclamation> listsR=rd.listerTous();
					for (Reclamation rr:listsR){
						if (rr.getObject().getIdo()==c.getObject().getIdo()&&rr.getTypereclamation().equals("Trouver")) {
							tabcin.setPersonne(rr.getPersonne());
							tabcin.setCenter(rr.getCenter());
							tabcin.setCin(c.getNumcin());
							tabcin.setNom(c.getNom());
							tabcin.setPrenom(c.getPrenom());
							listTabCIN.add(tabcin);
						}
					}
					
				}
				
				
				
				ObservableList<tabCIN> data = FXCollections.observableArrayList(listTabCIN);
				tabCIN.setItems(data);
		    	cellCINCIN.setCellValueFactory(new PropertyValueFactory<tabCIN,String>("cin"));
		    	cellNomCIN.setCellValueFactory(new PropertyValueFactory<tabCIN,String>("nom"));
		    	cellPrenomCIN.setCellValueFactory(new PropertyValueFactory<tabCIN,String>("prenom"));
		    	cellPersonneCIN.setCellValueFactory(new PropertyValueFactory<tabCIN,Personne>("personne"));
				cellCenterCIN.setCellValueFactory(new PropertyValueFactory<tabCIN,Center>("center"));
			}
		});
		

		txtPrenomCIN.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				// TODO Auto-generated method stub
				List<Cartecin> lists=carteCinDao.listerParPreNom(newValue);
				List<tabCIN>listTabCIN =new ArrayList<tabCIN>();
				for (Cartecin c:lists){
					tabCIN tabcin =new tabCIN();
					List<Reclamation> listsR=rd.listerTous();
					for (Reclamation rr:listsR){
						if (rr.getObject().getIdo()==c.getObject().getIdo()&&rr.getTypereclamation().equals("Trouver")) {
							tabcin.setPersonne(rr.getPersonne());
							tabcin.setCenter(rr.getCenter());
							tabcin.setCin(c.getNumcin());
							tabcin.setNom(c.getNom());
							tabcin.setPrenom(c.getPrenom());
							listTabCIN.add(tabcin);
						}
					}
					
				}
				
				
				
				ObservableList<tabCIN> data = FXCollections.observableArrayList(listTabCIN);
				tabCIN.setItems(data);
		    	cellCINCIN.setCellValueFactory(new PropertyValueFactory<tabCIN,String>("cin"));
		    	cellNomCIN.setCellValueFactory(new PropertyValueFactory<tabCIN,String>("nom"));
		    	cellPrenomCIN.setCellValueFactory(new PropertyValueFactory<tabCIN,String>("prenom"));
		    	cellPersonneCIN.setCellValueFactory(new PropertyValueFactory<tabCIN,Personne>("personne"));
				cellCenterCIN.setCellValueFactory(new PropertyValueFactory<tabCIN,Center>("center"));
			}
		});
		
		/**********************************************************Passeport*****************************************************/
		
		Passeport passeport=new Passeport();
		PassportDao passportDao=new PassportDao();
	
		List<Passeport> listsP=passportDao.listerTous();
		List<tabPasseport>listTabPasseport =new ArrayList<tabPasseport>();
		for (Passeport c:listsP){
			tabPasseport tabpasseport =new tabPasseport();
		
			List<Reclamation> listsR=rd.listerTous();
			for (Reclamation rr:listsR){
				if (rr.getObject().getIdo()==c.getObject().getIdo()&&rr.getTypereclamation().equals("Trouver")) {
					tabpasseport.setPersonne(rr.getPersonne());
					tabpasseport.setCin(c.getCin());
					tabpasseport.setNumPasseport(c.getNumerodupasseport());
					tabpasseport.setNom(c.getNom());
					tabpasseport.setPrenom(c.getPrenom());
					tabpasseport.setCenter(rr.getCenter());
					listTabPasseport.add(tabpasseport);
				}
			}
			
		}
		
		
		
		ObservableList<tabPasseport> datap = FXCollections.observableArrayList(listTabPasseport);
		tabPASSPORT.setItems(datap);
    	cellCinPASSPORT.setCellValueFactory(new PropertyValueFactory<tabPasseport,String>("cin"));
    	cellNumPASSPORT.setCellValueFactory(new PropertyValueFactory<tabPasseport,String>("numPasseport"));
    	cellNomPASSPORT.setCellValueFactory(new PropertyValueFactory<tabPasseport,String>("nom"));
    	cellPrenomPASSPORT.setCellValueFactory(new PropertyValueFactory<tabPasseport,String>("prenom"));
    	cellPresonnePASSPORT.setCellValueFactory(new PropertyValueFactory<tabPasseport,Personne>("personne"));
		cellCenterPASSPORT.setCellValueFactory(new PropertyValueFactory<tabPasseport,Center>("center"));
		
		txtcinPASSPORT.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				// TODO Auto-generated method stub
				List<Passeport> listsP=passportDao.listerParCin(txtcinPASSPORT.getText().toString());
				List<tabPasseport>listTabPasseport =new ArrayList<tabPasseport>();
				for (Passeport c:listsP){
					tabPasseport tabpasseport =new tabPasseport();
					List<Reclamation> listsR=rd.listerTous();
					for (Reclamation rr:listsR){
						if (rr.getObject().getIdo()==c.getObject().getIdo()&&rr.getTypereclamation().equals("Trouver")) {
							tabpasseport.setPersonne(rr.getPersonne());
							tabpasseport.setCin(c.getCin());
							tabpasseport.setNumPasseport(c.getNumerodupasseport());
							tabpasseport.setNom(c.getNom());
							tabpasseport.setPrenom(c.getPrenom());
							tabpasseport.setCenter(rr.getCenter());
							listTabPasseport.add(tabpasseport);
						}
					}
					
				}
				
				
				
				ObservableList<tabPasseport> datap = FXCollections.observableArrayList(listTabPasseport);
				tabPASSPORT.setItems(datap);
		    	cellCinPASSPORT.setCellValueFactory(new PropertyValueFactory<tabPasseport,String>("cin"));
		    	cellNumPASSPORT.setCellValueFactory(new PropertyValueFactory<tabPasseport,String>("numPasseport"));
		    	cellNomPASSPORT.setCellValueFactory(new PropertyValueFactory<tabPasseport,String>("nom"));
		    	cellPrenomPASSPORT.setCellValueFactory(new PropertyValueFactory<tabPasseport,String>("prenom"));
		    	cellPresonnePASSPORT.setCellValueFactory(new PropertyValueFactory<tabPasseport,Personne>("personne"));
				cellCenterPASSPORT.setCellValueFactory(new PropertyValueFactory<tabPasseport,Center>("center"));
			}
		});
		
		txtnumPASSPORT.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				// TODO Auto-generated method stub
				
				List<Passeport> listsP=passportDao.listerParNumPasseport(txtnumPASSPORT.getText().toString());
				List<tabPasseport>listTabPasseport =new ArrayList<tabPasseport>();
				for (Passeport c:listsP){
					tabPasseport tabpasseport =new tabPasseport();
					
					List<Reclamation> listsR=rd.listerTous();
					for (Reclamation rr:listsR){
						if (rr.getObject().getIdo()==c.getObject().getIdo()&&rr.getTypereclamation().equals("Trouver")) {
							tabpasseport.setPersonne(rr.getPersonne());
							tabpasseport.setCin(c.getCin());
							tabpasseport.setNumPasseport(c.getNumerodupasseport());
							tabpasseport.setNom(c.getNom());
							tabpasseport.setPrenom(c.getPrenom());
							tabpasseport.setCenter(rr.getCenter());
							listTabPasseport.add(tabpasseport);
						}
					}
					
				}
				
				
				
				ObservableList<tabPasseport> datap = FXCollections.observableArrayList(listTabPasseport);
				tabPASSPORT.setItems(datap);
		    	cellCinPASSPORT.setCellValueFactory(new PropertyValueFactory<tabPasseport,String>("cin"));
		    	cellNumPASSPORT.setCellValueFactory(new PropertyValueFactory<tabPasseport,String>("numPasseport"));
		    	cellNomPASSPORT.setCellValueFactory(new PropertyValueFactory<tabPasseport,String>("nom"));
		    	cellPrenomPASSPORT.setCellValueFactory(new PropertyValueFactory<tabPasseport,String>("prenom"));
		    	cellPresonnePASSPORT.setCellValueFactory(new PropertyValueFactory<tabPasseport,Personne>("personne"));
				cellCenterPASSPORT.setCellValueFactory(new PropertyValueFactory<tabPasseport,Center>("center"));
		
				
				
			}
		});

		txtnonPASSPORT.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				// TODO Auto-generated method stub
				
				List<Passeport> listsP=passportDao.listerParNom(txtnonPASSPORT.getText().toString());
				List<tabPasseport>listTabPasseport =new ArrayList<tabPasseport>();
				for (Passeport c:listsP){
					tabPasseport tabpasseport =new tabPasseport();
					List<Reclamation> listsR=rd.listerTous();
					for (Reclamation rr:listsR){
						if (rr.getObject().getIdo()==c.getObject().getIdo()&&rr.getTypereclamation().equals("Trouver")) {
							tabpasseport.setPersonne(rr.getPersonne());
							tabpasseport.setCin(c.getCin());
							tabpasseport.setNumPasseport(c.getNumerodupasseport());
							tabpasseport.setNom(c.getNom());
							tabpasseport.setPrenom(c.getPrenom());
							tabpasseport.setCenter(rr.getCenter());
							listTabPasseport.add(tabpasseport);
						}
					}
				}
				
				
				
				ObservableList<tabPasseport> datap = FXCollections.observableArrayList(listTabPasseport);
				tabPASSPORT.setItems(datap);
		    	cellCinPASSPORT.setCellValueFactory(new PropertyValueFactory<tabPasseport,String>("cin"));
		    	cellNumPASSPORT.setCellValueFactory(new PropertyValueFactory<tabPasseport,String>("numPasseport"));
		    	cellNomPASSPORT.setCellValueFactory(new PropertyValueFactory<tabPasseport,String>("nom"));
		    	cellPrenomPASSPORT.setCellValueFactory(new PropertyValueFactory<tabPasseport,String>("prenom"));
		    	cellPresonnePASSPORT.setCellValueFactory(new PropertyValueFactory<tabPasseport,Personne>("personne"));
				cellCenterPASSPORT.setCellValueFactory(new PropertyValueFactory<tabPasseport,Center>("center"));
		
				
				}
		});
		

		txtprenomPASSPORT.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				// TODO Auto-generated method stub
				
				List<Passeport> listsP=passportDao.listerParPreNom(txtprenomPASSPORT.getText().toString());
				List<tabPasseport>listTabPasseport =new ArrayList<tabPasseport>();
				for (Passeport c:listsP){
					tabPasseport tabpasseport =new tabPasseport();
					List<Reclamation> listsR=rd.listerTous();
					for (Reclamation rr:listsR){
						if (rr.getObject().getIdo()==c.getObject().getIdo()&&rr.getTypereclamation().equals("Trouver")) {
							tabpasseport.setPersonne(rr.getPersonne());
							tabpasseport.setCin(c.getCin());
							tabpasseport.setNumPasseport(c.getNumerodupasseport());
							tabpasseport.setNom(c.getNom());
							tabpasseport.setPrenom(c.getPrenom());
							tabpasseport.setCenter(rr.getCenter());
							listTabPasseport.add(tabpasseport);
						}
					}
					
				}
				
				
				
				ObservableList<tabPasseport> datap = FXCollections.observableArrayList(listTabPasseport);
				tabPASSPORT.setItems(datap);
		    	cellCinPASSPORT.setCellValueFactory(new PropertyValueFactory<tabPasseport,String>("cin"));
		    	cellNumPASSPORT.setCellValueFactory(new PropertyValueFactory<tabPasseport,String>("numPasseport"));
		    	cellNomPASSPORT.setCellValueFactory(new PropertyValueFactory<tabPasseport,String>("nom"));
		    	cellPrenomPASSPORT.setCellValueFactory(new PropertyValueFactory<tabPasseport,String>("prenom"));
		    	cellPresonnePASSPORT.setCellValueFactory(new PropertyValueFactory<tabPasseport,Personne>("personne"));
				cellCenterPASSPORT.setCellValueFactory(new PropertyValueFactory<tabPasseport,Center>("center"));
		
				
			}
		});
		/***********************************************************************************************************************/
		
		Autre autre=new Autre();
		AutreDao autreDao=new AutreDao();
	
		List<Autre> listsA=autreDao.listerTous();
		List<tabAutre>listTabAutre =new ArrayList<tabAutre>();
		for (Autre c:listsA){
			tabAutre tabautre =new tabAutre();
	        //System.out.println(c.getObject().getIdo());
			List<Reclamation> listsR=rd.listerTous();
			for (Reclamation rr:listsR){
				if (rr.getObject().getIdo()==c.getObject().getIdo()&&rr.getTypereclamation().equals("Trouver")) {
					tabautre.setNom(c.getNom());
					tabautre.setDescription(c.getDescription());
					tabautre.setPersonne(rr.getPersonne());
					tabautre.setCenter(rr.getCenter());
					listTabAutre.add(tabautre);
				}
			}
			
		}
		
		
		
		ObservableList<tabAutre> dataa = FXCollections.observableArrayList(listTabAutre);
		tabAUTRE.setItems(dataa);
    	cellDescriptinAUTRE.setCellValueFactory(new PropertyValueFactory<tabAutre,String>("description"));
    	cellNomAUTRE.setCellValueFactory(new PropertyValueFactory<tabAutre,String>("nom"));
    	cellpesonneAUTRE.setCellValueFactory(new PropertyValueFactory<tabAutre,Personne>("personne"));
		cellCenterAUTRE.setCellValueFactory(new PropertyValueFactory<tabAutre,Center>("center"));
		
		
		txtNomAUTRE.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				// TODO Auto-generated method stub
				
				Autre autre=new Autre();
				AutreDao autreDao=new AutreDao();
			
				List<Autre> listsA=autreDao.listerParNom(txtNomAUTRE.getText().toString());
				List<tabAutre>listTabAutre =new ArrayList<tabAutre>();
				for (Autre c:listsA){
					tabAutre tabautre =new tabAutre();
			        //System.out.println(c.getObject().getIdo());
					List<Reclamation> listsR=rd.listerTous();
					for (Reclamation rr:listsR){
						if (rr.getObject().getIdo()==c.getObject().getIdo()&&rr.getTypereclamation().equals("Trouver")) {
							tabautre.setNom(c.getNom());
							tabautre.setDescription(c.getDescription());
							tabautre.setPersonne(rr.getPersonne());
							tabautre.setCenter(rr.getCenter());
							listTabAutre.add(tabautre);
						}
					}
				
				}
				
				
				
				ObservableList<tabAutre> dataa = FXCollections.observableArrayList(listTabAutre);
				tabAUTRE.setItems(dataa);
		    	cellDescriptinAUTRE.setCellValueFactory(new PropertyValueFactory<tabAutre,String>("description"));
		    	cellNomAUTRE.setCellValueFactory(new PropertyValueFactory<tabAutre,String>("nom"));
		    	cellpesonneAUTRE.setCellValueFactory(new PropertyValueFactory<tabAutre,Personne>("personne"));
				cellCenterAUTRE.setCellValueFactory(new PropertyValueFactory<tabAutre,Center>("center"));
				
				
			}
		});

		/*****************************************************************************************************************************/
    }    
    
}
