package demo;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.GoogleSearchPage;

public class testNGtest {
	 WebDriver driver = null;

	@BeforeTest
	public void setupTest() {

		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	}
	@Test
	public void testFirefox() {
		driver.get("https://google.com");
		GoogleSearchPage.textbox_search(driver).sendKeys("step by step automation");
		GoogleSearchPage.button_search(driver).sendKeys(Keys.RETURN);;

	}	

	@AfterTest
	public void tearDownTest() {

//		driver.close();
		driver.quit();
		System.out.println("Successfully run the program");
	}

}

