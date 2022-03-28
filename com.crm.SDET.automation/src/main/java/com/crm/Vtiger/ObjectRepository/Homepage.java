package com.crm.Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericutility.WebDriverUtility;



public class Homepage extends WebDriverUtility
{
	// initialization of Web element
	public Homepage(WebDriver driver)
	{
	PageFactory.initElements(driver, this);
	}

	//declaration of web element
	@FindBy(linkText = "Organizations")
	private WebElement organizationLink;

	@FindBy(linkText="Contacts")
	private WebElement contactslink;

	@FindBy(linkText = "Products")
	private WebElement productsLink;


	@FindBy(css = "[src='themes/softed/images/user.PNG']")
	private WebElement signOutIconImage;

	@FindBy(linkText="Sign Out")
	private WebElement signOutLink;

	public WebElement getOrganizationLink() {
		return organizationLink;
	}
	public WebElement getSignOutIconImage() {
		return signOutIconImage;
	}
	public WebElement getSignOutLink() {
		return signOutLink;
	}
	//business logic
	/**
	 * This method will click on organization link
	 */
	public void clickonOrganizationlink() 
	{
		organizationLink.click();	
	}
	public WebElement getProductsLink() {
		return productsLink;
	}
	public void clickonproductslink()
	{
		productsLink.click();
	}
	@FindBy(name="button")
	private WebElement clickonsave;
	public WebElement getClickonsave() 
	{
		return clickonsave;
	}
	public void clickonsaveBtn()
	{
		clickonsave.click();
	}

	@FindBy(linkText="More")
	private WebElement clickonMore;
	public WebElement getClickonMore() 
	{
		return clickonMore;
	}
	public void clickonmorelink()
	{
		clickonMore.click();
	}

	@FindBy(name="Campaigns")
	private WebElement campaignslink;
	public WebElement getCampaignslink() 
	{
		return campaignslink;
	}
	public void clickoncampaignslink()
	{
		campaignslink.click();
	}

	public WebElement getContactslink() {
		return contactslink;
	}
	public void clickoncontactslink() {
		contactslink.click();
	}
	@FindBy(linkText="Opportunities")
	private WebElement opportunitieslink;
	public WebElement getOpportunitieslink() {
		return opportunitieslink;
	}


	public void clickonopportunitieslink()
	{
		opportunitieslink.click();
	}

	WebDriverUtility Wlib= new WebDriverUtility();
	public void logout(WebDriver driver)
	{
	 Wlib.mouseoveronElement(driver,signOutIconImage);
	 signOutLink.click();
	}

		
	}

