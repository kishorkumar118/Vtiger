package com.crm.Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Createnewcampaignspage 
{
	public Createnewcampaignspage (WebDriver driver)
	{
	 PageFactory.initElements(driver, this);
    }
	@FindBy(xpath="//img[@title='Create Campaign...']")
	private WebElement createcampaignpage;
	public WebElement getCreatecampaignpage() 
	{
		return createcampaignpage;
	}
	public void clickoncampaignpage()
	{
		createcampaignpage.click();
	}
}
