package mavenTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserTest {
	WebDriver driver;
	@BeforeTest
	@Parameters ("browser")
	public void TestParametersWithXml(String browser) throws Exception {
		if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("Webdriver.gecko.driver", "C:\\Selenium Webdriver\\firefox\\geckodriver.exe");
			driver = new FirefoxDriver();
		} 
	else 
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("Webdriver.chrome.driver", "C:\\Selenium Webdriver\\chrome\\chromedriver.exe");
			driver = new ChromeDriver();
		}
	else
		if (browser.equalsIgnoreCase("edge")) {
			System.setProperty("Webdriver", "C:\\Selenium Webdriver\\edgedriver_win64\\edgedriver.exe");
			driver = new EdgeDriver();
		}
		else {
			throw new Exception ("Browser is not correct");
		}
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
	
	}
	
	@Test
	public void TestFreeCrmLogin() throws InterruptedException {
		driver.get("https://www.freecrm.com");
		
		WebElement Username = driver.findElement(By.id(":R5al5jsl9fja:"));
		Username.sendKeys("onyiiherbert@gmail.com");
		Thread.sleep(3000);
		WebElement Password = driver.findElement(By.xpath("/html/body/div[1]/main/div[1]/div[2]/div[3]/button[1]"));
		Password.click();
			
	}
}
