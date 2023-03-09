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
import org.testng.annotations.BeforeTest;

public class AppTest 
{
	WebDriver driver;
	ChromeOptions chromeOptions;
	EdgeOptions edgeOptions;
	FirefoxOptions firefoxOptions;
	
	@BeforeTest
	public void buildOptions() {
		chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--no-sandbox");
		chromeOptions.addArguments("--headless");
		chromeOptions.addArguments("--disable-dev-shm-usage");
		chromeOptions.addArguments("--window-size=1920x1080");
		
		edgeOptions = new EdgeOptions();
		
		firefoxOptions = new FirefoxOptions();
	}
	
	@Test
	public void buildTestChrome() throws MalformedURLException {
		System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver");
		driver = new RemoteWebDriver(new URL("http://localhost:4444"), chromeOptions);
		testCase(driver);
		
	}
	
	@Test
	public void buildTestEdge() throws MalformedURLException {
		System.setProperty("webdriver.edge.driver", "src/drivers/msedgedriver");
		driver = new RemoteWebDriver(new URL("http://localhost:4444"), edgeOptions);
		testCase(driver);
	}
	
	@Test
	public void buildTestFireFox() throws MalformedURLException {
		System.setProperty("webdriver.firefox.driver", "src/drivers/FirefoxDriver/geckodriver-v0.32.2-linux64.tar.gz");
		driver = new RemoteWebDriver(new URL("http://localhost:4444"), firefoxOptions);
		testCase(driver);
	}
	
	public void testCase(WebDriver driver) {
		driver.navigate().to("https://www.browserstack.com/");
		String verifyBrowserStackTitle = driver.getTitle();
		assertEquals("Most Reliable App & Cross Browser Testing Platform | BrowserStack",verifyBrowserStackTitle);
		System.out.println(verifyBrowserStackTitle);
	}
	
	
}
