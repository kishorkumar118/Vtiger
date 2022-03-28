package com.crm.autodesk.genericutility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import com.crm.Vtiger.ObjectRepository.Homepage;
import com.crm.Vtiger.ObjectRepository.Loginpage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass 
{
	public static WebDriver sdriver;
	public WebDriver driver = null;
	public FileUtility Flib= new FileUtility();
    public WebDriverUtility Wlib = new WebDriverUtility();
	
	@BeforeSuite
	public void beforesuite()
	{
		System.out.println("this is beforesuite");
	}
	
	@BeforeTest
	public void beforetest()
	{
		System.out.println("this is beforetest");
	}
	//@Parameters("browser")
	@BeforeClass
	public void beforeclass() throws Throwable
	//public void beforeclass(String browsername) throws Throwable
	{
		String browser = Flib.getPropertyKeyValue("browser");
		String url = Flib.getPropertyKeyValue("url");
		if(browser.equals("chrome"))
		{
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}
		else
		{
			throw new Exception("browser is not compatible");
		}
		driver.get(url);
		Wlib.maximizeWindow(driver);
		Wlib.waitforPageToLoad(driver);
		sdriver=driver;
	}
	 
	@BeforeMethod
	public void beforemethod() throws Throwable
	{
	String username	= Flib.getPropertyKeyValue("username");
    String password	= Flib.getPropertyKeyValue("password");
    Loginpage loginpage = new Loginpage(driver);
    loginpage.login(username, password);
    }
	
	@AfterMethod
	public void aftermethod()
	{
		Homepage homepage = new Homepage(driver);
		homepage.logout(driver);
	}
	
	@AfterClass
	public void afterclass()
	{
		driver.quit();
	}
	
	@AfterTest
	public void aftertest()
	{
		System.out.println("close parallel mode execution");
	}
	
	@AfterSuite
	public void aftersuite()
	{
		System.out.println("close database connection");
	}
}
