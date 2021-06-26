package com.library.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.library.constants.BookErrorConstants;
import com.library.database.DatabaseConnection;
import com.library.dto.BookInfo;
import com.library.dto.BookResponse;
import com.library.sql.SqlQueries;

public class LibraryServiceImpl 
{

	public BookResponse getBooks() throws Exception 
	{
		DatabaseConnection databaseConnection = new DatabaseConnection();
		ArrayList<BookInfo> bookData = new ArrayList<BookInfo>();
		BookResponse bookResponse = new BookResponse();
		BookErrorConstants errorConstants = new BookErrorConstants();
		ResultSet dbResult = null;
		Connection dbConn = null;
		PreparedStatement sqlStatement = null;
		SqlQueries sqlQuery = new SqlQueries();
		try
		{
			dbConn = databaseConnection.getConnection();
			if(dbConn != null)
			{
				sqlStatement = dbConn.prepareStatement(sqlQuery.GET_BOOKS);
				dbResult = sqlStatement.executeQuery();
				if(dbResult == null)
				{
					bookResponse.setResultMessage("No Books Found");
				}
				else
				{
					while(dbResult.next())
					{
						BookInfo bookDTO = new BookInfo();
						bookDTO.setBookId(dbResult.getInt(1));
						bookDTO.setBookName(dbResult.getString(2));
						bookDTO.setBookAuthor(dbResult.getString(3));
						bookDTO.setBookQty(dbResult.getInt(4));
						bookData.add(bookDTO);
					}
					bookResponse.setResultMessage("Retrieved Books Successfully");
					bookResponse.setBook(bookData);
				}
			}
			else
			{
				throw new SQLException();
			}
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
			bookResponse.setErrorMessage("Generic Exception in Class: " + getClass() + "\nCaused By: " + exp.getMessage());
			throw exp;
		}
		finally
    	{
    		if(dbResult != null)
    		{
    			try
    			{
	    			if(!dbResult.isClosed())
	    				dbResult.close();
    			}
    			catch(SQLException err)
    			{
    				err.printStackTrace();
    				bookResponse.setErrorCode(errorConstants.SQL_EXP_ERROR_CODE);
    				bookResponse.setErrorMessage("SQL Exception in Class: " + getClass() + "\nCaused By: " + err.getMessage());
    				throw err;
    			}
    		}
    		if(sqlStatement != null)
    		{
    			try
    			{
	    			if(!sqlStatement.isClosed())
	    				sqlStatement.close();
    			}
    			catch(SQLException err)
    			{
    				err.printStackTrace();
    				bookResponse.setErrorCode(errorConstants.SQL_EXP_ERROR_CODE);
    				bookResponse.setErrorMessage("SQL Exception in Class: " + getClass() + "\nCaused By: " + err.getMessage());
    				throw err;
    			}
    		}
    		if(dbConn != null)
    		{
    			try
    			{
	    			if(!dbConn.isClosed())
	    				databaseConnection.closeConnection(dbConn);
    			}
    			catch(SQLException err)
    			{
    				err.printStackTrace();
    				bookResponse.setErrorCode(errorConstants.SQL_EXP_ERROR_CODE);
    				bookResponse.setErrorMessage("SQL Exception in Class: " + getClass() + "\nCaused By: " + err.getMessage());
    				throw err;
    			}
    		}
    	}
		return bookResponse;
	}

}
