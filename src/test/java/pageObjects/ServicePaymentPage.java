package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ServicePaymentPage extends BasePage{

	public ServicePaymentPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

@FindBy(xpath = "//div[contains(@id,':rs:')]")
WebElement divsalesby;

//@FindBy(xpath = "//span[normalize-space()='Hasan RN']")

@FindBy(xpath = "//input[@id='react-select-3-input']")
WebElement txtclient;

@FindBy(xpath = "//div[@id=':ru:']")
WebElement divserviceCategory;

@FindBy(xpath = "//div[@id=':rv:']")
WebElement divserviceName;

@FindBy(xpath = "//button[contains(@aria-label,'Choose date, selected date is Mar 2, 2025')]")
WebElement btndatePicker;

@FindBy(xpath = "//div[@class='MuiSelect-select MuiSelect-outlined MuiSelect-multiple MuiInputBase-input MuiOutlinedInput-input css-qiwgdb' and @xpath=\"1\"]")
WebElement divpreferredTrainer;

@FindBy(linkText = "Go to payment")
WebElement btngoToPayment;

@FindBy(xpath = "//body[1]/div[1]/div[1]/section[1]/main[1]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[4]/div[1]/div[1]/div[1]/div[2]/div[1]/span[1]/img[1]")
WebElement btnpaymentMethod;

@FindBy(xpath = "//button[@type='submit' and starts-with(text(),'Pay')]")
WebElement btnpay;

@FindBy(xpath = "//button[@type='button' and starts-with(text(),'Pay Later')]")
WebElement btnPayLater;

@FindBy(linkText = "Cancel")
WebElement btnCancel;










}
