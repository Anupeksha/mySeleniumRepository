package Tests;

import java.util.Arrays;
import java.util.Collection;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

public class ParameterizeTests 
{
	//Step 1 - Use Runwith class
	@RunWith(Parameterized.class)
	public class ParametrizeTC
	{
		//Step 2 -Declare Global Variables
		public String username;
		public String password;
		
		//Step 3 - create a constructor
		public ParametrizeTC(String username, String password)
		{
			this.username=username;
			this.password=password;
		}
				
	}
	
	//Step 4 - declaring variables
	@Parameters
	public static Collection<Object[]> getData()
	{
		//rows - no. of times you want to repeat test
		//cols - no. of parameters needed to be passed
		
		Object[][] data = new Object[2][2];
		data[0][0]="anuthe.best";
		data[0][1]="passwd";
		
		data[1][0]="anuthe.best01";
		data[1][1]="Lucky@11";
		
		return Arrays.asList(data);
	}

}
