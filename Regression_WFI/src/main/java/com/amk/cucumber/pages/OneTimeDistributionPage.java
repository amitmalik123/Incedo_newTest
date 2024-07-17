package com.amk.cucumber.pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.amk.cucumber.utility.SeleniumCore;

public class OneTimeDistributionPage extends BawBasePage {

	private static final String PAGE_NAME = "One Time Distribution Page";

	private final By saveCloseButton = By.cssSelector("button[id$='SaveAndClose']");	
	private final By payeeName1 = By.cssSelector("input[id='text-input-PayeeInstructionsCV:PayeeName1']");
	private final By address1 =By.cssSelector("input[id='text-input-PayeeInstructionsCV:Address1']");	
	private final By recipientType =By.cssSelector("input[id='radiogroup-item-input-OneTimeDistributionCV:RecipientType[0]']");
	private final By addPayeeInstructions =By.cssSelector("button[id='button-button-OneTimeDistributionCV:AddInstructionButton']");
	private final By city =By.cssSelector("input[id='text-input-PayeeInstructionsCV:City']");
	private final By state =By.cssSelector("input[id='text-input-PayeeInstructionsCV:State']");
	private final By zip =By.cssSelector("input[id='text-input-PayeeInstructionsCV:Zip']");
	private final By typeOfPayee =By.cssSelector("[value='SameNameAndAddress']");
	private final By sloa =By.cssSelector("[name='rbo_PayeeInstructionsCV:SLOA'][value='No']");
	private final By recommendedDate =By.cssSelector("p[id*='RecommendedDate']");
	private final By distributionDate =By.cssSelector("input[id='datetimepicker-input-OneTimeDistributionCV:DistributionDate']");	
	private final By deliveryOptions =By.cssSelector("input[id*='radiogroup-item-input-OneTimeDistributionCV:DeliveryOptions[0]']");	
	private final By chargeOvernightFee =By.cssSelector("input[id*='ChargeFee[1]']");
	private final By payeeRecord =By.cssSelector("input[id*='CheckDeliveryInstructionsTable']");
	private final By distRecord =By.xpath("//span[contains(text(),'8888 DIST record')]");
	private final By modalCheckbox =By.cssSelector("input[id*='WarningCheckboxes']");
	private final By modalProceedButton =By.cssSelector("button[id='button-button-OneTimeDistributionCV:WarningPopupProceedButton']");
	private final By calendar =By.cssSelector("[id='inputgroup-button-OneTimeDistributionCV:DistributionDateInputGroup']");
	private final By distributionReason =By.xpath("//div[@id='singleselect_OneTimeDistributionCV_DistributionReason_chosen']/a");
	private final By taxWithholding =By.cssSelector("select[id*='TaxWithholding']");
	private final By federalWithholding =By.cssSelector("select[id*='FederalWithholding']");
	private final By stateWithholding =By.cssSelector("select[id*='StateWithholding']");
	private final By federalAmount =By.cssSelector("input[id*='FederalWithholdingAmount']");
	private final By stateAmount =By.cssSelector("input[id*='StateWithholdingAmount']");
	private final By amount =By.cssSelector("input[id*='OneTimeDistributionCV:Amount'][type='text']");
	private final By addInstructionsButton =By.cssSelector("button[id*='AddInstructionButton']");
	private final By instructionTypeWire = By.cssSelector("input[value='W']");
	private final By abaRouting =By.cssSelector("input[id*='ABA']");
	private final By bankAccount =By.cssSelector("input[id*='BANK_AC_NUM']");
	private final By bankAccountName =By.cssSelector("input[id*='BANK_AC_NAME']");
	private final By ffcName =By.cssSelector("input[id*='FFC_NAME']");
	private final By ffcAcct =By.cssSelector("input[id*='FFC_NUM']");
	private final By bankName =By.cssSelector("input[id*='BANK_NAME']");
	private final By saveCloseButtonAddBankDetails = By.cssSelector("button[id*='Button1']");
	private final By iwrComplete = By.cssSelector("button[id*=InitiateOneTimeDistribution]");
	private final By qcApproved =By.cssSelector("button[id*='QCApproved']");
	private final By qcNotApproved =By.cssSelector("button[id*='QCNotApproved']");
	private final By editDistribution = By.cssSelector("button[id*=EditDistribution]");
	private final By stageDistribution = By.cssSelector("button[id*=ResidualDistributionButton]");
	private final By deliveryMethod = By.cssSelector("input[value=Journal]");
	private final By ediIconJournal = By.cssSelector("button[id*=EditButton]");
	private final By accoutJournal = By.cssSelector("select[id*=AccountNumberSelect]");
	private final By accoutTextJournal = By.cssSelector("input[id*=AccountNumberText]");
	private final By saveJournal = By.cssSelector("button[id*=AddDestinationAccountButton]");
	private final By amountJournal = By.cssSelector("input[id*=DestinationAllocationAmount]");
	
	
	String parentWindow;
	boolean isDisplay;
	
	public OneTimeDistributionPage(SeleniumCore seleniumCore) {
		this(seleniumCore, true);
	}

	public OneTimeDistributionPage(SeleniumCore seleniumCore, boolean pageVerification) {
		super(seleniumCore);
		if (pageVerification) {
			seleniumCore.frameAvailableAndSwitchToIt(By.cssSelector("iframe[title='Coach']"),60,1);
			logger.info("switched to the frame ");
			seleniumCore.getDriver().manage().window().fullscreen();
			boolean isVisible = seleniumCore.isElementVisible(saveCloseButton, 10,1);
			if (isVisible) {
				logger.info(PAGE_NAME + " verification"+SEPARATOR+ PAGE_NAME + " verification is PASSED");
			} else {
				logger.warn(PAGE_NAME + " verification"+SEPARATOR+ PAGE_NAME + " verification is FAILED");
			}
		}
	}	
	
	public void oneTimeDistribution(String deliveryMethod) {
		seleniumCore.waitForJStoLoad();
		String accountType = seleniumCore.getText(By.cssSelector("p[id*=AccountName]"));

		By element = By.xpath("//span[text()='" + deliveryMethod + "']/preceding-sibling::input");
		seleniumCore.clickRadioButton(element, "click on delivery method radio button", "", 10, 1);
		customLogger("click on delivery method radio button ", deliveryMethod);
		seleniumCore.waitForJStoLoad();
		waitForLoadingData();
		if (deliveryMethod.equalsIgnoreCase("Wire"))
			seleniumCore.sendKeys(amount, "500");
		seleniumCore.clickRadioButton(recipientType, "click on recipient type", "", 20, 1);
		String date = seleniumCore.getText(recommendedDate);
		String[] mm = date.split("/");
		if (mm[1].charAt(0) == '0') {
			mm[1] = String.valueOf(mm[1].charAt(1));
		}
		seleniumCore.click(calendar);
		By recDate = By.cssSelector("td:not([class*='disabled'])>[aria-label='" + mm[1] + "'][class='day-btn']");
		seleniumCore.click(recDate);
		customLogger("select recommended date ", "");
		if (deliveryMethod.equalsIgnoreCase("Check")) {
			seleniumCore.clickRadioButton(deliveryOptions, "click on delivery options", "", 10, 1);
			customLogger("click on delivery options ", "");

			/*
			 * if (accountType.toLowerCase().contains("ira") &&
			 * deliveryMethod.equalsIgnoreCase("Check")) { seleniumCore.clickRadioButton(
			 * chargeOvernightFee,"click on charge Overnight Fee", "", 10, 1); }
			 */
		}

		if (accountType.toLowerCase().contains("ira")) {
			WebElement clearingFirm = searchWebElement(distributionReason);
			clearingFirm.click();
			WebElement clearingFirm_chosen = seleniumCore.findElement(By.cssSelector("div[id*='DistributionReason_chosen']>div>div>input"));
			clearingFirm_chosen.sendKeys("WTRF-TRANSFER OUT");
			seleniumCore.waitForUILoading(1000);
			action.sendKeys(Keys.ENTER).build().perform();
			logger.info("distibution reason field");
			customLogger("select distibution reason field ", "");
			seleniumCore.waitForJStoLoad();
			waitForLoadingData();

			/*
			 * seleniumCore.selectByValue(taxWithholding, "Withhold");
			 * seleniumCore.tabOut(); seleniumCore.selectByValue(federalWithholding,
			 * "Percent", "", "", 1, 1); seleniumCore.sendKeys(federalAmount, "49"); if
			 * (seleniumCore.getText(By.cssSelector("[data-viewid='TaxWithholdingBanner']"))
			 * .contains("TX")) { seleniumCore.selectByValue(stateWithholding,
			 * "DoNotWithhold", "", "", 1, 1); } else { seleniumCore.sendKeys(stateAmount,
			 * "50"); }
			 */
		}
		// wire instruction
		if (deliveryMethod.equalsIgnoreCase("Wire")) {
			if (!seleniumCore.isElementVisible(By.xpath("//div[@data-viewid='WireDeliveryInstructionsTable']//table//tbody"))) {
				seleniumCore.click(addInstructionsButton);
				waitForLoadingData();
				switchTab("AddUpdateBank");
				seleniumCore.switchToFrame(By.cssSelector("iframe[title='Coach']"));
				seleniumCore.clickRadioButton(instructionTypeWire, "select instruction type: ", deliveryMethod);
				seleniumCore.sendKeys(abaRouting, "221172241");
				seleniumCore.sendKeys(bankAccount, "767686989");
				seleniumCore.sendKeys(bankAccountName, "abc");
				seleniumCore.sendKeys(ffcName, "def");
				seleniumCore.sendKeys(ffcAcct, "879879879");
				seleniumCore.sendKeys(bankName, "ghi");
				seleniumCore.click(saveCloseButtonAddBankDetails);
				waitForLoadingData();
				switchTab("OneTimeDistribution");
				seleniumCore.switchToFrame(By.cssSelector("iframe[title='Coach']"));
			} else {
				seleniumCore.clickRadioButton(By.cssSelector("input[name*='WireDeliveryInstructionsTable']"), "", "");
			}
			seleniumCore.waitForElementToBeClickable(iwrComplete, 10, 1).click();
			customLogger("click on intitate one time distribution button ", "");
			waitForLoadingData();
			if (seleniumCore.isElementFound(By.cssSelector("input[id*='WarningCheckboxes']"), 1, 1)) {
				List<WebElement> elements = seleniumCore.findElements(By.cssSelector("input[id*='WarningCheckboxes']"));
				if (elements.size() > 0) {
					for (WebElement element1 : elements) {
						element1.click();
					}
					seleniumCore.click(By.cssSelector("[id*='WarningPopupProceedButton']"));
				}
			}
			seleniumCore.waitForJStoLoad();
			switchTab("Shell Process");
			seleniumCore.doesTitleContainText("Shell Process", 20, 1);
			waitForPageLoad();
		}

		if (deliveryMethod.equalsIgnoreCase("Check")) {
			if (seleniumCore.isElementVisible(By.cssSelector("table[class='table table-condensed']>tbody>tr"), 2, 1)) {
				seleniumCore.clickRadioButton(payeeRecord, "select added payee ", "", 10, 1);
				customLogger("select added payee ", "");
				waitForPageLoad();
			} else {
				seleniumCore.click(addPayeeInstructions);
				customLogger("click on add payee instructions button", "");
				switchTab("PayeeInstructions");
				enterPayeeInformation();
				clickSaveCloseButton();
				switchTab("OneTimeDistribution");
				waitForPageLoad();
				seleniumCore.frameAvailableAndSwitchToIt(By.cssSelector("iframe[title='Coach']"), 30, 1);
				if (!seleniumCore.findElement(payeeRecord).isSelected()) {
					seleniumCore.clickRadioButton(payeeRecord, "select added payee", "", 10, 1);
					customLogger("select added payee ", "");
				}
			}
			seleniumCore.waitForElementToBeClickable(iwrComplete, 10, 1).click();
			customLogger("click on intitate one time distribution button ", "");
			waitForLoadingData();
			if (seleniumCore.isElementFound(By.cssSelector("input[id*='WarningCheckboxes']"), 1, 1)) {
				List<WebElement> elements = seleniumCore.findElements(By.cssSelector("input[id*='WarningCheckboxes']"));
				if (elements.size() > 0) {
					for (WebElement element1 : elements) {
						element1.click();
					}
					seleniumCore.click(By.cssSelector("[id*='WarningPopupProceedButton']"));
				}
			}
			if (seleniumCore.isElementVisible(By.xpath("//button[text()='Close']"), 2, 1)) {
				seleniumCore.findElement(By.xpath("//button[text()='Close']")).click();
				customLogger("click on close button", "");
				seleniumCore.waitForUILoading(4000);
			}
			switchTab("Shell Process");
			seleniumCore.doesTitleContainText("Shell Process", 20, 1);
		}
		if (deliveryMethod.equalsIgnoreCase("ACH")) {
			if (!seleniumCore.isElementVisible(By.cssSelector("div[data-viewid='ACHDeliveryInstructionsTable']"))) {
				seleniumCore.click(addInstructionsButton);
				waitForLoadingData();
				switchTab("AddUpdateBank");
				seleniumCore.switchToFrame(By.cssSelector("iframe[title='Coach']"));
				seleniumCore.sendKeys(abaRouting, "221172241");
				seleniumCore.sendKeys(bankAccount, "767686989");
				seleniumCore.sendKeys(bankAccountName, "abc");
				// seleniumCore.sendKeys(ffcName, "def");
				// seleniumCore.sendKeys(ffcAcct, "879879879");
				seleniumCore.sendKeys(bankName, "ghi");
				seleniumCore.click(saveCloseButtonAddBankDetails);
				waitForLoadingData();
				switchTab("OneTimeDistribution");
				seleniumCore.switchToFrame(By.cssSelector("iframe[title='Coach']"));
			} else {
				seleniumCore.clickRadioButton(By.cssSelector("input[name*='ACHDeliveryInstructionsTable']"), "", "");
			}
			seleniumCore.waitForElementToBeClickable(iwrComplete, 10, 1).click();
			customLogger("click on intitate one time distribution button ", "");
			waitForLoadingData();
			if (seleniumCore.isElementFound(By.cssSelector("input[id*='WarningCheckboxes']"), 1, 1)) {
				List<WebElement> elements = seleniumCore.findElements(By.cssSelector("input[id*='WarningCheckboxes']"));
				if (elements.size() > 0) {
					for (WebElement element1 : elements) {
						element1.click();
					}
					seleniumCore.click(By.cssSelector("[id*='WarningPopupProceedButton']"));
				}
			}
			seleniumCore.waitForJStoLoad();
			switchTab("Shell Process");
			seleniumCore.doesTitleContainText("Shell Process", 20, 1);
			waitForPageLoad();
		}
	}
	
	public void enterResidualDistribution(String deliveryMethod) {	
		if(deliveryMethod.equalsIgnoreCase("Wire")) {
			deliveryMethod= "Journal";
		}
		seleniumCore.waitForJStoLoad();		
		seleniumCore.switchToFrame(By.cssSelector("iframe[title='Coach']"));		
		String accountNumber = seleniumCore.getText(By.cssSelector("p[id*=AccountNumber]"));
		By element = By.xpath("//span[text()='" + deliveryMethod + "']/preceding-sibling::input");
		seleniumCore.clickRadioButton(element, "click on delivery method radio button", "", 10, 1);
	//	seleniumCore.jsClick(seleniumCore.findElement(element), "");
		customLogger("click on delivery method radio button ", deliveryMethod);
		seleniumCore.waitForJStoLoad();
		waitForLoadingData();
		if (deliveryMethod.equalsIgnoreCase("Journal")) {
			if (!seleniumCore.isElementVisible(By.xpath("//div[@data-viewid='DestinationAccountsTable']//table//tbody"),2,1)) {
			seleniumCore.selectByValue(accoutJournal, accountNumber, "", "", null, null);
			seleniumCore.sendKeys(amountJournal, "100");
			seleniumCore.click(saveJournal);
			}
		}else if (deliveryMethod.equalsIgnoreCase("ACH")) {
			if (!seleniumCore.isElementVisible(By.xpath("//div[@data-viewid='ACHResidualInstructionsTable']//table//tbody"),2,1)) {
				seleniumCore.click(addInstructionsButton);
				waitForLoadingData();
				switchTab("AddUpdateBank");
				seleniumCore.switchToFrame(By.cssSelector("iframe[title='Coach']"));
				seleniumCore.sendKeys(abaRouting, "221172241");
				seleniumCore.sendKeys(bankAccount, "767686989");
				seleniumCore.sendKeys(bankAccountName, "abc");
				// seleniumCore.sendKeys(ffcName, "def");
				// seleniumCore.sendKeys(ffcAcct, "879879879");
				seleniumCore.sendKeys(bankName, "ghi");
				seleniumCore.click(saveCloseButtonAddBankDetails);
				waitForLoadingData();
				switchTab("ResidualDistribution");
				seleniumCore.switchToFrame(By.cssSelector("iframe[title='Coach']"));
			}}else if (deliveryMethod.equalsIgnoreCase("Check")) {
				if (!seleniumCore.isElementVisible(By.xpath("//div[@data-viewid='CheckResidualInstructionsTable']//table//tbody"))) {				
				seleniumCore.click(addPayeeInstructions);
				customLogger("click on add payee instructions button", "");
				switchTab("PayeeInstructions");
				enterPayeeInformation();
				clickSaveCloseButton();
				switchTab("ResidualDistribution");
				waitForPageLoad();
				seleniumCore.frameAvailableAndSwitchToIt(By.cssSelector("iframe[title='Coach']"), 30, 1);
				if (!seleniumCore.findElement(payeeRecord).isSelected()) {
					seleniumCore.clickRadioButton(payeeRecord, "select added payee", "", 10, 1);
					customLogger("select added payee ", "");
				}
			}
			}
		seleniumCore.getDriver().switchTo().defaultContent();
	}

	public void enterPayeeInformation() {
		seleniumCore.switchToFrame(By.cssSelector("iframe[title='Coach']"));
		seleniumCore.waitForElementToBeFound(payeeName1, 20, 1);
		seleniumCore.sendKeys(payeeName1, "ab");
		customLogger("enter payee name 1 ", "");
		seleniumCore.sendKeys(address1, "ab");
		customLogger("enter address 1 ", "");
		seleniumCore.sendKeys(city, "alhambra");
		customLogger("enter city", "");
		seleniumCore.sendKeys(state, "ca");
		customLogger("enter state", "");
		seleniumCore.sendKeys(zip, "91803");
		customLogger("enter zip ", "");
		seleniumCore.clickRadioButton(typeOfPayee, "click on type of payee", "");
		customLogger("click on type of payee", "");
		seleniumCore.clickRadioButton(sloa, "click on sloa radiobutton", "");
		customLogger("click on sloa radiobutton", "");
	}
	
	public void clickSaveCloseButton() {
		seleniumCore.click(saveCloseButton);	
		customLogger("click on save and close button", "");
		switchTab("Shell Process");
	}
	
	public void waitForSpinnerToClose() {
		seleniumCore.waitForElementToBeInVisible(By.cssSelector("div[class='Coach_ProgressIcon_show'] >img"), 30, 1);
	//	seleniumCore.waitForElementToBeVisible(By.cssSelector("div[class='Coach_ProgressIcon_hide'] >img"), 30, 1);
	}
	
	public void clickIWRButton(String deliveryMethod) {
		seleniumCore.switchToFrame(By.cssSelector("iframe[title='Coach']"));
		if(deliveryMethod== null      |    deliveryMethod.equalsIgnoreCase("Check")   |   deliveryMethod.equalsIgnoreCase("ACH")) {
			By elementFound = By.xpath("//div[contains(@data-viewid,'ResidualInstructionsTable')]//table//tbody//input");
			seleniumCore.clickRadioButton(elementFound, "", "");
		}			
		seleniumCore.waitForElementToBeClickable(By.cssSelector("[id*=IWRComplete]"), 10, 1).click();		
		customLogger("click on iwr button on residual distribution button ", "");			
		waitForLoadingData();
		if(seleniumCore.isElementFound(By.cssSelector("input[id*='WarningCheckboxes']"), 1, 1)) {
			List<WebElement> elements = seleniumCore.findElements(By.cssSelector("input[id*='WarningCheckboxes']"));
			if (elements.size() > 0) {
				for (WebElement element : elements) {
					element.click();
				}
				seleniumCore.click(By.cssSelector("[id*='WarningPopupProceedButton']"));
			}
			}
		waitForLoadingData();
	}
	
	public void clickDeliveryMethodResidual(String option) {		
		seleniumCore.switchToFrame(By.cssSelector("iframe[title='Coach']"));
		seleniumCore.clickRadioButton(deliveryMethod, "click on delivery method", "", 10, 1);
		seleniumCore.getDriver().switchTo().defaultContent();
	}
	
	public void clickQcApprovedButton(String option) {
//		seleniumCore.switchToFrame(By.cssSelector("iframe[title='Coach']"));
		seleniumCore.waitForElementToBeClickable(qcApproved, 20, 1);
		if (seleniumCore.isElementVisible(qcApproved, 1, 1)) {
			if (option.equalsIgnoreCase("approve")) {
				seleniumCore.click(qcApproved);
				logger.info("clicked on qc approved button ");
				customLogger("clicked on qc approved button ", "");
			} else {
				seleniumCore.click(qcNotApproved);
				logger.info("clicked on qc not approved button ");
				customLogger("clicked on qc not approved button ", "");
			}
		} else {
			seleniumCore.click(By.cssSelector("button[id*='Cancel'][class*='warning']"));
		}
		seleniumCore.waitForJStoLoad();
		waitForLoadingData();
		if (seleniumCore.getDriver().getWindowHandles().size() == 3) {
			List<WebElement> elements = seleniumCore.findElements(By.cssSelector("input[id*='WarningCheckboxes']"));
			if (elements.size() > 0) {
				for (WebElement element : elements) {
					element.click();
				}
				seleniumCore.click(By.cssSelector("[id*='WarningPopupProceedButton']"));
				seleniumCore.waitForJStoLoad();
				waitForLoadingData();
			}
		}
	}
	
	public void clickQcApprovedButtonforRD(String option) {			
		seleniumCore.switchToFrame(By.cssSelector("iframe[title='Coach']"));
		seleniumCore.waitForElementToBeClickable(qcApproved, 20, 1);
		if(seleniumCore.isElementVisible(qcApproved, 1, 1)) {
			if(option.equalsIgnoreCase("approve")) {
		seleniumCore.click(qcApproved);
		logger.info("clicked on qc approved button ");
		customLogger("clicked on qc approved button ", "");
			}else {
				seleniumCore.click(qcNotApproved);
				logger.info("clicked on qc not approved button ");
				customLogger("clicked on qc not approved button ", "");
			}
		}else {
			seleniumCore.click(By.cssSelector("button[id*='Cancel'][class*='warning']"));
		}
		seleniumCore.waitForJStoLoad();
		waitForLoadingData();
		if(seleniumCore.getDriver().getWindowHandles().size()==3) {
		List<WebElement> elements = seleniumCore.findElements(By.cssSelector("input[id*='WarningCheckboxes']"));
		if (elements.size() > 0) {
			for (WebElement element : elements) {
				element.click();
			}
			seleniumCore.click(By.cssSelector("[id*='WarningPopupProceedButton']"));
			seleniumCore.waitForJStoLoad();
			waitForLoadingData();
		}
		}
	}
	
	public void updateJournal(String accountNumber) {
		seleniumCore.switchToFrame(By.cssSelector("iframe[title='Coach']"));
		seleniumCore.waitForElementToBeVisible(ediIconJournal, 20, 1);
		seleniumCore.jsClick(seleniumCore.findElement(ediIconJournal), "");
		seleniumCore.selectByValue(accoutJournal, "Other");
		seleniumCore.sendKeys(accoutTextJournal, accountNumber, "", "");	
		seleniumCore.tabOut();
		seleniumCore.click(saveJournal);
		seleniumCore.waitForUILoading(500);
		Assert.assertTrue("journal has not been updated", seleniumCore.getText(By.cssSelector("div[data-bindingrt*=AccountNumber]")).contains(accountNumber));
		logger.info("journal has been updated ");
		customLogger("journal has been updated ", "");		
		clickSaveCloseButton();
	}
}
