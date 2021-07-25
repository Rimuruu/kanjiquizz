package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Question {
	private ArrayList<String> answers;
	private String trueAnswer;
	private String question;
	private Boolean isRight = false;
	
	public ArrayList<String> getAnswers() {
		return this.answers;
	}
	
	public String getTrueAnswer() {
		return this.trueAnswer;
	}
	
	public String getQuestion() {
		return this.question;
	}
	
	public Boolean isAnswer(String guess) {
		return guess.compareTo(trueAnswer) == 0;
	}
	
	public void setStatut(Boolean x) {
		this.isRight = true;
	}
	
	
	public Question(String question,String answer,String dummy1,String dummy2 ,String dummy3) {
		this.answers = new ArrayList<String>(
			      Arrays.asList("","","",""));
		System.out.println(	this.answers.size());
		ArrayList<Integer> randomPool = new ArrayList<Integer>(
			      Arrays.asList(0,1,2,3));
		Random rand = new Random();
		int size = randomPool.size();
		this.answers.set(randomPool.remove(rand.nextInt(size)),answer);
		size--;
		this.answers.set(randomPool.remove(rand.nextInt(size)),dummy1);
		size--;
		this.answers.set(randomPool.remove(rand.nextInt(size)),dummy2);
		size--;
		this.answers.set(randomPool.remove(rand.nextInt(size)),dummy3);
		System.out.println(this.answers);
		this.trueAnswer = answer;
		this.question = question;
		
		
	}
	
	
	
}