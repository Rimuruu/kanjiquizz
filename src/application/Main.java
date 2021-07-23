package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import jfxtras.styles.jmetro.JMetro;
import jfxtras.styles.jmetro.Style;
import view.Menu;
import view.MenuMode;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	private Menu menu;
	private MenuMode menuMode;
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("KanjiQuizz");
			Menu menu = new Menu();
			MenuMode menuMode = new MenuMode();
			Style startingStyle = Style.LIGHT;
	        JMetro jMetro = new JMetro(startingStyle);
			
			Scene scene = new Scene(menu.getView(),800,600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			 jMetro.setScene(scene);
			  
			  
			menu.getStart().setOnAction(new EventHandler<ActionEvent>() {
			    @Override public void handle(ActionEvent e) {
			       scene.setRoot(menuMode.getView());
			    }
			});
			  
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
