package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import jfxtras.styles.jmetro.JMetro;
import jfxtras.styles.jmetro.Style;
import model.Game;
import model.Question;
import view.GameView;
import view.Menu;

import javafx.scene.Scene;


public class Main extends Application {
	private Menu menu;
	private Menu menuMode;
	private GameView gameView;
	private Scene scene;
	
	public void createGame() {
		Question a = new Question("salut","1","2","3","4");
		Question b = new Question("salut","1","2","3","4");
		Game game = new Game(a,b);
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
			menu = new Menu("Play","Quit");
			menuMode = new Menu("Romaji mode","Kana mode","Back");
			Style startingStyle = Style.LIGHT;
	        JMetro jMetro = new JMetro(startingStyle);
			
			scene = new Scene(menu.getView(),800,600);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
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
			       createGame();
			    }
			});
			scene.setRoot(this.menu.getView());  
			

			
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
