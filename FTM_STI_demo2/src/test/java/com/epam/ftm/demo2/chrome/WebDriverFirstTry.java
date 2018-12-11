package com.epam.ftm.demo2.chrome;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverFirstTry {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		// initialize WebDriver for Chrome. Please mind webdriver, chromedriver
		// version and chrome browser versions.
		// works for webdriver v3.14, chromedriver v2.44, chrome browser
		// v70
		
		
		// Draft version for training goals, please avoid local paths in properties,
		// setup repo environmental paths
		// or internal eclipse paths
		System.setProperty("webdriver.chrome.driver", "d:\\_webdriver\\chromedriver\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized"); // Maximize browser window via options, just an example
		WebDriver driver = new ChromeDriver(options);

		// Open web page for moving through demo steps
		driver.get("https://github.com/");

		// setting standard timeout
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Maximize browser window
		driver.manage().window().maximize();


		// Find the "button" input element by link text
		WebElement signIn = driver.findElement(By.linkText("Sign in"));
		signIn.click();
		
		// Explicit wait for a certain element state, use this for most cases to
		// synchronize and stabilize the test execution. Look into @ExpectedConditions class
		// for more specific states and options
		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.id("login_field")));
		
		
	/*	// Thread.sleep(3000)- the worst approach, just an example of anti-pattern. 
		// Don't use in production cases. Explicit waiter as above is to be used instead.
		// Try to comment out Thread.sleep block, substituting it with Explicit wait
		// for the relevant specific element to change the speed of scenario 
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
		
		// Find the text input element by "id" attribute with a certain value
		// and type the user name there
		driver.findElement(By.id("login_field")).sendKeys("ftm2016q4");

		// Find the text input element by xpath expression and type the password
		// there
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("ftm2016q4_!");
		
		// Explicit wait for a certain element state, use this for most cases to synchronize
		// and stabilize the test execution. Look into @ExpectedConditions class 
		// for more specific states and options 
		new WebDriverWait(driver, 10)
		.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='submit']")));

		
		// Now submit the form. WebDriver will find the form for us from the
		// element. 
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		


		// Print out the title of the last opened page
		System.out.println("Page title is: " + driver.getTitle());
		System.out.println(String.format("Login to '%s' was successfull!", driver.getTitle()));

		// Close browser window and terminate WebDriver
		driver.close();
	}

}
