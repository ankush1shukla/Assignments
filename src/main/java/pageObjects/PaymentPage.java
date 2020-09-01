package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {

	WebDriver driver;

	public PaymentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
    @FindBy(xpath = "//form[@id='payment-form']/div/div/div/div/input[@name='cardname']")
    private WebElement cardName;
    @FindBy(xpath = "//form[@id='payment-form']/div/div/div/div/div/input[@name='cardno']")
    private WebElement cardNumber;
    @FindBy(xpath = "//form[@id='payment-form']/div/div/div/div/div/input[@name='expmonth']")
    private WebElement month;
    @FindBy(xpath = "//form[@id='payment-form']/div/div/div/div/div/input[@name='expyear']")
    private WebElement date;
    @FindBy(xpath = "//form[@id='payment-form']/div/div/div/div/input[@name='cvvno']")
    private WebElement cvv;
    @FindBy(xpath = "//form[@id='payment-form']/div/div/div/input[@name='txtEmail']")
    private WebElement email;
    @FindBy(id = "paylimit")
    private WebElement payButton;
    
    @FindBy(xpath = "//form[@id='loginForm']/div/input[@id='usrname']")
	private WebElement username;
	@FindBy(xpath = "//form[@id='loginForm']/div/following-sibling::div/input[@id='psw']")
	private WebElement password;
	
	@FindBy(xpath = "//iframe[contains(@name,'a-')]")
	private WebElement iframe;
	@FindBy(xpath = "//span[@role='checkbox']")
	private WebElement robot;
	
	
	@FindBy(xpath = "//button[@id='loginBtn']")
	private WebElement submit;


    public void setCreditCardName(WebDriver driver, String fieldValue) {
        writeContentForTextField(fieldValue, cardName);
    }

    public void setCardNumber(String fieldValue) {
        writeContentForTextField(fieldValue, cardNumber);
    }

    public void setMonth(String fieldValue) {
        writeContentForTextField( fieldValue, month);
    }

    public void setYear(String fieldValue) {
        writeContentForTextField( fieldValue, date);
    }

    public void setCvv(String fieldValue) {
        writeContentForTextField(fieldValue, cvv);
    }

    public void setEmail(String fieldValue) {
        writeContentForTextField(fieldValue, email);
    }
    
    public void clickPayButton(WebDriver driver) {
        payButton.click();
    }
    
    
    public void setUserName(String fieldValue) {
		writeContentForTextField(fieldValue, username);
	}

	public void setPassword(String fieldValue) {
		writeContentForTextField(fieldValue, password);
	}
	
	public void clickRobot() {
        driver.switchTo().frame(iframe);
        robot.click();
        driver.switchTo().defaultContent();
}
	
	public void clickSubmit() {
		submit.click();
	}
    private static void writeContentForTextField(String fieldValue, WebElement textField) {
        textField.click();
        textField.sendKeys(fieldValue);
    }


    

}
