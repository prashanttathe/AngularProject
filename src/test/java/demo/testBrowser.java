package demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class testBrowser {
	@Test
	public void testFirefox() {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://google.com");
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Automation step by step");
		List<WebElement> ListofElements = driver.findElements(By.xpath("//input"));
		System.out.println("List of Elements: "+ListofElements.size());
	
		System.out.println("Successfully run the program");
		
//		Thread.sleep(2000);
//		driver.close();
//		driver.quit();
	}

}