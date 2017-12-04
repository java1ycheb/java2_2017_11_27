package myjfxlab1;

import javafx.application.Application;
import javafx.event.*;
import javafx.fxml.FXMLLoader;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.Stage;

public class Lab1 extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("GridPane.fxml"));
        Scene scene = new Scene(root);
        
        //Scene scene = new Scene(createPane(), 550, 550);
        stage.setTitle("Concurrency in JavaFX");
        stage.setScene(scene);
        stage.show();
    }
    //private void btnFindClick(Event ev){
    //	System.out.println("Find!");
    //}
    //private void btnCancelClick(Event ev){
    //   System.out.println("Try to Cancel!"); 
    //}
    //private Pane createPane(){
    //    GridPane root = new GridPane();
    //    root.setAlignment(Pos.CENTER);
    //    root.setHgap(10);
    //    root.setVgap(10);
    //    root.setPadding(new Insets(25, 25, 25, 25));        
        
     //   Text title = new Text("File finder");
     //   title.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
    //    root.add(title, 0, 0, 2, 1);
        
     //   Label pathL = new Label("Input path:");
      //  root.add(pathL, 0, 1);
        
     //   TextField path = new TextField("C:\\Program Files");
     //   path.setId("pathId");
    //    root.add(path, 1, 1);
        
     //  Label endL = new Label("File ends with:");
    //    root.add(endL, 0, 2);
        
     //   TextField end = new TextField(".pdf");
     //   end.setId("endId");
     //   root.add(end, 1, 2);

     //   Button btnFind = new Button();
     //   btnFind.setText("Find");
     //   btnFind.setOnAction(this::btnFindClick);
    //    root.add(btnFind,0,3);
            
     //   HBox box=new HBox();
     //   Button btnCancel = new Button();
     //   btnCancel.setText("Cancel");
     //   btnCancel.setOnAction(this::btnCancelClick);
        
    //    ProgressBar bar=new ProgressBar();
     //   bar.setId("barId");
     //   bar.setMinWidth(200);
    //    bar.setTranslateX(100);
    //    bar.setProgress(0);

    //    box.getChildren().add(btnCancel);
    //    box.getChildren().add(bar);
    //    root.add(box,1,3);
        
     //   ListView<String> list = new ListView<>();
    //    list.setMinWidth(500);
    //    list.setId("listId");
    //    root.add(list,0,4,2,1);
        
     //   return root;
    //    }
    public static void main(String[] args) {
    	launch(args);
    }
}