package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

	public static WebDriver driver;
	public Logger logger;
	public Properties p;

	@BeforeClass(groups = { "Sanity", "Regression", "Master", "DataDriven" })
	@Parameters({ "os", "browser" })
	public void setup(String os, String br) throws InterruptedException, Exception {

		logger = LogManager.getLogger(this.getClass());

		// Loading config.properties file
		FileReader file = new FileReader(
				"C:\\Users\\Dell\\eclipse-workspace\\OpenCartHybridFramework\\src\\test\\resources\\config.properties");
		p = new Properties();
		p.load(file);

		//Selenium Grid
		String execution_env="local";  //Local will start on Local system  and remote will start on Remote System
		if(execution_env.equalsIgnoreCase("remote"))
		{
			DesiredCapabilities cap=new DesiredCapabilities();
			//OS
			
			if(os.equalsIgnoreCase("windows"))
			{
				cap.setPlatform(Platform.WIN11);
			}
			
			else if(os.equalsIgnoreCase("mac"))
			{
				cap.setPlatform(Platform.MAC);
			}
			else
			{
				System.out.println("No Matching OS.....");
				return;
			}
		
			
			//browser
			
			switch(br.toLowerCase())
			{
			case "chrome":cap.setBrowserName("chrome");
			break;
			case "edge":cap.setBrowserName("MicrosoftEdge");
			break;
			default:System.out.println("No Matching Browser");
			return;
			
			}
			
			driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
		}
		
		
		
		switch (br.toLowerCase()) {

		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		default:
			System.out.println("Invalid Browser name.......");
			return;
		}

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://tutorialsninja.com/demo/");
		// driver.get(p.getProperty("url1"));
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}

	@AfterClass(groups = { "Sanity", "Regression", "Master", "DataDriven" })
	public void tearDown() {
		// driver.quit();
	}

	public String randomString() {
		String generateString = RandomStringUtils.randomAlphabetic(5);
		return generateString;
	}

	public String randomNumber() {
		String generateNumber = RandomStringUtils.randomNumeric(10);
		return generateNumber;
	}

	public String randomAlphaNumeric() {

		String generateString2 = RandomStringUtils.randomAlphabetic(5);
		String generateNumber2 = RandomStringUtils.randomNumeric(5);
		return (generateString2 + "@" + generateNumber2);
	}

	public String captureScreen(String tname) throws IOException {
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

		TakesScreenshot takesSreenshot = (TakesScreenshot) driver;
		File sourceFile = takesSreenshot.getScreenshotAs(OutputType.FILE);

		String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

		File targetFile = new File(targetFilePath);

		sourceFile.renameTo(targetFile);

		return targetFilePath;

	}

}
