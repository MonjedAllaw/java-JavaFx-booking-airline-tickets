package application;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTable;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Database {
	
    private String databaseName;
    private Connection con;
	Database(String databaseName){
		this.databaseName=databaseName;
		
		
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			this.con=DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/"+databaseName+"","root","");
			
			
			
			}catch(Exception e){
				System.out.println(e);}
	}
		
	
	
	public void printAccounts() {
		try {
			
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("select * from  account");
		while(rs.next())
		System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+" "+rs.getInt(4));
		
		}catch(Exception e){
			System.out.println(e);}
	}
	
	
	public void closeConnection() throws SQLException {
		con.close();
		
	}
	
	public void openConnection() throws SQLException {
		this.con=DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/"+databaseName+"","root","");
	}
	
	public boolean checkAccount(String email,String pass) {
		
		 try
	        {
	            
	            String query = "Select * from account where acc_email='"+email+"' and acc_password='"+pass+"'";
	            PreparedStatement preparedStmt = con.prepareStatement(query);
	            
	            ResultSet rs = preparedStmt.executeQuery();
	            
	        	if(rs.next()) {
	    			return true;
	    		}
	    		return false;
	   

	      
	        }
	        catch (Exception e)
	        {
	            System.err.println(e.getMessage());
	        } 	
		 
		 return false;
	}
	
	
	
	public Account getAccount(String email,String pass) {
		
		 try
	        {
	            
	            if( checkAccount(email,pass)) {
	            	 
	            	
	       
	                String query = "Select * from account where acc_email='"+email+"' and acc_password='"+pass+"'";
		            PreparedStatement preparedStmt = con.prepareStatement(query);
		           
		            ResultSet rs = preparedStmt.executeQuery();
	            	
	        		
	        		rs.next();
	            	Account ac = new Account(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4));
	            	return ac;
	            }
	            
	          
	            
	    		return null;
	   

	      
	        }
	        catch (Exception e)
	        {
	            System.err.println(e.getMessage());
	        } 	
		
          
		 return null;
	}
	
    public void insertAccount(String email, String pass) {
    	
        try
        {
        
            String query = " insert into account (acc_email,acc_password) values (?, ?)";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString (1, email);
            preparedStmt.setString  (2, pass);
           

            preparedStmt.execute();


            
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
        }
    }
    
    public void insertFlight(String departure,String destination,ValidDate date,ValidTime time) {
        try
        {
            
            String query = " insert into flight(f_departure,f_destination,f_date,f_time) values (?, ?, ? , ?)";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString (1, departure);
            preparedStmt.setString  (2, destination);
            preparedStmt.setString (3, date.toDb());
            preparedStmt.setString  (4, time.toString());
           

            preparedStmt.execute();


         
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
        }
    }
    
    
    public ObservableList<Flight> getAllFlights(){
		final ObservableList<Flight> data = FXCollections.observableArrayList ();
		try {
			
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from  flight");
			while(rs.next()) {
				data.add(new Flight (rs.getInt(1),rs.getString(2),rs.getString(3),new ValidDate(rs.getDate(4).toString()),new ValidTime(rs.getString(5)) )) ;
			}
				
			
			}catch(Exception e){
				System.out.println(e);}
		
		
		return data;
		
	}
    
    
    
    
    
    
    
    
    public void insertPassenger(int accountid,String name, ValidDate birthDate, String gender, int phoneNum) {
        try
        {
            
            String query = " insert into passenger(acc_id,p_name,p_birthdate,p_gender,p_phone) values (?, ?, ? , ?, ?)";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString (1,Integer.toString(accountid));
            preparedStmt.setString  (2, name);
            preparedStmt.setString (3, birthDate.toDb());
            preparedStmt.setString  (4,gender);
            preparedStmt.setString (5,Integer.toString(phoneNum));
           

            preparedStmt.execute();


         
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
        }
    }
    
    
    public ObservableList<Passenger> getAllPassengers(int id){
		final ObservableList<Passenger> data = FXCollections.observableArrayList ();
		try {
			
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from passenger where acc_id='"+id+"'");
			
			while(rs.next()) {
				data.add(new Passenger (rs.getInt(1),rs.getInt(2),rs.getString(3),new ValidDate(rs.getDate(4).toString()),rs.getString(5),rs.getInt(6))) ;
			}
				
			
			}catch(Exception e){
				System.out.println(e);}
		
		
		return data;
		
	}
    
    public void insertTicket(int accountid,int passengerId, int flightId, String travelClass) {
        try
        {
            
            String query = " insert into ticket(acc_id,p_id,f_id,travel_class) values (?, ?, ? , ?)";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString (1,Integer.toString(accountid));
            preparedStmt.setString  (2, Integer.toString(passengerId));
            preparedStmt.setString (3, Integer.toString(flightId));
            preparedStmt.setString  (4,travelClass);
 
           

            preparedStmt.execute();


         
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
        }
    }
}

    
