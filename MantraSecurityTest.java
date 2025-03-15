package MantraTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.zaproxy.clientapi.core.ApiResponse;
import org.zaproxy.clientapi.core.ClientApi;
import org.zaproxy.clientapi.core.ClientApiException;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MantraSecurityTest {
	static String ZAP_ADDRESS = "localhost";
	static final int ZAP_PORT = 8081;
	static String ZAP_API = "3d333oi6m6lc48go6cub432spk";
	
	private WebDriver driver;
	private ClientApi api;

	@BeforeMethod
	 public void setUp() {
		Proxy proxy = new Proxy ();
		String ProxyServerUrl = (ZAP_ADDRESS + ":" + ZAP_PORT);
		proxy.setHttpProxy(ProxyServerUrl);
		proxy.setSslProxy(ProxyServerUrl);
		
		ChromeOptions co = new ChromeOptions();
		co.setProxy(proxy);
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver(co);
		api = new ClientApi(ZAP_ADDRESS, ZAP_PORT, ZAP_API);
	 }
	
	@SuppressWarnings("deprecation")
	
	@Test(priority=1)
	public void myntraSecurityTest() throws InterruptedException {
		/*driver.get("https://www.amazon.com");
		String title = driver.getTitle();
		System.out.println("The title of this website is:" + title);
		Assert.assertEquals(title, "A product's introduction to the customer.");
	//Assert.assertTrue(driver.getTitle().contains("spend less. Smile more"));*/
		System.getProperty("webdriver.chrome.driver", "C:\\Users\\USER\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.freecrm.com");
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[1]/header/div/nav/div[2]/div/div[2]/ul/li[1]/a")).click();
		Thread.sleep(4000);
		driver.findElement(By.name("email")).sendKeys("onyiiherbert@gmail.com");
		driver.findElement(By.name("password")).sendKeys("brown4real19901");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div/form/div/div[3]")).click();
		
		
	}
	
	/*@Test//(priority=2)
	public void camblyTest() throws InterruptedException {
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.cambly.com");
		Thread.sleep(6000);
		driver.findElement(By.xpath("/html/body/nav/div[2]/div[2]/button[1]/div/div")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("onyiiherbert@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("brown4real19901");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"login-page-button\"]/span[1]")).click();
	}*/
	
	@AfterMethod
	public void tearDown() {
		if(api != null) {
		String template = "traditional-html";
		String title = "Sign up";
		String description = "This is Freecrm sign up test";
		String targetFolder = System.getProperty("user.dir");
		String reportfilename = "myntra.html";
		
		try {
			ApiResponse response = api.reports.generate(title, template, null, description, null, null,
					null, null, null, reportfilename, null, targetFolder, null);
			//System.out.println("The title of this website is:" + response.toString());
		} catch (ClientApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
	
	
	
	
}
 