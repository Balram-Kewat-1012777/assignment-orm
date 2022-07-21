package com.yash.que5.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
@Entity
public class TestQuestions {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int qid;
	@OneToOne
	@JoinColumn(name="testid")
	private Test test;
	private String question;
	private String answer1;
	private String answer2;
	private String answer3;
	private String answer4; 
	private String correctanswer;
	public int getQid() {
		return qid;
	}
	public void setQid(int qid) {
		this.qid = qid;
	}
	public Test getTest() {
		return test;
	}
	public void setTest(Test test) {
		this.test = test;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer1() {
		return answer1;
	}
	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}
	public String getAnswer2() {
		return answer2;
	}
	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}
	public String getAnswer3() {
		return answer3;
	}
	public void setAnswer3(String answer3) {
		this.answer3 = answer3;
	}
	public String getAnswer4() {
		return answer4;
	}
	public void setAnswer4(String answer4) {
		this.answer4 = answer4;
	}
	public String getCorrectanswer() {
		return correctanswer;
	}
	public void setCorrectanswer(String correctanswer) {
		this.correctanswer = correctanswer;
	}
	public TestQuestions(int qid, Test test, String question, String answer1, String answer2, String answer3,
			String answer4, String correctanswer) {
		super();
		this.qid = qid;
		this.test = test;
		this.question = question;
		this.answer1 = answer1;
		this.answer2 = answer2;
		this.answer3 = answer3;
		this.answer4 = answer4;
		this.correctanswer = correctanswer;
	}
	@Override
	public String toString() {
		return "TestQuestions [qid=" + qid + ", test=" + test + ", question=" + question + ", answer1=" + answer1
				+ ", answer2=" + answer2 + ", answer3=" + answer3 + ", answer4=" + answer4 + ", correctanswer="
				+ correctanswer + "]";
	}
	public TestQuestions() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
