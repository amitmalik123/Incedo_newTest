package com.amk.cucumber.pages;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.amk.cucumber.exceptions.DefaultException;
import com.amk.cucumber.utility.SeleniumCore;

public class TransferAttributesPage extends BawBasePage {

	private static final String PAGE_NAME = "Transfer Attributes Page";

	private final By saveCloseButton = By.cssSelector("button[id$=SaveAndClose]");
	
	private final By fullCheckBox = By.cssSelector("input[value='Full']");	
	private final By nonACAT = By.cssSelector("input[id*='NonACAT']");
	private final By contributionCode = By.cssSelector("select[id='singleselect-TransferAttributesCV:ContributionCode']");
//	private final By contraFirm = By.cssSelector("select[id='singleselect-TransferAttributesCV:ContraFirm']");
	private final By contraFirmAccount = By.cssSelector("input[id='text-input-TransferAttributesCV:ContraFirmAccount']");
	private final By contraFirmNameLine1 = By.cssSelector("input[id='text-input-TransferAttributesCV:ContraFirmName1']");
	private final By contraFirmNameLine2 = By.cssSelector("input[id='text-input-TransferAttributesCV:ContraFirmName2']");
	private final By estimatedCheckbox =By.cssSelector("input[value='Estimated']");
	private final By amount = By.cssSelector("input[id='decimal-input-TransferAttributesCV:Amount']");
	private final By createChecklist =By.cssSelector("button[id*='CreateCheckListButton']");
	private final By modifyChecklist =By.cssSelector("button[id*='ModifyChecklistButton']");
	private final By saveChecklist =By.cssSelector("button[id*='SaveCheckListButton']");
	private final By headerAccount = By.cssSelector("[aria-labelledby='outputtext-label-TransferAttributesCV:AccountNumber']");
	private final By destinationAccount = By.cssSelector("select[id='singleselect-TransferAttributesCV:AccountNumberSelect']");
	private final By percentCheckbox =By.cssSelector("input[value='Percent']");
	private final By dollarAllocation =By.cssSelector("input[value='USDollar']");	
	private final By allRemainingAllocation =By.cssSelector("input[value='AllRemaining']");
	private final By specialInstructionsUnit =By.cssSelector("input[value='SpecialInstructions']");
	private final By destinationAmount = By.cssSelector("input[id='decimal-input-TransferAttributesCV:DestinationAllocationAmount']");
	private final By addButton = By.cssSelector("button[id='button-button-TransferAttributesCV:AddDestinationAccountButton']");	
	private final By createTOARButton = By.cssSelector("button[id='button-button-TransferAttributesCV:CreateTOARButton']");
	private final By createTOADButton = By.cssSelector("button[id='button-button-TransferAttributesCV:CreateTOADButton']");	
	private final By contraFirmChosen = By.xpath("//div[@id='singleselect_TransferAttributesCV_ContraFirm_chosen']/a/div");
	private final By clearingFirmChosen = By.xpath("//div[@id='singleselect_TransferAttributesCV_ClearingFirm_chosen']/a");
	private final By contraFirmRegistrationChosen = By.xpath("//div[@id='singleselect_TransferAttributesCV_ContraFirmRegistration_chosen']/a/div");
	private final By specialInstructions = By.cssSelector("[id='textarea-textarea-TransferAttributesCV:SpecialInstructions']");	
	private final By createFundingAccount = By.xpath("//button[text()='Create Funding Account']");
	private final By errorMsg = By.cssSelector("div[class*='danger']");
	private final By iwrComplete =By.cssSelector("button[id*='IWRComplete']");
	private final By qcApproved =By.cssSelector("button[id*='QCApproved']");
	private final By submissionComplete =By.cssSelector("button[id*='SubmissionComplete']");
	private final By readyForSubmission =By.cssSelector("button[id*='ReadyForSubmission']");
	private final By beingTransferred =By.cssSelector("input[value=MutualFundsOnly]");
	private final By ptdEligibility =By.cssSelector("input[id*=PTDEligibility]");
	private final By bondsAccount =By.cssSelector("input[id*=BondsInAccount]");
	private final By custodianChange =By.cssSelector("input[id*=CustodianChange][value='No']");
	private final By securitiesToSell =By.cssSelector("input[id*='SecuritiesToSell'][value='No']");
	private final By securityType =By.cssSelector("select[id*=SellSecurityTypeCell]");
	private final By securitiesToExclude =By.cssSelector("input[id*=SecuritiesToExclude][value='No']");
	private final By options =By.cssSelector("input[value='NoOptions']");
	private final By securityTypeSecuritiesExclude =By.cssSelector("select[id*=ExcludeSecurityTypeCell]");
	private final By pendingTrades =By.cssSelector("input[id*=PendingTrades][value='No']");
	private final By pendingTradesDates =By.cssSelector("input[id*=SettlementDate]");
	private final By implicationAckCheckbox =By.cssSelector("input[id*=Implication_Ack_Checkbox]");
	private final By sellSecurityCell =By.cssSelector("input[id*=SellSecurityCell]");
	private final By excludeSecurityCell =By.cssSelector("input[id*=ExcludeSecurityCell]");
	private final By submittedToFidelity =By.cssSelector("input[id*=SubmittedToFidelity]");
	private final By edsConfirmationNumber =By.cssSelector("input[id*=EDSConfirmationNumber]");
	private final By fidelityServiceTicketMF =By.cssSelector("input[id*=FidelityServiceTicketMF]");
	private final By transferStatus =By.cssSelector("p[id*= TransferStatus]");	
	private final By editTransferButton =By.cssSelector("button[id*=EditTransfer]");
	private final By removeFundingAccountButton =By.cssSelector("button[id*=RemoveFundingAccountButton]");
	private final By nuances =By.cssSelector("div[class*=NuancesTable]");
	private final By mutualFund = By.cssSelector("input[id*='FidelityServiceTicketMF']");
	
	String parentWindow;
	boolean isDisplay;
	WebElement clearingFirm;
	WebElement clearingFirm_chosen;
	WebElement contraFirm;
	WebElement contraFirm_chosen;		
	WebElement contraFirmRegistrationFirm;
	WebElement contraFirmRegistrationFirm_chosen;
	
	public TransferAttributesPage(SeleniumCore seleniumCore) {
		this(seleniumCore, true);
	}

	public TransferAttributesPage(SeleniumCore seleniumCore, boolean pageVerification) {
		super(seleniumCore);
		if (pageVerification) {
			seleniumCore.switchToFrame(By.cssSelector("iframe[title='Coach']"),10,1);
			boolean isVisible = seleniumCore.isElementVisible(saveCloseButton,1,1);
			if (isVisible) {
				logger.info(PAGE_NAME + " verification"+SEPARATOR+ PAGE_NAME + " verification is PASSED");
			} else {
				logger.warn(PAGE_NAME + " verification"+SEPARATOR+ PAGE_NAME + " verification is FAILED");
			}
		}
	}	
	
	public void enterTransferRequest(String transferRequest, String workItemType) {
		String[] transferData = transferRequest.split(",");		
		switch (workItemType) {
		case "Transfer In Request":
		case "Custodian Change Request":
			commonTransferRequestSteps(transferData);
			/*
			 * seleniumCore.waitForElementToBeClickable(createFundingAccount,60,1).click();
			 * customLogger("click on create funding account button ", "");
			 * seleniumCore.waitForJStoLoad(); waitForLoadingData(); try {
			 * seleniumCore.handleAlert("OK"); }catch(Exception e) {
			 * logger.info(e.getLocalizedMessage()); } seleniumCore.waitForJStoLoad();
			 * seleniumCore.waitForUILoading(1000);
			 */		 
			break;
		case "Partial Transfer Out":		
		case "Partial Transfer Out In Kind":							
			selectContraFirm(transferData[1]);			
			seleniumCore.sendKeys(contraFirmAccount, transferData[2], " enter firm account ");
			seleniumCore.tabOut();		
			seleniumCore.waitForElementToBeClickable(estimatedCheckbox, 10, 1);
			seleniumCore.clickRadioButton(estimatedCheckbox, "clicking on amount expectation : Estimated", "");
			seleniumCore.waitForElementToBeClickable(amount, 10, 1);
			seleniumCore.findElement(amount).click();
			seleniumCore.sendKeys(amount, transferData[4], " enter amount ");	
			clickSaveCloseButton();
			break;			
		case "Full Transfer Out In Kind":
			commonTransferRequestSteps(transferData);
			seleniumCore.clickRadioButton(beingTransferred, "being transfered has selected", "");
	//		seleniumCore.findElements(ptdEligibility).stream().map(element -> element.getAttribute("value")).filter(e -> e.equalsIgnoreCase("No"));
			Optional<WebElement> elementWithNoValue= seleniumCore.findElements(ptdEligibility).stream().filter(e -> "No".equalsIgnoreCase(e.getAttribute("value"))).findFirst();
			elementWithNoValue.get().click();
			Optional<WebElement> bondsAccountWithNoValue= seleniumCore.findElements(bondsAccount).stream().filter(e -> "No".equalsIgnoreCase(e.getAttribute("value"))).findFirst();
			bondsAccountWithNoValue.get().click();
			if(seleniumCore.getAttribute(custodianChange, "aria-checked").equals("true")) {
				Assert.assertTrue("securities to sell is not visible", seleniumCore.isElementFound(securitiesToSell, 2, 1));
				seleniumCore.clickRadioButton(securitiesToSell, "clicked No to securities to sell", "");
				/*
				 * Assert.assertTrue("securities to sell table is not visible",
				 * seleniumCore.isElementVisible(securityType));
				 * seleniumCore.selectByIndex(securityType, 1, "", "", null, null);
				 * seleniumCore.sendKeys(sellSecurityCell, "89798");
				 */
				seleniumCore.clickRadioButton(options, "clicked No options in account", "");
				seleniumCore.clickRadioButton(securitiesToExclude, "clicked No to securities to exclude", "");
				/*
				 * Assert.assertTrue("securities to exclude table is not visible",
				 * seleniumCore.isElementVisible(securityTypeSecuritiesExclude));
				 * seleniumCore.sendKeys(excludeSecurityCell, "89798");
				 */
			}			
			createToadRecord();
	//		iwrComplete();			
			break;
		default:
			logger.info("transfer request section info has been entered");
		}
		logger.info("entered transfer request section ");
		customLogger("entered transfer request section info ", "");
	}
	
	public void selectContraFirm(String value) {
		contraFirm = searchWebElement(contraFirmChosen);
		contraFirm.click();
		contraFirm_chosen = seleniumCore.findElement(By.xpath("//div[@class='chosen-search']/input[1]"));
		contraFirm_chosen.sendKeys(value);
		action.sendKeys(Keys.ENTER).perform();
		logger.info("enter contra firm "+value);
		customLogger("enter contra firm ", value);		
		seleniumCore.waitForUILoading(1000);		
	}
	
	public void selectContraFirmRegistration(String value) {
		contraFirmRegistrationFirm = searchWebElement(contraFirmRegistrationChosen);
		contraFirmRegistrationFirm.click();
		contraFirmRegistrationFirm_chosen = seleniumCore.findElement(By.cssSelector("div[id*='ContraFirmRegistration_chosen']>div>div>input"));
		contraFirmRegistrationFirm_chosen.sendKeys(value);
		action.sendKeys(Keys.ENTER).perform();
		logger.info("entered non acat firm ");
		customLogger("select non acat firm in clearing Firm chosen field ", "");	
	}
	
	public void selectClearingFirm(String value) {
		clearingFirm = searchWebElement(clearingFirmChosen);
		clearingFirm.click();
		clearingFirm_chosen = seleniumCore.findElement(By.cssSelector("div[id*='ClearingFirm_chosen']>div>div>input"));
//		clearingFirm_chosen.sendKeys(transferData[7]);
		if(value.trim().toLowerCase().equalsIgnoreCase("american funds")) {
			clearingFirm_chosen.sendKeys("the bank of");
		}else {
		clearingFirm_chosen.sendKeys("a");
		}
		action.sendKeys(Keys.ENTER).perform();
		logger.info("select clearing firm ");
		customLogger("select clearing firm ", "");
	}
	
	public void enterDestinationAccounts(String workitemType, Map<String, String> addAccountInfo, String allocationUnit) {
		String account;
		account=seleniumCore.getText(headerAccount);
		logger.info("account value is "+ account.length());		
		if (!account.isEmpty()) {
			seleniumCore.selectByValue(destinationAccount, account, "select account ", "", 10, 1);
		} else {
			account = addAccountInfo.get("accountNumber");
			seleniumCore.selectByValue(destinationAccount, account, "select account ", "", 10, 1);
		}		 	
		if(allocationUnit.equals("percentage")) {
		    seleniumCore.clickRadioButton(percentCheckbox, "clicking on allocation unit: percent", "");	
		    seleniumCore.sendKeys(destinationAmount, "100", " enter destination amount ");
		}else if (allocationUnit.equals("multiple")){
			seleniumCore.clickRadioButton(percentCheckbox, "clicking on allocation unit: percent", "");	
			seleniumCore.sendKeys(destinationAmount, "50", " enter destination amount ");
			seleniumCore.click(addButton);			
			
		        Select select = new Select(seleniumCore.findElement(destinationAccount));
				List<WebElement> lst = select.getOptions();		
				for (WebElement options : lst)
					if (!options.getText().equals(account)  &&    !options.getText().equals("Select")   &&  !options.getText().isBlank()   &&   !options.getText().isEmpty()) {						
						options.click();
						waitForUILoading(500);									
						break;
					}  		
			seleniumCore.clickRadioButton(percentCheckbox, "clicking on allocation unit: percent", "");	
			seleniumCore.sendKeys(destinationAmount, "50", " enter destination amount ");
		}else if (allocationUnit.equals("multipleAR")){
			seleniumCore.clickRadioButton(dollarAllocation, "clicking on allocation unit: dollar", "");	
			seleniumCore.sendKeys(destinationAmount, "50", " enter destination amount ");
			seleniumCore.click(addButton);
			
			Select select = new Select(seleniumCore.findElement(destinationAccount));
			List<WebElement> lst = select.getOptions();		
			for (WebElement options : lst)
				if (!options.getText().equals(account)  &&    !options.getText().equals("Select")   &&  !options.getText().isBlank()   &&   !options.getText().isEmpty()) {						
					options.click();
					waitForUILoading(500);								
					break;
				}	
			seleniumCore.clickRadioButton(allRemainingAllocation, "clicking on allocation unit: all remaining", "");	
			}else {
			seleniumCore.clickRadioButton(specialInstructionsUnit, "clicking on allocation unit: percent", "");				
		}
		seleniumCore.click(addButton);
		logger.info("clicked on add button ");
		customLogger("clicked on add button ", "");
		seleniumCore.waitForJStoLoad();
		waitForLoadingData();
		seleniumCore.click(createFundingAccount);
		logger.info("clicked on create funding account button ");
		customLogger("clicked on create funding account button ", "");
		waitForLoadingData();
		seleniumCore.waitForJStoLoad();
		waitForLoadingData();		
		if(workitemType.equals("Custodian Change Request") ) {
		  seleniumCore.waitForElementToBeInVisible(By.cssSelector("[role='alert']"), 30, 1);		  
		  seleniumCore.click(createTOARButton);
		  logger.info("clicked on create TOAR Record button ");
		  customLogger("clicked on create TOAR Record button ", "");
		  seleniumCore.waitForJStoLoad(); 
		  if(seleniumCore.isElementVisible(edsConfirmationNumber, 1, 1)) {
				seleniumCore.clickRadioButton(submittedToFidelity, "checked submitted to fidelity", "");
				seleniumCore.sendKeys(edsConfirmationNumber, "546456", " enter eds confirmation number");
			}
	//	  waitForLoadingData();
		  Assert.assertTrue("TOAR record is not created", seleniumCore.getText(By.cssSelector("[role='alert']"),10,1).contains("TOAR Record created successfully"));
		  clickSaveCloseButton();
		  List<WebElement> elements = seleniumCore.findElements(By.cssSelector("input[id*='WarningCheckboxes']"));
		  if(elements.size()>0) {
			  for(WebElement element : elements) {
				  seleniumCore.waitForUILoading(500);
				  element.click();
			  }
			  seleniumCore.click(By.cssSelector("[id*='WarningPopupProceedButton']"));
		  }
		}else {
			iwrComplete();			
		}
		if(seleniumCore.isElementVisible(errorMsg, 4, 1)) {
			throw new DefaultException("getting error message : "+ seleniumCore.getText(errorMsg));
		}
		}
	
		public void enterDestinationAccounts() {
			String account = seleniumCore.getText(headerAccount);
			seleniumCore.selectByValue(destinationAccount, account, "select account ", "", 10, 1);
			seleniumCore.clickRadioButton(percentCheckbox, "clicking on allocation unit: percent", "");
			seleniumCore.sendKeys(destinationAmount, "100", " enter destination amount ");
			seleniumCore.click(addButton);
			logger.info("clicked on add button ");
			customLogger("clicked on add button ", "");
		}
	
	public void clickSaveCloseButton() {
		waitForLoadingData();
		if(seleniumCore.isElementFound(saveCloseButton,1,1)) {
		seleniumCore.waitForElementToBeClickable(saveCloseButton, 20, 1);
		seleniumCore.click(saveCloseButton);
		logger.info("clicked on save & close button ");
		customLogger("entered destination accounts info and clicked on save & close button ", "");	
		}
		}
	
		public void clickQcApprovedButton() {			
			seleniumCore.waitForElementToBeClickable(qcApproved, 20, 1);
			seleniumCore.click(qcApproved);
			logger.info("clicked on qc approved button ");
			customLogger("clicked on qc approved button ", "");
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
			waitForLoadingData();
		}
	
		public void clickSubmissionCompleteButton() {
			if (!seleniumCore.isElementFound(By.cssSelector("input[id*=SubmittedToFidelity][aria-checked='true']"))) {
				seleniumCore.clickRadioButton(submittedToFidelity, "checked submitted to fidelity", "");
				if (seleniumCore.isElementVisible(edsConfirmationNumber, 1, 1)) {
					seleniumCore.sendKeys(edsConfirmationNumber, "546456", " enter eds confirmation number");
				} else if (seleniumCore.isElementVisible(mutualFund, 1, 1)) {
					seleniumCore.sendKeys(mutualFund, "W253563-31APR22", " enter eds confirmation number");
				}
			}
			List<WebElement> checklists = seleniumCore.findElements(By.xpath("//*[text()='Use Checklist']/parent::div/following-sibling::div//tbody/tr[not(contains(@style,'display: none;'))]"));

			for (int i = 1; i <= checklists.size(); i++) {
				By checkistElement = By.xpath(
						"//*[text()='Use Checklist']/parent::div/following-sibling::div//tbody/tr[not(contains(@style,'display: none;'))]["+ i + "]/td//input[@type='checkbox']");
				seleniumCore.jsClick(seleniumCore.findElement(checkistElement), "");
			}
			submissionComplete();
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
	
	public void submissionComplete() {
		seleniumCore.waitForElementToBeClickable(submissionComplete, 20, 1);
		seleniumCore.click(submissionComplete);
		logger.info("clicked on submission complete button ");
		customLogger("clicked on submission complete button ", "");
	}
	
	public void clickReadyForsubmission() {
		seleniumCore.waitForElementToBeClickable(readyForSubmission, 20, 1);
		seleniumCore.click(readyForSubmission);
		logger.info("clicked on ready for submission button ");
		customLogger("clicked on ready for submission button ", "");
	}
	
	public void commonTransferRequestSteps(String[] transferData) {
		String transferType = transferData[9].trim();
		By cashCheckBox = By.cssSelector("input[value='"+transferType+"']");
		seleniumCore.clickRadioButton(fullCheckBox, "clicking on amount type: Full", "");
		customLogger("click on amount type: Full ", "");
		seleniumCore.clickRadioButton(cashCheckBox, "clicking on transfer type: In Kind", "");
		customLogger("click on transfer type: ",transferType);			
		if(transferType.toLowerCase().equalsIgnoreCase("cash")) {
			seleniumCore.selectByValue(contributionCode, transferData[0]);
		}else {
		seleniumCore.jsClick(seleniumCore.findElement(nonACAT), "click on non-ACAT checkbox", ""); 
		customLogger("click on non-ACAT checkbox", "");			
		seleniumCore.waitForJStoLoad();
		waitForLoadingData();
		}
		selectContraFirm(transferData[1]);	
		if (!transferType.toLowerCase().equalsIgnoreCase("cash")) {
			if (!seleniumCore.findElement(By.cssSelector("#singleselect_TransferAttributesCV_ClearingFirm_chosen")).getAttribute("class").contains("chosen-disabled")) {
				selectClearingFirm(transferData[1]);
				if (seleniumCore.getText(clearingFirmChosen).equalsIgnoreCase("Select")) {
					selectClearingFirm(transferData[1]);
				}
			}
		}
		seleniumCore.sendKeys(contraFirmAccount, transferData[2], " enter contra firm account ");
		seleniumCore.tabOut();	
		try {
			seleniumCore.handleAlert("OK");
			}catch(Exception e) {
				logger.info(e.getLocalizedMessage());
			}
		if (!transferType.toLowerCase().equalsIgnoreCase("cash")) {
		seleniumCore.sendKeys(contraFirmNameLine1, transferData[5], " enter firm account ");
		seleniumCore.tabOut();				
		seleniumCore.sendKeys(contraFirmNameLine2, transferData[6], " enter firm account ");
		seleniumCore.tabOut();			
		selectContraFirmRegistration(transferData[8]);	
		}
		if (transferType.toLowerCase().equalsIgnoreCase("cash")) { 
			String deliveryMethod = transferData[10].trim();
			By mailCheckbox =By.cssSelector("input[value='"+deliveryMethod+"']");
			seleniumCore.clickRadioButton(mailCheckbox, "", "");
		}	
		seleniumCore.waitForElementToBeClickable(amount, 10, 1);
		seleniumCore.sendKeys(amount, transferData[4], " enter amount ");
		seleniumCore.clickRadioButton(estimatedCheckbox, "clicking on amount expectation : Estimated", "");		
		seleniumCore.sendKeys(specialInstructions, "enter special instructions");
		seleniumCore.waitForJStoLoad();
		seleniumCore.tabOut();	
		seleniumCore.waitForUILoading(1000);
	}
	
	public void createToadRecord() {
		seleniumCore.clickRadioButton(pendingTrades, "selecting pending trades radio button", "");
		// seleniumCore.sendKeys(pendingTradesDates, seleniumCore.dateCreation(2));
		seleniumCore.clickRadioButton(implicationAckCheckbox, "checked the acknowledgment", "");
//		seleniumCore.jsClick(seleniumCore.findElement(createTOARButton), "");
		seleniumCore.click(createTOADButton);
		logger.info("clicked on create TOAD Record button ");
		customLogger("clicked on create TOAD Record button ", "");
		seleniumCore.waitForJStoLoad();
		waitForLoadingData();
		if(seleniumCore.isElementVisible(fidelityServiceTicketMF, 1, 1)) {
			seleniumCore.clickRadioButton(submittedToFidelity, "checked submitted to fidelity", "");
			seleniumCore.sendKeys(fidelityServiceTicketMF, "W253563-31APR22", " enter eds confirmation number");
		}
//		Assert.assertTrue("TOAD record is not created", seleniumCore.getText(By.cssSelector("[role='alert']"), 20, 1).contains("TOAD Record created successfully"));
		iwrComplete();
	//	clickSaveCloseButton();
		if(seleniumCore.getDriver().getWindowHandles().size()==3) {
		if(seleniumCore.isElementFound(By.cssSelector("input[id*='WarningCheckboxes']"), 1, 1)) {
		List<WebElement> elements = seleniumCore.findElements(By.cssSelector("input[id*='WarningCheckboxes']"));
		if (elements.size() > 0) {
			for (WebElement element : elements) {
				element.click();
			}
			seleniumCore.click(By.cssSelector("[id*='WarningPopupProceedButton']"));
		}
		}}
	}
	
	public void iwrComplete() {
		waitForLoadingData();		
		//table[@class='table table-striped']//tr//div[@class='Text_Area  CoachView div_6_1_3_1_4_style CPP CoachView_show']//textarea[not(@disabled)]
		answerChecklistQuestions();
		seleniumCore.click(iwrComplete);
		logger.info("click on iwr complete button ");
		customLogger("click on iwr complete button ", "");
		seleniumCore.waitForJStoLoad();		
		waitForLoadingData();
	}
	
	public void answerChecklistQuestions() {
		if(seleniumCore.isElementVisible(By.xpath("//table[@class='table table-striped']//tr//div[@class='Text_Area  CoachView div_6_1_3_1_4_style CPP CoachView_show']//textarea[not(@disabled)]"),1,1)) {
			List<WebElement> elements = seleniumCore.findElements(By.xpath("//table[@class='table table-striped']//tr//div[@class='Text_Area  CoachView div_6_1_3_1_4_style CPP CoachView_show']//textarea[not(@disabled)]"));
			for(int i=1;i<=elements.size();i++) {
				seleniumCore.sendKeys(By.xpath("(//table[@class='table table-striped']//tr//div[@class='Text_Area  CoachView div_6_1_3_1_4_style CPP CoachView_show']//textarea[not(@disabled)])["+i+"]"),"abcde");
			}
		}
	}
	
	public String transferStatus() {
		waitForLoadingData();
		seleniumCore.waitForElementToBeVisible(transferStatus, 20, 1);
		return seleniumCore.getText(transferStatus);
	}
	
	public void checkListSection() {
		seleniumCore.click(createChecklist);
		seleniumCore.waitForJStoLoad();		
		waitForLoadingData();
	}
	
	public void checkListUpdate() {
		boolean flag=false;
		List<WebElement> elements = seleniumCore.findElements(By.xpath("(//*[text()='Create Checklist']/parent::div/following-sibling::div//tbody/tr[not(contains(@style,'display: none;'))])[2]//input[@value]"));
		for(int i=0;i<elements.size()-1;i++) {
			String attValue= elements.get(i).getAttribute("aria-checked");
			if(attValue.toLowerCase().equals("true")) {
			seleniumCore.clickRadioButton(By.xpath("(//*[text()='Create Checklist']/parent::div/following-sibling::div//tbody/tr[not(contains(@style,'display: none;'))])[2]//input[@value='No']"), "", "");
			flag= true;
			}else {
				seleniumCore.clickRadioButton(By.xpath("(//*[text()='Create Checklist']/parent::div/following-sibling::div//tbody/tr[not(contains(@style,'display: none;'))])[2]//input[@value='Yes']"), "", "");				
			}
		}
		if(flag) {
			String value1= seleniumCore.getAttribute(By.xpath("(//*[text()='Create Checklist']/parent::div/following-sibling::div//tbody/tr[not(contains(@style,'display: none;'))])[2]//input[@value='No']"), "aria-checked");
			Assert.assertEquals("user not able to update checklist option", "true", value1);
		}else {
			String value1= seleniumCore.getAttribute(By.xpath("(//*[text()='Create Checklist']/parent::div/following-sibling::div//tbody/tr[not(contains(@style,'display: none;'))])[2]//input[@value='No']"), "aria-checked");
			Assert.assertEquals("user not able to update checklist option", "false", value1);
		}
	}
	
	public void validateChecklistOptions() {		
		List<WebElement> elements = seleniumCore.findElements(By.xpath("//*[text()='Create Checklist']/parent::div/following-sibling::div//tbody/tr"));
		for(int i=1;i<elements.size();i++) {
			List<WebElement> elements2 = seleniumCore.findElements(By.xpath("//*[text()='Create Checklist']/parent::div/following-sibling::div//tbody/tr["+i+"]/td[3]//input"));
			for(int j=0;j<elements2.size()-1;j++) {
			String attValue= elements2.get(j).getAttribute("aria-checked");
			String attValue1= elements2.get(j+1).getAttribute("aria-checked");
			if(attValue.equals(attValue1)) {
				elements2.get(j).click();
			}
			Assert.assertNotEquals("all the options are not selected", elements2.get(j).getAttribute("aria-checked"), elements2.get(j+1).getAttribute("aria-checked"));
			}
		}
	}
	
	public void updateChecklist() {
		waitForLoadingData();
		seleniumCore.click(modifyChecklist);
		answerChecklistQuestions();
		Assert.assertTrue("create checklist heading is not displayed", seleniumCore.isElementVisible(By.xpath("//div[@role='heading']/span[text()='Create Checklist']")));
		seleniumCore.click(saveChecklist);
		logger.info("modify the chechlist");
		customLogger("modify the chechlist ", "");
		Assert.assertTrue("create checklist heading is not displayed", seleniumCore.isElementVisible(By.xpath("//div[@role='heading']/span[text()='Use Checklist']")));
	}
	
	public void editTransfer() {
		seleniumCore.click(editTransferButton);
		logger.info("clicked on edit transfer button");
		customLogger("clicked on edit transfer button", "");
		waitForLoadingData();
	}
	
	public void updateTransferType(String transferType) {
		By cashCheckBox = By.cssSelector("input[value='"+transferType+"']");
		seleniumCore.clickRadioButton(cashCheckBox, "clicking on transfer type: ", transferType);
		seleniumCore.handleAlert("OK");
		waitForLoadingData();
		logger.info("switched transfer type to "+transferType);
		customLogger("switched transfer type to ", transferType);
	}
	
	public void updateDeliveryMethod(String transferType) {
		By cashCheckBox = By.cssSelector("input[value='"+transferType+"']");
		seleniumCore.clickRadioButton(cashCheckBox, "clicking on delivery method: ", transferType);		
		customLogger("switched delivery method to ", transferType);
	}
	
	public void validateChecklistAgain() {
		Assert.assertFalse("create checklist heading is displayed", seleniumCore.isElementVisible(By.xpath("//div[@role='heading']/span[text()='Create Checklist']"),1,1));
		logger.info("create checklist is not visible");
		customLogger("create checklist is not visible", "");
	}
	
	public void removeFundingAccount() {
		seleniumCore.click(removeFundingAccountButton);
		logger.info("clicked on remove funding account button");
		customLogger("clicked on remove funding account button", "");
		seleniumCore.handleAlert("OK");
	}
	
	public boolean validateFaxVerbiage() {
		return seleniumCore.isElementVisible(By.xpath("//div[@class='ContentBox']//span[text()='Sent via Fax to']"));
	}
	
	public String validateSubmissionAlert() {
		return seleniumCore.getText(By.xpath("//div[@data-viewid='Header_Alert']//span"));
		
	}
	
	public void validateContraFirmSubmissionSection(String option) {
		if(option.toLowerCase().equalsIgnoreCase("inkind")) {
			Assert.assertFalse("nuances is visible for transfer inkind", seleniumCore.isElementVisible(nuances,2,1));
			logger.info("nuances is not visible for transfer inkind");
			customLogger("nuances is not visible for transfer inkind", "");
		}else {
			Assert.assertTrue("nuances is not visible for transfer cash", seleniumCore.isElementVisible(nuances));
			logger.info("nuances is visible for transfer cash");
			customLogger("nuances is visible for transfer cash", "");
		}
		
	}
	
}







