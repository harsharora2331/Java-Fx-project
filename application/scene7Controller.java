package application;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
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

public class scene7Controller implements Initializable  {
     
	@FXML
	Label regnoLabel,firstnameLabel,lastnameLabel,mailLabel,cnLabel,passLabel;
	
	@FXML
	TextField tf1;
	@FXML
	Button backBtn;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
     
		DATA_BASE db = null;
		try {
			db = new DATA_BASE();
			
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
	 	}
//		
	   int r=scene6Controller.r;
			

				
		String s = null;
		try {
			s = db.showdata(r);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("1");
		System.out.println(s);
		String parts[] =s.split(" ");
		int  REGNO = Integer.parseInt(parts[0]);
		regnoLabel.setText(Integer.toString(REGNO));
		String fname = parts[1];
		firstnameLabel.setText(fname);
		String lname = parts[2];
		lastnameLabel.setText(lname);
		String e_mail = parts[3];
		mailLabel.setText(e_mail);
		String phn = parts[4];
		cnLabel.setText(phn);
		String pas = parts[5];
		passLabel.setText(pas);
      //  System.out.println(REGNO + " "+ fname + " "+lname+" "+e_mail+ " "+phn+" "+pas);
		//System.out.println(parts[0]);
		
		backBtn.setOnAction(e -> {
			 Stage s6 = (Stage)backBtn.getScene().getWindow();
          Parent root6=null;
          try {
               root6 = FXMLLoader.load(getClass().getResource("scene6.fxml"));
          } catch (IOException ioException) {
              ioException.printStackTrace();
          }

          Scene scene8 = new Scene(root6);
          s6.setScene(scene8);	
		 });
//        
}}
