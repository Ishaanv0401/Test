package com.Formy.pages;

import java.awt.Checkbox;
import java.time.LocalDate;

import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParallelTesting 
{
	WebDriver driver;
	
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
	
	@Test(threadPoolSize = 3,invocationCount=4)
	public void test_Datepicker() throws Exception
	{
		driver.get("https://formy-project.herokuapp.com/datepicker");
		System.out.println("Test the DatePicker functionality");
		WebElement datepicker=driver.findElement(By.id("datepicker"));
		datepicker.click();
		//Thread.sleep(2000);
		WebElement currentDate=driver.findElement(By.xpath("//td[@class='today day']"));
		currentDate.click();
		/*Thread.sleep(3000);
		LocalDate TodaysDate = LocalDate.now();
		String SelectedDate=datepicker.toString();
		String ExpectedDate=TodaysDate.toString();
		
		System.out.println("Expected Date is:"+ExpectedDate);
		System.out.println("Selected Date is:"+SelectedDate);*/
		
		//Assert.assertEquals(currentDate.isEnabled(), true);
	}
	
	@Test
	public void TestCheckbox()
	{
		driver.get("https://formy-project.herokuapp.com/checkbox");
		driver.manage().window().maximize();
		WebElement Checkbox=driver.findElement(By.id("checkbox-1"));
		Checkbox.click();
		Boolean CheckboxStatus=Checkbox.isSelected();
		Assert.assertEquals(true, CheckboxStatus);
	}

}
