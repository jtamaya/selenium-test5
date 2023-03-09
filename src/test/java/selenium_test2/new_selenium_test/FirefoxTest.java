package selenium_test2.new_selenium_test;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

public class FirefoxTest 
{
	WebDriver driver;
	FirefoxOptions firefoxOptions;
	
	
	@Test
	public void buildTestFireFox() throws MalformedURLException {
		System.setProperty("webdriver.firefox.driver", "src/drivers/FirefoxDriver/geckodriver-v0.32.2-linux64.tar.gz");
		firefoxOptions = new FirefoxOptions();
		driver = new RemoteWebDriver(new URL("http://localhost:4444"), firefoxOptions);
		testCase(driver);
	}
	
	public void testCase(WebDriver driver) {
		driver.navigate().to("https://www.browserstack.com/");
		String verifyBrowserStackTitle = driver.getTitle();
		assertEquals("Most Reliable App & Cross Browser Testing Platform | BrowserStack",verifyBrowserStackTitle);
		System.out.println(verifyBrowserStackTitle);
	}
	
	@AfterTest
	public void terminate() {
		driver.close();
		System.out.println("Closing Firefox");
	}
	
	
}