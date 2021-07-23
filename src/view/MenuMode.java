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

public class MenuMode {
	private BorderPane view;
	private VBox menu;
	private Button romaji;
	private Button kana;
	private Button back;
	
	public void setView(BorderPane view){
		this.view = view;
	}
	
	public BorderPane getView() {
		return this.view;
	}
	

	
	public Button getRomaji() {
		return this.romaji;
	}
	
	
	public Button getKana() {
		return this.kana;
	}
	
	public Button geBack() {
		return this.back;
	}
	
	
	public MenuMode() {
		this.romaji = new Button("Romaji mode");
		this.kana = new Button("Kana mode");
		this.kana = new Button("Kana mode");
		this.view = new BorderPane();
		this.menu = new VBox();
		this.menu.getChildren().addAll(this.romaji,this.kana);
		this.view.setCenter(this.menu);
		this.view.setPrefSize(800,400);
		this.menu.setAlignment(Pos.CENTER);
		this.menu.setMargin(romaji, new Insets(10,10,10,10));
		this.menu.setMargin(kana, new Insets(10,10,10,10));
		this.romaji.setId("start");
		this.kana.setId("quit");
		
	}
	
}