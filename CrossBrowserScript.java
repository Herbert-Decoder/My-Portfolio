package Test_Ng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



import org.testng.annotations.Parameters;


public class CrossBrowserScript {
	WebDriver driver;
	 Logger logger = (Logger) LoggerFactory.getLogger(CrossBrowserScript.class);
	 
	@BeforeTest
	@Parameters("browser")
	
	
	public void TestParameterWithXml(String browser) throws Exception {
		
		//((org.slf4j.Logger) logger).info("Browser selected: {}", browser);

		if(browser.equalsIgnoreCase("firefox")) {
		System.setProperty("webdriver", "C:\\Selenium Webdriver\\geckodriver-v0.36.0-win-aarch64\\geckodriver.exe");

		driver = new FirefoxDriver();
		 //((org.slf4j.Logger) logger).info("Firefox browser launched.");
		
	}
		else if(browser.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Webdriver\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		 //((org.slf4j.Logger) logger).info("Edge browser launched.");
	}
	else if(browser.equalsIgnoreCase("edge")) {
		System.setProperty("webdriver", "C:\\Selenium Webdriver\\edgedriver_win64\\edgedriver.exe");
		driver = new EdgeDriver();
		 //((org.slf4j.Logger) logger).info("Chrome browser launched.");
	}
	else {
		throw new Exception("Browser is not correct");
	}
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		 //((org.slf4j.Logger) logger).info("Implicit wait applied for 90 seconds.");
	}
	
	@Test
	public void TestFreeCrmLogin() throws InterruptedException {
		 //((org.slf4j.Logger) logger).info("Navigating to freecrm.com");
		driver.get("https://www.freecrm.com");
		
		try{
			WebElement userName = driver.findElement(By.id(":R5al5jsl9fja:"));
		
		userName.sendKeys("onyiiherbert@gmail.com");
		Thread.sleep(3000);
		WebElement password = driver.findElement(By.xpath("/html/body/div[1]/main/div[1]/div[2]/div[3]/a[1]"));
		password.click();
		//((org.slf4j.Logger) logger).info("Entered username.");
		}catch (Exception e) {
            //((org.slf4j.Logger) logger).error("An error occurred: {}", e.getMessage());
        }
		//password.sendKeys("brown4real19901");
	
		//Thread.sleep(6000);
		//WebElement Login = driver.findElement(By.name("login"));
		//Login.click();
		//Thread.sleep(6000);
		//WebElement search = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div[2]/div[4]/div/div[1]/div[1]/ul/li[2]/span/div/a/span/svg"));
		//search.click();
		//WebElement search1 = driver.findElement(By.name("search"));
		//search1.sendKeys("devops");
		//Thread.sleep(4000);
		//WebElement searchbtn = driver.findElement(By.xpath("/html/body/div[6]/div/div/div/div[3]/div[2]/div/div[2]/div[2]/a/div/h4"));
		//searchbtn.click();
	}
	
	
	

}
