/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interftext;

import com.WD.DAOimpl.CentreDao;
import com.WD.entities.Center;
import com.mysql.jdbc.Connection;
import java.sql.*;
import com.mysql.jdbc.Statement;
import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;
import com.sun.tools.xjc.reader.xmlschema.bindinfo.BIConversion.Static;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;
import javafx.util.Duration;
import static jdk.nashorn.internal.objects.NativeRegExp.source;
import org.controlsfx.control.Notifications;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * FXML Controller class
 *
 * @author khale
 */
public class Interface1Controller implements Initializable {

	
    @FXML
    private Button connect_id;
    @FXML
    private TextField user;
    @FXML
    private PasswordField password;
    CentreDao cd =new CentreDao();
    public static int cont=7;
    public static Center staticcenter;
    
	/**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    	 List<Center> centrs =cd.listerTous();
    }    

    private void fermer_fenetre(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void se_connecter(ActionEvent event) throws IOException, SQLException {
        AnchorPane root = FXMLLoader.load(getClass().getResource("index.fxml"));
        Stage stage1 = (Stage) connect_id.getScene().getWindow();

       // Image img =new Image("*/small_tick.png");
        
        String us = user.getText();
        String pass = password.getText();
        List<Center> centrs =cd.listerParNom(us);
        if (centrs.size()==0) {
        	Notifications notificationBuilder = Notifications.create()
                    .title("erreur")
                    .text("informations incorrect!")
                    .graphic(null)
                    .position(Pos.CENTER);
                 notificationBuilder.darkStyle();
                notificationBuilder.showError();
                
                user.setText("");
                password.setText("");
		}else {
			if (centrs.get(0).getNoncenter().equals(us)&&centrs.get(0).getMotDePasse().equals(pass)) {
				try {
					FileWriter file=new FileWriter("center.wd");
					PrintWriter pw=new PrintWriter(file);
					pw.println(String.valueOf( centrs.get(0).getIdcenter() )   );
					pw.close();
					file.close();
				
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				
				String id="";
		    	try {
					FileReader fr=new FileReader("center.wd");
					BufferedReader br = new BufferedReader(fr);
					id =br.readLine();
					br.close();
					fr.close();
				} catch (Exception e) {
					// TODO: handle exception
				}
		    	
		    	System.out.println(id);
			
					Scene scene = new Scene(root);  
                    Stage primaryStage=new Stage();
                    primaryStage.setTitle("index");
                    primaryStage.setScene(scene);
                    primaryStage.show();
                    
                    Notifications notificationBuilder = Notifications.create()
                           .title("connexion réussie")
                           .text("Bienvenue!")
                           .graphic(null)
                            //.graphic(new ImageView(img))
                           .hideAfter(Duration.seconds(5))
                           .position(Pos.BOTTOM_RIGHT);
                     notificationBuilder.darkStyle();
                    notificationBuilder.showConfirm();
                   
                    stage1.close();        
                  
			}
		}
       
        if (us.isEmpty() || pass.isEmpty())
        {
           Notifications notificationBuilder = Notifications.create()
                .title("erreur")
                .text("verifier les champs!")
                .graphic(null)
                .position(Pos.CENTER);
             notificationBuilder.darkStyle();
           notificationBuilder.showError();
         
        }
       
         
      
        
       
      
    }
    @FXML
    private void onclick_enter(KeyEvent event) throws IOException, SQLException
    { 		
    	if (event.getCode() == KeyCode.ENTER) {
    	se_connecter(null);
    	}
    	/*
    	  AnchorPane root = FXMLLoader.load(getClass().getResource("index.fxml"));
          Stage stage1 = (Stage) connect_id.getScene().getWindow();

          
          String us = user.getText();
          String pass = password.getText();
          List<Center> centrs =cd.listerParNom(us);
          if (event.getCode() == KeyCode.ENTER) {
          if (centrs.size()==0) {
          	Notifications notificationBuilder = Notifications.create()
                      .title("erreur")
                      .text("informations incorrect!")
                      .graphic(null)
                      .position(Pos.CENTER);
                   notificationBuilder.darkStyle();
                  notificationBuilder.showError();
                  
                  user.setText("");
                  password.setText("");
  		}else {
  			if (centrs.get(0).getNoncenter().equals(us)&&centrs.get(0).getMotDePasse().equals(pass)) {
  				try {
					FileWriter file=new FileWriter("center.wd");
					PrintWriter pw=new PrintWriter(file);
					pw.println(String.valueOf( centrs.get(0).getIdcenter() )   );
					pw.close();
					file.close();
				
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
  								
  					Scene scene = new Scene(root);  
                      Stage primaryStage=new Stage();
                      primaryStage.setTitle("index");
                      primaryStage.setScene(scene);
                      primaryStage.show();
                      
                      Notifications notificationBuilder = Notifications.create()
                             .title("connexion réussie")
                             .text("Bienvenue!")
                             .graphic(null)
                              //.graphic(new ImageView(img))
                             .hideAfter(Duration.seconds(5))
                             .position(Pos.BOTTOM_RIGHT);
                       notificationBuilder.darkStyle();
                      notificationBuilder.showConfirm();
                     
                      stage1.close();        
                    
  			}
  		}
         
          if (us.isEmpty() || pass.isEmpty())
          {
             Notifications notificationBuilder = Notifications.create()
                  .title("erreur")
                  .text("verifier les champs!")
                  .graphic(null)
                  .position(Pos.CENTER);
               notificationBuilder.darkStyle();
             notificationBuilder.showError();
           
          }
          }*/
    }
    
    
}
