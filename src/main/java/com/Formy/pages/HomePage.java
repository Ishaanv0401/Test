package com.Formy.pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage
{
	private By autocomplete = By.xpath("//a[@class='btn btn-lg' and @href='/autocomplete']");
	
	public AutocompletePage clickautocompletebtn()
	{
		click(autocomplete);
		return new AutocompletePage();
	}
}
