package com.crm.vtiger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.crm.Vtiger.ObjectRepository.Campaignsinformationpage;
import com.crm.Vtiger.ObjectRepository.Campaignspage;
import com.crm.Vtiger.ObjectRepository.Createnewcampaignspage;
import com.crm.Vtiger.ObjectRepository.Createnewproductpage;
import com.crm.Vtiger.ObjectRepository.Homepage;
import com.crm.Vtiger.ObjectRepository.Productinformationpage;
import com.crm.Vtiger.ObjectRepository.Productpage;
import com.crm.autodesk.genericutility.Baseclass;
import com.crm.autodesk.genericutility.ExcelUtility;
import com.crm.autodesk.genericutility.JavaUtility;
/**
 * 
 * @author Kishorkumar
 * 
 *
 */


@Listeners(com.crm.autodesk.genericutility.Listenersimplementationclass.class)
public class Createcampaign_productnametest extends Baseclass {
	
	@Test
	public void test() throws Throwable
	{
		 ExcelUtility Elib = new ExcelUtility();
		 JavaUtility Jlib = new JavaUtility();
		
			 /* fetch testdata from excelsheet */
	        String campaignname = Elib.getDataFromExcel("DATA",6,3)+ Jlib.getRandomnumber();
	        String productname = Elib.getDataFromExcel("DATA",5,3)+Jlib.getRandomnumber();
	             
		/*navigate to product page */
	        Homepage homepage = new Homepage(driver);
	    homepage.clickonproductslink();
	    
	    /* create new productpage */
	  	Createnewproductpage cnp = new Createnewproductpage(driver);
	  	cnp.clickonproductimg();
	  	Assert.fail();
	  	
	  	/*create productname */
	  	Productpage productpage = new Productpage(driver);
	  			productpage.createproductname(productname);
	  	        productpage.clickonsaveBtn();
	  				
	  	/*validation for productname*/
	  	      Productinformationpage pif = new Productinformationpage(driver);
	  	      Wlib.waitforElementtobeclickable(driver,pif.actualproductname());
	  	String actualmsg = pif.actualproductname().getText();
	  	Assert.assertEquals(actualmsg,productname);
	  	
	    /*move to campaignmodule */
	    Wlib.mouseoveronElement(driver, homepage.getClickonMore());
	    
	    /*navigate to campaignlink */
	    homepage.clickoncampaignslink();
	    
	    /*create new camapaignspage*/
	    Createnewcampaignspage cncp = new Createnewcampaignspage(driver);
	   cncp.clickoncampaignpage();
	    
	   /* create a newcampaign */
	    Campaignspage cp = new Campaignspage(driver);
	    cp.createcampaignname(campaignname);
	    cp.selectproductname();
	    
	    /* switch to childwindow */
	     Wlib.switchToWindow(driver,"Products");
	     productpage.enterproductname(productname);
	     productpage.clickonproductname();
	     driver.findElement(By.xpath("//a[text()='"+productname+"']")).click();
	     
	     /* switch to parentwindow */
	     Wlib.switchToWindow(driver,"Campaigns");
	     homepage.clickonsaveBtn();
	     
	     /*validation for campaignname*/
	     Campaignsinformationpage cip = new Campaignsinformationpage (driver);
	     String actualmsg1 = cip.actualcampaignname().getText();
	     Assert.assertEquals(actualmsg1,campaignname);
	     
	     }
	  }

