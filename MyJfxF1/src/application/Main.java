package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	
	
	@Override
	public void start(Stage primaryStage) {
		Button btn = new Button();
		TextField txt = new TextField();
		Label lbl = new Label();
	    btn.setText("Say Hello");
	    btn.setOnAction(new EventHandler<ActionEvent>() {
	            
	           @Override
	           public void handle(ActionEvent event) {
	               if("".equals(txt.getText())) lbl.setText("Hello World");
	               else lbl.setText("Hello "+ txt.getText());
	           }
	       });
		try {
			GridPane root = new GridPane();
			root.setHgap(10);
			root.setVgap(10);
			root.add(btn, 0, 0);
			root.add(txt, 1, 0);
			root.add(lbl, 1, 1);
			Scene scene = new Scene(root,250,200);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Hello World!");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
