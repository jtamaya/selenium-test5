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
import org.openqa.selenium.remote.RemoteWebDriver;

public class AppTest 
{
	@Test
	public void buildTest() throws MalformedURLException {
		System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--no-sandbox");
		options.addArguments("--headless");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--window-size=1920x1080");
		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444"), options);
		driver.navigate().to("https://www.browserstack.com/");
		String verifyBrowserStackTitle = driver.getTitle();
		assertEquals("Most Reliable App & Cross Browser Testing Platform | BrowserStack",verifyBrowserStackTitle);
	}
	
	@Test
	public void buildTestEdge() throws MalformedURLException {
		System.setProperty("webdriver.edge.driver", "src/driver/msedgedriver");
		EdgeOptions options = new EdgeOptions();
		
		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444"), options);
		driver.navigate().to("https://www.browserstack.com/");
		String verifyBrowserStackTitle = driver.getTitle();
		assertEquals("Most Reliable App & Cross Browser Testing Platform | BrowserStack",verifyBrowserStackTitle);
	}
}
