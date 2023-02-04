package application;

public class Passenger {
	
	

	
	int accountId;
	int passengerId;
	String name;
	ValidDate birthDate;
	String gender;
	int PhoneNum;
	
	
	
	
	public Passenger(String name, ValidDate birthDate, String gender, int phoneNum) {
		
		this.name = name;
		this.birthDate = birthDate;
		this.gender = gender;
		PhoneNum = phoneNum;
	}
	
	
	
	public Passenger(int passengerId,int accountId, String name, ValidDate birthDate, String gender, int phoneNum) {
	
		this.accountId = accountId;
		this.passengerId = passengerId;
		this.name = name;
		this.birthDate = birthDate;
		this.gender = gender;
		PhoneNum = phoneNum;
	}
	public Passenger(int accountId, String name, ValidDate birthDate, String gender, int phoneNum) {
		
		this.accountId = accountId;
	
		this.name = name;
		this.birthDate = birthDate;
		this.gender = gender;
		PhoneNum = phoneNum;
	}




	@Override
	public String toString() {
		return "Passenger: "+ name+ "\nBirthDate: "
				+ birthDate + "\nGender: " + gender + "\nPhone Number: " + PhoneNum ;
	}



	public int getAccountId() {
		return accountId;
	}



	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}



	public int getPassengerId() {
		return passengerId;
	}



	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public ValidDate getBirthDate() {
		return birthDate;
	}



	public void setBirthDate(ValidDate birthDate) {
		this.birthDate = birthDate;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public int getPhoneNum() {
		return PhoneNum;
	}



	public void setPhoneNum(int phoneNum) {
		PhoneNum = phoneNum;
	}


	

}
