package com.Formy.pages;

import java.sql.Time;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutocompletePage extends BasePage
{
	private By Address =By.id("autocomplete");
	private By StreetAddress = By.id("street_number");
	private By City = By.id("locality");
	private By State = By.id("administrative_area_level_1");
	private By ZipCode = By.id("postal_code");
	private By Country = By.id("country");
	
	public void Autocomplete_details() throws InterruptedException
	{
		//Thread.sleep(3000);
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("autocomplete"))));
		entertext(Address, "55 strathaven Dr");
		entertext(StreetAddress, "Bristol Rd");
		entertext(City, "Mississauga");
		entertext(State, "Ontario");
		entertext(ZipCode, "L5R 4G9");
		entertext(Country, "Canada");
	}
	
}
