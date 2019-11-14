package cBrowser;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CB 
{

WebDriver driver;


	@BeforeTest
	@Parameters("browser")
	
	public void setup(String browser) throws Exception
	{
		//check if paramtere passed is firefox
		
		if(browser.equalsIgnoreCase("firefox"))
		{
			//create firefox instance
			System.setProperty("webdriver.gecko.driver", "D:\\Sanjay\\Selenium_Training\\CrossBrowser\\Driver\\geckodriver.exe");
			driver= new FirefoxDriver();
		}
		
		//check if paramter passed is chrome
		
		else if(browser.equalsIgnoreCase("chrome"))
		{
			//create chrome instance
			System.setProperty("webdriver.chrome.driver", "D:\\Sanjay\\Selenium_Training\\CrossBrowser\\Driver\\chromedriver.exe");
			driver= new ChromeDriver();
		}
		
		//check if paramter passed is edge
		
		else if (browser.equalsIgnoreCase("IE"))
		{
			//create edge instance
			System.setProperty("webdriver.ie.driver", "D:\\Sanjay\\Selenium_Training\\CrossBrowser\\Driver\\IEDriverServer.exe");
			driver= new InternetExplorerDriver();
		}
		
		else
		{
			//if no browser passed
			throw new Exception("Browser not found");
			
		}
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@Test
	public void login() 
	{
		driver.get("http://demo.guru99.com/V4/");
		driver.findElement(By.name("uid")).sendKeys("guru99");
		driver.findElement(By.name("password")).sendKeys("guru99");
				
	}
	
	@AfterTest
	public void closeBrwoser()
	{
		driver.quit();
	}
}




	




