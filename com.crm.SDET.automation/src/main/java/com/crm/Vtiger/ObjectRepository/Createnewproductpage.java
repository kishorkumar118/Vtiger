package com.crm.Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Createnewproductpage {
	//Initialization of web elements

		public Createnewproductpage(WebDriver driver) 
		{
			PageFactory.initElements(driver, this);
		}
		@FindBy(xpath="//img[@title='Create Product...']")
		private WebElement createproductimg;
		public WebElement getCreateproductimg() 
		{
			return createproductimg;
		}
		
		public void clickonproductimg()
		{
			createproductimg.click();
		}

	}

