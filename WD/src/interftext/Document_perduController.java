/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interftext;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import org.controlsfx.control.Notifications;

import com.WD.DAOimpl.AutreDao;
import com.WD.DAOimpl.CarteCinDao;
import com.WD.DAOimpl.CentreDao;
import com.WD.DAOimpl.ObjectDao;
import com.WD.DAOimpl.PassportDao;
import com.WD.DAOimpl.PersonneDao;
import com.WD.DAOimpl.ReclamationDao;
import com.WD.entities.Autre;
import com.WD.entities.Cartecin;
import com.WD.entities.Center;
import com.WD.entities.Object;
import com.WD.entities.Passeport;
import com.WD.entities.Personne;
import com.WD.entities.Reclamation;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author khale
 */
public class Document_perduController implements Initializable {


    @FXML
    private ComboBox<String> passeportType;
    @FXML
    private ComboBox<String> passeportSexe;

    List<String> ListTypeObject,ListTypeSignaler,ListpasseportType,ListSexe;
    ObservableList<String> options ;

    @FXML
    private TextField txtcin;
    @FXML
    private TextField txtprenom;
    @FXML
    private TextField txtnom;
    @FXML
    private TextField txtnumtele;
    @FXML
    private ComboBox<String> TypeObject;
    @FXML
    private DatePicker DateSignaler;
    @FXML
    private ComboBox<String> TypeSignaler;
    @FXML
    private Pane passeportPane;
    @FXML
    private TextField passeportcin;
    @FXML
    private TextField passeportprenom;
    @FXML
    private TextField passeportcodeoays;
    @FXML
    private TextField passeportnum;
    @FXML
    private TextField passeportnom;
    @FXML
    private DatePicker passeportdateness;
    @FXML
    private Pane paneCarteCIN;
    @FXML
    private TextField CarteCINCin;
    @FXML
    private TextField CarteCINPrenom;
    @FXML
    private TextField CarteCINNom;
    @FXML
    private TextField CarteCINAdresse;
    @FXML
    private DatePicker CarteCINDateNess;
    @FXML
    private Pane OutrePane;
    @FXML
    private TextField OutreNom;
    @FXML
    private TextArea OutreDescription;
	Personne pglobale =null;
	int idcc;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    	try {
			FileReader fr=new FileReader("center.wd");
			BufferedReader br = new BufferedReader(fr);
			idcc =Integer.parseInt(br.readLine());
			br.close();
			fr.close();
		} catch (Exception e) {
			// TODO: handle exception
		} 
    	
                  passeportPane.setVisible(false);
                  paneCarteCIN.setVisible(true);
                  OutrePane.setVisible(false);
        ListTypeObject=new ArrayList<String>();
    	ListTypeObject.add("Passeport");
        ListTypeObject.add("carte d'identité");
        ListTypeObject.add("Autre...");
    	options=FXCollections.observableArrayList(ListTypeObject);
        TypeObject.setValue("carte d'identité");
    	TypeObject.setItems(options);
    	TypeObject.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue.equals("Passeport")) {
                    passeportPane.setVisible(true);
                    paneCarteCIN.setVisible(false);
                    OutrePane.setVisible(false);
                }
                if (newValue.equals("carte d'identité")) {
                  passeportPane.setVisible(false);
                  paneCarteCIN.setVisible(true);
                  OutrePane.setVisible(false);
                }
                if (newValue.equals("Autre...")) {
                   passeportPane.setVisible(false);
                   paneCarteCIN.setVisible(false);
                   OutrePane.setVisible(true);
                }
                
            }
        });
        
      /********************************************************************************************************************/
      ListTypeSignaler=new ArrayList<String>();
    	ListTypeSignaler.add("Perdue");
        ListTypeSignaler.add("Trouver");
    	options=FXCollections.observableArrayList(ListTypeSignaler);
        TypeSignaler.setValue("Perdue");
    	TypeSignaler.setItems(options);
    	//TypeSignaler.getSelectionModel().selectedItemProperty().addListener
        /*******************************************************************************************************************/
        ListSexe=new ArrayList<String>();
    	ListSexe.add("Homme");
        ListSexe.add("Famme");
    	options=FXCollections.observableArrayList(ListSexe);
        passeportSexe.setValue("Homme");
    	passeportSexe.setItems(options);
    	/**************************************************************************************************/
    	 ListpasseportType=new ArrayList<String>();
    	 ListpasseportType.add("Passeport biométrique");
    	 ListpasseportType.add("Passeport interne");
    	 ListpasseportType.add("Passeport international");
    	 ListpasseportType.add("Passeport lisible électroniquement");
     	options=FXCollections.observableArrayList(ListpasseportType);
     	passeportType.setValue("Passeport biométrique");
     	passeportType.setItems(options);
      //-------------------------------------------------------------------------------------------
    	PersonneDao pd =new PersonneDao();
    
    
    	txtcin.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				// TODO Auto-generated method stub
				Personne pp=new Personne();
				try {
					pp=(Personne) pd.consulter(pp,newValue);
					if (pp.getCin().equals(newValue)) {
						txtnom.setText(pp.getNom());
						txtprenom.setText(pp.getPrenom());
						txtnumtele.setText(pp.getTele());
						pglobale=pp;
					}else{
						txtnom.setText("");
						txtprenom.setText("");
						txtnumtele.setText("");
						pglobale=null;
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				
				}
		});
    } 
    public void ajouter(){
    	/*LocalDate ld ;;
    	Calendar ca ;;
    	Date date;
    	ObjectDao od=new ObjectDao();
    	Object o =new Object();
    	o=od.FinList();*/
    	  if (verifier())
          {
    		  
          Alert alert = new Alert(AlertType.CONFIRMATION);
          alert.setTitle("Confirmation ");
          alert.setHeaderText("Confirmation d'enregistrement");
          alert.setContentText("voulez-vous enregistrer cette réclamation ?");
          ButtonType buttonTypeOne = new ButtonType("Oui");
          ButtonType buttonTypeTwo = new ButtonType("Non");
          alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo);    
          Optional<ButtonType> result = alert.showAndWait();
              if (result.get() == buttonTypeOne){
            	  try {
					ajouterReclamation();
				
            	  
                        Notifications notificationBuilder = Notifications.create()
                                   .title("Terminé")
                                   .text("Enregistrement terminé avec succés")
                                   .graphic(null)
                                    //.graphic(new ImageView(img))
                                   .hideAfter(Duration.seconds(5))
                                   .position(Pos.BOTTOM_RIGHT);
                             notificationBuilder.darkStyle();
                            notificationBuilder.showConfirm();
                          /* CarteCINCin.setText("");
                           CarteCINPrenom.setText("");
                           CarteCINNom.setText("");
                           CarteCINAdresse.setText("");
                           OutreNom.setText("");
                           OutreDescription.setText("");
                           txtcin.setText("");
                           txtprenom.setText("");
                           txtnom.setText("");
                           txtnumtele.setText("");
                           passeportcin.setText("");
                           passeportprenom.setText("");
                           passeportcodeoays.setText("");
                           passeportnum.setText("");
                           passeportnom.setText("");*/
            	  } catch (Exception e) {
  					// TODO: handle exception

                      Notifications notificationBuilder00 = Notifications.create()
                                 .title("Error")
                                 .text("Erreur d'enregistrement\n"+e.getMessage())
                                 .graphic(null)
                                  //.graphic(new ImageView(img))
                                 .hideAfter(Duration.seconds(5))
                                 .position(Pos.BOTTOM_RIGHT);
                           notificationBuilder00.darkStyle();
                          notificationBuilder00.showError();
  				}      
                            
          } else {
                  
                           CarteCINCin.setText("");
                           CarteCINPrenom.setText("");
                           CarteCINNom.setText("");
                           CarteCINAdresse.setText("");
                           OutreNom.setText("");
                           OutreDescription.setText("");
                           txtcin.setText("");
                           txtprenom.setText("");
                           txtnom.setText("");
                           txtnumtele.setText("");
                           passeportcin.setText("");
                           passeportprenom.setText("");
                           passeportcodeoays.setText("");
                           passeportnum.setText("");
                           passeportnom.setText("");
      // ... user chose CANCEL or closed the dialog
          }
          
          }
    }
    public void ajouterReclamation() {
    	Personne p=new Personne();
    	if (pglobale.equals(null)) {
    	p.setCin(txtcin.getText().toString());
    	p.setNom(txtnom.getText().toString());
    	p.setPrenom(txtprenom.getText().toString());
    	p.setTele(txtnumtele.getText().toString());
    	}else {
			p=pglobale;
		}
    	PersonneDao pd=new PersonneDao();
        pd.ajouter(p);
    	Object o =new Object();
    	o.setTypeobject(TypeObject.getValue()); 
    	ObjectDao od=new ObjectDao();
    	od.ajouter(o);
    	Reclamation r =new Reclamation();
    	r.setTypereclamation(TypeSignaler.getValue().toString());
    	System.out.println("000000000000000000000000000000000000000000000000000000000");
    	LocalDate ld = DateSignaler.getValue();
    	Calendar ca =  Calendar.getInstance();
    	ca.set(ld.getYear(), ld.getMonthValue() - 1, ld.getDayOfMonth());
    	Date date = ca.getTime();
    	r.setDatereclamation(date);
    	System.out.println("111111111111111111111111111111111111111111111111111");
    	CentreDao cd = new CentreDao();
    	Center cent=(Center) cd.consulter(new Center(), idcc);
    	r.setCenter(cent);
    	o=od.FinList();
    	r.setObject(o);
    	//r.setIdreclamation(55);
    	
    	if (pglobale.equals(null)) {
    		r.setPersonne(pd.FinList());
        	}else {
            	r.setPersonne(pglobale);
    		}
    	

    	System.err.println(r);
    	ReclamationDao rd =new ReclamationDao();
    	rd.ajouter(r);
    	if (TypeObject.getValue().equals("Passeport")) {
    		System.out.println("pppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppp");
    		PassportDao passportDao=new PassportDao();
    		Passeport passeport=new Passeport();
    		passeport.setCin("P"+passeportcin.getText().toString());
    		if (TypeSignaler.getValue().equals("Trouver")) 
    			passeport.setCin("T"+passeportcin.getText().toString());
			
    		
    		System.err.println("000000000000000000000000000000000000000000000000000");
    		passeport.setNumerodupasseport(passeportnum.getText().toString());
    		System.err.println("1111111111111111111111111111111111111111111111");
    	//	passeport.setTypedepasseport(passeportType.getValue().toString());
    		System.err.println("222222222222222222222222222222222222222222222222");
    		passeport.setSexe(passeportSexe.getValue().toString());
    		System.err.println("333333333333333333333333333333333333333333333333333333");
    		ld = passeportdateness.getValue();
        	ca =  Calendar.getInstance();
        	ca.set(ld.getYear(), ld.getMonthValue() - 1, ld.getDayOfMonth());
        	date = ca.getTime();
    		passeport.setDatedenaissance(date);
    		System.err.println("444444444444444444444444444444444444444444444");
    		passeport.setObject(o);
    		System.out.println(passeport);
			passportDao.ajouter(passeport);
		}
        if (TypeObject.getValue().equals("carte d'identité")) {
        	System.out.println("cccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc");
        	CarteCinDao carteCinDao=new CarteCinDao();
        	System.out.println("111111111111111111111111111111111111111");
        	Cartecin cartecin=new Cartecin();
        	cartecin.setNumcin("P"+CarteCINCin.getText().toString());
        	if (TypeSignaler.getValue().equals("Trouver"))
        		cartecin.setNumcin("T"+CarteCINCin.getText().toString());
        	System.out.println("222222222222222222222222222222222222222222");
        	cartecin.setNom(CarteCINNom.getText().toString());
        	System.out.println("333333333333333333333333333333333333");
        	cartecin.setPrenom(CarteCINPrenom.getText().toString());
        	System.out.println("44444444444444444444444444444444444444444");
        	cartecin.setAdresse(CarteCINAdresse.getText().toString());
        	System.out.println("5555555555555555555555555555555555555555555");
        	ld = CarteCINDateNess.getValue();
        	ca =  Calendar.getInstance();
        	ca.set(ld.getYear(), ld.getMonthValue() - 1, ld.getDayOfMonth());
        	date = ca.getTime();
        	System.out.println("666666666666666666666666666666666666666666666");
        	cartecin.setDateness(date);
        	System.out.println("777777777777777777777777777777777777777777777777");
        	cartecin.setObject(o);
        	System.out.println("8888888888888888888888888888888888888888888");
        	System.out.println(cartecin);
        	System.out.println("99999999999999."+cartecin);
			carteCinDao.ajouter(cartecin);
		}
        if (TypeObject.getValue().equals("Autre...")) {
        	System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
			AutreDao autreDao =new AutreDao();
			Autre autre =new Autre();
			autre.setNom(OutreNom.getText().toString());
			autre.setDescription(OutreDescription.getText().toString());
			autre.setObject(o);

			System.out.println("-------------------"+o);
			System.out.println("-------------------"+autre);
			autreDao.ajouter(autre);
		}
    	System.out.println(txtcin.getText().toLowerCase().toString());
    	Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Ajouter Reclamation");
		alert.setHeaderText("Reclamation ajouté avec succées\n");
		alert.showAndWait();
    	
    }
    @FXML
    private void verifier_numero(KeyEvent event) {
      txtcin.textProperty().addListener(new ChangeListener<String>() {


          @Override
          public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
              if (!newValue.matches("\\d*")) {
            txtcin.setText(newValue.replaceAll("[^\\d]", "")); //To change body of generated methods, choose Tools | Templates.
          }
          }});    
              }

    @FXML
    private void verifier_numero1(KeyEvent event) {
        txtnumtele.textProperty().addListener(new ChangeListener<String>() {


          @Override
          public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
              if (!newValue.matches("\\d*")) {
            txtnumtele.setText(newValue.replaceAll("[^\\d]", "")); //To change body of generated methods, choose Tools | Templates.
          }
          }});    
    }

    @FXML
    private void verifier_numero_passport(KeyEvent event) {
        
          passeportnum.textProperty().addListener(new ChangeListener<String>() {


          @Override
          public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
              if (!newValue.matches("\\d*")) {
            passeportnum.setText(newValue.replaceAll("[^\\d]", "")); //To change body of generated methods, choose Tools | Templates.
          }
          }});    
        
    }

    @FXML
    private void verifier_numero_pass_cin(KeyEvent event) {
         passeportcin.textProperty().addListener(new ChangeListener<String>() {


          @Override
          public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
              if (!newValue.matches("\\d*")) {
            passeportcin.setText(newValue.replaceAll("[^\\d]", "")); //To change body of generated methods, choose Tools | Templates.
          }
          }});    
    }

    @FXML
    private void verifier_cin(KeyEvent event) {
         CarteCINCin.textProperty().addListener(new ChangeListener<String>() {


          @Override
          public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
              if (!newValue.matches("\\d*")) {
            CarteCINCin.setText(newValue.replaceAll("[^\\d]", "")); //To change body of generated methods, choose Tools | Templates.
          }
          }});    
    }
    public boolean verifier()
    {     
     if((!txtcin.getText().isEmpty())&&(!txtnumtele.getText().isEmpty())&&(DateSignaler.getValue() != null)&&(!txtnom.getText().isEmpty())&&(!txtprenom.getText().isEmpty()))
     {
        if (paneCarteCIN.isVisible()&&(TypeSignaler.getValue().equals("Trouver")))
        {
            if(CarteCINCin.getText().isEmpty()&&CarteCINPrenom.getText().isEmpty()&&CarteCINNom.getText().isEmpty()&&CarteCINAdresse.getText().isEmpty())
            {
                Notifications notificationBuilder = Notifications.create()
                    .title("erreur Carte CIN")
                    .text("verifier les champs des Carte CIN!")
                    .graphic(null)
                    .position(Pos.CENTER_LEFT);
                 notificationBuilder.darkStyle();
               notificationBuilder.showError();
               return false;
            }
        }
         if (passeportPane.isVisible()&&(TypeSignaler.getValue().equals("Trouver")))
         {
              if(passeportcin.getText().isEmpty()&&passeportnum.getText().isEmpty()&&passeportprenom.getText().isEmpty()&&passeportnom.getText().isEmpty()&&passeportcodeoays.getText().isEmpty())
              {
                   Notifications notificationBuilder2 = Notifications.create()
                    .title("erreur du passeport")
                    .text("verifier les champs passeport!")
                    .graphic(null)
                    .position(Pos.CENTER_LEFT);
                 notificationBuilder2.darkStyle();
                notificationBuilder2.showError();
               return false;
              }
                  
         }
          if (OutrePane.isVisible())
         {
              if((OutreNom.getText().isEmpty())&&(OutreDescription.getText().isEmpty()))
              {
                   Notifications notificationBuilder3 = Notifications.create()
                    .title("erreur Autre")
                    .text("verifier les champs Autre!")
                    .graphic(null)
                    .position(Pos.CENTER_LEFT);
                 notificationBuilder3.darkStyle();
                notificationBuilder3.showError();
               return false;
              }
                  
         }
         
    
     }else{
    	 Notifications notificationBuilder32 = Notifications.create()
                 .title("erreur sur La personne")
                 .text("verifier les champs du La personne annoncée!")
                 .graphic(null)
                 .position(Pos.TOP_RIGHT);
              notificationBuilder32.darkStyle();
             notificationBuilder32.showError();
    	 return false;
    	 }
	return true;

	
	}
    /*********************************************************************/
}
