
package AdobeTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginPage 
{
	static WebDriver driver;
	
	WebElement adobeUserIDTextBox = driver.findElement(By.id("adobeid_username"));
	WebElement adobePasswordTextBox = driver.findElement(By.id("adobeid_password"));
	
	WebElement enterpriseUserIDTextBox = driver.findElement(By.id("enterprise_username"));
	WebElement enterprisePasswordTextBox = driver.findElement(By.id("enterprise_password"));
	
	WebElement submitButton = driver.findElement(By.id("sign_in"));
	WebElement signInWithEnterpriseIDButton = driver.findElement(By.xpath("id('enterprise_sign_in_button')"));
	
	WebElement adobeStaySignedInCheckBox = driver.findElement(By.id("adobeid_remember_me"));
	WebElement enterpriseStaySignedInCheckBox = driver.findElement(By.id("enterprise_remember_me"));
	
	WebElement signinwithanEnterpriseIDLink = driver.findElement(By.id("enterprise_signin_link"));
	
	static String adobeurl = "file:///C:/Users/SUDHEER/Desktop/AAM-qe/AAM-login-page.html";
	WebElement blankEmailAddressMessage=driver.findElement(By.xpath("id('adobeid_signin')/fieldset[1]"));	
	
	
/*	@BeforeTest
	public void LaunchURL() throws Exception
	{
		driver.get(adobeurl);
	}*/
	
	@Test (description="TC - 1 - Valid Adobe User id + Valid Password + with checkbox (Stay signed in) marked")
	public void TC1() throws Exception
	{
		try
		{
			adobeUserIDTextBox.sendKeys("adobeuser@gmail.com");
			adobePasswordTextBox.sendKeys("Password@123");		
			submitButton.click();
			System.out.println("TC1 Passed");
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
		}
	}
	
	@Test (description="TC - 2 - InValid Adobe User id + Valid Password + withOUT checkbox (Stay signed in) marked")
	public void TC2() throws Exception
	{
		try
		{
			adobeStaySignedInCheckBox.click();
			adobeUserIDTextBox.sendKeys("adobeuserinvalid@gmail.com");
			adobePasswordTextBox.sendKeys("Password@123");	Thread.sleep(3000);	
			submitButton.click();
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
		}
	}
	
	@Test (description="TC - 3 - Valid Enterprise domain id + Valid Password + with checkbox (Stay signed in) marked")
	public void TC3() throws Exception
	{
		try
		{
			signinwithanEnterpriseIDLink.click();
			enterpriseUserIDTextBox.sendKeys("enterpriseuser");
			enterprisePasswordTextBox.sendKeys("Password@123");		
			signInWithEnterpriseIDButton.click();
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
		}
	}
	
	@Test (description="TC - 4 - Valid Enterprise User id + Valid Password + withOUT checkbox (Stay signed in) marked")
	public void TC4() throws Exception
	{
		try
		{
			signinwithanEnterpriseIDLink.click();
			enterpriseUserIDTextBox.sendKeys("enterpriseuser@gmail.com");
			enterprisePasswordTextBox.sendKeys("Password@123");		
			enterpriseStaySignedInCheckBox.click(); Thread.sleep(3000);
			signInWithEnterpriseIDButton.click();
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
		}	
	}
	
	public void verifyText(String actualStgring, String expectedString) throws Exception
	{
		try
		{
			if (actualStgring.equals(expectedString))
			{
				System.out.println("Acual value : " + actualStgring + " - is equal to expected value : " + expectedString );
			}
			else
				System.out.println("Acual value : " + actualStgring + " - is NOT EQUAL expected value : " + expectedString );
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
		}
	}
	
	@Test (description="TC - 5 - For Adobe User id Form - entering empty/blank email id + blank password ")
	public void TC5() throws Exception 
	{
		try
		{
			adobeUserIDTextBox.sendKeys("");
			adobePasswordTextBox.sendKeys("");		
			submitButton.click();
			Thread.sleep(3000);
			String expectedString1 = blankEmailAddressMessage.getText();
			System.out.println("Expected String : " + expectedString1);
			String actualString1 = "Enter your email";
			verifyText(actualString1,expectedString1);
		}
		
		catch (Exception exception)
		{
			exception.printStackTrace();
		}
	}
	
	
/*	@AfterSuite
	public void LaunchURL() throws Exception
	{
		driver.quit();
	}*/
	
	public static void main(String args[]) throws Exception
	{
		driver = new FirefoxDriver();
		driver.get(adobeurl);
		LoginPage obj = new LoginPage();
		obj.TC1();
		obj.TC2();
		obj.TC3();
		obj.TC4();
		obj.TC5();
		
		driver.quit();
	}
}
