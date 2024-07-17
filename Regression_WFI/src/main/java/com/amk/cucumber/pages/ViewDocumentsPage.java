package com.amk.cucumber.pages;


import org.junit.Assert;
import org.openqa.selenium.By;

import com.amk.cucumber.exceptions.DefaultException;
import com.amk.cucumber.utility.CommonMethods;
import com.amk.cucumber.utility.SeleniumCore;

public class ViewDocumentsPage extends CommonMethods {

	// Static Data
	private static final String PAGE_NAME = "VIEW DOCUMENTS PAGE";

	// Sections
	private final String documentSection = "//*[@id='view-documents-page']";

	// Page Locators
	private static final By viewDocumentsPageLabel = By.xpath("//div[@class='PageHeading']");
	private final By combinedDocumentButtons = By.xpath(documentSection + "//*[contains(@class, 'combined-button')]");
	private final By eSignatureButton = By.xpath("//button[contains(text(),'eSignature')]");
	private final By continueButton = By.xpath("//button[contains(text(),'Continue')]");
	private final By promptAfterEsign = By.xpath("//*[@id='prompt_to_leave_modalLabel']");
	private final By separateButton = By.xpath("//button[contains(text(),'Separate Documents')]");
	private final By AgreementsDisclosures = By.xpath("//span[contains(text(),'Agreements & Disclosures')]");
	private final By AccountEstablishmentDocuments = By
			.xpath("//span[contains(text(),'Account Establishment Documents')]");
	private final By electronicSignatureModalTitle = By.cssSelector("span.signer-information");
	private final By emailElectronicSignatureModalTitle = By.cssSelector("#txtEmailAddress0");
	private final By trackingCenterLink = By.xpath("//div[@class='prompt-to-leave-modal-body']//a");
	private final By SeparateDocumentsButtons = By.xpath("//button[contains(text(), 'Separate Documents')]");
	private final By CloseOnSeparateDocuments = By.xpath("//input[contains(@value,'Close')]");
	private final By additionalDocumentsYes = By.cssSelector("#additionaldocumentsyes");
	private final By additionalDocumentsNo = By.cssSelector("#additionaldocumentsno");
	private final By additionalDocsAcknowledgeCheck = By.cssSelector("#additionalDocsAcknowledgeCheck");
	private final By uploadFile = By.cssSelector("#file");
	private final By fileUploaded = By.xpath("//div[@class='fileItems-container'     or     @class='fileItems-sup-container']");	
	private final By action = By.cssSelector("span.dotContainter");
	private final By labelDocument = By.xpath("//button[text()='Label Document']");
	private final By signer = By.cssSelector("select#signers");
	private final By sign = By.cssSelector("div.pdfViewer-tag-button > div > img");
	private final By doneButton = By.xpath("//*[text()='DONE']");
	private final By status = By.xpath("//div[@class='fileItem-fileStatus fileItem-fileStatus-labeled']");
	private final By supplementalDocuments = By.cssSelector("button.button-Enabled-Supplemental");
	private final By revewAndConfirm = By.xpath("//button[@class='button-primary button-ReviewAndConfirm']");
	private final By revewAndConfirmPage = By.xpath("//div[@class='headerCommonTitleText margin-container']/div");
	private final By confirm = By.cssSelector("button.button-Confirm ");
	private final By confirmMessage = By.xpath("//div[@id='documentReceivedText']");
	private final By inPerson = By.cssSelector("[id*=inPerson] + span");
	private final By signButton = By.cssSelector("#signButton");

	public ViewDocumentsPage(SeleniumCore seleniumCore) {
		this(seleniumCore, true);
	}

	public ViewDocumentsPage(SeleniumCore seleniumCore, boolean pageVerification) {
		super(seleniumCore);
		if (pageVerification) {
			waitForSpinnerToBeDisappear();
			if (seleniumCore.isElementVisible(viewDocumentsPageLabel,30,1)) {
				logger.info(PAGE_NAME + " verification" + " : " + PAGE_NAME + " verification is PASSED");
			} else {
				logger.warn(PAGE_NAME + " verification" + " : " + PAGE_NAME + " verification is FAILED");
			}
		}
	}

	public static By getLabel() {
		return viewDocumentsPageLabel;
	}

	public void validateSeparateButton() {
		this.seleniumCore.click(separateButton);
		waitForSpinnerToBeDisappear();
		Assert.assertTrue("Separate Button does not show documents separately ",
				seleniumCore.isElementClickable(AccountEstablishmentDocuments));
		Assert.assertTrue("Agreements disclosures checkbox is not clickable",
				seleniumCore.isElementClickable(AgreementsDisclosures));
		this.seleniumCore.click(AccountEstablishmentDocuments);
		this.seleniumCore.click(AgreementsDisclosures);
	}

	public void clickCombinedDocumentsBtn(String stepName, String logMessage) {
		this.seleniumCore.reducesize();
		this.seleniumCore.waitForElementToBeClickable(combinedDocumentButtons,30,1);
		this.seleniumCore.click(combinedDocumentButtons);
		seleniumCore.waitForUILoading(1000);
	}

	public void verifyclientmessage(String text) {
		Assert.assertTrue("e-sign prompt message has not been verified ", seleniumCore.getText(promptAfterEsign).contains(text));
		customLogger("e-sign prompt message has been verified ", "");
	}
	
	public ItemDetailsPage clickTrackingCenterLinkOnEmailSentModel() {
		seleniumCore.waitForElementToBeVisible(trackingCenterLink);
		seleniumCore.click(trackingCenterLink);
		return new ItemDetailsPage(seleniumCore);
	}

	public void clickSeparateDocumentsBtn(String stepName, String logMessage) {
		seleniumCore.waitForJStoLoad();	
		waitForLoadingData();
		this.seleniumCore.isElementVisible(SeparateDocumentsButtons,10,1);
		this.seleniumCore.click(SeparateDocumentsButtons);
		this.seleniumCore.waitForElementToBeClickable(AccountEstablishmentDocuments);
		this.seleniumCore.click(AccountEstablishmentDocuments);
		seleniumCore.waitForUILoading(500);
	}
	
	public String switchApplicationPage() {	
		String url = switchTab(2);	
		String[] reportId = url.split("=");			
		String number = reportId[2].substring(0, 7);	
		logger.info("switched to One Combined document window and getdoc number " + " : " + number);	
		customLogger("Switched to OneCombined Document ", url);					
		return number;	
	}	
	
	public String switchApplicationPageReturnUrl() {	
		String url = switchTab(2);							
		return url;	
	}
	
	public DocuSignPage eSignatureStart(String option) {	
		seleniumCore.waitForJStoLoad();	
		waitForLoadingData();	
		seleniumCore.scrollIntoView(seleniumCore.findElement(eSignatureButton));	
		this.seleniumCore.click(eSignatureButton,"","",10,1);	
		customLogger("click on e-sign button", "");	
		seleniumCore.isElementVisible(electronicSignatureModalTitle, 10, 1);	
		if(option.toLowerCase().contains("in person")) {
			seleniumCore.clickRadioButton(inPerson, "click in person option", option);
			customLogger("click in person option", "");			
		}else {
		seleniumCore.sendKeys(emailElectronicSignatureModalTitle, "test@assetmark.com", "enter email address");	
		customLogger("enter email address ", "test@assetmark.com");	
		}
		if(!seleniumCore.findElement(By.cssSelector("#additionalDocumentsNoConfirm")).getAttribute("style").contains("flex")) {	
		seleniumCore.clickRadioButton(additionalDocumentsNo, "click additional document No checkbox ", PAGE_NAME);	
		customLogger("click additional document No checkbox", "");	
		}	
		seleniumCore.scrollIntoView(seleniumCore.findElement(continueButton));	
		this.seleniumCore.click(continueButton);	
		seleniumCore.waitForJStoLoad();	
		waitForLoadingData();	
		customLogger("click on continue button", "");	
		WaitForProgressBar();	
		return new DocuSignPage(this.seleniumCore);	
	}
	
	public void signButton() {
		seleniumCore.waitForJStoLoad();	
		waitForLoadingData();
		seleniumCore.waitForElementToBeVisible(signButton, 20, 1);
		seleniumCore.click(signButton);
	}
	
	public void WaitForProgressBar() {
		By element= By.xpath("//div[@id='preparing-experience']/parent::div");
		if(seleniumCore.isElementVisible(element, 2, 1)) {
			seleniumCore.waitForElementToBeInVisible(element, 80, 1);
		}
	}
	
	public void closeSeparateDocuments(String stepName, String logMessage) {
		// this.seleniumCore.reducesize();
		this.seleniumCore.isElementVisible(CloseOnSeparateDocuments);
		this.seleniumCore.click(CloseOnSeparateDocuments);
		this.seleniumCore.getDriver().switchTo().defaultContent();
	}
	
	public SubmitPage clickProceedSubmitButton(String stepName, String logMessage) {
		waitForLoadingData();
		if(seleniumCore.isElementVisible(By.id("viewDocuments_next"), 3, 1)) {
			this.seleniumCore.click(By.id("viewDocuments_next"), stepName, logMessage);
			customLogger(logMessage, "");
			return new SubmitPage(this.seleniumCore);
		}else {
			new DefaultException("submit button is not visible");
			return null;
		}		
	}
	
	public void addAdditionalDocument() {
		waitForLoadingData();
		this.seleniumCore.click(eSignatureButton);
		seleniumCore.isElementVisible(electronicSignatureModalTitle, 10, 1);
//		seleniumCore.sendKeys(emailElectronicSignatureModalTitle, "test1@gmail.com", "enter email address");
		seleniumCore.clickRadioButton(additionalDocumentsYes, "click additional document Yes checkbox ", PAGE_NAME);
		seleniumCore.clickRadioButton(additionalDocsAcknowledgeCheck, "check acknowledge checkbox ", PAGE_NAME);
		this.seleniumCore.click(continueButton);		
	}
	
	public void UploadDocument(String filePath) {
		seleniumCore.isElementVisible(uploadFile, 10, 1);		
		seleniumCore.getDriver().findElement(uploadFile).sendKeys(filePath);		
		Assert.assertTrue("file has not been uploaded", seleniumCore.isElementVisible(fileUploaded, 10, 1));
		logger.info("file has been uploaded ");
		customLogger("file has been uploaded ", "");	
	}
	
	public void addLabel(String image) {
		seleniumCore.click(action);
		Assert.assertTrue("label document is not visible", seleniumCore.isElementVisible(labelDocument, 10, 1));
		seleniumCore.click(labelDocument);
		seleniumCore.selectByIndex(signer, 1, "select signer", PAGE_NAME, 10, 1);
		seleniumCore.isElementVisible(sign, 10, 1);
		seleniumCore.click(sign);
		performSikuliClick(image);
	//	performSikuliClick(image);
	}
	
	public void clickDoneButton() {
		seleniumCore.isElementVisible(doneButton, 10, 1);
		seleniumCore.scrollIntoView(seleniumCore.findElement(doneButton));	
		if(!seleniumCore.getAttribute(doneButton, "class").contains("Disabled")) {
			seleniumCore.click(doneButton);
			logger.info("file has been uploaded ");
			customLogger("file has been uploaded ", "");
		}
	}
	
	public String validateStatus() {
		seleniumCore.isElementVisible(status, 10, 1);
		return seleniumCore.getText(status);
	}
	
	public void clickSupplementalDocumentsButton() {
		seleniumCore.isElementVisible(supplementalDocuments, 10, 1);
		seleniumCore.click(supplementalDocuments);
		logger.info("click supplemental documents button ");
		customLogger("click supplemental documents button ", "");
	}
	
	public String clickReviewAndConfirmButtonAndValidateReviewAndConfirmPage() {
		seleniumCore.isElementVisible(revewAndConfirm, 10, 1);
		seleniumCore.click(revewAndConfirm);		
		logger.info("click revew and confirm button ");
		customLogger("click revew and confirm button ", "");
		return seleniumCore.getText(revewAndConfirmPage).toLowerCase();
	}
	
	public String validateReviewAndConfirmPage() {
		seleniumCore.isElementVisible(status, 10, 1);
		return seleniumCore.getText(status);
	}	

	public DocuSignPage validateConfirmButtonMessage(String value) {
		seleniumCore.isElementVisible(confirm, 10, 1);
		seleniumCore.click(confirm);
		Assert.assertTrue("confirm message is not displaying ", seleniumCore.getText(confirmMessage).contains(value));
		seleniumCore.waitForElementToBeInVisible(confirm, 40, 1);
		logger.info("click confirm button ");
		customLogger("click confirm button ", "");	
		WaitForProgressBar();	
		return new DocuSignPage(this.seleniumCore);
	}

}
