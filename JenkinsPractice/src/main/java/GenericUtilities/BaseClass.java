package GenericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public WebDriver driver;
	
	@BeforeClass
	public void config_BC() {
		WebDriverManager.chromiumdriver().setup();
		driver=new ChromeDriver();
		
	}
	
	@BeforeMethod
	public void config_BM() {
		driver.get("http://rmgtestingserver/domain/Online_Banking_System/");
	}
}
