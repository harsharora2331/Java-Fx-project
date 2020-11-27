package application;

public class Users {
      int RegNo;
      String fname,lname,email,contact;
public Users(int regNo, String fname, String lname, String email, String contact) {
		super();
		RegNo = regNo;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.contact = contact;
	}

	public int getRegNo() {
		return RegNo;
	}
	public void setRegNo(int regNo) {
		RegNo = regNo;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}

      

}
