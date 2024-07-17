package com.amk.cucumber.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.amk.cucumber.exceptions.DefaultException;
import com.amk.cucumber.utility.SeleniumCore;

public class CheckContributionsPage extends BawBasePage {

	private static final String PAGE_NAME = "Check Distributions Page";

	private final By saveCloseButton = By.cssSelector("button[id*='SaveAndClose']");
	private final By checkType =By.cssSelector("select[id*='CheckType']");
	private final By alphaAmount =By.cssSelector("input[id*='Alpha_Amount']");
	private final By numericalAmount =By.cssSelector("input[id*='Numerical_Amount']");
	private final By checkDate =By.cssSelector("input[id*='Check_Date']");
	private final By checkNumber =By.cssSelector("input[id*='CheckNumber']");
	private final By abaRoutingNumber =By.cssSelector("input[id*='ABARoutingNumber']");
	private final By bankAccount =By.cssSelector("input[id*='BankAccountNumber']");
	private final By allocationAccountNumber =By.cssSelector("select[id*='Allocation_AccountNumber']");
	private final By allocationAmount =By.cssSelector("input[id*='AllocationAmount']");
	private final By transactionDescription =By.cssSelector("select[id*='TransactionDescription']");
	private final By addButton =By.cssSelector("button[id*='AddEditAllocationButton']");
	private final By addAllocation =By.xpath("//table[@class='table table-condensed']/tbody/tr/td");
	private final By imageType =By.cssSelector("select[id*='ImageType']");
	private final By iwrCompleteButton =By.cssSelector("button[id*='IWRCompleteButton']");
	private final By modalCheckbox =By.cssSelector("input[id*='WarningCheckboxes']");
	private final By modalProceedButton =By.cssSelector("button[id*='ProceedTaskCompleteButton']");
	private final By qcPasseddButton =By.cssSelector("[id*='QCPassedButton']");
	
	String parentWindow;
	boolean isDisplay;
	
	public CheckContributionsPage(SeleniumCore seleniumCore) {
		this(seleniumCore, true);
	}

	public CheckContributionsPage(SeleniumCore seleniumCore, boolean pageVerification) {
		super(seleniumCore);
		if (pageVerification) {
			seleniumCore.frameAvailableAndSwitchToIt(By.cssSelector("iframe[title='Coach']"),80,1);
			boolean isVisible = seleniumCore.isElementVisible(alphaAmount, 30,1);
			seleniumCore.getDriver().manage().window().maximize();
			if (isVisible) {
				logger.info(PAGE_NAME + " verification"+SEPARATOR+ PAGE_NAME + " verification is PASSED");
			} else {
				logger.warn(PAGE_NAME + " verification"+SEPARATOR+ PAGE_NAME + " verification is FAILED");
			}
		}
	}	
	
	public void enterCheckDetails(String amount, String numbers) {	
		String[] number= numbers.split(",");
		seleniumCore.waitForJStoLoad();
		waitForLoadingData();
		seleniumCore.waitForElementToBeVisible(alphaAmount, 40, 1);
		seleniumCore.selectByVisibleText(checkType, number[2]);	
		customLogger("select check type ", number[2]);
		seleniumCore.waitForJStoLoad();
		waitForLoadingData();
		seleniumCore.waitForElementToBeClickable(alphaAmount, 40, 1).click();		
		seleniumCore.sendKeys(alphaAmount, amount);
		seleniumCore.tabOut();
		customLogger("enter alpha amount ", amount);
		waitForSpinnerToClose();
		seleniumCore.sendKeys(numericalAmount, amount);
		customLogger("enter numerical amount ", amount);
		seleniumCore.sendKeys(checkDate, dateUtil.dateFormat(2));
		customLogger("enter check date ", "");
		seleniumCore.sendKeys(checkNumber, number[0]);
		customLogger("enter check number ", number[0]);
		seleniumCore.sendKeys(bankAccount, number[0]);	
		seleniumCore.tabOut();
		customLogger("enter bank account ", number[0]);
		waitForSpinnerToClose();
		seleniumCore.sendKeys(abaRoutingNumber, number[1]);
		seleniumCore.tabOut();
		seleniumCore.waitForJStoLoad();
		waitForLoadingData();
		waitForSpinnerToClose();	
		if(seleniumCore.isElementVisible(By.xpath("//*[text()='Unable to verify ABA.']"),3,1)) {
			seleniumCore.sendKeys(abaRoutingNumber, "011002343","enter aba routing number","",2,1);
			seleniumCore.tabOut();
		}
		if(seleniumCore.isElementVisible(By.xpath("//*[contains(text(),'Please enter valid ABA']"),3,1)) {
			throw new DefaultException("ABA number is not valid, please enter valid value");
		}
		customLogger("enter aba routing number", number[1]);
		waitForSpinnerToClose();		
	}
	
	public void enterAllocationDetails() {
		seleniumCore.waitForElementToBeVisible(allocationAccountNumber, 10, 1);
		seleniumCore.selectByIndex(allocationAccountNumber, 2, "select allocation account", "", 5, 1);
		customLogger("select allocation account ", "");
		seleniumCore.waitForJStoLoad();
		waitForLoadingData();
		waitForSpinnerToClose();
		seleniumCore.sendKeys(allocationAmount, "100");
		seleniumCore.tabOut();
		customLogger("enter allocation account ", "");	
		if(seleniumCore.getAttribute(transactionDescription, "disabled")==null) {
		  seleniumCore.selectByIndex(transactionDescription, 2, "select transaction description", "", 5, 1); 
		  customLogger("select transaction description ", "");
		}
		seleniumCore.scrollIntoView(seleniumCore.findElement(addButton));
		seleniumCore.click(addButton);
		customLogger("click add button ", "");
		seleniumCore.waitForJStoLoad();
		waitForLoadingData();
		waitForSpinnerToClose();
	}
	
	public int validateAllocatedDetails() {
		List<WebElement> elements=seleniumCore.findElements(addAllocation);
		return elements.size();
	}
	
	public void clickSaveCloseButton() {
		seleniumCore.click(saveCloseButton);	
		customLogger("click on save and close button ", "");	
	}
	
	public void selectImageTypeAndClickIWRComplete() {
		seleniumCore.waitForElementToBeVisible(imageType, 10, 1);
		seleniumCore.selectByVisibleText(imageType, "Check Front and Back");		
		customLogger("select image type", "Check Front and Back");
		seleniumCore.click(iwrCompleteButton);
		customLogger("click on iwr complete button ", "");	
		handleModal();		
	}
	
	public void handleModal() {
		if (seleniumCore.isElementVisible(modalProceedButton, 10, 1)) {
			List<WebElement> elements=seleniumCore.findElements(By.cssSelector("input[id*=PopupCheckboxesGroup]"));
			elements.stream().forEach(e-> e.click());			
			seleniumCore.click(modalProceedButton, "click on proceed button", "");
			customLogger("click on modal proceed button", "");
			seleniumCore.waitForUILoading(5000);
			switchTab("Shell Process");
		}
	}
	
	public void waitForSpinnerToClose() {
		seleniumCore.waitForElementToBeInVisible(By.cssSelector("div[class='Coach_ProgressIcon_show'] >img"), 30, 1);
	//	seleniumCore.waitForElementToBeVisible(By.cssSelector("div[class='Coach_ProgressIcon_hide'] >img"), 30, 1);
	}
	
	public void clickQCPassed() {
		seleniumCore.waitForElementToBeClickable(qcPasseddButton, 20, 1);
		seleniumCore.click(qcPasseddButton);
		customLogger("click on qc passed button", "");
		handleModal();		
	}
}
