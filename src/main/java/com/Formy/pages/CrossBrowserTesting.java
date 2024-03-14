package com.Formy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CrossBrowserTesting {
	WebDriver driver;

	@Parameters("Browser")
	@BeforeMethod
	public void setup(String browser) {
		if(browser.equalsIgnoreCase("Edge")) 
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else if (browser.equalsIgnoreCase("Chrome")) 
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
	}

	@Test
	public void TestRadioBtn() {
		driver.get("https://formy-project.herokuapp.com/radiobutton");
		System.out.println("Test the functionality of Radio Btn");
		WebElement RadioBtn = driver.findElement(By.id("radio-button-1"));
		RadioBtn.click();
		Boolean Status = RadioBtn.isSelected();
		Assert.assertEquals(true, Status);
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
