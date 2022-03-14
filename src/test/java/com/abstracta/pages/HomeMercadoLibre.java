package com.abstracta.pages;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.abstracta.utils.Base;

public class HomeMercadoLibre extends Base{
	
	By searchBox = By.name("as_word");
	By logo = By.xpath("//a [@href=\"//www.mercadolibre.cl\"]");
	By product = By.xpath("//*[@id=\"root-app\"]/div/div/section/ol/li/div/div/div[2]/div[1]/a/h2");
	By titleProduct = By.className("ui-pdp-title");
	By priceProduct = By.className("andes-money-amount__fraction");
	

	public HomeMercadoLibre(WebDriver driver, Properties properties) {
		super(driver, properties);
		// TODO Auto-generated constructor stub
	}
	
	public void searchProduct() {
		if (isDispleyed(logo)) {
			type(properties.getProperty("product"), searchBox);
			enter(searchBox);
		}else {
			System.out.println("page was not found");
		}

		
	}
	
	public void visitProducts() throws InterruptedException {
		navegatorPag(product,1,titleProduct, priceProduct);
//		int countProductVisit = 0;
//		List<WebElement> products = findElements(product);
//		int countProduct = products.size();
//		System.out.println("Cantidad de productos: " + countProduct);
//		int countMaxVisit = 3;
//		int pagVisitadas = 0;
//		
//		for (int i = 0; i <= products.size(); i++) {
//			products.get(i).
//			
//			Thread.sleep(3000);
//			
//			String title = getTextLocator(titleProduct);
//			String price = getTextLocator(priceProduct);
//			String link = getTexLink();
//			
//			System.out.println(title);
//			System.out.println(price);
//			System.out.println(link);
			
// 		Set<String> windows = driver.getWindowHandles(); //[parentid,childid,subchildId]
//
//			Iterator<String>it = windows.iterator();
//
//			String parentId = it.next();
//
//			String childId = it.next();
//
//			driver.switchTo().window(childId);
//
//			driver.switchTo().window(parentId);
			
		}
		
		
//		for (int i = 0; i <= countMaxVisit; i++) {
//			Actions accion = new Actions(driver);
//			String linkClickDerecho = Keys.chord(Keys.CONTROL,Keys.ENTER);
//			String nombreLink = products.get(i).getText();
//			System.out.println(nombreLink);
//			if (pagVisitadas<=countMaxVisit) {
//				driver.findElements(product).get(i).sendKeys(linkClickDerecho);
//				////li[@class='gf-li']/a
//			}
//			
//			//revision de las paginas abiertas
//			Set<String> paginas = driver.getWindowHandles();
//			Iterator<String> it=paginas.iterator();
//			while (it.hasNext()) {
//				//si el siguiente indice esta presente (hashNext)
//				driver.switchTo().window(it.next());
//				System.out.println("Nombres de las paginas desplegadas");
//				System.out.println(driver.getTitle());
//				
//			}
//		}

	
	

}
