package com.amk.cucumber.steps;

import io.cucumber.java.en.Then;

public class TaxManagementServicesStep  extends GenericStepMethods {	
	
	
	@Then("User fill all tms data to enroll")
	public void userFillManagementData() {		
			emptyLogger(" \n ");
			taxManagementServices.selectTaxSensitivity("medium");
			taxManagementServices.addCustomizations();
			taxManagementServices.clickSaveCustomizations();
			docuSignPage =  taxManagementServices.clickContinueButton("medium");
			emptyLogger(" \n ");
		}
	
	
	@Then("User modify tms data")
	public void userModifyManagementData() {		
			emptyLogger(" \n ");
			taxManagementServices.selectTaxSensitivity("low");			
			docuSignPage =  taxManagementServices.clickContinueButton("low");
			emptyLogger(" \n ");
		}
	
	@Then("User cancel tms enrollment")
	public void userCancelEnrollment() {		
			emptyLogger(" \n ");
			docuSignPage =  taxManagementServices.clickContinueButton("medium");
			emptyLogger(" \n ");
		}
	
}	
