package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegisterationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC01_AccountRegistrationTest extends BaseClass {
	@Test(groups= {"Regression","Master"})
	public void verify_acount_registartion() {

		
		logger.info("***************Starting TC001_AccountRegistrationTest**************");
		try {
			
		HomePage hp = new HomePage(driver);

		hp.clickMyAccount();
		logger.info("Clicked on My account Link---------------");
		hp.clickRegister();
		logger.info("Clicked on Register Link---------------");
		AccountRegisterationPage regpage = new AccountRegisterationPage(driver);
		
		logger.info("Providing Customers Details---------------");
		regpage.setFirstName(randomString().toUpperCase());
		regpage.setLastname(randomString().toUpperCase());
		regpage.setEmail(randomString() + "@gmail.com");
		regpage.setTelephone(randomNumber());

		String password = randomAlphaNumeric();
		regpage.setPassword(password);

		regpage.setConfirmPass(password);

		regpage.setPrivacy();
		regpage.clickContinue();
		
		String confmsg = regpage.getConfirmMsg();
		
		logger.info("Validating expected message--------------");
		if(confmsg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}
		
		else
		{
			logger.error("----------Test Failed-------------");
			logger.debug("------------Debug logs---------------");
			Assert.assertTrue(false);
		}
		
	}
		
		catch(Exception e)
		{
			Assert.fail();
		}
		//Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		
		
		logger.info("********************Finished TC001_AccountRegistrationTest********************");
		
		
		
		
	}
}
