package Tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import util.TestUtil;


public class TestBase 
{
	//Initializing the property file
	public static Properties CONFIG=null;
	public static Properties OR=null;
	public static Properties OR_link=null;
	public static Properties OR_Rediff=null;
	public static WebDriver dr=null;
	public static EventFiringWebDriver driver =null;
	public static boolean isLoggedin=false;

	public void initialize() throws IOException 
	{
		//We don't want to initialize the driver again and again hence we keep a condition
		if(driver==null)
		{
			//Loading config.properties
			CONFIG = new Properties();
			FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"/src/Config/config.properties");
			CONFIG.load(fs);

			//Loading OR.properties
			OR=new Properties();
			fs = new FileInputStream(System.getProperty("user.dir")+"/src/Config/OR.properties");
			OR.load(fs);

			OR_link=new Properties();
			fs=new FileInputStream(System.getProperty("user.dir")+"/src/Config/OR_Linkedin.properties");
			OR_link.load(fs);
			//System.out.println(OR_link.getProperty("url"));

			OR_Rediff=new Properties();
			fs=new FileInputStream(System.getProperty("user.dir")+"/src/Config/OR_Rediff.properties");
			OR_Rediff.load(fs);


			//Initialize the webdriver

			if(CONFIG.getProperty("browser").equals("Mozilla"))
			{
				dr= new FirefoxDriver();
			}
			else
			{
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--start-maximized");
				dr= new ChromeDriver(options);
			}

			driver = new EventFiringWebDriver(dr);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		}
	}



	public static WebElement getObject(String xpathkey)
	{
		try
		{
			return driver.findElement(By.xpath(OR.getProperty(xpathkey)));
		}
		catch(Throwable t)
		{
			System.out.println("Error finding the Webelement");
			return null;
		}


	}
	public static WebElement getObjectN(String xpathkey)
	{
		try
		{
			return driver.findElement(By.xpath(OR_link.getProperty(xpathkey)));
		}
		catch(Throwable t)
		{
			System.out.println("Error finding the Webelement");
			return null;
		}


	}
	public static WebElement getObjectR(String xpathkey)
	{
		try
		{
			return driver.findElement(By.xpath(OR_Rediff.getProperty(xpathkey)));
		}
		catch(Throwable t)
		{
			//System.out.println("Error finding the Webelement");
			TestUtil.Takescreenshot(xpathkey);
			//Assert.assertTrue(t.getMessage(), false);
			return null;

		}


	}

	public static List<WebElement> getObjectsR(String xpathkey)
	{
		try
		{
			return driver.findElements(By.xpath(OR_Rediff.getProperty(xpathkey)));
		}
		catch(Throwable t)
		{
			//System.out.println("Error finding the Webelement");
			return null;
		}


	}

}
