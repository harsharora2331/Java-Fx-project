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


public class sampleControler implements Initializable{
        @FXML
        Button loginBtn1,SignupBtn,adminBtn;
	
		 @Override
		public void initialize(URL location, ResourceBundle resources)
		{
			loginBtn1.setOnAction(e -> 
			  {
	            Stage s = (Stage)loginBtn1.getScene().getWindow();
	           
	              Parent root=null;
	              try {
	                   root = FXMLLoader.load(getClass().getResource("scene2.fxml"));
	              } catch (IOException ioException) {
	                  ioException.printStackTrace();
	              }
	
	              Scene ss = new Scene(root);
	              s.setScene(ss);
			   }
			   );
	          
			  SignupBtn.setOnAction(a ->
	          {
	  	            Stage s2 = (Stage)SignupBtn.getScene().getWindow();
	  	              Parent root1=null;
	  	              try {
	  	                   root1 = FXMLLoader.load(getClass().getResource("scene3.fxml"));
	  	              } catch (IOException ioException) {
	  	                  ioException.printStackTrace();
	  	              }
	  	
	  	              Scene scene3 = new Scene(root1);
	  	              s2.setScene(scene3);
				
	          }
	          );
			
			  adminBtn.setOnAction(e -> 
			  {
	            Stage s3 = (Stage)adminBtn.getScene().getWindow();
	              Parent root2=null;
	              try {
	                   root2 = FXMLLoader.load(getClass().getResource("scene4.fxml"));
	              } catch (IOException ioException) {
	                  ioException.printStackTrace();
	              }
	
	              Scene scene4 = new Scene(root2);
	              s3.setScene(scene4);
			   }
			   );
		
		 }}
