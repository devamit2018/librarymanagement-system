package com.test.models;

import java.sql.Timestamp;

public class Addbooks {

	private int id ;
	private String Callno;
	private String Name;
	private String Author;
	private String publisher;
	private int Quantity;
	private int Issue;
	private Timestamp Addeddate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCallno() {
		return Callno;
	}
	public void setCallno(String callno) {
		Callno = callno;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getAuthor() {
		return Author;
	}
	public void setAuthor(String author) {
		Author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	public int getIssue() {
		return Issue;
	}
	public void setIssue(int issue) {
		Issue = issue;
	}
	public Timestamp getAddeddate() {
		return Addeddate;
	}
	public void setAddeddate(Timestamp addeddate) {
		Addeddate = addeddate;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
