package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class NavigationBar extends HBox {
	private Text link_home = new Text("Home");
    
    private Text link_book = new Text("Book a Trip");
    
    private Text link_manage = new Text("Manage Booking");
    
    private Text link_passenger = new Text("Passenger Info");
    
	
	public Text getLink_home() {
		return link_home;
	}


	public void setLink_home(Text link_home) {
		this.link_home = link_home;
	}


	public Text getLink_book() {
		return link_book;
	}


	public void setLink_book(Text link_book) {
		this.link_book = link_book;
	}


	public Text getLink_manage() {
		return link_manage;
	}


	public void setLink_manage(Text link_manage) {
		this.link_manage = link_manage;
	}


	public Text getLink_passenger() {
		return link_passenger;
	}


	public void setLink_passenger(Text link_passenger) {
		this.link_passenger = link_passenger;
	}


	public NavigationBar() {
			
	     setId("nav");

	     Text name =new Text("rbs airlines");
	     name.setId("name");
	     ImageView logo =new ImageView(new Image("C:\\Users\\Corazon\\OneDrive\\Desktop\\college\\semester 3\\programing 3\\javaFx project\\MIS\\src\\application\\images\\plane2.png"));

	     HBox Logo =new HBox();
	     Logo.setId("Logo");
	     Logo.getChildren().addAll(logo);
	     Logo.setAlignment(Pos.CENTER_LEFT);

	     link_home.setId("link_home");
	     link_book.setId("link_book");
	     link_manage.setId("link_manage");
	     link_passenger.setId("link_passenger");
	     
	     getChildren().addAll(Logo,name,link_home,link_book,link_manage,link_passenger);
	     setMargin(Logo,new Insets(10,0,10,25));
	     setMargin(name,new Insets(40,200,20,0));
	     setMargin(link_home,new Insets(50,100,0,200));
	     setMargin(link_book,new Insets(50,100,0,20));
	     setMargin(link_manage,new Insets(50,100,0,20));
	     setMargin(link_passenger,new Insets(50,100,0,20));
	     

		
	}
	
	
	
}
