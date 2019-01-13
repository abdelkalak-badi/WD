/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dw.PIndex.Signaler;

import com.WD.DAOimpl.AutreDao;
import com.WD.DAOimpl.CarteCinDao;
import com.WD.DAOimpl.CentreDao;
import com.WD.DAOimpl.ObjectDao;
import com.WD.DAOimpl.PassportDao;
import com.WD.DAOimpl.PersonneDao;
import com.WD.DAOimpl.ReclamationDao;
import com.WD.entities.Autre;
import com.WD.entities.Cartecin;
import com.WD.entities.Object;
import com.WD.entities.Passeport;
import com.WD.entities.Personne;
import com.WD.entities.Reclamation;
import com.sun.javafx.beans.event.AbstractNotifyListener;
import com.sun.javafx.property.adapter.PropertyDescriptor;
import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author BADI-PC
 */
public class Signaler_D_existantsController implements Initializable {

    @FXML
    private ComboBox<String> passeportType;
    @FXML
    private ComboBox<String> passeportSexe;

    List<String> ListTypeObject,ListTypeSignaler,ListpasseportTypeListSexe;
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
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
        ListpasseportTypeListSexe=new ArrayList<String>();
    	ListpasseportTypeListSexe.add("Homme");
        ListpasseportTypeListSexe.add("Famme");
    	options=FXCollections.observableArrayList(ListpasseportTypeListSexe);
        passeportSexe.setValue("Homme");
    	passeportSexe.setItems(options);
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
    	r.setCenter(cd.FinList());
    	o=od.FinList();
    	r.setObject(o);
    	r.setIdreclamation(55);
    	
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
    		passeport.setCin(passeportcin.getText().toString());
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
        	cartecin.setNumcin(CarteCINCin.getText().toString());
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
    	
    }
    
}
