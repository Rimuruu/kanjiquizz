package view;

import java.util.ArrayList;
import java.util.Arrays;

import javafx.geometry.Insets;
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
	private Button menuButton;
	private Text question;
	private Text result;
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
				    	   Question c = game.currentQuestion();
				    	   if(curr.isAnswer(btn.getText())){
				    		   btn.getStyleClass().add("good_answer");
				    		   c.setStatut(true);
				    		   game.incrScore();
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
	
	
	public void resultView() {
		this.container.getChildren().clear();
		this.result = new Text(this.game.getScore()+"/"+this.game.getNbQuestion());
		this.result.getStyleClass().add("result");
		this.container.getChildren().addAll(this.result,this.menuButton);
	}
	
	
	public Button getMenuButton() {
		return this.menuButton;
	}
	
	public GameView(Game game) {
		
		this.view = new BorderPane();
		this.answerContainer = new HBox();
		this.container = new VBox();
		this.answerContainer.setPadding(new Insets(20,20,20,20));
		this.answers = new ArrayList<Button>(
			      Arrays.asList(new Button(""),new Button(""),new Button(""),new Button("")));
		
		for (Button btn : this.answers) {
			answerContainer.getChildren().add(btn);
		}
		this.next = new Button("Next");
		this.next.setDisable(true);
		this.next.getStyleClass().add("button_next");
		this.menuButton = new Button("Back to menu");
		this.next.setOnAction(e->{
			if(this.game.getNbQuestion()-1 == this.game.getRound() ) resultView();
			else {
				this.game.incr();
				loadQuestion();
			}
			
		});
		this.question = new Text();
		this.container.getChildren().addAll(this.question,this.answerContainer,this.next);
		this.game = game;
		this.view.setCenter(this.container);
		this.view.setPrefSize(800,400);
		this.container.setAlignment(Pos.CENTER);
		
		this.question.getStyleClass().add("question");
		this.answerContainer.setAlignment(Pos.CENTER);
		loadQuestion();

		
	}
	
}