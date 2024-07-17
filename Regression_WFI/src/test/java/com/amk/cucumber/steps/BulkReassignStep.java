package com.amk.cucumber.steps;

import org.junit.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BulkReassignStep  extends GenericStepMethods {
	
	@When("Enter user {string} in search criteria and click on search")
	public void enterUserAndClickSearchButton(String value) {
		emptyLogger(" \n ");		
		bulkReassignPage.searchCriteria(value);
		emptyLogger(" \n ");
	}	
	
	@Then("Validate search result")
	public void validate_search_result()  {
		emptyLogger(" \n ");		
		Assert.assertTrue("search results are not visible", bulkReassignPage.validateSearchResult());
		logger.info("search results are visible");
		customLogger("search results are visible", "");
		emptyLogger(" \n ");
	}
	
	@When("Click reassign button")
	public void clickOnSearchedResultOption () {
		emptyLogger(" \n ");		
		bNumber= bulkReassignPage.selectRecordAndReassign();	
		emptyLogger(" \n ");
	}
	
	@Then("Select reassignTo information and user as {string}")
	public void select_reassignTo_information_and_user(String value)  {
		emptyLogger(" \n ");		
		bulkReassignPage.reassignToModel(value);
		emptyLogger(" \n ");
	}
	
	@Then("Validate reassigned record to user {string}")
	public void validate_reassigned_result(String text)  {
		emptyLogger(" \n ");			
		bulkReassignPage.searchAssignedRecord(bNumber);	
		Assert.assertTrue("record has not been reassigned", bulkReassignPage.validateReassignedRecord().contains(text));
		logger.info("validate the assigned user name");
		customLogger("validate the assigned user name", "");
		emptyLogger(" \n ");
	}
}	
