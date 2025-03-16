package testCases;



import java.time.Duration;
import java.util.List;

import javax.xml.xpath.XPath;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
				cp.clickOnClient("David ");
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
	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	// Wait for the element to be present (this handles visibility and existence)
		WebElement month = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[2]/div/div/div/div[1]/div[1]/div/div")));
		 //Scroll the element into view
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", month);
		//WebElement month = driver.findElement(By.xpath(""));
		String monthYear = month.getText();
		System.out.println(monthYear);
		String actualMonthYear="January 1999";
		WebElement back= driver.findElement(By.xpath("//button[@title='Previous month']"));
		while(!monthYear.equalsIgnoreCase(actualMonthYear)){
			back.click();
			WebElement newmonth = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[2]/div/div/div/div[1]/div[1]/div/div")));
			 //Scroll the element into view
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", newmonth);
			monthYear = newmonth.getText();
		}
		System.out.println(monthYear);
		List<WebElement> dates = driver.findElements(By.xpath("//button[contains(@class,'MuiButtonBase-root MuiPickersDay-root MuiPickersDay-dayWithMargin css-1h5ekkr') and normalize-space()='']"));
		WebElement date = driver.findElement(By.xpath("//button[contains(@class,'MuiButtonBase-root MuiPickersDay-root MuiPickersDay-dayWithMargin css-1h5ekkr') and normalize-space()='30']"));
		
		date.click();
		
		
		ec.clickSubmit();
		boolean status= ec.isMsgDisplayed();
		
		if(status==true) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
	}
	
}
