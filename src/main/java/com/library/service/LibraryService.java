/**
 * 
 */
package com.library.service;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
/**
 * @author Shubham Tawde
 *
 */

//the Class which will be exposed as a REST Service
@Path("/library")
public class LibraryService 
{
	@GET
	@Path("test")
	public String testMethod()
	{
		return "API is working as expected";
	}
}
