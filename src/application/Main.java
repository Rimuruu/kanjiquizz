package application;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import jfxtras.styles.jmetro.JMetro;
import jfxtras.styles.jmetro.Style;
import model.Game;
import model.GameMode;
import model.KanjiLoader;
import view.GameView;
import view.Menu;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;


public class Main {
	
	public static void main(String[] args){
		
		AppMain.launch( AppMain.class,args);
	}

	public static class AppMain extends Application {
	private Menu menu;
	private Menu menuMode;
	private GameView gameView;
	private Scene scene;
	
	public void createGame(GameMode gameMode) {
		Game game = new Game(gameMode);
		gameView = new GameView(game);
		gameView.getMenuButton().setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
			       scene.setRoot(menu.getView());
			    }
			});
		scene.setRoot(this.gameView.getView());
	}
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("KanjiQuizz");
			primaryStage.getIcons().add(new Image(Main.class.getClassLoader().getResourceAsStream("kanjiquizz.png")));
			menu = new Menu("Play","Quit");
			menuMode = new Menu("Romaji mode","Kana mode","Back");
			Style startingStyle = Style.LIGHT;
	        JMetro jMetro = new JMetro(startingStyle);
			
			scene = new Scene(menu.getView(),800,600);
			jMetro.setScene(scene);
			jMetro.getOverridingStylesheets().add(getClass().getResource("application.css").toExternalForm());			  
			  
			menu.getButton("Play").setOnAction(new EventHandler<ActionEvent>() {
			    @Override public void handle(ActionEvent e) {
			       scene.setRoot(menuMode.getView());
			    }
			});
			
			menu.getButton("Quit").setOnAction(new EventHandler<ActionEvent>() {
			    @Override public void handle(ActionEvent e) {
			    	primaryStage.close();
			    }
			});
			
			menuMode.getButton("Back").setOnAction(new EventHandler<ActionEvent>() {
			    @Override public void handle(ActionEvent e) {
			       scene.setRoot(menu.getView());
			    }
			});
			
			menuMode.getButton("Romaji mode").setOnAction(new EventHandler<ActionEvent>() {
			    @Override public void handle(ActionEvent e) {
			       createGame(GameMode.ROMAJI);
			    }
			});
			
			menuMode.getButton("Kana mode").setOnAction(new EventHandler<ActionEvent>() {
			    @Override public void handle(ActionEvent e) {
			       createGame(GameMode.KANA);
			    }
			});
			
			scene.setRoot(this.menu.getView());  
			
			KanjiLoader.loadKanji();
			
			
			primaryStage.setScene(scene);
			primaryStage.show();
			
			
			
			
			
			
		
	} catch (UnsupportedEncodingException e) {
		Alert errorAlert = new Alert(AlertType.ERROR);
		errorAlert.setHeaderText("UnsupportedEncodingException");
		errorAlert.setContentText(e.getMessage());
		errorAlert.showAndWait();
		e.printStackTrace();
		e.printStackTrace();
	
	} catch (IOException e) {
		Alert errorAlert = new Alert(AlertType.ERROR);
		errorAlert.setHeaderText("File error");
		errorAlert.setContentText(e.getMessage());
		errorAlert.showAndWait();
		e.printStackTrace();
	
	}
		
		catch(Exception e) {
			Alert errorAlert = new Alert(AlertType.ERROR);
			errorAlert.setHeaderText("Exception");
			errorAlert.setContentText(e.getMessage());
			errorAlert.showAndWait();
			e.printStackTrace();
			e.printStackTrace();
		}
		
		 
	}
}
	
	
}
