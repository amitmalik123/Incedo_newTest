package com.amk.cucumber.pages;

import org.openqa.selenium.By;

import com.amk.cucumber.utility.SeleniumCore;

public class BawLoginPage extends BawBasePage {

	private static final String PAGE_NAME = "BAW LOGIN PAGE";
	private static final String SEPARATOR = ":";
	protected By usernameTextField = By.id("username");
	protected By passwordTextField = By.id("password");
	protected By signInButton = By.xpath("//form[@id='signInForm']/a[@href='javascript:submitForm();']");

	public BawLoginPage(SeleniumCore seleniumCore) {
		this(seleniumCore, true);
	}

	public BawLoginPage(SeleniumCore seleniumCore, boolean pageVerification) {
		super(seleniumCore);
		if (pageVerification) {
			boolean isVisible = seleniumCore.isElementVisible(usernameTextField);
			if (isVisible) {
				logger.info(PAGE_NAME + " verification"+SEPARATOR+ PAGE_NAME + " verification is PASSED");
			} else {
				logger.warn(PAGE_NAME + " verification"+SEPARATOR+ PAGE_NAME + " verification is FAILED");
			}
		}
	}

	public void enterUsername(String username, String stepName, String logMessage) {		
		this.seleniumCore.waitForElementToBeVisible(usernameTextField,20,1);
		this.seleniumCore.sendKeys(usernameTextField, username, stepName, logMessage);
	}

	public void enterPassword(String password, String stepName, String logMessage) {
		this.seleniumCore.waitForElementToBeVisible(passwordTextField,20,1);
		this.seleniumCore.sendKeys(passwordTextField, password, false, stepName, logMessage);
	}

	public void clickSignin(String stepName, String logMessage) {
		this.seleniumCore.waitForElementToBeVisible(signInButton,20,1);
		this.seleniumCore.click(signInButton, stepName, logMessage);
	}

	public BawHomePage login(String username, String password, String stepName) {
		this.enterUsername(username, stepName, PAGE_NAME + ": Entering username - " + username);
		customLogger(" Entering username - ", username);
		this.enterPassword(password, stepName, PAGE_NAME + ": Entering password ");
		customLogger(" Entering password ", "");
		this.clickSignin(stepName, PAGE_NAME + ": Clicking on Signin");
		customLogger(" Clicking on Signin", "");
		return new BawHomePage(seleniumCore);
	}
}
