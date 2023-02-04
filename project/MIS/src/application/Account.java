package application;

public class Account {
	private int id;
	private String email;
	private String password;
	private int isAdmin;
	
	public Account(){
		
	};
	public Account(int id,String email, String pass,int isAdmin){
		this.id= id;
		this.email=email;
		this.password=pass;
		this.isAdmin=isAdmin;
		
	}
	public int isAdmin() {
		return isAdmin;
	}
	public void setAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email +", is admin="+isAdmin+ "]";
	}
	public int getId() {
		return id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	};
	
	

}
