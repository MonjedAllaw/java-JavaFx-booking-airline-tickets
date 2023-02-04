package application;
	
import java.util.regex.Pattern;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;


public class Main extends Application {
	private Scene signInScene;
	private Scene signUpScene;
	private Scene homeScene;
	private Scene bookingScene;
	private Scene manageScene;
	private Scene  passengerScene;
	private Account currentAccount;
	
	

	public Account getCurrentAccount() {
		return currentAccount;
	}

	public void setCurrentAccount(Account currentAccount) {
		this.currentAccount = currentAccount;
	}

	public Scene getSignInScene() {
		return signInScene;
	}

	public void setSignInScene(Scene signInScene) {
		this.signInScene = signInScene;
	}

	public Scene getSignUpScene() {
		return signUpScene;
	}

	public void setSignUpScene(Scene signUpScene) {
		this.signUpScene = signUpScene;
	}

	public Scene getHomeScene() {
		return homeScene;
	}

	public void setHomeScene(Scene homeScene) {
		this.homeScene = homeScene;
	}

	public Scene getBookingScene() {
		return bookingScene;
	}

	public void setBookingScene(Scene bookScene) {
		this.bookingScene = bookScene;
	}

	public Scene getManageScene() {
		return manageScene;
	}

	public void setManageScene(Scene manageScene) {
		this.manageScene = manageScene;
	}

	public Scene getPassengerScene() {
		return passengerScene;
	}

	public void setPassengerScene(Scene passengerScene) {
		this.passengerScene = passengerScene;
	}
	

	@Override
	public void start(Stage primaryStage) {
		
		try {

			Database db = new Database("misdb");
			 Rectangle2D screenSize = Screen.getPrimary().getVisualBounds();
			////////sign up/////////
			
			AnchorPane signUpPage = new AnchorPane();
			signUpPage.setId("rootpane");
			
			
			/////form 1
			
			Text title = new Text(20, 20, "Create New Account");
			title.setId("title");
			
			TextField emailField = new TextField();
			emailField.setId("emailField");
			
			PasswordField passField = new PasswordField();
			passField.setId("passField");

			PasswordField passcomField = new PasswordField();
			passcomField.setId("passcomField");
			
			Text errorMessage = new Text(20, 20, "");
			errorMessage.setId("errorMessage");
			
			Button signupBTN = new Button("SIGN UP");
			signupBTN.setId("subtn");
			
			
			
			
			HBox social = new HBox(20);
			social.getChildren().addAll(new ImageView(new Image("C:\\Users\\Corazon\\OneDrive\\Desktop\\college\\semester 3\\programing 3\\javaFx project\\MIS\\src\\application\\images\\facebook.png"))
					,new ImageView(new Image("C:\\Users\\Corazon\\OneDrive\\Desktop\\college\\semester 3\\programing 3\\javaFx project\\MIS\\src\\application\\images\\google.png"))
					,new ImageView(new Image("C:\\Users\\Corazon\\OneDrive\\Desktop\\college\\semester 3\\programing 3\\javaFx project\\MIS\\src\\application\\images\\amongus.png")));
			social.setAlignment(Pos.CENTER);
			
			emailField.setPromptText("   Email");
			passField.setPromptText("   password");
			passcomField.setPromptText("   comfirm password");
			
			

			GridPane form1 = new GridPane();
			form1.setId("form1");
			
			
			form1.add(title, 1, 0);
			form1.add(new Text("signup using:"), 1, 1);
			form1.add(social, 1, 2);
			form1.add(emailField, 1, 3);
			form1.add(passField, 1, 4);
			form1.add(passcomField,1, 5);
			form1.add(signupBTN, 1, 7);
			form1.add(errorMessage, 1, 6);
			form1.setAlignment(Pos.CENTER);
			for(Node a :form1.getChildren()) {
				form1.setHalignment(a, HPos.CENTER);
			}
			
		

	
				
				
				emailField.setOnKeyReleased(e->{
					
						
						String emailcontent= emailField.getText().trim();
				
						
						
						 int ATcount= emailcontent.length()-emailcontent.replaceAll("@","").length();
						if(Pattern.matches("\\S+@\\S+\\.com", emailcontent)) {
							
							if(ATcount>1) {
								errorMessage.setText("@ can only be used once");
								emailField.setStyle("-fx-background-color: #eeeeee; -fx-border-color:red; ");
								errorMessage.setStroke(Color.RED);
								
							}else {
								errorMessage.setText("valid email format");
								errorMessage.setStroke(Color.web("#11ac9c"));
								emailField.setStyle("-fx-background-color: #eeeeee; -fx-border-color:#11ac9c; ");
							}
							
						}else {
							emailField.setStyle("-fx-background-color: #eeeeee; -fx-border-color:red; ");
							errorMessage.setText("invalid email format ");
							errorMessage.setStroke(Color.RED);
						}		
						
						
						
						
				
					
					
					
				});
				
				
				passField.setOnKeyReleased(e->{
					
					String passContent= passField.getText().trim();
					if (passContent.length()<8 || passContent.length()>20) {
						passField.setStyle("-fx-background-color: #eeeeee; -fx-border-color:red; ");
						errorMessage.setText("password should be 8-20 characters");
						errorMessage.setStroke(Color.RED);
						
					}else {
					passField.setStyle("-fx-background-color: #eeeeee; -fx-border-color:#11ac9c; ");
					errorMessage.setText("valid password");
					errorMessage.setStroke(Color.web("#11ac9c"));
					}
					
					
					
						
						
					
				});
				
				

				passcomField.setOnKeyReleased(e->{
					
					String passcomContent= passcomField.getText().trim();
					if (passcomContent.equals(passField.getText())  ) {
					passcomField.setStyle("-fx-background-color: #eeeeee; -fx-border-color:#11ac9c; ");
					errorMessage.setText(" password match");
					errorMessage.setStroke(Color.web("#11ac9c"));
						
					}else {
						passcomField.setStyle("-fx-background-color: #eeeeee; -fx-border-color:red; ");
						errorMessage.setText("password doesnt match");
						errorMessage.setStroke(Color.RED);
					
					}
					
					
					
						
					
					
					
				});
				
			

			//////form2
				
				Text first = new Text(20, 20, "Already Have One?");
				first.setId("first");
				Text second = new Text(20,20,"welcom back");
				second.setId("second");
				
				
				
				
				Button signinbutton = new Button("SIGN IN");
				signinbutton.setId("sibtn");
				

				

				GridPane form2 = new GridPane();
				form2.setId("form2");
				
				
				form2.add(first, 1, 0);
				form2.add(second, 1, 1);
				form2.add(signinbutton, 1, 5);
				form2.setAlignment(Pos.CENTER);
				for(Node a :form2.getChildren()) {
					form1.setHalignment(a, HPos.CENTER);
				}
				
			
				
				//////
				
				
				
				
				////title
				Text name =new Text("rbs airlines");
				name.setId("name");
				ImageView logo =new ImageView(new Image("C:\\Users\\Corazon\\OneDrive\\Desktop\\college\\semester 3\\programing 3\\javaFx project\\MIS\\src\\application\\images\\plane2.png"));
				
				HBox Logo =new HBox();
				Logo.setId("Logo");
				Logo.getChildren().addAll(logo);
				Logo.setAlignment(Pos.CENTER_LEFT);
				
				
				////
			
			
			signUpPage.getChildren().addAll(Logo,name,form1,form2);
			signUpPage.getChildren().get(2).toBack();
			
			AnchorPane.setTopAnchor(name,40.0);
			AnchorPane.setLeftAnchor(name, 133.0);
			AnchorPane.setTopAnchor(Logo,10.0);
			AnchorPane.setLeftAnchor(Logo, 25.0);
			AnchorPane.setRightAnchor(form2, 25.0);
			AnchorPane.setTopAnchor(form2, 280.0);
			
			//////////////////////////////////////////////////////////////////////////////////////////
	////////sign up/////////
			
				AnchorPane signInPage = new AnchorPane();
				signInPage.setId("rootpane");
				
				
				/////form 1
				
				Text titlex = new Text(20, 20, "Sign In To Your Account");
				titlex.setId("title");
				
				TextField emailFieldx = new TextField();
				emailFieldx.setId("emailField");
				
				PasswordField passFieldx = new PasswordField();
				passFieldx.setId("passField");
				

				
				
				Text errorMessagex = new Text(20, 20, "");
				errorMessagex.setId("errorMessage");
				
				Button signinBTN = new Button("SIGN IN");
				signinBTN.setId("subtn");
				
				
				
				
				HBox socialx = new HBox(20);
				socialx.getChildren().addAll(new ImageView(new Image("C:\\Users\\Corazon\\OneDrive\\Desktop\\college\\semester 3\\programing 3\\javaFx project\\MIS\\src\\application\\images\\facebook.png"))
						,new ImageView(new Image("C:\\Users\\Corazon\\OneDrive\\Desktop\\college\\semester 3\\programing 3\\javaFx project\\MIS\\src\\application\\images\\google.png"))
						,new ImageView(new Image("C:\\Users\\Corazon\\OneDrive\\Desktop\\college\\semester 3\\programing 3\\javaFx project\\MIS\\src\\application\\images\\amongus.png")));
				socialx.setAlignment(Pos.CENTER);
				
				emailFieldx.setPromptText("   Email");
				passFieldx.setPromptText("   password");
				
				
				

				GridPane form1x = new GridPane();
				form1x.setId("form1");
				
				
				form1x.add(titlex, 1, 0);
				form1x.add(new Text("sign in using:"), 1, 1);
				form1x.add(socialx, 1, 2);
				form1x.add(emailFieldx, 1, 3);
				form1x.add(passFieldx, 1, 4);
				form1x.add(signinBTN, 1, 6);
				form1x.add(errorMessagex, 1, 5);
				form1x.setAlignment(Pos.CENTER);
				for(Node a :form1x.getChildren()) {
					form1.setHalignment(a, HPos.CENTER);
				}
				
			

					
				
					emailFieldx.setOnKeyReleased(e->{
						
							
							String emailcontent= emailFieldx.getText().trim();
					
							
							
							 int ATcount= emailcontent.length()-emailcontent.replaceAll("@","").length();
							if(Pattern.matches("\\S+@\\S+\\.com", emailcontent)) {
								
								if(ATcount>1) {
									errorMessagex.setText("@ can only be used once");
									emailFieldx.setStyle("-fx-background-color: #eeeeee; -fx-border-color:red; ");
									errorMessagex.setStroke(Color.RED);
									
								}else {
									errorMessagex.setText("valid email format");
									errorMessagex.setStroke(Color.web("#11ac9c"));
									emailFieldx.setStyle("-fx-background-color: #eeeeee; -fx-border-color:#11ac9c; ");
								}
								
							}else {
								emailFieldx.setStyle("-fx-background-color: #eeeeee; -fx-border-color:red; ");
								errorMessagex.setText("invalid email format ");
								errorMessagex.setStroke(Color.RED);
							}		
							
							
							
							
					
						
						
						
					});
					
					
					passFieldx.setOnKeyReleased(e->{
						
						String passContent= passFieldx.getText().trim();
						if (passContent.length()<8 || passContent.length()>20) {
							passFieldx.setStyle("-fx-background-color: #eeeeee; -fx-border-color:red; ");
							errorMessagex.setText("password should be 8-20 characters");
							errorMessagex.setStroke(Color.RED);
							
						}else {
						passFieldx.setStyle("-fx-background-color: #eeeeee; -fx-border-color:#11ac9c; ");
						errorMessagex.setText("valid password");
						errorMessagex.setStroke(Color.web("#11ac9c"));
						}
						
						
						
							
							
						
					});
					
					

				

				//////form2
					
					Text firstx = new Text(20, 20, "New Here?");
					firstx.setId("first");
					Text secondx = new Text(20,20,"create your account");
					secondx.setId("second");
					
					
					
					
					Button signupbutton = new Button("SIGN UP");
					signupbutton.setId("sibtn");
					

					

					GridPane form2x = new GridPane();
					form2x.setId("form2");
					
					
					form2x.add(firstx, 1, 0);
					form2x.add(secondx, 1, 1);
					form2x.add(signupbutton, 1, 5);
					form2x.setAlignment(Pos.CENTER);
					for(Node a :form2x.getChildren()) {
						form1.setHalignment(a, HPos.CENTER);
					}
					
				
					
					//////
					
					
					
					
					////title
					Text namex =new Text("rbs airlines");
					namex.setId("name");
					ImageView logox =new ImageView(new Image("C:\\Users\\Corazon\\OneDrive\\Desktop\\college\\semester 3\\programing 3\\javaFx project\\MIS\\src\\application\\images\\plane2.png"));
					
					HBox Logox =new HBox();
					Logox.setId("Logo");
					Logox.getChildren().addAll(logox);
					Logox.setAlignment(Pos.CENTER_LEFT);
					
					
					////
				
				
				signInPage.getChildren().addAll(Logox,namex,form2x,form1x);
				signInPage.getChildren().get(3).toBack();
				
				AnchorPane.setTopAnchor(namex,40.0);
				AnchorPane.setRightAnchor(namex, 133.0);
				AnchorPane.setTopAnchor(Logox,10.0);
				AnchorPane.setRightAnchor(Logox, 25.0);
				AnchorPane.setLeftAnchor(form2x,100.0);
				AnchorPane.setTopAnchor(form2x, 280.0);
				AnchorPane.setRightAnchor(form1x, 0.0);
				
			/////////////////////////////////////////////////
			String navCss= this.getClass().getResource("nav.css").toExternalForm();
			String authCss= this.getClass().getResource("auth.css").toExternalForm();
			String homeCss= this.getClass().getResource("Home.css").toExternalForm();
			String passengerCss= this.getClass().getResource("Passenger_info.css").toExternalForm(); 
			String bookingCss=this.getClass().getResource("booking.css").toExternalForm();
			
				
			Home home =new Home(primaryStage,this);
			Passenger_info pi =new Passenger_info(primaryStage,this);
			Booking booking = new Booking(primaryStage,this);
			
			
			signUpScene = new Scene(signUpPage,screenSize.getWidth(), screenSize.getHeight());
			signInScene = new Scene(signInPage,screenSize.getWidth(), screenSize.getHeight());
			homeScene = new Scene(home,screenSize.getWidth(), screenSize.getHeight());
			passengerScene = new Scene(pi,screenSize.getWidth(), screenSize.getHeight());
			bookingScene = new Scene(booking,screenSize.getWidth(), screenSize.getHeight());
			
			signUpPage.requestFocus();
			signInPage.requestFocus();
			
		
			
			
			signUpScene.getStylesheets().addAll(authCss);
			signInScene.getStylesheets().addAll(authCss);
			homeScene.getStylesheets().addAll(homeCss,navCss);
			passengerScene.getStylesheets().addAll(passengerCss,navCss);
			bookingScene.getStylesheets().addAll(navCss,bookingCss);
         
           
            
			signinbutton.setOnAction(e->{
				 
	           
	            primaryStage.setScene(signInScene);
	          
			
		});
			signupbutton.setOnAction(e->{
				 
	            primaryStage.setScene(signUpScene);
	            
	            
			
		});
			
			signinBTN.setOnAction(e->{
				String emailcontent= emailFieldx.getText().trim();
				String passContent= passFieldx.getText().trim();
				
				 int ATcount= emailcontent.length()-emailcontent.replaceAll("@","").length();

				if((Pattern.matches("\\S+@\\S+\\.com", emailcontent))&& (!(ATcount>1) )
						&&(passContent.length()>=8 && passContent.length()<=20 && db.checkAccount(emailcontent, passContent))
						) {
					signinBTN.setStyle("-fx-background-color: #11ac9c; -fx-text-fill:white; -fx-font:normal bold 15px 'sans-serif'; -fx-border-color:#11ac9c;  ");
					
					errorMessagex.setText("success");
					errorMessagex.setStroke(Color.web("#11ac9c"));
					 currentAccount = db.getAccount(emailcontent, passContent);
					 System.out.print(currentAccount);
					 home.setIsAdmin(currentAccount.isAdmin());
					 pi.setCurrentAccount(currentAccount);
					 booking.setCurrentAccount(currentAccount);
					
					 primaryStage.setScene(homeScene);
					
					
				}else {
					signinBTN.setStyle("-fx-background-color: #11ac9c; -fx-text-fill:white; -fx-font:normal bold 15px 'sans-serif'; -fx-border-color:red; ");
					errorMessagex.setText("REQUIERMENTS UNMATCHED");
					errorMessagex.setStroke(Color.RED);
				}
					
				
			});
		
			signupBTN.setOnAction(e->{
				String emailcontent= emailField.getText().trim();
				String passContent= passField.getText().trim();
				String passcomContent= passcomField.getText().trim();
				 int ATcount= emailcontent.length()-emailcontent.replaceAll("@","").length();

				if((Pattern.matches("\\S+@\\S+\\.com", emailcontent))&& (!(ATcount>1) )
						&&(passContent.length()>=8 && passContent.length()<=20)
						&&(passcomContent.equals(passContent))) {
					signupBTN.setStyle("-fx-background-color: #11ac9c; -fx-text-fill:white; -fx-font:normal bold 15px 'sans-serif'; -fx-border-color:#11ac9c;  ");
					db.insertAccount(emailcontent, passcomContent);
					errorMessage.setText("ACCOUNT CREATED SUCCESSFULLY");
					errorMessage.setStroke(Color.web("#11ac9c"));
					primaryStage.setScene(homeScene);
					currentAccount = db.getAccount(emailcontent, passContent);
					
					pi.setCurrentAccount(currentAccount);
					booking.setCurrentAccount(currentAccount);
					home.setIsAdmin(currentAccount.isAdmin());
				
					
					
				}else {
					signupBTN.setStyle("-fx-background-color: #11ac9c; -fx-text-fill:white; -fx-font:normal bold 15px 'sans-serif'; -fx-border-color:red; ");
					errorMessage.setText("REQUIERMENTS UNMATCHED");
					errorMessage.setStroke(Color.RED);
				}
					
				
			});
			
	
			primaryStage.setScene(signUpScene);
			primaryStage.setMaximized(true);
			primaryStage.show();
			
		
			

		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		
		
		launch(args);
	}
}
