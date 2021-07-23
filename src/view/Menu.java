package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import jfxtras.styles.jmetro.JMetroStyleClass;

public class Menu {
	private BorderPane view;
	private VBox menu;
	private Button start;
	private Button quit;
	
	public void setView(BorderPane view){
		this.view = view;
	}
	
	public BorderPane getView() {
		return this.view;
	}
	

	
	public Button getStart() {
		return this.start;
	}
	
	
	public Button getQuit() {
		return this.quit;
	}
	
	
	public Menu() {
		this.start = new Button("Play");
		this.quit = new Button("Quit");
		this.view = new BorderPane();
		this.menu = new VBox();
		this.menu.getChildren().addAll(this.start,this.quit);
		this.view.setCenter(this.menu);
		this.view.setPrefSize(800,400);
		this.menu.setAlignment(Pos.CENTER);
		this.menu.setMargin(start, new Insets(10,10,10,10));
		this.menu.setMargin(quit, new Insets(10,10,10,10));
		this.start.setId("start");
		this.quit.setId("quit");
		
	}
	
}