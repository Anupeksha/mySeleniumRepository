package Tests;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import util.TestUtil;


public class FirstCry_Login extends TestBase
{
	@Before
	public void before() throws IOException
	{
		initialize();
	}

	@Test
	public void login_fc() throws InterruptedException
	{
		driver.get(OR_link.getProperty("url"));
		TestUtil.WaitForPageLoad();
		//TestUtil.Login_FirstCry(username, password);
	}

}
