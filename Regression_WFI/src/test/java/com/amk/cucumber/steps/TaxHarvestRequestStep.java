package com.amk.cucumber.steps;

import io.cucumber.java.en.Then;

public class TaxHarvestRequestStep  extends GenericStepMethods {
	
	
	
	@Then("verifying the Eligible cusip displayed on securities")
	public void cusip_Displayed_On_TLH_Data() {
		try {
			valueFor_TLHR = checkVisibilityOfCloseButton_THR();
			if (valueFor_TLHR) {
				logger.info("  ** The Account Doesn't have any Eligible Securities at the moment ** ");
				customLogger("  *** The Account Doesn't have any Eligible Securities at the moment *** ", "");
			}
		} catch (Exception e) {
			emptyLogger(" \n ");
			taxHarvestRequest.verifyCusipDisplayed(clientData.get("Net_Amt"), clientData.get("Wizard"), clientData.get("Cusip"));
			emptyLogger(" \n ");
		}
	}
	
	@Then("opting for Harvest type {string}")
	public void click_finish_With_Data(String harvestoption) {
		if (valueFor_TLHR) {

		} else {
			emptyLogger(" \n ");
			taxHarvestRequest.optingHarvestType(harvestoption);
			emptyLogger(" \n ");
		}
	}
	
	@Then("Choosing {string} as Harvest amount type and entering {string}")
	public void addingSpecificAmountAboveHundred(String optionToRealize, String proceedsBeInvested) {
		if (valueFor_TLHR) {

		} else {
			emptyLogger(" \n ");
			taxHarvestRequest.choosingHarvestAmountTypeAndAddingSpecificAmount(optionToRealize, proceedsBeInvested);
			emptyLogger(" \n ");
		}
	}
	
	@Then("clicking on {string} and accepting the Disclosures and click on finish button.")
	public void checkit(String marketOption) {
		if (valueFor_TLHR) {

		} else {
			emptyLogger(" \n ");
			taxHarvestRequest.choosingProceedsToBeInvested(marketOption);
			docuSignPage = taxHarvestRequest.acceptingDisclosure();
			emptyLogger(" \n ");
		}
	}
	
	@Then("Choosing {string} as Harvest amount type")
	public void checkingit(String optionToRealize) {
		if (valueFor_TLHR) {

		} else {
			emptyLogger(" \n ");
			taxHarvestRequest.choosingHarvestAmountType(optionToRealize);
			emptyLogger(" \n ");
		}
	}
	
	@Then("Choosing Harverst options and Navigating to DocuSign page and click on finish button")
	public void user_should_view_docu_sign_and_click_finish_With_Data_roundOneTest() {
		if (valueFor_TLHR) {

		} else {
			emptyLogger(" \n ");
			docuSignPage = taxHarvestRequest.chooseOptionsForTaxLossGain(clientData.get("HarvestType"),
					clientData.get("HarvestAmountType"), clientData.get("ProceedsInvested")); // HarvestType
			docuSignPage.clickContinueButton();
			docuSignPage.clickFinishButton();
			emptyLogger(" \n ");
		}
	}
}	
