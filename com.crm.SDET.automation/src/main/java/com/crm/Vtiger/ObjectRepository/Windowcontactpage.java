package com.crm.Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Windowcontactpage {
	//Initialization of web elements

		public Windowcontactpage(WebDriver driver) 
		{
			PageFactory.initElements(driver, this);
		}
		    @FindBy(xpath="//table[@class='small']/tbody/tr[2]/td/a")
			private WebElement existingcontact;
			public WebElement getExistingcontact() 
			{
				return existingcontact;
			}
			public void selectexistingcontact()
			{
				existingcontact.click();
			}
		}


