package com.abstracta.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.abstracta.utils.Base;

public class ProductPage extends Base{

	public ProductPage(WebDriver driver, Properties properties) {
		super(driver, properties);
		// TODO Auto-generated constructor stub
	}
	
	By titleProduct = By.className("ui-pdp-title");
	By priceProduct = By.className("andes-money-amount__fraction");
	

}
