package com.amk.cucumber.steps;

import io.cucumber.java.en.Then;

public class PortfolioDetailsStep  extends GenericStepMethods {
	
	@Then("User navigates to portfolio details page and click on Account setup button")
	public void Validate_portfolio_details_page_and_proceed_to_Account_setup_page() {
		emptyLogger(" \n ");	
		accountSetupPage=portfolioDetailsPage.goToAccountSetup("Account Setup Button: ", "click on account setup button");		
		emptyLogger(" \n ");
	}
	
}	
