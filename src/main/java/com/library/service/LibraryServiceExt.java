package com.library.service;

import java.sql.SQLException;

import com.library.constants.BookErrorConstants;
import com.library.dto.BookResponse;
import com.library.service.impl.LibraryServiceImpl;

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

}
