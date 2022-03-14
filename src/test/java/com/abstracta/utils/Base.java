package com.abstracta.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public WebDriver driver;
	public Properties properties;

	public Base(WebDriver driver, Properties properties) {

		this.driver = driver;
		this.properties = properties;

	}
	
	public WebDriver driverConnections() throws IOException {
		properties = new Properties();
		String filePath = System.getProperty("user.dir") + "/src/test/java/abstractaProject/data.properties";
		FileInputStream file = new FileInputStream(filePath);
		properties.load(file);

		String browserName = properties.getProperty("browser");
		if (browserName.equalsIgnoreCase("chrome")) {

			// System.setProperty("webdriver.chrome.driver",
			// "C:\\driver\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		}
		return driver;

	}

	
	public WebElement findElement(By locator) {
		return driver.findElement(locator);
	}
	
	public List<WebElement> findElements(By locator){
		return driver.findElements(locator);
	}
	
	public String getText(WebElement elementTex) {
		return elementTex.getText();
	}
	
	public String getTextLocator(By locator) {
		return driver.findElement(locator).getText();
	}
	
	public String getTexLink() {
		return driver.getCurrentUrl();
	}
	
	public void type (String inputText, By locator) {
		driver.findElement(locator).sendKeys(inputText);
	}
	
	public void clickElemento (WebElement webElement) {
		driver.findElement((By) webElement).click();
	}
	
	public void clickElemt(By locator) {
		driver.findElement(locator).click();
	}
	
	public Boolean isDispleyed(By locator) {
		try {
			
			return driver.findElement(locator).isDisplayed();
			
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}
	
	public void visitUrl() {
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(properties.getProperty("url"));
	}
	
	public void enter(By locator) {
		driver.findElement(locator).submit();
	}
	
	public void navegatorPag(By locator, int countPag, By titleProduct, By priceProduct ) throws InterruptedException {
		List<WebElement> linksPag = findElements(locator);
		int countLinkPag = linksPag.size();
		System.out.println("Cantidad de productos: " + countLinkPag);
		for (int i = 0; i <= countPag; i++) {
			linksPag.get(i).click();			
			
			
     		Set<String> windows = driver.getWindowHandles(); //[parentid,childid,subchildId]

     		Iterator<String> it = windows.iterator();

			String parentId = it.next();
			System.out.println("padre: "+ parentId);

			String childId = it.next();
			System.out.println("hija: " + childId);

		    driver.switchTo().window(childId);

			
			String title = getTextLocator(titleProduct);
			String price = getTextLocator(priceProduct);
			String link = getTexLink();
			
			System.out.println(title);
			System.out.println(price);
			System.out.println(link);
			
			Thread.sleep(3000);

			driver.switchTo().window(parentId);
			
		}
		
	}
	
}
