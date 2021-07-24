package model;

import java.util.ArrayList;

public class Game {
	private ArrayList<Question> questions;
	int nbQuestion;
	int round;
	
	public ArrayList<Question> getQuestions() {
		return questions;
	}
	
	public Question currentQuestion() {
		return this.questions.get(round);
	}
	
	
	
	public void incr() {
		if(round < nbQuestion-1) round++;
	}
	
	public Game(Question... questions) {
		this.questions = new ArrayList<Question>();
		for(Question question : questions) {
			this.questions.add(question);
		}
		this.round = 0;
		this.nbQuestion = this.questions.size();
		
	}
	
	
}