package abstractaProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.mongodb.MapReduceCommand.OutputType;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MercadoLibreTest {
	
	public WebDriver driver;
    public Properties propiedades;
	public WebDriver InitDriver() throws IOException {
		// TODO Auto-generated method stub
		 propiedades = new Properties();
		 String filePath= System.getProperty("user.dir")+"/src/test/java/abstractaProject/data.properties";
		FileInputStream file = new FileInputStream(filePath);
			
		propiedades.load(file);
		String browserName = propiedades.getProperty("browser");
		if (browserName.equalsIgnoreCase("chrome")) {

			//System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
            WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		}
		if (browserName.equalsIgnoreCase("firefox")) {
			//System.setProperty("webdriver.gecko.driver", "C:\\driver\\geckodriver.exe");
           WebDriverManager.firefoxdriver().setup();
			 driver = new FirefoxDriver();

		}
		if (browserName.equalsIgnoreCase("IE")) {

		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();	
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		return driver;
		
	}
	

	
	/*public static void getScreenShotPath(String nameTest,WebDriver driver) {
		// TODO Auto-generated method stub
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File file=screenshot.getScreenshotAs(OutputType.FILE);
		String destinoFile = System.getProperty("user.dir" + "\\report\\" + nameTest+".png");
		
	}*/
	
//	public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException
//	{
//		Calendar calendar = Calendar.getInstance();
//		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyy_hh_mm_ss");
//		//String png= System.currentTimeMillis()+ ".png";
//		TakesScreenshot ts=(TakesScreenshot) driver;
//		File source =ts.getScreenshotAs(OutputType.FILE);
//		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+formater.format(calendar.getTime())+testCaseName+".png";
//		FileUtils.copyFile(source,new File(destinationFile));
//		
//		return destinationFile;
//	}
	
	public static String getDAte() {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yy");
		Date date = new Date();
		return dateFormat.format(date);
	}

}
