package com.amk.cucumber.steps;

import com.amk.cucumber.constants.Constants;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ConstructPortfolioStep  extends GenericStepMethods {
	
	String tms="";
	
	@When("User navigates to Construct portfolio page and enter required information")
	public void User_navigates_to_Construct_portfolio_page_and_enter_require_data() {
		emptyLogger(" \n ");
		clientRegistrationType= clientData.get(Constants.CLIENT_TYPE);
		constructPortfolioPage.deleteExistingRegistration();
		String registrationType = clientData.get(Constants.REGISTRATION_TYPE);
		String custodian = clientData.get(Constants.CUSTODIAN_KEY);
		String investmentAmount = clientData.get(Constants.AMOUNT_KEY);
		String accountType = clientData.get(Constants.CLIENT_ACCOUNT_TYPE);
		String investmentSolution = clientData.get(Constants.INVESTMENT_SOLUTION);	
		tms = clientData.get("TMS");
		if(!clientRegistrationType.toLowerCase().contains("donor advised")) {
		constructPortfolioPage.selectClientRegistrationType(registrationType, "Registration type: ", "Select registration type: " + registrationType);
		}
		constructPortfolioPage.selectClientCustodian(custodian, "Select client custodian", "Select custodian type: " + custodian);
		constructPortfolioPage.insertInvestmentAmount(investmentAmount, "Entering client investment amount","enter invstment amount: " + investmentAmount);
		constructPortfolioPage.selectAccountType(accountType, "Entering client amount type","select account type " + accountType);
		constructPortfolioPage.chooseNewInvestmentFromModal(investmentSolution,"Selecting new investment in modal window", "select new investment: " + investmentSolution);
		emptyLogger(" \n ");
	}
	
	@Then("User clicks on next button on construct portfolio page")
	public void User_clicks_on_next_button_and_validate_fee_page() {
		emptyLogger(" \n ");
		constructPortfolioPage.confirmSingleStrategyInvestment("Confirm advisor managed portfolio Strategy: ","clicking on confirm button ");
		if(tms.equals("Yes")) {
			feesPage= constructPortfolioPage.confirmClientPortfolioTMS("Click on next button ", "navigate to fee page");
		}else {
		feesPage= constructPortfolioPage.confirmClientPortfolio("Click on next button ", "navigate to fee page");
		}
		emptyLogger(" \n ");
	}
	
	@Then("User selects savos investment and click next button on construct portfolio page")
	public void User_select_savos_click_next_button_and_validate_fee_page() {
		emptyLogger(" \n ");
		constructPortfolioPage.chooseSavosInvestment();
		constructPortfolioPage.reviewAndProceed();
		feesPage= constructPortfolioPage.confirmClientPortfolio("Click on next button ", "navigate to fee page");		
		emptyLogger(" \n ");
	}
	
}	
