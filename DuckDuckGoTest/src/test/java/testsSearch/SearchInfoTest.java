package testsSearch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchInfoTest {
	
	private WebDriver driver;
	private String txt;
	
	@BeforeMethod
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.navigate().to("https://duckduckgo.com/");
		driver.manage().window().maximize();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
		driver.quit();
	}
	
	@Test(description="CP_0001")
	public void searchInfo() {
		
		driver.findElement(By.id("search_form_input_homepage")).sendKeys("Argentesting");
		driver.findElement(By.id("search_button_homepage")).click();
		driver.findElement(By.className("result__a")).click();
		
		txt = driver.findElement(By.className("section-heading-title")).getText();
		
		Assert.assertTrue(txt.contains("Congreso Argentino de Testing"), "La página a la que ingresó no es la correcta. Se esperaba el texto: " + txt);
				
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
