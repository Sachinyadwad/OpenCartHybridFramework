package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegisterationPage extends BasePage {

	public AccountRegisterationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(id = "input-firstname")
	WebElement txtFirstName;

	@FindBy(id = "input-lastname")
	WebElement txtLastName;

	@FindBy(id = "input-email")
	WebElement txtEmail;

	@FindBy(id = "input-telephone")
	WebElement txtTelephone;

	@FindBy(id = "input-password")
	WebElement txtPassword;

	@FindBy(id = "input-confirm")
	WebElement txtConfirmPassword;

	@FindBy(xpath = "//input[@name='agree']")
	WebElement chkPolicy;

	@FindBy(xpath = "//input[@value=\"Continue\"]")
	WebElement btnContinue;

	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirm;

	public void setFirstName(String fname) {
		txtFirstName.sendKeys(fname);
	}

	public void setLastname(String lname) {
		txtLastName.sendKeys(lname);
	}

	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}

	public void setTelephone(String tel) {
		txtTelephone.sendKeys(tel);
	}

	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}

	public void setConfirmPass(String pwd) {
		txtConfirmPassword.sendKeys(pwd);
	}

	public void setPrivacy() {
		chkPolicy.click();
	}

	public void clickContinue() {
		// Sol1
		btnContinue.click();
		/*
		 * //Sol2 btnContinue.submit(); //Sol3 Actions act=new Actions(driver);
		 * act.moveToElement(btnContinue).click().perform();
		 * 
		 * //Sol4 JavascriptExecutor js=(JavascriptExecutor) driver;
		 * js.executeScript("arguements[0].click();", btnContinue);
		 * 
		 * // Sol5 btnContinue.sendKeys(Keys.RETURN); }
		 */
	}

	public String getConfirmMsg() {

		return (msgConfirm.getText());

	}
}
