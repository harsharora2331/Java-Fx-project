package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class scene8Controller implements Initializable {
    
	@FXML
    private Button db_updataBtn;
	
	@FXML
    private Button backBtn;

    @FXML
    private Button db_deleteBtn;

    @FXML
    private TextField tf_regno;

    @FXML
    private TextField tf_fname;

    @FXML
    private TextField tf_contact;

    @FXML
    private TextField tf_lname;

    @FXML
    private TextField tf_email;
    
    @FXML
    private TextField tf_delete;

    @FXML
    private TableView<Users> table_users;

    @FXML
    private TableColumn<Users, Integer> regno_col;

    @FXML
    private TableColumn<Users, String> fname_col;

    @FXML
    private TableColumn<Users, String> lname_col;

    @FXML
    private TableColumn<Users, String> email_col;

    @FXML
    private TableColumn<Users, String> contact_col;

    @FXML
    private Button bkBtn;
    ObservableList<Users> listM;
    int index = -1;
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		regno_col.setCellValueFactory(new PropertyValueFactory<Users,Integer>("regNo"));
		fname_col.setCellValueFactory(new PropertyValueFactory<Users,String>("fname"));
		lname_col.setCellValueFactory(new PropertyValueFactory<Users,String>("lname"));
		email_col.setCellValueFactory(new PropertyValueFactory<Users,String>("email"));
		contact_col.setCellValueFactory(new PropertyValueFactory<Users,String>("contact"));
		try {
			DATA_BASE db2 = new DATA_BASE();
			listM = db2.getData();
			table_users.setItems(listM);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 
		 db_deleteBtn.setOnAction(e -> {
			 Stage s20 = (Stage)db_deleteBtn.getScene().getWindow();
          Parent root20=null;
          try {
        	   String em = tf_delete.getText();
        	   try {
				DATA_BASE db3 = new DATA_BASE();
				db3.deleteValue(em);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        	   
               root20 = FXMLLoader.load(getClass().getResource("scene8.fxml"));
          } catch (IOException ioException) {
              ioException.printStackTrace();
          }

          Scene scene20 = new Scene(root20);
          s20.setScene(scene20);	
          
          ButtonType b1 = new ButtonType("Ok");
			Alert exit=new Alert(Alert.AlertType.CONFIRMATION,"Data Successfully Deleted",b1);
			exit.setTitle("Conformation");
			// exit.initModality(Modality.APPLICATION_MODAL);
			exit.setResizable(false);
			exit.show();
		 });
		
		 
		 db_updataBtn.setOnAction(e -> {
			 Stage s21 = (Stage)db_updataBtn.getScene().getWindow();
          Parent root21=null;
          try {
        	   int reg = Integer.parseInt(tf_regno.getText());
        	   String fn = tf_fname.getText();
        	   String ln = tf_lname.getText();
        	   String cont = tf_contact.getText();
        	   String em1 = tf_email.getText();
        	   try {
				DATA_BASE db4 = new DATA_BASE();
				db4.UPVALUE(reg, fn, ln, em1, cont);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        	   
               root21 = FXMLLoader.load(getClass().getResource("scene8.fxml"));
          } catch (IOException ioException) {
              ioException.printStackTrace();
          }

          Scene scene21 = new Scene(root21);
          s21.setScene(scene21);	
          
          ButtonType b1 = new ButtonType("Ok");
			Alert exit=new Alert(Alert.AlertType.CONFIRMATION,"Data Successfully Updated",b1);
			exit.setTitle("Conformation");
			// exit.initModality(Modality.APPLICATION_MODAL);
			exit.setResizable(false);
			exit.show();
          
		 });
		
		 bkBtn.setOnAction(e -> {
			 Stage s6 = (Stage)bkBtn.getScene().getWindow();
           Parent root6=null;
           try {
                root6 = FXMLLoader.load(getClass().getResource("scene5.fxml"));
           } catch (IOException ioException) {
               ioException.printStackTrace();
           }

           Scene scene8 = new Scene(root6);
           s6.setScene(scene8);	
		 });
	}

}
