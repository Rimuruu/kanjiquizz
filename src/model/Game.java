package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

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
	
	
	public Question randomQuestion(){
		String q = null;
		String a = null;
		String[] d = {null,null,null};

		Random rand = new Random();
		HashMap<String,String> kanjiscopy = (HashMap<String, String>) KanjiLoader.kanjis.clone();
		Iterator it =  kanjiscopy.entrySet().iterator();
		int r = rand.nextInt(kanjiscopy.size());
		for(int i = 0 ; i <  r ; i++) {
	         Map.Entry pair = (Map.Entry)it.next();
	         q = (String) pair.getKey();
	         a = (String) pair.getValue();
	         it.remove();
	    }
		for(int l = 0; l<4; l++) {
			r = rand.nextInt(kanjiscopy.size());
			for(int i = 0 ; i <  3 ; i++) {
		         Map.Entry pair = (Map.Entry)it.next();
		         d[i] = (String) pair.getValue();
		         it.remove();
		    }
		}
		
		return new Question(q,a,d[0],d[1],d[2]);
				
	
	}

	public Game() {
		this.questions = new ArrayList<Question>();
		for(int i = 0; i<5;i++) {
			this.questions.add(randomQuestion());
		}
		this.nbQuestion = this.questions.size();
		
	}
	
	
	public Game(Question... questions) {
		this.questions = new ArrayList<Question>();
		for(Question question : questions) {
			this.questions.add(question);
		}
		this.nbQuestion = this.questions.size();
		
	}
	
	
}