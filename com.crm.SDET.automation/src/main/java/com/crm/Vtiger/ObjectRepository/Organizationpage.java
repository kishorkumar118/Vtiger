package com.crm.Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericutility.WebDriverUtility;


public class Organizationpage {

	//Initialization of web elements

public Organizationpage(WebDriver driver)
{
	PageFactory.initElements(driver,this);
}
@FindBy(className="dvHeaderText")
private WebElement Actualorganizationname;

public WebElement getActualorganizationname() 
{
	return Actualorganizationname;
}

public WebElement actualorganizationname()
{
	return Actualorganizationname;
}
@FindBy(xpath="//input[@name='account_name']/following-sibling::img")
private WebElement clicktheorganizationimg;
public WebElement getClicktheorganizationimg() {
	return clicktheorganizationimg;
}
public void clickonorganizationimg() {
	clicktheorganizationimg.click();
}
@FindBy(id="search_txt")
private WebElement clicktheorganization;

public WebElement getClicktheorganization() {
	return clicktheorganization;
}
public void createorganizationname(String orgname)
{
	clicktheorganization.sendKeys(orgname);
}
@FindBy(name="search")
private WebElement clickonsearch;

public WebElement getClickonsearch() {
	return clickonsearch;
}
public void clickonsearchnow()
{
	clickonsearch.click();
}
@FindBy(xpath="//select[@id='related_to_type']")
private WebElement selectthetype;
public WebElement getSelectthetype() {
	return selectthetype;
}
public void selectfromdropbox(String organization) 
{
	WebDriverUtility wlib = new WebDriverUtility ();
	selectthetype.click();
	WebElement select = selectthetype;
	wlib.select(select,organization);
}
}


