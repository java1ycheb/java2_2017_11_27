package application;
	
import java.util.Random;

import javafx.animation.Animation;
import javafx.animation.Transition;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;


public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		Button btn = new Button();
		TextField txt = new TextField();
		Label lbl = new Label();
	    btn.setText("Say Hello");
	    lbl.setText("CSS is cool");
	    btn.setOnAction(new EventHandler<ActionEvent>() {
	            
	           @Override
	           public void handle(ActionEvent event) {
	        	   
	        	   
	           }
	       });
	    
	    ObservableList pchData = FXCollections.observableArrayList(
	    		new PieChart.Data("Data 1", 20),
	    		new PieChart.Data("Data 2", 10),
	    		new PieChart.Data("Data 3", 5)
	    		);
	    PieChart pch = new PieChart(pchData);
	    
	    Button btn2 = new Button("Add data");
	    btn2.setOnMouseClicked(new EventHandler<MouseEvent>() {
	            
	           @Override
	           public void handle(MouseEvent event) {
	        	   Random  rnd = new Random();
	        	   pchData.add(new PieChart.Data("Data " + (pchData.size() +1 ), 10+rnd.nextInt(20)) );
	           }
	       });
	    Button btn3 = new Button("Rotate");
	    btn3.setOnMouseClicked(new EventHandler<MouseEvent>() {
	            
	           @Override
	           public void handle(MouseEvent event) {
	        	   Animation anim = new Transition() {
	        		   {
	        			   setCycleDuration(Duration.seconds(2));
	        			   
	        		   }

					@Override
					protected void interpolate(double frac) {
						pch.setRotate(360*frac);
					}	   
	        	   };
	        	   anim.play();
	        	   
	           }
	       });
	    
	    
		try {
			FlowPane root = new FlowPane();
			root.getChildren().add(btn);
			root.getChildren().add(lbl);
			root.getChildren().add(btn3);
			root.getChildren().add(pch);
			root.getChildren().add(btn2);
			
			Scene scene = new Scene(root,400,600);
			scene.getStylesheets().add(getClass().getResource("CascadeSS.css").toExternalForm());
			primaryStage.setTitle("CSS is cool!");
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
