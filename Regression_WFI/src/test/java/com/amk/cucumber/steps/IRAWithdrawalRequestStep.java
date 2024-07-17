package com.amk.cucumber.steps;

import org.junit.Assert;

import com.amk.cucumber.constants.Constants;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class IRAWithdrawalRequestStep  extends GenericStepMethods {
	
	@When("User clicks on Not a withdrawal_button")
	public void user_clicks_on_Not_a_withdrawal_button() {
		emptyLogger(" \n ");
		iRAWithdrawalRequestPage.clickNotWithdrawalButton();		
		emptyLogger(" \n ");
	}
	
	@Then("Select work item {string} and click on reclassify work item")
	public void select_work_item_and_click_on_reclassify_work_item(String workType) {
		emptyLogger(" \n ");
		iRAWithdrawalRequestPage.selectReclassifyWorkItem(workType);	
		iRAWithdrawalRequestPage.clickReClassifyWorkItemButton(bawPageWindow);
		emptyLogger(" \n ");
	}
	
	@When("User clicks on cancel advisor request button")
	public void user_clicks_on_cancel_advisor_request_button() {
		emptyLogger(" \n ");
		iRAWithdrawalRequestPage.clickCancelAdvisorRequetButton(bawPageWindow);	
		emptyLogger(" \n ");
	}
	
	@When("Validate OCR screen should be skipped {string}")
	public void validate_ocr_screen_be_skipped(String option) {
		emptyLogger(" \n ");
		if(option.equals("No")) {
		Assert.assertTrue("ocr screen is not visible", iRAWithdrawalRequestPage.validateOCRScreen());
		logger.info("ocr screen has not been skipped");
		customLogger("ocr screen has been validated ", "");
		}else {
			Assert.assertFalse("ocr screen is visible", iRAWithdrawalRequestPage.validateOCRScreen());
			logger.info("ocr screen has been skipped");
			customLogger("ocr screen has been skipped ", "");
		}		
		emptyLogger(" \n ");
	}
	
	@When("User clicks on OCR Complete button")
	public void user_clicks_on_OCR_Complete_button() {
		emptyLogger(" \n ");
		iRAWithdrawalRequestPage.clickOCRComplete();		
		emptyLogger(" \n ");
	}
	
	@Then("Validate work item under work items and images sections")
	public void open_work_item_link()  {
		emptyLogger(" \n ");
		iRAWithdrawalRequestPage.clickWorkItemLink();			
		emptyLogger(" \n ");
	}
	
	@Then("User validate IWR screen should display")
	public void user_validate_IWR_screen_should_display() {
		emptyLogger(" \n ");
		Assert.assertTrue("IWR screen is not displaying", iRAWithdrawalRequestPage.validateIWRScreen());
		logger.info("iwr screen has displayed");
		customLogger("IWR screen has ben validated ", "");
		emptyLogger(" \n ");
	}
	
	@When("User enters withdrawal amount {string} and click continue button")
	public void user_enter_require_info_on_account_information_section(String amount) {
		emptyLogger(" \n ");
		iRAWithdrawalRequestPage.accountInformation(amount);		
		iRAWithdrawalRequestPage.clickContinueButton(0);		
		emptyLogger(" \n ");
	}
	
	@Then("Validate distribution reason section and navigate to tax withHolding")
	public void validate_distribution_reason_section_and_navigate_to_tax_withHolding() {
		emptyLogger(" \n ");
		iRAWithdrawalRequestPage.distributionReason();		
		iRAWithdrawalRequestPage.clickContinueButton(1);
		emptyLogger(" \n ");
	}
	
	@Then("Validate tax section with {string} and navigate to delivery method segment")
	public void validate_tax_withHolding_section_and_navigate_to_delivery_method_segment(String type) {
		emptyLogger(" \n ");
		iRAWithdrawalRequestPage.taxWithholding(type);
		iRAWithdrawalRequestPage.clickContinueButton(2);
		emptyLogger(" \n ");
	}
	
	@Then("User enters required information on delivery section")
	public void user_enters_required_information_on_delivery_section() {
		emptyLogger(" \n ");
		if (clientData.get(Constants.TYPE_KEY).equalsIgnoreCase("Withdrawal via ACH"))
			iRAWithdrawalRequestPage.deliveryMethod(); 
		else {
		String deliveryTabData= clientData.get(Constants.DELIVERY_DATA);
		String [] deliveryData= deliveryTabData.split(",");
		iRAWithdrawalRequestPage.deliveryMethod(clientData.get(Constants.Withdrawal_Method),deliveryData);
		}
		emptyLogger(" \n ");
	}
	
	@When("User select existing bank")
	public void user_select_existing_bank() {
		emptyLogger(" \n ");
		iRAWithdrawalRequestPage.selectExistingBank(clientData.get(Constants.EXISTING_BANK_ACCOUNT));
		emptyLogger(" \n ");
	}
	
	@When("User select {string} SLOA")
	public void user_select_check_SLOA(String type) {
		emptyLogger(" \n ");
		iRAWithdrawalRequestPage.selectSLOACheck(type);
		emptyLogger(" \n ");
	}
	
	@Then("Navigate to signature segment")
	public void navigate_to_signature_segment() {
		emptyLogger(" \n ");			
		if (!clientData.get(Constants.TYPE_KEY).equalsIgnoreCase("Withdrawal via ACH")) {
			String deliveryType = iRAWithdrawalRequestPage.validateDeliveryMethod();
			Assert.assertTrue("verify the delivery method ", clientData.get(Constants.Withdrawal_Method).contains(deliveryType));
			customLogger("delivery method is", deliveryType);
		}
		iRAWithdrawalRequestPage.clickContinueButton(3);		
		emptyLogger(" \n ");
	}
	
	@Then("add {string} in the signature section and continue")
	public void add_NIGO_text_in_the_signature_section_and_continue(String note) {
		emptyLogger(" \n ");		
		iRAWithdrawalRequestPage.signature();
		if(!note.contains("no")) { 
		  iRAWithdrawalRequestPage.addNIGONotes(note);		
		}    
		iRAWithdrawalRequestPage.clickContinueButton(4);
		emptyLogger(" \n ");
	}
	
	@Then("Validate {string} page and nigo added note {string}")
	public void validate_IWR_summary_page_and_nigo_added_note(String summary, String note) {
		emptyLogger(" \n ");
		Assert.assertEquals("iwr summary screen is not validated", iRAWithdrawalRequestPage.validateIWRSummary(), summary.toLowerCase());		
		logger.info("iwr summary screen is validated");
		customLogger("iwr summary screen is validated ", "");		
		Assert.assertTrue("added nigo note has not been validated",iRAWithdrawalRequestPage.validateAddedNIGONotes().contains(note.toLowerCase()));
		logger.info("added nigo note has been validated");
		customLogger("added nigo note has been validated ", "");		 
		emptyLogger(" \n ");
	}
	
	@Then("Validate added note {string} in notes history")
	public void validate_added_note_in_history(String note) {
		emptyLogger(" \n ");		
		Assert.assertTrue("added note has not been validated in history", iRAWithdrawalRequestPage.validateAddedNoteInHistory().contains(note.toLowerCase()));	
		logger.info("added note has been validated in notes history ");
		customLogger("added note has been validated in notes history", "");
		emptyLogger(" \n ");
	}
	
	@Then("Click on save notes button")
	public void click_on_save_notes_button() {
		emptyLogger(" \n ");
		iRAWithdrawalRequestPage.saveNotesButton();
		emptyLogger(" \n ");
	}
	
	@Then("Add nigo reason and validate added reason and click on IWR complete button")
	public void add_nigo_reason_and_click_on_IWR_complete_button()  {
		emptyLogger(" \n ");
		iRAWithdrawalRequestPage.addNIGOReasonAndValidate();
		emptyLogger(" \n ");
	}
	
	@Then("Delete note and click on GotoIWR button")
	public void delete_note__and_click_on_GotoIWR_button()  {
		emptyLogger(" \n ");
		iRAWithdrawalRequestPage.clickDeleteLink();
		iRAWithdrawalRequestPage.clickGoToIWR();
		emptyLogger(" \n ");
	}
	
	@Then("Validate {string} task")
	public void validate_IWR_task(String summary) {
		emptyLogger(" \n ");
		Assert.assertEquals("iwr summary task is not validated", iRAWithdrawalRequestPage.validateIWRSummary().trim(), summary.toLowerCase().trim());		
		logger.info("iwr task is validated");
		customLogger("task has been validated: ", summary);		
		emptyLogger(" \n ");
	}
	
	@Then("Navigate to signature section, uncheck NIGO checkbox and click continue")
	public void navigate_to_signature_section()  {
		emptyLogger(" \n ");
		iRAWithdrawalRequestPage.procedingToSignatureSection();		
		emptyLogger(" \n ");
	}
	
	@When("User click on add bank instructions and add the bank details")
	public void user_click_on_add_bank_instructions_and_add_the_bank_details()  {
		emptyLogger(" \n ");
		iRAWithdrawalRequestPage.viewAddBankInstructions();		
		emptyLogger(" \n ");
	}
	
	@Then("Validate IWR & Place Trade tabs and enter date in followup date modal")
	public void validate_IWR_Place_Trade_tabs_and_enter_date_in_followup_date_modal() {
		emptyLogger(" \n ");		
	//	  iRAWithdrawalRequestPage.validateIWRTab();
		  iRAWithdrawalRequestPage.validatePlaceTradeTab();
		  iRAWithdrawalRequestPage.followUpDateModal();		
		emptyLogger(" \n ");
	}
	
	@When("User clicks on setup instructions complete button")
	public void user_clicks_on_setup_instructions_complete_button() {
		emptyLogger(" \n ");
		iRAWithdrawalRequestPage.clickSetUpInstructionsComplete();		
		emptyLogger(" \n ");
	}
	
	@Then("Validate request distribution tab and submit to beta")
	public void validate_request_distribution_tab() {
		emptyLogger(" \n "); 	 
		iRAWithdrawalRequestPage.expandRequestDistributionTabAndClickSubmitToBeta(bawPageWindow);
		emptyLogger(" \n ");
	}
	
	@When("User navigate to special handling and cancel advisor request")
	public void user_navigate_to_special_handling_and_cancel_advisor_request() {
		emptyLogger(" \n ");
		iRAWithdrawalRequestPage.cancelAdvisorReqest(bawPageWindow);		
		emptyLogger(" \n ");
	}
	
	@Then("Validate beta submission request")
	public void validate_beta_submission_request() {
		emptyLogger(" \n "); 	 
		iRAWithdrawalRequestPage.validateBetaConfirmation();
		emptyLogger(" \n ");
	}
	
	@When("Expand document OCR Compare tab and upload document")
	public void expand_document_OCR_Compare_tab_and_upload_document()  {
		emptyLogger(" \n ");
		String filePath=System.getProperty("user.dir") + clientData.get(Constants.PDF_FILE_PATH);
		iRAWithdrawalRequestPage.documentsOCRCompareTab(filePath);			
		emptyLogger(" \n ");
	}
	
	@Then("Validate uploaded document in document OCR section")
	public void validate_uploaded_document_in_document_OCR_section() {
		emptyLogger(" \n "); 	 
		iRAWithdrawalRequestPage.verifyUploadedFileInOCRCompareTab();
		emptyLogger(" \n ");
	}
	
	@Then("Validate submitToCustodianModal")
	public void Validate_submitToCustodianModal()  {
		emptyLogger(" \n ");
		iRAWithdrawalRequestPage.submitToCustodianUploadDoc();
		iRAWithdrawalRequestPage.submitToCustodianFax();
		emptyLogger(" \n ");
	}
	
	@When("User update special handling section")
	public void spSection()  {
		emptyLogger(" \n ");
		iRAWithdrawalRequestPage.specialHandlingSection();		
		emptyLogger(" \n ");
	}
	
	@Then("Validate rd on baw page")
	public void validateRdChanges()  {
		emptyLogger(" \n ");
		iRAWithdrawalRequestPage.validateSponBAW();		
		emptyLogger(" \n ");
	}
}	
