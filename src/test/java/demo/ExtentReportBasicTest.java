package demo;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.GoogleSearchPage;

public class ExtentReportBasicTest {

	static WebDriver driver = null;
	public static void main(String[] args) {
		
		ExtentSparkReporter htmlReporter = new ExtentSparkReporter("Extent.html");
		
//		initialize ExtentReports and attach the HtmlReporter
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		ExtentTest test1 = extent.createTest("Google test one", "Test google search functionality");
		
		test1.log(Status.INFO, "Starting the test");
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		
		driver.get("https://google.com");
		test1.pass("Navigated to google");
		
		GoogleSearchPage.textbox_search(driver).sendKeys("step by step automation");
		test1.pass("Entered text in search box");
		
		GoogleSearchPage.button_search(driver).sendKeys(Keys.RETURN);;
		test1.pass("Entered key pressed");
		
		driver.quit();
		test1.pass("Browser closed");
		
		ExtentTest test2 = extent.createTest("Google test two", "Test google search functionality");
		
		test2.log(Status.INFO, "Starting the test");
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		
		driver.get("https://google.com");
		test2.pass("Navigated to google");
		
		GoogleSearchPage.textbox_search(driver).sendKeys("step by step automation");
		test2.fail("Entered text in search box");
		
		GoogleSearchPage.button_search(driver).sendKeys(Keys.RETURN);;
		test2.pass("Entered key pressed");
		
		driver.quit();
		test1.pass("Browser closed");

		// calling flush writes everything to the log file
        extent.flush();
		
		
		

	}
}
