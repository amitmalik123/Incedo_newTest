package com.amk.cucumber.steps;

import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.amk.cucumber.constants.Constants;

import io.cucumber.java.en.When;

public class OptOutListStep  extends GenericStepMethods {
	
	@When("User enters agent id and stop agent notifications {string} , {int}")
	public void enterUserAndStops(String sheetName, Integer rowNo) throws InvalidFormatException, IOException {
		emptyLogger(" \n ");		
		clientData = (HashMap<String, String>) getIndividualRowDataFromSheet(sheetName, rowNo);
		optOutListPage.enterAgentId(clientData.get(Constants.CLIENT_NAME));
		optOutListPage.clickStopAgent();
		emptyLogger(" \n ");
	}	
	
	@When("User enters agent id and resume agent notifications")
	public void enterUserAndresume(){
		emptyLogger(" \n ");		
		optOutListPage.enterAgentId(clientData.get(Constants.CLIENT_NAME));
		optOutListPage.clickResumeAgent();
		emptyLogger(" \n ");
	}
	
}	
