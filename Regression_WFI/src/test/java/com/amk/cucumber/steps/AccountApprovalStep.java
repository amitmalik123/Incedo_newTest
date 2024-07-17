package com.amk.cucumber.steps;

import org.junit.Assert;

import io.cucumber.java.en.Then;

public class AccountApprovalStep  extends GenericStepMethods {
	
	@Then("User selects the client fullname and clicks on approval request")
	public void User_clicks_on_approval_request() {
		emptyLogger(" \n ");
		accountApprovalPage.clickPendingLink(fullname.trim(), "Select Account before Approval ","Approval Request before Approval");
		accountApprovalPage.approveRequest("Click on approve request button ", "Approve Request button");
		emptyLogger(" \n ");
	}
	
	@Then("User selects the client fullname and reject request")
	public void User_reject_the_request() {
		emptyLogger(" \n ");
		accountApprovalPage.clickPendingLink(fullname.trim(), "Select account before approval ","approval request before approval");
		accountApprovalPage.rejectRequest("Click on reject request button ", "reject request button");
		emptyLogger(" \n ");
	}
	
	@Then("User validate reject message {string}")
	public void User_validate_reject_message(String message) {
		emptyLogger(" \n ");		
		Assert.assertTrue("paperwork has not been recalled", accountApprovalPage.validateRejectMessage().contains(message));	
		customLogger("record has been rejected ", "");
		emptyLogger(" \n ");
	}
}	
