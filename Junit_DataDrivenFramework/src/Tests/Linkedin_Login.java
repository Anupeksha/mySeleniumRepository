package Tests;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import util.TestUtil;

public class Linkedin_Login extends TestBase
{
	@Before
	public void BeforeTest() throws IOException
	{
		initialize();
	}
	
	@Test
	public void login_link()
	{
		//System.out.println("url : "+OR_link.getProperty("url"));
		driver.get(OR_link.getProperty("url"));
		TestUtil.LinkedLogin("anuthe.best01@gmail.com","aloo2017");
		TestUtil.LinkedinLogout();
		
	}

}


