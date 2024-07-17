package com.amk.cucumber.steps;

import org.junit.Assert;

import com.amk.cucumber.constants.Constants;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OWBHomeStep  extends GenericStepMethods {
	
	String checkNumber;
	
	@When("User click on {string} tab")
	public void User_clicks_on_check_management_tab(String tab) {
		emptyLogger(" \n ");
		owbHomePage.clickCheckManagement(tab);		
		emptyLogger(" \n ");
	}	
	
	@And("User search B number")
	public void user_search_B_number() {
		emptyLogger(" \n ");
		owbHomePage.searchBNumber(bNumber);		
		emptyLogger(" \n ");
	}
	
	@And("User click on view button")
	public void user_click_view_button() {
		emptyLogger(" \n ");
		owbHomePage.clickViewLink();		
		emptyLogger(" \n ");
	}
	
	@And("User select status and press save button")
	public void user_select_status_and_press_submit_button() {
		emptyLogger(" \n ");
		owbHomePage.selectStatus();	
		owbHomePage.clickSaveButton();
		emptyLogger(" \n ");
	}
	
	@And("User fetch check number")
	public void user_fetch_check_number() {
		emptyLogger(" \n ");
		checkNumber= owbHomePage.fetchCheckNumber();	
		emptyLogger(" \n ");
	}
	
	@And("User click on deposit digital link")
	public void user_click_deposit_digital_link() {
		emptyLogger(" \n ");
		owbHomePage.clickDigitalDepositLink();		
		emptyLogger(" \n ");
	}
	
	@Then("User validate check number")
	public void user_validate_check_number() {
		emptyLogger(" \n ");
		Assert.assertTrue("check number has not been validated", owbHomePage.validateCheckNumber().contains(checkNumber));
		logger.info("check number has been validated");
		customLogger("check number has been validated ", "");
		emptyLogger(" \n ");
	}
	
	@When("User click on start batch button")
	public void user_click_start_batch_button() {
		emptyLogger(" \n ");
		owbHomePage.startBatch(checkNumber);		
		emptyLogger(" \n ");
	}
	
	@When("User perform mark deposit")
	public void user_perform_mark_deposit() {
		emptyLogger(" \n ");
		owbHomePage.clickDeposit();
		owbHomePage.clickMarkDeposit();
		emptyLogger(" \n ");
	}
	
	@Then("User validate check status {string}")
	public void user_validate_status(String stat) {
		emptyLogger(" \n ");
		Assert.assertEquals("status has not been validated", stat, owbHomePage.validateStatus());
		logger.info("status has been validated");
		customLogger("status has been validated ", "");
		emptyLogger(" \n ");
	}
	
	@When("User enter firm details and money in sections")
	public void addNewFirm() {
		emptyLogger(" \n ");
		owbHomePage.clickAddNewFirm();
		firmName= owbHomePage.enterFirmDetails();
		owbHomePage.enterMoneyInDetails();
		owbHomePage.clickSaveButton();
		owbHomePage.enterClearingFirms();
		emptyLogger(" \n ");
	}
	
	@When("User expand tab {string}")
	public void expandTab(String tab) {
		emptyLogger(" \n ");
		owbHomePage.expandTab(tab);		
		emptyLogger(" \n ");
	}
	
	@When("User update submission methods")
	public void submissionMethods() {
		emptyLogger(" \n ");
		owbHomePage.submissionMethod();
		expandTab("Submission");
		emptyLogger(" \n ");
	}
	
	@When("User enter follow up section details")
	public void followupDetails() {
		emptyLogger(" \n ");
		owbHomePage.enterFollowUpDetails();
		expandTab("Follow");
		emptyLogger(" \n ");
	}
	
	@When("User enter money out section details")
	public void moneyOutDetails() {
		emptyLogger(" \n ");
		owbHomePage.enterMoneyOutDetails();
		owbHomePage.clickSaveButton();
		emptyLogger(" \n ");
	}
	
	@When("User search {string} firm and click on {string}")
	public void searchAndUpdate(String value, String option) {
		emptyLogger(" \n ");
		if(value.isEmpty()  |   value.isBlank()) {
			owbHomePage.searchContraFirm(firmName, option);   
		}else {
		owbHomePage.searchContraFirm(value, option);    
		}
		//clientData.get(Constants.ACCOUNT_NUMBER)	
		emptyLogger(" \n ");
	}
	
	@When("User validate clearing firm visibility")
	public void clearingFirmVisibility() {
		emptyLogger(" \n ");		
		owbHomePage.validateClearingFirms();
		emptyLogger(" \n ");
	}
	
	@When("User validate money in submission tab")
	public void validateSubmissionTab() {
		emptyLogger(" \n ");		
		owbHomePage.validateSmubmissionSection();
		emptyLogger(" \n ");
	}	
	
	@When("User validate money in follow up tab")
	public void validateFollowupTab() {
		emptyLogger(" \n ");		
		owbHomePage.validateFollowupTab();
		emptyLogger(" \n ");
	}
	
	@When("User select transfer form instructions of criteria {string}")
	public void selectInstructions(String criteria) {
		emptyLogger(" \n ");		
		transferInstructions= owbHomePage.selectCriteria(criteria);
		emptyLogger(" \n ");
	}
}	
