package GenericUtilities;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClass {
	
	
	//creating objects for utility class
	public FileUtilities Fut=new FileUtilities();
	public ExcelUtilities Eut=new ExcelUtilities();
	public WebDriverUtility1 Wut=new WebDriverUtility1();
	public JavaUtility Jut=new JavaUtility();
	
	public  static WebDriver driver;
	
	
	//giving connection to DB
	@BeforeSuite
	public void confid_BS() throws Throwable {
		Thread.sleep(5000);
		System.out.println("-connection to database-");
	}
	
	
	//closing the connection
	@AfterSuite 
	public void confid_AS() {
		System.out.println("-close connection to database-");
	}
	
	
	//launch the browser
	//@Parameters("Browser")
	@BeforeClass 
	public void config_BC() throws Throwable {
		
		System.out.println("Before class executing");
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
		
		String Browser = Fut.getPropertyKeyValue("browser");
		
		if(Browser.equalsIgnoreCase("chrome")) {
			
			driver=new ChromeDriver();
		}
		else if(Browser.equalsIgnoreCase("firefox")) {
			//WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(Browser.equalsIgnoreCase("edge")) {
			//WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else {
			driver=new ChromeDriver();
		}
		
		//maximizing the browser
		Wut.maximizeWindow(driver);
		
		//giving implicit wait
		Wut.waitTillPageGetsLoad(driver);
		
	}
	
	
	//close the browser
	@AfterClass 
	public void confid_AC() {
		
		driver.close();
		System.out.println("After class executed");
	}
	
	
	//login to the application
	@BeforeMethod 
	public void config_BM() throws Throwable {
		
		System.out.println("Before method executing");
		String Url = Fut.getPropertyKeyValue("url");
		driver.get(Url);
		
	}
	
	
	//logout to the application
	@AfterMethod 
	public void confid_AM() {
		System.out.println("After method executed");
	}
	
}













