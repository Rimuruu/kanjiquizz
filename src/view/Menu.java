package view;

import java.util.HashMap;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class Menu {
	private BorderPane view;
	private VBox menu;
	private HashMap<String,Button> buttons; 
	
	public void setView(BorderPane view){
		this.view = view;
	}
	
	public BorderPane getView() {
		return this.view;
	}
	

	
	public Button getButton(String name) {
		
		return buttons.get(name);
	}
	

	
	
	public Menu(String... args) {
		
		this.view = new BorderPane();
		this.menu = new VBox();
		buttons = new HashMap<String,Button>();
		for(String arg : args) {
			Button tmp = new Button(arg);
			buttons.put(arg, tmp);
			this.menu.getChildren().add(tmp);
			VBox.setMargin(tmp, new Insets(10,10,10,10));
		}
		
		this.view.setCenter(this.menu);
		this.view.setPrefSize(800,400);
		this.menu.setAlignment(Pos.CENTER);

		
	}
	
}