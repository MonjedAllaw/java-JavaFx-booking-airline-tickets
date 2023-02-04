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

public class Home extends AnchorPane {
	Stage stage;
	Main main;
	int isAdmin;
	HBox hb = new HBox();
	Database db = new Database("misdb");
	
    Home(Stage stage, Main m){
    	this.stage = stage;
    	main=m;
        createHome();
        setId("home");
    };

    private void createHome(){
        NavigationBar nav = new NavigationBar();
        nav.getLink_passenger().setOnMouseClicked(e->{
        	stage.setScene(main.getPassengerScene());
           
        });
        
        nav.getLink_book().setOnMouseClicked(e->{
        	stage.setScene(main.getBookingScene());
           
        });

        //////////////////
        
       TableView<Flight> table = new TableView<Flight>();
       table.setId("table");
       final ObservableList<Flight> data =db.getAllFlights();
        
        Text label = new Text("See Available Flights:");
        label.setId("lb");
        
        
        table.setEditable(true);
        table.setFixedCellSize(65.0);
        
        TableColumn departureCol = new TableColumn("Departure");
        departureCol.setPrefWidth(170);
        departureCol.setCellValueFactory(
                new PropertyValueFactory<Flight, String>("departure"));
        
        
        
        TableColumn destinationCol = new TableColumn("Destination");
        destinationCol.setPrefWidth(170);
      
        destinationCol.setCellValueFactory(
                new PropertyValueFactory<Flight, String>("destination"));
        
        
        TableColumn dateCol = new TableColumn("Date");
        dateCol.setPrefWidth(170);
        dateCol.setCellValueFactory(
                new PropertyValueFactory<Flight, ValidDate>("date"));
        
        TableColumn timeCol = new TableColumn("Time");
        timeCol.setPrefWidth(170);
       
        timeCol.setCellValueFactory(
                new PropertyValueFactory<Flight, ValidTime>("time"));
  
        
        table.setItems(data);
        table.getColumns().addAll(departureCol, destinationCol, dateCol,timeCol);
        
        final TextField addDepature = new TextField();
        addDepature.setPromptText("Departure");
        addDepature.setMaxWidth(departureCol.getPrefWidth());
        
        
        final TextField addDestination = new TextField();
        addDestination.setMaxWidth(destinationCol.getPrefWidth());
        addDestination.setPromptText("Destination");
        
        
        final TextField addDate = new TextField();
        addDate.setMaxWidth(dateCol.getPrefWidth());
        addDate.setPromptText("Date");
        
        
        final TextField addTime = new TextField();
        addTime.setMaxWidth(timeCol.getPrefWidth());
        addTime.setPromptText("Time");
        
       
      
        
        
        final Button addButton = new Button("add");
        
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	
            	
            	String dep=addDepature.getText();
            	String des=addDestination.getText();
            	String date=addDate.getText();
            	String time=addTime.getText();
            	
            	if(dep!="" && des!="" 
            			&& ValidDate.isValid(date)&& ValidTime.isValid(time)
            			
            			
            			) {
                data.add(new Flight(
                		dep,
                		des,
                        new ValidDate (date),new ValidTime(time)) 
                		
                		
                		);
                
                db.insertFlight(dep, des,new ValidDate (date),new ValidTime(time));
                addDepature.clear();
                addDestination.clear();
                addDate.clear();
                addTime.clear();
                
            }}
        });
        
        hb.getChildren().addAll(addDepature, addDestination, addDate,addTime, addButton);
        hb.setSpacing(3);
       
        hb.setId("hidden");
      
         
        
        
      
        //////////////
        HBox div1 = new HBox();
        div1.setId("div1");

        Text text1 =new Text("Let the journey begin");
        text1.setId("text1");
        ImageView img1 =new ImageView(new Image(getClass().getResourceAsStream("images/a.png")));
       

        
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(text1,label, table, hb);
        vbox.setMargin(label,new Insets(20,0,10,0));
        vbox.setMargin(hb,new Insets(10,0,0,0));
        div1.getChildren().addAll(vbox,img1);
        div1.setMargin(vbox,new Insets(0,10,10,25));
        div1.setMargin(img1,new Insets(80,0,20,150));
     
        
        
       
        getChildren().addAll(nav,div1);
        setTopAnchor(nav,0.0);
        setTopAnchor(div1,200.0);
      
    }

	public int getIsAdmin() {
		return isAdmin;
		
		
	}

	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
		if(isAdmin==1) {
			hb.setId("visible");
		}
		
	}
    

}
