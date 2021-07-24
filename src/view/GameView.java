package view;

import java.util.ArrayList;
import java.util.Arrays;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import model.Game;
import model.Question;

public class GameView {
	private BorderPane view;
	private VBox container;
	private HBox answerContainer;
	private ArrayList<Button> answers; 
	private Button next;
	private Text question;
	private Game game;
	
	public void setView(BorderPane view){
		this.view = view;
	}
	
	public BorderPane getView() {
		return this.view;
	}
	
	
	public void loadQuestion() {
		Question curr = game.currentQuestion();
		ArrayList<String> as = curr.getAnswers();
		Button b;
		String a;
		next.setDisable(true);
		for(int i = 0; i<4;i++) {
			 b = answers.get(i);
			 a = as.get(i);
			 b.setText(a);
			 b.setDisable(false);
			 b.getStyleClass().remove("good_answer");
			 b.getStyleClass().remove("bad_answer");
			 b.setOnAction(e-> {
				    	   Button btn = (Button) e.getSource();
				    	   
				    	   if(curr.isAnswer(btn.getText())){
				    		   btn.getStyleClass().add("good_answer");
				    		   for(Button other : answers) {
				    			   other.setDisable(true);
				    			
				    		   }
				    	   }
				    	   else {
				    		   btn.getStyleClass().add("bad_answer"); 
				    		   for(Button other : answers) {
				    			   other.setDisable(true);
				    			  if(curr.isAnswer(other.getText())) {
				    				  other.getStyleClass().add("good_answer");
				    			  }
				    		   }
				    	   }
				    	   
				    	   next.setDisable(false);
					      
					    }
					);
		}
		question.setText(curr.getQuestion());
		
	}
	
	
	public GameView(Game game) {
		
		this.view = new BorderPane();
		this.answerContainer = new HBox();
		this.container = new VBox();
		this.answers = new ArrayList<Button>(
			      Arrays.asList(new Button(""),new Button(""),new Button(""),new Button("")));
		
		for (Button btn : this.answers) {
			answerContainer.getChildren().add(btn);
		}
		this.next = new Button("Next");
		this.next.setDisable(true);
		this.next.setOnAction(e->{

			this.game.incr();
			loadQuestion();
			
		});
		this.question = new Text();
		this.container.getChildren().addAll(this.question,this.answerContainer,this.next);
		this.game = game;
		this.view.setCenter(this.container);
		this.view.setPrefSize(800,400);
		this.container.setAlignment(Pos.CENTER);
		this.answerContainer.setAlignment(Pos.CENTER);
		loadQuestion();

		
	}
	
}