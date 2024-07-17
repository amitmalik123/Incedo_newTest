package com.amk.cucumber.steps;

import com.amk.cucumber.constants.Constants;

import io.cucumber.java.en.When;

public class AccountListStep extends GenericStepMethods{

	
	@When("User is on the accountlist tab and search with the accountNo")
	public void user_is_on_the_accountlist_tab_and_search_with_account_no() {
		emptyLogger(" \n ");
		accountListPage.enterNameInTableSearchBox(clientData.get(Constants.ACCOUNT_NUMBER));
		accountListPage.clickGo(accountListPage);
		emptyLogger(" \n ");
	}
	
	@When("User should click on searched account and navigate to account wizard page")
	public void user_should_click_on_searched_account_and_navigate_to_account_wizard_page() {
		emptyLogger(" \n ");
		holdingsSummaryPage  = accountListPage.clickOnSearchedAccount(clientData.get(Constants.ACCOUNT_NUMBER));
		accountWizardPage  = holdingsSummaryPage.clickAccountWizardTab();
		emptyLogger(" \n ");
	}
}
