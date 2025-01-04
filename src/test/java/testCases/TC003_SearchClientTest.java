package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ClientsPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC003_SearchClientTest extends BaseClass{
	
	@Test
	public void verifyClientSearch() throws InterruptedException {
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
				cp.clickViewClient();
				cp.clickDetails();
				String value=cp.getFirstname();
		        logger.info("Details");
				System.out.println(value);
				if(value.contains("Charan")) {
					Assert.assertTrue(true);
				}else {
					Assert.assertTrue(false);
				}
	}

}
