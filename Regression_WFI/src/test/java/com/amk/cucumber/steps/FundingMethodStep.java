package com.amk.cucumber.steps;

import org.junit.Assert;
import org.openqa.selenium.By;

import com.amk.cucumber.constants.Constants;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FundingMethodStep  extends GenericStepMethods {
	
	@When("User navigates to funding tab and enter funding method")
	public void User_navigates_to_funding_page_and_enter_require_data() {	
		emptyLogger(" \n ");			
		if(clientData.get(Constants.CUSTODIAN_KEY).toLowerCase().contains("pershing")     ||    clientData.get(Constants.CUSTODIAN_KEY).toLowerCase().contains("fidelity")   
				||    clientData.get(Constants.CUSTODIAN_KEY).toLowerCase().contains("Schwab")) {
			fundingMethodPage.selectFundingMethod(clientData.get(Constants.FUNDING_METHOD));
		}else {
		fundingMethodPage.selectFundingMethod(clientData.get(Constants.FUNDING_METHOD) , "Select funding method: ", "enter the check amount info");		
		}
		emptyLogger(" \n ");
	}
	
	@Then("User click on online access document delivery button")
	public void User_click_on_Online_Access_Document_Delivery_button_and_validate_the_page() {
		emptyLogger(" \n ");	
		fundingMethodPage.goToOnlineAccessDocumentDelivery("Online Access & Document Delivery button: ", "click on Online Access & Document Delivery button on Funding tab");		
		emptyLogger(" \n ");
	}
	
	@Then("Validate created contra firm on funding page")
	public void validateContrafirm() {
		emptyLogger(" \n ");	
		fundingMethodPage.addinformation(firmName);		
		Assert.assertEquals("created firm name is not present on funding page", seleniumCore.getText(By.cssSelector("#typeAheadSelectedDeliveryFirmName")),firmName);
		emptyLogger(" \n ");
	}
	
	@When("User enters all transfer information on funding page")
	public void transferInfo() {
		emptyLogger(" \n ");	
		fundingMethodPage.enterTransferInfo();			
		emptyLogger(" \n ");
	}
	
}	
