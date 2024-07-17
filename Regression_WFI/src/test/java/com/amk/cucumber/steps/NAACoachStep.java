package com.amk.cucumber.steps;

import org.junit.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NAACoachStep  extends GenericStepMethods {
	
	@Then("User validates N number adopted under parent")
	public void user_validates_N_number_adopted_under_parent() {
		emptyLogger(" \n ");	
		naaCoachPage.validateNNumber();		
		emptyLogger(" \n ");
	}	
	
	@When("User select CIP value {string} and save client")
	public void user_select_CIP_value_and_save_client(String value) {
		emptyLogger(" \n ");	
		naaCoachPage.selectCIPAndSaveClient(value);		
		emptyLogger(" \n ");
	}
	
	@When("User clicks on {string} b number open button")
	public void user_clicks_on_b_number_open_button(String workType) {
		emptyLogger(" \n ");	
		naaCoachPage.clickOpenButton(workType);		
		emptyLogger(" \n ");
	}
	
	@When("User does the activate account")
	public void user_clicks_on_activate_account_button() {
		emptyLogger(" \n ");	
		userExpandRegistrationSection();	
		naaCoachPage.activateAccounts();	
		emptyLogger(" \n ");
	}
	
	@When("User expand registration section")
	public void userExpandRegistrationSection() {
		emptyLogger(" \n ");	
		naaCoachPage.expandActivationSection();			
		emptyLogger(" \n ");
	}
	
	@When("User add new feature")
	public void user_add_new_feature() {
		emptyLogger(" \n ");	
		naaCoachPage.clickEditAppDataButton();	
		naaCoachPage.addNewFeature();	
		emptyLogger(" \n ");
	}
	
	@Then("Validate model in investment section is non editable")
	public void user_investment_section_uneditable() {
		emptyLogger(" \n ");	
		naaCoachPage.clickEditAppDataButton();	
		naaCoachPage.validateInvestmentSection();	
		emptyLogger(" \n ");
	}
	
	@Then("User validate added feature")
	public void user_validate_added_feature() {
		emptyLogger(" \n ");	
		Assert.assertTrue("added feature is not displaying", naaCoachPage.validateNewAddedFeature().contains("power of attorney"));
		customLogger("new feature has been added", "");		
		emptyLogger(" \n ");
	}
	
	@Then("User validate {string} alert message")
	public void user_validate_alert_message(String message) {
		emptyLogger(" \n ");	
		Assert.assertTrue("application is not approved by BD", naaCoachPage.validateApprovedAlert());
		customLogger("validate message: ", message);		
		emptyLogger(" \n ");
	}
	
	@Then("User validate {string} letter display under acc and beta")
	public void user_validate_letter_display_under_acc_and_beta(String message) {
		emptyLogger(" \n ");	
		naaCoachPage.validateAccAndBeta(message);
		if(message.equalsIgnoreCase("P")) {
			customLogger("P letter has been validated ", "");
		}else {
			customLogger("A letter has been validated ", "");
		}				
		emptyLogger(" \n ");
	}
	
	@Then("User validate {string} letter display under acc")
	public void user_validate_letter_display_under_acc(String message) {
		emptyLogger(" \n ");	
		naaCoachPage.validateAccStatus(message);
		if(message.equalsIgnoreCase("P")) {
			customLogger("P letter has been validated ", "");
		}else {
			customLogger("A letter has been validated ", "");
		}				
		emptyLogger(" \n ");
	}
	
	@Then("Validate added account number and name")
	public void validate_added_account_number_and_name() {
		emptyLogger(" \n ");	
		naaCoachPage.validateAccountNumberAndName(addAccountInfo);			
		emptyLogger(" \n ");
	}
	
	@When("User add new work item {string}")
	public void user_add_new_work_item(String workItem) {
		emptyLogger(" \n ");	
		naaCoachPage.addWorkItem(workItem);	
		naaCoachPage.clickSaveAndRefresh();
		emptyLogger(" \n ");
	}
	
	@When("User click on save and refresh button")
	public void user_click_on_save_and_refresh_button() {
		emptyLogger(" \n ");	
		naaCoachPage.clickSaveAndRefresh();		
		emptyLogger(" \n ");
	}
	
	@When("User click on save and exit button")
	public void user_click_on_save_and_exit_button() {
		emptyLogger(" \n ");	
		naaCoachPage.clickSaveAndExit();		
		emptyLogger(" \n ");
	}
	
	@When("User clicks on save and exit button")
	public void user_clicks_on_save_and_exit_button() {
		emptyLogger(" \n ");			
		bawDashboardPage.switchTab("NAA Coach");
		naaCoachPage.clickSaveAndExit();
		bawDashboardPage.switchTab("Process Portal");
		emptyLogger(" \n ");
	}
	
	@Then("Validate new created work item {string} and open the work item and switch to {string} page")
	public void validate_added_account_number_and_name(String workItem, String page) {
		emptyLogger(" \n ");	
		naaCoachPage.validateAndOpenNewAddedWorkItem(workItem, page);			
		emptyLogger(" \n ");
	}
	
	@Then("Validate updated work item to {string}")
	public void validateUpdatedWI(String value) {
		emptyLogger(" \n ");	
		Assert.assertTrue("work item has not been updated", value.contains(naaCoachPage.headerWorkItem()));
		customLogger("work item has been updated ", "");
		logger.info("work item has been updated");
		emptyLogger(" \n ");
	}
	
}	
