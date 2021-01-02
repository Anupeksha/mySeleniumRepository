package Suite1;

import java.io.IOException;

import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import Tests.TestBase;
import util.ReadXLS;
import util.TestUtil;

public class SearchShopping extends TestBase
{
	@Before
	public void before() throws IOException
	{
		String run = ReadXLS.getCellData("Testcases","SearchShopping", "RunMode");
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
	public void search() throws InterruptedException
	{
		driver.get(OR_Rediff.getProperty("url"));
		TestUtil.Login_Rediff("anuthe.best01", "Lucky@11");
		getObjectR("search_input").sendKeys(OR_Rediff.getProperty("Search_Keyword"));
		getObjectR("search_input").sendKeys(Keys.ENTER);
		String search_head=OR_Rediff.getProperty("Search_heading")+OR_Rediff.getProperty("Search_Keyword")+")]";
		if(driver.findElement(By.xpath(search_head)).isDisplayed())
		{
			System.out.println("Search results displayed");
		}
		//System.out.println("isLoggedin = "+isLoggedin);

	}

}
