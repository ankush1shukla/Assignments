package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage {

	WebDriver driver;

	public ConfirmationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[contains(@class,'recharge-status success-msg')]")
	private WebElement status;

	@FindBy(xpath = "//span[@class='recharge-summary']")
	private WebElement message;

	public String RechargeStatus() {
		return status.getText();
	}

	public String RechargeMessage() {
		return message.getText();
	}
}
