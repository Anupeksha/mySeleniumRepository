package Suite1;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import Tests.TestBase;
import util.ReadXLS;
import util.TestUtil;

public class TestsearchLinks extends TestBase
{
	@Rule
	public ErrorCollector err=new ErrorCollector();


	@Before
	public void before() throws IOException
	{
		if(ReadXLS.getCellData("Testcases", "TestsearchLinks", "RunMode").equals("N"))
		{
			Assume.assumeTrue(false);
		}
		else
		{
			initialize();
		}
	}

	@Test
	public void linksTest()
	{

		String links_part1=OR_Rediff.getProperty("ProductLinks_part1");
		String links_part2=OR_Rediff.getProperty("ProductLinks_part2");

		for(int i=2;i<6;i++)
		{
			try
			{
				WebElement e = driver.findElement(By.xpath(links_part1+i+links_part2));
				String product_name=e.getText();
				e.click();
				String head = getObjectR("Product_heading").getText();
				Thread.sleep(2000);
				//System.out.println(i+" : "+head);
				if(product_name.equals(head))
				{
					System.out.println("Navigated to the correct page opened");
					//TestUtil.Takescreenshot("Linked_Page");
				}
				else
				{
					//System.out.println(product_name+" : "+head);
					System.err.println("Leading to incorrect page : "+i);

					//Assert.assertTrue("Leading to incorrect page", product_name.equals(head));
					TestUtil.Takescreenshot("Incorrect_Page_snap");
				}

				driver.navigate().back();
			}
			catch(Throwable t)
			{
				err.addError(t);
				//Assert.assertTrue("Product page not found", false);
				System.err.println("Product page not found");
				TestUtil.Takescreenshot("NoTitle");
			}
		}


	}
}


