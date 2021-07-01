package com.library.sql;

public class SqlQueries 
{
	public static final String GET_BOOKS = "SELECT * FROM book_info";
	
	public static final String ADD_BOOK = "INSERT INTO book_info" + " VALUES " + " (?, ?, ?, ?);";
	
	public static final String DELETE_BOOK = "INSERT INTO book_info" + " VALUES " + " (?, ?, ?, ?);";
}
