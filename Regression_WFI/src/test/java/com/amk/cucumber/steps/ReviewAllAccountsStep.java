package com.amk.cucumber.steps;

import io.cucumber.java.en.Then;

public class ReviewAllAccountsStep  extends GenericStepMethods {
	
	@Then("User navigates to review all accounts tab and click on create documents button")
	public void User_click_on_create_documents_button_and_navigate_to_create_documents_page() {
		emptyLogger(" \n ");	
		reviewAllAccountsPage.checkIfAllApproved();	
		createDocumentsPage=reviewAllAccountsPage.confirmClientsDocuments();
		emptyLogger(" \n ");
	}
	
}	
