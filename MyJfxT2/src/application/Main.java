package application;
	
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.fxml.FXMLLoader;


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
		try {
			FlowPane root = new FlowPane();
			root.getChildren().add(btn);
			root.getChildren().add(lbl);
			root.getChildren().add(pch);
			Scene scene = new Scene(root,500,500);
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
