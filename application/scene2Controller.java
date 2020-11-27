package application;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class scene2Controller implements Initializable {
    @FXML
    TextField tf1;
    PasswordField pf11;
	@FXML
    Button loginBtn,homeBtn;
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		loginBtn.setOnAction(e -> {
			
//		   int regNo = -1;
		   String pass = null;
		   try {
			   	System.out.println("Line 1");
			   int regNo = Integer.parseInt(tf1.getText());
			   //	String regNo = tf1.getText();
			   //	System.out.println("Line before calling");
                //System.out.println("REgNo is "+regNo+"Pass is "+pf11.getText());
			    //boolean b = check(regNo,pf11.getText());
//			   	System.out.println("line after calling");
//			   	if(b==true) {
//			   		throw new Exception();
//			   	}
			   	
			   			System.out.println("LIne 3");
			   			Stage s57 = (Stage)loginBtn.getScene().getWindow();
			   			Parent root57=null;
			   			try {
			   				root57 = FXMLLoader.load(getClass().getResource("scene6.fxml"));
			   			} catch (IOException ioException) {
			   				ioException.printStackTrace();
			   			}
		   
			   			Scene scene59 = new Scene(root57);
			   			s57.setScene(scene59);	
			 
		  }
		   catch(Exception ex) {
			   System.out.println("Line 4 ");
			   ButtonType b1 = new ButtonType("Ok");
				Alert exit=new Alert(Alert.AlertType.ERROR,"Invalid Input",b1);
				exit.setTitle("Conformation");
				// exit.initModality(Modality.APPLICATION_MODAL);
				exit.setResizable(false);
				exit.show();
		   }
	    });
		    
		
		
		
		homeBtn.setOnAction(e1 ->
		{
			 Stage s7 = (Stage)homeBtn.getScene().getWindow();
           Parent root7=null;
           try {
                root7 = FXMLLoader.load(getClass().getResource("sample.fxml"));
           } catch (IOException ioException) {
               ioException.printStackTrace();
           }

           Scene scene9 = new Scene(root7);
           s7.setScene(scene9);	
		});

		}

//	public boolean check(int regNo,String pass)   {
//		System.out.println("Line inside function");
//		System.out.println("REgno is "+regNo);
//		System.out.println("Pass is "+pass);
//		DATA_BASE db6 = null;
//		try {
//			db6 = new DATA_BASE();
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			System.out.println("A");
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			System.out.println("B");
//			e.printStackTrace();
//		}
//		String s = null;
//		try {
//			System.out.println("calling get pass function");
//			s = db6.getpass(regNo);
//			System.out.println("get pass function completed");
//		} catch (SQLException e) {
//			System.out.println("C");
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	
//		if(!s.equals(pass)) {
//			return true;
//		}
//		return false;
//	}

}
