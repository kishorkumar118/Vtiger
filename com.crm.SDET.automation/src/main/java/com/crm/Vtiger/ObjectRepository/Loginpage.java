package com.crm.Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericutility.WebDriverUtility;

public class Loginpage extends WebDriverUtility {
	//initialization of web element
		public Loginpage(WebDriver driver) 
		{
			PageFactory.initElements(driver,this);
		}
		
	// declaration of web element
	@FindBy(name="user_name")
	private WebElement userNameTextField;

	@FindBy(name="user_password")
	private WebElement passwordTextField;

	@FindBy(id="submitButton")
	private WebElement loginbutton;

	//getters method to use it in the test script
	public WebElement getUserNameTextField() 
	{
		return userNameTextField;
	}
	public WebElement getPasswordTextField() 
	{
		return passwordTextField;
	}
	public WebElement getLoginbutton() 
	{
		return loginbutton;
	}


	 public void login(String username, String password) 
	 {
		 userNameTextField.sendKeys(username);
		 passwordTextField.sendKeys(password);
		 loginbutton.click();
	 }
	}

