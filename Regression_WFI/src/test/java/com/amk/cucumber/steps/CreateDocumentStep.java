package com.amk.cucumber.steps;

import io.cucumber.java.en.Then;

public class CreateDocumentStep  extends GenericStepMethods {
	
	@Then("User click on create documents button")
	public void User_click_on_create_documents_button_and_validate_the_view_documents_page() {
		emptyLogger(" \n ");		
		viewDocumentsPage= createDocumentsPage.createDocumentsConfirmation("Create document button: ", "click on create document button on create document page");		
		emptyLogger(" \n ");
	}
	
}	
