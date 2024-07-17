package com.amk.cucumber.steps;

import org.junit.Assert;

import com.amk.cucumber.constants.Constants;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class InvestmentChangeStep  extends GenericStepMethods {
	
	private static String sourceInvestmentSolution;
	
	@When("Click on account number and navigate to investment selection tab")
	public void Click_on_Account_Number_Navigate_Investment_Selection_Tab()  {
		emptyLogger(" \n ");
		String tabName = investmentChangePage.validateSecondaryTab();
		if(tabName.contains("Source Account".toLowerCase())) {	
		investmentChangePage.selectSourceAccount(clientData.get(Constants.ACCOUNT_NUMBER));
		investmentChangePage.clickNextBtn();	
		}
		emptyLogger(" \n ");
	}
	
	@When("Select {string} source account and navigate to investment selection tab")
	public void Select_on_Account_Number_Navigate_Investment_Selection_Tab(String type)  {
		emptyLogger(" \n ");
		String tabName = investmentChangePage.validateSecondaryTab();
		if(tabName.contains("Source Account".toLowerCase())) {	
		investmentChangePage.selectMultipleSourceAccount(clientData.get(Constants.ACCOUNT_NUMBER));
		investmentChangePage.selectMultipleSourceAccount(clientData.get(Constants.ACCOUNT_NUMBER2));
		investmentChangePage.clickNextBtn();	
		}
		emptyLogger(" \n ");
	}
	
	@Then("Validate Account Number On Destination Investment Tab")
	public void Validate_Account_Number_On_Destination_Investment_Tab()  {
		emptyLogger(" \n ");
		sourceInvestmentSolution= investmentChangePage.fetchedSourceModal(clientData.get(Constants.ACCOUNT_NUMBER));
		customLogger("account number has been verified","");
		emptyLogger(" \n ");
	}
	
	@When("Select new investment on destination investment tab")
	public void Select_new_investment_on_destination_investment_tab()  {
		emptyLogger(" \n ");
		investmentChangePage.selectNewInvestmentDestinationInvestment(clientData.get(Constants.INVESTMENT_NAME));
		emptyLogger(" \n ");
	}
	
	@When("Select existing investment with {string} account on destination investment tab")
	public void Select_second_account_on_destination_investment_tab(String count)  {
		emptyLogger(" \n ");
		switch(count){
		case "one":
			investmentChangePage.selectExistingInvestmentDestinationInvestment(clientData.get(Constants.ACCOUNT_NUMBER));
			break;
		case "multiple":
			investmentChangePage.selectExistingInvestmentDestinationInvestment(clientData.get(Constants.ACCOUNT_NUMBER3));
			investmentChangePage.selectExistingInvestmentDestinationInvestment(clientData.get(Constants.ACCOUNT_NUMBER4));
			break;	
		default:
			logger.info("existing account has selected");
		}
		
		emptyLogger(" \n ");
	}
	
	@Then("Validate New Investment Modal")
	public void Validate_New_investment_Modal()  {
		emptyLogger(" \n ");
		Assert.assertTrue("new investment model does not match ",investmentChangePage.isChooseNewInvestmentModalVisible());
		customLogger("new investment pop-up is displaying","");
		emptyLogger(" \n ");
	}
	
	@When("Select Solution Type")
	public void Select_solution_type()  {
		emptyLogger(" \n ");
		investmentChangePage.selectSolutionType(clientData.get(Constants.Program_ID));
		emptyLogger(" \n ");
	}
	
	@When("User select all remaining investment checkbox")	
	public void Select_all_remaining_investment()  {	
		emptyLogger(" \n ");	
		investmentChangePage.checkAllRemaining();	
		emptyLogger(" \n ");	
	}
	
	@When("Search and Select Investment Solution on destination investment tab {int}")
	public void Search_and_select_investment_on_destination_investment_tab1(Integer count)  {
		emptyLogger(" \n ");		
		switch(count) {
		case 1:
			String investmentSoluton1= clientData.get(Constants.INVESTMENT_SOLUTION_NAME1);
			investmentChangePage.searchInvestmentSolution(investmentSoluton1);
			investmentChangePage.searchAndSelectInvestmentSolution(investmentSoluton1);
			break;
		case 2:
			String investmentSoluton2= clientData.get(Constants.INVESTMENT_SOLUTION_NAME2);
			investmentChangePage.searchInvestmentSolution(investmentSoluton2);
			investmentChangePage.searchAndSelectInvestmentSolution(investmentSoluton2);
			break;
		default:
			logger.info("Investment soluiton has been selected");
		}		
		emptyLogger(" \n ");
	}
	
	@When("Select Investment Solution on destination investment tab")
	public void select_investment_on_destination_investment_tab1() {
		emptyLogger(" \n ");
		investmentChangePage.selectNewInvestment(sourceInvestmentSolution);
		logger.info("new investment soluiton has been selected");
		emptyLogger(" \n ");
	}

	@Then("Validate New Selected Investment Name")
	public void Validate_New_selected_investment_name()  {
		emptyLogger(" \n ");
		String investmentSoluton1= clientData.get(Constants.INVESTMENT_SOLUTION_NAME1);
		Assert.assertEquals("mismatch in selected investment name", investmentSoluton1, investmentChangePage.validateSelectedInvestmentName());		
		emptyLogger(" \n ");
	}
	
	@When("Select {string} amount in destination investment tab")
	public void Select_amount_in_destination_investment_tab(String option)  {
		emptyLogger(" \n ");
		switch(option) {
		case "partial":
			investmentChangePage.enterPartialAmount(clientData.get(Constants.AMOUNT_KEY));
			break;
		case "100 percentage":
			investmentChangePage.click100Percentage();
			break;	
		default:
			logger.info("detination investment has been selected ");
		}				
		emptyLogger(" \n ");
	}
	
	@When("Click on next button")
	public void clickNextButton()  {		
		investmentChangePage.clickNextBtn();		
	}
	
	@Then("Validate {string} tab and navigate to account features tab")
	public void Validate_suitability_tab_and_navigate_to_fees_tab(String value)  {
		emptyLogger(" \n ");
		String tabName = investmentChangePage.validateSecondaryTab();
		if(tabName.contains(value.toLowerCase())) {				
		investmentChangePage.selectClientRiskTolerance(clientData.get(Constants.SUITABILITY_CLIENT_RISK_TOLERANCE));
		investmentChangePage.selectClientInvestmentHorizon(clientData.get(Constants.SUITABILITY_CLIENT_ISVESTMENT_HORIZON));
		investmentChangePage.selectClientTotalNetWorth(clientData.get(Constants.SUITABILITY_CLIENT_NET_WORTH));
		clickNextButton();
		}else {
		logger.info("user does not go inside "+ value +" tab");
		customLogger("user does not go inside ", value +" tab");
		}
		emptyLogger(" \n ");
	}
	
	@When("Select assign new account number")
	public void selectAccountNumber()  {	
		seleniumCore.clickRadioButton(investmentChangePage.newAccountNumber, "select assign new account number", "");
		customLogger("select assign new account number","");		
	}
	
	@When("User clicks destination account with {string} option") 
	public void chooseAccountTypeOption(String type)  {	
		String tabName = investmentChangePage.validateSecondaryTab();
		if(tabName.equalsIgnoreCase("Account Number")) {
		if(type.equalsIgnoreCase("new")) {
			seleniumCore.clickRadioButton(investmentChangePage.assignNewAccount, "retain a new account number is selected", "");
			logger.info("assign a new account number is selected");
		}else {
			seleniumCore.clickRadioButton(investmentChangePage.retainCheckbox, "retain a new account number is selected", "");
			customLogger("retain a new account number is selected","");
			logger.info("retain a new account number is selected");
		}			
		}
	}
	
	@Then("Validate the {string} tab")
	public void validate_the_current_tab(String currentTab) {
		emptyLogger(" \n ");
		String tabName = investmentChangePage.validateSecondaryTab();
		if(tabName.contains(currentTab.toLowerCase())) {
			logger.info("user is navigating to "+ currentTab +" tab");
			customLogger("user is navigating to "+ currentTab +" tab", "");			
		if(tabName.equalsIgnoreCase("Account Features")   &&  seleniumCore.isElementVisible(investmentChangePage.beneficalOwnerLink,2,1) ) {
			seleniumCore.clickRadioButton(investmentChangePage.beneficalOwner, "click benefical owner option", "");
			clickNextButton();
			clickNextButton();
		}
		clickNextButton();		
		}else {
			logger.info("user does not go inside "+ currentTab +" tab");
			customLogger("user does not go inside ", currentTab +" tab");	
		}
		emptyLogger(" \n "); 
	}
	
	@When("User fetch account number from retain account number section")
	public void fetchAccountNumber() {
		emptyLogger(" \n ");
		retainAccountNumber = investmentChangePage.fetchAccountNumber();	
		emptyLogger(" \n ");
	}
	
	@Then("User enter savos investment information {string} transition on investment change page")
	public void User_select_savos_click_next_button_and_validate_fee_page(String option) {
		emptyLogger(" \n ");
		investmentChangePage.chooseSavosInvestment();
		investmentChangePage.reviewAndProceed(option);			
		emptyLogger(" \n ");
	}
	
	@Then("User validate partial label visibility")
	public void partialLabelVisibility() {
		emptyLogger(" \n ");
		Assert.assertTrue("partial label is visible", investmentChangePage.hiddenPartialLabel());					
		emptyLogger(" \n ");
	}
	
	@Then("User validate new account number option visibility")
	public void newAccountNumberVisibility() {
		emptyLogger(" \n ");
		Assert.assertTrue("new account number option is visible", investmentChangePage.hiddenNewAccountNumberOption());	
		logger.info("assign new account number option is not visible");
		customLogger("assign new account number option is not visible", "");		
		emptyLogger(" \n ");
	}
	
	@Then("User validate custom allocation button")
	public void customAllocation() {
		emptyLogger(" \n ");
		seleniumCore.scrollIntoView(seleniumCore.findElement(investmentChangePage.customAllocation));
		Assert.assertTrue("custom allocation button is not visible", seleniumCore.isElementVisible(investmentChangePage.customAllocation));	
		logger.info("custom allocation button is present");
		customLogger("custom allocation button is present", "");
		emptyLogger(" \n ");
	}
}	
