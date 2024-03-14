package com.Formy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataproviderOnly 
{
    WebDriver driver;
	
	@BeforeMethod
	public void setup()
	{
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
		driver.manage().window().maximize();
		
	}
	
	@DataProvider(name="input-provider")
	public static Object[][] inputData()
	{
		Object[][] data=new Object[2][3];
		
		data[0][0] = "Joe"; data[0][1]="Joe@gmail.com"; data[0][2]=1;
		data[1][0]= "Jane"; data[1][1]="Jane@gmail.com"; data[1][2]=2;
		
		return data;
	}
	@Test(dataProviderClass=DataproviderOnly.class, dataProvider="input-provider")
	public void testinputFields(String name,String email,int inputnumber)
	{
		System.out.println("Input # "+inputnumber);
		System.out.println("Name: "+name);
		System.out.println("Email: "+email);
		driver.get("https://formy-project.herokuapp.com/form");
		
		driver.get("https://formy-project.herokuapp.com/form");
		driver.findElement(By.id("first-name")).sendKeys(name);
		driver.findElement(By.id("last-name")).sendKeys(email);
	}
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}

}
