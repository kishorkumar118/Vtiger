package com.crm.Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Campaignspage {
	//Initialization of web elements
    public Campaignspage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
    
    //Declaration of Web elements
	@FindBy(name="campaignname")
	private WebElement newcampaigname;
	
	@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
	private WebElement clickonproductimg;
	
	//getters method is used in testscript
	public WebElement getNewcampaigname() 
	{
		return newcampaigname;
	}
	
	public WebElement getClickonproductimg() {
		return clickonproductimg;
	}
	
	//business logic
	/**
	 * this method used to create campaignname
	 * @param campaignname
	 */
	public void createcampaignname(String campaignname)
	{
		newcampaigname.sendKeys(campaignname);
	}
	/**
	 * this method used to select the productname from campaignpage
	 */
	public void selectproductname() 
	{
		clickonproductimg.click();
	}
}
