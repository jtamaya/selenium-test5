package selenium_test2.new_selenium_test;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AppTest 
{
	@Test
	public void buildTest() {
		System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--no-sandbox");
		options.addArguments("--headless");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--window-size=1920x1080");
		WebDriver driver = new ChromeDriver(options);
		driver.navigate().to("https://www.browserstack.com/");
		String verifyBrowserStackTitle = driver.getTitle();
	}
}
