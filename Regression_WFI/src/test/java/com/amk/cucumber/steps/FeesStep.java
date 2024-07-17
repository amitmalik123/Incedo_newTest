package com.amk.cucumber.steps;

import com.amk.cucumber.constants.Constants;

import io.cucumber.java.en.When;

public class FeesStep  extends GenericStepMethods {	

	@When("^User Enters the flat fee and click on next \"(.*)\"$")
	public void enter_flat_fee_and_navigate_docSign_page(String fee) {
		emptyLogger(" \n ");
		feesPage.enterFlatFee(fee);
		feesPage.clickNextButton();		
		emptyLogger(" \n ");
	}
	
	@When("User clicks on complete and print button on fee page")
	public void user_clicks_on_complete_and_print_button_on_fee_page() {
		emptyLogger(" \n ");		
		 feesPage.clickCompleteAndPrintBtn();
		 docuSignPage= feesPage.clickContinueWithPrintOnProcessingTimeModel();
		emptyLogger(" \n ");
	}
	
	@When("User clicks on complete and submit button and click on complete button on client signature button on fee page")
	public void user_clicks_on_complete_and_submit_button_and_click_on_complete_button_on_client_signature_button_on_fee_page() {
		emptyLogger(" \n ");
		feesPage.clickCompleteAndSubmitBtn();
		feesPage.clickCompleteOnClientSignatureModel();
		docuSignPage= feesPage.clickCompleteOnSignerInformationModel();
		emptyLogger(" \n ");
	}
	
	@When("User navigates to fee page and enter require data")
	public void User_navigates_to_fee_page_and_enter_require_data() {	
		emptyLogger(" \n ");	
		feesPage.enterClientFee(clientData.get(Constants.CLIENT_FEE), "Enter flat fee: ", "entering the flat fee ");
		portfolioDetailsPage= feesPage.confirmClientFee("Click on next button ", "navigate to portfolio details page ");
		emptyLogger(" \n ");
	}
	
}	
