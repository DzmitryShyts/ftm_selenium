package com.epam.ftm.demo3.additional_po.native_page_object_with_abstract_page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YandexAccountPage extends YandexAbstractPage {

	@FindBy(xpath = "//span[@class='user-account__name user-account__name_hasAccentLetter']")
	private WebElement yourAccountLabel;

	public YandexAccountPage(WebDriver driver) {
		super(driver);
	}

	// Method to ensure that the core/mandatory control for the page is
	// displayed
	public boolean loginIsCorrect() {
		return yourAccountLabel.isDisplayed();

	}

}
