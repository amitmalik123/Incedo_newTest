package com.amk.cucumber.pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.amk.cucumber.exceptions.DefaultException;
import com.amk.cucumber.utility.SeleniumCore;

public class JournalUtilityPage extends BawBasePage {

	private static final String PAGE_NAME = "Journal Utility Page";

	private final By saveCloseButton = By.cssSelector("button[id$=SaveClose]");
	private final By frame = By.cssSelector("iframe[title='Coach']");
	private final By destinationAccount = By.cssSelector("select[id='singleselect-JournalCV1:DestinationManageAccountNumber']");	
	private final By unit = By.cssSelector("select[id='singleselect-JournalCV1:Unit']");
	private final By addJournal = By.cssSelector("button[id='button-button-JournalCV1:AddJournal']");
	private final By pendingJournal = By.xpath("//table[.//th[@aria-label='Dest Acct Name']]");
	private final By amount = By.cssSelector("input[id='text-input-JournalCV1:UnitSectionAmount']");

	public JournalUtilityPage(SeleniumCore seleniumCore) {
		this(seleniumCore, true);
	}

	public JournalUtilityPage(SeleniumCore seleniumCore, boolean pageVerification) {
		super(seleniumCore);
		if (pageVerification) {
			seleniumCore.frameAvailableAndSwitchToIt(frame, 10, 1);
			boolean isVisible = seleniumCore.isElementVisible(destinationAccount);
			if (isVisible) {
				logger.info(PAGE_NAME + " verification"+SEPARATOR+ PAGE_NAME + " verification is PASSED");
			} else {
				logger.warn(PAGE_NAME + " verification"+SEPARATOR+ PAGE_NAME + " verification is FAILED");
			}
		}
	}			
	
	public void switchToFrame() {
		this.seleniumCore.waitForElementToBeVisible(frame);
		this.seleniumCore.getDriver().switchTo().frame(this.seleniumCore.getDriver().findElement(frame));
	}
	
	public void clickSaveCloseButton(String page) {
		seleniumCore.waitForElementToBeClickable(saveCloseButton, 20, 1);
		seleniumCore.click(saveCloseButton);
		seleniumCore.waitForJStoLoad();		
		waitForLoadingData();
		if (seleniumCore.doesTitleContainText("Journal utility", 3, 1)) {
			seleniumCore.handleAlert("OK");
			throw new DefaultException("getting an alert");
		}
		logger.info("clicked on save & close button ");
		customLogger("clicked on save & close button ", "");
		seleniumCore.waitForJStoLoad();
		waitForLoadingData();
		seleniumCore.numberOfWindows(2);
		seleniumCore.getDriver().switchTo().window(page);			
		try {
			seleniumCore.handleAlert("OK");
			seleniumCore.waitForJStoLoad();
			waitForLoadingData();
		} catch (Exception e) {
			logger.info(e.getLocalizedMessage());
		}
		logger.info("successfully clicked on OK button ");
	}	
	
	public void selectDestinationAccount() {	
		seleniumCore.waitForJStoLoad();	
		waitForLoadingData();	
		seleniumCore.waitUntilElementToBeClickable(destinationAccount, 10, 1);	
		seleniumCore.selectByIndex(destinationAccount, 3, "click on destination field ","selecting destination account ", 10, 1);	
		customLogger("selecting destination account ", "");	
		seleniumCore.waitForJStoLoad();	
		waitForLoadingData();
	}	
		
	public void selectUnit(String value) {	
		seleniumCore.waitForJStoLoad();	
		waitForLoadingData();
		seleniumCore.waitUntilElementToBeClickable(unit, 10, 1);	
		seleniumCore.selectByIndex(unit, 3, "click on unit field ", "selecting unit percentage ", 10, 1);	
		seleniumCore.waitForJStoLoad();	
		waitForLoadingData();	
		seleniumCore.waitForElementToBeClickable(amount, 30, 1);
		seleniumCore.click(amount);
		seleniumCore.sendKeys(amount, value);		
		seleniumCore.tabOut();	
		customLogger("selecting unit percentage and enter amount", value);	
	}	
		
	public void clickAddJournalButton() {	
		WebElement addnUpdateButton = searchWebElement(addJournal);	
		seleniumCore.waitForUILoading(1000);	
		seleniumCore.jsClick(addnUpdateButton, "", " click on add journal button");	
		customLogger("clicked on add journal button ", "");	
	}	
		
	public void validateAddedJournal() {		
		seleniumCore.waitForJStoLoad();	
		seleniumCore.waitForUILoading(2000);	
		List<WebElement> pendingJournal= seleniumCore.findElements(By.xpath("//table[.//th[@aria-label='Dest Acct Name']]//tbody//td"));	
		Assert.assertTrue("added journal is not present", pendingJournal.size()>=1);			
		customLogger("added journal has been validated ", "");	
	}
}
