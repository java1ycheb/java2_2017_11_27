package myjfx3;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Myappjfx3  extends Application{
	
	public void start(Stage primaryStage) {
	
			
			try {
				Parent root = FXMLLoader.load(getClass().getResource("WebBrowserView.fxml"));
				Scene scene = new Scene(root);
				
				primaryStage.setTitle("Simple Web Browser");
				primaryStage.setScene(scene);
				primaryStage.show();
			
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}


		}
	
	public static void main(String[] args) {
		launch(args);
	}


}


