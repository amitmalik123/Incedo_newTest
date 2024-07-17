package com.amk.cucumber.steps;

import java.io.File;

import org.junit.Assert;

import com.amk.cucumber.constants.Constants;
import com.amk.cucumber.utility.PDFReader;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ItemDetailsStep  extends GenericStepMethods {
	
	@Then("User upload the PDF file")
	public void user_should_upload_pdf_file() {
		emptyLogger(" \n ");
		itemDetailsPage.clickUploadButton();		
		itemDetailsPage.uploadFile(System.getProperty("user.dir") + clientData.get(Constants.PDF_FILE_PATH));
		customLogger("file has been uploaded succesfully ", "");
		itemDetailsPage.closeUploadPopUp();
//		Validate_added_note("successfully uploaded");
		emptyLogger(" \n ");		
	}
	
	@Then("User verify the tracking Id starts with B")
	public void user_should_verify_the_tracking_id_starts_with_b() {
		emptyLogger(" \n ");	
		bTrackingId = itemDetailsPage.clickOnBTrackingId(dTrackingId);
		logger.info("*****  ####  b number  : "+bTrackingId);
		customLogger(" d number has been converted into b number ", bTrackingId);	
		emptyLogger(" \n ");
	}
	
	@Then("Validate item status {string}")
	public void Validate_item_status (String value)  {
		emptyLogger(" \n ");	
		String status= itemDetailsPage.ValidateStatus();
		Assert.assertTrue("d number status is not "+ value, status.contains(value));
		customLogger("d number status ", value);	
		emptyLogger(" \n ");
	}
	
	@Then("Validate item advisor alert required {string}")
	public void Validate_item_advisor_alert_required(String value)  {
		emptyLogger(" \n ");	
		String status= itemDetailsPage.ValidateAdvisorAlertRequired();
		Assert.assertTrue("item advisor alert required value is no "+ status, status.contains(value));
		customLogger("item advisor alert required value is ", value);	
		emptyLogger(" \n ");
	}
	
	@When("User add the new note {string}")
	public void user_add_the_new_note(String note) {
		emptyLogger(" \n ");
		itemDetailsPage.clickAddNewNoteButton();	
		Assert.assertTrue("add new note pop-up is not visible", itemDetailsPage.isAddNewNotePopUpDisplayed());
		itemDetailsPage.writeNewNoteInAddNewNotePopUp(note);		
		itemDetailsPage.saveNewNote();
		emptyLogger(" \n ");		
	}
	
	@Then("Validate first note {string}")
	public void Validate_added_note(String value) {		
		String status = itemDetailsPage.getFirstNoteDescription();
		if (value.contains("not check")) {
			Assert.assertFalse("check detail section is displaying ", status.contains(value));
			customLogger("check detail section is not displaying ", "");
		} else {
			Assert.assertTrue("added note is not validating ", status.contains(value));
			customLogger("added note has been validated ", value);
		}		
	}
	
	@Then("Validate second note {string}")
	public void Validate_2nd_added_note (String value)  {
		emptyLogger(" \n ");	
		String status= itemDetailsPage.getSecondNoteDescription();
		Assert.assertTrue("added note is not validating ", status.contains(value));
		emptyLogger(" \n ");
	}
	
	@When("User clicks on view button")
	public void user_clicks_on_view_button() {
		emptyLogger(" \n ");
		itemDetailsPage.clickViewButton();			
		emptyLogger(" \n ");		
	}
	
	@Then("Validate view documents popup")
	public void validate_view_documents_popup () {
		emptyLogger(" \n ");
		Assert.assertTrue("view documents popup is not displaying ", itemDetailsPage.isViewDocumentsPopUpDisplayed());	
		customLogger("view documents popup is displaying ", "");	
		emptyLogger(" \n ");		
	}
	
	@Then("Validate uploaded document {string} on view documents popup")
	public void validate_uploaded_document_on_view_documents_popup (String docName) {
		emptyLogger(" \n ");
		Assert.assertTrue("view documents popup is not displaying ", itemDetailsPage.validateUploadedDocOnViewDocumentsPopUp().contains(docName.toLowerCase()));		
		customLogger("uploaded document is present on view documents popup ", "");	
		emptyLogger(" \n ");		
	}
	
	@Then("Validate eSignature button")
	public void validate_eSignature_button () {
		emptyLogger(" \n ");
		Assert.assertTrue("eSignature button is not displaying ", itemDetailsPage.isESignatureButtonVisible());				
		emptyLogger(" \n ");		
	}
	
	@Then("Validate finish now button is visible")
	public void validate_Finish_Now_button_is_visible () {
		emptyLogger(" \n ");
		Assert.assertTrue("finish now button is not displaying ", itemDetailsPage.isFinishNowButtonVisible());				
		emptyLogger(" \n ");		
	}
	
	@When("User clicks on finish now button")
	public void user_clicks_on_finish_now_button() {
		emptyLogger(" \n ");
		itemDetailsPage.clickFinishNowButton();			
		emptyLogger(" \n ");		
	}
	
	@Then("User fetch the N number")
	public void user_fetch_the_N_number() {
		emptyLogger(" \n ");
		String nNumber= itemDetailsPage.getItemNumber();
		logger.info("n number is "+ nNumber);
		customLogger("n number is  - ", nNumber);
		emptyLogger(" \n ");		
	}
	
	@When("User clicks on cancel button")
	public void user_clicks_on_cancel_button() {
		emptyLogger(" \n ");
		itemDetailsPage.clickCancelButton();			
		emptyLogger(" \n ");		
	}
	
	@Then("Validate transfer details added on item details page")
	public void validate_transfer_details_added_on_shell_page()  {
		emptyLogger(" \n ");		
		itemDetailsPage.clickShowDetails();
		itemDetailsPage.validateAddedTransferDetails(clientData.get(Constants.TRANSFER_REQUEST)); 	
		emptyLogger(" \n ");
	}
	
	@Then("Validate distribution details on item details page")
	public void validateDistributionDetails()  {
		emptyLogger(" \n ");		
		itemDetailsPage.clickShowDetails();		
		Assert.assertTrue("distibution record is not visible on item detail page", itemDetailsPage.validateDistribuitonDetails().contains(clientData.get(Constants.Withdrawal_Method)));
		emptyLogger(" \n ");
	}
	
	@Then("Validate confirmation note {string}")	
	public void validate_confirmation_note(String note) {	
		emptyLogger(" \n ");	
		Assert.assertEquals("confirmation has not been validated", note.trim(), itemDetailsPage.confirmNote());	
		customLogger("confirmation has been validated ", note);		
		emptyLogger(" \n ");			
	}	
	
	@Then("Validate description text as {string}")
	public void validateDescription(String value) {
		Assert.assertTrue("description is not as expected", itemDetailsPage.getDescriptionText().contains(value));
	}
	
	@When("User download pdf document")
	public void validatePDFContent() {
		emptyLogger(" \n ");
		itemDetailsPage.openViewDocumentsFromPopUp();			
		emptyLogger(" \n ");		
	}		
	
	@When("User clicks on submit button")
	public void clickSubmitButton() {
		emptyLogger(" \n ");
		seleniumCore.click(itemDetailsPage.submit);
		customLogger("click on submit button", "");	
		logger.info("click on submit button");
		seleniumCore.waitForUILoading(5000);
		emptyLogger(" \n ");		
	}
}	
