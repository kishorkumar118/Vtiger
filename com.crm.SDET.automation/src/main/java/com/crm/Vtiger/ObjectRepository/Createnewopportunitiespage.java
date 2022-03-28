package com.crm.Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Createnewopportunitiespage {
	public Createnewopportunitiespage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement newopportunitiesimg;
	public WebElement getNewopportunitiesimg() {
		return newopportunitiesimg;
	}
	public void clickonopportunitiesimg() 
	{
		newopportunitiesimg.click();
	}
	

}


