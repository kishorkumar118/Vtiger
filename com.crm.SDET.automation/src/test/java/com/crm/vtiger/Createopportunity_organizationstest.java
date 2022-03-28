package com.crm.vtiger;
import org.testng.annotations.Test;
import com.crm.Vtiger.ObjectRepository.Createnewopportunitiespage;
import com.crm.Vtiger.ObjectRepository.Homepage;
import com.crm.Vtiger.ObjectRepository.Opportunitiespage;
import com.crm.Vtiger.ObjectRepository.Organizationpage;
import com.crm.Vtiger.ObjectRepository.WindowOrganizationpage;
import com.crm.autodesk.genericutility.Baseclass;
import com.crm.autodesk.genericutility.ExcelUtility;
import com.crm.autodesk.genericutility.JavaUtility;

public class Createopportunity_organizationstest extends Baseclass 
{
	@Test
	public void test() throws Throwable {
		
     /* fetch testdata from excelsheet */
		ExcelUtility Elib = new ExcelUtility();
        JavaUtility Jlib = new JavaUtility();
         String opportunityname = Elib.getDataFromExcel("DATA",7,3)+ 
        		 Jlib.getRandomnumber();
         String organization = Elib.getDataFromExcel("DATA",9,3);
         
 /*navigate to opportunities page */
Homepage homepage = new Homepage(driver);
homepage.clickonopportunitieslink();

/* create a new opportunitypage */
Createnewopportunitiespage cnop = new Createnewopportunitiespage(driver);
cnop.clickonopportunitiesimg();

/* create a new opportunityname */
Opportunitiespage opportunitiespage = new Opportunitiespage(driver);
opportunitiespage.craeteopportunityname(opportunityname);
Organizationpage op = new Organizationpage(driver);
op.selectfromdropbox(organization);
opportunitiespage.clickonorganizationimg();

/* switch to organization window */
Wlib.switchToWindow(driver, "Accounts");
WindowOrganizationpage windoworganizationpage = new WindowOrganizationpage(driver);
windoworganizationpage.selectexistingorganization();

/* switch to opportunity window */
Wlib.switchToWindow(driver,"Potentials");
opportunitiespage.clickonErasebtn();
homepage.clickonsaveBtn();
Wlib.switchToAlertWindowandAccept(driver);
}
}


