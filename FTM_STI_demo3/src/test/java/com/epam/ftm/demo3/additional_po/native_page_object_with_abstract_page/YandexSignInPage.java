package com.epam.ftm.demo3.additional_po.native_page_object_with_abstract_page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YandexSignInPage extends YandexAbstractPage {

	@FindBy(xpath = "//input[@type='text']")
	private WebElement loginInput;

	@FindBy(xpath = "//input[@type='password']")
	private WebElement pwdInput;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement signInBtn;

	public YandexSignInPage(WebDriver driver) {
		super (driver);
	}

	public YandexAccountPage loginToYandex(String login, String password) {
		// Clear text input element created by "id" attribute with a certain
		// value and type the user name there
		System.out.println("Typing user login: " + login);
		loginInput.clear();
		loginInput.sendKeys(login);

		// Clear text input element created by xpath expression and type the
		// password there
		System.out.println("Typing user password: " + password);
		pwdInput.clear();
		pwdInput.sendKeys(password);

		// Click element created by xpath expression and type the password there
		signInBtn.click();
		System.out.println("Login is in progress...");
		
		return new YandexAccountPage(driver);

	}

}
