package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class scene5Controller implements Initializable{
	
	@FXML
	Button logoutBtn;
	@FXML
	Button viewstudentBtn;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		 logoutBtn.setOnAction(e -> {
			 Stage s4 = (Stage)logoutBtn.getScene().getWindow();
             Parent root4=null;
             try {
                  root4 = FXMLLoader.load(getClass().getResource("scene4.fxml"));
             } catch (IOException ioException) {
                 ioException.printStackTrace();
             }

             Scene scene6 = new Scene(root4);
             s4.setScene(scene6);	
		 });
		 
		 viewstudentBtn.setOnAction(e -> {
			 
			 Stage s24 = (Stage)viewstudentBtn.getScene().getWindow();
             Parent root24=null;
             try {
                  root24 = FXMLLoader.load(getClass().getResource("scene8.fxml"));
                  
             } catch (IOException ioException) {
                 ioException.printStackTrace();
             }

             Scene scene24 = new Scene(root24);
             s24.setScene(scene24);	
		 });
		
		
	}

}
