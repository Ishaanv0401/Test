package com.Formy.pages;

import org.openqa.selenium.*;

public class BasePage 
{
	public static WebDriver driver;
	
	public void setWebDriver(WebDriver driver)
	{
		BasePage.driver = driver;
		
	}
	protected WebElement find(By locator)
	{
		return driver.findElement(locator);
	}
	
	protected void click(By locator)
	{
		find(locator).click();
	}
	
	protected void entertext(By locator,String testdata)
	{
		find(locator).sendKeys(testdata);
	}
	
	protected String getText(By locator)
	{
		String text=find(locator).getText();
		System.out.println("Text: "+text);
		return text;
	}

}
