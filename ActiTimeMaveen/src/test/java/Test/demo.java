package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class demo 
{
	@Test
	public void testA()
	{
		//WebDriver Manager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.close();
	}
	
}
