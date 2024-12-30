package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC03_LoginDDT extends BaseClass {

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class,groups="DataDriven")
	public void verify_loginDDT(String email, String pwd, String exp) {

		logger.info("********************  Starting TC03_LoginDDT   *******************");

		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();

			LoginPage lp = new LoginPage(driver);
			lp.SetEmail(email);
			lp.SetPassword(pwd);
			lp.ClickLogin();

			MyAccountPage mac = new MyAccountPage(driver);
			boolean targetPage = mac.isMyAccountPageExists();
			// mac.clickLogout();

			/*
			 * Condition 1.Data is valid----Login success---test pass-logout
			 *                              Login Failed----test fail
			 * 
			 * Condition 2.Data is Invalid-----Login success----test fail---logout 
			 * 									Login fail-------test pass
			 */

			
			//Positive and Negative Test cases 
			if (exp.equalsIgnoreCase("valid")) {
				if (targetPage == true) {
					mac.clickLogout();
					Assert.assertTrue(true);
				} else {
					Assert.assertTrue(false);
				}
			}
			if (exp.equalsIgnoreCase("Invalid")) {
				if (targetPage == true) {
					mac.clickLogout();
					Assert.assertTrue(false);
				} else {
					Assert.assertTrue(true);
				}
			}
		} catch (Exception e) {
			Assert.fail();
		}
		logger.info("********************  Finshed TC03_LoginDDT   *******************");

	}
}
