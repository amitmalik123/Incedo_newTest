package com.amk.cucumber.pages;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.amk.cucumber.instantiator.Instantiator;
import com.amk.cucumber.utility.CommonMethods;
import com.amk.cucumber.utility.SeleniumCore;

public class AccountWizardPage extends CommonMethods implements Instantiator<AccountWizardPage> {

	// Static Data
	private static final String PAGE_NAME = "Account Wizard tab";

	// Navigation
	private final By newClientHeader = By.xpath("//*[text()='Create a new client']");
	private final By searchField = By.xpath("//input[@id='ctl00_cphContentArea_txtSearch']");
	private final By goButton = By.xpath("//input[@id='ctl00_cphContentArea_btnSearch']");
	private final By newClientGoButton = By.xpath("//input[@id='ctl00_cphContentArea_Button1']");
	private final By completeAndPrintBtn = By.xpath("//*[@id='HTMLPrintButton'   or    @id='PrintButton']");
	private final By clientSignatureModalContinueButton = By.xpath("//span[text()='Continue']/parent::button[@class='formButton']");
	private final By signerInformationModalContinueButton = By.id("btnContinue");
	private final By completeAndSubmitBtn = By.xpath("//input[@id='OnlineSubmitbutton']");
	private final By dTrackingId = By.xpath("//div[@id='divConfirmation']//b//a");
	private final By readyForSignature = By.xpath("//div[@id='divConfirmation']");
	protected By trackingCenterTab = By.xpath("//a[@id='ctl00_rItems_hLink_2'     or      text()='Tracking Center' and not(@id)]       |    //a[@id='header_0_content_0_rItems_hLink_2'   and    contains(.,'Tracking Center')]");
	private final By addRegistration = By.xpath("//a[text()='Add a Registration']");
	private final By taxHarvestRequest = By.xpath("//li[text()='Gain Loss Tax Harvest Request']");
	private By radiobuttonclientSignature = By.xpath("//input[@id='rbPrint']");
	private final By withoutsignButton = By.xpath("//span[contains(text(),'Continue')]");
	public final By completeAndEsigntBtn = By.xpath("//input[@id='eSignatureButton']");
	private By accHolderName = By.id("txtAccountHolderName1");
	private By clientEmail = By.id("txtAccountHolderEmail1");
	private By radbtnInPerson1 = By.id("radbtnInPerson1");
	private By radbtnInPerson2 = By.id("radbtnInPerson2");
	protected final String commonEmailForClient = "nonproduction@assetmark.com";
	private final By byPersonButton = By.xpath("//input[@id='btnContinue']");
	private  By clientESignRadioBtn = By.xpath("//input[@id='rbEsign']");
	private By clientaccfromResults = By.xpath("(//tr[@class='GridItem'])[1]");
	private final By ClientManagement = By.xpath("//span[text()='Client Management']");
	private final By subHeading = By.cssSelector("#A1");
	private final By withDrawalMethodHeading = By.xpath("//div[@id='InterviewQuestions']/div");
	private final By modalContinueButton = By.xpath("//input[@id='btnContinue']");
	private final By checkAddrNew = By.cssSelector("#rbChkAddrNew");
	private final By wireAddrNew = By.cssSelector("#rbWireNewBank");
	private final By achAddrNew = By.cssSelector("#rbAchNewBank");

	// Body

	protected String trackingId;

	@Override
	public AccountWizardPage getInstance() {
		return new AccountWizardPage(seleniumCore);
	}

	public AccountWizardPage(SeleniumCore seleniumCore) {
		this(seleniumCore, true);
	}

	public AccountWizardPage(SeleniumCore seleniumCore, boolean pageVerification) {
		super(seleniumCore);

		waitForAllLoadingImagesToBeDisappear();
		if (pageVerification) {
			if ((seleniumCore.isElementVisible(newClientHeader, 20, 1))   ||   seleniumCore.isElementVisible(subHeading, 20, 1) ) {
				logger.info(PAGE_NAME + " verification" + SEPARATOR + PAGE_NAME + " verification is PASSED");
			} else {
				logger.warn(PAGE_NAME + " verification" + SEPARATOR + PAGE_NAME + " verification is FAILED");
			}
		}
	}

	public void clickClient(String client, String stepName, String logMessage) {
		String path = "//a[contains(text(), " + "'" + client + "'" + ")]";
		this.seleniumCore.click(By.xpath(path), stepName, logMessage);

	}

	public AccountWizardPage clickClient(String client, String pick, String stepName, String logMessage) {
		String path = "(//a[contains(text(), " + "'" + client + "'" + ")])" + "[" + pick + "]";
		this.seleniumCore.click(By.xpath(path), stepName, logMessage);

		return new AccountWizardPage(seleniumCore);
	}

	public Object selectClientManagementOption(String option) {
		seleniumCore.waitForJStoLoad();
		waitForLoadingData();
		String path = "//*[contains(text(), " + "'" + option + "'" + ")]";
		this.seleniumCore.waitForElementToBeClickable(By.xpath(path), 15, 1);
		this.seleniumCore.click(By.xpath(path), "", "", 10, 1);
		logger.info("Clicked on client management option: "+ option);
		customLogger("Clicked on client management option:  ", option);
		switch(option) {
		case "Change Your Financial Advisor Fee":
			return new FeesPage(seleniumCore);			
		case "Change Investments":
			return new InvestmentChangePage(seleniumCore);			
		case "View Document History":
			return new ViewDocumentsPage(seleniumCore);			
		case "Add a Registration":
			return new ConstructPortfolioPage(seleniumCore);
		}	
		return null;
	}

	/**
	 * To find needed client
	 * 
	 * @param client
	 * @param stepName
	 * @param logMessage
	 */
	public void findClient(String client, String logMessage) {
		this.seleniumCore.sendKeys(searchField, client, logMessage);
		this.seleniumCore.click(goButton);
	}

	public void clickAccount(String account) {
		seleniumCore.waitForJStoLoad();
		waitForLoadingData();
		By accountCheckbox = By.xpath("//label[contains(text(), '" + account + "')]");
		if(seleniumCore.isElementFound(By.xpath("//label[contains(text(), '"+ account +"') ]/preceding-sibling::div//input[@checked]"), 4, 1)){		
			logger.info("account already selected ");
		}else {
		this.seleniumCore.waitForElementToBeVisible(accountCheckbox);
		this.seleniumCore.click(accountCheckbox, PAGE_NAME, "Clicking on Account with number " + account);
		customLogger("Clicking on Account with number ", account);
		}
	}

	public void selectRequest(String request) {
		seleniumCore.waitForElementToBeClickable(By.xpath("//li[contains(text(), '" + request + "')]"), 20, 1).click();
		customLogger("Clicking on request ", request);
	}

	public void selectType(String type) {
		seleniumCore.waitForJStoLoad();
		seleniumCore.waitForElementToBeClickable(By.xpath("//li[contains(text(), '" + type + "')]"), 20, 1).click();
		customLogger("Clicking on type  ", type);
	}
	
	public List<String> tmsCancelForm() {
	return	seleniumCore.findElements(By.cssSelector(".formscontent")).stream().map(WebElement::getText).collect(Collectors.toList());
	}

	public DocuSignPage clickCompleteAndPrintBtn() {
		this.seleniumCore.waitForElementToBeVisible(completeAndPrintBtn, 10, 1);
		this.seleniumCore.click(completeAndPrintBtn);
		logger.info("Clicked on complete and print button ");
		customLogger("Clicked on complete and print button ", "");
		return new DocuSignPage(seleniumCore);
	}
	
	public TaxManagementServices clickCompleteAndPrintBtnForTMS() {
		this.seleniumCore.waitForElementToBeVisible(completeAndPrintBtn, 10, 1);
		this.seleniumCore.click(completeAndPrintBtn);
		logger.info("Clicked on complete and print button ");
		customLogger("Clicked on complete and print button ", "");
		return new TaxManagementServices(seleniumCore);
	}

	public void clickCompleteAndSubmitBtn() {
		this.seleniumCore.waitForElementToBeVisible(completeAndSubmitBtn);
		this.seleniumCore.click(completeAndSubmitBtn);

		logger.info("Clicked on complete and submit button ");
		customLogger("Clicked on complete and submit button ", "");
	}

	public void clickCompleteOnClientSignatureModel() {
		this.seleniumCore.getDriver().switchTo().activeElement();
		this.seleniumCore.waitForElementToBeVisible(clientSignatureModalContinueButton);
		this.seleniumCore.click(clientSignatureModalContinueButton);
		this.seleniumCore.waitForJStoLoad();
		logger.info("Click on client signature model continue button ");
		customLogger("Click on client signature model continue button ", "");
	}

	public Object clickCompleteOnSignerInformationModel(String request) {	
		seleniumCore.waitForJStoLoad();
		waitForLoadingData();
		this.seleniumCore.getDriver().switchTo().activeElement();		
		if(!seleniumCore.waitForElementToBeInVisible(By.id("esig_iframe"), 5, 1)) {			
			this.seleniumCore.switchFrameById("esig_iframe");				
			this.seleniumCore.click(signerInformationModalContinueButton);	
			logger.info("Click on signer information model continue button ");	
			customLogger("Click on signer information model continue button ", "");	
			seleniumCore.waitForJStoLoad();	
			waitForLoadingData();	
		}	
		seleniumCore.waitForJStoLoad();
		if(request.contains("tax management")) {
			return new TaxManagementServices(seleniumCore);
		}else {
		return new DocuSignPage(seleniumCore);	
		}
	}

	public Object[] fetchDTrackingId() {
		Object[] trackingIdItemsDetails = new Object[2];
		this.seleniumCore.isElementVisible(readyForSignature, 30, 1);
		this.seleniumCore.getLogger().info(PAGE_NAME + SEPARATOR + "Ready For Signatures dialog Box is visible");		
		trackingId = this.seleniumCore.getText(dTrackingId);
		seleniumCore.click(dTrackingId, PAGE_NAME, "Click on tracking id");
//		this.seleniumCore.click(closeBtn, PAGE_NAME, "Clicking on Close button");
		customLogger("fetched d track id and clicked on close button", "");		
		trackingIdItemsDetails[0] = trackingId;
		trackingIdItemsDetails[1]=new ItemDetailsPage(seleniumCore);
		
		return trackingIdItemsDetails;
	}

	public TrackingCenterPage clickTrackingCenterTab() {
		seleniumCore.isElementVisible(trackingCenterTab, 20, 1);
		this.seleniumCore.click(trackingCenterTab, PAGE_NAME, "Clicking on tracking center tab");
		customLogger("Clicking on tracking center tab", "");

		return new TrackingCenterPage(seleniumCore);
	}		

	public ConstructPortfolioPage clickAddRegistration() {
		this.seleniumCore.waitForElementToBeVisible(addRegistration, 5, 1);
		this.seleniumCore.click(addRegistration);
		return new ConstructPortfolioPage(seleniumCore);
	}

	public ClientProfilePage clickGoButton() {
		seleniumCore.click(newClientGoButton);

		return new ClientProfilePage(seleniumCore);
	}	

	public void selectSearchedClient() {
		this.seleniumCore.click(clientaccfromResults, "Click on to search clients", "Clicked displayed client");
		customLogger("Selected Displayed Client", "");
		this.seleniumCore.waitForElementToBeVisible(ClientManagement);

	}
	
	public void SelectApplicableHNWAccount(String accountnum) {
		List<WebElement> elements = this.seleniumCore
				.findElements(By.xpath("//label[(contains(@for,'ctl00_cphContentArea_rdlAccountList'))]"));
		logger.info("accounts size : " + elements.size());
		if (elements.size() > 1) {
			for (WebElement ele : elements) {
				if (ele.getText().contains(accountnum)) {
					ele.click();
					break;
				} else {
					logger.info("Account found was not a match");
				}
			}
		} else {
			logger.info("Account was a defualt match");
		}
	}
	
	public boolean clickTaxHarvestRequestLink() {
		boolean value = false;
		this.seleniumCore.waitForElementToBeVisible(taxHarvestRequest);
		this.seleniumCore.click(taxHarvestRequest, PAGE_NAME, "Clicking on Tax Loss Harvest");
		customLogger("Clicking on Tax Loss Harvest", "");
		return value;
	}
	
	public TaxHarvestRequestPage clickContinueBtnForCompleteAndSubmit() {
		logger.info("utlizing direct click .. ");
		this.seleniumCore.findElement(radiobuttonclientSignature).click();
		customLogger("Clicking on Complete and submit button", "");
		this.seleniumCore.waitForElementToBeVisible(withoutsignButton);
		this.seleniumCore.click(withoutsignButton);
		customLogger("Clicking on Continue Button", "Clicked");
		waitForSpinnerToBeDisappear();
		return new TaxHarvestRequestPage(seleniumCore);
	}
	
	public TaxHarvestRequestPage clickCompleteAndPrintButton() {
		this.seleniumCore.waitForElementToBeVisible(completeAndPrintBtn);
		this.seleniumCore.click(completeAndPrintBtn);
		customLogger("clicking on Complete and Print Button", "");
		waitForSpinnerToBeDisappear();
		return new TaxHarvestRequestPage(seleniumCore);
	}
	
	public void clickCompleteAndEsignBtn() {
		this.seleniumCore.waitForElementToBeVisible(completeAndEsigntBtn);
		this.seleniumCore.click(completeAndEsigntBtn);
		waitForSpinnerToBeDisappear();
	}
	
	public TaxHarvestRequestPage insertAccdetailsforpersonalSign(String clientName) {
		this.seleniumCore.switchFrameById("esig_iframe");
		this.seleniumCore.findElement(accHolderName).sendKeys(clientName);
		this.seleniumCore.findElement(clientEmail).sendKeys(commonEmailForClient);
		customLogger("Entered client account Details", "");
		this.seleniumCore.findElement(radbtnInPerson1).click();
		this.seleniumCore.findElement(radbtnInPerson2).click();
		logger.info("utlizing direct click .. ");
		this.seleniumCore.waitForElementToBeVisible(byPersonButton);
		this.seleniumCore.click(byPersonButton);
		waitForSpinnerToBeDisappear();
		seleniumCore.switchToDefaultContent();
		return new TaxHarvestRequestPage(seleniumCore);
	}
	
	public void selectClientESign() {
		this.seleniumCore.findElement(clientESignRadioBtn).click();
		customLogger("Selecting Electronic Signature Option","Selected");
		waitForSpinnerToBeDisappear();
	}
	
	public DocuSignPage selectWithdrawalMethodAndContinue(String bankAccount, String WithdrawalType) {
		waitForUILoading();
		Assert.assertTrue("frame is not present", seleniumCore.isElementVisible(By.id("esig_iframe"),5,1));
		this.seleniumCore.switchFrameById("esig_iframe");
		Assert.assertTrue("withdrawal method modal is not visible", seleniumCore.getText(withDrawalMethodHeading).contains("Withdrawal Method"));
		By withdrawalCheckbox = By.xpath("//*[contains(text(), '" + WithdrawalType + "')]//input");
		this.seleniumCore.clickRadioButton(withdrawalCheckbox, PAGE_NAME,"Click on withdrawal type:  " + withdrawalCheckbox);
		if(bankAccount.isEmpty()    &&   WithdrawalType.contains("Check")) {
			seleniumCore.clickRadioButton(checkAddrNew, PAGE_NAME,"click new instrustions on check");
			customLogger("click new instrustions on check","");
		} else if (bankAccount.isEmpty()    &&   WithdrawalType.contains("Wire")) {
			seleniumCore.clickRadioButton(wireAddrNew, PAGE_NAME,"click new instrustions on wire");
			customLogger("click new instrustions on wire","");
		}else if (bankAccount.isEmpty()     &&   WithdrawalType.contains("ACH")) {
			seleniumCore.clickRadioButton(achAddrNew, PAGE_NAME,"click new instrustions on ach");
			customLogger("click new instrustions on ach","");
		}else if (!bankAccount.isEmpty() ) {
			By existingBank = By.xpath("//label[contains(text(),'" + bankAccount + "')]/ancestor::td//input[@id='rbAchBankOnSloa0']");
			this.seleniumCore.clickRadioButton(existingBank, PAGE_NAME,	"select exting bank account ends with :  " + withdrawalCheckbox);
			customLogger("Select the existing bank account number ends with: ", bankAccount);
		}
		this.seleniumCore.click(modalContinueButton, PAGE_NAME, "Click on continue button ");
		logger.info("Select the withdrawal type " + WithdrawalType);
		customLogger("Select the withdrawal type ", WithdrawalType);

		return new DocuSignPage(seleniumCore);
	}
}
