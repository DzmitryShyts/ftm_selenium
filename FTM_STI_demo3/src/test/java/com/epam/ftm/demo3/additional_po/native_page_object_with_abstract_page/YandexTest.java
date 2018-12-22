package com.epam.ftm.demo3.additional_po.native_page_object_with_abstract_page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class YandexTest {

	private static final String PASSWORD = "Qwerty123";
	private static final String LOGIN = "dmitry.shyts";
	private static final String START_URL = "https://passport.yandex.com";

	private WebDriver driver;

	@BeforeClass(description = "Start browser")
	public void startBrowser() {
		// init Webdriver and open start url
		System.setProperty("webdriver.chrome.driver", "d:\\_webdriver\\chromedriver\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized"); // Maximize browser window via options, just an example
		driver = new ChromeDriver(options);
	}

	@BeforeClass(dependsOnMethods = "startBrowser", description = "Add implicite wait and maximize window")
	public void addImplicitly() {
		// setting standard timeout
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// navigating to test url
		driver.get(START_URL);
		// Maximize browser window
		driver.manage().window().maximize(); // Maximize browser window via general API, alternative to chrome options
	}

	@Test(description = "Login to Yandex account")
	public void loginToYandex() {
		// Login via user-defined method
		new YandexHomePage(driver).openSignInPage().loginToYandex(LOGIN, PASSWORD);
		new WebDriverWait(driver, 10).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='user-account__name user-account__name_hasAccentLetter']")));

		// Verify the login procedure was correct
		Assert.assertTrue(new YandexAccountPage(driver).loginIsCorrect(), "Looks you are NOT logged in correctly");
		System.out.println("Login was completed correctly.");
	}

	@AfterClass(description = "Stop Browser")
	public void stopBrowser() {
		driver.quit();
	}

}
