package com.crm.vtiger;
import org.testng.annotations.Test;
import com.crm.Vtiger.ObjectRepository.Createnewproductpage;
import com.crm.Vtiger.ObjectRepository.Homepage;
import com.crm.Vtiger.ObjectRepository.Productinformationpage;
import com.crm.Vtiger.ObjectRepository.Productpage;
import com.crm.autodesk.genericutility.Baseclass;
import com.crm.autodesk.genericutility.ExcelUtility;
import com.crm.autodesk.genericutility.JavaUtility;

public class Createproducttest extends Baseclass
{
	@Test(groups="regressiontest")
	public void test() throws Throwable
	{
         /* fetch testdata from excelsheet */
            ExcelUtility Elib = new ExcelUtility();
	         JavaUtility Jlib = new JavaUtility();
        String productname = Elib.getDataFromExcel("DATA",5,3)+Jlib.getRandomnumber();
             
	
     /*navigate to productpage */
    Homepage homepage = new Homepage(driver);
    homepage.clickonproductslink();
    
    /*create newproductpage */
  	Createnewproductpage cnpp = new Createnewproductpage(driver);
  	cnpp.clickonproductimg();
  	
  	/*create new productname */
  	Productpage productpage = new Productpage(driver);
  			productpage.createproductname(productname);
  	        productpage.clickonsaveBtn();
  				
  	/*validation for productname*/
  	      Productinformationpage pifp = new Productinformationpage(driver);
  	      Wlib.waitforElementtobeclickable(driver,pifp.actualproductname());
  	String actualmsg = pifp.actualproductname().getText();
  	{
  		if(actualmsg.contains(productname))
  		{
  			System.out.println(productname+" is verified==pass");
  		}
  		else
  		{
  			System.out.println(productname+" is not verified==pass");
  		}
  
      
      }
	}
}
