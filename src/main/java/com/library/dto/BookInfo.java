package com.library.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BookInfo 
{
	private int bookId;
	private String bookTitle;
	private String bookAuthor;
	private int bookQty;
	
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
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
		return "Book Id:" + this.bookId + " Book Title:" + this.bookTitle + "\t \t" + " Book Author:" + this.bookAuthor + "\t \t"  + " Book Quantity:" + this.bookQty;
	}
	
	
}
