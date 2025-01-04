package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AddclientPage;
import pageObjects.ClientsPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC002_AddClientTest extends BaseClass{

	@Test
	public void verify_Add_Client() throws InterruptedException {
		//LoginPage
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
		cp.clickAddNewClient();
		
		AddclientPage acp=new AddclientPage(driver);
		acp.setFirstname(RandomString().toLowerCase());
		acp.setLastname(RandomString().toLowerCase());
		acp.setEmail(RandomString()+"@gmail.com");
		acp.setMobileNumber("5"+RandomNumber());
		acp.setEmergencyNumber("5"+RandomNumber());
		acp.clickTermsAndConditions();
		acp.clickSigntab();
		acp.clickCloseTandC();
		acp.clickSubmit();
		boolean status=acp.conifrmationmsg();
		
		if(status==true) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
		
		
		
		
		
	}
}
