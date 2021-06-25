/**
 * 
 */
package com.library.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Shubham Tawde
 * 
 */
public class DatabaseConnection 
{
	/* The DB URL, Username, Password variables
	 */
	static final String dbURL = "jdbc:mysql://localhost:3306/library?useSSL=false";
	static final String dbUser = "root";
	static final String dbPass = "12345";
	
	public Connection getConnection() throws SQLException, ClassNotFoundException
	{
		Connection dbConnection;
		//instantiate the connection
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			dbConnection = DriverManager.getConnection(dbURL, dbUser, dbPass);
		}
		catch (SQLException sqlExp) 
		{
			System.out.println("Error Description: " + sqlExp.getMessage());
			sqlExp.printStackTrace();
			throw sqlExp;
		}
		catch (ClassNotFoundException exp) 
		{
			System.out.println("Error Description: " + exp.getMessage());
			exp.printStackTrace();
			throw exp;
		}
		//return the database connection to the calling class
		return dbConnection;
	}

	public void closeConnection(Connection dbConnection) throws SQLException 
	{
		try 
		{
			if(dbConnection != null)
			{
				dbConnection.close();
			}
		} 
		catch (SQLException sqlExp)
		{
			System.out.println("Error Description: " + sqlExp.getMessage());
			sqlExp.printStackTrace();
			throw sqlExp;
		}
	}
}

