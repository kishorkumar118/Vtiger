package com.crm.Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericutility.WebDriverUtility;




public class Organizationinformationpage {
	//Initialization of web elements

		public Organizationinformationpage(WebDriver driver) 
		{
			PageFactory.initElements(driver, this);
		}
		@FindBy(name="accountname")
		private WebElement Organizationname;

		@FindBy(css="[name='industry']")
		private WebElement industrytype;

		@FindBy(css="[title='Save [Alt+S]']")
		private WebElement saveBtn;

		public WebElement getOrganizationname() {
			return Organizationname;
		}

		public WebElement getIndustrytype() {
			return industrytype;
		}

		public WebElement getSaveBtn() {
			return saveBtn;
		}
		
		public void neworganizationname(String orgname)
		{
		Organizationname.sendKeys(orgname);
		}
		WebDriverUtility wlib = new WebDriverUtility();
		public void selectindustrytype(String industryname) 
		{
			industrytype.click();
			WebElement list = industrytype;
			wlib.select(list,industryname);
		}
		public void clickonsavebutton(){
			{
				saveBtn.click();
			}
			
			
		}
		
}
