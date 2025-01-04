package pageObjects;

import java.awt.RenderingHints.Key;
import java.sql.Time;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import freemarker.log.Logger;

public class PaymentPage extends BasePage{

	public PaymentPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
@FindBy(xpath = "//label[normalize-space()='Membership Payment']")
WebElement tabMembership;
	
@FindBy(xpath  = "/html[1]/body[1]/div[1]/div[1]/section[1]/main[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]")
WebElement salesBY;

@FindBy(xpath = "//input[@id='react-select-2-input']")
WebElement txtClient;

@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/section[1]/main[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[5]/div[2]/div[1]/div[1]")
WebElement txtMembershipCategory;

@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/section[1]/main[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[6]/div[2]/div[1]/div[1]")
WebElement txtMembershipname;

@FindBy(xpath = "//button[normalize-space()='Go to payment']")
WebElement btnGotoPayment;

@FindBy(xpath = "//body[1]/div[1]/div[1]/section[1]/main[1]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[5]/div[1]/div[4]/div[1]/div[2]/div[1]/span[1]/img[1]")
WebElement btnPaymentmethod;

@FindBy(xpath = "//button[contains(text(), 'Pay ') and @type='submit']")
WebElement btnPay;

@FindBy(xpath = "//button[contains(text(), 'Pay Later')]")
WebElement btnPaylater;

@FindBy(linkText = "Cancel")
WebElement btnCancel;

@FindBy(xpath = "//p[contains(text(),'Teja')]")
WebElement invoice;

@FindBy(xpath = "//div[contains(@role,'dialog')]//div[contains(@class,'modal-header')]//button[contains(@type,'button')]")
WebElement btnClose;


public void clickMembershipTab() {
	Actions act=new Actions(driver);
	act.moveToElement(tabMembership).click();
	act.build().perform();
}

public void clickSalesBy() {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.visibilityOf(salesBY));
	salesBY.click();
}

public void selectSalesBy(String staff) {

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.visibilityOf(salesBY));
    salesBY.click();
	List<WebElement> stafflist=driver.findElements(By.xpath("//li[@class=\"MuiButtonBase-root MuiMenuItem-root MuiMenuItem-gutters MuiMenuItem-root MuiMenuItem-gutters css-17pxts6\"]"));
	
	for(int i=0; i<stafflist.size(); i++) {
		String res=stafflist.get(i).getText();
		System.out.println(res);
		if(res.contains(staff)){
			stafflist.get(i).click();
			break;
		}else {
			continue;
		}
	}
}
	


public void selectClient(String name) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.elementToBeClickable(txtClient));
    
        // Handle non-interactable case with JavaScript
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value = '';", txtClient);
  //  txtClient.click();
    txtClient.sendKeys(name);
    
    List<WebElement> clients=driver.findElements(By.xpath("//div[contains(text(), '"+name+"')]"));
    for(int i=0; i<clients.size(); i++) {
    	String clientname=clients.get(i).getText();
    	System.out.println(clientname);
    	if(clientname.contains(name)) {
    		clients.get(i).click();
    		break;
    	}
    }
    
}


public void selectMembershipCategory(String category) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.elementToBeClickable(txtMembershipCategory));
    txtMembershipCategory.click();
    
    List<WebElement> categories=driver.findElements(By.xpath("//li/span[contains(text(),'"+category+"')]"));
    for(int i=0; i<categories.size(); i++) {
    	String categoryname=categories.get(i).getText();
    	System.out.println(categoryname);
    	if(categoryname.contains(category)) {
    		categories.get(i).click();
    		break;
    	}
}

}

public void selectMembership(String membership) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    wait.until(ExpectedConditions.elementToBeClickable(txtMembershipname));
    txtMembershipname.click();
    List<WebElement> memberships=driver.findElements(By.xpath("//li/span[contains(text(), '"+membership+"')]"));
    for(int i=0; i<memberships.size(); i++) {
    	String membershipname=memberships.get(i).getText();
    	System.out.println(membershipname);
    	if(membershipname.contains(membership)) {
    		WebElement mem=memberships.get(i);
    		JavascriptExecutor js=(JavascriptExecutor)driver;
    		
    		js.executeScript("arguments[0].scrollIntoView(true);", mem);
    		//wait.until(ExpectedConditions.elementToBeClickable(mem));
    		mem.click();
    		break;
    	}
}
}

public void clickGototPayment() {
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView(true);", btnGotoPayment);
	
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
	wait.until(ExpectedConditions.elementToBeClickable(btnGotoPayment));
	btnGotoPayment.click();
}

public void clickPaymentmethod() {
	btnPaymentmethod.click();
}

public void clickPay() {
	btnPay.click();
}

public boolean isInvoiceDisplayed(String name) {
	btnPay.click();
	WebElement invoice=driver.findElement(By.xpath("//p[contains(text(),'"+name+"')]"));
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
	wait.until(ExpectedConditions.elementToBeClickable(invoice));
	boolean status=invoice.isDisplayed();
	return status;
}

public void clickClose() {
	btnClose.click();
}


}
