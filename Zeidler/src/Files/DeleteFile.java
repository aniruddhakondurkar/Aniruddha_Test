package Files;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import helper.Login;

public class DeleteFile extends Login
{
	//Filename to be deleted
	static String filename="download-3.jpeg";


	public static void main (String args[]) throws Exception
	{
		deletefile();
	}
	
	public static void deletefile()
	{
		try
		{
			login();
			
			dri.findElement(By.xpath("//span[@class='files']")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Add Images')]")));
			
			//search the file to be deleted
			
			WebElement deletefile= dri.findElement(By.xpath("//a[contains(text(),'"+filename+"')]//following::a[@class='icon_delete']"));
			deletefile.click();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='Delete File']")));
			
			dri.findElement(By.xpath("//input[@value='Delete File']")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='js-file-manager-search']")));
			
			if(!isElementPresent(By.xpath("//a[contains(text(),'"+filename+"')]")))
			{
				System.out.println("File deleted successfully");
			}
			
			else
			{
				System.out.println("Error in deleting file, File not deleted");
			}
			
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	

}
