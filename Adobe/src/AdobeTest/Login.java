package AdobeTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Login 
{

	public static void main(String args[]) throws InterruptedException
	{
	WebDriver driver = new FirefoxDriver();
	driver.get("file:///C:/Users/SUDHEER/Desktop/AAM-qe/AAM-login-page.html");
	Thread.sleep(3000);
	WebElement adobeUserIDTextBox = driver.findElement(By.id("adobeid_username"));
	WebElement adobePasswordTextBox = driver.findElement(By.id("adobeid_password"));
	
	WebElement enterpriseUserIDTextBox = driver.findElement(By.id("enterprise_username"));
	WebElement enterprisePasswordTextBox = driver.findElement(By.id("enterprise_password"));
	
	WebElement adobeSubmitButton = driver.findElement(By.id("sign_in"));
	WebElement signInWithEnterpriseIDButton = driver.findElement(By.xpath("id('enterprise_sign_in_button')"));
	
	WebElement adobeStaySignedInCheckBox = driver.findElement(By.id("adobeid_remember_me"));
	WebElement enterpriseStaySignedInCheckBox = driver.findElement(By.id("enterprise_remember_me"));
	//WebElement signinwithanEnterpriseIDLink = driver.findElement(By.id("enterprise_signin_link")));
	
	adobeUserIDTextBox.sendKeys("adobeuser@gmail.com");
	adobePasswordTextBox.sendKeys("Password@123");		
	adobeSubmitButton.click();
	System.out.println("TC - 1 : Passed");
	Thread.sleep(3000);

	enterpriseStaySignedInCheckBox.click();
	enterpriseUserIDTextBox.sendKeys("enterpriseuser");
	enterprisePasswordTextBox.sendKeys("Password@123");		Thread.sleep(3000);
	signInWithEnterpriseIDButton.click();
	System.out.println("TC - 3 : Passed");
	
	driver.quit();	
	
	}
}
