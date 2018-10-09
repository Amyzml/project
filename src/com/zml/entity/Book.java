package com.zml.entity;

public class Book {
	private String id;
	private String bname;
	private String author;
	private String publish;
	private int much;
	private int nowmuch;
	private String isbn;
	
	
	public int getMuch() {
		return much;
	}
	public void setMuch(int much) {
		this.much = much;
	}
	public int getNowmuch() {
		return nowmuch;
	}
	public void setNowmuch(int nowmuch) {
		this.nowmuch = nowmuch;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublish() {
		return publish;
	}
	public void setPublish(String publish) {
		this.publish = publish;
	}
	
	
}
