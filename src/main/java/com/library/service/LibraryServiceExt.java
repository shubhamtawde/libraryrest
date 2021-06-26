package com.library.service;

import java.sql.SQLException;

import com.library.constants.BookErrorConstants;
import com.library.dto.BookInfo;
import com.library.dto.BookResponse;
import com.library.service.impl.LibraryServiceImpl;
import com.library.validation.Validation;

public class LibraryServiceExt 
{

	public BookResponse getBooks() throws SQLException 
	{
		BookResponse bookResponse = new BookResponse();
		BookErrorConstants errorConstants = new BookErrorConstants();
		LibraryServiceImpl libraryServiceImpl = new LibraryServiceImpl();
		try
		{
			bookResponse = libraryServiceImpl.getBooks();
		}
		catch(SQLException sqlExp)
		{
			sqlExp.printStackTrace();
			bookResponse.setErrorCode(errorConstants.SQL_EXP_ERROR_CODE);
			bookResponse.setErrorMessage("SQL Exception in Class: " + getClass() + "\nCaused By: " + sqlExp.getMessage());
			throw sqlExp;
		}
		catch(Exception exp)
		{
			exp.printStackTrace();
			bookResponse.setErrorCode(errorConstants.GENERIC_EXP_ERROR_CODE);
			bookResponse.setErrorMessage("SQL Exception in Class: " + getClass() + "\nCaused By: " + exp.getMessage());
		}
		return bookResponse;
	}

	public BookResponse addBook(BookInfo bookData) throws SQLException 
	{
		
		BookResponse bookResponse = new BookResponse();
		BookErrorConstants errorConstants = new BookErrorConstants();
		LibraryServiceImpl libraryServiceImpl = new LibraryServiceImpl();
		Validation validationCheck = new Validation();
		
		//checks for validation whether object passed is empty or not
		if(bookData.getBookId() <= 0)
		{
			bookResponse.setErrorCode(-1);
			bookResponse.setErrorMessage("Book ID Cannot be negative/zero");
		}
		if(bookData.getBookQty() <= 0)
		{
			bookResponse.setErrorCode(-1);
			bookResponse.setErrorMessage("Book Quantity cannot be negative/zero");
		}
		if(!validationCheck.checkChar(bookData.getBookName()) || !validationCheck.checkChar(bookData.getBookAuthor()))
		{
			bookResponse.setErrorCode(errorConstants.NO_CHAR_PRESENT);
			bookResponse.setErrorMessage("Enter Alphabets only");
		}
		if(bookData.getBookName().isEmpty() || bookData.getBookAuthor().isEmpty())
		{
			bookResponse.setErrorCode(errorConstants.IS_EMPTY_FIELD);
			bookResponse.setErrorMessage("Book Name/Author cannot be empty!");
		}
		
		try
		{
			bookResponse = libraryServiceImpl.addBook(bookData);
		}
		catch(SQLException sqlExp)
		{
			sqlExp.printStackTrace();
			bookResponse.setErrorCode(errorConstants.SQL_EXP_ERROR_CODE);
			bookResponse.setErrorMessage("SQL Exception in Class: " + getClass() + "\nCaused By: " + sqlExp.getMessage());
			throw sqlExp;
		}
		catch(Exception exp)
		{
			exp.printStackTrace();
			bookResponse.setErrorCode(errorConstants.GENERIC_EXP_ERROR_CODE);
			bookResponse.setErrorMessage("SQL Exception in Class: " + getClass() + "\nCaused By: " + exp.getMessage());
		}
		return bookResponse;
	}

}
