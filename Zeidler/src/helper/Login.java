package helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Files.AddFiles;

public abstract class Login {

	public static ChromeDriver dri=new ChromeDriver();
	public static  WebDriverWait wait= new WebDriverWait(dri, 10);
	
	
	public static void login() throws Exception
	{
		try 
		{
			 			
			System.setProperty("webdriver.chrome.dri", "D:\\Test\\libs\\chromedriver.exe");
						
			dri.get("https://demo.bigtreecms.org/admin/login/");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='user']")));
			
			dri.findElement(By.xpath("//input[@id='user']")).sendKeys("demo@bigtreecms.org");
			dri.findElement(By.xpath("//input[@id='password']")).sendKeys("demo");
			
			dri.findElement(By.xpath("//input[@class='button blue']")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@class,'first last')]")));
		}
		
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public static boolean isElementPresent(By by) 
	{
		try {
			dri.findElement(by);
			return true;
		} 
		catch (Exception e) 
		{		   
			return false;
		}
	}
}
