package com.crm.Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericutility.WebDriverUtility;



public class Opportunitiespage {
	//Initialization of web elements

		public Opportunitiespage(WebDriver driver) 
		{
			PageFactory.initElements(driver, this);
		}
		@FindBy(name="potentialname")
		private WebElement newopportunityname;
		public WebElement getNewopportunityname() {
			return newopportunityname;
		}
		public void craeteopportunityname (String opportunityname)
		{
			newopportunityname.sendKeys(opportunityname);
		}
		@FindBy(xpath="//select[@id='related_to_type']")
		private WebElement selectthetype;
		public WebElement getSelectthetype() {
			return selectthetype;
		}
		public void selectfromdropbox(String Contacts) 
		{
			WebDriverUtility wlib = new WebDriverUtility ();
			selectthetype.click();
			WebElement select = selectthetype;
			wlib.select(select,Contacts);
		}
		@FindBy(xpath="//input[@id='related_to_display']/following-sibling::img")
		private WebElement clickthecontactimg;
		public WebElement getClickthecontactimg() {
			return clickthecontactimg;
		}
		public void clickoncontactimg()
		{
			clickthecontactimg.click();
		}
		@FindBy(xpath="//input[@id='related_to_display']/following-sibling::img")
		private WebElement clicktheorganizationimg;
		public WebElement getClicktheorganizationimg() {
			return clicktheorganizationimg;
		}
		public void clickonorganizationimg()
		{
			clickthecontactimg.click();
		}
		@FindBy(xpath="//tbody/tr[4]/td[@class='dvtCellInfo']/input[@title='Clear']")
		private WebElement Erasebutton;
		public WebElement getErasebutton() {
			return Erasebutton;
		}
		public void clickonErasebtn()
		{
			Erasebutton.click();
		}
		
		
	}

