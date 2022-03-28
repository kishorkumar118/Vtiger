package com.crm.Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contactinformationpage {
	//Initialization of web elements
    public Contactinformationpage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
    
    //Declaration of web elements
	@FindBy(className="dvHeaderText")
	private WebElement actualcontactname;
	
	//getters method are used in testscript
	public WebElement getActualcontactname() 
	{
		return actualcontactname;
	}
	
	//business logic
	/**
	 * this used to get actual contactname
	 * @return
	 */
	public WebElement actualcontactname() 
	{
		return actualcontactname;
	}
	}




