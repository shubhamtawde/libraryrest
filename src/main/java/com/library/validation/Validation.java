/**
 * 
 */
package com.library.validation;

/**
 * @author Shubham Tawde
 *
 */
public class Validation 
{
	public boolean checkChar(String test)
	{
		for(int i=0; i<test.length(); i++)
		{	
			if(!Character.isAlphabetic(test.charAt(i)))
			{
				if(!Character.isWhitespace(test.charAt(i)))
					return false;
				else
					continue;
			}
			else
				continue;
		}
		return true;
	}
}
