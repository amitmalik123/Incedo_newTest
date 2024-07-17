package com.amk.cucumber.steps;

import org.junit.Assert;

import com.amk.cucumber.constants.Constants;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AccountUpdateUtilityStep extends GenericStepMethods {

	@When("User search with accountNo")
	public void user_is_on_the_accountlist_tab_and_search_with_account_no() {
		emptyLogger(" \n ");
		accountUpdateUtilityPage.enterAccountNumber(clientData.get(Constants.ACCOUNT_NUMBER));
		emptyLogger(" \n ");
	}

	@When("User {string} tax management section")
	public void taxManagementSection(String option) {
		emptyLogger(" \n ");
		accountUpdateUtilityPage.taxManagementSegment(taxManagementId, option);
		emptyLogger(" \n ");
	}

	@Then("Validate {string} confirmation message")
	public void validateActivationMessage(String message) {
		emptyLogger(" \n ");
		Assert.assertTrue("", accountUpdateUtilityPage.validateAlert().contains(message));
		logger.info("confirmation message is: " + message);
		customLogger("confirmation message is: ", message);
		emptyLogger(" \n ");
	}

	@Then("enter and validate funding account number")
	public void userValidateFundingNumber() {
		emptyLogger(" \n ");
		accountUpdateUtilityPage.enterFundingAccountNuber("78687687");
		emptyLogger(" \n ");
	}

}
