package com.amk.cucumber.steps;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.amk.cucumber.constants.Constants;
import com.amk.cucumber.pages.OneTimeDistributionPage;
import com.amk.cucumber.pages.ShellProcessPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ShellProcessStep  extends GenericStepMethods {		
	
	@Then("Validate notes history section {string}")
	public void validate_notes_history_section(String msg) {
		emptyLogger(" \n ");		
		String text= shellProcessPage.validateNotesHistory();	
		Assert.assertTrue("Error message : text has not been verified in notes history ", text.contains(msg));
		customLogger("expected text is present in notes history ", msg);	
		emptyLogger(" \n ");
	}
	
	@Then("User fetched funding account")
	public void fetchFundingAccount() {
		emptyLogger(" \n ");		
		fundingAccountNumber= shellProcessPage.fetchFundingAccountNumber();	
		logger.info("funding account number "+ fundingAccountNumber);	
		customLogger("funding account number ", fundingAccountNumber);	
		emptyLogger(" \n ");
	}
	
	@Then("User fetched transfer tracking number")
	public void fetchTrackingNumber() {
		emptyLogger(" \n ");		
		transferTrackingNumber= shellProcessPage.fetchTransferNumber();	
		logger.info("transfer tracking number "+ transferTrackingNumber);	
		customLogger("transfer tracking number ", transferTrackingNumber);	
		emptyLogger(" \n ");
	}
	
	@Then("Validate notes history section should not have {string}")
	public void validate_notes_history(String msg) {
		emptyLogger(" \n ");	
		String text= shellProcessPage.validateNotesHistory();	
		Assert.assertFalse("Error message : text has not been verified in notes history ", text.contains(msg));
		customLogger("expected text is not present in notes history ", msg);	
		emptyLogger(" \n ");
	}
	
	@Then("Validate {string} uploaded document")
	public void validate_uploaded_document(String uploadDocument) {
		emptyLogger(" \n ");
		shellProcessPage.validateUploadedDoucment(uploadDocument);
		emptyLogger(" \n ");
	}	
	
	@Then("Click on save & refresh button")
	public void click_on_save_refresh_button_click_on_alert() {
		emptyLogger(" \n ");
		shellProcessPage.clickSaveRefreshButton();
		emptyLogger(" \n ");
	}
	
	@Then("Click termination notification button")
	public void terminationNotificationButton() {
		emptyLogger(" \n ");
		shellProcessPage.clickTerminationNotificationButton();
		emptyLogger(" \n ");
	}
	
	@When("Select work item type {string}")
	public void select_work_item_type(String value) {
		emptyLogger(" \n ");
		shellProcessPage.selecWorkItemType(value);
		emptyLogger(" \n ");
	}
	
	@When("Check doc visibility and click on submit to bank button")
	public void check_doc_visibility_and_click_on_submit_to_bank_button() {
		emptyLogger(" \n ");
		shellProcessPage.checkUploadedDocumentAndClickSubmitCustodianButton();		
		emptyLogger(" \n ");
	}
	
	@When("Select pershing and click upload button")
	public void select_pershing_and_click_upload_bank_button() {
		emptyLogger(" \n ");		
		shellProcessPage.selectPershingAndUpload();
		emptyLogger(" \n ");
	}
	
	@When("Click on {string} button")
	public void click_fax_button(String buttonType) {
		emptyLogger(" \n ");		
		shellProcessPage.clickFaxButton(buttonType);
		emptyLogger(" \n ");
	}
	
	@When("Click on fax button")
	public void click_fax_button() {
		emptyLogger(" \n ");		
		shellProcessPage.clickFaxButton();
		emptyLogger(" \n ");
	}
	
	@When("Select custodian type {string}")
	public void select_custodian_type(String value) {
		emptyLogger(" \n ");
		shellProcessPage.selectCustodianType(value);
		emptyLogger(" \n ");
	}
	
	@When("Enter account apl id")
	public void enter_account_apl_id() {
		emptyLogger(" \n ");
		shellProcessPage.enterAccountAplId(advisorAPLID);
		emptyLogger(" \n ");
	}
	
	@When("Enter Custodial Account value from {string}")
	public void enter_custodial_account_value(String row) {
		emptyLogger(" \n ");		
		switch(row) {
		case "firstRow":
			shellProcessPage.enterCustodialAccountValue(advisorAPLID);
			break;
		case "secondRow":
			firstRow = values.get(0);
			secondRow = values.get(1);
			shellProcessPage.enterCustodialAccountValue(firstRow[2]);
			break;
		}		
		emptyLogger(" \n ");
	}
	
	@When("Enter Custodial Account value {string} , {int}")
	public void enter_custodial_account_value(String sheetName, Integer rowNo) throws InvalidFormatException, IOException {
		emptyLogger(" \n ");			
		clientData = (HashMap<String, String>) getIndividualRowDataFromSheet(sheetName, rowNo);
		shellProcessPage.enterCustodialAccountValue(clientData.get(Constants.ACCOUNT_NUMBER));
		emptyLogger(" \n ");
	}
	
	@When("Select account from select account popup")
	public void accountPopup() throws InvalidFormatException, IOException {
		emptyLogger(" \n ");			
		shellProcessPage.selectAccount();		
		emptyLogger(" \n ");
	}
	
	@When("Select individual owner and click run now {string} , {int}")
	public void select_individual_owner_and_click_run_now(String sheetName, Integer rowNo) throws InvalidFormatException, IOException {
		emptyLogger(" \n ");	
		clientData = (HashMap<String, String>) getIndividualRowDataFromSheet(sheetName, rowNo);
		shellProcessPage.selectIndividualOwner(clientData.get(Constants.INDIVIDUAL_User));		
		emptyLogger(" \n ");
	}
	
	@When("Select individual owner and click run now")
	public void select_individual_owner_and_click_run_now() {
		emptyLogger(" \n ");	
		shellProcessPage.selectIndividualOwner(clientData.get(Constants.INDIVIDUAL_User));		
		emptyLogger(" \n ");
	}
	
	@When("Add document and click on submit")
	public void add_document_and_click_on_submit() {
		emptyLogger(" \n ");
		String filePath=System.getProperty("user.dir") + clientData.get(Constants.PDF_FILE_PATH);
		shellProcessPage.clickAddDocumentButton();
		shellProcessPage.switchToUploadDocumentAndUploadDocument(filePath);
		shellProcessPage.validateUploadedFileTextAndClickSubmitButton(bawPageWindow);       // switched back to baw window
		emptyLogger(" \n ");
	}	
	
	@When("Edit workitem header")
	public void edit_workitem_header() {
		emptyLogger(" \n ");
		shellProcessPage.editHeaderData(secondRow[2]);		
		emptyLogger(" \n ");
	}	
	
	@When("Edit header data")
	public void editHeader() {
		emptyLogger(" \n ");
		shellProcessPage.editHeaderData(clientData.get(Constants.ACCOUNT_NUMBER));		
		emptyLogger(" \n ");
	}
	
	@Then("Validate client name {string} edit")
	public void validate_client_name(String option) {
		emptyLogger(" \n ");
		switch(option) {
		case "before":
			Assert.assertEquals("client name is not matching ", firstRow[0].replaceAll("[,&/\\s]", ""), shellProcessPage.fetchClientName());	
			customLogger("client name has been validated after edit", "");	
			break;
		case "after":			
			Assert.assertEquals("client name is not matching ", secondRow[0].replaceAll("[,&/\\s]", ""), shellProcessPage.fetchClientName());
			customLogger("client name has been validated after edit", "");	
			break;
		}		
		emptyLogger(" \n ");
	}
	
	@When("Click on add document, upload {string} document and validate")
	public void click_on_add_document_and_upload_doc(String docType) {
		String filePath="";
		if(docType.equals(Constants.PDF_FILE_PATH)) {
			filePath =System.getProperty("user.dir") + clientData.get(Constants.PDF_FILE_PATH);
		}else {
			filePath =System.getProperty("user.dir") + clientData.get(Constants.TIF_FILE_PATH);
		}		
		shellProcessPage.clickAddDocumentButtonInDocumentList();
		shellProcessPage.switchToUploadDocumentAndUploadDocument(filePath);
	//	shellProcessPage.clickUploadedDocandValidate(filePath);
		emptyLogger(" \n ");
	}	
	
	@Then("Validate added check details on shell page")
	public void validate_added_check_details() {
		emptyLogger(" \n ");
		Assert.assertTrue("added check details has not been validated ", shellProcessPage.validateAddedCheckDetails());
		customLogger("added check details has been validated", "");	
		emptyLogger(" \n ");
	}

	@Then("^Add a note on shell page \"(.*)\"$")
	public void addNoteAndClickSaveRefreshButton(String value) {
		emptyLogger(" \n ");		
		shellProcessPage.enterNoteTextBox(value);	
		emptyLogger(" \n ");
	}
	
	@Then("^Validate added note in description \"(.*)\"$")
	public void validate_added_note_description(String value) {
		emptyLogger(" \n ");		
		String noteValue= shellProcessPage.validateNote().toLowerCase();
		Assert.assertTrue("added note has not been verified", noteValue.contains(value.toLowerCase()));	
		customLogger("added note has been verified ", "");
		emptyLogger(" \n ");
	}
	
	@Then("Validate external status {string}")
	public void validate_external_status(String value) {
		emptyLogger(" \n ");		
		String actualValue= shellProcessPage.validateExternalStatus();
		Assert.assertEquals("internal status has not been validated ", value, actualValue);
		logger.info("internal status has been validated as: " + actualValue);
		customLogger("internal status has been validated as: ", actualValue);
		emptyLogger(" \n ");
	}
	
	@When("Fetch b number from shell process page")
	public void fetch_bNumber_from_shell_process_page() {
		emptyLogger(" \n ");
		bNumber= shellProcessPage.fetchBNumber();
		emptyLogger(" \n ");
	}	
	
	@When("Fetch advisor aplid from shell process page")
	public void fetch_advisor_aplid_from_shell_process_page() {
		emptyLogger(" \n ");
		advisorAPLID= shellProcessPage.fetchAdvisorAplId();
		emptyLogger(" \n ");
	}
	
	@When("Click on save exit button")
	public void click_on_save_exit_button() {
		emptyLogger(" \n ");
		shellProcessPage.clickSaveExitButton(bawPageWindow);		
		emptyLogger(" \n ");
	}
	
	@When("Click on save exit button for rd")
	public void click_on_save_exit_buttonForRd() {
		emptyLogger(" \n ");
		shellProcessPage.clickSaveExitButtonForRD(bawPageWindow);		
		emptyLogger(" \n ");
	}

	@Then("Validate web visibility {string}")
	public void validate_web_visibility(String noteDesc) {
		emptyLogger(" \n ");
		Assert.assertFalse("document is visible at web", shellProcessPage.validateWebVisibility(noteDesc));		
		customLogger("document is not visible at web","");
		emptyLogger(" \n ");
	}
	
	@Then("Validate one-time distribution status as {string}")
	public void oneTimeDistributionStatus(String status) {
		emptyLogger(" \n ");
		Assert.assertEquals("one-time distribution status is not as expected", shellProcessPage.oneTimeDistributionStatus().toLowerCase(), status.toLowerCase());		
		customLogger("one-time distribution status is not as expected","");
		emptyLogger(" \n ");
	}
	
	@Then("Validate residual distribution status as {string}")
	public void residualDistributionStatus(String status) {
		emptyLogger(" \n ");
		Assert.assertEquals("residual distribution status is not as expected", shellProcessPage.residualDistributionStatus().toLowerCase(), status.toLowerCase());		
		customLogger("residual distribution status is not as expected","");
		emptyLogger(" \n ");
	}
	
	@Then("Validate advisor visibility")
	public void validate_advisor_visibility() {
		emptyLogger(" \n ");
		Assert.assertFalse("document is visible at web",  Boolean.parseBoolean(shellProcessPage.validateAdvisorVisibility()));		
		customLogger("document is not visible at web","");
		emptyLogger(" \n ");
	}
	
	@Then("Validate received date timestamp format")
	public void validate_received_date_timestamp_format() {
		emptyLogger(" \n ");
		shellProcessPage.validateTimeStamp();
		emptyLogger(" \n ");
	}
	
	@When("User check Uncheck web visibility")
	public void user_check_uncheck_web_visibility() {
		emptyLogger(" \n ");
		shellProcessPage.checkWebVisibility();		
		emptyLogger(" \n ");
	}
	
	@When("User check Uncheck Advisor visibility")
	public void user_check_uncheck_Advisor_visibility() {
		emptyLogger(" \n ");
		shellProcessPage.checkAdvisorVisibility();
		emptyLogger(" \n ");
	}
	
	@When("^Update internal status \"(.*)\"$")
	public void update_internal_status(String status) {
		emptyLogger(" \n ");
		shellProcessPage.updateInternalStatus(status);
		emptyLogger(" \n ");
	}
	
	@When("Update owning group")
	public void update_owning_group() {
		emptyLogger(" \n ");
		shellProcessPage.updateOwningStatus();
		emptyLogger(" \n ");
	}
	
	@When("User close the D tracking id")
	public void user_close_the_D_tracking_id() {
		emptyLogger(" \n ");
		shellProcessPage.closeDNumber();
		emptyLogger(" \n ");
	}
	
	@When("User checked yes for account closing")
	public void residualAccountClose() {
		emptyLogger(" \n ");
		shellProcessPage.accountCloseOneTimeResidual();
		emptyLogger(" \n ");
	}
	
	@When("Update individual owner {string}")
	public void update_individual_owner(String user) {
		emptyLogger(" \n ");
		shellProcessPage.updateIndividualOwner(user);
		emptyLogger(" \n ");
	}
	
	@When("click on Update OA button")
	public void click_Update_OA_button() {
		emptyLogger(" \n ");
		createOAPage = shellProcessPage.clickAddUpdateButton();		
		emptyLogger(" \n ");
	}
	
	@When("User enter hrc number and click on submit")
	public void user_enter_hrc_number_and_click_on_submit() {
		emptyLogger(" \n ");
		shellProcessPage.enterHrcAndSubmit(numberHRC);	
		bawDashboardPage.switchWindow(bawPageWindow);	
		emptyLogger(" \n ");
	}
	
	@Then("^Validate modal change or OA has been created on shell page \"(.*)\"$")
	public void validate_added_OA_details_on_shell_page(String value) {
		emptyLogger(" \n ");
		Assert.assertTrue("added OA has not been verified ", shellProcessPage.validateAddedOA().contains(value));
		emptyLogger(" \n ");
	}
	
	@Then("Validate journal creation")
	public void validate_journal_creation() {
		emptyLogger(" \n ");
		shellProcessPage.validateJournal();
		emptyLogger(" \n ");
	}
	
	@Then("Validate transfer firm details section")
	public void validate_transfer_firm_details_section()  {
		emptyLogger(" \n ");		
		shellProcessPage.validateTransferFirmDetails();
		emptyLogger(" \n ");
	}
	
	@Then("Click on update transfer button")
	public void click_on_update_transfer_button()  {
		emptyLogger(" \n ");		
		shellPageWindow= seleniumCore.getDriver().getWindowHandle();
		transferAttributesPage= shellProcessPage.clickUpdateTransferDetailsButton();
		emptyLogger(" \n ");
	}
	
	@Then("Validate transfer details added on shell page")
	public void validate_transfer_details_added_on_shell_page()  {
		emptyLogger(" \n ");		
		shellProcessPage.validateAddedTransferDetails(clientData.get(Constants.TRANSFER_REQUEST)); 	
		emptyLogger(" \n ");
	}
	
	@Then("Validate D list and close the D number")
	public void validate_D_list_and_close_the_D_number()  {
		emptyLogger(" \n ");		
		shellProcessPage.ValidateDList();	
		dTrackingId= shellProcessPage.selectDNumberAndClickDButton();	
		emptyLogger(" \n ");
	}
	
	@Then("Validate {string} alert")
	public void Validate_Activation_alert(String option)  {
		emptyLogger(" \n ");
		shellProcessPage.clickOnActivationButton(option);
		shellProcessPage.ValidateActivationAlert();
		emptyLogger(" \n ");
	}
	
	@Then("Manage alert")
	public void manage_alert()  {
		emptyLogger(" \n ");		
		shellProcessPage.ValidateActivationAlert();
		emptyLogger(" \n ");
	}
	
	@Then("Validate {string} work item is created")
	public void Validate_Activation_workitem_is_created(String option)  {
		emptyLogger(" \n ");
		Assert.assertTrue(option +" workitem has not created", shellProcessPage.getWorkItemHeader().contains(option));
		logger.info(option+" workitem has been created");
		customLogger(option, " workitem has been created");
		emptyLogger(" \n ");
	}
	
	@Then("Click on {string} button under account number association")
	public void click_on_select_button(String buttonType)  {
		emptyLogger(" \n ");		
		shellProcessPage= new ShellProcessPage(seleniumCore);
		 shellProcessPage.clickSelectButton(buttonType);
		emptyLogger(" \n ");
	}
	
	@Then("Validate added account number and account name")
	public void validate_added_account_number_and_account_name()  {
		emptyLogger(" \n ");			
		addAccountInfo= shellProcessPage.validateAddedAccountInAccountNumberAsociation();
		emptyLogger(" \n ");
	}
	
    @Then ("User should Approve Harvest Request")
    public void approveHarvestRequest() {
    	shellProcessPage.approveShellHarvestRequest();
    }
    
    @Then("Validate account number digits should be {int}")
	public void validate_account_number_digits(int digit)  {
		emptyLogger(" \n ");		
		Assert.assertEquals("account digits are not equal to "+ digit, digit, shellProcessPage.validateAccountNumberDigits());	
		customLogger("validated account number digits are equal to ", String.valueOf(digit));
		emptyLogger(" \n ");
	}
    
    @When("Validate open windows number {int}")
	public void validateOpenWindows(int value) {
		emptyLogger(" \n ");
		Assert.assertEquals("workitems are not opened in difefrent tabs", value, shellProcessPage.switchTab());	
		customLogger("workitems are not opened in difefrent tabs ", "");
		emptyLogger(" \n ");
	}
    
    @When("Click on add button under account number association")
	public void click_on_add_button()  {
		emptyLogger(" \n ");			
		shellProcessPage.clickAddButton();
		emptyLogger(" \n ");
	}
    
    @Then("Validate {string} is present and highlight with color {string} on shell page")
	public void validate_party_element_present_highlighted(String value, String color)  {
		emptyLogger(" \n ");		
		shellProcessPage.validatePartyManager(value, color);		
		emptyLogger(" \n ");
	}
    
    @Then("Validate check details section")
	public void validate_check_section()  {
		emptyLogger(" \n ");		
		shellProcessPage.validateCheckDetailsSection();
		emptyLogger(" \n ");
	} 
	
	@Then("Click on create new digital record button")
	public void click_on_crete_new_digital_button()  {
		emptyLogger(" \n ");		
		shellPageWindow= seleniumCore.getDriver().getWindowHandle();
		shellProcessPage.clickNewDigitalButton();						
		emptyLogger(" \n ");
	}
	
	@Then("Click on add update check details button")
	public void click_on_update_check_button()  {
		emptyLogger(" \n ");		
		checkContributionsPage= shellProcessPage.clickAddUpdateCheckDetails();
		emptyLogger(" \n ");
	}
	
	@Then("User validate OA has deleted")
	public void oaDeleted()  {
		emptyLogger(" \n ");	
		Assert.assertNull("OA has not deleted", shellProcessPage.validateaddedOAIsDeleted());
		logger.info("OA has deleted");
		customLogger("OA has deleted", "");
		emptyLogger(" \n ");
	}
	
	@When("User clicked on return to last user button")
	public void clickLastUser()  {
		emptyLogger(" \n ");		
		shellProcessPage.clickLastUser();						
		emptyLogger(" \n ");
	}
	
	@When("User fetch parent b number from shell process page")
	public void parentBNumber()  {
		emptyLogger(" \n ");		
		bNumber= shellProcessPage.parentBNumber();						
		emptyLogger(" \n ");
	}
	
	@Then("Click on one time distribution button")
	public void click_on_one_time_distribution_button()  {
		emptyLogger(" \n ");		
		shellPageWindow= seleniumCore.getDriver().getWindowHandle();
		oneTimeDistributionPage= shellProcessPage.clickoneTimeDistributionButton();
		emptyLogger(" \n ");
	}
	
	@When("User click on residual distribution button when status is {string}")
	public void clickResButton(String stat)  {
		emptyLogger(" \n ");		
		residualDistribution = shellProcessPage.clickResidualDistribution(stat);						
		emptyLogger(" \n ");
	}
	
	@When("User clicks on residual distribution button when status is {string}")
	public void clicksResButton(String stat)  {
		emptyLogger(" \n ");	
		oneTimeDistributionPage = new OneTimeDistributionPage(seleniumCore);
		residualDistribution = shellProcessPage.clickResidualDistribution(stat);						
		emptyLogger(" \n ");
	}
	
	@When("Click on residual distribution button for qc user")
	public void clickResButtonQcUser()  {
		emptyLogger(" \n ");		
		residualDistribution = shellProcessPage.clickResidualDistributionQcUser();						
		emptyLogger(" \n ");
	}
	
	@Then("Validate retained account number")
	public void retainedAccountNumber() {
		emptyLogger(" \n ");
		Assert.assertTrue("account number is not retained on shell page ", shellProcessPage.fetchAccountNumberDigits().equalsIgnoreCase(retainAccountNumber));
		logger.info("account number has retained on shell page");
		customLogger("account number has retained on shell page", "");
		emptyLogger(" \n ");
	}
	
	@When("User add NIGO reason")
	public void addNIGOReason()  {
		emptyLogger(" \n ");		
		shellProcessPage.selectNigoReason();						
		emptyLogger(" \n ");
	}
	
	@Then("Validate special routing section")
	public void validateSpRouting() {
		emptyLogger(" \n ");
		List<WebElement> elements = shellProcessPage.validateSpecialRouting();
		Assert.assertTrue("multiple special routing rules are not present ", elements.size()==2);
		logger.info("multiple special routing rules are present");
		customLogger("multiple special routing rules are present", "");
		emptyLogger(" \n ");
	}
	
	@When("User click on transfer fidelity form")
	public void transferFidelityButton()  {
		emptyLogger(" \n ");		
		shellProcessPage.createTransferButton();						
		emptyLogger(" \n ");
	}
	
	@When("User verify form is downloaded")
	public void downloadForm()  {
		emptyLogger(" \n ");		
		String date = seleniumCore.dateCreation(0, "MMddyy");
		String pdfName= bNumber+"_00000000_TOAIN_"+date;
		String text= clientData.get(Constants.ACCOUNT_NUMBER);
		validatePdfContent(pdfName, text);
		shellProcessPage.createTransferButton();						
		emptyLogger(" \n ");
	}
	
	@When("Remove downloaded file")
	public void deleteFile()  {
		emptyLogger(" \n ");		
		String date = seleniumCore.dateCreation(0, "MMddyy");
		String pdfName= bNumber+"_00000000_TOAIN_"+date;
		deletePDFFile(pdfName);						
		emptyLogger(" \n ");
	}
	
	@Then("Validate transfer details status as {string}")
	public void validateTransferStatus(String sta) {
		emptyLogger(" \n ");	
		String status= shellProcessPage.transferFirmStatus();
		Assert.assertTrue("transfer status is not as expected", status.toLowerCase().contains(sta.toLowerCase()));
		logger.info("transfer status is as expected "+ status);
		customLogger("transfer status is as expected", status);
		emptyLogger(" \n ");
	}
	
	@When("User clicks on initiate rd and close account button")
	public void initiateRdCloseButton()  {
		emptyLogger(" \n ");		
		shellProcessPage.initiateRdCloseButton();						
		emptyLogger(" \n ");
	}
	
}	
