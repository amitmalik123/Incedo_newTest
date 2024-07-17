package com.amk.cucumber.steps;

import org.junit.Assert;

import com.amk.cucumber.constants.Constants;
import com.amk.cucumber.pages.JournalUtilityPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateOAStep  extends GenericStepMethods {
	
	@When("Select managed acct")
	public void select_managed_acct() {
		emptyLogger(" \n ");		
		createOAPage.selectManagedAcct(clientData.get(Constants.ACCOUNT_NUMBER));		
		emptyLogger(" \n ");
	}
	
	@When("^Select action type \"(.*)\"$")
	public void select_action_type(String actionType) {
		emptyLogger(" \n ");	
		if(actionType.equals("Journal")) {
		createOaWindow = seleniumCore.getDriver().getWindowHandle();	
		journalUtilityPage= (JournalUtilityPage) createOAPage.selectActionType(actionType);	
		}else
			createOAPage.selectActionType(actionType);	
		emptyLogger(" \n ");
	}
	
	@When("^enter action value \"(.*)\"$")
	public void enter_action(String action) {
		emptyLogger(" \n ");	
		createOAPage.enterActioTextBox(action);
		createOAPage.clickAddUpdateButton();
		emptyLogger(" \n ");	
	}
	
	@When("select account type as {string}, straegist id as {string} & model code {string}")
	public void select_values_on_select_model(String accountType, String strategistId, String modelCode) {
		emptyLogger(" \n ");	
		createOAPage.clickSelectLink();
		createOAPage.selectModelValues( accountType,  strategistId,  modelCode);
		createOAPage.clickSaveCloseSelectModelButton();
		createOAPage.clickAddUpdateButton();
		emptyLogger(" \n ");	
	}
	
	@When("click on Update OA button on create OA page")
	public void click_Update_OA_button_on_Create_OA_page() {
		emptyLogger(" \n ");
		createOAPage.clickAddUpdateButton();
		emptyLogger(" \n ");
	}
	
	@Then("^Validate added OA details on create OA page \"(.*)\"$")
	public void validate_added_OA_details_on_create_OA_page(String value) {
		emptyLogger(" \n ");		
		Assert.assertTrue("added OA has not been verified ",createOAPage.validateAddedOA().contains(value));
		emptyLogger(" \n ");
	}
	
	@When("Click on save and close button on {string} page")
	public void click_on_save_and_close_button(String page) {
		emptyLogger(" \n ");
		switch (page) {
		case "createOAPage":
			createOAPage.clickSaveCloseButton();
			break;
		case "journalUtilityPage":
			journalUtilityPage.clickSaveCloseButton(createOaWindow);
			break;
		default:
			logger.info("clicked on save and close");
		}
		emptyLogger(" \n ");
	}
	
	@When("^Edit the OA record \"(.*)\"$")
	public void edit_the_OA_record(String action) {
		emptyLogger(" \n ");
		createOAPage.clickEditLink();
		createOAPage.enterActioTextBox(action);
		createOAPage.clickSaveChangesButton();
		emptyLogger(" \n ");
	}
	
	@When("Cancel the OA record")
	public void cancel_the_OA_record() {
		emptyLogger(" \n ");		
		createOAPage.clickCancelLink();		
		emptyLogger(" \n ");
	}
	
	@When("Delete the OA record")
	public void delete_the_OA_record() {
		emptyLogger(" \n ");		
		createOAPage.clickDeleteLink();
		createOAPage.validateaddedOAIsDeleted();
		emptyLogger(" \n ");
	}
	
	@When("{string} added journal")
	public void edit_added_journal(String option) {
		emptyLogger(" \n ");		
		/*
		 * seleniumCore.getDriver().switchTo().window(createOaWindow);
		 * logger.info(seleniumCore.getDriver().getTitle());
		 * seleniumCore.handleAlert("OK");
		 */
		switch(option) {
		case "Edit":
			createOAPage.clickEditLink();
			break;
		case "Cancel":	
			createOAPage.clickCancelLink();
			break;
		default:
			logger.info("edit or cancel the journal");
		}		
		emptyLogger(" \n ");
	}
	
	 @Then("Validate party element is present and highlight with color {string} on Create OA page")
		public void validate_party_element_present_highlighted(String color)  {
			emptyLogger(" \n ");		
			createOAPage.validatePartyManager(color);		
			emptyLogger(" \n ");
		}
	
	 @When("User manage to select account results {string} msg")
		public void accountSelection(String errorType) {
			emptyLogger(" \n ");				
			createOAPage.manageAccount(clientData.get(Constants.ACCOUNT_NUMBER), errorType);
			emptyLogger(" \n ");
		}
}	
