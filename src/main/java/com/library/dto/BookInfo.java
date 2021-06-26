package com.library.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BookInfo 
{
	private int bookId;
	private String bookName;
	private String bookAuthor;
	private int bookQty;
	
	public BookInfo() {
		
	}
	
	public BookInfo(int bookId, String bookName, String bookAuthor, int bookQty) {
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.bookQty = bookQty;
	}

	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public int getBookQty() {
		return bookQty;
	}
	public void setBookQty(int bookQty) {
		this.bookQty = bookQty;
	}
	
	@Override
	public String toString() {
		return "Book Id:" + this.bookId + " Book Name:" + this.bookName + "\t \t" + " Book Author:" + this.bookAuthor + "\t \t"  + " Book Quantity:" + this.bookQty;
	}
	
	
}
