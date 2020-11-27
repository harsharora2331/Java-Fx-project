package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DATA_BASE {
	Connection con;
    Statement st;
    public DATA_BASE() throws ClassNotFoundException, SQLException {
    	String url="jdbc:mysql://localhost:3306/STS";
		String uname= "root";
		String pass = "1234";
		//String query = "insert into student values (14,'Avi',443)";
		// Load the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// Connection object
		con = DriverManager.getConnection(url,uname,pass);
		st = con.createStatement();
	    
	 
	//	System.out.println(count +" Row affected"); 
    }
   
    public  void insertData(String tablename,int regestration, String fname,String lname,String contactno, String e_mail,String pass) throws SQLException {
    	
    	String count_rows = "Select count(*) from signupdata";
		ResultSet rs = st.executeQuery(count_rows);
		rs.next();
		int count = rs.getInt("count(*)");
		System.out.println("count value is "+count);
		 regestration = count+=1;
		System.out.println("reg_no value is "+regestration);
		System.out.println("Table contains "+rs.getInt("count(*)")+" rows");
    	String insertQuery="insert into "+tablename+"(Reg_no,First_name , Last_name, Email, contact_number,Pass_word)" +" values ("+regestration+",'"+fname+"','"+lname+"','"+e_mail+"','"+contactno+"','"+pass+"');";
       
    	System.out.println(insertQuery);
        System.out.println("You registered Successfully");
        System.out.println("Your registration number is ");
        st.executeUpdate(insertQuery);
        con.close();
    }
    public String showdata(int Regno) throws SQLException {
    	System.out.println(Regno);
    	String show_query = "Select * from signupdata where Reg_no="+Regno;
    	ResultSet rs = st.executeQuery(show_query);
    	if(!rs.next()) {
    	System.out.println("Hello i am here");
    		return "bye";
    	}
    	    String ans;
    	    int REGNO;
    		String fname,lname,email,phone,pass;
    		REGNO = rs.getInt(1);
    		fname = rs.getString(2);
    	    lname = rs.getString(3);
    	    email = rs.getString(4);
    	    phone = rs.getString(5);
    	    pass = rs.getString(6);
    	    ans = REGNO +" "+ fname+" "+lname+" "+email+" "+phone+" "+pass;
    	    return ans;
    	    
   }
    	
    
    public int getRegisterId() throws SQLException {
    	String query = "Select Reg_no from signupdata where Reg_no=(Select Max(Reg_no) from signupdata)";
    	ResultSet rs=st.executeQuery(query);
    	rs.next();
    	System.out.println(" ID is "+rs.getInt(1));
    	return rs.getInt(1);
    	
    }
   
	public void close() {
		
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}   // delete from signupdata where email = 'email';
	public void deleteValue(String email) throws SQLException {
	      String q = "Delete from signupdata where Email = "+"'"+email+"';";
	        
		st.executeUpdate(q);
	      
	}
	   // UPDATE table_name
		//  SET column1 = '3', column2 = 'hrsh', ...
		//	WHERE condition;
	public void UPVALUE(int regno,String fname,String lname,String email,String contact) throws SQLException {
		String qq = "UPDATE signupdata SET Reg_no ="+""+regno+", First_name ='"+fname+"', Last_name ='"+lname+"', Email ='"+email+"', contact_number ='"+contact+"' Where Reg_no ="+regno+";";
	    System.out.println(qq);
	    st.executeUpdate(qq);
	}
    
	public ObservableList<Users> getData() {
		// TODO Auto-generated method stub
		ObservableList<Users> list = FXCollections.observableArrayList();
    	try {
    		PreparedStatement ps = 	con.prepareStatement("select * from signupdata");  
    		ResultSet rs = ps.executeQuery();
    		while(rs.next()) {
    			list.add(new Users(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
    		}
    	}catch(Exception e ) {
    	
    	}
    	return list;
	}


//	public String getpass(int regNo) throws SQLException {
//		// TODO Auto-generated method stub
//		String q = "Select Pass_word from signupdata Where Reg_no ='" + regNo +"';";
//		ResultSet rs=st.executeQuery(q);
//		rs.next();
//		String pp = rs.getString(1);
//		return pp;
//	}  

	public boolean userexist(String email) throws SQLException {
		// TODO Auto-generated method stub
		String query5="Select * from signupdata where Email='"+email+"';";
		ResultSet rs=st.executeQuery(query5);
		if(rs.next()==false)
		{
			return false;
		}
		return true;
	}

	public boolean checkUser(int regNo, String pp) throws SQLException {
		// TODO Auto-generated method stub
		//Statement st=con.createStatement();
		String query5="select * from signupdata where Reg_no='" +regNo +"' and Pass_word ='" + pp +"';"; 
		ResultSet rs=st.executeQuery(query5);
		if(rs.next()==false)
		{
		  return true;
		}
		return false;
	}

	public String getpass(int regNo) throws SQLException {
		System.out.println("line in database function");
		// TODO Auto-generated method stub
		String q = "Select Pass_word from signupdata Where Reg_no ='" + regNo +"';";
		ResultSet rs=st.executeQuery(q);
		rs.next();
		String pp = rs.getString(1);
		System.out.println("DATA BASE PASS IS "+pp);
		return pp;
		
	}

}
