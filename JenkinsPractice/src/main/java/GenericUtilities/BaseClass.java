package GenericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public WebDriver driver;
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	
	@BeforeSuite
	public void config_BS() throws InterruptedException {
		System.out.println("before suite");
		Thread.sleep(3000);
	}
	@BeforeClass
	public void config_BC() {
		
		//WebDriverManager.chromiumdriver().create();
		System.out.println("Befor class");
		driver=new ChromeDriver();
		
	}
	
	@BeforeMethod
	public void config_BM() {
		driver.get("http://rmgtestingserver/domain/Online_Banking_System/");
	}
}
