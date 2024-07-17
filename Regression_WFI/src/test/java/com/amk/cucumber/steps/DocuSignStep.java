package com.amk.cucumber.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DocuSignStep  extends GenericStepMethods {
	
	@Then("User navigates to docu sign page and clicks on Continue & Finish button")
	public void User_navigated_to_doc_sign_page_and_clicks_on_Continue_Finish_button() {	
		emptyLogger(" \n ");
		docuSignPage.clickContinueButton();			
		docuSignPage.clickFinishButton();
		emptyLogger(" \n ");
	}
	
	@Then("User does the esign")
	public void User_does_esign() {
		emptyLogger(" \n ");		
		docuSignPage.eSign();
		emptyLogger(" \n ");
	}
	
	@Then("User check the checkbox and sign the document")
	public void User_check_the_checkbox_and_sign_the_document() {
		emptyLogger(" \n ");		
		docuSignPage.eSignatureSign();
		emptyLogger(" \n ");
	}
	
	@Then("User view and accept additional and supplemental document")
	public void user_view_and_accept_additional_and_supplemental_document() {
		emptyLogger(" \n ");		
		itemDetailsPage=docuSignPage.eSignatureAdditionalAndSupplementalDocument();
		emptyLogger(" \n ");
	}
	
	@When("User answer in person questions")
	public void user_answer_person_question() {
		emptyLogger(" \n ");		
		docuSignPage.signDocument();
		docuSignPage.answerQuestions();
		docuSignPage.signDocument();
		emptyLogger(" \n ");
	}
	

	@When("User click on initial button")
	public void user_click_sign_button(){
		emptyLogger(" \n ");
		docuSignPage.eInitial();
		emptyLogger(" \n ");
	}
	
}	
