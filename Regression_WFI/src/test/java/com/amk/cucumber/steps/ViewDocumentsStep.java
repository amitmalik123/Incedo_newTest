package com.amk.cucumber.steps;

import org.junit.Assert;

import com.amk.cucumber.constants.Constants;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ViewDocumentsStep  extends GenericStepMethods {
	
	@When("User perform actions on view documents page and fetch require data")
	public void User_perform_actions_on_view_documents_page() {
		emptyLogger(" \n ");	
		viewDocumentsPage.clickCombinedDocumentsBtn("Combined document button: ", "click on one combined document button on view document page");
		numberHRC= viewDocumentsPage.switchApplicationPage();		
		emptyLogger(" \n ");
	}
	
	@Then("User Verifies Separate Documents")
	public void user_verifies_separate_Button(){
		emptyLogger(" \n ");
		viewDocumentsPage.validateSeparateButton();
		emptyLogger(" \n ");
	}
	
	@Then("User does the esignature with {string} method")
	public void User_does_esignature(String option) {
		emptyLogger(" \n ");
		docuSignPage = viewDocumentsPage.eSignatureStart(option);
		docuSignPage.eSignatureSign();
		emptyLogger(" \n ");
	}	

	@Then("User Verifies the message after agent is done with its part in esignature {string}")
	public void verify_client_side_message(String text) {
		emptyLogger(" \n ");
		viewDocumentsPage.verifyclientmessage(text);
		emptyLogger(" \n ");
	}
	
	@When("User clicks on tracking center link")
	public void user_clicks_on_tracking_center_link() {
		emptyLogger(" \n ");
		itemDetailsPage= viewDocumentsPage.clickTrackingCenterLinkOnEmailSentModel();
		emptyLogger(" \n ");
	}
	
	@When("User clicks on Separate Documents and select Accounts Establishment option")
	public void User_clicks_Separate_Documents_and_select_Accounts_Establishment() {
		emptyLogger(" \n ");
		viewDocumentsPage.clickSeparateDocumentsBtn("Separate Documents Button: ","click on Separate Documents button on view document page");
		numberHRC= viewDocumentsPage.switchApplicationPage();
		customLogger("hrc number is ", numberHRC);
		viewDocumentsPage.closeSeparateDocuments("Close Separate Documents", "clicked on Close button on View, Print or Save Documents dialogbox");
		customLogger("Click Separate Documents", "Successfully clicked Separate Documents and selected Accounts Establishment option");
		emptyLogger(" \n ");
	}
	
	@When("User clicks on Separate Documents and validate {string} instructions")
	public void validateInstructions(String option) {
		emptyLogger(" \n ");
		viewDocumentsPage.clickSeparateDocumentsBtn("Separate Documents Button: ","click on Separate Documents button on view document page");
		if(option.equalsIgnoreCase("transfer")) {
			customLogger("transfer instructions notes are displyed", "");
		}else {
			customLogger("liquidate instructions notes are displyed", "");
		}
		emptyLogger(" \n ");
	}
	
	@Then("User navigates to view documents page and click on procees to submit button")
	public void User_clicks_on_proceed_to_submit_button_and_navigates_to_submit_page() {
		emptyLogger(" \n ");
		submitPage = viewDocumentsPage.clickProceedSubmitButton("Proceed to submit button: ", "click on proceed to submit button on view document page");		
		emptyLogger(" \n ");
	}
	
	@When("User add the additional documents")
	public void user_upload_the_additional_documents() {
		emptyLogger(" \n ");
		viewDocumentsPage.addAdditionalDocument();
		emptyLogger(" \n ");
	}
	
	@When("User upload the {string} document")
	public void user_upload_the_document(String doc) {
		emptyLogger(" \n ");
		String filePath=System.getProperty("user.dir") + clientData.get(Constants.PDF_FILE_PATH);		
		viewDocumentsPage.UploadDocument(filePath);			
		emptyLogger(" \n ");
	}
	
	@When("User add label and click on done")
	public void user_add_label_and_click_on_done() {
		emptyLogger(" \n ");
		viewDocumentsPage.addLabel("additionalDocument");
		viewDocumentsPage.clickDoneButton();
		emptyLogger(" \n ");
	}
	
	@Then("User validate status {string}")
	public void user_validate_status(String value) {
		emptyLogger(" \n ");
		Assert.assertEquals("status is not matchng", value, viewDocumentsPage.validateStatus());
		emptyLogger(" \n ");
	}
	
	@When("User clicks the supplemental documents button")
	public void user_clicks_the_supplemental_documents_button() {
		emptyLogger(" \n ");
		viewDocumentsPage.clickSupplementalDocumentsButton();
		emptyLogger(" \n ");
	}
	
	@Then("User validate the {string} page")
	public void user_validate_the_page(String value) {
		emptyLogger(" \n ");
		Assert.assertTrue("status is not matchng",  viewDocumentsPage.clickReviewAndConfirmButtonAndValidateReviewAndConfirmPage().contains(value));
		emptyLogger(" \n ");
	}
	
	@Then("User validate the confirm message {string}")
	public void user_validate_the_confirm_message(String value) {
		emptyLogger(" \n ");
		docuSignPage = viewDocumentsPage.validateConfirmButtonMessage(value);
		emptyLogger(" \n ");
	}
	
}	
