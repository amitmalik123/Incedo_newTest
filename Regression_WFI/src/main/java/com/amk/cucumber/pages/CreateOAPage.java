package com.amk.cucumber.pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.amk.cucumber.utility.SeleniumCore;

public class CreateOAPage extends BawBasePage {
	
	private static final String PAGE_NAME = "Create OA Page";	
	
	private final By actionType = By.cssSelector("select#OAType");
	private final By managedAcct = By.cssSelector("select#AccountId");
	private final By action = By.cssSelector("#OAActionText");
	private final By addUpdateButton = By.cssSelector("#ButtonGroup0_AddOA");
	private final By addedOA = By.cssSelector("#Table3_0");
	private final By editLink = By.xpath("//a[text()='Edit']");
	private final By cancelLink = By.xpath("//a[contains(text(),'Cancel')]");
	private final By deleteLink = By.cssSelector("a[name='delete']");
	private final By saveChangesButton = By.cssSelector("#ButtonGroup2_SaveChanges");
	private final By selectLink = By.xpath("//tr[@id='section12_Row0']//a");
	private final By accountTypeSelectModel = By.cssSelector("select#accountTypeDD");
	private final By strategistIdSelectModel = By.cssSelector("select#strategistDD");
	private final By modelCodeSelectModel = By.cssSelector("select#modelCodeDD");
	private final By saveCloseSelectModelButton = By.cssSelector("button#modelButtons_save");
	private final By spThirdParty = By.cssSelector("#spThirdParty");
	private final By thirdParty = By.cssSelector("#IsThirdPartyIMADiv");
	private final By otherManagedAccount = By.cssSelector("input#InputText0");
	
	public CreateOAPage(SeleniumCore seleniumCore) {
		this(seleniumCore, true);
	}
	
	public CreateOAPage(SeleniumCore seleniumCore, boolean pageVerification) {
		super(seleniumCore);
		if (pageVerification) {
			boolean isVisible = seleniumCore.isElementVisible(actionType);
			if (isVisible) {
				logger.info(PAGE_NAME + " verification" + SEPARATOR + PAGE_NAME + " verification is PASSED");
			} else {
				logger.warn(PAGE_NAME + " verification" + SEPARATOR + PAGE_NAME + " verification is FAILED");
			}
		}
	}
	
	public void selectManagedAcct(String value) {
		WebElement acctountmanaged = searchWebElement(managedAcct);
		seleniumCore.selectByValue(acctountmanaged, value);
		logger.info("select managed account as " + value);
		customLogger("select managed account as ", value);
	}
	
	public Object selectActionType(String value) {
		seleniumCore.waitForJStoLoad();
		seleniumCore.waitForElementToBeClickable(actionType, 20, 1);
		seleniumCore.selectByValue(actionType, value);
		seleniumCore.waitForUILoading(1000);
		logger.info("select action type to " + value);
		customLogger("select action type to", value);
		
		switch (value) {
		case "Journal":			
			switchTab(3, "journal utility to add journal");
			return new JournalUtilityPage(seleniumCore);			
		default:
			return true;
		}
	}
	
	public void enterActioTextBox(String value) {
		seleniumCore.waitForElementToBeClickable(action, 10, 1);
		seleniumCore.sendKeys(action, value, "enter action in textbox");
		seleniumCore.waitForUILoading(1000);
		seleniumCore.tabOut();		
		customLogger("enter action in textbox", "");
	}
	
	public void clickAddUpdateButton() {
		WebElement addnUpdateButton = searchWebElement(addUpdateButton);
		seleniumCore.waitForUILoading(2000);
		seleniumCore.jsClick(addnUpdateButton, PAGE_NAME, " clicked on add & update button");
		customLogger("clicked on add & update button..", "");
	}
	
	public String validateAddedOA() {
		String value = seleniumCore.getText(addedOA);
		logger.info("fetch the added OA " + value);
		customLogger("fetched the added OA value ", value);
		return value;
	}
	
	public void clickEditLink() {
		WebElement linkEdit = searchWebElement(editLink);
		seleniumCore.jsClick(linkEdit, PAGE_NAME, " click on edit link");
		customLogger("clicked on edit link..", "");
		seleniumCore.waitForJStoLoad();		
		waitForLoadingData();
	}
	
	public void clickCancelLink() {	
		seleniumCore.waitForElementToBeVisible(cancelLink, 20, 1);	
		List<WebElement> findElements = seleniumCore.findElements(cancelLink);	
		for (int i = 0; i < findElements.size(); i++) {	
			By cancel = By.xpath("//a[contains(text(),'Cancel')]");	
			seleniumCore.jsClick(seleniumCore.findElement(cancel), PAGE_NAME, " click on cancel link");	
			seleniumCore.handleAlert("OK");	
			try {	
				seleniumCore.handleAlert("OK");	
				seleniumCore.waitForJStoLoad();	
				waitForLoadingData();	
			} catch (Exception e) {	
				logger.info("no alert present");	
			}	
		}	
		customLogger("clicked on cancel link..", "");	
	}
	
	public void clickDeleteLink() {
		WebElement linkDelete = searchWebElement(deleteLink);
		seleniumCore.jsClick(linkDelete, PAGE_NAME, " click on delete link ");
		seleniumCore.handleAlert("OK");
		customLogger("clicked on delete link..", "");
	}
	
	public void clickSaveChangesButton() {
		WebElement savenChangesButton = searchWebElement(saveChangesButton);
		savenChangesButton.click();
		logger.info("clicked on the save changes button ");
		customLogger("clicked on save changes buton..", "");
	}
	
	public void clickSaveCloseButton() {			
		seleniumCore.waitForJStoLoad();			
		waitForLoadingData();	
		By saveCloseButton = By.cssSelector("#ButtonGroup1_SaveClose");	
		seleniumCore.waitForElementToBeClickable(saveCloseButton, 30, 1).click();			
		logger.info("clicked on the save & close button on create OA page");	
		customLogger("clicked on  save & close buton on create OA page", "");	
		seleniumCore.waitForJStoLoad();
		waitForLoadingData();			
	}
	
	public void validateaddedOAIsDeleted() {
		WebElement deletedOA = searchWebElement(addedOA);
		if(deletedOA==null)
			customLogger("created OA has been deleted","");		
	}
	
	public void clickSelectLink() {
		WebElement linkSelect = searchWebElement(selectLink);
		linkSelect.click();
		seleniumCore.getDriver().switchTo().activeElement();
		logger.info("clicked on select link ");
		customLogger("clicked on select link ", "");
	}
	
	public void selectModelValues(String accountType, String strategistId, String modelCode) {
		seleniumCore.waitForElementToBeClickable(accountTypeSelectModel, 10, 1);
		seleniumCore.waitForUILoading(2000);
		seleniumCore.selectByValue(accountTypeSelectModel, accountType);
		logger.info("select account type to " + accountType);
		customLogger("select account type " , accountType);
		seleniumCore.waitForUILoading(2000);
		seleniumCore.selectByValue(strategistIdSelectModel, strategistId);
		logger.info("select strategist id as " + strategistId);
		customLogger("select strategist id " ,strategistId);
		seleniumCore.waitForUILoading(1000);
		seleniumCore.selectByValue(modelCodeSelectModel, modelCode);
		logger.info("select model code as " + modelCode);
		customLogger("select model code " , modelCode);
		seleniumCore.waitForUILoading(1000);		
	}
	
	public void clickSaveCloseSelectModelButton() {
		WebElement savenCloseButton = searchWebElement(saveCloseSelectModelButton);
		savenCloseButton.click();
		logger.info("clicked on save & close button on popup");
		customLogger("clicked on save & close button on popup..", "");
	}
	
	public void selectDestination() {
		WebElement linkSelect = searchWebElement(selectLink);
		linkSelect.click();
		seleniumCore.getDriver().switchTo().activeElement();
		logger.info("clicked on select link ");
		customLogger("clicked on select link ", "");
	}
	
	public void validatePartyManager(String color) {
		seleniumCore.waitForElementToBeVisible(spThirdParty, 10, 1);
		Assert.assertTrue("3rd party manager is not visible", seleniumCore.isElementVisible(spThirdParty));
		logger.info("3rd party manager is visible");
		customLogger("3rd party manager is visible", "");
		Assert.assertTrue("3rd party manager is not highlighted", seleniumCore.getAttribute(spThirdParty, "style").contains(color));
		logger.info("3rd party manager is highlighted");
		customLogger("3rd party manager is highlighted", "");
		Assert.assertTrue("third party is not highlighted", seleniumCore.getAttribute(thirdParty, "style").contains("yellow"));
		logger.info("third party is highlighted");
		customLogger("third party is highlighted", "");
	}
	
	public void manageAccount(String account, String errorType) {
		seleniumCore.selectByVisibleText(managedAcct, "Other");
		seleniumCore.sendKeys(otherManagedAccount, account, true, "", "", 2,1);
		seleniumCore.waitForUILoading(1000);
		seleniumCore.tabOut();
		seleniumCore.waitForUILoading(1000);		
		if(errorType.equals("error")){
		seleniumCore.click(By.xpath("//div[@id='accountTable']//tbody/tr[2]/td[@class='tabledata']/input"),"","",5,1);
		seleniumCore.handleAlert("OK");
		} else {
			seleniumCore.click(By.xpath("//div[@id='accountTable']//tbody/tr[1]/td[@class='tabledata']/input"),"","",5,1);
			logger.info("no error message triggered");
			customLogger("no error message triggered", "");
		}
		waitForLoadingData();
	}
	
}
