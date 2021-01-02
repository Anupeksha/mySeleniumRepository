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

import Tests.TestBase;
import util.ReadXLS;
import util.TestUtil;


@RunWith(Parameterized.class)
public class LoginRediff extends TestBase
{
	public String username;
	public String password;

	public LoginRediff(String username, String password)
	{
		this.username=username;
		this.password=password;
	}

	@Parameters
	public static Collection<Object[]> getData() throws IOException
	{
		//rows - no. of times you want to repeat test
		//cols - no. of parameters needed to be passed

		Object[][] data = new Object[2][2];
		int rowcnt=ReadXLS.getRowCount("LoginRediff");
		int colcnt=ReadXLS.getColCount("LoginRediff");

		//System.out.println("rows : "+rowcnt);System.out.println("cols : "+colcnt);

		for(int r=2;r<=rowcnt;r++)

		{
			for(int c=2;c<=colcnt;c++)
			{
				//System.out.println("[r][c] = "+r +"  "+c);
				//System.out.println("[r-2][c-2] = "+(r-2) +"  "+(c-2));
				//System.out.println(data[r-2][c-r]=ReadXLS.getCellData("LoginRediff", r, c));
				data[r-2][c-2]=ReadXLS.getCellData("LoginRediff", r, c);
			}
		}
		
		/*data[0][0]=ReadXLS.getCellData("LoginRediff",2, 2);
		data[0][1]=ReadXLS.getCellData("LoginRediff",2, 3);

		data[1][0]=ReadXLS.getCellData("LoginRediff",3, 2);
		data[1][1]=ReadXLS.getCellData("LoginRediff",3, 3);*/

		return Arrays.asList(data);
	}


	@Before
	public void before() throws IOException
	{
		String run = ReadXLS.getCellData("Testcases","LoginRediff", "RunMode");
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
	public void login_rediff() throws InterruptedException
	{
		driver.get(OR_Rediff.getProperty("url"));
		//TestUtil.WaitForPageLoad();
		TestUtil.Login_Rediff(username,password);
		//System.out.println("isLoggedin = "+isLoggedin);


	}

}
