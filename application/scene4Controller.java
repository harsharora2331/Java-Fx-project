package application;

import java.io.IOException;
import java.net.URL;
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
import javafx.stage.Stage;

public class scene4Controller implements Initializable {
    
	@FXML
	Button adminloginBtn,backBtn,adminhomeBtn;
	@FXML
	TextField adminlogintf;
	@FXML
	PasswordField adminloginpf;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		 adminloginBtn.setOnAction(e -> {
			    String user,pass;
			 	user = adminlogintf.getText();
				pass = adminloginpf.getText();
				String usercheck = "harsharora2331@gmail.com";
				String passcheck = "harsh2331";
				if(user.equals(usercheck) && pass.equals(passcheck)) {
					Stage s3 = (Stage)adminloginBtn.getScene().getWindow();
		             Parent root3=null;
		             try {
		                  root3 = FXMLLoader.load(getClass().getResource("scene5.fxml"));
		             } catch (IOException ioException) {
		                 ioException.printStackTrace();
		             }

		             Scene scene5 = new Scene(root3);
		             s3.setScene(scene5);
				}else {
					ButtonType b1 = new ButtonType("Ok");
			           Alert exit=new Alert(Alert.AlertType.ERROR,"Username Or Password are incorrect... ",b1);
			           exit.setTitle("Warning");
			          // exit.initModality(Modality.APPLICATION_MODAL);
			           exit.setResizable(false);
			           exit.show();
				}

//			 Stage s3 = (Stage)adminloginBtn.getScene().getWindow();
//             Parent root3=null;
//             try {
//                  root3 = FXMLLoader.load(getClass().getResource("scene5.fxml"));
//             } catch (IOException ioException) {
//                 ioException.printStackTrace();
//             }
//
//             Scene scene5 = new Scene(root3);
//             s3.setScene(scene5);	
		 });
		 
		 adminhomeBtn.setOnAction(e -> {
			 Stage s8 = (Stage)adminhomeBtn.getScene().getWindow();
           Parent root8=null;
           try {
                root8 = FXMLLoader.load(getClass().getResource("sample.fxml"));
           } catch (IOException ioException) {
               ioException.printStackTrace();
           }

           Scene scene10 = new Scene(root8);
           s8.setScene(scene10);	
		 });
		
		
	}

}
