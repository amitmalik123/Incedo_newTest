package com.amk.cucumber.steps;

import com.amk.cucumber.constants.Constants;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ClientProfileStep  extends GenericStepMethods {
	
	@When("User navigates to client profile page and enter required information")
	public void User_navigates_to_Client_Profile_page_and_enter_require_data() {	
		emptyLogger(" \n ");		
		clientRegistrationType= clientData.get(Constants.CLIENT_TYPE);
		clientProfilePage.selectClientType(clientRegistrationType, "Client type: ");
		fullname=clientProfilePage.fillFullClientName(clientRegistrationType,"Client Name: ", clientRegistrationType);		
		clientProfilePage.selectFiduciaryRole(clientData.get(Constants.FIDUCIARY_ROLE), "Fiduciary Role: ", "select fiduciary role");
		if(!clientRegistrationType.toLowerCase().contains("donor")) {
		clientProfilePage.selectClientRiskTolerance(clientRegistrationType,clientData.get(Constants.RISK_TOLERANCE), "select risk tolerance: ");
		clientProfilePage.selectClientInvestmentHorizon(clientData.get(Constants.INVESTMENT_HORIZON), "select investment horizon: ");
		clientProfilePage.selectClientTotalNetWorth(clientData.get(Constants.TOTAL_NET_WORTH),"select total net worth: ");
		}
		clientProfilePage.selectClientRiskProfile(clientData.get(Constants.RISK_RETURN_PROFILE), "select risk return profile: ");
		emptyLogger(" \n ");
	}
	
	@Then("User clicks on next button on client profile page")
	public void User_clicks_on_next_button_and_validate_Construct_portfolio_page() {
		emptyLogger(" \n ");
		constructPortfolioPage= clientProfilePage.confirmClient("Click on next button ", "navigate to construct portfolio page");		
		emptyLogger(" \n ");
	}
	
}	
