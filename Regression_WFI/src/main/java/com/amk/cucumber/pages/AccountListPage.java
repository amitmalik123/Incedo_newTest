package com.amk.cucumber.pages;

import org.openqa.selenium.By;

import com.amk.cucumber.instantiator.Instantiator;
import com.amk.cucumber.utility.CommonMethods;
import com.amk.cucumber.utility.SeleniumCore;

public class AccountListPage extends CommonMethods implements Instantiator<AccountListPage> {
	// Static Data
	private static final String PAGE_NAME = "ACCOUNT LIST PAGE (Clients)";

	// Navigation
	private final By accountListTab = By.xpath("//span[text()='Account List']/parent::li");
	private final By accountListGrid = By.xpath("//table[@id='AccountListGrid']");
	private final By goBtn = By.xpath("//button[@id='searchbutton']");
	private final By clientSearchInput = By.xpath("//*[@id='client_search_input']");

	@Override
	public AccountListPage getInstance() {
		return new AccountListPage(seleniumCore);
	}

	public AccountListPage(SeleniumCore seleniumCore) {
		this(seleniumCore, true);
	}

	public AccountListPage(SeleniumCore seleniumCore, boolean pageVerification) {
		super(seleniumCore);
		waitForSpinnerToBeDisappear();
		waitForAllLoadingImagesToBeDisappear();
		if (pageVerification) {
			boolean isGrid = seleniumCore.isElementVisible(accountListGrid, 20, 1);
			boolean isClientListTab = isElementHasClass(accountListTab, "selected");
			boolean isGOBtnClickable = seleniumCore.isElementVisible(goBtn, 5, 1);

			if (isClientListTab && isGrid && isGOBtnClickable) {
				logger.info(PAGE_NAME + " verification" + SEPARATOR + PAGE_NAME + " verification is PASSED");
			} else {
				logger.warn(PAGE_NAME + " verification" + SEPARATOR + PAGE_NAME + " verification is FAILED");
			}
		}
	}

	public void enterNameInTableSearchBox(String accountNo) {
		logger.info("the account number used is :: " + accountNo);
		this.waitForAllLoadingImagesToBeDisappear();
		this.seleniumCore.sendKeys(clientSearchInput, accountNo, "Entering Client Account No ", accountNo);
		customLogger("Searched for Client with account number: ", accountNo);
	}

	public <T> T clickGo(Instantiator<T> clazz) {
		this.seleniumCore.click(goBtn, "Click GO to search clients ", "Clicked GO");		
		waitForSpinnerToBeDisappear();
		waitForAllLoadingImagesToBeDisappear();
		waitForUILoading(1000);
		return clazz.getInstance();
	}
	
	public HoldingsSummaryPage clickOnSearchedAccount(String accountNo) {
		final By accountNumber = By.xpath("//table[@id='AccountListGrid']//td[text()='" + accountNo + "']");
			this.seleniumCore.click(accountNumber, "Clicking on Searched Account", "Clicked");
			customLogger("Clicked on searched account detail ",accountNo);
			return new HoldingsSummaryPage(seleniumCore);
	}


}
