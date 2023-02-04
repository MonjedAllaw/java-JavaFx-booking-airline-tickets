package application;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
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

public class Passenger_info extends AnchorPane{
	Stage stage;
	Main main;
	private Account currentAccount;
	HBox hb = new HBox();
	Database db = new Database("misdb");
	
	Passenger_info(Stage stage, Main m){
    	this.stage = stage;
    	main=m;
        setId("passenger_info");
    };
    
    private void createPassengerInfo() {
    	   NavigationBar nav = new NavigationBar();
    	   nav.getLink_home().setOnMouseClicked(e->{
           	stage.setScene(main.getHomeScene());
              
           });
    	   nav.getLink_book().setOnMouseClicked(e->{
           	stage.setScene(main.getBookingScene());
              
           });
    	   


           //////////////////
           
          TableView<Passenger> table = new TableView<Passenger>();
          table.setId("table");
          final ObservableList<Passenger> data =db.getAllPassengers(currentAccount.getId());
           
           Text label = new Text("Passengers On this Account:");
           label.setId("lb");
           
           
           table.setEditable(true);
           table.setFixedCellSize(65.0);
           

           
           TableColumn nameCol = new TableColumn("Name");
           nameCol.setPrefWidth(170);
           nameCol.setMaxWidth(170);
         
           nameCol.setCellValueFactory(
                   new PropertyValueFactory<Passenger, String>("name"));
           
           
           TableColumn bDateCol = new TableColumn("Birth Date");
           bDateCol.setPrefWidth(170);
           nameCol.setMaxWidth(170);
           bDateCol.setCellValueFactory(
                   new PropertyValueFactory<Passenger, ValidDate>("birthDate"));
           
           TableColumn genderCol = new TableColumn("Gender");
           genderCol.setPrefWidth(170);
           nameCol.setMaxWidth(170);
           genderCol.setCellValueFactory(
                   new PropertyValueFactory<Passenger, String>("gender"));
     
           	TableColumn phoneCol = new TableColumn("Phone");
           	phoneCol.setPrefWidth(170);
           	nameCol.setMaxWidth(170);
           	phoneCol.setCellValueFactory(
           			new PropertyValueFactory<Passenger,Integer>("PhoneNum"));
           
           
           table.setItems(data);
           table.getColumns().addAll( nameCol, bDateCol,genderCol,phoneCol);
           
           final TextField addName = new TextField();
           addName.setPromptText("Name");
           addName.setMaxWidth(nameCol.getPrefWidth());
           
           
        
           
           final TextField addDate = new TextField();
           addDate.setMaxWidth(bDateCol.getPrefWidth());
           addDate.setPromptText("Birth Date");
           
           final TextField addGender = new TextField();
           addGender.setMaxWidth(genderCol.getPrefWidth());
           addGender.setPromptText("Gender");
           
           final TextField addPhone = new TextField();
           addPhone.setMaxWidth(phoneCol.getPrefWidth());
           addPhone.setPromptText("Phone number");
           
          
 
           final Button addButton = new Button("add");
           
           addButton.setOnAction(new EventHandler<ActionEvent>() {
               @Override
               public void handle(ActionEvent e) {
               	
               	
               	String name=addName.getText();
               	String date=addDate.getText();
               	String gender=addGender.getText();
               	String phone =addPhone.getText();
               	
              
               	
               	if( (gender.equalsIgnoreCase("Male")||gender.equalsIgnoreCase("Female")) && ValidDate.isValid(date)) {
               		
               		
                   data.add(new Passenger (name,new ValidDate(date),gender, Integer.parseInt(phone)) );
                   
                   db.insertPassenger(currentAccount.getId(),name,new ValidDate(date),gender, Integer.parseInt(phone));
                   addName.clear();
                   addGender.clear();
                   addDate.clear();
                   addPhone.clear();
                   
               }}
           });
           
           hb.getChildren().addAll(addName, addDate,addGender ,addPhone, addButton);
           hb.setSpacing(3);
          
        
         
            
           
           
         
           //////////////
           HBox div1 = new HBox();
           div1.setId("div1");

           Text text1 =new Text("Enter The Information of people who will Book through This Account");
           text1.setId("text1");
           ImageView img1 =new ImageView(new Image(getClass().getResourceAsStream("images/b.png")));
          

           
           final VBox vbox = new VBox();
           vbox.setSpacing(5);
           vbox.setPadding(new Insets(10, 0, 0, 10));
           vbox.getChildren().addAll(label, table, hb);
           vbox.setMargin(label,new Insets(20,0,10,0));
           vbox.setMargin(hb,new Insets(10,0,0,0));
           div1.getChildren().addAll(vbox,img1);
           div1.setMargin(vbox,new Insets(0,10,10,25));
           div1.setMargin(img1,new Insets(70,0,20,150));
        
           
           
          
           getChildren().addAll(text1,nav,div1);
           setTopAnchor(nav,0.0);
           setTopAnchor(div1,255.0);
           setTopAnchor(text1,212.0);
           setLeftAnchor(text1,35.0);
         
       }

  

   	public void setCurrentAccount(Account acc) {
   		this.currentAccount = acc;	
   		createPassengerInfo();
   	}
       

   }
