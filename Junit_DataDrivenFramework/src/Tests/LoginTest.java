package Tests;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import util.TestUtil;

public class LoginTest extends TestBase 
{
	@Before
	public void BeforeTest() throws IOException
	{
		initialize();
	}

	@Test
	public void login() throws InterruptedException
	{
		driver.get(CONFIG.getProperty("URL_under_test"));
		TestUtil.Login("aloo080817@gmail.com","lucky@11");
		if(!isLoggedin)
		{
			System.out.println("Unable to login");
		}

	}

}
