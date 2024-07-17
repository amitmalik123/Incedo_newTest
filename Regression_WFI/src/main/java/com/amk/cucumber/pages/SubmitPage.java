package com.amk.cucumber.pages;

import org.openqa.selenium.By;

import com.amk.cucumber.utility.CommonMethods;
import com.amk.cucumber.utility.SeleniumCore;

public class SubmitPage extends CommonMethods {

	// Static Data
	private static final String PAGE_NAME = "SUBMIT PAGE";

	// Page Locators
	private static final By viewDocumentsPageLabel = By.xpath("//div[contains(@class,'submit-header')]");
	private final By submitButton = By.xpath("//a[@class='btn btn-primary submit-accounts ']");
	private final By submitText = By.cssSelector("span.icon-spacing");

	public SubmitPage(SeleniumCore seleniumCore) {
		this(seleniumCore, true);
	}

	public SubmitPage(SeleniumCore seleniumCore, boolean pageVerification) {
		super(seleniumCore);
		if (pageVerification) {
			waitForSpinnerToBeDisappear();
			if (seleniumCore.isElementVisible(viewDocumentsPageLabel)) {
				logger.info(PAGE_NAME + " verification" + " : " + PAGE_NAME + " verification is PASSED");
			} else {
				logger.warn(PAGE_NAME + " verification" + " : " + PAGE_NAME + " verification is FAILED");
			}
		}
	}

	public static By getLabel() {
		return viewDocumentsPageLabel;
	}

	/**
	 * Clicks on the first document's Separate Documents button
	 *
	 * @param stepName
	 * @param logMessage
	 */
	public void clickSubmitBtn(String stepName, String logMessage) {
		seleniumCore.waitForJStoLoad();
		waitForLoadingData();
		seleniumCore.waitForElementToBeClickable(submitButton, 10, 1);
		this.seleniumCore.click(submitButton, stepName, logMessage);
		customLogger("Successfully clicked on " + logMessage, "");
	}
	
	public String validateAccountSubmission() {
		seleniumCore.isElementVisible(submitText, 10, 1);
		return seleniumCore.getText(submitText);
	}
	
}
