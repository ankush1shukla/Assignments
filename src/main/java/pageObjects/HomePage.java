package pageObjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "operator")
	private WebElement operatorInputField;
	@FindBy(name = "mobile")
	private WebElement telephoneInputField;
	@FindBy(name = "amount")
	private WebElement rechargeAmountInputField;
	@FindBy(xpath = "//ul[contains(@class,'cat1')]//li[1]//a[1]//div[1]//b[1][contains(text(),'$10')]")
	private WebElement selectAmount;
	@FindBy(xpath = "//div[contains(@class,'box menuitem')]//div[3]//div[1]//button[1]")
	private WebElement rechargeNextButton;

	public void selectOperator(String fieldValue) {
		operatorInputField.click();
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='suggestion']//ul//li//a//div//b"));
		for (WebElement ele : list) {
			if (ele.getText().contains(fieldValue)) {
				ele.click();
				break;
			}
		}
	}

	public void specifyTelephoneNumber(String fieldValue) {
		telephoneInputField.click();
		telephoneInputField.sendKeys(fieldValue);
	}

	public void selectRechargeAmount() {
		rechargeAmountInputField.click();
		selectAmount.click();
	}

	public void clickOnRechargeButton() {
		rechargeNextButton.click();
	}
}
