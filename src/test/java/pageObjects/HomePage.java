package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
@FindBy(xpath = "//body/div[@id='root']/div[@class='d-flex vh-100 overflow-hidden w-100']/section[@class='main-page pageBg flex-grow-0 flex-shrink-0 notFullWided']/header[@class='d-flex flex-wrap justify-content-end mainHeader']/div[@class='space-3 px-3 d-flex align-items-center']/div[5]/a[1]")
WebElement lnkAdmin;

@FindBy(xpath = "//span[normalize-space()='Sign Out']")
WebElement lnkSignout;

@FindBy(xpath = "//div[@class='w-100 d-flex align-items-center justify-content-start ps-3']")
WebElement tabMenu;

@FindBy(xpath="(//span[@class='main-link-inner'])[3]")
WebElement lnkClientsTab;

@FindBy(xpath = "//span[@class='d-inline-block'][normalize-space()='Clients']")
WebElement lnkClients;

@FindBy(xpath = "//a[normalize-space()='Payment']")
WebElement lnkPaymentsTab;



public boolean isAdminDisplayed() {
	return lnkAdmin.isDisplayed();
}

public void clickAdmin() {
	lnkAdmin.click();
}

public void clickSignout() {
	lnkSignout.click();
}

public void clickMenuTab() {
	Actions a=new Actions(driver);
	a.moveToElement(tabMenu);
	a.build().perform();
	//tabMenu.click();
	
}

public void clickClientsTab() {
	lnkClientsTab.click();
}

public void clickClients() {
	lnkClients.click();
}

public void clickPaymentsTab() {
	lnkPaymentsTab.click();
}

}
