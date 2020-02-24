package qbrainx.test;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
	
	WebDriver driver;
	
	Logger log = Logger.getLogger(LoginTest.class);
	
		
	@BeforeMethod
	private void setup() throws IOException {
		System.setProperty("webdriver.chrome.driver", "F:\\Gowtham\\Oxygen workspaces\\TestNGlog4j\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		log.info(" Launcing the chrome browser");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		log.info("entering the application url");
		Properties prop = new Properties();
		FileInputStream stream = new FileInputStream("F:\\Gowtham\\Oxygen workspaces\\TestNGlog4j\\src\\test\\java\\qbrainx\\test\\testdatas.properties");
		prop.load(stream);
		driver.get(prop.getProperty("url"));
		log.warn(" Hey, this is just an warning message ");
	}

	@Test
	private void facebooktest() throws FileNotFoundException {
		Properties prop = new Properties();
		FileInputStream stream = new FileInputStream("F:\\Gowtham\\Oxygen workspaces\\TestNGlog4j\\src\\test\\java\\qbrainx\\test\\testdatas.properties");
		String title = driver.getTitle();
		System.out.println(title);
		System.out.println("The username is" + prop.getProperty("username"));
		System.out.println("The password is "+ prop.getProperty("password"));
		log.info("Login page title" );
		Assert.assertTrue(true);
	}

	@Test
	private void facebooklogintest() {
		boolean result = driver.findElement(By.id("loginbutton")).isDisplayed();
		log.debug("This is debug message");
		System.out.println(result);
		log.fatal("This ia just an fatal message");
	}

}
