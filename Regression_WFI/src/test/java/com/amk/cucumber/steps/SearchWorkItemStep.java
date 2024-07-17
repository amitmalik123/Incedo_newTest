package com.amk.cucumber.steps;

import org.junit.Assert;

import com.amk.cucumber.constants.Constants;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchWorkItemStep  extends GenericStepMethods {
	
	@When("Enter account number and click on search button")
	public void enterAccountNumberAndClickSearchButton() {
		emptyLogger(" \n ");		
		searchWorkItemPage.enterAccountNumberAndClickSearch(clientData.get(Constants.ACCOUNT_NUMBER));		
		emptyLogger(" \n ");
	}	
	
	@When("Click on {string} link")
	public void clickOnSearchedResultOption (String option) {
		emptyLogger(" \n ");		
		searchWorkItemPage.clickDetailsLink(option);		
		emptyLogger(" \n ");
	}
	
	@Then("Enter external id and click on search button")
	public void enter_external_id_and_click_on_search_button()  {
		emptyLogger(" \n ");		
		if(bNumber==null) {
		searchWorkItemPage.enterExternalIdAndClickSearch(bTrackingId);	
		}else {
			searchWorkItemPage.enterExternalIdAndClickSearch(bNumber);		
		}
		emptyLogger(" \n ");
	}
	
	@Then("Validate searched result {string} for {string}")
	public void validate_searched_result_data(String parameterToValidate, String value)  {
		emptyLogger(" \n ");				
		searchWorkItemPage.validateSearchedResultData(parameterToValidate, value );		
		emptyLogger(" \n ");
	}
	
	@When("Validate time stamp in sorted order")
	public void validate_time_stamp_in_sorted_order()  {
		emptyLogger(" \n ");
		searchWorkItemPage.ValidateStartDateOrder();
		emptyLogger(" \n ");
	}
	
	@When("Fetch parent b number")
	public void fetch_parent_bNumber() {
		emptyLogger(" \n ");
		parentBNumber= searchWorkItemPage.fetchParentBNumber();
		emptyLogger(" \n ");
	}
	
	@Then("Validate {string} trackpoint")
	public void validate_withdrawal_trackpoint(String option)  {
		emptyLogger(" \n ");	
		Assert.assertTrue(option+" trackpoint is not prsent", searchWorkItemPage.fetchWorkItemText().toLowerCase().contains(option.toLowerCase()));		
		emptyLogger(" \n ");
	}
	
}	
