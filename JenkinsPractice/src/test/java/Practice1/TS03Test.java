package Practice1;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class TS03Test {

	@Test(invocationCount = 2)
	public void tc03() {
		Reporter.log("test case 03", true);
	}
	
	@Test(priority = -1)
	public void tc04() {
		System.out.println("test case 04");
	}
	
	@Test(priority = -2)
	public void tc05() {
		System.out.println("tc05");
	}
}
