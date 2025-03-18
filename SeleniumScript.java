package edureka;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumScript {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Webdriver\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");
		/*WebDriver driver = new ChromeDriver();
		driver.get("https://www.ebay.com");
		System.out.println(driver.getTitle());
		driver.quit();

	}

}*/
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote--allow--origins*");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https:\\www.freecrm.com");
		Thread.sleep(3000);
		
		driver.findElement(By.name("email")).sendKeys("onyiiherbert@gmail.com");
		driver.findElement(By.name("password")).sendKeys("brown4real19901");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div/form/div/div[3]")).click();

		//driver.findElement(By.name("_nkw")).sendKeys("mobiles");
		//driver.findElement(By.xpath("/html/body/div[1]/header/div/nav/div[2]/div/div[2]/ul/li[1]/a")).click();//sendKeys("sign up");
		//driver.findElement(By.cssSelector("#gh-btn")).click();
		
		

	}

}
