package pageObjects;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.beust.jcommander.internal.Console;

import freemarker.log.Logger;

public class ClientsPage extends BasePage{

	public ClientsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
@FindBy(xpath = "//button[normalize-space()='Add new Client']")
WebElement btnAddNewClient;

@FindBy(xpath = "//*[@name='searchQuery']")
WebElement txtSearch;

@FindBy(xpath = "//span[normalize-space()='Details']")
WebElement tabDetails;

@FindBy(xpath = "//ul[@class='dropdown-menu show']//span[contains(text(),'View Client Profile')]")////tbody/tr/td/div/ul/li/button/span[text()='View Client Profile']
WebElement lnkViewClient;

@FindBy(xpath = "//h5[@class='fw-bold mb-2 mt-2 d-flex align-items-center']/span")
WebElement firstname;

@FindBy(xpath = "//ul[@class='dropdown-menu show']//span[contains(text(),'More Actions')]")
WebElement lnkMoreActions;

@FindBy(xpath = "//a[@class='custom-acc-created__item membership']")
WebElement lnkMembership;

@FindBy(xpath = "//ul[@class='dropdown-menu show']//span[contains(text(),'Edit Client')]")
WebElement lnkEditClient;

public void clickAddNewClient() {
	btnAddNewClient.click();
}

public void setSearch(String name) {
txtSearch.sendKeys(name);	
}



	
public void clickOnClient(String name) throws InterruptedException {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    // Locate the search input field and enter the client name to search
	txtSearch.clear();
    txtSearch.sendKeys(name);
    Thread.sleep(20000);

    // Wait until the table loads with results
   // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"menu0\"]/div[1]/div/div/table"))); // Adjust table ID as needed

   
    
    // Locate the table that contains client records
    WebElement clientTable = driver.findElement(By.xpath("//*[@id=\"menu0\"]/div[1]/div/div/table"));

    // Wait for the rows to be visible
    List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));
    wait.until(ExpectedConditions.visibilityOfAllElements(rows));

    // Iterate through the rows and find the one with the desired client name
  
    for(int i =0; i<rows.size(); i++) {
    	List<WebElement> cols=rows.get(i).findElements(By.xpath("//table/tbody/tr/td"));
    	for(int j=0; j<cols.size(); j++) {
    		String cell=cols.get(j).getText();
    		System.out.println(cell);
    		if(cell.equals(name)) {
    			System.out.println(cell);
    			WebElement more= driver.findElement(By.xpath("//tbody/tr/td/div/a/img"));
    			more.click();
    			break;
    			
    		}
    		
    	}
    
    }
      
}


public void clickViewClient() {
	lnkViewClient.click();
}

public void clickDetails() {
	tabDetails.click();
}

public String getFirstname() {
	return firstname.getText();
	
}

public void membershipPayment() {
	lnkMoreActions.click();
	lnkMembership.click();
}

public void editClient() {
	lnkEditClient.click();
}


}
