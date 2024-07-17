package com.amk.cucumber.steps;

import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.amk.cucumber.constants.Constants;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SetQCSelectionStep  extends GenericStepMethods {
	
	
	@Then("Validate icon and rate updated {string} , {int}")
	public void validate_search_result(String sheetName, Integer rowNo) throws InvalidFormatException, IOException  {
		emptyLogger(" \n ");
		clientData = (HashMap<String, String>) getIndividualRowDataFromSheet(sheetName, rowNo);
		setQCSelectionPage.selectUserName(clientData.get(Constants.INDIVIDUAL_User));
		setQCSelectionPage.selectWorkType();
		setQCSelectionPage.selectQcRate();
		setQCSelectionPage.clickSave();
		seleniumCore.handleAlert("OK");
		emptyLogger(" \n ");
	}
	
	@When("Click get list button")
	public void clickOnSearchedResultOption () {
		emptyLogger(" \n ");		
		setQCSelectionPage.selectUserName(clientData.get(Constants.INDIVIDUAL_User));
		setQCSelectionPage.clickGetList();
		emptyLogger(" \n ");
	}
	
	@Then("Validate list displayed for user name")
	public void validate_search_result() {
		emptyLogger(" \n ");		
		setQCSelectionPage.validateGetListResult();		
		emptyLogger(" \n ");
	}
	
}	
