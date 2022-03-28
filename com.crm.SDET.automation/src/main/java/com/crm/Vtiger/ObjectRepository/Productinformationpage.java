package com.crm.Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Productinformationpage {
	//Initialization of web elements

		public Productinformationpage(WebDriver driver) 
		{
			PageFactory.initElements(driver, this);
		}
		@FindBy(className="lvtHeaderText")
		private WebElement actualproductname;
		public WebElement getActualproductname() 
		{
			return actualproductname;
		}
		public WebElement actualproductname() 
		{
			return actualproductname;
		}
	}

