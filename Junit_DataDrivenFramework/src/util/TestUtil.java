package util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import Tests.TestBase;

public class TestUtil extends TestBase 
{
	public static void Login(String username,String password) throws InterruptedException 
	{
		WebDriverWait wait = new WebDriverWait(driver, 25);
		if(isLoggedin=true)
		{			isLoggedin=false;
		//Alert al = driver.switchTo().alert();
		//al.dismiss();
		wait.until(ExpectedConditions.visibilityOf(getObject("NotNowButton_xpath")));
		getObject("NotNowButton_xpath").click();
		getObject("login_xpath").click();

		wait.until(ExpectedConditions.visibilityOf(getObject("Login_heading_xpath")));
		getObject("username_xpath").sendKeys(username);
		getObject("continueButton_xpath").click();
		getObject("password_xpath").sendKeys(password);
		getObject("Loginbutton_xpath").click();
		wait.until(ExpectedConditions.visibilityOf(getObject("Username_heading_xpath")));
		if(getObject("Username_heading_xpath").isDisplayed())
		{
			isLoggedin=true;
			System.out.println(getObject("Username_heading_xpath").getText());
		}
		System.out.println("isLoggedin = "+isLoggedin);
		}
	}

	public static void LinkedLogin(String username, String password)
	{
		getObjectN("email_input").sendKeys(username);
		getObjectN("password_input").sendKeys(password);
		getObjectN("submit_button").click();

	}

	public static void LinkedinLogout() 
	{
		WebElement username = getObjectN("user_fullname");
		if(username.isDisplayed())
		{
			getObjectN("Me_link").click();
			getObjectN("signout_link").click();
		}
	}
	public static void Login_Rediff(String username, String password) throws InterruptedException
	{
		if(isLoggedin==true)
		{
			isLoggedin=true;
		}
		getObjectR("username_input").sendKeys(username);
		getObjectR("password_input").sendKeys(password);
		getObjectR("sigin_button").click();
		try
		{
			if(getObjectR("Logout_link").isDisplayed())
			{
				System.out.println("Logged in successfully");
				getObjectR("Rediff_Home_link").click();
				isLoggedin=true;
			}
		}
		catch(Exception e)
		{
			System.err.println("Not able to login");
			isLoggedin=false;
			Takescreenshot("Invalid_Login");
		}
	}

	public static void WaitForPageLoad() throws InterruptedException
	{
		JavascriptExecutor js =(JavascriptExecutor)driver;
		String state = (String) js.executeScript("return document:readyState");
		int i=0;
		while(i<10)
		{
			if(state.equals("complete"))
			{
				break;
			}
			else
			{
				Thread.sleep(2000);
			}

			i++;
		}
		Long d=(Long) js.executeScript("return jQuery:active");

		i=0;
		while(i<10)
		{
			if(d.longValue()==0)
			{
				break;
			}
			else
			{
				Thread.sleep(2000);
			}

			i++;
		}
	}

	public static void Logout_Rediff()
	{
		if(isLoggedin==true)
		{
			getObjectR("Signout_link").click();
			if(getObjectR("Signin_link").isDisplayed())
			{
				System.out.println("Logged out Successfully");
				isLoggedin=false;
			}
		}
		else
			System.out.println("Already signed-out");
	}

	public static void Takescreenshot(String fileName)
	{
		File srcFile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Date d = new Date();
		String date = new SimpleDateFormat("d").format(d)+"_"+new SimpleDateFormat("MMM").format(d)+"_"+new SimpleDateFormat("yyyy").format(d);

		try 
		{
			FileUtils.copyFile(srcFile,new File(System.getProperty("user.dir")+"/Screenshots/"+fileName+"_"+d.toString()+".png"));
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
			System.err.println(e.getMessage());

		}
	}
	
	public static void zipFolder(String folderPath)
	{
		//zip any folder
		try
		{
			File inFolder = new File(folderPath);
			File outFolder = new File("Reports.zip");
			ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(outFolder)));
			BufferedOutputStream in = null;
			byte[] data = new byte[1000];
			String files[]=inFolder.list();
			for(int i=0;i<files.length;i++)
			{
				in = new BufferedOutputStream(new FileOutputStream(inFolder.getPath()+"/"+files[i]), 1000);
				out.putNextEntry(new ZipEntry(files[i]));
				int count;
//				while((count=in.read(data,0,1000))!=-1)
//				{
//					out.write(data,0,count);
//				}
//				out.closeEntry();
			}
			out.flush();
			out.close();
		}
		catch(Exception e)
		{
			
		}
		
		
	}
}
