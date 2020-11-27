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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class scene6Controller  implements Initializable{
	public static int r;
	
    @FXML
    Button studentlogoutBtn,studsubmitBtn;
    @FXML
    TextField tf1;                // initialize,submitlogin,
    
	@Override
	public void initialize(URL location, ResourceBundle resources) 
	{
		studentlogoutBtn.setOnAction(e -> 
		{
			 Stage s6 = (Stage)studentlogoutBtn.getScene().getWindow();
			 Parent root6=null;
			 try 
			 {
                root6 = FXMLLoader.load(getClass().getResource("scene2.fxml"));
			 } 
			 catch (IOException ioException) 
			 {
               ioException.printStackTrace();
			 }

			 Scene scene8 = new Scene(root6);
			 s6.setScene(scene8);	
		 });
			
		studsubmitBtn.setOnAction(e -> 
		{
			if(tf1.getText().length()>=0)
			{  try {
		         r = Integer.parseInt(tf1.getText());
		         //int reg1 ;
		         //try {
						//reg1=Integer.parseInt(tf1.getText());
						
						Stage s14 = (Stage)studsubmitBtn.getScene().getWindow();
				          Parent root14=null;
				          try {
			                 root14 = FXMLLoader.load(getClass().getResource("scene7.fxml"));
				          } catch (IOException ioException) {
			                ioException.printStackTrace();
				          }

			            Scene scene14 = new Scene(root14);
			            s14.setScene(scene14);	
						
					}
		         	catch(Exception ex) 
		         	{
						ButtonType b1 = new ButtonType("Ok");
				           Alert exit=new Alert(Alert.AlertType.WARNING,"Please Check Your Regestration Number..",b1);
				           exit.setTitle("Warning");
				          // exit.initModality(Modality.APPLICATION_MODAL);
				           exit.setResizable(false);
				           exit.show();
					}
			}
//			
		});
		}
	}
//			
		