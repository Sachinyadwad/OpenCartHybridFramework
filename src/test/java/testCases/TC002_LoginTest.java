package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {

	@Test(groups= {"Sanity","Master"})
	public void verify_Login() {

		logger.info("************Starting TC002_LoginTest********************");

		try {

			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();

			LoginPage lp = new LoginPage(driver);
			lp.SetEmail("automationnew1@gmail.com");
			lp.SetPassword("automationnew1");
			lp.ClickLogin();

			MyAccountPage mac = new MyAccountPage(driver);
			boolean targetPage = mac.isMyAccountPageExists();
			mac.clickLogout();
			Assert.assertTrue(targetPage);

		}

		catch (Exception e) {
			Assert.fail();
		}
	logger.info("***************Finished TC_002_Login_Test************");
	}
}
