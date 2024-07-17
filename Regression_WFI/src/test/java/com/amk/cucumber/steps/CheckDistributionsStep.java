package com.amk.cucumber.steps;

import org.junit.Assert;

import com.amk.cucumber.constants.Constants;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckDistributionsStep  extends GenericStepMethods {
	
	@When("enter check and allocation details")
	public void enter_one_time_distribution_details()  {
		emptyLogger(" \n ");				
		checkContributionsPage.enterCheckDetails(clientData.get(Constants.AMOUNT_KEY),clientData.get(Constants.FUNDING_METHOD));
		checkContributionsPage.enterAllocationDetails();
		emptyLogger(" \n ");
	}
	
	@Then("Validate added allocation")
	public void Validate_added_allocation() {
		emptyLogger(" \n ");	
		Assert.assertTrue("allocation details has not been added", checkContributionsPage.validateAllocatedDetails()>1);
		customLogger("allocation details has been added ", "");	
		emptyLogger(" \n ");
	}
	
	@When("User click on IWR Complete button")
	public void enter_payee_information()  {
		emptyLogger(" \n ");				
		checkContributionsPage.selectImageTypeAndClickIWRComplete();		
	//	checkContributionsPage.clickSaveCloseButton();		
		emptyLogger(" \n ");
	}
	
	@When("User click on qc passed button")
	public void click_on_qc_passed_button()  {
		emptyLogger(" \n ");				
		checkContributionsPage.clickQCPassed();			
		emptyLogger(" \n ");
	}
	
}	
