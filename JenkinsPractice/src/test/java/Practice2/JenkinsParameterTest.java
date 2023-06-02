package Practice2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JenkinsParameterTest {

	@Test
	public void mathod1() {
		WebDriver driver;

		System.out.println("Before class executing");
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
		System.setProperty("webdriver.msedge.driver", "./driver/msedgedriver.exe");
		
		String Browser = System.getProperty("browser");
		String Url=System.getProperty("url");
		
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
		
		driver.get(Url);
	}
}
