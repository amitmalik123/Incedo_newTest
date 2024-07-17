package com.amk.cucumber.steps;

import org.junit.Assert;

import io.cucumber.java.en.Then;

public class SubmitPageStep  extends GenericStepMethods {
	
	@Then("User navigates to submit page and clicks on submit button")
	public void User_clicks_on_proceed_to_submit_button() {
		emptyLogger(" \n ");
		submitPage.clickSubmitBtn("Click on Submit button", "Submit button");
		customLogger("click on submit button", "");
		emptyLogger(" \n ");
	}	
	
	@Then("User validate successful submission text {string}")
	public void user_validate_successful_submission_text(String text) {
		emptyLogger(" \n ");
		Assert.assertTrue("account has not been submitted successfully", submitPage.validateAccountSubmission().contains(text));
		customLogger("account has been submitted successfully ", "");
		emptyLogger(" \n ");
	}
}	
