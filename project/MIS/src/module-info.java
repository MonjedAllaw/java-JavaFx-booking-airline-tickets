module MIS {
	requires javafx.controls;
	requires javafx.graphics;
    requires java.sql;
    requires java.desktop;

  
    requires javafx.fxml;
	requires javafx.base;

    
    opens application to javafx.graphics, javafx.fxml;
    
    exports application;
}
