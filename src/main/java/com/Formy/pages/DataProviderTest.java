package com.Formy.pages;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderTest 
{
	WebDriver driver;
	
	@BeforeMethod
	public void setup()
	{
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
		driver.manage().window().maximize();
		
	}
	
	@DataProvider
	public Object[][] ajaxData()
	{
		Object[][] data=new Object [2][3];
		data[0][0]="Joe";
		data[0][1]="Doe";
		data[0][2]="Tester";
		data[1][0]="Jane";
		data[1][1]="Doe";
		data[1][2]="Developer";

		return data;		
	}
	@Test(dataProvider="ajaxData")
	public void testAjaxform(String name, String lastname,String Jobtitle)
	{
		System.out.println("Name:"+name);
		System.out.println("Lastname:"+lastname);
		System.out.println("Job Title:"+Jobtitle);
		driver.get("https://formy-project.herokuapp.com/form");
		
		driver.findElement(By.id("first-name")).sendKeys(name);
		driver.findElement(By.id("last-name")).sendKeys(lastname);
		driver.findElement(By.id("job-title")).sendKeys(Jobtitle);
		
		WebElement Button=driver.findElement(By.xpath("//a[@href=\"/thanks\"]"));
		Button.click();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(2000));
		WebElement AlertMsg=driver.findElement(By.xpath("//div[@class='alert alert-success']"));
		wait.until(ExpectedConditions.visibilityOf(AlertMsg));
		String Subimission_Msg=AlertMsg.getText().trim();
		Assert.assertEquals(Subimission_Msg,"The form was successfully submitted!");
	}
	
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}

}
