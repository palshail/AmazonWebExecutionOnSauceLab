package Script;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;



public class BaseClass {

	
	public WebDriver driver;
	
	public static final String USERNAME = "pal_shail88";
	public static final String ACCESS_KEY = "f9a86fb4dd6b4ad4aa33b34ff05c3724";
	public static final String url = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.us-west-1.saucelabs.com:443/wd/hub";
			
			
	@Test
	public void setup() throws InterruptedException
	{
		try {

			DesiredCapabilities caps = DesiredCapabilities.chrome();
			caps.setCapability("platform", "Windows 10");
			caps.setCapability("version", "87.0");
			driver = new RemoteWebDriver(new java.net.URL(url),caps);
			System.out.println("Application is Launched");
			driver.get("https://www.amazon.in/");
			driver.manage().window().maximize();
			driver.findElement(By.xpath("//*[@id='nav-hamburger-menu']/i")).click();
			WebDriverWait wait = new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='hmenu-customer-name']"))).click();
			driver.findElement(By.id("ap_email")).sendKeys("amazonID");
			driver.findElement(By.id("continue")).click();
			driver.findElement(By.id("ap_password")).sendKeys("amazonpassword");
			driver.findElement(By.id("signInSubmit")).click();
			System.out.println(driver.getTitle());
			String webpageurl = driver.getCurrentUrl().toString();
			System.out.println(webpageurl);
			System.out.println("Login successful");
			
		}catch(Exception ex)
		{
			System.out.println(ex.getMessage());
			System.out.println(ex.getCause());
			ex.printStackTrace();
		}
	}
}
