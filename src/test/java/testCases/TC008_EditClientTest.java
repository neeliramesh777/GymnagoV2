package testCases;

import javax.xml.xpath.XPath;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ClientsPage;
import pageObjects.EditClientPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC008_EditClientTest extends BaseClass{

	@Test(enabled = false)
	public void verifyEditClient() throws InterruptedException {
		//LoginPage
		
		try {
				LoginPage lp= new LoginPage(driver);
				lp.login("admin@pixel.com", "sk12345");
				//HomePage
				HomePage hp=new HomePage(driver);
				Thread.sleep(2000);
				hp.clickMenuTab();
				hp.clickClientsTab();
				hp.clickClients();
				Thread.sleep(2000);
				
				ClientsPage cp=new ClientsPage(driver);
				logger.info("Searching");
				//boolean status=cp.selectClient("Charan New");
			//Assert.assertTrue(status);
				
				//cp.setSearch("Charan New");
				cp.clickOnClient("David zzmos");
				cp.editClient();
				
				//EditClientPage
				
				EditClientPage ec=new EditClientPage(driver);
				ec.clickSubmit();
				boolean status= ec.isMsgDisplayed();
				
				if(status==true) {
					Assert.assertTrue(true);
				}else {
					Assert.assertTrue(false);
				}}catch (StaleElementReferenceException e) {
					System.out.println("Stale element found. Retrying...");
					
				}
		
				
	}
	
	@Test(priority = 0)
	public void VerifyEditClientWithValidData() throws InterruptedException {
		LoginPage lp= new LoginPage(driver);
		lp.login("admin@pixel.com", "sk12345");
		//HomePage
		HomePage hp=new HomePage(driver);
		Thread.sleep(2000);
		hp.clickMenuTab();
		hp.clickClientsTab();
		hp.clickClients();
		Thread.sleep(2000);
		
		ClientsPage cp=new ClientsPage(driver);
		logger.info("Searching");
		//boolean status=cp.selectClient("Charan New");
	//Assert.assertTrue(status);
		
		//cp.setSearch("Charan New");
		cp.clickOnClient("David zzmos");
		try{
		cp.editClient();
		}catch(StaleElementReferenceException e) {
			System.out.println("Stale element foun..");
			cp.editClient();
		}
		//EditClientPage
		
		EditClientPage ec=new EditClientPage(driver);
		WebElement datepicker=driver.findElement(By.xpath("//button[@class=\"MuiButtonBase-root MuiIconButton-root MuiIconButton-edgeEnd MuiIconButton-sizeMedium css-slyssw\"]"));
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);",datepicker);
		datepicker.click();		
		String monthYear=driver.findElement(By.xpath("//div[@class='MuiDateCalendar-root css-1080di7']//div[@id=':r6k:-grid-label']")).getText();
		String actualMonthYear="January 2000";
		WebElement previousyearmonth= driver.findElement(By.xpath("//button[@title='Previous month']//*[name()='svg']"));
		while(monthYear!=actualMonthYear){
			previousyearmonth.click();
		}
		
		
		
		ec.clickSubmit();
		boolean status= ec.isMsgDisplayed();
		
		if(status==true) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
	}
	
}
