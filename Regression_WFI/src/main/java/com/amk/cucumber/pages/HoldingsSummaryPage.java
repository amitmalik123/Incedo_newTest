package com.amk.cucumber.pages;

import org.openqa.selenium.By;

import com.amk.cucumber.instantiator.Instantiator;
import com.amk.cucumber.utility.CommonMethods;
import com.amk.cucumber.utility.SeleniumCore;

public class HoldingsSummaryPage extends CommonMethods implements Instantiator<HoldingsSummaryPage> {

	// Static Data
	private static final String PAGE_NAME = "HOLDINGS SUMMARY PAGE (ACCOUNT DETAIL)";

	// Page Locators	
	private final By accountWizardBtn = By.xpath("//a[@id='clientDetailAccountDetailAnchor']");

	@Override
	public HoldingsSummaryPage getInstance() {
		return new HoldingsSummaryPage(seleniumCore);
	}

	public HoldingsSummaryPage(SeleniumCore seleniumCore) {
		this(seleniumCore, true);
	}

	public HoldingsSummaryPage(SeleniumCore seleniumCore, boolean pageVerification) {
		super(seleniumCore);
		waitForSpinnerToBeDisappear();
		if (pageVerification) {
			boolean isButtonVisible = seleniumCore.isElementVisible(accountWizardBtn, 20, 1);		
			waitForSpinnerToBeDisappear();
			if (isButtonVisible) {
				logger.info(PAGE_NAME + " verification" + SEPARATOR + PAGE_NAME + " verification is PASSED");
			} else {
				logger.warn(PAGE_NAME + " verification" + SEPARATOR + PAGE_NAME + " verification is FAILED");
			}
		}
	}

	public AccountWizardPage clickAccountWizardTab() {
		this.seleniumCore.click(accountWizardBtn, PAGE_NAME, "Clicking on the account wizard button");
		customLogger("Clicked on the account wizard button", "");
		return new AccountWizardPage(seleniumCore);
	}
}
