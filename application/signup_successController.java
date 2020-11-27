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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class signup_successController implements Initializable{
	@FXML
	Label registerField;
	@FXML
	Button studloginBtn,bckBtn;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		int id=-1;
		try {
			DATA_BASE db=new DATA_BASE();
			id=db.getRegisterId();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		registerField.setText(Integer.toString(id));
 
		studloginBtn.setOnAction(e -> {
			 Stage s12 = (Stage)studloginBtn.getScene().getWindow();
          Parent root12=null;
          try {
               root12= FXMLLoader.load(getClass().getResource("scene2.fxml"));
          } catch (IOException ioException) {
              ioException.printStackTrace();
          }

          Scene scene12 = new Scene(root12);
          s12.setScene(scene12);	
		 });
		
		bckBtn.setOnAction(e -> {
			 Stage s6 = (Stage)bckBtn.getScene().getWindow();
          Parent root6=null;
          try {
               root6 = FXMLLoader.load(getClass().getResource("scene3.fxml"));
          } catch (IOException ioException) {
              ioException.printStackTrace();
          }

          Scene scene8 = new Scene(root6);
          s6.setScene(scene8);	
		 });
		
		
	}

}
