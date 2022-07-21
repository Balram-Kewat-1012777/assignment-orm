package com.yash.que5.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Teacher {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int techerid;
	private String teachername;
	private String email; 
	private String password;
	
	
	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getTecherid() {
		return techerid;
	}
	public void setTecherid(int techerid) {
		this.techerid = techerid;
	}
	public String getTeachername() {
		return teachername;
	}
	public void setTeachername(String teachername) {
		this.teachername = teachername;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Teacher [techerid=" + techerid + ", teachername=" + teachername + ", email=" + email + ", password="
				+ password + "]";
	}
	public Teacher(int techerid, String teachername, String email, String password) {
		super();
		this.techerid = techerid;
		this.teachername = teachername;
		this.email = email;
		this.password = password;
	}
	
	
	
}
