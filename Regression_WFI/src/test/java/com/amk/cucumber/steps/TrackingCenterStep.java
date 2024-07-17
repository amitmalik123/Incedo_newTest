package com.amk.cucumber.steps;

import org.junit.Assert;

import com.amk.cucumber.pages.ItemDetailsPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TrackingCenterStep  extends GenericStepMethods {
	
	@When("User recall the item")
	public void User_navigate_to_item_number() {
		emptyLogger(" \n ");
		String [] lastname= fullname.replaceAll("\\s", "").split(",");
		trackingCenterPage.clickBrokerDealerTab();
		trackingCenterPage.searchForItemNumber("No", lastname[1]);		
		trackingCenterPage.clickRecallButton();
		emptyLogger(" \n ");
	}	
	
	@Then("User validate the recalled message {string}")
	public void User_validate_paperwork_recalled(String message) {
		emptyLogger(" \n ");
		String text= trackingCenterPage.validateRecallText();
		Assert.assertTrue("paperwork has not been recalled", text.contains(message));
		customLogger("record has been recalled ", "");
		seleniumCore.waitForUILoading(5000);
		emptyLogger(" \n ");
	}
	
	@When("User submit the request after recall or reject")
	public void User_submit_request_after_recall() {
		emptyLogger(" \n ");				
		trackingCenterPage.clickTrackingCenterTab();
		itemDetailsPage= (ItemDetailsPage) trackingCenterPage.searchForItemNumber("YES", fullname.trim());
		itemDetailsPage.clickSubmitButton();
		submitPage.clickSubmitBtn("Click on Submit button", "submit button");		
		emptyLogger(" \n ");
	}
	
	@When("User submit the request again after reject")
	public void User_submit_request_again_after_recall() {
		emptyLogger(" \n ");	
		itemDetailsPage= (ItemDetailsPage) trackingCenterPage.searchForItemNumber("YES", fullname.trim());
		submitPage= itemDetailsPage.clickSubmitButton("Click on Submit button");
		submitPage.clickSubmitBtn("Click on Submit button", "submit button");		
		emptyLogger(" \n ");
	}
	
	@When("User search item number")
	public void User_search_item_number() {
		emptyLogger(" \n ");						
		itemDetailsPage= (ItemDetailsPage) trackingCenterPage.searchForItemNumber("YES", fullname.trim());		
		customLogger("searched for item number and navigate to item details page ", "");
		emptyLogger(" \n ");
	}
	
	@When("User search item by b number")
	public void User_search_item() {
		emptyLogger(" \n ");						
		itemDetailsPage= trackingCenterPage.searchForItemNumber(bNumber);		
		customLogger("searched for item number and navigate to item details page ", "");
		emptyLogger(" \n ");
	}
	
}	
