package testCases;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.InvalidElementStateException;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ClientsPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.PaymentPage;
import testBase.BaseClass;

public class TC004_PaymentTest extends BaseClass{

	@Test(priority=0, enabled = false)
	public void verifyMembershipPayment() throws InterruptedException {
		//LoginPage
		LoginPage lp= new LoginPage(driver);
		lp.login("admin@pixel.com", "sk12345");
		//HomePage
		HomePage hp=new HomePage(driver);
		hp.clickMenuTab();
		hp.clickClientsTab();
		Thread.sleep(2000);
		hp.clickClients();
		Thread.sleep(2000);
		//ClientsPage
		ClientsPage cp=new ClientsPage(driver);
		logger.info("Searching");
		//boolean status=cp.selectClient("Charan New");
	//Assert.assertTrue(status);
		
		//cp.setSearch("Charan New");
		cp.clickOnClient("Charan New");
		cp.membershipPayment();
	}
	
	@Test(priority = 1)
	public void verifyPayment() throws InterruptedException {
		LoginPage lp= new LoginPage(driver);
		lp.login("admin@pixel.com", "sk12345");
		//HomePage
		HomePage hp=new HomePage(driver);
		hp.clickMenuTab();
		hp.clickClientsTab();
		hp.clickPaymentsTab();
		//PaymentPage
		
		PaymentPage pp=new PaymentPage(driver);
		pp.clickMembershipTab();
		//pp.clickSalesBy();
		pp.selectSalesBy("Raju RN");
		Thread.sleep(10);
		logger.info("Selecting client");
		    	logger.info("Clicking on search");
		    	pp.selectClient("Peter RN");
		    	logger.info("Selected client");
		  
		pp.selectMembershipCategory("Standard Membership");
		logger.info("Selected membership category");
		pp.selectMembership("One day membership");
		logger.info("Selected membership");
		pp.clickGototPayment();
		logger.info("Clicked gotopayment");
		pp.clickPaymentmethod();
		logger.info("Clicked payment method");
		//pp.clickPay();
		//logger.info("Clicked pay");
		
		if(pp.isInvoiceDisplayed("Peter RN")) {
		Assert.assertEquals(true, "Pass");
		pp.clickClose();
		}else {
			assertEquals(false, "Fail");
		}
		
		
		
		
	}
	

	
	
}
