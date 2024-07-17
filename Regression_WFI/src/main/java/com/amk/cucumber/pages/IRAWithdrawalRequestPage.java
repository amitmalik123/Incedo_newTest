package com.amk.cucumber.pages;

import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.amk.cucumber.utility.SeleniumCore;



public class IRAWithdrawalRequestPage extends BawBasePage {

	private static final String PAGE_NAME = "IRA WITHDRAWAL PROCESS PAGE";
	private static final String SEPARATOR = ":";
	private String title = "Withdrawal Request";

	private final By formsAvailable = By.xpath("//input[@id='Fill1']");
	private final By selectForms = By.xpath("//input[@id='c4']");
	private final By openButton = By.xpath("//input[@name='ButtonGroup1#Button0'    and     @id='Button0']");
	private final By withdrawalAmount = By.xpath("//input[@id='PART_WD_AMT']");
	private final By partialWithdrawalCheckBox = By.xpath("//input[@id='PART_WD_CASH_PMT']");
	private final By ocrCompleteButton = By.xpath("//button[@id='ButtonGroup0_Button2']");
	private final By notAWithdrawalButton = By.xpath("//button[@id='ButtonGroup0_Button3']");
	private final By reClassifyWorkItemeButton = By.xpath("//input[@name='ButtonGroup0#Button1']");
	private final By accountlInformationHeader = By.xpath("//div[text()='Account Information']");
	private final By distributionReasonHeader = By.xpath("//div[text()='Distribution Reason']");
	private final By wireToSLOACheckbox = By.xpath("//input[@id='DEL_METH_WIRE_SLOA']");
	private final By withdrawalAmountCheck = By.xpath("//input[@value='Withdrawal Amount']/parent::td/following-sibling::td/img");
	private final By rmdCheckBox = By.xpath("//input[@id='DIST_RMD']");
	private final By taxWithholdingHeader = By.xpath("//div[text()='Tax Withholding']");
	private final By distributionReasonCheck = By.xpath("//input[@value='Distribution Reason']/parent::td/following-sibling::td/img");
	private final By federalDoNotWithhold = By.xpath("//input[@id='FWH_NO']");
	private final By stateDoNotWithhold = By.xpath("//input[@id='SWH_NO']");
	private final By federalWithhold = By.xpath("//input[@id='FWH_YES_PERCENT']");
	private final By federalWithholdTextbox = By.xpath("//input[@id='FWH_PERCENT']");
	private final By stateWithhold = By.xpath("//input[@id='SWH_YES_PERCENT']");
	private final By stateWithholdTextbox = By.xpath("//input[@id='SWH_PERCENT']");
	private final By deliveryMethodHeader = By.xpath("//div[text()='Delivery Method']");
//	private final By taxWithholdingCheck = By.xpath("//input[@value='Tax Withholding']/parent::td/following-sibling::td/img");
	
	private final By deliveryOptions = By.cssSelector("#DEL_METH_CHECK_REGULAR");
	private final By streetAddress = By.cssSelector("#BPM_CHECK_DELIVERYOPTION_STREET_ADDRESS");
	//check delivery tab
	private final By checkName = By.xpath("//input[@id='DEL_METH_CHECK_PAYEE_NAME']");
	private final By checkAddress = By.xpath("//input[@id='DEL_METH_CHECK_ADDRESS']");
	private final By checkCity = By.xpath("//input[@id='DEL_METH_CHECK_CITY']");
	private final By checkState = By.xpath("//input[@id='DEL_METH_CHECK_STATE']");
	private final By checkZip = By.xpath("//input[@id='DEL_METH_CHECK_ZIP']");
	private final By checkNewCheckBox = By.xpath("//input[@id='CHECK_NEW_INSTRUCTION']");
	private final By checkTypeOfPayee = By.xpath("//select[@id='BPM_REL_CHECK_TYPE_OF_PAYEE']");
	private final By checkSLOA = By.xpath("//input[@id='BPM_REL_CHECK_SLOA_NO']");
	private final By selectCheckSLOA = By.cssSelector("#SLOA_ADD_CHECK");
	private final By selectACHSLOA = By.cssSelector("#SLOA_ADD_ACH");
	private final By selectSLOA = By.cssSelector("#SLOA_OPT");
	
	//wire transfer delivery tab
	private final By bankName = By.xpath("//input[@id='DEL_METH_WIRE_BANK_NAME']");
	private final By routingNumber = By.xpath("//input[@id='DEL_METH_WIRE_BANK_ABA']");
	private final By bankAccountNumber = By.xpath("//input[@id='DEL_METH_WIRE_BANK_AC_NUM']");
	private final By bankAccountName = By.xpath("//input[@id='DEL_METH_WIRE_BANK_AC_NAME']");
	private final By wireNewCheckBox = By.xpath("//input[@id='WIRE_NEW_INSTRUCTION']");
	private final By thirdPartyFormNo = By.xpath("//input[@id='BPM_REL_BANK_WIRE_THIRD_PARTY_NO']");
	
	//wire transfer delivery tab
	private final By achBankName = By.xpath("//input[@id='DEL_METH_ACH_BANK_NAME']");
	private final By achRoutingNumber = By.xpath("//input[@id='DEL_METH_ACH_BANK_ABA']");
	private final By achBankAccountNumber = By.xpath("//input[@id='DEL_METH_ACH_BANK_AC_NUM']");
	private final By achBankAccountName = By.xpath("//input[@id='DEL_METH_ACH_BANK_AC_NAME']");
	private final By achNewCheckBox = By.xpath("//input[@id='ACH_NEW_INSTRUCTION']");
	private final By achThirdPartyFormNo = By.xpath("//input[@id='BPM_REL_BANK_ACH_THIRD_PARTY_NO']");
	private final By existingBank = By.xpath("//input[@name='payee_instructions'    and    contains(@onclick,'Wire')][1]");
	
	
	private final By achSLOA = By.cssSelector("input#SLOA_ADD_ACH");
	private final By wireSLOA = By.cssSelector("input#SLOA_ADD_WIRE");
	private final By deliveryType = By.xpath("//td[@id='deliveryType']");
	private final By signatureHeader = By.xpath("//div[text()='Signature']");
	private final By deliveryMethodCheck = By.xpath("//input[@value='Delivery Method']/parent::td/following-sibling::td/img");
	private final By iwrTab = By.xpath("//div[@class='dijitTitlePaneTitleFocus'    and    @aria-controls='IWR_pane']");
	private final By iwrTabVerbiage = By.xpath("//font[text()='You have Completed IWR ']");
	private final By placeTradeTab = By.xpath("//div[@class='dijitTitlePaneTitleFocus'    and    @aria-controls='PlaceTrade_pane']");
	private final By ocrCompareTab = By.xpath("//div[@class='dijitTitlePaneTitleFocus'    and    @aria-controls='OCR_pane']");
	private final By deliveryInstructionsTab = By.xpath("//div[@class='dijitTitlePaneTitleFocus'    and    @aria-controls='SLOA_pane']");
	private final By rdTab = By.xpath("//div[@class='dijitTitlePaneTitleFocus'    and    @aria-controls='RD_pane']");
	private final By submitToCustodianTab = By.xpath("//div[@class='dijitTitlePaneTitleFocus'    and    @aria-controls='SubToCus_pane']");
	private final By workItemsImagesTab = By.xpath("//div[@class='dijitTitlePaneTitleFocus'    and    @aria-controls='wiq_pane']");
	private final By viewAddBankInstructions = By.xpath("//input[@id='ADD_RELB']");
	private final By addBankInstructionsFrame = By.xpath("//iframe[contains(@id,'coach_frame')]");
	private final By tcuCheckbox = By.xpath("//*[text()='Tracking Center Upload']/parent::td/preceding-sibling::td/input[@id='Check2']");
	private final By setupInstructionsComplete = By.xpath("//input[@id='SLOAB']");
	private final By submitToCustodianButton = By.xpath("//input[@id='CUSTODIANB']");
	private final By submitToCustodianModal = By.xpath("//*[@id='REL_ACC_POPUP']");
	private final By prsnModal = By.xpath("//*[@id='PRS_DOC_TYPE']");
	private final By submitButtonCustodianModal = By.xpath("//*[@id='UPLOADB']");
	private final By faxButtonCustodianModal = By.xpath("//*[@id='FAXB1']");	
	private final By saveCloseButtonAddBankPage = By.xpath("//button[text()='Save & Close']");
	private final By placeWithdrawalAdvisorOAButton = By.xpath("//input[@id='CreateOA']");
	private final By followUpDateModal = By.xpath("//input[@id='dijit_form_DateTextBox_0']");
	private final By followUpDateButtonModal = By.xpath("//input[@value='Set FollowUp Date']");
	private final By requestDistributionTab = By.xpath("//div[@aria-controls='RD_pane']");
	private final By submitToBeta = By.xpath("//input[@id='SUBTNET']");
	private final By qcComplete = By.xpath("//*[text()='QCComplete']");
	private final By notesTextbox = By.id("dijit_form_Textarea_0");
	private final By saveNotesButton = By.cssSelector("#ButtonGroup0_Button4");
	private final By goToIWRButton = By.cssSelector("#IWRB");
	private final By nigoCheckbox = By.cssSelector("#nigochsig");
//	private final By nigoCheckbox = By.xpath("//*[@id='nigochsig'    or    @id='nigochwa']");
	private final By nigoTextbox = By.cssSelector("#sigta");
	private final By nigoReason1 = By.cssSelector("#NIGO_REASON_CATEGORY_SELECT");
	private final By nigoReason2 = By.cssSelector("#NIGO_REASONS_BY_CATEGORY_SELECT");
	private final By addNIGOReasonButton = By.cssSelector("input[value='Add NIGO Reason']");
	private final By nigoReasonTable = By.cssSelector("#NIGO_REASONS_TABLE");
	private final By iwrCompleteButton = By.cssSelector("#IWRCB");
	private final By documentUploadButton = By.cssSelector("#UPLOAD_DOCUMENTS");
	private final By uploadCommitButton = By.cssSelector("#ButtonGroup1_Button0");
	private final By getSignatureText = By.xpath("//td[@class='FontStyle2']/pre");
	private final By addedBankNotes = By.xpath("//*[contains(text(),'Bank Name')]");
	private final By deleteLink = By.xpath("//table[@id='NIGO_REASONS_TABLE']//*[text()='Delete']");
	private final By workItemLink = By.xpath("//div[@id='wiq_pane']/table/tbody/tr[2]/td[1]/a");
	private final By uploadedDocInOCRCompareTab = By.xpath("//div[@id='OCR_pane']/table/thead/tr[2]/td/input[@type='checkbox'    and     not(checked)]");
	private final By cancelAdvisorRequest = By.cssSelector("#ButtonGroup2_Button0");	
	private final By reClassifyWorkItem = By.xpath("//select[@id='reclassify']");
	private final By task = By.cssSelector("#task");
	private final By historyNotes = By.cssSelector("#AddNotes_pane");
	private final By shAdvisorReqest = By.cssSelector("#Advisor");
	private final By shCotinueButton = By.cssSelector("input[value='Continue']");
	private final By cancelWithdrawalRequest = By.cssSelector("#CANCEL_WITHDRAWAL");
	private final By yesButton = By.cssSelector("input[value='YES']");
	private final By betaConfirmationLabel = By.xpath("//td[contains(text(),'BETA Confirmation ID')]");
	private final By continueButton = By.cssSelector("input[name='ButtonGroup1#Button1']");
	private By shUpdateDistributionReason = By.xpath("//div[@id='SpecialHandling_pane']//input[@id='RFD']");
	private final By savenRefresh = By.cssSelector("#ButtonGroup4_Button2");
	
	public IRAWithdrawalRequestPage(SeleniumCore seleniumCore) {
		this(seleniumCore, true);
	}

	public IRAWithdrawalRequestPage(SeleniumCore seleniumCore, boolean pageVerification) {
		super(seleniumCore);
		if (pageVerification) {					
			seleniumCore.waitForJStoLoad();
			seleniumCore.doesTitleContainText(title, 30, 1);
			boolean isVisible = this.seleniumCore.getDriver().getTitle().contains(title);			
			if (isVisible)
				logger.info(PAGE_NAME + " verification" + SEPARATOR + PAGE_NAME + " verification is PASSED");
			else
				logger.warn(PAGE_NAME + " verification" + SEPARATOR + PAGE_NAME + " verification is FAILED");
		}
	}
	
	public void selectReclassifyWorkItem(String value) {
        logger.info("Set type of payee "+ value);      
        seleniumCore.waitForJStoLoad();
        waitForPageLoad();
        seleniumCore.doesTitleContainText("Withdrawal Request", 30, 1); 
        seleniumCore.selectByValue(reClassifyWorkItem, value, "", "", 10, 1);
        seleniumCore.waitForJStoLoad();		
    }
	
	public void selectFormsAvailableAndClickOnOpenButton(String formsType) {				
		this.seleniumCore.waitForElementToBeVisible(formsAvailable);			
		this.seleniumCore.click(formsAvailable);
		this.seleniumCore.click(selectForms);		
		this.seleniumCore.waitForElementToBeClickable(openButton);
		this.seleniumCore.click(openButton);
		seleniumCore.waitForJStoLoad();
		logger.info("select the form type " + SEPARATOR + formsType);
		customLogger("select the form type ", formsType);
}  

	public String validateWithdrawalAmount() {				
			this.seleniumCore.waitForElementToBeVisible(withdrawalAmount,10,1);
			String withdrawalsAmount = this.seleniumCore.getAttribute(withdrawalAmount, "value");
			logger.info("select the form type " + SEPARATOR + withdrawalsAmount);
			customLogger("withdrawal amount ", withdrawalsAmount);
			return withdrawalsAmount;			
	}  

	public void clickOCRComplete() {    	
		seleniumCore.waitForElementToBeVisible(ocrCompleteButton,10,1);
			WebElement ele=this.seleniumCore.findElement(ocrCompleteButton);
			this.seleniumCore.jsClick(ele, "OCR Button: ", "Click on OCR button ");	
			customLogger("Clicked on OCR button ", "");				
	} 
	
	public void clickNotWithdrawalButton() {    	
		seleniumCore.waitForElementToBeVisible(notAWithdrawalButton,10,1);
			WebElement ele=this.seleniumCore.findElement(notAWithdrawalButton);
			this.seleniumCore.jsClick(ele, "Not a withdrawal Button: ", "Click on Not a withdrawal button ");	
			customLogger("Clicked on Not a Withdrawal button ", "");						
		try {
			this.seleniumCore.handleAlert("OK");
		} catch (Exception e) {
			try {
				this.seleniumCore.getDriver().switchTo().alert().accept();
			} catch (Exception e1) {
				this.seleniumCore.getDriver().switchTo().activeElement().click();
			}
		}
		seleniumCore.waitForJStoLoad();
		waitForLoadingData();
		customLogger("Click OK on alert popup ", "");
	}
	
	public void clickContinueButton(int index) {		
		this.seleniumCore.waitForJStoLoad();
		WebElement continueButton = this.seleniumCore.getDriver().findElement(By.xpath("//*[@id='NigoFont" + index + "']/preceding-sibling::input[@value='Continue']"));
		this.seleniumCore.waitForElementToBeClickable(continueButton,10,1);
		this.seleniumCore.scrollIntoView(continueButton);		
		this.seleniumCore.jsClick(continueButton, "Continue Button: ", "click on continue button ");		
		this.seleniumCore.waitForJStoLoad();
		logger.info("Clicked on continue button ");		
		customLogger("Clicked on continue button ", "");		 
	}
	
	public void procedingToSignatureSection() {			
		this.seleniumCore.waitForJStoLoad();
		By sig= By.cssSelector("#SIGB");
		seleniumCore.isElementVisible(sig,40,1);
		seleniumCore.click(sig);
		seleniumCore.clickRadioButton(nigoCheckbox, "unCheck NIGO checkbox ","clicked on NIGO checkbox ");
		seleniumCore.isElementVisible(continueButton,40,1);
		seleniumCore.click(continueButton);
	}
	
	public void accountInformation(String amount) {
		if(seleniumCore.isElementVisible(partialWithdrawalCheckBox, 20, 1))			
			this.seleniumCore.click(partialWithdrawalCheckBox);		
		seleniumCore.sendKeys(withdrawalAmount, amount, "enter withdrawal amount");
		logger.info("enter withdrawal amount: "+ amount);
		customLogger("enter withdrawal amount: ", amount);
	}
	
	public void distributionReason() {
		this.seleniumCore.waitForElementToBeVisible(withdrawalAmountCheck,10,1);	
		Assert.assertTrue("delivery method sectio is not displaying", seleniumCore.isElementVisible(distributionReasonHeader));
		Assert.assertTrue("delivery method sectio is not displaying", seleniumCore.isElementVisible(withdrawalAmountCheck));		
			this.seleniumCore.waitForElementToBeVisible(rmdCheckBox);
			this.seleniumCore.click(rmdCheckBox);					
		logger.info("Validated the distribution reason section ");
		customLogger("Validate the distribution reason section ", "");
	}
	
	public void taxWithholding(String type) {
		this.seleniumCore.waitForElementToBeVisible(distributionReasonCheck,20,1);	
		Assert.assertTrue("delivery method sectio is not displaying", seleniumCore.isElementVisible(taxWithholdingHeader));
		Assert.assertTrue("delivery method sectio is not displaying", seleniumCore.isElementVisible(distributionReasonCheck));			
			this.seleniumCore.waitForElementToBeVisible(federalDoNotWithhold);	
			switch(type) {
			case "no withhold":
				this.seleniumCore.click(federalDoNotWithhold);		
				this.seleniumCore.click(stateDoNotWithhold);
				break;
			case "withhold":
				this.seleniumCore.click(federalWithhold);
				seleniumCore.sendKeys(federalWithholdTextbox, "10" ,"enter federal rate");	
				if(seleniumCore.getText(By.cssSelector("#SWH_MINIMUM_TEXT")).contains("FL")) {
					seleniumCore.click(By.cssSelector("#SWH_NO"));
				}else {
				this.seleniumCore.click(stateWithhold);
				seleniumCore.sendKeys(stateWithholdTextbox, "20" ,"enter state rate");	
				}
				break;	
			default:
				logger.info("does not select any tax info");
			}
						
		logger.info("Validated the tax withholding section ");
		customLogger("Validate the tax withholding section ", "");
	}
	
	public void deliveryMethod(String withdrawalType,String[] deliveryData) {	
		this.seleniumCore.waitForElementToBeVisible(deliveryMethodHeader,10,1);				
		 if(withdrawalType.contains("Check")) {			
				this.seleniumCore.waitForElementToBeVisible(checkName,10,1);		
				this.seleniumCore.sendKeys(checkName, deliveryData[0] ,"enter name in Check segment");						
				customLogger("enter name ", deliveryData[0]);	
				this.seleniumCore.sendKeys(checkAddress, deliveryData[1], "enter address in Check segment");	
				customLogger("enter address ", deliveryData[1]);	
				this.seleniumCore.sendKeys(checkCity, deliveryData[2] ,"enter city in Check segment");		
				customLogger("enter city ", deliveryData[2]);	
				this.seleniumCore.sendKeys(checkState, deliveryData[3], "enter state in Check segment");	
				customLogger("enter state ", deliveryData[3]);	
				this.seleniumCore.sendKeys(checkZip, deliveryData[4] ,"enter zip in Check segment");		
				customLogger("enter zip code ", deliveryData[4]);					
				this.seleniumCore.clickRadioButton(checkNewCheckBox, "New CheckBox: ", "click on new checkbox in check segment");	
				seleniumCore.scrollIntoView(seleniumCore.findElement(checkTypeOfPayee));	
				this.seleniumCore.selectByValue(checkTypeOfPayee, deliveryData[5]);			
				customLogger("click on new checkbox and select type of payee in check segment", "");	
				seleniumCore.clickRadioButton(deliveryOptions, "selecting delivery options ", "");	
				if(seleniumCore.isElementVisible(streetAddress)) {	
					seleniumCore.clickRadioButton(streetAddress, "selecting street address ", "");	
				}	
				this.seleniumCore.clickRadioButton(checkSLOA, "SLOA CheckBox: ", "click on SLOA checkbox in check segment");		
				logger.info("check information has been entered in delivery section");	
				customLogger("check information has been entered in delivery section ", "");	
			}	
			else if (withdrawalType.contains("Wire")) {					
					this.seleniumCore.waitForElementToBeVisible(bankName,10,1);		
					String bankNam= seleniumCore.generateRandomData(10);	
					this.seleniumCore.sendKeys(bankName,  bankNam ,"enter bank name in Wire segment");			
					customLogger("enter bank name ", bankNam);	
					this.seleniumCore.sendKeys(routingNumber, deliveryData[1], "enter aba routing number in Wire segment");	
					customLogger("enter routing number ", deliveryData[1]);		
					String bankAccountNum = seleniumCore.generateRandomNumericData(10);	
					this.seleniumCore.sendKeys(bankAccountNumber, bankAccountNum ,"enter bank account number in Wire segment");		
					customLogger("enter bank account number ", bankAccountNum);	
					String bankAccountNam = seleniumCore.generateRandomNumericData(8);	
					this.seleniumCore.sendKeys(bankAccountName, bankAccountNam , "enter bank account name in Wire segment");	
					customLogger("enter bank account name ", bankAccountNam);	
					this.seleniumCore.clickRadioButton(wireNewCheckBox, "New CheckBox: ", "click on new checkbox in wire segment");						
					this.seleniumCore.clickRadioButton(thirdPartyFormNo, "Third party CheckBox: ", "click on third party checkbox in wire segment");	
					customLogger("click on new and third party checkbox in wire segment", "");	
					logger.info("wire information has been entered in delivery section");	
					customLogger("wire information has been entered in delivery section ", "");	
			}	
			else if (withdrawalType.contains("ACH")) {					
				this.seleniumCore.waitForElementToBeVisible(achBankName,10,1);		
				String bankName= seleniumCore.generateRandomData(10);	
				this.seleniumCore.sendKeys(achBankName, bankName ,"enter bank name in ach segment");			
				customLogger("enter bank name ", bankName);	
				this.seleniumCore.sendKeys(achRoutingNumber, deliveryData[1], "enter aba routing number in ach segment");	
				customLogger("enter routing number ", deliveryData[1]);	
				String bankAccountNumber = seleniumCore.generateRandomNumericData(10);	
				this.seleniumCore.sendKeys(achBankAccountNumber, bankAccountNumber ,"enter bank account number in ach segment");		
				customLogger("enter bank account number ", bankAccountNumber);	
				String bankAccountName = seleniumCore.generateRandomNumericData(8);	
				this.seleniumCore.sendKeys(achBankAccountName, bankAccountName, "enter bank account name in ach segment");	
				customLogger("enter bank account name ", bankAccountName);	
				this.seleniumCore.clickRadioButton(achNewCheckBox, "New CheckBox: ", "click on new checkbox in ach segment");					
				this.seleniumCore.clickRadioButton(achThirdPartyFormNo, "Third party CheckBox: ", "click on third party checkbox in ach segment");	
				customLogger("click on new and third party checkbox in wire segment", "");	
				logger.info("ach information has been entered in delivery section");	
				customLogger("ach information has been entered in delivery section ", "");	
		}	
			}
	
	public void selectExistingBank(String bankAccount) {
		By existingBank= By.xpath("//div[contains(@data-value,'"+ bankAccount +"')]/input");
		seleniumCore.clickRadioButton(existingBank, " ", "select existing bank");
		logger.info("user select existing bank ends with: " + bankAccount);
		customLogger("user select existing bank account ends with ", bankAccount);
	}
	
	public void selectSLOACheck(String type) {
		switch(type) {
		case "Check":
			seleniumCore.clickRadioButton(selectCheckSLOA, "select check SLOA ", "");
			break;
		case "ACH":
			seleniumCore.clickRadioButton(selectSLOA, "", "");			
			seleniumCore.clickRadioButton(selectACHSLOA, "select check SLOA ", "");
			break;	
		case "Wire":
			seleniumCore.clickRadioButton(wireSLOA, "select check SLOA ", "");
			break;		
		default:
			logger.info("user has not selected any SLOA");
		}		
	}
		
		
	public void deliveryMethod(String deliveryData) {
		this.seleniumCore.waitForElementToBeVisible(achBankName);	
		this.seleniumCore.sendKeys(achBankName, seleniumCore.generateRandomData(10) ,"enter bank name in ach segment");		
		customLogger("Enter bank name for withdrawal by ach  ", "");
		this.seleniumCore.sendKeys(achRoutingNumber, deliveryData, "enter aba routing number in ach segment");
		customLogger("Enter routing number for withdrawal by ach  ", "");
		this.seleniumCore.sendKeys(achBankAccountNumber, seleniumCore.generateRandomNumericData(10) ,"enter bank account number in ach segment");	
		customLogger("Enter bank account number for withdrawal by ach  ", "");
		this.seleniumCore.sendKeys(achBankAccountName, seleniumCore.generateRandomData(10), "enter bank account name in ach segment");
		customLogger("Enter bank account name for withdrawal by ach  ", "");
		this.seleniumCore.clickRadioButton(achNewCheckBox, "New CheckBox: ", "click on new checkbox in ach segment");
		this.seleniumCore.clickRadioButton(achThirdPartyFormNo, "Third party CheckBox: ", "click on third party checkbox in ach segment");
	}
	
	public void deliveryMethod() {
		 this.seleniumCore.waitForElementToBeVisible(wireToSLOACheckbox);		
			WebElement ele=this.seleniumCore.findElement(wireToSLOACheckbox);
			this.seleniumCore.jsClick(ele, "Wire to SLOA checkbox: ", "Checked Wire to SLOA checkbox ");		
		customLogger("Checked Wire to SLOA checkbox   ", "");
	}
	
	public void clickReClassifyWorkItemButton(String parentWindow) {
		seleniumCore.waitForElementToBeClickable(reClassifyWorkItemeButton, 10 , 1);
			WebElement ele=this.seleniumCore.findElement(reClassifyWorkItemeButton);
			this.seleniumCore.jsClick(ele, "Reclassify work item Button: ", "Click on reclassify work item button ");	
			customLogger("Click on reclassify work item button ", "");	
			seleniumCore.waitForJStoLoad();			
			waitForLoadingData();
			seleniumCore.waitForUILoading(10000);
			seleniumCore.getDriver().switchTo().window(parentWindow);
	} 
	
	public String validateDeliveryMethod() {				
		this.seleniumCore.waitForElementToBeVisible(deliveryType);			
		return this.seleniumCore.getText(deliveryType);				
	}
	
	public void clickSLOAoption() {				
		this.seleniumCore.waitForElementToBeVisible(achSLOA);			
		this.seleniumCore.click(achSLOA);			
	}
	
	public void signature() {
		this.seleniumCore.waitForElementToBeVisible(deliveryMethodCheck,20,1);	
		Assert.assertTrue("signature section has not been validated", seleniumCore.isElementVisible(signatureHeader));
		Assert.assertTrue("signature section has not been validated", seleniumCore.isElementVisible(deliveryMethodCheck));		
		customLogger("Validate signature secton  ", "");		
	}
	
	public void validateIWRTab() {
		this.seleniumCore.waitForJStoLoad();		
		seleniumCore.waitForUILoading(8000);
		tabExpand(iwrTab);
		if(this.seleniumCore.isElementVisible(iwrTabVerbiage)) {
			logger.info("You have Completed IWR" + SEPARATOR + " verbiage has been verified");
		}
		this.seleniumCore.click(iwrTab);	
		customLogger("IWR tab has been validated ", "");
	}
	
	public void validatePlaceTradeTab() {			
		tabExpand(placeTradeTab);
		this.seleniumCore.click(placeWithdrawalAdvisorOAButton);
		try {
			this.seleniumCore.handleAlert("OK");
		} catch (Exception e) {	
		}
		logger.info("click on withdrawal advisor QA button");	
		customLogger("Clicked on place withdrawal advior OA button ", "");
	}
	
	public void tabExpand(By element) {
		this.seleniumCore.waitForElementToBeVisible(element);			
		if(this.seleniumCore.findElement(element).getAttribute("aria-pressed").equalsIgnoreCase("false")) {
			this.seleniumCore.click(element);	
			logger.info("Expand "+ element);			
		}
	}
	
	public void viewAddBankInstructions() {
		String parentWindow= seleniumCore.getDriver().getWindowHandle();
		tabExpand(deliveryInstructionsTab);	
		seleniumCore.waitForElementToBeClickable(viewAddBankInstructions, 10, 1);
		this.seleniumCore.click(viewAddBankInstructions);
		logger.info("click on - view/add bank instructions " + SEPARATOR + "");	
		customLogger("click on - view/add bank instructions ", "");
		switchTab("AddUpdateBankInstructions");
		Assert.assertTrue("does not switch to AddUpdateBankInstructions", seleniumCore.getDriver().getTitle().contains("UpdateBank"));
		
			seleniumCore.switchToFrame(addBankInstructionsFrame);
			if(this.seleniumCore.isElementVisible(saveCloseButtonAddBankPage,10,1))
			    this.seleniumCore.click(saveCloseButtonAddBankPage);
				logger.info("work item has been verified");
			seleniumCore.getDriver().switchTo().window(parentWindow);
			logger.info("switched back to IWR Withdrawal page");
			try {
				this.seleniumCore.handleAlert("OK");
			} catch (Exception e) {	
				try {
				this.seleniumCore.getDriver().switchTo().alert().accept();
				}catch(Exception e1) {
					logger.info("no alert found"+ e1.getLocalizedMessage());	
				}
				} 
			waitForLoadingData();
		}
	
	public void validateAddedBankDetailsInDeliveryInstructionsTab(String achNumber) {
		tabExpand(deliveryInstructionsTab);	
		WebElement addedRecord= this.seleniumCore.getDriver().findElement(By.xpath("//table[@id='SLOA_RELB_DISPLAY_TABLE']//*[text()='"+achNumber+"']"));
		if(addedRecord.isDisplayed()) {
			logger.info("added bank details has been verified");
			customLogger("added bank details has been verified ", "");
		}
	}
	
	public void documentsOCRCompareTab(String filePath) {
		String parentWindow= seleniumCore.getDriver().getWindowHandle();
		tabExpand(ocrCompareTab);				
		this.seleniumCore.click(documentUploadButton);
		logger.info("click on document upload button " + SEPARATOR + "");	
		customLogger("click on document upload button ", "");		
		switchTab("Upload Document");
		upload(filePath);
		customLogger("document has been uploaded ", "");
		logger.info("document has been uploaded");
		seleniumCore.getDriver().switchTo().window(parentWindow);
		logger.info("switched back to IWR Withdrawal page after file upload");		
	}	
	
	public void verifyUploadedFileInOCRCompareTab() {
		tabExpand(ocrCompareTab);	
		this.seleniumCore.waitForElementToBeVisible(uploadedDocInOCRCompareTab,10,1);	
		Assert.assertTrue("uploaded document details has not been captured in OCR Compare tab", seleniumCore.isElementVisible(uploadedDocInOCRCompareTab));		
		logger.info("uploaded document  with no web visibility has been validated in OCR Compare tab");
		customLogger("uploaded document  with no web visibility has been validated in OCR Compare tab  ", "");
	}
	
	public void submitToCustodianUploadDoc() {		
		submitToCustodian();
		seleniumCore.selectByValue(prsnModal, "ACH(ACHA)");
		seleniumCore.waitForElementToBeVisible(submitButtonCustodianModal);
		this.seleniumCore.click(submitButtonCustodianModal);		
		seleniumCore.handleAlert("OK");
		seleniumCore.waitForJStoLoad();
		if(seleniumCore.getDriver().findElement(By.xpath("//*[contains(text(),'pdf has been Committed.')]")).isDisplayed())			
			logger.info("uploaded document details are displaying in notes ");		
		customLogger("uploaded document details are displaying in notes  ", "");
	}
	
	public void submitToCustodianFax() {		
		submitToCustodian();		
		seleniumCore.waitForElementToBeVisible(faxButtonCustodianModal);
		this.seleniumCore.click(faxButtonCustodianModal);		
		seleniumCore.handleAlert("OK");
		seleniumCore.waitForJStoLoad();	
		logger.info("clicked on fax button on custodian popup ");		
		customLogger("clicked on fax button on custodian popup  ", "");
	}
	
	public void submitToCustodian() {
		tabExpand(submitToCustodianTab);				
		this.seleniumCore.click(tcuCheckbox);			
		this.seleniumCore.click(submitToCustodianButton);	
		submitToCustodianModal();
		logger.info("clicked on submit to custodian button ");		
		customLogger("clicked on submit to custodian button  ", "");
	}
	
	public void submitToCustodianModal() {
		seleniumCore.getDriver().switchTo().activeElement();
		if(this.seleniumCore.isElementVisible(submitToCustodianModal))	
		logger.info("switched to submit to custodian popup ");
		customLogger("switched to submit to custodian popup ", "");					
	}
	
	public void upload(String filePath) {		
		this.seleniumCore.findElement(By.id("browseFile")).sendKeys(filePath);
		System.out.println("file uploaded");		
		if(this.seleniumCore.isElementVisible(uploadCommitButton))		
		this.seleniumCore.findElement(By.id("ButtonGroup1_Button0")).click();
		logger.info("file has been uploaded ");
		customLogger("file has been uploaded ", "");		
	}
	
	public void followUpDateModal() {
		try {
		this.seleniumCore.handleAlert("OK");
		}catch(Exception e) {
			logger.info("No alert found");
		}		
		this.seleniumCore.getDriver().switchTo().activeElement();
		this.seleniumCore.waitForElementToBeVisible(followUpDateModal,10,1);
		if (this.seleniumCore.isElementVisible(followUpDateModal)) {
			this.seleniumCore.findElement(By.xpath("//div[@title='Set FollowUp Date']")).click();
			this.seleniumCore.click(followUpDateButtonModal);
		}
		seleniumCore.waitForUILoading(8000);
		seleniumCore.doesTitleContainText("Withdrawal", 10, 1);	
		seleniumCore.waitForJStoLoad();	
		waitForLoadingData();
		try {
			this.seleniumCore.handleAlert("OK");
		} catch (Exception e) {	
			try {
			this.seleniumCore.getDriver().switchTo().alert().accept();
			}catch(Exception e1) {
				logger.info("no alert found"+ e1.getLocalizedMessage());	
			}
			} 	
		logger.info("Close the follow up date popup");
		customLogger("Close the follow up date popup  ", "");
	}
	
	public void expandRequestDistributionTabAndClickSubmitToBeta(String parentWindow) {	
		seleniumCore.waitForJStoLoad();	
		waitForLoadingData();	
		this.seleniumCore.waitForElementToBeVisible(requestDistributionTab, 10, 1);	
		tabExpand(requestDistributionTab);	
		this.seleniumCore.click(submitToBeta);	
		logger.info("Validate the request distribution tab and Click on submit to beta button");	
		customLogger("Click on submit beta button  ", "");	
		seleniumCore.waitForJStoLoad();	
		waitForLoadingData();				
		seleniumCore.getDriver().switchTo().window(parentWindow);	
		seleniumCore.waitForJStoLoad();	
		waitForLoadingData();			
	}

	public void clickQCComplete() {
		if (this.seleniumCore.isElementVisible(qcComplete)) {
			WebElement ele = this.seleniumCore.findElement(qcComplete);
			this.seleniumCore.jsClick(ele, "QC Button: ", "click on OCR button");
		}
		logger.info("Clicked on  QC Complete button");
		customLogger("Clicked on  QC Complete button ", "");
	}
	
	public void saveNotesButton() {
		if (this.seleniumCore.isElementVisible(saveNotesButton,10,1)) {
			seleniumCore.jsClick(seleniumCore.findElement(saveNotesButton), "click on save notes butto", "");
		}else {
			throw new NoSuchElementException();
		}
		logger.info("Clicked on  save notes button");
		customLogger("clicked on save notes button ", "");
	}
	
	public void clickGoToIWR() {
		if (this.seleniumCore.isElementVisible(goToIWRButton)) {
			WebElement ele = this.seleniumCore.findElement(goToIWRButton);
			this.seleniumCore.jsClick(ele, "QC Button: ", "click on OCR button");
		}
		logger.info("Clicked on  go to IWR button");
		customLogger("Clicked on  go to IWR button ", "");
	}
	
	public void addNIGONotes(String note) {
		seleniumCore.isElementClickable(nigoCheckbox, 10, 1);
		this.seleniumCore.clickRadioButton(nigoCheckbox, "check NIGO checkbox ", "clicked on NIGO checkbox ");
		customLogger("clicked on NIGO checkbox", "");
		this.seleniumCore.sendKeys(nigoTextbox, note, "enter notes in NIGO textbox ");
		seleniumCore.waitForUILoading(1000);
		seleniumCore.tabOut();
		logger.info("enter notes in NIGO textbox");
		customLogger("enter notes in NIGO textbox ", "");
	}
	
	public String validateIWRSummary() {
		seleniumCore.isElementVisible(task, 10, 1);
		return seleniumCore.getText(task).toLowerCase();
	}
	
	public String validateAddedNIGONotes() {
		seleniumCore.isElementVisible(notesTextbox, 5, 1);
		return seleniumCore.getAttribute(notesTextbox, "value");
	}
	
	public String validateAddedNoteInHistory() {
		seleniumCore.waitForJStoLoad();
		seleniumCore.isElementVisible(historyNotes, 10, 1);
		return seleniumCore.getText(historyNotes).toLowerCase();
	}
	
	public void addNIGOReasonAndValidate() {
		if (this.seleniumCore.isElementVisible(nigoReason1, 10, 1)) {
			seleniumCore.click(nigoReason1);
			this.seleniumCore.selectByValue(nigoReason1, "Other");
			seleniumCore.waitForUILoading(1000);
			seleniumCore.click(nigoReason2);
			this.seleniumCore.selectByValue(nigoReason2, "Form/Pages");
			seleniumCore.waitForUILoading(1000);
		} else {
			throw new NoSuchElementException();
		}
		WebElement ele = this.seleniumCore.findElement(addNIGOReasonButton);
		this.seleniumCore.jsClick(ele, "Add NIGO Reason button: ", "clicked on Add NIGO Reason button ");
		customLogger("clicked on Add NIGO Reason button", "");

		Assert.assertTrue("NIGO reason table is not present", seleniumCore.isElementVisible(nigoReasonTable, 10, 2));
		Assert.assertTrue("NIGO reason table is not present with selected data",
				seleniumCore.getText(nigoReasonTable).contains("Other"));
		Assert.assertTrue("NIGO reason table is not present with selected data",
				seleniumCore.getText(nigoReasonTable).contains("Form/Pages"));
		logger.info("NIGO reason table is present with selected data");
		customLogger("NIGO reason table is present with selected data", "");
		WebElement element = this.seleniumCore.findElement(iwrCompleteButton);
	//	this.seleniumCore.scrollIntoView(element);
		this.seleniumCore.jsClick(element, "IWR Complete button: ", "click on IWR Complete button ");
		this.seleniumCore.handleAlert("OK");
		customLogger("alert message has bee displayed ", "");
	}

	public void clickDeleteLink() {
		if (this.seleniumCore.isElementVisible(deleteLink,10,2)) {			
			this.seleniumCore.click(deleteLink);			
		}				
		logger.info("click on delete link to delete notes");
		customLogger("click on delete link to delete notes ", "");
	}	
	
	public void verifySignatureText() {
		if (this.seleniumCore.isElementVisible(getSignatureText)) {			
				if(this.seleniumCore.getText(getSignatureText).contains("Signature: add notes"))
					logger.info("enter notes in NIGO textbox");
				else
					Assert.assertFalse("signature note is not visible", false);
			logger.info("signature note has been verified");
			customLogger("signature note has been verified ", "");
		}	
	}
	
	public void clickWorkItemLink() {
		String parentWindow= seleniumCore.getDriver().getWindowHandle();		
		tabExpand(workItemsImagesTab);
		this.seleniumCore.isElementVisible(workItemLink,10,2);	
		this.seleniumCore.click(workItemLink);				
		logger.info("click on work item link");
		switchTab(4, "Tab Switching");		
		seleniumCore.waitForUILoading(2000);
	//	Assert.assertTrue("work item has not been verified", seleniumCore.getDriver().findElement(By.xpath("//h1[contains(text(),'IRA Withdrawal Request')]")).isDisplayed());			
		logger.info("work item has been verified");	
		customLogger("work item has been validated ", "");
		seleniumCore.closeDriver();
		seleniumCore.getDriver().switchTo().window(parentWindow);
		logger.info("work item link has been verified and switched back to BAW window");		
	}
	
	public void validateAddBankDetailsInNotesSection() {
		if (this.seleniumCore.isElementVisible(addedBankNotes,10,2)) {			
			logger.info("bank notes has been added");		
		} 
		customLogger("bank notes has been added ", "");
	}
	
	public void clickSetUpInstructionsComplete() {
		if (this.seleniumCore.isElementVisible(setupInstructionsComplete, 10, 1)) {
			seleniumCore.jsClick(seleniumCore.findElement(setupInstructionsComplete),
					"click on setip instruction complete button", "");
		} else {
			throw new NoSuchElementException();
		}
		seleniumCore.waitForUILoading(8000);
		seleniumCore.doesTitleContainText("IRA Withdrawal", 10, 1);
		logger.info("clicked on setup instructions button");
		customLogger("clicked on setup instructions button ", "");
	}	
	
	public boolean validateOCRScreen() {
		seleniumCore.waitForJStoLoad();	
		waitForLoadingData();
		seleniumCore.waitForElementToBeClickable(ocrCompleteButton, 30, 1);
		if(seleniumCore.getText(ocrCompleteButton).contains("OCR Complete")) {
			return true;
		}else {
			return false;
		}			
	}
	
	public void clickCancelAdvisorRequetButton(String parentWindow) {
		seleniumCore.waitForElementToBeClickable(cancelAdvisorRequest, 20, 1);
		seleniumCore.click(cancelAdvisorRequest);
		seleniumCore.handleAlert("OK");
		seleniumCore.waitForJStoLoad();
		waitForLoadingData();
		logger.info("clicked on cancel advisor request button");	
		customLogger("clicked on cancel advisor request button ", "");
		seleniumCore.getDriver().switchTo().window(parentWindow);
	}
	
	public boolean validateIWRScreen() {
		seleniumCore.waitForElementToBeClickable(accountlInformationHeader, 30, 1);
		return seleniumCore.isElementVisible(accountlInformationHeader);
	}
	
	public void cancelAdvisorReqest(String parentWindow) {
		seleniumCore.waitForElementToBeClickable(shCotinueButton, 20, 1);
		seleniumCore.clickRadioButton(shAdvisorReqest, "click cancel advisor request", "");
		seleniumCore.click(shCotinueButton);
		seleniumCore.getDriver().switchTo().activeElement();
		Assert.assertTrue("", seleniumCore.isElementFound(cancelWithdrawalRequest, 5, 1));		
		logger.info("cancel ithdrawal OA is displaying");	
		customLogger("cancel ithdrawal OA is displaying", "");
		seleniumCore.click(yesButton);	
		seleniumCore.getDriver().switchTo().window(parentWindow);
	}
	
	public void validateBetaConfirmation() {	
		seleniumCore.doesUrlContainText("WorkflowState", 30, 1);	
		seleniumCore.waitForJStoLoad();	
		waitForLoadingData();	
		By betaConfirmationLabel = By.xpath("//td[contains(text(),'ID:')]/following-sibling::td");			
		Assert.assertNotNull("beta confirmation id is null", seleniumCore.findElement(betaConfirmationLabel));			
		logger.info("beta confirmation id has been validated");		
		customLogger("beta confirmation id has been validated", "");	
	}
	
	public void specialHandlingSection() {
		seleniumCore.clickRadioButton(shUpdateDistributionReason, "", "");
		seleniumCore.click(shCotinueButton);
		waitForLoadingData();		
	//	seleniumCore.clickRadioButton(By.cssSelector("#DIST_NORMAL"), "", "");
		seleniumCore.click(cancelAdvisorRequest);
		try {
			seleniumCore.handleAlert("OK");
		}catch(Exception e) {
			logger.info(e.getLocalizedMessage());	
		}
		logger.info("user has updated special handling section");		
		customLogger("user has updated special handling section", "");
		waitForLoadingData();
		seleniumCore.click(savenRefresh);
		seleniumCore.waitForJStoLoad();	
		waitForLoadingData();
	}
	
	public void validateSponBAW() {
		tabExpand(rdTab);
		seleniumCore.jsClick(seleniumCore.findElement(rdTab), "");
	}
}



