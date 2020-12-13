package demo;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.GoogleSearchPage;
public class test1_GoogleSearch {
	private static WebDriver driver = null;
	@BeforeGroups
	public void setupTest() {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
	}
		@Test
		public void googlesearch() {

			driver.get("https://google.com/");
			
//			driver.findElement(By.name("q")).sendKeys("Automation step by step");
//			driver.findElement(By.name("btnk")).click();
			
			GoogleSearchPage.textbox_search(driver).sendKeys("Step by step automation");
			GoogleSearchPage.button_search(driver).sendKeys(Keys.RETURN);
			
			 
			
		}

		@AfterTest
		public void tearDown() {

			driver.close();
			driver.quit();
			System.out.println("Successfully run the program");
		}

	}
