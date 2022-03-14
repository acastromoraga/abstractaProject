package abstractaProject;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestMercadoLibre {

	public WebDriver driver;
	public Properties propiedades;
	
	//locators
	By searchBox = By.name("as_word");

	@Before
	public void setUp() throws Exception {
		
		propiedades = new Properties();
		String filePath = System.getProperty("user.dir") + "/src/test/java/abstractaProject/data.properties";
		FileInputStream file = new FileInputStream(filePath);
		propiedades.load(file);

		String browserName = propiedades.getProperty("browser");
		if (browserName.equalsIgnoreCase("chrome")) {

			// System.setProperty("webdriver.chrome.driver",
			// "C:\\driver\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(propiedades.getProperty("url"));

	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void test() {
		if (driver.findElement(searchBox).isDisplayed()) {
			driver.findElement(searchBox).clear();
			driver.findElement(searchBox).sendKeys("camisetas");
			driver.findElement(searchBox).submit();
		}
		

	}

}
