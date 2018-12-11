package com.epam.ftm.demo2.chrome;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class YandexCHR {

	private static final String SIGN_IN_INPUT = "//button[@type='submit']";
	private static final String INPUT_PASSWORD = "//input[@type='password']";
	private static final String LOGIN_FIELD = "//input[@type='text']";
	private static final String YOUR_INBOX = "Яндекс.Паспорт";
	private static final String PASSWORD = "Qwerty123";
	private static final String LOGIN = "dmitry.shyts";
	private static final String START_URL = "https://passport.yandex.ru/auth?retpath=https%3A%2F%2Fpassport.yandex.ru%2Fprofile&noreturn=1";

	private WebDriver driver;

	@BeforeClass(description = "Start browser")
	public void startBrowser() {

		System.setProperty("webdriver.chrome.driver", "d:\\_webdriver\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@BeforeClass(dependsOnMethods = "startBrowser", description = "Add implicite wait and maximize window")
	public void addImplicitly() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(START_URL);
		driver.manage().window().maximize();
	}

	@Test(description = "Login to Yandex account")
	public void loginToYandex() {
		doLogin(LOGIN, PASSWORD);

		Assert.assertEquals("Яндекс.Паспорт",driver.getTitle(), "Login unsuccessful");
	}

	@AfterClass(description = "Stop Browser")
	public void stopBrowser() {
		driver.quit();
	}

	private void doLogin(String login, String password) {

		// Find the "button" input element by link text
		driver.findElement(By.xpath("//button[@type='submit']")).click();


		WebElement loginInput = driver.findElement(By.xpath(LOGIN_FIELD));
		loginInput.clear();
		loginInput.sendKeys(login);


		WebElement passwordInput = driver.findElement(By.xpath(INPUT_PASSWORD));
		passwordInput.clear();
		passwordInput.sendKeys(password);


		driver.findElement(By.xpath(SIGN_IN_INPUT)).click();
	}

	public static String getYourInbox() {
		return YOUR_INBOX;
	}

}
