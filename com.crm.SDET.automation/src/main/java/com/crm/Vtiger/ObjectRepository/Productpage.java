package com.crm.Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Productpage {
	//Initialization of web elements

		public Productpage(WebDriver driver) 
		{
			PageFactory.initElements(driver, this);
		}
			@FindBy(name="productname")
			private WebElement newproductname;
			public WebElement getProductname() 
			{
				return newproductname;
			}
			public void createproductname(String productname)
			{
				newproductname.sendKeys(productname);
			}
		@FindBy(name="button")
		private WebElement clickonsave;
		public WebElement getClickonsave() 
		{
			return clickonsave;
		}
		public void clickonsaveBtn()
		{
			clickonsave.click();
		}
		@FindBy(id="search_txt")
		private WebElement product;
		public WebElement getProduct() 
		{
			return product;
		}
		public void enterproductname(String productname)
		{
			product.sendKeys(productname);
		}
		@FindBy(name="search")
		private WebElement clicktheproduct;
		public WebElement getClicktheproduct() 
		{
			return clicktheproduct;
		}
		public void clickonproductname() 
		{
			clicktheproduct.click();
		}
//		@FindBy(xpath="//a[text()='"++"']")
//		public WebElement dynamicproductname;
//		public WebElement getDynamicproductname()
//		{
//			return dynamicproductname;
//		}
//		public void clickondynamicproductname()
//		{
//			dynamicproductname.click();
//		}
		
	}
		
		

