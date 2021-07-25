package model;

import java.util.ArrayList;

public class Game {
	private ArrayList<Question> questions;
	private int nbQuestion;
	private int round = 0;
	private int score = 0;
	
	public ArrayList<Question> getQuestions() {
		return questions;
	}
	
	public Question currentQuestion() {
		return this.questions.get(round);
	}
	
	public void incrScore() {
		this.score++;
	}
	
	public int getNbQuestion() {
		return this.nbQuestion;
	}
	public int getRound() {
		return this.round;
	}
	
	public int getScore() {
		return this.score;
	}
	
	
	
	public void incr() {
		if(round < nbQuestion-1) round++;
	}
	
	public Game(Question... questions) {
		this.questions = new ArrayList<Question>();
		for(Question question : questions) {
			this.questions.add(question);
		}
		this.nbQuestion = this.questions.size();
		
	}
	
	
}