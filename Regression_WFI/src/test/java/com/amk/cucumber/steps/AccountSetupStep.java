package com.amk.cucumber.steps;

import com.amk.cucumber.constants.Constants;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AccountSetupStep  extends GenericStepMethods {
	
	@When("User navigates to account holder tab and enter require information")
	public void User_navigates_to_account_setup_page_and_enter_require_data() {	
		emptyLogger(" \n ");	
//		clientRegistrationType= clientData.get(Constants.CLIENT_TYPE);
		accountSetupPage.clickAddNewAccount(clientRegistrationType, "click Account Holder button: ");
		accountSetupPage.addAccount(clientData.get(Constants.ACCOUNTHOLDER_FIRST_NAME), clientData.get(Constants.ACCOUNTHOLDER_MIDDLE_NAME), clientData.get(Constants.ACCOUNTHOLDER_LAST_NAME), 
				clientData.get(Constants.ACCOUNTHOLDER_BIRTH_DATE), clientData.get(Constants.ACCOUNTHOLDER_SSN), "Add Account Holder info: ", "enter account holder info session");
		accountSetupPage.addPhoneAndEmail(clientData.get(Constants.ACCOUNTHOLDER_PHONE), clientData.get(Constants.ACCOUNTHOLDER_EMAIL));
		accountSetupPage.addAccountHomeAddress(clientData.get(Constants.ACCOUNTHOLDER_ADDRESSLINE1), clientData.get(Constants.ACCOUNTHOLDER_CITY), clientData.get(Constants.ACCOUNTHOLDER_STATE),
				clientData.get(Constants.ACCOUNTHOLDER_ZIP), "Address info: ", "enter address details on address modal");	
	//	if(!clientRegistrationType.toLowerCase().contains("donor advised")) {
		accountSetupPage.addCustodianInfo(clientData.get(Constants.CUSTODIAN_KEY));		
		accountSetupPage.saveAccount("Save button: ", "click on account holder save button");		
		emptyLogger(" \n ");
	}
	
	@When("Navigate to Account information page and enter ssn info")
	public void Navigate_to_Account_information_page_and_enter_ssn_info() {
		emptyLogger(" \n ");		
		accountSetupPage.addSSNTaxReporting(clientData.get(Constants.ACCOUNTHOLDER_SSN));		
		emptyLogger(" \n ");
	}
	
	@When("Navigate to Account information page and select existing client")
	public void Navigate_to_Account_information_page_and_select_existing_clent() {
		emptyLogger(" \n ");		
		accountSetupPage.clickExistingAccount();	
		emptyLogger(" \n ");
	}
	
	@Then("User clicks on account information button")
	public void Navigate_to_Account_information_page_and_validate_same_page() {
		emptyLogger(" \n ");
		accountSetupPage.goToInformationPage("Account information button: ", "click on account information button");		
		emptyLogger(" \n ");
	}
	
	@When("User navigates to online access document delivery tab and click on review all accounts button")
	public void User_enter_require_data_on_review_all_accounts_page_and_click_on_review_accounts_button() {
		emptyLogger(" \n ");			
		reviewAllAccountsPage=accountSetupPage.reviewAllAccounts("Review all accounts button: ", "click on review all accounts button");		
		emptyLogger(" \n ");
	}
	
	@When("User is on the accountWizard tab and Search and open a client")
	public void user_is_on_the_accuntWizard_tab_and_search_with_client_name() {
		emptyLogger(" \n ");		
		accountWizardPage.findClient(clientData.get(Constants.CLIENT_NAME), "find client and clicked on go button");
		 accountWizardPage.selectSearchedClient();
		emptyLogger(" \n ");
	}
	
	@Then("User navigate to Account information tab and click on account feature button")
	public void Navigate_to_Account_features_page_and_validate_same_page() {
		emptyLogger(" \n ");
		accountSetupPage.accountAdditionalInfo(clientData.get(Constants.CUSTODIAN_KEY));
		accountSetupPage.goToAccountFeaturesPage("Account features button: ", "click on account features button");
		emptyLogger(" \n ");
	}
	
	@Then("User navigate to Account information tab and click on tax management services button")
	public void Navigate_to_Account_features_page_and_clickTaxManagement() {
		emptyLogger(" \n ");	
		accountSetupPage.clickTMSButton();		
		emptyLogger(" \n ");
	}
	
	@Then("User navigate to Account features tab and click on funding method button")
	public void User_click_on_next_button_and_validate_the_Funding_page() {
		emptyLogger(" \n ");		
		fundingMethodPage = accountSetupPage.goToFundingMethodPage("Funding Method button: ", "click on Funding Method button");
		emptyLogger(" \n ");
	}
	
	@Then("User navigate through beneficiaries tabs")
	public void Navigate_to_through_beneficiaries_page() {
		emptyLogger(" \n ");
		accountSetupPage.beneficiaries("click on primary beneficiaries button");	
		accountSetupPage.beneficiaries("click on contingent beneficiaries button");
		emptyLogger(" \n ");
	}
	
	@Then("User navigate to donor succession plan and enter required info")
	public void donorSuccessionPlan() {
		emptyLogger(" \n ");
		accountSetupPage.donorSuccessionPlan();
		accountSetupPage.givingFundInfo();
		emptyLogger(" \n ");
	}
	
}	
