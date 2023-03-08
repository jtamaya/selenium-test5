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
		WebDriver driver = new ChromeDriver();

		driver.get("https://selenium.dev");

		driver.quit();
	}
}
