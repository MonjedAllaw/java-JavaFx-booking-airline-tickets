package application;
import java.util.regex.*;

public class ValidTime {

	private String hour;
	private String minutes;
	

	public ValidTime(String time) {
		if(Pattern.matches("\\d\\d:\\d\\d", time)) {
			if( Integer.parseInt(time.substring(0,2))>=24
				 || Integer.parseInt(time.substring(3,5))>=60) { //negative input will be validated in the regex since - will ruin the pattern
				System.out.print("invalid time");
				this.hour="00";
				this.minutes = "00";
			
			}else {
				this.hour=time.substring(0,2);
				this.minutes=time.substring(3,5);
			}
		}else {
			System.out.println("invalid Time");
			this.hour="00";
			this.minutes = "00";
			
		}
		
	}
	
	public ValidTime(int hour,int minutes) {
		if(hour<0 || hour >=24 ) {
			System.out.println("invalid hour value");
			this.hour="00";
		}else {
			if(hour < 10) {
				this.hour= "0"+hour;
			}else {
				this.hour=""+hour;
			}
		}
		
		if(minutes<0 || minutes >=60) {
			System.out.print("invalid minutes value");
			this.minutes = "00";
		}else {
			if(minutes<10 )
				this.minutes="0"+minutes;
			else
				this.minutes=""+minutes;
		}
		
		
	}
	
	
	public static boolean isValid(String time) {
		
		if(Pattern.matches("\\d\\d:\\d\\d", time)) {
			if( Integer.parseInt(time.substring(0,2))>=24
				 || Integer.parseInt(time.substring(3,5))>=60) { //negative input will be validated in the regex since - will ruin the pattern
		
				return false;
			
			}else {
				return true;
			}
		}else {
			return false;
		}
		
	}
	
	
	
	public String toString() {
		return this.hour+":"+this.minutes;
	}

	
	
}
