package com.yash.que5.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Test {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int testid;
	private String testname;
	@OneToOne
	@JoinColumn(name = "techerid")
	private Teacher teacher;

	public Test() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getTestid() {
		return testid;
	}

	public void setTestid(int testid) {
		this.testid = testid;
	}

	public String getTestname() {
		return testname;
	}

	public void setTestname(String testname) {
		this.testname = testname;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Test(int testid, String testname, Teacher teacher) {
		super();
		this.testid = testid;
		this.testname = testname;
		this.teacher = teacher;
	}

	@Override
	public String toString() {
		return "Test [testid=" + testid + ", testname=" + testname + ", teacher=" + teacher + "]";
	}

}
