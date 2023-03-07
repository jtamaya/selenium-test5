package selenium_test2.new_selenium_test;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AppTest 
{
	@Test
	public void buildTest() {
		System.setProperty("webdriver.chrome.driver", "**\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.browserstack.com/");
		String verifyBrowserStackTitle = driver.getTitle();
		assertEquals("Most Reliable App & Cross Browser Testing Platform | BrowserStack",verifyBrowserStackTitle);
	}
}
