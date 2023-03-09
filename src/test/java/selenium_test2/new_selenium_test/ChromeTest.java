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

public class ChromeTest 
{
	public WebDriver driver;
	public ChromeOptions chromeOptions;
	
	@BeforeTest
	public void buildTestChrome() throws MalformedURLException {
		System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver");
		chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--no-sandbox");
		chromeOptions.addArguments("--headless");
		chromeOptions.addArguments("--disable-dev-shm-usage");
		chromeOptions.addArguments("--window-size=1920x1080");
		System.out.println("Starting Chrome");
		driver = new RemoteWebDriver(new URL("http://localhost:4444"), chromeOptions);
	}
	
	@Test
	public void testCase() {
		driver.navigate().to("https://www.browserstack.com/");
		String verifyBrowserStackTitle = driver.getTitle();
		assertEquals("Most Reliable App & Cross Browser Testing Platform | BrowserStack",verifyBrowserStackTitle);
		System.out.println(verifyBrowserStackTitle);
	}
	
	@AfterTest
	public void terminate() {
		driver.close();
		System.out.println("Closing Chrome");
	}
	
	
}
