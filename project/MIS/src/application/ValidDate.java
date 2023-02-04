package application;


import java.util.regex.Pattern;

public class ValidDate {
	private int day;
	private int month;
	private int year;
	private int daysInMonth;
	

	
	
	public ValidDate(String date) {
		
	
		
		if(correctPattern(date)) {
			
			
			if(Pattern.matches("\\d\\d\\d\\d-\\d\\d-\\d\\d", date)) {
				String parts[] = date.split("-");
				
				if( Integer.parseInt(parts[0])<=0) { 
					System.out.print("invalid year");
					this.year=1;
					
				
				}else {
					this.year= Integer.parseInt(parts[0]);
				}
				
				if( Integer.parseInt(parts[1])<=0  || Integer.parseInt(parts[1])>12) { 
					System.out.print("invalid month");	
					this.month=1;
				
				}else {
					this.month= Integer.parseInt(parts[1]);
				}
				daysInMonth= nbOfDays(this.year,this.month);
				if( Integer.parseInt(parts[2])<=0  || Integer.parseInt(parts[2])>daysInMonth) { 
					System.out.print("invalid day");	
					this.day=1;
				
				}else {
					this.day= Integer.parseInt(parts[2]);
				}
				
			
				
			}else {
			String parts[] = date.split("-");
			
			if( Integer.parseInt(parts[2])<=0) { 
				System.out.print("invalid year");
				this.year=1;
				
			
			}else {
				this.year= Integer.parseInt(parts[2]);
			}
			
			if( Integer.parseInt(parts[1])<=0  || Integer.parseInt(parts[1])>12) { 
				System.out.print("invalid month");	
				this.month=1;
			
			}else {
				this.month= Integer.parseInt(parts[1]);
			}
			daysInMonth= nbOfDays(this.year,this.month);
			if( Integer.parseInt(parts[0])<=0  || Integer.parseInt(parts[0])>daysInMonth) { 
				System.out.print("invalid day");	
				this.day=1;
			
			}else {
				this.day= Integer.parseInt(parts[0]);
			}
			
			
		}
			
		}else {
			System.out.println("invalid date");
			this.year=2022;
			this.month=1;
			this.day=1;
			
			
		}
		
	}
	
	public ValidDate(int day,int month,int year) {
		
		if (year >0) {
			this.year= year;
			
		}else {
			System.out.println("invalid year");
			this.year=2022;
		}
		
		
		
		if(month <1 || month>12) {
			System.out.println("invalid month(default is 1)");
			this.month=1;
		}else {
			this.month=month;
		}
		
		
		daysInMonth= nbOfDays(this.year,this.month);
		if(day<1 || day>daysInMonth) {
			System.out.println("invalid day(default is 1)");
			this.day=1;
		}else {
			this.day=day;
		}	
		
	}
	
	
	
	public int getDay() {
		return this.day;
	}
	public int getMonth() {
		
		return this.month;
	}
	public int getyear() {
		return this.year;
	}
	
	public void setDay(int day) {
		if(day<1 || day>daysInMonth) {
			System.out.println("invalid day");
			
		}else {
			this.day=day;
		}
			
	}
	
	public void setMonth(int month) {
		if(month <1 || month>12) {
			System.out.println("invalid month");
		
		}else {
			this.month=month;
		}
	}
	
	public void setYear(int year) {
		if(year <1 ) {
			System.out.println("invalid year");
		}else {
			this.year=year;
		}
	}
	
	
	public String toString() {
		return day+"-"+month+"-"+year;
		
	}
	
	public String toDb() {
		return year+"-"+month+"-"+day;
		
	}
	
	
	
	private static boolean correctPattern(String date ) {
	
		if(Pattern.matches("\\d\\d-\\d\\d-\\d\\d\\d\\d", date) ||Pattern.matches("\\d-\\d-\\d\\d\\d\\d", date) 
				||Pattern.matches("\\d-\\d\\d-\\d\\d\\d\\d", date) || Pattern.matches("\\d\\d-\\d-\\d\\d\\d\\d", date)
				|| Pattern.matches("\\d\\d\\d\\d-\\d\\d-\\d\\d", date)) {
		
		
			return true;}
		return false;
	}
	
	
	static int nbOfDays(int y,int month) {
		int n=-1 ;
		
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			n=31;
			break;
			
		case 4:
		case 6:
		case 9:
		case 11:
			n=30;
			break;
			
		case 2:
			if((y%100 == 0 && y%400 == 0)|| (y%4==0)) 
				n=29;	
			else
				n=28;
		 break;
	}
		return n;
			
		
	}
	
	
	public static boolean isValid(String date) {
		int year;
		int month;
		int daysInMonth;
		
		
		if(correctPattern(date)) {
				
			System.out.println("here");
				if(Pattern.matches("\\d\\d\\d\\d-\\d\\d-\\d\\d", date)) {
					System.out.println("here2");
					String parts[] = date.split("-");
					
					if( Integer.parseInt(parts[0])<=0) { 
						System.out.print("invalid year");
						return false;
						
					
					}else {
						year= Integer.parseInt(parts[0]);
					}
					
					if( Integer.parseInt(parts[1])<=0  || Integer.parseInt(parts[1])>12) { 
						System.out.print("invalid month");	
						return false;
					
					}else {
						month= Integer.parseInt(parts[1]);
					}
					daysInMonth= nbOfDays(year,month);
					if( Integer.parseInt(parts[2])<=0  || Integer.parseInt(parts[2])>daysInMonth) { 
						System.out.print("invalid day");	
						return false;
					
					}else {
						return true;	
					}
			}else {
			String parts[] = date.split("-");
			if( Integer.parseInt(parts[2])<=0) { 
				System.out.print("invalid year");
				return false;
				
				
			
			}else {
				year= Integer.parseInt(parts[2]);
			}
			
			if( Integer.parseInt(parts[1])<=0  || Integer.parseInt(parts[1])>12) { 
				System.out.print("invalid month");
				return false;
				
			
			}else {
				 month= Integer.parseInt(parts[1]);
			}
		    daysInMonth= nbOfDays(year,month);
		    
			if( Integer.parseInt(parts[0])<=0  || Integer.parseInt(parts[0])>daysInMonth) { 
				System.out.print("invalid day");	
				return false;
			
			}else {
				return true;	
			}}
			
			
			
			
		}else 
			return false;
			
	
		
	
	}

	}