package com.amk.cucumber.pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.amk.cucumber.exceptions.DefaultException;
import com.amk.cucumber.utility.BasePage;
import com.amk.cucumber.utility.SeleniumCore;



public class ItemDetailsPage extends BasePage {

	// Static Data
	private static final String PAGE_NAME = "ITEM DETAILS PAGE";

	// Page Locators
	private final By pageLabel = By.xpath("//*[@id='genworth-breadcrumb']//a[contains(text(),'Item Detail')]");

	// Top Info
	private final By description = By.xpath("//div[@class='description']/span");

	// View Documents Popup
	private final By viewDocumentsHeaderPopUp = By.xpath("//div[@class='modal-title'][ text()='View Documents']");	
	private final By viewDocumentsPDFListTable = By.xpath("//div[@class='modal-body']//a[@name='pdfDetails']");	
	private final By closeButton = By.cssSelector("button#btnClose");
	private final By viewDocumentsFileLinks = By.xpath("//div[@id='ViewNItemPDFListModal']//a[@name='nPdfDetails']");

	// Buttons
	private final By uploadButton = By.xpath("//*[@class='fileupload']/label");
	private final By viewButton = By.xpath("//a[text()='View']");
	private final By addNewNoteButton = By.xpath("//a[text()='Add New Note']");
	private final By trackingCenterTab = By.xpath("//div[@class]/a[text()='Tracking Center']");
	private final By submitButton = By.cssSelector("#submitToBDButton");
	public final By submit = By.cssSelector("label[class*='submitButton']");
	private final By cancelButton = By.cssSelector("#cancelRequest");
	private final By cancelPopupYesButton = By.xpath("//button[@class='formButton']/span[text()='Yes']");

	// Upload PopUp
	private final By uploadPopUp = By.xpath("//div[@id='TrackingCenterFileUploadModal']//div[@class='modal-content']");
	private final By uploadPopUpCloseButton = By
			.xpath("//div[@id='TrackingCenterFileUploadModal']//button[@id='btnModalClose']");
	private final By uploadDropbox = By.xpath("//div[@id='TrackingCenterFileUploadModal']//input");
	private final By uploadButtonPopUp = By
			.xpath("//div[@id='TrackingCenterFileUploadModal']//button[text()='Upload']");
	private final By uploadPopUpCloseButton2 = By
			.xpath("//div[@id='TrackingCenterFileUploadModal']//button[text()='Close']");
	private final By uploadFileName = By.xpath(
			"//div[@id='TrackingCenterFileUploadModal']//div[@class='fileuploadlist']//div[contains(@class, 'file-name')]");
	private final By uploadFileSize = By.xpath(
			"//div[@id='TrackingCenterFileUploadModal']//div[@class='fileuploadlist']//div[contains(@class, 'size-text')]");
	private final By uploadFileStatus = By.xpath(
			"//div[@id='TrackingCenterFileUploadModal']//div[@class='fileuploadlist']//div[contains(@class, 'upload-status')]/span");
	private final By uploadStatusIMG = By.xpath(
			"//div[@id='TrackingCenterFileUploadModal']//div[@class='fileuploadlist']//div[contains(@class, 'upload-status')]/img");

	// Add New Note
	private final By addNewNoteTextarea = By.xpath("//div[@id='AddWorkItemNoteModal']//textarea");
	private final By addNewNoteContent = By.xpath("//div[@id='AddWorkItemNoteModal']//div[@class='modal-content']");
	private final By addNewNoteSaveButton = By.xpath("//div[@id='AddWorkItemNoteModal']//button[@id='AddNoteSave']");
	private final By addNewNoteCancelButton = By
			.xpath("//div[@id='AddWorkItemNoteModal']//button[contains(text(), 'Cancel')]");
	private final By firstNoteDescription = By.xpath("//table[@id='TrackingCenterItemDetailNotesGrid']//tr[2]//td[contains(@class, 'description')]");
	private final By secondNoteDescription = By.xpath("//table[@id='TrackingCenterItemDetailNotesGrid']//tr[3]//td[contains(@class, 'description')]");

	// General
	private final By confirmationMessage = By.xpath("//div[@class='confirmation']");
	public final By selectedItemTitle = By.xpath("//span[@id='NotesTitleSelectedItemDescription']");

	private final By itemNumber = By.xpath("//div[@class='item-number']//span[@class='value']");
//	private final By checkTrackingId = By.xpath("//tr[contains(@class,'firstrow')]//following-sibling::tr[1]//td[4]");
	private final By checkTrackingId = By.xpath("//td[contains(text(),'reference purposes')]");
	
	private final By status = By.xpath("//*[contains(text(),'Status:')]/following-sibling::span");	
	private final By eSignatureButton = By.xpath("//a[text()='eSignature']");
	private final By finishNowButton = By.xpath("//a[text()='Finish Now']");
	private final By showDetails = By.xpath("//a[text()='Show Details']");
	private final By transferDetails = By.cssSelector("#transferDetailContents");
	private final By advisorAlertRequired = By.xpath("//*[contains(text(),'Advisor Alert Required')]/following-sibling::span");
	private final By confirm = By.cssSelector("div.confirmation");
	private final By distributionDetails = By.cssSelector("#oneTimeDistributionDetailContents");
	
	
	/**
	 * To construct the Item Details Page
	 *
	 * @param seleniumCore
	 */
	public ItemDetailsPage(SeleniumCore seleniumCore) {
		this(seleniumCore, true);
	}

	/**
	 * To construct the Item Details Page
	 *
	 * @param seleniumCore
	 * @param pageVerification - Flag to check if the page is loaded or not
	 */
	public ItemDetailsPage(SeleniumCore seleniumCore, boolean pageVerification) {
		super(seleniumCore);
		if (pageVerification) {
			boolean isVisible = seleniumCore.isElementVisible(pageLabel, 20, 1);
			if (isVisible) {
				this.seleniumCore.getLogger().info(PAGE_NAME + " verification"+":"+ PAGE_NAME + " verification is PASSED");
			} else {
				this.seleniumCore.getLogger().warn(PAGE_NAME + " verification"+":"+ PAGE_NAME + " verification is FAILED");
			}
		}
	}

	public void addNewNote(String stepName, String testMessage) {
		By addNewNote = By.xpath("//*[@id='TrackingCenterItemDetail']/div[7]/div[1]/a");
		By modalInputArea = By.id("AddNoteTextArea");
		By saveNewMessage = By.id("AddNoteSave");
		this.seleniumCore.getLogger().info(stepName+":"+ testMessage);
		this.seleniumCore.waitForElementToBeVisible(addNewNote).click();
		this.seleniumCore.waitForElementToBeVisible(modalInputArea).sendKeys(testMessage);
		this.seleniumCore.waitForElementToBeVisible(saveNewMessage).click();
	}

	public void confirmThatMessageAdded(String stepName, String testMessage) {
		By lastComment = By.xpath("//*[@id='TrackingCenterItemDetailNotesGrid']/tbody/tr[2]/td[4]");
		String publishedMessage = this.seleniumCore.getText(lastComment);
		logger.info(publishedMessage);		
	}

	public boolean isDataDisplayedInInfoPanel(String info) {
		WebElement infoEle = this.seleniumCore.findElement(
				By.xpath("//span[@class='label' and contains(text(), '" + info + "')]/following-sibling::span"));
		return !infoEle.getText().isEmpty();
	}

	public boolean isDescriptionDisplayed() {
		return !this.seleniumCore.findElement(description).getText().isEmpty();
	}

	public boolean isViewDocumentsPopUpDisplayed() {
		seleniumCore.waitForJStoLoad();
		return seleniumCore.isElementVisible(viewDocumentsHeaderPopUp, 5, 1);				
	}

	public void clickViewButton() {	
		this.seleniumCore.waitForElementToBeClickable(viewButton);	
		this.seleniumCore.click(viewButton);	
		seleniumCore.waitForJStoLoad();					
		customLogger("click on view button", "");	
	}	
		
	public void clickSubmitButton() {	
		seleniumCore.waitForJStoLoad();	
		waitForLoadingData();		
		this.seleniumCore.waitForElementToBeClickable(submitButton,10,1);	
		this.seleniumCore.click(submitButton);		
		customLogger("click on submit button", "");	
		waitForLoadingData();
	}	
	
	public SubmitPage clickSubmitButton(String msg) {	
		seleniumCore.waitForJStoLoad();	
		waitForLoadingData();
		By paperwork= By.xpath("//td[text()='New Account Paperwork Submission']");
		if(seleniumCore.isElementVisible(paperwork,1,1)) {
			seleniumCore.click(paperwork);
		}
		this.seleniumCore.waitForElementToBeClickable(submitButton,10,1);	
		this.seleniumCore.click(submitButton);	
		logger.info(msg);
		customLogger("click on submit button", "");	
		return new SubmitPage(seleniumCore);
	}
		
	public void clickCancelButton() {	
		this.seleniumCore.waitForElementToBeClickable(cancelButton,10,1);	
		this.seleniumCore.click(cancelButton);		
		seleniumCore.getDriver().switchTo().activeElement();	
		this.seleniumCore.waitForElementToBeClickable(cancelPopupYesButton,10,1);	
		this.seleniumCore.click(cancelPopupYesButton);	
		customLogger("click on cancel button", "");	
	}	
		
	public String validateUploadedDocOnViewDocumentsPopUp() {		 	
		String text= seleniumCore.getText(viewDocumentsPDFListTable);	
		clickCloseButton();	
		return text;	
	}	
	
	public void openViewDocumentsFromPopUp() {	
		seleniumCore.click(viewDocumentsPDFListTable);
		logger.info("click on document link to download");
		customLogger("click on document link to download", "");			
	}
	
	public Integer getAmountOfDocumentsInViewPopUp() {	
		return this.seleniumCore.findElements(viewDocumentsFileLinks).size();	
	}	
	public void clickFirstDocumentInViewPopUp() {	
		this.seleniumCore.findElement(viewDocumentsFileLinks).click();	
	}	
	public void clickCloseButton() {	
		this.seleniumCore.waitForElementToBeClickable(closeButton);	
		this.seleniumCore.click(closeButton);	
		customLogger("click on view documents popup close button", "");	
	}

	public boolean isTableHeaderDisplayed(String header) {
		return this.seleniumCore
				.findElement(By.xpath(
						"//div[contains(@id, 'TrackingCenterChildItemDetailsGrid') and text()='" + header + "']"))
				.isDisplayed();
	}

	public boolean isTableInnerDataDisplayed(String column) {
		/**
		 * possible columns: 'externalDesc' for Item 'registration' for Account Name
		 * 'account' for Account # 'status' for Status 'advisorAction' for Advisor
		 * Action
		 */
		List<WebElement> tableEle = this.seleniumCore
				.findElements(By.xpath("//td[contains(@class, '" + column + "')]"));
		return tableEle.stream().noneMatch(e -> (!e.isDisplayed()));
	}

	public void clickUploadButton() {		
		this.seleniumCore.waitForElementToBeClickable(uploadButton);
		this.seleniumCore.click(uploadButton);
		customLogger("Clicking upload button ", "");					
	}

	public boolean isUploadPopUpDisplayed() {
		this.seleniumCore.waitForElementToBeVisible(uploadPopUp);
		return this.seleniumCore.findElement(uploadPopUp).isDisplayed();
	}

	public void closeUploadPopUp() {
		this.seleniumCore.waitForElementToBeVisible(uploadPopUpCloseButton);
		this.seleniumCore.click(uploadPopUpCloseButton);
		logger.info("clicked on uploadPopUpCloseButton ");
		customLogger("clicked on uploadPopUpCloseButton ", "");
	}

	public void uploadFile(String filePath) {
		this.seleniumCore.findElement(uploadDropbox).sendKeys(filePath);
		this.seleniumCore.waitForElementToBeVisible(uploadButtonPopUp);
		this.seleniumCore.findElement(uploadButtonPopUp).click();
		this.seleniumCore.waitForElementToBeVisible(uploadStatusIMG);
	}

	public String getUploadConfirmation() {
		String fileName = this.seleniumCore.findElement(uploadFileName).getText();
		String fileSize = this.seleniumCore.findElement(uploadFileSize).getText();
		String uploadStatus = this.seleniumCore.findElement(uploadFileStatus).getText();

		return fileName + " " + fileSize + " " + uploadStatus;
	}

	public void closeUploadPopUpButton() {
		this.seleniumCore.findElement(uploadPopUpCloseButton2).click();
	}

	public void clickAddNewNoteButton() {
		seleniumCore.waitForElementToBeVisible(addNewNoteButton, 5, 1);
		this.seleniumCore.click(addNewNoteButton);	
		customLogger("click on add new note button ", "");
	}

	public boolean isAddNewNotePopUpDisplayed() {
		return this.seleniumCore.findElement(addNewNoteTextarea).isDisplayed()
				&& this.seleniumCore.findElement(addNewNoteContent).isDisplayed();
	}

	public void closeAddNewNotePopUp() {
		this.seleniumCore.findElement(addNewNoteCancelButton).click();
	}

	public void saveNewNote() {
		this.seleniumCore.findElement(addNewNoteSaveButton).click();
		customLogger("click on save note button ", "");
	}

	public void writeNewNoteInAddNewNotePopUp(String note) {
		this.seleniumCore.findElement(addNewNoteTextarea).sendKeys(note);
		logger.info("add the note on tracking center page ");
		customLogger("add the note on tracking center page ", note);
	}

	public boolean isTableColumnDisplayedInViewPopUp(String column) {
		this.seleniumCore.waitForElementToBeVisible(
				By.xpath("//div[@id='NItemPDFList']/div[2]/div[contains(text(), '" + column + "')]"));
		return this.seleniumCore
				.findElement(By.xpath("//div[@id='NItemPDFList']/div[2]/div[contains(text(), '" + column + "')]"))
				.isDisplayed();
	}

	public String getConfirmationMessage() {
		this.seleniumCore.waitForElementToBeVisible(confirmationMessage);
		return this.seleniumCore.findElement(confirmationMessage).getText();
	}

	public String getFirstNoteDescription() {
		seleniumCore.getDriver().navigate().refresh();
		this.seleniumCore.waitForElementToBeVisible(firstNoteDescription,30,1);
		seleniumCore.scrollIntoView(seleniumCore.findElement(firstNoteDescription));
		seleniumCore.isElementFound(firstNoteDescription, 20, 1);
		return this.seleniumCore.findElement(firstNoteDescription).getText();
	}
	
	public String getSecondNoteDescription() {	
		seleniumCore.getDriver().navigate().refresh();
		this.seleniumCore.waitForElementToBeVisible(secondNoteDescription,10,1);
		return this.seleniumCore.findElement(secondNoteDescription).getText();
	}

	public TrackingCenterPage switchToTrackingCenterPage() {
		this.seleniumCore.click(trackingCenterTab, "Switch to Tracking Center page", "Clicked");
		customLogger("Switch to Tracking Center page", "");
		waitForAllLoadingImagesToBeDisappear();
		
		return new TrackingCenterPage(seleniumCore);
	}

	public void clickItemByName(String name) {
		By itemName = By.xpath("//tr[@role='row']/td[text()='" + name + "']");
		seleniumCore.click(itemName);
	}

	public String getItemNumber() {
		seleniumCore.waitForElementToBeVisible(itemNumber, 30, 1);
		String itemNum = this.seleniumCore.findElement(itemNumber).getText();		
		return itemNum;
	}

	public String checkDTrackingId() {
		this.seleniumCore.waitForElementToBeVisible(checkTrackingId);
		return this.seleniumCore.getText(checkTrackingId);
	}

	public String fetchBTrackingId(String actualTrackingId) {
		String bTrackingId = null;
		String dTrackingId = checkDTrackingId();
		if (dTrackingId.contains(actualTrackingId)) {
			bTrackingId = this.seleniumCore.getText(itemNumber);
		}
		logger.info("D Tracking ID is - " +actualTrackingId);		
		customLogger("D Tracking ID is - ", actualTrackingId);
		logger.info("B Tracking ID is - " +bTrackingId);		
		customLogger("B Tracking ID is - ", bTrackingId);
		return bTrackingId;
	}
	
	public String clickOnBTrackingId(String dTrackingId) {	
		Assert.assertEquals("D tracking id is not matching", getItemNumber(), dTrackingId);	
			
		for (int MaxTime = 0; MaxTime < 50; MaxTime++) {	
			this.seleniumCore.getDriver().navigate().refresh();	
			if (getItemNumber().startsWith("B")     ||    getItemNumber().startsWith("A") )	
				break;	
			seleniumCore.waitForUILoading(5000);	
		}		
		if(!getItemNumber().startsWith("B")) {					
			throw new DefaultException("Failure scenario : Even after a Minute or two if the D number is not flipped to B the issue could be related to Process Initiator ( PI) or Access store is closed.");	
		}			
		return getItemNumber();	
	}
	
	public String ValidateStatus() {
		seleniumCore.waitForJStoLoad();
		seleniumCore.waitForUILoading(5000);
		seleniumCore.waitForElementToBeVisible(status,10,1);
		seleniumCore.getDriver().navigate().refresh();		
		seleniumCore.waitForElementToBeVisible(status,10,1);
		return seleniumCore.getText(status);		
	}
	
	public String ValidateAdvisorAlertRequired() {			
		seleniumCore.waitForElementToBeVisible(advisorAlertRequired,10,1);
		return seleniumCore.getText(advisorAlertRequired);		
	}
	
	public boolean isESignatureButtonVisible() {		
		return seleniumCore.isElementVisible(eSignatureButton);				
	}
	
	public boolean isFinishNowButtonVisible() {
		return seleniumCore.isElementVisible(finishNowButton,10,1);	
	}
	
	public void clickFinishNowButton() {		
		this.seleniumCore.waitForElementToBeClickable(finishNowButton);
		this.seleniumCore.click(finishNowButton);
		customLogger("Clicking Finish Now button ", "");					
	}	
	
	public void clickShowDetails() {	
		waitForLoadingData();
		seleniumCore.isElementVisible(showDetails, 10, 1);
		this.seleniumCore.click(showDetails);
		customLogger("Click on show details link ", "");					
	}
	
	public void validateAddedTransferDetails(String transferRequest) {
		String[] transferData = transferRequest.split(",");
		seleniumCore.waitForElementToBeVisible(transferDetails, 20, 1);
		Assert.assertTrue("contra firm account value has not captured on shell page", seleniumCore.validateTextValue(transferDetails, 10, 1, transferData[2].trim()));
		Assert.assertTrue("amount value has not captured on shell page", seleniumCore.validateTextValue(transferDetails, 10, 1, transferData[4].trim()));
		logger.info("validated transfer added details on item details page ");
		customLogger("validated transfer added details on item details page", "");
	}
	
	public String validateDistribuitonDetails() {		
		seleniumCore.waitForElementToBeVisible(distributionDetails, 20, 1);
		return seleniumCore.getText(distributionDetails);
	}
	
	public String confirmNote() {			
		return seleniumCore.getText(confirm).trim();					
	}
	
	public String getDescriptionText() {
		return seleniumCore.getText(description);
	}
}
