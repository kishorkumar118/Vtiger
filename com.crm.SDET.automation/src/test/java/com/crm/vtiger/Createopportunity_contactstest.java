package com.crm.vtiger;


import org.testng.annotations.Test;

import com.crm.Vtiger.ObjectRepository.Createnewopportunitiespage;
import com.crm.Vtiger.ObjectRepository.Homepage;

import com.crm.Vtiger.ObjectRepository.Opportunitiespage;
import com.crm.Vtiger.ObjectRepository.Windowcontactpage;
import com.crm.autodesk.genericutility.Baseclass;
import com.crm.autodesk.genericutility.ExcelUtility;

import com.crm.autodesk.genericutility.JavaUtility;


@Test
public class Createopportunity_contactstest extends Baseclass
{
	@Test
	public void test() throws Throwable
	{
	
     /* fetch testdata from excelsheet */
		ExcelUtility Elib = new ExcelUtility();
        JavaUtility Jlib = new JavaUtility();
         String opportunityname = Elib.getDataFromExcel("DATA",7,3)+ Jlib.getRandomnumber();
         String contact = Elib.getDataFromExcel("DATA",8,3);
         
 
/*navigate to opportunities page */
Homepage homepage = new Homepage(driver);
homepage.clickonopportunitieslink();

/* create a new opportunitypage */
Createnewopportunitiespage cnop = new Createnewopportunitiespage(driver);
cnop.clickonopportunitiesimg();

/* create a new opportunityname */
Opportunitiespage opportunitiespage = new Opportunitiespage(driver);
opportunitiespage.craeteopportunityname(opportunityname);
opportunitiespage.selectfromdropbox(contact);
opportunitiespage.clickoncontactimg();

/* switch to contact window */
Wlib.switchToWindow(driver, "Contacts");
Windowcontactpage windowcontactpage = new Windowcontactpage(driver);
windowcontactpage.selectexistingcontact();

/* switch to opportunity window */
Wlib.switchToWindow(driver,"Potentials&action");
opportunitiespage.clickonErasebtn();
homepage.clickonsaveBtn();
Wlib.switchToAlertWindowandAccept(driver);

/* validate for opportunityname */
}
}
