package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);

	}

	@FindBy(id = "input-email")
	WebElement txtEmail;

	@FindBy(id = "input-password")
	WebElement txtPassword;

	@FindBy(xpath = "//input[@class=\"btn btn-primary\"]")
	WebElement btnLogin;

	public void SetEmail(String email) {
		txtEmail.sendKeys(email);
	}

	public void SetPassword(String pass) {
		txtPassword.sendKeys(pass);
	}

	public void ClickLogin() {
		btnLogin.click();
	}
}
