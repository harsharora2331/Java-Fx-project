package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class scene3Controller implements Initializable {
	String fetchQuery="insert into "+1 +"values ("+1+") ";
	@FXML
	TextField tf1,tf2,tf3,tf4,pf1;
	@FXML
	Button submitBtn,hmBtn;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		submitBtn.setOnAction(e->{
			 DATA_BASE db5 = null;
			try {
				db5 = new DATA_BASE();
			} catch (ClassNotFoundException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			 String ee = tf4.getText();
			 try {
				if(db5.userexist(ee))
				  {
					  ButtonType b3=new ButtonType("OK");
					  Alert alert1=new Alert(Alert.AlertType.INFORMATION,"Email Already exists",b3);
					  alert1.setTitle("Warning");
					  alert1.setResizable(false);
					  alert1.show();
				  }
				 else {
				
				String fn = null,ln = null,cont = null,em = null,pass = null;
				fn = tf1.getText();
				ln = tf2.getText();
				cont = tf3.getText();
				em = tf4.getText();
				pass = pf1.getText();
				if(validatedata(fn,ln,cont,em,pass)) {
					ButtonType b1 = new ButtonType("Ok");
				       Alert exit=new Alert(Alert.AlertType.ERROR,"Invalid Input..",b1);
				       exit.setTitle("Warning");
				      // exit.initModality(Modality.APPLICATION_MODAL);
				       exit.setResizable(false);
				       exit.show();
				}
				else {
				DATA_BASE db = null;
				try {
					db = new DATA_BASE();

				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String firstName=tf1.getText();
				String lastName=tf2.getText();
				String contact_no= tf3.getText();
				String email=tf4.getText();
				String password = pf1.getText();
				int reg_no = 0;
				
				
         
				try {
				   // db.insertData("signupdata", firstName, lastName, contact_no, email, password);	
					db.insertData("signupdata",reg_no,firstName , lastName,contact_no,email,password);
					db.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 Stage s11 = (Stage)submitBtn.getScene().getWindow();
				    Parent root11=null;
				    try {
				         root11 = FXMLLoader.load(getClass().getResource("signup_success.fxml"));
				    } catch (IOException ioException) {
				        ioException.printStackTrace();
				    }

				    Scene scene11 = new Scene(root11);
				    s11.setScene(scene11);	
				}}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}	
		});
		
		hmBtn.setOnAction(e -> {
			 Stage s6 = (Stage)hmBtn.getScene().getWindow();
          Parent root6=null;
          try {
               root6 = FXMLLoader.load(getClass().getResource("sample.fxml"));
          } catch (IOException ioException) {
              ioException.printStackTrace();
          }

          Scene scene8 = new Scene(root6);
          s6.setScene(scene8);	
		 });
		
	}

	private boolean validatedata(String fn, String ln, String cont, String em, String pass) {
		
		if(fn.length()==0 || ln.length()==0 || cont.length()==0 || em.length()==0 || pass.length()==0) {
			return true;
		}
		else if(cont.length()!=10) {
			return true;
		}
		else if(fn.length()>30 || ln.length()>30) {
			return true;
		}
		else if(true) {
			int k=0;
			for(int i=0;i<em.length();i++) 
			{
				if(em.charAt(i)=='@') {
					return false;
				}
				k++;
			}
			if(k==em.length())
			{  return true;}
		}
		else if(pass.length()<5 || pass.length()>10) {
			return true;
		}
		return false;
	}
	

}
