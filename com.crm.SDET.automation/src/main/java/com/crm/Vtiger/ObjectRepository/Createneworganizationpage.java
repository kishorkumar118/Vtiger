package com.crm.Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Createneworganizationpage {
	//Initialization of web elements

	public Createneworganizationpage(WebDriver driver) 
	{
			PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement createOrganizationImg;

	public WebElement getCreateOrganizationImg() {
		return createOrganizationImg;
	}
	public void clickoncreateimage()
	{
		createOrganizationImg.click();
	}
	}


