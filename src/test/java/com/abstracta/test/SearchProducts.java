package com.abstracta.test;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.validator.PublicClassValidator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.abstracta.pages.HomeMercadoLibre;
import com.abstracta.pages.ProductPage;

public class SearchProducts {
	
	public WebDriver driver;
	public Properties properties;
	
	HomeMercadoLibre homeMercadoLibre;
	ProductPage productPage;

	@Before
	public void setUp() throws Exception {
		homeMercadoLibre = new HomeMercadoLibre(driver, properties);
		productPage = new ProductPage(driver, properties);
		driver = homeMercadoLibre.driverConnections();
		homeMercadoLibre.visitUrl();
	
	}

	@After
	public void tearDown() throws Exception {
		//driver.quit();
	}

	@Test
	public void test() throws InterruptedException {
		homeMercadoLibre.searchProduct();
		homeMercadoLibre.visitProducts();
		
	
	}

}
