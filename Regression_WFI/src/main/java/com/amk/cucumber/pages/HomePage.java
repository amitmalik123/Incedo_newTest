package com.amk.cucumber.pages;

import org.openqa.selenium.By;

import com.amk.cucumber.utility.CommonMethods;
import com.amk.cucumber.utility.SeleniumCore;

public class HomePage extends CommonMethods {

	// Static Data
	private static final String PAGE_NAME = "HOME PAGE";

	private final By logout = By.xpath("//a[text()='Logout']");
	private final By switchIDLink = By.xpath("//a[text()='Switch ID']");

	/**
	 * To construct the Home Page
	 *
	 * @param seleniumCore
	 */
	public HomePage(SeleniumCore seleniumCore) {
		this(seleniumCore, true);
	}

	/**
	 * To construct the Home Page
	 *
	 * @param seleniumCore
	 * @param pageVerification - Flag to check if the page is loaded or not
	 */
	public HomePage(SeleniumCore seleniumCore, boolean pageVerification) {
		super(seleniumCore);
		if (pageVerification) {
			// boolean isVisible = seleniumCore.doesUrlContainText("dashboard", 10, 1);

			/*
			 * if (seleniumCore.isElementVisible(By.
			 * xpath("//button[text()='Confirm My Choices']"), 2, 1)) {
			 * seleniumCore.getDriver().switchTo().activeElement();
			 * seleniumCore.findElement(By.xpath("//button[text()='Confirm My Choices']")).
			 * click(); } if
			 * (seleniumCore.isElementVisible(By.cssSelector("[title='Home']"), 3, 1)) {
			 * seleniumCore.click(By.cssSelector("button[id*='button']"));
			 * seleniumCore.click(By.xpath("//*[text()='Classic Homepage']"));
			 * seleniumCore.doesUrlContainText("ewealthmanager", 10, 1);
			 * 
			 * seleniumCore.click(By.cssSelector("[class='selected']"));
			 * seleniumCore.click(By.xpath("//*[text()='Set as Default']"));
			 * 
			 * }
			 */

			if (seleniumCore.doesUrlContainText("dashboard", 10, 1)
					|| seleniumCore.doesUrlContainText("ewealthmanager", 10, 1)) {
				logger.info(PAGE_NAME + " verification" + "," + PAGE_NAME + " verification is PASSED");
			} else {
				throw new RuntimeException(PAGE_NAME + " verification is FAILED");
			}
		}
	}

	public LookUpPage clickSwitchID(String stepName, String logMessage) {
		this.seleniumCore.waitForElementToBeClickable(switchIDLink, 60, 1);
		this.seleniumCore.jsClick(seleniumCore.findElement(switchIDLink), stepName, logMessage);
		return new LookUpPage(seleniumCore);
	}

}
