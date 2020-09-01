package Application;

import static org.testng.AssertJUnit.assertEquals;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.ConfirmationPage;
import pageObjects.HomePage;
import pageObjects.PaymentPage;
import resources.base;

public class RechargeApplication extends base {

	WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());
	HomePage homePage;
	PaymentPage payment;

	@BeforeTest
	public void setUp() throws IOException {
		driver = initializeDriver();
		log.info("Driver is initialised");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to the home page");
		homePage = new HomePage(driver);
		payment = new PaymentPage(driver);
	}

	@AfterTest
	public void tearDown() throws IOException {
		driver.close();
		log.info("Browser is closed");

	}

	@Test
	public void RechargePlanSelection() throws IOException, InterruptedException {
		
		homePage.selectOperator(prop.getProperty("mobile_operator"));
		homePage.specifyTelephoneNumber(prop.getProperty("mobile_no"));
		homePage.selectRechargeAmount();
		homePage.clickOnRechargeButton();
		log.info("Mobile datails filled!");
	}
	
	@Test
	public void VeriftNavigationOnPaymentPage() throws IOException, InterruptedException {
		System.out.println(driver.getCurrentUrl());
		assertEquals(driver.getCurrentUrl(), "https://prueba.undostres.com.mx/payment.php");
	}

	@Test
	public void PayingRechargeAmount() {
	    
		payment.setCreditCardName(driver, prop.getProperty("card_name"));
		payment.setCardNumber(prop.getProperty("card_no"));
		payment.setMonth(prop.getProperty("month_no"));
		payment.setYear(prop.getProperty("year_name"));
		payment.setCvv(prop.getProperty("cvv_no"));
		payment.setEmail(prop.getProperty("email_Id"));
		payment.clickPayButton(driver);
		payment.setUserName(prop.getProperty("user_name"));
		payment.setPassword(prop.getProperty("user_password"));
		payment.clickRobot();
		payment.clickSubmit();
		log.info("Payment Completed!");
	}

	@Test
	public void RechargeConfirmation() throws IOException, InterruptedException {

		ConfirmationPage confirm = new ConfirmationPage(driver);
		System.out.print(driver.getCurrentUrl());
		assertEquals(confirm.RechargeStatus(), prop.getProperty("expectedStatus"));
		System.out.print(confirm.RechargeStatus());
		assertEquals(confirm.RechargeMessage(), prop.getProperty("expectedRechargeMessage"));
		System.out.print(confirm.RechargeMessage());
	}

}
