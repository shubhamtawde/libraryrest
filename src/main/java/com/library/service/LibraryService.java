package com.library.service;
import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
/**
 * @author Shubham Tawde
 *
 */
import javax.ws.rs.core.MediaType;

import com.library.constants.BookErrorConstants;
import com.library.dto.BookInfo;
import com.library.dto.BookResponse;

//the Class which will be exposed as a REST Service
@Path("/library")
public class LibraryService 
{
	@GET
	@Path("test")
	@Produces(MediaType.APPLICATION_JSON)
	public String testMethod()
	{
		return "API is working as expected";
	}
	
	@GET
	@Path("getBooks")
	@Produces(MediaType.APPLICATION_JSON)
	public BookResponse getBooks() throws SQLException
	{
		LibraryServiceExt libraryServiceExt = new LibraryServiceExt();
		BookResponse bookResponse = new BookResponse();
		BookErrorConstants errorConstants = new BookErrorConstants();
		try
		{
			bookResponse = libraryServiceExt.getBooks();
			if(bookResponse.getErrorCode() == 0)
			{
				if(bookResponse.getBook().isEmpty())
				{
					bookResponse.setResultMessage("No data found in the database");
				}
				else
				{
					bookResponse.setResultMessage("Retrieved Books Successfully");
				}
			}
		}
		catch(SQLException sqlExp)
		{
			sqlExp.printStackTrace();
			bookResponse.setErrorCode(errorConstants.SQL_EXP_ERROR_CODE);
			bookResponse.setErrorMessage("SQL Exception in Class: " + getClass() + "\nCaused By: " + sqlExp.getMessage());
		}
		catch(Exception exp)
		{
			exp.printStackTrace();
			bookResponse.setErrorCode(errorConstants.GENERIC_EXP_ERROR_CODE);
			bookResponse.setErrorMessage("Generic Exception in Class: " + getClass() + "\nCaused By: " + exp.getMessage());
		}
		return bookResponse;
	}
	
	
	@POST
	@Path("addBook")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public BookResponse addBook(BookInfo bookData)
	{
		LibraryServiceExt libraryServiceExt = new LibraryServiceExt();
		BookResponse bookResponse = new BookResponse();
		BookErrorConstants errorConstants = new BookErrorConstants();
		try
		{
			bookResponse = libraryServiceExt.addBook(bookData);
			if(bookResponse.getErrorCode() == 0)
			{
				bookResponse.setResultMessage(bookData.getBookName() + " Added Successfully!");
			}
		}
		catch(SQLException sqlExp)
		{
			sqlExp.printStackTrace();
			bookResponse.setErrorCode(errorConstants.SQL_EXP_ERROR_CODE);
			bookResponse.setErrorMessage("SQL Exception in Class: " + getClass() + "\nCaused By: " + sqlExp.getMessage());
		}
		catch(Exception exp)
		{
			exp.printStackTrace();
			bookResponse.setErrorCode(errorConstants.GENERIC_EXP_ERROR_CODE);
			bookResponse.setErrorMessage("Generic Exception in Class: " + getClass() + "\nCaused By: " + exp.getMessage());
		}
		return bookResponse;
	}
	
	@DELETE
	@Path("deleteBook/{bookId}")
	@Produces(MediaType.APPLICATION_JSON)
	public BookResponse deleteBook(@PathParam("bookId") int bookId)
	{
		LibraryServiceExt libraryServiceExt = new LibraryServiceExt();
		BookResponse bookResponse = new BookResponse();
		BookErrorConstants errorConstants = new BookErrorConstants();
		try
		{
			bookResponse = libraryServiceExt.deleteBook(bookId);
			if(bookResponse.getErrorCode() == 0)
			{
				bookResponse.setResultMessage("Book with Book ID: " + bookId + " Deleted Successfully!");
			}
		}
		catch(SQLException sqlExp)
		{
			sqlExp.printStackTrace();
			bookResponse.setErrorCode(errorConstants.SQL_EXP_ERROR_CODE);
			bookResponse.setErrorMessage("SQL Exception in Class: " + getClass() + "\nCaused By: " + sqlExp.getMessage());
		}
		catch(Exception exp)
		{
			exp.printStackTrace();
			bookResponse.setErrorCode(errorConstants.GENERIC_EXP_ERROR_CODE);
			bookResponse.setErrorMessage("Generic Exception in Class: " + getClass() + "\nCaused By: " + exp.getMessage());
		}
		return bookResponse;
	}
	
	@PUT
	@Path("issueBook/{bookId}")
	@Produces(MediaType.APPLICATION_JSON)
	public BookResponse issueBook(@PathParam("bookId") int bookId)
	{
		LibraryServiceExt libraryServiceExt = new LibraryServiceExt();
		BookResponse bookResponse = new BookResponse();
		BookErrorConstants errorConstants = new BookErrorConstants();
		try
		{
			bookResponse = libraryServiceExt.issueBook(bookId);
			if(bookResponse.getErrorCode() == 0)
			{
				bookResponse.setResultMessage("Book with Book ID: " + bookId + " Issued Successfully!");
			}
		}
		catch(SQLException sqlExp)
		{
			sqlExp.printStackTrace();
			bookResponse.setErrorCode(errorConstants.SQL_EXP_ERROR_CODE);
			bookResponse.setErrorMessage("SQL Exception in Class: " + getClass() + "\nCaused By: " + sqlExp.getMessage());
		}
		catch(Exception exp)
		{
			exp.printStackTrace();
			bookResponse.setErrorCode(errorConstants.GENERIC_EXP_ERROR_CODE);
			bookResponse.setErrorMessage("Generic Exception in Class: " + getClass() + "\nCaused By: " + exp.getMessage());
		}
		return bookResponse;
	}
}