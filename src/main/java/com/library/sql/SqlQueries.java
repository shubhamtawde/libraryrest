package com.library.sql;

public class SqlQueries 
{
	public static final String GET_BOOKS = "SELECT * FROM book_info";
	
	public static final String ADD_BOOK = "INSERT INTO book_info" + " VALUES " + " (?, ?, ?, ?);";
	
	public static final String DELETE_BOOK = "DELETE FROM book_info WHERE book_id = ?;";
	
	public static final String UPDATE_BOOK = "UPDATE book_info SET qty = qty - 1 WHERE (book_id = ? AND qty > 0);";
}
