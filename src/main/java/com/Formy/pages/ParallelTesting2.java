package com.Formy.pages;

import org.testng.Assert;
import org.openqa.selenium.*;
import org.testng.annotations.*;
import org.openqa.selenium.edge.EdgeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ParallelTesting2 
{
	private WebDriver driver;
	
	@BeforeMethod
	public void setup()
	{
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	
	@Test
	public void TestRadioBtn()
	{
		driver.get("https://formy-project.herokuapp.com/radiobutton");
		System.out.println("Test the functionality of Radio Btn");
		WebElement RadioBtn=driver.findElement(By.id("radio-button-1"));
		RadioBtn.click();
		Boolean Status=RadioBtn.isSelected();
		Assert.assertEquals(true, Status);
	}
}
