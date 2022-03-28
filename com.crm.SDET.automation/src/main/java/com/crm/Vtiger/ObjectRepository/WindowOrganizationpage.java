package com.crm.Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WindowOrganizationpage {
	//Initialization of web elements

		public WindowOrganizationpage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		@FindBy(xpath="//table[@class='small']/tbody/tr[2]/td/a")
		private WebElement existingorganization;
		public WebElement getExistingorganization() 
		{
			return existingorganization;
		}
		public void selectexistingorganization()
		{
			existingorganization.click();
		}
	}


