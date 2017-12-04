package myjfx3;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.web.WebView;

public class WBController implements Initializable {
	@FXML
	private TextField textURL;
	
	@FXML
	private WebView webPage;
	
	@FXML
	private void goToPage(ActionEvent event) {
		String url = textURL.getText();
		if(!url.isEmpty()) {
			webPage.getEngine().load(url);
		}
	};
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
