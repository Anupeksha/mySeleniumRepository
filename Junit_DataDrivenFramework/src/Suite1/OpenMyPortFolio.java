package Suite1;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.Keys;

import Tests.TestBase;
import util.ReadXLS;

@RunWith(Parameterized.class)
public class OpenMyPortFolio extends TestBase 
{
	String username;
	String password;

	public OpenMyPortFolio(String username, String password)
	{
		this.username=username;
		this.password=password;
	}

	@Parameters
	public static Collection<Object[]> dataSet() throws IOException
	{
		Object[][] data=new Object[1][2];
		int colcnt=ReadXLS.getColCount("LoginRediff");
		//System.out.println("col : "+colcnt);
		int r=2;

		for(int c=2;c<=colcnt;c++)

		{	
			//System.out.println("[r-2][c-2] = "+(r-2) +"  "+(c-2));
			data[r-2][c-2]=ReadXLS.getCellData("LoginRediff", r+1, c);
			//System.out.println(data[r-2][c-2]);

		}
		/*data[0][0]=ReadXLS.getCellData("LoginRediff",3, 2);
		data[0][1]=ReadXLS.getCellData("LoginRediff",3, 3);*/
		return Arrays.asList(data);
	}

	@Before
	public void before() throws IOException
	{
		String run = ReadXLS.getCellData("Testcases","OpenMyPortFolio", "RunMode");
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
	public void open() throws InterruptedException
	{
		//driver.get(OR_Rediff.getProperty("url"));

		//TestUtil.Login_Rediff("anuthe.best01","Lucky@11");
		getObjectR("Home_link").click();
		getObjectsR("Topemenu").get(1).click();
		getObjectsR("Top_Tabs_links").get(1).click();
		getObjectR("RediffMoney_Signin_input").sendKeys(username);
		getObjectR("RediffMoney_password_input").sendKeys(password);
		getObjectR("RediffMoney_password_input").sendKeys(Keys.ENTER);
		//System.out.println("isLoggedin = "+isLoggedin);
	}

}
