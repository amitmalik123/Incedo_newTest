package com.amk.cucumber.pages;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.amk.cucumber.constants.Constants;
import com.amk.cucumber.exceptions.DefaultException;
import com.amk.cucumber.utility.SeleniumCore;

public class NAACoachPage extends BawBasePage {

	// Static Data
	private static final String PAGE_NAME = "NAA COACH PAGE";

	// Page Locators
	private static final By addWorkItemButton = By.xpath("//button[@value='Add WorkItem']");
	private final By nNumber = By.xpath("//*[text()='New Account Paperwork Submission']");
	private final By childBNumber = By.xpath("//*[text()='New Account Application']/parent::td/preceding-sibling::td/a");
	private final By cip = By.xpath("//h3[contains(text(),'CIP')]");	
	private final By cipSelect = By.xpath("(//select)[2][@class='form-control']");	
	private final By saveClientData = By.xpath("//button[@value='Save Client Data']");	
	private final By workitemHeading = By.xpath("//h3[contains(text(),'Work Items for')]");	
		
	private final By activationSection = By.xpath("(//div[@class='container-fluid']//h3[@class='panel-title'])[last()]");	
	private final By ampSOPCompleted = By.xpath("//b[text()=' AMP SOP Completed ']/preceding-sibling::input");	
	private final By activateAccounts = By.xpath("//button[contains(text(),'Activate Accounts')]");	
	private final By approvalAlert = By.xpath("//*[@role= 'alert'     and   contains(text(),'approved by BD')]");	
	private final By accA = By.xpath("//*[contains(@class,'label-info')][1]   |   //*[contains(@class,'label-success')][1]");	
	private final By betaA = By.xpath("//*[contains(@class,'label-info')][1]/../following-sibling::td/font    |    //*[contains(@class,'label-success')][1]/../following-sibling::td/font");
	private final By bNumberWorkItem = By.xpath("//table[@id='workItemTable']");
	private final By addNewWorkItem = By.xpath("//*[text()='Add New Work Item']/input");
	private final By addWorkItemType = By.cssSelector("#addWorkItemType");
	private final By addWorkItem = By.cssSelector("#AddWIModalLabel");
	private final By addWorkItemSaveButton = By.cssSelector("button[value='Add WorkItem Save']");
	private final By saveRefreshButton = By.cssSelector("button[value='Save and Refresh']");
	private final By saveExitButton = By.cssSelector("button[value='Save and Exit']");
	private final By editAppButton = By.cssSelector("button[value*='View/Edit App Data -']");
	private final By editAppModal = By.cssSelector("#EditAppModalLabel");
	private final By powerAttorneyButton = By.cssSelector("[value='Add Power of Attorney']");
	private final By powerAttorneyFirstName = By.xpath("//*[@class='has-error']//input[@name='ACCFIRSTNAME']");
	private final By powerAttorneyLastName = By.xpath("//*[@class='has-error']//input[@name='ACCLASTNAME']");
	private final By investmentSummary = By.cssSelector("table#investmentSummaryTable input[disabled]");
	private final By powerAttorneyDoB = By.xpath("//*[contains(@class,'has-error')]//input[@name='DATEOFBIRTH']");
	private final By powerAttorneySaveCloseButton = By.xpath("//button[@name='SAVEANDCLOSEEDITAPPDATA']");
	private final By addedFeature = By.xpath("//h4[./*[text()='Customers and Associated Parties']]/following-sibling::div");
	private final By legalAddress1 = By.xpath("//div[@data-uspsaddresstype='LEGAL']//input[@name='USPSLEGALADDRESS1']");
	private final By legalCity = By.xpath("//div[@data-uspsaddresstype='LEGAL']//input[@name='USPSLEGALCITY']");
	private final By legalState = By.xpath("//div[@data-uspsaddresstype='LEGAL']//input[@name='USPSLEGALSTATE']");
	private final By legalZip = By.xpath("//div[@data-uspsaddresstype='LEGAL']//input[@name='USPSLEGALZIPCODE']");
	private final By clientName = By.xpath("//div[@id='Client-body']//input[@name='CLIENTNAME']");
	private final By clientAddress1 = By.xpath("//div[@id='Client-body']//input[@name='USPSADDRESS1']");
	private final By clientCity = By.xpath("//div[@id='Client-body']//input[@name='USPSCITY']");
	private final By clientState = By.xpath("//div[@id='Client-body']//input[@name='USPSSTATE']");
	private final By clientZip = By.xpath("//div[@id='Client-body']//input[@name='USPSZIP']");
	private final By statementName = By.xpath("//div[contains(@class,'aFormUSPSData')]//input[@name='ACCFIRSTNAME']");
	private final By statementAddress1 = By.xpath("//div[contains(@class,'aFormUSPSData')]//input[@name='USPSADDRESS1']");
	private final By statementCity = By.xpath("//div[contains(@class,'aFormUSPSData')]//input[@name='USPSCITY']");
	private final By statementState = By.xpath("//div[contains(@class,'aFormUSPSData')]//input[@name='USPSSTATE']");
	private final By statementZip = By.xpath("//div[contains(@class,'aFormUSPSData')]//input[@name='USPSZIP']");
	private final By workItemHeader = By.xpath("//h5[contains(text(),'Work Item')]/b");

	public NAACoachPage(SeleniumCore seleniumCore) {
		this(seleniumCore, true);
	}

	public NAACoachPage(SeleniumCore seleniumCore, boolean pageVerification) {
		super(seleniumCore);
		if (pageVerification) {
			waitForLoadingData();
			waitForSpinnerToBeDisappear();
			if (seleniumCore.isElementVisible(By.xpath("//*[contains(text(),'Advisor:')]"),60,1)) {
				logger.info(PAGE_NAME + " verification" + " : " + PAGE_NAME + " verification is PASSED");
			} else {
				logger.warn(PAGE_NAME + " verification" + " : " + PAGE_NAME + " verification is FAILED");
			}
		}
	}

	public void validateNNumber() {
		seleniumCore.waitForJStoLoad();
		seleniumCore.waitForElementToBeVisible(nNumber, 30, 1);	
		seleniumCore.scrollIntoView(seleniumCore.findElement(nNumber));
		Assert.assertTrue("N number is not adopted under parent ",seleniumCore.isElementVisible(nNumber,20,1));
		logger.info("N number is adopted under parent ");		
		customLogger("N number is adopted under parent ", "");
	}
	
	public String validateChildBNumber() {
		return seleniumCore.getText(childBNumber);
	}
	
	public void selectCIPAndSaveClient(String option) {	
		seleniumCore.waitForElementToBeVisible(cip, 20, 1);	
		seleniumCore.scrollIntoView(seleniumCore.getDriver().findElement(cip));
		List<WebElement> elements = seleniumCore.findElements(By.xpath("//table[@id='cipTable']//tbody/tr"));			
		for(int i=1; i<=elements.size();i++) {
			seleniumCore.selectByVisibleText(By.xpath("//table[@id='cipTable']//tbody/tr["+i+"]/td//select"), option);
			seleniumCore.waitForUILoading(500);
		}			
		customLogger("select CIP value ", option);	
		logger.info("select CIP value as " + option);	
		seleniumCore.click(saveClientData);	
		customLogger("click on save client button", "");	
		logger.info("click on save client button");	
		seleniumCore.waitForJStoLoad();	
		waitForLoadingData();	
		waitForSpinnerToBeDisappear();
	}	
		
	public void clickOpenButton(String workType) {	
		
		By parentWorkitem = By.xpath("//td[./span[text()='"+workType+"']]/following-sibling::td/button[contains(text(),'Open')]");
		
		seleniumCore.waitForElementToBeVisible(workitemHeading, 60, 1);	
		seleniumCore.scrollIntoView(seleniumCore.getDriver().findElement(workitemHeading));	
		seleniumCore.waitForElementToBeClickable(parentWorkitem, 20, 1);	
		clickRunButton(seleniumCore.getDriver().findElement(parentWorkitem));	
		customLogger("click on open button", "");	
		logger.info("click on open button");
		seleniumCore.waitForJStoLoad();	
		waitForLoadingData();
		switchTab("Shell Process");
		seleniumCore.waitForJStoLoad();					
		try {
			seleniumCore.handleAlert("OK");		
		}catch(Exception e) {				
			logger.info("action click");
		}		
	}	
		
	public void clickEditAppDataButton() {	
		seleniumCore.waitForJStoLoad();				
		waitForLoadingData();	
		seleniumCore.scrollIntoView(seleniumCore.getDriver().findElement(By.xpath("//*[text()='Registration Status']")));
		seleniumCore.waitForElementToBeVisible(editAppButton, 30, 1);
		seleniumCore.waitForElementToBeClickable(editAppButton, 20, 1).click();
		customLogger("click on edit app data button", "");	
		logger.info("click on edit app data button");		
		seleniumCore.waitForJStoLoad();				
		waitForLoadingData();	
	}
	
	public void addNewFeature() {	
		seleniumCore.waitForElementToBeVisible(editAppModal, 30, 1);	
		seleniumCore.scrollIntoView(seleniumCore.getDriver().findElement(powerAttorneyButton));
		seleniumCore.waitForElementToBeClickable(powerAttorneyButton, 20, 1).click();
		customLogger("click on add power of attorney button", "");	
		logger.info("click on add power of attorney button");		
		seleniumCore.waitForJStoLoad();				
		waitForLoadingData();	
		seleniumCore.sendKeys(powerAttorneyFirstName, "abc");
		seleniumCore.sendKeys(powerAttorneyLastName, "def");
		seleniumCore.sendKeys(powerAttorneyDoB, "01011990");
		seleniumCore.tabOut();
		seleniumCore.click(powerAttorneySaveCloseButton);
		customLogger("click on save and close button to add power of attorney", "");	
		logger.info("click on save and close button to add power of attorney");	
		seleniumCore.waitForJStoLoad();				
		waitForLoadingData();	
	}
	
	public String validateNewAddedFeature() {
		seleniumCore.waitForElementToBeVisible(addedFeature, 10, 1);
		return seleniumCore.getText(addedFeature).toLowerCase();
	}
	
	public void expandActivationSection() {
		seleniumCore.waitForJStoLoad();				
		waitForLoadingData();
		seleniumCore.waitForUILoading(3000);
		seleniumCore.waitForElementToBeClickable(activationSection, 25, 1);
		seleniumCore.scrollIntoView(seleniumCore.getDriver().findElement(activationSection));
		seleniumCore.click(activationSection);
		logger.info("go to the registration section and click to expand it");
		customLogger("go to the registration section and click to expand it", "");
	}	
		
	public void activateAccounts() {
		seleniumCore.waitForJStoLoad();
		waitForLoadingData();	
		if(seleniumCore.isElementVisible(By.xpath("//div[@data-uspsaddresstype='LEGAL']//div[contains(text(),'Address Not Found')]"), 1, 1)) {
			editLegalAddress();
		}	
		if(seleniumCore.isElementVisible(By.xpath("//div[@data-dbobjecttype='AccountEntities']//div[contains(text(),'Address Not Found')]"), 1, 1)) {
			editDuplicateStatement();
			clickEditAppDataButton();
			seleniumCore.waitForElementToBeVisible(editAppModal, 30, 1);	
			seleniumCore.sendKeys(By.xpath("//div[@id='DuplicateStatement1']//input[@class='aLength30 form-control aBlank']"), "abcde");
			seleniumCore.tabOut();
			seleniumCore.click(powerAttorneySaveCloseButton);
			customLogger("click on save and close button to add power of attorney", "");	
			logger.info("click on save and close button to add power of attorney");	
			seleniumCore.waitForJStoLoad();				
			waitForLoadingData();	
			
		}
		if (seleniumCore.isElementVisible(ampSOPCompleted, 5, 1)) {
			seleniumCore.click(ampSOPCompleted);
		}
		if(seleniumCore.waitForElementToBeClickable(activateAccounts, 10, 1)==null) {
			throw new DefaultException("Activate Accounts button is not active");
		}
		seleniumCore.click(activateAccounts,"click on activate accounts button","");		
		try {
			seleniumCore.handleAlert("OK");
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		seleniumCore.waitForJStoLoad();
		waitForLoadingData();
		try {
			seleniumCore.handleAlert("OK");
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
	}
	
	public void editDuplicateStatement() {				
		seleniumCore.sendKeys(statementName, seleniumCore.getAttribute(clientName, "value")," statement and client names are same");
		seleniumCore.sendKeys(statementAddress1, seleniumCore.getAttribute(clientAddress1, "value")," statement and client address are same");
		seleniumCore.sendKeys(statementCity, seleniumCore.getAttribute(clientCity, "value")," statement and client city are same");
		seleniumCore.sendKeys(statementState, seleniumCore.getAttribute(clientState, "value")," statement and client state are same");
		seleniumCore.sendKeys(statementZip, seleniumCore.getAttribute(clientZip, "value")," statement and client zip are same");
		customLogger("updated legal address as client address", "");
	}
	
	public void editLegalAddress() {				
		seleniumCore.sendKeys(legalAddress1, seleniumCore.getAttribute(clientAddress1, "value")," legal and client address are same");
		seleniumCore.sendKeys(legalCity, seleniumCore.getAttribute(clientCity, "value")," legal and client city are same");
		seleniumCore.sendKeys(legalState, seleniumCore.getAttribute(clientState, "value")," legal and client state are same");
		seleniumCore.sendKeys(legalZip, seleniumCore.getAttribute(clientZip, "value")," legal and client zip are same");
		customLogger("updated legal address as client address", "");
	}
	
	public boolean validateApprovedAlert() {
		seleniumCore.waitForJStoLoad();
		waitForLoadingData();
		return seleniumCore.isElementVisible(approvalAlert, 20, 1);
	}
	
	public void validateAccAndBeta(String text) {
		seleniumCore.isElementVisible(accA, 20, 1);
		seleniumCore.scrollIntoView(seleniumCore.findElement(By.cssSelector("[value='Add WorkItem']")));
		Assert.assertEquals("acc is not validated", text, seleniumCore.getText(accA));
		Assert.assertEquals("beta is not validated", text, seleniumCore.getText(betaA));
	}
	
	public void validateAccStatus(String text) {
		seleniumCore.isElementVisible(accA, 20, 1);
		seleniumCore.scrollIntoView(seleniumCore.findElement(By.cssSelector("[value='Add WorkItem']")));
		Assert.assertEquals("acc is not validated", text, seleniumCore.getText(accA));		
	}

	public void validateAccountNumberAndName(Map<String, String> addAccountInfo) {
		seleniumCore.waitForElementToBeFound(bNumberWorkItem, 30, 1);
		Assert.assertTrue("added account number has not validated on NAA Coach page", seleniumCore.getText(bNumberWorkItem).contains(addAccountInfo.get("accountNumber")));
		Assert.assertTrue("added account name has not validated on NAA Coach page", seleniumCore.getText(bNumberWorkItem).contains(addAccountInfo.get("accountName")));
		customLogger("added account number and account has been validated on NAA Coach page","");
	}
	
	public void addWorkItem(String value) {
		seleniumCore.waitForJStoLoad();
		seleniumCore.waitForElementToBeFound(addWorkItemButton, 30, 1);
//		seleniumCore.scrollIntoView(seleniumCore.findElement(addWorkItemButton));
		seleniumCore.jsClick(seleniumCore.findElement(addWorkItemButton), "click on add work item button", "");
		customLogger("click on add work item button","");		
		seleniumCore.getDriver().switchTo().activeElement();
		seleniumCore.waitForElementToBeFound(addWorkItem, 30, 1);
		seleniumCore.jsClick(seleniumCore.findElement(addNewWorkItem), "click on add new work item radio button", "");
		customLogger("click on add new work item radio button","");
		seleniumCore.selectByValue(addWorkItemType, value);
		seleniumCore.click(addWorkItemSaveButton);
		waitForLoadingData();
		seleniumCore.waitForJStoLoad();
		waitForLoadingData();
	}
	
	public void clickSaveAndRefresh() {
		seleniumCore.waitForElementToBeClickable(saveRefreshButton, 30, 1);		
		seleniumCore.click(saveRefreshButton);
		seleniumCore.waitForJStoLoad();
		seleniumCore.waitForUILoading(5000);
		logger.info("click on save and refresh button");
		customLogger("click on save and refresh button","");			
	}
	
	public void clickSaveAndExit() {
		seleniumCore.waitForElementToBeClickable(saveExitButton, 30, 1);		
		seleniumCore.click(saveExitButton);
		waitForLoadingData();
		seleniumCore.waitForUILoading(7000);
		logger.info("click on save and exit button");
		customLogger("click on save and exit button","");			
	}
	
	public void validateAndOpenNewAddedWorkItem(String workItem, String page) {
		seleniumCore.waitForElementToBeFound(addWorkItemButton, 30, 1);
		By work= By.xpath("//span[text()='"+workItem+"']");
		Assert.assertTrue("new work item has not added", seleniumCore.isElementVisible(work, 10, 1));
		customLogger("new work item has been added","");
		By openButton= By.xpath("//span[text()='"+workItem+"']/../following-sibling::td/button");
		seleniumCore.jsClick(seleniumCore.findElement(openButton), "click on open button", "");
		seleniumCore.waitForJStoLoad();
		seleniumCore.waitForUILoading(5000);
		customLogger("click on open button of added work item","");
		switchTab(page);
	}
	
	public void validateInvestmentSection() {
		Assert.assertTrue("model in investment summary section is editable", seleniumCore.isElementVisible(investmentSummary, 10, 1));
		logger.info("model in investment summary section is non editable");
		customLogger("model in investment summary section is non enable","");
	}
	
	public String headerWorkItem() {
		String value= seleniumCore.getText(workItemHeader).trim();
		return value;
	}
}




