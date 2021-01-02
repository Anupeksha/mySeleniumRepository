package Suite1;

import java.io.IOException;

import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;

import Tests.TestBase;
import util.ReadXLS;
import util.TestUtil;


public class LogoutRediff extends TestBase
{
	@Before
	public void before() throws IOException
	{
		String run = ReadXLS.getCellData("Testcases","LogoutRediff", "RunMode");
		if(run.equals("N"))
		{
			Assume.assumeTrue(false);
		}
		else
		{
			initialize();
		}
	}
	
	
	@Test
	public void logout()
	{
		//System.out.println("isLoggedin = "+isLoggedin);
		TestUtil.Logout_Rediff();
	}

}
