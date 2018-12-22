package com.epam.ftm.demo3.additional_po.native_page_object_with_abstract_page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YandexHomePage extends YandexAbstractPage {

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement signInBtn;

	public YandexHomePage(WebDriver driver) {
		super(driver);
	}

	public YandexSignInPage openSignInPage() {
		// click the "button" input element created by link text
		signInBtn.click();
		System.out.println("Navigating to signin page...");
		return new YandexSignInPage(driver);
	}
}
