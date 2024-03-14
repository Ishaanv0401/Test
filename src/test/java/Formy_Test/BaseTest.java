package Formy_Test;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.Formy.pages.BasePage;
import com.Formy.pages.HomePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest 
{
	private WebDriver driver;
	protected BasePage basepage;
	protected HomePage homepage;
	private final String AUT_Url="https://formy-project.herokuapp.com/";
	
	@BeforeClass
	public void setup()
	{
		WebDriverManager.edgedriver().setup();
		driver =new EdgeDriver();
		driver.manage().window().maximize();
	}
	@ AfterClass
	public void teardown()
	{
		driver.quit();
	}
	
	@BeforeMethod
	public void loadaApplication()
	{
		driver.get(AUT_Url);
		basepage = new BasePage();
		basepage.setWebDriver(driver);
		homepage=new HomePage();
		
	}
	@AfterMethod
	public void takescreenshotforfailure(ITestResult testResult)
	{
		if(ITestResult.FAILURE==testResult.getStatus())
		{
		TakesScreenshot screenshot=(TakesScreenshot) driver;
		File source=screenshot.getScreenshotAs(OutputType.FILE);
		File destination = new File(System.getProperty
		("user.dir")+"/Resources/Screenshots/"+testResult.getName()+".png");
		try {
			FileHandler.copy(source, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
}
