package com.amk.cucumber.steps;

import org.junit.Assert;

import com.amk.cucumber.constants.Constants;
import com.amk.cucumber.pages.ConstructPortfolioPage;
import com.amk.cucumber.pages.DocuSignPage;
import com.amk.cucumber.pages.FeesPage;
import com.amk.cucumber.pages.InvestmentChangePage;
import com.amk.cucumber.pages.ItemDetailsPage;
import com.amk.cucumber.pages.TaxManagementServices;
import com.amk.cucumber.pages.ViewDocumentsPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AccountWizardStep extends GenericStepMethods {

	@When("^Click on client management option \"(.*)\"$")
	public void click_on_client_management_option(String option) {
		emptyLogger(" \n ");		
		switch(option) {
		case "Change Your Financial Advisor Fee":
			feesPage = (FeesPage) accountWizardPage.selectClientManagementOption(option);
			break;
		case "Change Investments":
			investmentChangePage = (InvestmentChangePage) accountWizardPage.selectClientManagementOption(option);
			break;
		case "View Document History":
			viewDocumentsPage = (ViewDocumentsPage) accountWizardPage.selectClientManagementOption(option);
			break;
		case "Add a Registration":
			constructPortfolioPage = (ConstructPortfolioPage) accountWizardPage.selectClientManagementOption(option);	
		}		
		emptyLogger(" \n ");
	}

	@When("Select request and type in Account Management")
	public void select_request_and_type_in_Account_Management() {
		emptyLogger(" \n ");
		accountWizardPage.clickAccount(clientData.get(Constants.ACCOUNT_NUMBER));
		accountWizardPage.selectRequest(clientData.get(Constants.REQUEST_KEY));
		accountWizardPage.selectType(clientData.get(Constants.TYPE_KEY));
		emptyLogger(" \n ");
	}
	
	@When("Select request and {string} in Account Management")
	public void select_request_and_type_in_Account_Management(String type) {
		accountWizardPage.clickAccount(clientData.get(Constants.ACCOUNT_NUMBER));
		accountWizardPage.selectRequest(clientData.get(Constants.REQUEST_KEY));
		accountWizardPage.selectType(type);
		emptyLogger(" \n ");
	}
	
	@Then("Validate cancel tms form is present")
	public void validateTMSForm() {
		emptyLogger(" \n ");
		Assert.assertTrue("Cancel TMS form is not present", accountWizardPage.tmsCancelForm().contains("Investment Solution Change Request Form"));
		emptyLogger(" \n ");
	}

	@When("User clicks on complete and print button")
	public void user_clicks_on_complete_and_print_button() {
		emptyLogger(" \n ");
		docuSignPage = accountWizardPage.clickCompleteAndPrintBtn();
		emptyLogger(" \n ");
	}
	
	@When("User clicks on complete and print button to navigate to tms")
	public void user_clicks_on_complete_and_print_button_navigate_tms() {
		emptyLogger(" \n ");
		taxManagementServices = accountWizardPage.clickCompleteAndPrintBtnForTMS();
		emptyLogger(" \n ");
	}

	@When("User clicks on complete and submit button and click on complete button on client signature button")
	public void user_clicks_on_complete_and_submit_button_and_click_on_complete_button_on_client_signature_button() {
		emptyLogger(" \n ");
		String request= clientData.get(Constants.REQUEST_KEY).toLowerCase();
		accountWizardPage.clickCompleteAndSubmitBtn();
		accountWizardPage.clickCompleteOnClientSignatureModel();
		if(request.contains("tax management")) {
			taxManagementServices=	(TaxManagementServices) accountWizardPage.clickCompleteOnSignerInformationModel(request);
		}else {
		docuSignPage =  (DocuSignPage) accountWizardPage.clickCompleteOnSignerInformationModel(request);
		}
		emptyLogger(" \n ");
	}

	@Then("Fetch the tracking id and click on close button")
	public void user_should_fetch_tracking_id_and_click_close() {
		emptyLogger(" \n ");
		Object[] trackingIdItemsDetails = accountWizardPage.fetchDTrackingId();
		dTrackingId = (String) trackingIdItemsDetails[0];
		itemDetailsPage = (ItemDetailsPage) trackingIdItemsDetails[1];
		logger.info("*****  ####  d number  : " + dTrackingId);
		customLogger("d number: ", dTrackingId);
		emptyLogger(" \n ");
	}

	@Then("User is on the tracking center page and click on tracking id")
	public void user_is_on_the_tracking_center_page_and_click_on_tracking_id() {
		emptyLogger(" \n ");
		trackingCenterPage = accountWizardPage.clickTrackingCenterTab();
		itemDetailsPage = trackingCenterPage.searchForItemNumber(dTrackingId);
		emptyLogger(" \n ");
	}

	@Then("Navigate to tracking center page")
	public void Navigate_to_tracking_center_page() {
		emptyLogger(" \n ");
		trackingCenterPage = accountWizardPage.clickTrackingCenterTab();
		emptyLogger(" \n ");
	}

	@Then("User Adds a new Registration")
	public void User_Adds_a_new_Registration() {
		emptyLogger(" \n ");
		constructPortfolioPage = accountWizardPage.clickAddRegistration();
		emptyLogger(" \n ");
	}

	@When("User is on Account Wizard tab and click on go button for New Client creation")
	public void User_navigate_to_Account_Wizard_and_click_Go_button_for_New_Client_creation() {
		emptyLogger(" \n ");
		clientProfilePage = accountWizardPage.clickGoButton();
		customLogger("Start New Account Creation Journey",
				"Successfully clicked on Go button for New Account Creation");
		emptyLogger(" \n ");
	}

	@Then("Select a applicable HNW account and select the TLH option and do complete and Submit")
	public void navigate_to_account_wizard_page_and_select_the_tlh_option_and_do_complete_and_submit() {
		emptyLogger(" \n ");
		accountWizardPage.SelectApplicableHNWAccount(clientData.get(Constants.ACCOUNT_NUMBER)); // AccountforHNW
		try {
			accountWizardPage.clickTaxHarvestRequestLink();
		} catch (Exception e) {
			logger.info(
					" The selected account doesn't display 'Tax Harvest Request' from Gain Loss Tax Harvest Request request type ");
			customLogger(
					" # $ @ The selected account doesn't display 'Tax Harvest Request' from Gain Loss Tax Harvest Request request type ",
					"");
		}
		accountWizardPage.clickCompleteAndSubmitBtn();
		emptyLogger(" \n ");
	}

	@Then("opt for client physical signature and Navigate to Harvest options")
	public void continue_without_sign_and_opt_by_person_and_navigate_to_harvest_options() {
		emptyLogger(" \n ");
		taxHarvestRequest = accountWizardPage.clickContinueBtnForCompleteAndSubmit();
		emptyLogger(" \n ");
	}

	@Then("Select a applicable HNW account and select the TLH option and do complete and print")
	public void select_a_applicable_HNW_account_and_click_tlh_then_complete_and_print() {
		emptyLogger(" \n ");
		accountWizardPage.SelectApplicableHNWAccount(clientData.get(Constants.ACCOUNT_NUMBER));
		try {
			valueFor_TLHR = accountWizardPage.clickTaxHarvestRequestLink();
		} catch (Exception e) {
			logger.info(
					" The selected account doesn't display 'Tax Harvest Request' from Gain Loss Tax Harvest Request request type ");
			customLogger(
					" # $ @ The selected account doesn't display 'Tax Harvest Request' from Gain Loss Tax Harvest Request request type ",
					"");
		}
		taxHarvestRequest = accountWizardPage.clickCompleteAndPrintButton();
		emptyLogger(" \n ");
	}

	@Then("Select a applicable HNW account and select the TLH option and click Complete and Esign button")
	public void navigate_to_account_wizard_page_and_select_the_tlh_option_and_do_Complete_and_Esign_Generic() {
		emptyLogger(" \n ");
		accountWizardPage.SelectApplicableHNWAccount(clientData.get(Constants.ACCOUNT_NUMBER));
		try {
			accountWizardPage.clickTaxHarvestRequestLink();
		} catch (Exception e) {
			logger.info(
					" # $ @ The selected account doesn't display 'Tax Harvest Request' from Gain Loss Tax Harvest Request request type ");
			customLogger(
					" # $ @ The selected account doesn't display 'Tax Harvest Request' from Gain Loss Tax Harvest Request request type ",
					"");
		}
		if (seleniumCore.isElementVisible(accountWizardPage.completeAndEsigntBtn, 3, 1)) {
			accountWizardPage.clickCompleteAndEsignBtn();
		} else {
			accountWizardPage.clickCompleteAndSubmitBtn();
			accountWizardPage.selectClientESign();
			accountWizardPage.clickCompleteOnClientSignatureModel();
		}
		emptyLogger(" \n ");
	}

	@Then("provide account details and opt for client physical signature and Navigate to Harvest options")
	public void provide_account_details_and_opt_by_person_and_navigate_to_harvest_options() {
		if (valueFor_TLHR) {

		} else {
			emptyLogger(" \n ");
			taxHarvestRequest = accountWizardPage.insertAccdetailsforpersonalSign(clientData.get(Constants.CLIENT_NAME));
			emptyLogger(" \n ");
		}
	}
	
	@When("User select withdrawal method and click on continue button")
	public void navigates_to_docsign_page() {
		emptyLogger(" \n ");
		String withdrawalMethod= clientData.get(Constants.Withdrawal_Method);			
		docuSignPage=accountWizardPage.selectWithdrawalMethodAndContinue(clientData.get(Constants.EXISTING_BANK_ACCOUNT), withdrawalMethod);			
		emptyLogger(" \n ");
	}

	

}
