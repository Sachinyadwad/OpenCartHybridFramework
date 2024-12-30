package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
	}

	@FindBy(xpath = "//h2[normalize-space()='My Account']")
	WebElement msgMyAccount;

	@FindBy(linkText = "Logout")
	WebElement btnLogout;

	public boolean isMyAccountPageExists() {
		try {
			return (msgMyAccount.isDisplayed());
		} catch (Exception e) {
			return false;
		}
		

	}
	
	public void clickLogout()
	{
		btnLogout.click();
	}
}
