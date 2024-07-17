package com.amk.cucumber.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.amk.cucumber.utility.SeleniumCore;

public class ShellProcessPage extends BawBasePage {

	private static final String PAGE_NAME = "Shell Process";

	private final By uploadCommitButton = By.cssSelector("#ButtonGroup1_Button0");
	private final By pendingUploadText = By.cssSelector("div#CustomHTML14");
	private final By runNowButton = By.cssSelector("#ButtonGroup0_RunNow");
	private final By addDocument = By.cssSelector("button#ButtonGroup2_Button0");
	private final By faxButton = By.cssSelector("#ButtonGroup3_Button0");
	private final By faxButton1 = By.cssSelector("#ButtonGroup9_Button0");
	private final By emailButton = By.cssSelector("#ButtonGroup9_Button1");
	private final By pershingDocList = By.cssSelector("#InputText2");
	private final By submitButton = By.cssSelector("button#ButtonGroup0_Button0");
	private final By individualOwner = By.cssSelector("select#ComboBox1");
	private final By addDocumentInDocumentList = By.cssSelector("#ButtonGroup2_Button1");
	private final By uploadedDocLink = By.cssSelector("#TableCelldocType1_0>a");
	private final By custodialAccount = By.cssSelector("input#InputText9");
	private final By custodian = By.cssSelector("select#InputText0");
	private final By accountAplId = By.cssSelector("input#InputText1");
	private final By workItemType = By.cssSelector("select#InputText3");
//	private final By noteTextBox = By.cssSelector("#InputText5_0");
	private final By noteTextBox = By.xpath("//*[@id='InputText5_0'  or   @id='InputText0_0' ]");
	private final By noteText = By.cssSelector("#Table4");
	private final By internalStatus = By.cssSelector("#combo");
	private final By owningGroup = By.cssSelector("#ComboBox0");
	private final By validateExternalStatus = By.cssSelector("#InputText0");	
	private final By saveExitButton = By.cssSelector("button#ButtonGroup0_Button2");
	private final By saveRefreshButton = By.cssSelector("#ButtonGroup0_Button0");
	private final By secoundUploadedDocument = By.cssSelector("#Table2_1");
	private final By firstUploadedDocument = By.cssSelector("#Table2_0");
	private final By webVisibility = By.xpath("//*[@id='TableCellnote_type0_0_checkbox']");
	private final By docVisibility = By.cssSelector("[id=BooleanChoice1_0_checkbox]");
	private final By advisorVisibility = By.xpath("//*[@id='Checkbox1_0_checkbox']");
	private final By advisorVisibilityVal = advisorVisibility.xpath("//preceding-sibling::input");
	private final By addUpdateButton = By.xpath("//*[@id='ButtonGroup8_Button0']");
	private final By bNumber = By.xpath("//*[text()='B #']/following-sibling::td");
	private final By fileName = By.cssSelector("a.jstree-clicked");
	private final By updateTransferDetailsButton = By.cssSelector("#ButtonGroup27_AddTransfer");
	private final By editHeaderData = By.cssSelector("#ButtonGroup6_EditWI");
	private final By clientAplId = By.cssSelector("#inClientAPLId");
	private final By custodianAccount = By.cssSelector("#inCustodianAccNo");
	private final By saveChangesButton = By.cssSelector("#ButtonGroup0_Save");
	private final By addedOA = By.cssSelector("#bNumberOAs");
	private final By closeNoCheckbox = By.cssSelector("#DNoMatchNo_checkbox");
	private final By closeYesCheckbox = By.cssSelector("#DNoMatchYes_checkbox");
	private final By closeDButton = By.cssSelector("button[id*=_btnCloseDNo]");
	private final By closedDNumber = By.cssSelector("#TableCellExternalId0_0");
	private final By activateICTCheckbox = By.cssSelector("#ICTCheckbox_checkbox");
	private final By activateICTButton = By.cssSelector("#ButtonGroup10_btnActivateICT");
	private final By contraFirmAccount = By.cssSelector("#deliveryFirmAccountNo");
	private final By amount = By.cssSelector("#transferAmount");
	private final By accountAplIdField = By.xpath("//input[@id='InputText1'   and   @disabled]");
	private final By teamName = By.cssSelector("#ComboBox0");
	private final By refreshUserList = By.cssSelector("#ButtonGroup7_Button0");
	private final By individualOwnerFollowUpOwnership = By.cssSelector("#ComboBox3");
	private final By feeMaintenanceCheckbox = By.cssSelector("#FMACheckbox_checkbox");
	private final By tmsCheckbox = By.cssSelector("#TMSCheckbox_checkbox");	
	private final By activateFeeMaintenanceButton = By.cssSelector("#ButtonGroup14_btnActivateFMA");	
	private final By terminationNotificationButton = By.cssSelector("#NotificationBtnGroup_termination");
	private final By tmsActivateButton = By.cssSelector("[id*='btnActivateTMS']");
	private final By header = By.xpath("//table[@class='headingTable']//h1");
	private final By hrcTextbox = By.cssSelector("#InputText32");
	private final By hrcSubmitButton = By.cssSelector("#ButtonGroup21_SubmitHRC");
	private final By SelectAccount = By.xpath("//button[text()='Select']");
	private final By accountNumberDigits = By.xpath("//div[@id='CustomHTML0']//td[contains(text(),'Custodian')]/following-sibling::td[1]");
	private final By addedAccountNumber = By.cssSelector("#TableCellCustodialAccountNumber0_0");
	private final By addedAccountName = By.cssSelector("#TableCellItemName0_0");
	private final By qcSelectionStatus = By.cssSelector("#qcSelectionStatus");
	private final By advisorid = By.xpath("//td[text()='Advisor APLID']/following-sibling::td[@class='FontStyle'][1]");
	private final By addButtonAccountNumberAssociation = By.cssSelector("#ItemAssociation_AddAccountAssociation");
	private final By clientName = By.xpath("//td[text()='Client Name']/following-sibling::td[1]");
	private final By spThirdParty = By.cssSelector("#spThirdParty");
	private final By createNewDigitalRecord = By.cssSelector("#ButtonGroup33_CreateNewDigitalRecord");
	private final By addUpdateCheckDetails = By.cssSelector("#ButtonGroup32_AddCheck");
	private final By addedCheckDetails = By.cssSelector("tr[id*='checkAllocationsTBL']");
	private final By receivedTime = By.cssSelector("#CustomHTML48_0");
	private final By openSuspend = By.xpath("//span[contains(text(),'Open Suspend OA')]");
	private final By lastUserButton = By.cssSelector("#ButtonGroup5_Button0");
	private final By oneTimeDistributionButton = By.cssSelector("#ButtonGroup34_OneTimeCash");
	private final By residualDistributionButton = By.cssSelector("#ButtonGroup37_0_ResidualBtn");
	private final By nigoReason = By.cssSelector("select#categoryDropDown");
	private final By nigoReason2 = By.cssSelector("select#nigoReasonsDropDown");
	private final By addNigoReason = By.cssSelector("[id*=btnAddNigoReason]");
	private final By parentbNumber = By.xpath("//*[@id='otherWorkItems_SectionTitle']//a");
	private final By spRouting = By.xpath("//div[text()='Special Routing']");
	private final By createFidelityTransferButton = By.cssSelector("[id*=CreateFidelityTransferForm]");
	private final By oneTimeDistributionStatus = By.xpath("//table[@id='oneTimeStatusTBL']//div[@class='customHTML']");		
	private final By accountClosingResidual= By.cssSelector("input[id*=IsAccountClosingStr][value='Yes']");
	private final By intiRdCloseAccount = By.cssSelector("[id*=InitiateResidualBtn]");
	
	String parentWindow;
	boolean isDisplay;

	public ShellProcessPage(SeleniumCore seleniumCore) {
		this(seleniumCore, true);
	}

	public ShellProcessPage(SeleniumCore seleniumCore, boolean pageVerification) {
		super(seleniumCore);
		if (pageVerification) {
			try {
				Assert.assertTrue("shell page title is not verified ", seleniumCore.getDriver().getTitle().contains(PAGE_NAME));				
			} catch (Exception e) {
				seleniumCore.waitForUILoading(2000);
				System.out.println("## catch block code --  -- --");
			}
		}
	}

	public String getWorkItemHeader() {
		seleniumCore.waitForElementToBeVisible(header, 10, 1);
		return seleniumCore.getText(header);		
	}
	
	public String validateNotesHistory() {
		By requiredText = By.xpath("//table[@id='Table4']");		
		seleniumCore.waitForElementToBeVisible(requiredText, 20, 1);
		String text = this.seleniumCore.getText(requiredText);
		return text;
	}	
	
	public String fetchFundingAccountNumber() {
		By requiredText = By.xpath("//table[@id='Table4']//pre[contains(text(),'Funding')]");		
		seleniumCore.waitForElementToBeVisible(requiredText, 20, 1);
		String text = this.seleniumCore.getText(requiredText).split(" ")[3].trim();
		return text;
	}
	
	public String fetchTransferNumber() {
		By requiredText = By.xpath("//table[@id='Table4']//pre[contains(text(),'Record created')]");		
		seleniumCore.waitForElementToBeVisible(requiredText, 20, 1);
		String text = this.seleniumCore.getText(requiredText).split("#")[1].trim();		
		return text.substring(0, text.length()-1);		
	}

	public void validateUploadedDoucment(String uploadDocument) {
		switch (uploadDocument) {
		case "first":
			WebElement isfirstUploadedDocument = searchWebElement(firstUploadedDocument);
			Assert.assertTrue("uploaded document list is not visible", isfirstUploadedDocument.isDisplayed());
			customLogger("first uploaded document list has been validated", "");
			break;
		case "second":
			WebElement isSecondUploadedDocument = searchWebElement(secoundUploadedDocument);
			Assert.assertTrue("uploaded document list is not visible", isSecondUploadedDocument.isDisplayed());
			customLogger("second uploaded document list has been validated", "");
			break;
		default:
			logger.info("uploaded document list is visible");
		}
		logger.info("uploaded document list is visible");
		switchWindow(1);
	}

	public void clickSaveRefreshButton() {
		WebElement savenRefreshButton = searchWebElement(saveRefreshButton);
		seleniumCore.jsClick(savenRefreshButton, PAGE_NAME, " clicked on Save & Refresh button");
		try {
		seleniumCore.handleAlert("OK");
		}catch(Exception e) {
			logger.info(e.getMessage());
		}
		seleniumCore.waitForJStoLoad();
		waitForLoadingData();
		customLogger("clicked on Save & Refresh button ", "");
	}
	
	public void validateCheckDetailsSection() {
		WebElement timeDistributionButton = searchWebElement(createNewDigitalRecord);
		Assert.assertTrue("create new digital record section is not displaying", timeDistributionButton.isDisplayed());
		logger.info("create new digital record section is displaying");
		customLogger("create new digital record section is displaying", "");
	}
	
	public void clickNewDigitalButton() {
		WebElement addnUpdateTransferDetailsButton = searchWebElement(createNewDigitalRecord);
		seleniumCore.jsClick(addnUpdateTransferDetailsButton, PAGE_NAME, " click on create new digital record button");
		customLogger("click on create new digital record button", "");		
	}
	
	public CheckContributionsPage clickAddUpdateCheckDetails() {
		seleniumCore.doesTitleContainText("Shell Process", 60, 1);
		seleniumCore.waitForElementToBeClickable(addUpdateCheckDetails, 30, 1);
		seleniumCore.click(addUpdateCheckDetails);
		seleniumCore.waitForJStoLoad();
		switchTab("CheckContributions");		
		return new CheckContributionsPage(seleniumCore);
	}
	
	public boolean validateAddedCheckDetails() {
		seleniumCore.waitForElementToBeVisible(addUpdateCheckDetails, 20, 1);
		return seleniumCore.isElementVisible(addedCheckDetails);
	}

	public void clickSaveExitButton(String parentWindow) {
		WebElement savenExitButton = searchWebElement(saveExitButton);
		javaScriptExecutor.executeScript("arguments[0].scrollIntoView(true);", savenExitButton);
		seleniumCore.jsClick(savenExitButton, PAGE_NAME, " clicked on Save & Exit button");
		customLogger("clicked on Save & Exit button ", "");	
		seleniumCore.handleAlert("OK");		
		try {
			seleniumCore.handleAlert("OK");
		} catch (Exception e) {
			logger.info(e.getMessage());			
		}		 
		seleniumCore.getDriver().switchTo().window(parentWindow);
		seleniumCore.waitForJStoLoad();
		waitForLoadingData();
	}
	
	public String oneTimeDistributionStatus() {
		return seleniumCore.getText(oneTimeDistributionStatus);
	}
	
	public String residualDistributionStatus() {
		seleniumCore.waitForJStoLoad();
		waitForLoadingData();
		By rdStatus = By.xpath("//p[@id='ResidualStatus_0']");
		return seleniumCore.getText(rdStatus);
	}
	
	public void clickSaveExitButtonForRD(String parentWindow) {
		WebElement savenExitButton = searchWebElement(saveExitButton);
		javaScriptExecutor.executeScript("arguments[0].scrollIntoView(true);", savenExitButton);
		seleniumCore.jsClick(savenExitButton, PAGE_NAME, " clicked on Save & Exit button");
		customLogger("clicked on Save & Exit button ", "");		
		try {
			seleniumCore.handleAlert("OK");
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		if (seleniumCore.isElementFound(By.xpath("//div[@id='terminateNotification'   and   not(contains(@style,'display'))]"), 1, 1)) {
			seleniumCore.click(By.cssSelector("#TerminationBG_override"));
			seleniumCore.waitForJStoLoad();
			waitForLoadingData();		
			Assert.assertTrue("case is not overridden", validateNotesHistory().toLowerCase().contains("override"));			
			seleniumCore.click(By.cssSelector("button#ButtonGroup0_Button2"));
		}		  
		seleniumCore.handleAlert("OK");		
		try {
			seleniumCore.handleAlert("OK");
		} catch (Exception e) {
			logger.info(e.getMessage());			
		}		 
		seleniumCore.getDriver().switchTo().window(parentWindow);
		seleniumCore.waitForJStoLoad();
		waitForLoadingData();
	}
	
	public void updateInternalStatus(String value) {
		seleniumCore.waitForJStoLoad();
		waitForLoadingData();
		seleniumCore.waitForElementToBeClickable(internalStatus, 10, 1);
		seleniumCore.scrollIntoView(seleniumCore.findElement(internalStatus));	
		seleniumCore.selectByValue(internalStatus, value);
		logger.info("internal status has been updated to :" + value);
		customLogger("internal status has been updated to ", value);
	}
	
	public void updateOwningStatus() {
		seleniumCore.waitForElementToBeClickable(owningGroup, 10, 1);
		String presentOwning= seleniumCore.getAttribute(owningGroup, "value");
		seleniumCore.selectByValue(owningGroup, presentOwning);
		logger.info("owning status has been updated " );
		customLogger("owning status has been updated  ", "");
	}
	
	public String validateExternalStatus() {
		seleniumCore.waitForElementToBeVisible(validateExternalStatus, 10, 1);		
		return seleniumCore.getAttribute(validateExternalStatus, "value");		
	}

	public String validateNote() {
		WebElement noteValidate = searchWebElement(noteText);
		customLogger("note has been fetched ", "");
		return noteValidate.getText();
	}

	public void enterNoteTextBox(String value) {
		seleniumCore.waitForElementToBeClickable(noteTextBox, 10, 1);
		seleniumCore.sendKeys(noteTextBox, value, "enter note in Notes textbox");
		customLogger("enter note in Notes textbox ", "");
	}

	public void selecWorkItemType(String value) {	
		waitForLoadingData();
		WebElement workItemTypeSelect = searchWebElement(workItemType);
		seleniumCore.selectByValue(workItemTypeSelect, value);
		logger.info("work item type has been selected to:" + value);
		customLogger("work item type has been selected to: ", value);
		waitForLoadingData();
		seleniumCore.tabOut();
	}

	public void enterCustodialAccountValue(String account) {
		WebElement custAccount = searchWebElement(custodialAccount);
		custAccount.sendKeys(account);
		clickTabKey();
		seleniumCore.waitForElementToBePresent(accountAplIdField, 10, 1);
		logger.info("enter the custodial account number " + SEPARATOR + account);
		customLogger("enter the custodial account number ", account);
	}
	
	public void selectCustodianType(String value) {
		WebElement workItemTypeSelect = searchWebElement(custodian);
		seleniumCore.selectByValue(workItemTypeSelect, value);
		seleniumCore.waitForElementToBePresent(teamName, 10, 1);
		logger.info("select custodian " + SEPARATOR + value);
		customLogger("select custodian : ", value);
	}
	
	public void enterAccountAplId(String value) {
		WebElement workItemTypeSelect = searchWebElement(accountAplId);
		workItemTypeSelect.sendKeys(value);
		clickTabKey();
		seleniumCore.waitForElementToBePresent(accountAplId.cssSelector("[disabled]") , 10, 1);	
		seleniumCore.waitForElementToBePresent(teamName, 10, 1);
		logger.info("enter account apl id " + SEPARATOR + value);
		customLogger("enter account apl id : ", value);
	}
	
	public void clickAddDocumentButton() {
		parentWindow = seleniumCore.getDriver().getWindowHandle();
		WebElement addDoc = searchWebElement(addDocument);
		addDoc.click();
		logger.info("click on add document button ");
		customLogger("click on add document button ", "");
		seleniumCore.waitForUILoading(1000);
	}

	public void switchToUploadDocumentAndUploadDocument(String filePath) {
		switchTab("Upload Document");
		Assert.assertTrue("page title is not equals to upload", seleniumCore.getDriver().getTitle().contains("Upload"));
		upload(filePath);		
		logger.info("switched to upload document page and upload the document ");
		customLogger("switched to upload document page and upload the document ", "");
		seleniumCore.getDriver().switchTo().window(parentWindow);
	}

	public void upload(String filePath) {
		this.seleniumCore.findElement(By.id("browseFile")).sendKeys(filePath);
		logger.info("document has been uploaded");
		customLogger("document has been uploaded ", "");
		this.seleniumCore.isElementVisible(uploadCommitButton, 10, 1);
		this.seleniumCore.findElement(By.id("ButtonGroup1_Button0")).click();
	}

	public void validateUploadedFileTextAndClickSubmitButton(String parentWindow) {
		WebElement buttonSubmit = searchWebElement(submitButton);
		Assert.assertTrue("submit button is not visible ", buttonSubmit.isDisplayed());
		Assert.assertTrue("pending upload text is not present ",
				seleniumCore.getText(pendingUploadText).contains("Pending Upload"));
		buttonSubmit.click();
		seleniumCore.waitForUILoading(2000);
		logger.info("clicked on submit button");
		seleniumCore.handleAlert("OK");
		seleniumCore.waitForJStoLoad();
		seleniumCore.waitForUILoading(8000);
		seleniumCore.getDriver().switchTo().window(parentWindow);
		logger.info("switched to alert and clicked on OK ");
		customLogger("switched to alert and clicked on OK ", "");
	}

	public boolean validateWebVisibility(String notesDescription) {
		logger.info("Validating - web visibility ");
		customLogger("Validating - web visibility  ", "");		
		By webVisibility = By.xpath("//table[@id='Table4']//*[@id='TableCellnote_type0_1_checkbox']");				
		WebElement element=seleniumCore.getDriver().findElement(webVisibility);					
		return	element.isSelected();			
	}
	
	public void checkUploadedDocumentAndClickSubmitCustodianButton() {
		seleniumCore.waitForJStoLoad();		
		if(seleniumCore.findElement(By.cssSelector("#BooleanChoice1_0_hidden")).getAttribute("value").equals("false"))
		seleniumCore.jsClick(seleniumCore.findElement(docVisibility), PAGE_NAME, " click on doc visibility checkbox");
		customLogger("click on doc visibility checkbox ", "");
		WebElement addDoc = searchWebElement(addDocument);
		addDoc.click();
		logger.info("click on submit to custodian/bank button ");
		customLogger("click on submit to custodian/bank button ", "");
		seleniumCore.handleAlert("OK");
	}
	
	public void selectPershingAndUpload() {
		seleniumCore.getDriver().switchTo().activeElement();
		seleniumCore.waitForElementToBeVisible(pershingDocList, 10, 1);
		seleniumCore.selectByIndex(pershingDocList, 1, "select pershing doc type list", "", 10, 1);		
		customLogger("select pershing doc type list ", "");
		seleniumCore.click(uploadCommitButton);
		logger.info("click on upload button ");
		customLogger("click on upload button ", "");			
		seleniumCore.handleAlert("OK");
	}
	
	public void clickFaxButton() {
		seleniumCore.getDriver().switchTo().activeElement();		
		seleniumCore.waitForElementToBeVisible(faxButton, 10, 1);		
		seleniumCore.click(faxButton);
		logger.info("click on fax button ");
		customLogger("click on fax button ", "");			
		seleniumCore.handleAlert("OK");
	}
	
	public void clickFaxButton(String buttonType) {
		seleniumCore.getDriver().switchTo().activeElement();
		if (buttonType.equalsIgnoreCase("fax")) {
			seleniumCore.waitForElementToBeVisible(faxButton1, 10, 1);
			seleniumCore.click(faxButton1);
			logger.info("click on fax button ");
			customLogger("click on fax button ", "");
		} else if (buttonType.equalsIgnoreCase("email")) {
			seleniumCore.waitForElementToBeVisible(emailButton, 10, 1);
			seleniumCore.click(emailButton);
			logger.info("click on email button ");
			customLogger("click on email button ", "");
		} else {
			logger.info("button is not present");
		}
		seleniumCore.handleAlert("OK");
	}
	
	public void checkWebVisibility() {
		seleniumCore.waitForJStoLoad();		
		WebElement webVisibile = searchWebElement(webVisibility);
		seleniumCore.jsClick(webVisibile, PAGE_NAME, " clicked on add & update button");			
	}
	
	public void checkAdvisorVisibility() {	
		WebElement advisorVisibile = searchWebElement(advisorVisibility);
		seleniumCore.jsClick(advisorVisibile, PAGE_NAME, " clicked on add & update button");			
	}
	
	public String validateAdvisorVisibility() {
		return seleniumCore.getAttribute(advisorVisibilityVal, "value");
	}
	
	public void validateTimeStamp() {
		String actualValue= seleniumCore.getText(receivedTime);
		System.out.println(actualValue);
		seleniumCore.waitForUILoading(60000);
		System.out.println(dateUtil.zoneDateTime("America/Los_Angeles"));
		Assert.assertNotEquals("date is not in PST format", dateUtil.zoneDateTime("America/Los_Angeles"), actualValue);		
		logger.info("verified timestamp in PST format");
		customLogger("verified timestamp in PST format", "");
	}

	public String validateAddedOA() {
		WebElement addedOAValue = searchWebElement(addedOA);
		Assert.assertTrue("added OA is displaying ", addedOAValue.isDisplayed());
		String value = seleniumCore.getText(addedOA);
		logger.info("fetch the added OA " + value);
		customLogger("fetch the added OA text- ", value);
		return value;
	}
	
	public void validateJournal() {
		List<WebElement> WebElements= seleniumCore.getDriver().findElements(By.xpath("//*[@id='ojTbody']/tr"));
		if(WebElements.size()==0) {
			logger.info("journal has not been created or updated to cancelled " );
			customLogger("journal has not been created or updated to cancelled ", "");
		}else {
			logger.info("journal has been verified  ");
			customLogger("journal has been verified ", "");
		}		
	}

	public void selectIndividualOwner(String value) {
		seleniumCore.waitForUILoading(5000);
//		seleniumCore.waitForElementToBeClickable(individualOwner, 10, 1);
		seleniumCore.selectByValue(individualOwner, value);
		seleniumCore.click(runNowButton, "click on run now button", value);
		logger.info("individual owner has been  selected as " + value);
		customLogger("individual owner has been selected as ", value);
	}

	public void clickAddDocumentButtonInDocumentList() {
		parentWindow = seleniumCore.getDriver().getWindowHandle();
		seleniumCore.waitForJStoLoad();
		seleniumCore.waitForElementToBeClickable(addDocumentInDocumentList, 20, 1);		
		seleniumCore.click(addDocumentInDocumentList, "click on add document button ", "click on add document button ");
		logger.info("clicked on add document button");
		customLogger("clicked on add document button ", "");
	}

	public void clickUploadedDocandValidate(String filePath) {
		WebElement uploadedDocumentLink = searchWebElement(uploadedDocLink);
		uploadedDocumentLink.click();
		switchTab("FileBound");
		seleniumCore.waitForUILoading(3000);
		String path = seleniumCore.removeAllSpecialCharacter(filePath);
		Assert.assertTrue("uploaded document has not been verified",
				path.contains(seleniumCore.getText(fileName).replaceAll("\\s", "")));
		logger.info("uploaded document has been verified ");
		customLogger("uploaded document has been verified ", "");
		seleniumCore.closeDriver();
		seleniumCore.getDriver().switchTo().window(parentWindow);
	}

	public CreateOAPage clickAddUpdateButton() {
		WebElement addnUpdateButton = searchWebElement(addUpdateButton);
		seleniumCore.jsClick(addnUpdateButton, PAGE_NAME, " clicked on add & update button");
		try {
			seleniumCore.handleAlert("OK");
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		customLogger("clicked on add & update button ", "");
		return new CreateOAPage(seleniumCore);
	}

	public String fetchBNumber() {
		seleniumCore.waitForJStoLoad();
		waitForLoadingData();
		seleniumCore.waitForElementToBeVisible(bNumber, 20, 1);
		String bNum = seleniumCore.getText(bNumber);
		logger.info("fetched b number.." + bNum);
		customLogger("fetched b number ", bNum);
		return bNum;
	}
	
	public String fetchAdvisorAplId() {
		seleniumCore.waitForElementToBeVisible(advisorid, 20, 1);
		String bNum = seleniumCore.getText(advisorid);
		logger.info("fetch advisor apl id " + bNum);
		customLogger("fetch advisor apl id", bNum);
		return bNum;
	}
	
	public void validateTransferFirmDetails() {
		WebElement addnUpdateTransferDetailsButton = searchWebElement(updateTransferDetailsButton);
		Assert.assertTrue("transfer firm details section is not displaying", addnUpdateTransferDetailsButton.isDisplayed());
		logger.info("transfer firm details section is displaying");
		customLogger("transfer firm details section is displaying", "");
	}

	public TransferAttributesPage clickUpdateTransferDetailsButton() {
		WebElement addnUpdateTransferDetailsButton = searchWebElement(updateTransferDetailsButton);
		seleniumCore.jsClick(addnUpdateTransferDetailsButton, PAGE_NAME, " click on update transfer details button");
		customLogger("click on add/update transfer details button", "");
		switchTab("TransferAttributes");
		seleniumCore.waitForJStoLoad();
		waitForLoadingData();
		return new TransferAttributesPage(seleniumCore);
	}

	public void editHeaderData(String value) {
		seleniumCore.waitForJStoLoad();
		waitForLoadingData();
		WebElement addnUpdateButton = searchWebElement(editHeaderData);
		seleniumCore.jsClick(addnUpdateButton, PAGE_NAME, " clicked on edit header data button");
		seleniumCore.waitForJStoLoad();
		waitForLoadingData();		
		seleniumCore.sendKeys(custodianAccount, value, "update cutodian account number");
		seleniumCore.click(saveChangesButton);
		logger.info("clicked on save changes button..");
		customLogger("clicked on add & update button..", "");	
		seleniumCore.waitForJStoLoad();
		waitForLoadingData();
		seleniumCore.click(saveChangesButton);		
		seleniumCore.waitForJStoLoad();
		waitForLoadingData();
	}
	
	public String fetchClientName() {
		seleniumCore.waitForElementToBeVisible(clientName, 10, 1);
		return seleniumCore.getText(clientName).replaceAll("[,&/\\s]", "");
	}

	public void ValidateDList() {
		seleniumCore.waitForJStoLoad();
		waitForLoadingData();
		WebElement addnUpdateButton = searchWebElement(closeNoCheckbox);
		seleniumCore.jsClick(addnUpdateButton, PAGE_NAME, " clicked checkbox No option");
		customLogger("clicked checkbox No option", "");
		seleniumCore.waitForJStoLoad();
		String dNumbers = "//*[@id='closeDNumberTable']/tbody/tr[contains(@id,'close')]";
		seleniumCore.waitForElementToBeVisible(By.xpath(dNumbers), 20, 1);
		int dNumberListSize = seleniumCore.findElements(By.xpath(dNumbers)).size();
		Assert.assertTrue("d# number list is not displayed", dNumberListSize > 0);
		logger.info("d# number list has been displayed, list count is " + dNumberListSize);
		customLogger("d# number list has been displayed, list count is ", Integer.toString(dNumberListSize));
	}
	
	public void closeDNumber() {
		WebElement addnUpdateButton = searchWebElement(closeYesCheckbox);
		seleniumCore.jsClick(addnUpdateButton, PAGE_NAME, " click on yes checkbox to close D number ");
		seleniumCore.waitForJStoLoad();
	}
	
	public void accountCloseOneTimeResidual() {
		WebElement addnUpdateButton = searchWebElement(accountClosingResidual);
		seleniumCore.jsClick(addnUpdateButton, PAGE_NAME, " click on yes checkbox to close account ");
		seleniumCore.click(By.cssSelector("[id*=ConfirmICABtn]"));
		seleniumCore.waitForJStoLoad();
		waitForLoadingData();
	}

	public String selectDNumberAndClickDButton() {
		String dNumber = "//*[@id='closeDNumberTable']/tbody/tr[contains(@id,'close')]//input[@type='checkbox']";
		seleniumCore.waitForElementToBeVisible(By.xpath(dNumber), 20, 1);
		seleniumCore.findElement(By.xpath(dNumber)).click();
		String closeDNumber = seleniumCore.getText(closedDNumber);
		seleniumCore.click(closeDButton, dNumber, "click on close D# button ");
		logger.info("clicked on close D# button ");
		customLogger("clicked on close D# button ", "");

		return closeDNumber;
	}

	public void clickOnActivationButton(String option) {
		switch(option) {
		case "ICT Activation":
			WebElement ictActivate = searchWebElement(activateICTCheckbox);			
			seleniumCore.jsClick(ictActivate, PAGE_NAME, " checked ready to activation ict checkbox");			
			customLogger("activation checkbox has been checked", "");
			seleniumCore.waitForElementToBeClickable(activateICTButton);
			seleniumCore.click(activateICTButton);
			logger.info("clicked on activate ict button");
			customLogger("clicked on activation button", "");
			break;
		case "fee maintenance activation":
			WebElement feeActivate = searchWebElement(feeMaintenanceCheckbox);
			seleniumCore.jsClick(feeActivate, PAGE_NAME, " checked activate fee maintenance checkbox");
			customLogger("checked activate fee maintenance checkbox", "");
			seleniumCore.waitForElementToBeClickable(activateFeeMaintenanceButton);
			seleniumCore.click(activateFeeMaintenanceButton);
			logger.info("clicked on activate fee maintenance ");
			customLogger("click on fee maintenance activation button", "");
			break;
		case "tms activation":
			WebElement tmsActivate = searchWebElement(tmsCheckbox);
			seleniumCore.jsClick(tmsActivate, PAGE_NAME, " checked activate tms checkbox");
			customLogger("checked activate tms checkbox", "");
			seleniumCore.waitForElementToBeClickable(tmsActivateButton);
			seleniumCore.click(tmsActivateButton);
			logger.info("clicked on activate tms ");
			customLogger("click on tms activation button", "");
			break;	
		default:
			logger.info("clicked on activate ict button..");
		}		
	}

	public void validateAddedTransferDetails(String transferRequest) {
		String[] transferData = transferRequest.split(",");
		seleniumCore.waitForElementToBeVisible(contraFirmAccount, 20, 1);
		Assert.assertTrue("contra firm account value has not captured on shell page", seleniumCore.validateTextValue(contraFirmAccount, 10, 1, transferData[2].trim()));
//		Assert.assertTrue("amount value has not captured on shell page", seleniumCore.validateTextValue(amount, 10, 1, transferData[4].trim()));
		logger.info("validated transfer added details on shell page ");
		customLogger("validated transfer added details on shell page", "");
	}
	
	public void updateIndividualOwner(String value) {
		seleniumCore.selectByValue(owningGroup, "QC Account Maintenance");
		seleniumCore.waitForJStoLoad();
		waitForLoadingData();
		seleniumCore.click(refreshUserList);
		seleniumCore.waitForJStoLoad();
		waitForLoadingData();
		seleniumCore.waitForElementToBeClickable(individualOwnerFollowUpOwnership, 10, 1);
		seleniumCore.selectByValue(individualOwnerFollowUpOwnership, value);
		logger.info("Individual owner has been updated to :" + value);
		customLogger("Individual owner status has been updated to ", value);
	}
	
	public void clickTerminationNotificationButton() {
		WebElement terminationNotButton = searchWebElement(terminationNotificationButton);
		seleniumCore.scrollIntoView(terminationNotButton);
		seleniumCore.jsClick(terminationNotButton, PAGE_NAME, " click on termination Notification button");
		seleniumCore.handleAlert("OK");
		customLogger("click on termination Notification button ", "");
	}
	
	public void enterHrcAndSubmit(String number) {
		seleniumCore.waitForElementToBeVisible(hrcTextbox, 20, 1);
		seleniumCore.sendKeys(hrcTextbox, number , "enter hrc value : "+ number);
		seleniumCore.click(hrcSubmitButton);
		seleniumCore.waitForJStoLoad();
		seleniumCore.waitForUILoading(5000);
		customLogger("enter hrc number & click on submit ", "");
	}
	
	public void clickSelectButton(String buttonType) {
		seleniumCore.waitForJStoLoad();
		waitForLoadingData();
		seleniumCore.isUrlContains("WorkflowState", 10, 1);
		if(buttonType.equalsIgnoreCase("select")) {
		try {
			seleniumCore.getDriver().switchTo().activeElement().click();
			action.keyDown(Keys.ENTER).keyUp(Keys.ENTER).build().perform();
		} catch (Exception e) {
			logger.info(e.getMessage());
			try {
				seleniumCore.handleAlert("OK");
			} catch (Exception e1) {
				logger.info(e1.getMessage());
				handleHRCSumissionAlert();
			}
		}
		seleniumCore.getDriver().switchTo().activeElement().click();
		WebElement select = searchWebElement(SelectAccount);
		seleniumCore.jsClick(select, ""," click on select button under account number association");
		customLogger("click on select button under account number association ", "");
		}else {
			seleniumCore.click(addButtonAccountNumberAssociation);
			logger.info("click on add button under account number association");
			customLogger("click on add button under account number association ", "");
			seleniumCore.waitForJStoLoad();
			waitForLoadingData();
		}
	}
	
	public void handleHRCSumissionAlert() {			
		performSikuliClick("HRCSubmissionSuccessfulOK"); 
		performSikuliClick("HRCSubmissionSuccessfulOK");			
		customLogger("click on select button under account number section ", "");
	}
	
	public Map<String, String> validateAddedAccountInAccountNumberAsociation() {
		seleniumCore.waitForElementToBeFound(addedAccountNumber, 10, 1);
		Assert.assertTrue("added account number has not been validated", seleniumCore.isElementVisible(addedAccountNumber));
		Assert.assertTrue("added account name has not been validated", seleniumCore.isElementVisible(addedAccountName));
		customLogger("added account number and account name has been validated on shell page", "");
		Map<String, String> addAccountInfo= new HashMap<String, String>();
		addAccountInfo.put("accountNumber", seleniumCore.getText(addedAccountNumber));
		addAccountInfo.put("accountName", seleniumCore.getText(addedAccountName));
		
		return addAccountInfo;
	}
	
	public void ValidateActivationAlert() {
		seleniumCore.handleAlert("OK");
		logger.info("clicked Ok on alert pop-up");
		customLogger("clicked Ok on alert pop-up", "");
	}
	
	public int validateAccountNumberDigits() {
		seleniumCore.waitForElementToBeVisible(accountNumberDigits, 20, 1);
		return seleniumCore.getText(accountNumberDigits).length();
	}
	
	public String fetchAccountNumberDigits() {
		seleniumCore.waitForElementToBeVisible(accountNumberDigits, 20, 1);
		return seleniumCore.getText(accountNumberDigits);
	}
	
	public void clickAddButton() {
		seleniumCore.isUrlContains("WorkflowState", 10, 1);		
		seleniumCore.waitForElementToBeClickable(addButtonAccountNumberAssociation, 20, 1);		
		WebElement select = searchWebElement(addButtonAccountNumberAssociation);
		seleniumCore.jsClick(select, PAGE_NAME, " click on select button under account number section");		
		customLogger("click on add button under account number association section ", "");
		seleniumCore.waitForJStoLoad();		
		waitForLoadingData();
	}
	
	public void validatePartyManager(String value, String color) {
		switch(value) {
		case "party element":
			seleniumCore.waitForElementToBeVisible(spThirdParty, 10, 1);
			Assert.assertTrue("3rd party element is not visible", seleniumCore.isElementVisible(spThirdParty));
			logger.info("3rd party element is visible");
			customLogger("3rd party element is visible", "");		
			Assert.assertTrue("3rd party element is not highlighted", seleniumCore.getDriver().findElement(spThirdParty).getCssValue("background").contains(color));
			Assert.assertTrue("3rd party element is not highlighted", seleniumCore.getAttribute(spThirdParty, "style").contains(color));
			logger.info("3rd party element is highlighted");
			customLogger("3rd party element is highlighted", "");
			break;
		case "Open Suspend OA":
			seleniumCore.waitForElementToBeVisible(openSuspend, 10, 1);
			Assert.assertTrue("Open suspend OA is not visible", seleniumCore.isElementVisible(openSuspend));
			logger.info("Open suspend OA is visible");
			customLogger("Open suspend OA is visible", "");		
			Assert.assertTrue("Open suspend OA is not highlighted", seleniumCore.getDriver().findElement(openSuspend).getCssValue("background").contains(color));
			Assert.assertTrue("Open suspend OA is not highlighted", seleniumCore.getAttribute(openSuspend, "style").contains(color));
			logger.info("Open suspend OA is highlighted");
			customLogger("Open suspend OA is highlighted", "");
			break;	
		}		
	}
	
	public WebElement validateaddedOAIsDeleted() {
		return searchWebElement(By.cssSelector("#bNumberOAs > tbody > tr"));		
	}
	
	public void clickLastUser() {
		waitForLoadingData();
		seleniumCore.click(lastUserButton);
		logger.info("clicked on return to last user");
		customLogger("clicked on return to last user", "");
	}
	
	public OneTimeDistributionPage clickoneTimeDistributionButton() {
		seleniumCore.doesTitleContainText("Shell Process", 60, 1);
		WebElement timeDistributionButton = searchWebElement(oneTimeDistributionButton);
		seleniumCore.waitForElementToBeVisible(oneTimeDistributionButton, 30, 1);
		seleniumCore.jsClick(timeDistributionButton, PAGE_NAME, " click on one time distribution button");
		customLogger("click on one time distribution button", "");
		switchTab("OneTimeDistribution");
		seleniumCore.waitForJStoLoad();
		waitForLoadingData();
		return new OneTimeDistributionPage(seleniumCore);
	}
	
	public boolean clickResidualDistribution(String status) {	
		String stat = seleniumCore.getText(By.cssSelector("p[id=ResidualStatus_0]"));
		if(stat.equalsIgnoreCase(status)) {
		seleniumCore.click(residualDistributionButton);
		logger.info("clicked on residual distribution button");
		customLogger("clicked on residual distribution button", "");
		switchTab("ResidualDistribution");
		seleniumCore.waitForJStoLoad();
		waitForLoadingData();	
		return true;
		}else {
			return false;
		}
	}
	
	public boolean clickResidualDistributionQcUser() {	
		if(seleniumCore.getText(By.cssSelector("p[id=ResidualStatus_0]")).equalsIgnoreCase("IWRComplete")) {
		seleniumCore.click(residualDistributionButton);
		logger.info("clicked on residual distribution button");
		customLogger("clicked on residual distribution button", "");
		switchTab("ResidualDistribution");
		seleniumCore.waitForJStoLoad();
		waitForLoadingData();	
		return true;
		}else {
			return false;
		}
	}
	
	public void selectAccount() {
		seleniumCore.click(By.xpath("//div[@id='accountTable']//tbody/tr[1]/td[@class='tabledata']/input"),"","",5,1);
		logger.info("account has been selected from the popup");
		customLogger("account has been selected from the popup", "");
	}
	
	public void selectNigoReason() {
		seleniumCore.selectByValue(nigoReason, "Conflicting");
		seleniumCore.selectByVisibleText(nigoReason2, "Address");
		seleniumCore.click(addNigoReason);
		logger.info("nigo reason has added");
		customLogger("nigo reaon has added", "");
		waitForLoadingData();
	}
	
	public String parentBNumber() {
		seleniumCore.waitForElementToBeVisible(parentbNumber, 20, 1);
		return seleniumCore.getText(parentbNumber);
	}
	
	public List<WebElement> validateSpecialRouting() {
		Assert.assertTrue("special routing is not visible", seleniumCore.isElementVisible(spRouting));
		return seleniumCore.findElements(By.xpath("//div[contains(@id,'spSection')]//ul/li"));		
	}
	
	public void createTransferButton() {	
		waitForLoadingData();
		seleniumCore.click(createFidelityTransferButton);
		logger.info("clicked on create fidelity transfer form button");
		customLogger("clicked on create fidelity transfer form button", "");
		seleniumCore.handleAlert("OK");
		waitForLoadingData();
	}
	
	public void initiateRdCloseButton() {			
		seleniumCore.click(intiRdCloseAccount);
		logger.info("clicked on initiate rd and close account button");
		customLogger("clicked on initiate rd and close account button", "");
		seleniumCore.waitForJStoLoad();
		waitForLoadingData();
		seleniumCore.handleAlert("OK");		
	}
	
	public String transferFirmStatus() {
		waitForLoadingData();
		return seleniumCore.getText(By.xpath("//td[./label[text()='Status']]/following-sibling::td"));
	}
}
