package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Booking extends AnchorPane{
	Stage stage;
	Main main;
	private Account currentAccount;
	HBox hb = new HBox();
	Database db = new Database("misdb");
	 
  
	
	Booking(Stage stage, Main m){
    	this.stage = stage;
    	main=m;
    	
        setId("booking");
    };
    
    private void createBooking() {
    	   NavigationBar nav = new NavigationBar();
    	   nav.getLink_home().setOnMouseClicked(e->{
           	stage.setScene(main.getHomeScene());
              
           });
    	   nav.getLink_passenger().setOnMouseClicked(e->{
           	stage.setScene(main.getPassengerScene());
              
           });
    	   


           //////////////////
           
    	  final ObservableList<Flight> fdata =db.getAllFlights();
          final ObservableList<Passenger> pdata =db.getAllPassengers(currentAccount.getId());
          final ObservableList<String> cdata = FXCollections.observableArrayList("First Class","Business Class","Economy Class"); 
          
          
          final ComboBox<Flight> cboFlight = new ComboBox<>();
          final ComboBox<Passenger> cboPassenger = new ComboBox<>();
          final ComboBox<String> cboClass = new ComboBox<>();
          
        
          Text textp =new Text("Passenger");
          textp.setId("text");
          cboPassenger.setPrefWidth(600);
          cboPassenger.setValue( pdata.get(0));
         
          Text textf =new Text("Flight");
          textf.setId("text");
          cboFlight.setPrefWidth(600);
          cboFlight.setValue( fdata.get(0));
          
          Text textc =new Text("Travel Class");
          textc.setId("text");
          cboClass.setPrefWidth(600);
          cboClass.setValue(cdata.get(0));
         
        
          cboFlight.getItems().addAll(fdata);
          cboPassenger.getItems().addAll(pdata);
          cboClass.getItems().addAll(cdata);
          
          
          
          final Button addButton = new Button("book");
          addButton.setId("addbtn");
          Text message =new Text("");
          message.setId("message");
          
          addButton.setOnAction(new EventHandler<ActionEvent>() {
              @Override
              public void handle(ActionEvent e) {
            	  db.insertTicket(currentAccount.getId(),cboPassenger.getValue().getPassengerId(), cboFlight.getValue().getFlightId(),cboClass.getValue() );
              	  message.setText("Successfully made a bookig!");
              
              }});
          
          
          
           //////////////
           HBox div1 = new HBox();
           div1.setId("div1");

           Text text1 =new Text("Choose The Passenger And The Flight they want to book");
           
           text1.setId("text1");
           ImageView img1 =new ImageView(new Image(getClass().getResourceAsStream("images/c.png")));
           
          

           
           final VBox vbox = new VBox();
           vbox.setSpacing(5);
           vbox.setPadding(new Insets(10, 0, 0, 10));
           
          
           
           vbox.getChildren().addAll(textp,cboPassenger,textf,cboFlight,textc,cboClass,addButton,message);
       
           vbox.setMargin(addButton,new Insets(30,0,30,0));
           
           
           
           
           
           
           vbox.setMargin(hb,new Insets(10,0,0,0));
           div1.getChildren().addAll(vbox,img1); 
           div1.setMargin(vbox,new Insets(30,10,10,25));
           div1.setMargin(img1,new Insets(40,0,20,190));
        
           
           
           
          
           getChildren().addAll(text1,nav,div1);
           setTopAnchor(nav,0.0);
           setTopAnchor(div1,255.0);
           setTopAnchor(text1,212.0);
           setLeftAnchor(text1,35.0);
         
       }

  

   	public void setCurrentAccount(Account acc) {
   		this.currentAccount = acc;	
   	      createBooking();
   		
   	}
       

   }