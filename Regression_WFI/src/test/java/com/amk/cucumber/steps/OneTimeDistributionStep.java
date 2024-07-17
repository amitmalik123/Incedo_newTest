package com.amk.cucumber.steps;

import com.amk.cucumber.constants.Constants;

import io.cucumber.java.en.When;

public class OneTimeDistributionStep  extends GenericStepMethods {
	
	@When("enter one time distribution details")
	public void enter_one_time_distribution_details()  {
		emptyLogger(" \n ");				
		oneTimeDistributionPage.oneTimeDistribution(clientData.get(Constants.Withdrawal_Method));
		emptyLogger(" \n ");
	}
	
	@When("enter residual distribution details")
	public void enter_residual_distribution_details()  {
		emptyLogger(" \n ");				
		oneTimeDistributionPage.enterResidualDistribution(clientData.get(Constants.Delivery_Method));
		emptyLogger(" \n ");
	}
	
	@When("enter payee information")
	public void enter_payee_information()  {
		emptyLogger(" \n ");				
		oneTimeDistributionPage.enterPayeeInformation();	
		oneTimeDistributionPage.clickSaveCloseButton();
		bawDashboardPage.switchTab("OneTimeDistribution");
		emptyLogger(" \n ");
	}
	
	@When("User click on iwr button on distribution button")
	public void clickSaveCloseButton()  {
		emptyLogger(" \n ");	
		if(residualDistribution) {
		oneTimeDistributionPage.clickIWRButton(clientData.get(Constants.Delivery_Method));		
		bawDashboardPage.switchTab("ShellProcess");		
		seleniumCore.doesTitleContainText("Shell Process", 40, 1);
		}
		emptyLogger(" \n ");
	}
	
	@When("User select delivery method as {string}")
	public void updateDeliveryMethod(String option)  {
		emptyLogger(" \n ");			
		oneTimeDistributionPage.clickDeliveryMethodResidual(option);		
		emptyLogger(" \n ");
	}
	
	@When("QC user {string} the record of one time distrbution")
	public void qaApprove(String option)  {
		emptyLogger(" \n ");				
		oneTimeDistributionPage.clickQcApprovedButton(option);		
		seleniumCore.getDriver().switchTo().window(shellPageWindow);     
		emptyLogger(" \n ");
	}	
	
	@When("QC user {string} the record of residual distrbution")
	public void qaApproveOnRD(String option)  {
		emptyLogger(" \n ");	
		if(residualDistribution) {
		oneTimeDistributionPage.clickQcApprovedButtonforRD(option);		
		seleniumCore.getDriver().switchTo().window(shellPageWindow);  
		}
		emptyLogger(" \n ");
	}
	
	@When("User update the journal with account no {string}")
	public void updateJournal(String option)  {
		emptyLogger(" \n ");				
		oneTimeDistributionPage.updateJournal(option);				     
		emptyLogger(" \n ");
	}	
	
}	
