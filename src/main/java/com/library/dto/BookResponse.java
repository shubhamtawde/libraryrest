package com.library.dto;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class BookResponse
{
	private int errorCode;
	private String errorMessage;
	private String resultMessage;
	private ArrayList<BookInfo> book;
	private ArrayList<BookIssueInfo> issueBook;

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public ArrayList<BookInfo> getBook() {
		return book;
	}

	public void setBook(ArrayList<BookInfo> book) {
		this.book = book;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	@Override
	public String toString() {
		return "BookResponse [errorCode=" + errorCode + ", errorMessage=" + errorMessage + ", resultMessage="
				+ resultMessage + ", book=" + book + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	public String getResultMessage() {
		return resultMessage;
	}

	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}

	public ArrayList<BookIssueInfo> getIssueBook() {
		return issueBook;
	}

	public void setIssueBook(ArrayList<BookIssueInfo> issueBook) {
		this.issueBook = issueBook;
	}
	
}
