package com.crm.vtiger;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.crm.Vtiger.ObjectRepository.Contactinformationpage;
import com.crm.Vtiger.ObjectRepository.Contactpage;
import com.crm.Vtiger.ObjectRepository.Createnewcontactpage;
import com.crm.Vtiger.ObjectRepository.Createneworganizationpage;
import com.crm.Vtiger.ObjectRepository.Homepage;
import com.crm.Vtiger.ObjectRepository.Organizationinformationpage;
import com.crm.Vtiger.ObjectRepository.Organizationpage;
import com.crm.autodesk.genericutility.Baseclass;
import com.crm.autodesk.genericutility.ExcelUtility;

import com.crm.autodesk.genericutility.JavaUtility;


public class Createcontact_organizationtest extends Baseclass {
	@Test
	public void test() throws Throwable
	{
		ExcelUtility Elib = new ExcelUtility();
		 JavaUtility Jlib = new JavaUtility();
      /* fetch testdata from excelsheet */
            String orgname = Elib.getDataFromExcel("DATA",1,3)+ Jlib.getRandomnumber();
            String contactname = Elib.getDataFromExcel("DATA",4, 3)+ Jlib.getRandomnumber();
         
            
    /* navigate to organizationlink */
    Homepage hompage = new Homepage(driver);
    hompage.clickonOrganizationlink();

    /*create new organizationpage */
    Createneworganizationpage cnop = new Createneworganizationpage(driver);
    cnop.clickoncreateimage();

    /* create organizationname */
    Organizationinformationpage oifp = new Organizationinformationpage(driver);
    oifp.neworganizationname(orgname);
    oifp.selectindustrytype("Healthcare");
    oifp.clickonsavebutton();

    /*validate the organizationname */
    Organizationpage op = new Organizationpage(driver);
    Wlib.waitforElementtobeclickable(driver, op.actualorganizationname());
    String actualmsg = op.actualorganizationname().getText();
    if(actualmsg.contains(orgname))
    {
    	System.out.println("organizationname is verified successfully =="+orgname);
    }
    else
    {
    	System.out.println("organizationname is not verified successfully=="+orgname);
    }
    /*move to morelink */
    Wlib.mouseoveronElement(driver, hompage.getClickonMore());
    
    /*navigate to contactslink*/
    hompage.clickoncontactslink();
    
    /* create new contact page*/
     Createnewcontactpage cncp = new Createnewcontactpage(driver);
     cncp.clickoncontactimg();
   
    /* create a contactname*/
     Contactpage cp = new Contactpage(driver);
     cp.createnewcontactname(contactname);
     cp.clickoncontactimg();
      
     /* switch to childwindow */
     Wlib.switchToWindow(driver,"Accounts");
     op.createorganizationname(orgname);
      op.clickonsearchnow();
    driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();
       
       /* switch to Parentwindow */
       Wlib.switchToWindow(driver,"contacts");
       hompage.clickonsaveBtn();
     
       /*validation for contactname*/
       Contactinformationpage cifp = new Contactinformationpage(driver);
       String actualmsg1 = cifp.actualcontactname().getText();
       if(actualmsg1.contains(contactname))
      {
       	System.out.println(contactname+"is verified==pass");
       }
       else
       {
       	System.out.println(contactname+ "is not verified==fail");
       }
       
       
      }
       
}
