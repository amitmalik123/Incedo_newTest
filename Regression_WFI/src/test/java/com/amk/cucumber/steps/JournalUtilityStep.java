package com.amk.cucumber.steps;

import com.amk.cucumber.constants.Constants;

import io.cucumber.java.en.When;

public class JournalUtilityStep  extends GenericStepMethods {
	
	@When("User add a journal")
	public void user_add_a_journal()  {
		emptyLogger(" \n ");		
		journalUtilityPage.selectDestinationAccount();
		journalUtilityPage.selectUnit(clientData.get(Constants.AMOUNT_KEY));
		journalUtilityPage.clickAddJournalButton();
		emptyLogger(" \n ");
	}
	
	@When("Validate Added Journal")
	public void validate_added_journal()  {
		emptyLogger(" \n ");		
		journalUtilityPage.validateAddedJournal();
		emptyLogger(" \n ");
	}
	
}	
