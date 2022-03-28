package com.crm.Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Campaignsinformationpage {
	//Initialization of web elements
    public Campaignsinformationpage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
    
    //Declaration of Web element
	@FindBy(className="dvHeaderText")
	private WebElement actualcampaignname;
	
	//getters method is used in testscript
	public WebElement getActualcampaignname() 
	{
		return actualcampaignname;
	}
	
	//business logic
	/**
	 * this method returns the actualcampaignname
	 * @return
	 */
	public WebElement actualcampaignname() 
	{
		return actualcampaignname;
	}
	

}
