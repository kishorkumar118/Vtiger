package com.crm.vtiger;

import org.testng.annotations.Test;
import com.crm.Vtiger.ObjectRepository.Createneworganizationpage;
import com.crm.Vtiger.ObjectRepository.Homepage;
import com.crm.Vtiger.ObjectRepository.Organizationinformationpage;
import com.crm.Vtiger.ObjectRepository.Organizationpage;
import com.crm.autodesk.genericutility.Baseclass;
import com.crm.autodesk.genericutility.ExcelUtility;
import com.crm.autodesk.genericutility.JavaUtility;

public class Createorganizationtest extends Baseclass 
{
	@Test(groups="smoketest")
	public void test() throws Throwable
	{
	
         /* fetch testdata from excelsheet */
             ExcelUtility Elib = new ExcelUtility();
	         JavaUtility Jlib = new JavaUtility();
             String orgname = Elib.getDataFromExcel("DATA",1,3)+ Jlib.getRandomnumber();
             
 /* navigate to organizationlink */
Homepage homepage = new Homepage(driver);
homepage.clickonOrganizationlink();

/*create neworganizationpage */
Createneworganizationpage cnop = new Createneworganizationpage(driver);
cnop.clickoncreateimage();

/* create new organization name */
Organizationinformationpage oip = new Organizationinformationpage(driver);
oip.neworganizationname(orgname);
homepage.clickonsaveBtn();

/* validation for organization name */
Organizationpage op = new Organizationpage(driver);
String actualmsg = op.actualorganizationname().getText();
if(actualmsg.contains(orgname))
{
	System.out.println(orgname+"is verified pass");
}
else
{
	System.out.println(orgname+ "is not verified");
}
}
	}
	

