package abstractaProject;

import java.util.Set;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;

public class prueba {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/home/tsoft/Descargas/chromedriver_linux/chromedriver");
		WebDriver driver = new ChromeDriver();
		

		driver.manage().window().maximize();
		driver.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");
		Thread.sleep(3000);
		Actions action = new Actions(driver);
		
		//clic a T�rminos
		driver.findElement(By.xpath(".//a[@href='https://rahulshettyacademy.com/#/documents-request']")).click();
		Thread.sleep(3000);
		String titulo1 = driver.getTitle();
		System.out.println("Antes de cambiar: " + titulo1);
		
		Set<String> ids = driver.getWindowHandles();
		Iterator<String> iterador = ids.iterator();
		
		String parentId = iterador.next();
		System.out.println("padre: " + parentId);
		String ChildId = iterador.next();
		System.out.println("hija: " + ChildId);
		
		driver.switchTo().window(ChildId);
		String nombrePag = driver.getTitle();
		System.out.println("Nombre Pag despu�s de cambiar: " + nombrePag);
		
		driver.switchTo().window(parentId);
		System.out.println("Ventana padre nuevamente: " + driver.getTitle());

	}

}
