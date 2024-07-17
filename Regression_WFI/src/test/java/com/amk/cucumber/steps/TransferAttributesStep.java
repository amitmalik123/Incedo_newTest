package com.amk.cucumber.steps;

import org.junit.Assert;
import org.openqa.selenium.By;

import com.amk.cucumber.constants.Constants;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TransferAttributesStep  extends GenericStepMethods {
	
	@Then("enter transfer details for work item {string} with {string} allocation in destination")
	public void enter_transfer_details(String workItemType, String allocationUnit)  {
		emptyLogger(" \n ");				
		transferAttributesPage.enterTransferRequest(clientData.get(Constants.TRANSFER_REQUEST),workItemType);
		if(workItemType.equals("Transfer In Request")   ||     workItemType.equals("Custodian Change Request") )
			transferAttributesPage.enterDestinationAccounts(workItemType, addAccountInfo, allocationUnit);
//		transferAttributesPage.clickSaveCloseButton();
		seleniumCore.getDriver().switchTo().window(shellPageWindow);     
		emptyLogger(" \n ");
	}	
	
	@When("QC user approve the record")
	public void qaApprove()  {
		emptyLogger(" \n ");				
		transferAttributesPage.clickQcApprovedButton();		
		seleniumCore.getDriver().switchTo().window(shellPageWindow);     
		emptyLogger(" \n ");
	}
	
	@When("User clicks on submission complete")
	public void submissionComplete()  {
		emptyLogger(" \n ");				
		transferAttributesPage.clickSubmissionCompleteButton();		
		seleniumCore.getDriver().switchTo().window(shellPageWindow);     
		emptyLogger(" \n ");
	}
	
	@When("User clicks on ready for submission")
	public void readyForsubmissionComplete()  {
		emptyLogger(" \n ");				
		transferAttributesPage.clickReadyForsubmission();		
		seleniumCore.getDriver().switchTo().window(shellPageWindow);     
		emptyLogger(" \n ");
	}
	
	@When("Validate transfer status should be {string}")
	public void transferStatus(String status)  {
		emptyLogger(" \n ");				
		String tStatus= transferAttributesPage.transferStatus();
		Assert.assertEquals("transfer status is not "+ status, status, tStatus);
		emptyLogger(" \n ");
	}
	
	@When("User clicks on IWR button")
	public void iwrComplete()  {
		emptyLogger(" \n ");				
		transferAttributesPage.iwrComplete();	
		seleniumCore.getDriver().switchTo().window(shellPageWindow);  
		emptyLogger(" \n ");
	}
	
	@Then("enter transfer details for work item")
	public void enter_transfer_details()  {
		emptyLogger(" \n ");				
		String transferRequest = clientData.get(Constants.TRANSFER_REQUEST);
		String[] transferData = transferRequest.split(",");	
		transferAttributesPage.commonTransferRequestSteps(transferData);		   
		emptyLogger(" \n ");
	}
	
	@Then("enter destination accounts details")
	public void destinationDetails()  {
		emptyLogger(" \n ");				
		transferAttributesPage.enterDestinationAccounts();		   
		emptyLogger(" \n ");
	}
	
	@Then("User validate checklist update options")
	public void checkListOptions()  {
		emptyLogger(" \n ");				
		transferAttributesPage.checkListSection();
		transferAttributesPage.checkListUpdate();
		emptyLogger(" \n ");
	}
	
	@When("User clicks on create checklist button")
	public void createChecklistButton()  {
		emptyLogger(" \n ");				
		transferAttributesPage.checkListSection();  
		emptyLogger(" \n ");
	}
	
	@Then("User validate all checklist options are selected or not")
	public void checklistAllOptions()  {
		emptyLogger(" \n ");				
		transferAttributesPage.validateChecklistOptions();
		emptyLogger(" \n ");
	}
	
	@When("User clicks on update checklist button")
	public void updateChecklistButton()  {
		emptyLogger(" \n ");				
		transferAttributesPage.updateChecklist(); 
		emptyLogger(" \n ");
	}
	
	@When("User switch transfer type to {string}")
	public void switchType(String type)  {
		emptyLogger(" \n ");				
		transferAttributesPage.editTransfer(); 
		transferAttributesPage.updateTransferType(type); 
		emptyLogger(" \n ");
	}
	
	@When("User select transfer type to {string}")
	public void selectTransferType(String type)  {
		emptyLogger(" \n ");			 
		transferAttributesPage.updateTransferType(type); 
		emptyLogger(" \n ");
	}
	
	@When("User switch delivery method to {string}")
	public void switchDeliveryMethod(String type)  {
		emptyLogger(" \n ");				
		transferAttributesPage.editTransfer(); 
		transferAttributesPage.updateDeliveryMethod(type); 
		emptyLogger(" \n ");
	}
	
	@When("User remove funding account")
	public void removeFundingAccount()  {
		emptyLogger(" \n ");				
		transferAttributesPage.editTransfer(); 
		transferAttributesPage.removeFundingAccount();
		emptyLogger(" \n ");
	}
	
	@Then("User validate checklist response after switch")
	public void afterSwitch()  {
		emptyLogger(" \n ");				
		transferAttributesPage.validateChecklistAgain();
		emptyLogger(" \n ");
	}
	
	@Then("User validate delivery method after switch")
	public void deliveryMethodAfterSwitch()  {
		emptyLogger(" \n ");			
		Assert.assertTrue("delivery method does not change after switch", transferAttributesPage.validateFaxVerbiage());
		logger.info("delivery method does change after switch");
		customLogger("delivery method does change after switch", "");
		emptyLogger(" \n ");
	}
	
	@Then("Validate error message on submission {string}")
	public void validateSubmission(String msg)  {
		emptyLogger(" \n ");			
		transferAttributesPage.submissionComplete();
		Assert.assertTrue("error messgae has not triggered "+ msg, transferAttributesPage.validateSubmissionAlert().contains(msg));
		logger.info("error messgae has not triggered "+ msg);
		customLogger("error messgae has not triggered ", msg);
		emptyLogger(" \n ");
	}
	
	@Then("Validate checklist section when transfer status is {string}")
	public void validatetransferStatus(String status)  {
		emptyLogger(" \n ");				
		Assert.assertEquals("transfer status is not inflight", status.toLowerCase(), transferAttributesPage.transferStatus().toLowerCase());
		transferAttributesPage.validateChecklistAgain();
		emptyLogger(" \n ");
	}
	
	@When("Validate created contra firm on transfer page")
	public void validateConfirmFirmTransfer()  {
		emptyLogger(" \n ");				
		transferAttributesPage.selectContraFirm(firmName);
		Assert.assertTrue("created firm name is not present", seleniumCore.isElementVisible(By.xpath("//div[@id='singleselect_TransferAttributesCV_ContraFirm_chosen']/a/span[text()='"+firmName+"']")));
		emptyLogger(" \n ");
	}
	
	@Then("Validate contra firm submission section for {string}")
	public void validateConfirmFirmSubmissionSection(String option)  {
		emptyLogger(" \n ");				
		transferAttributesPage.validateContraFirmSubmissionSection(option);
		emptyLogger(" \n ");
	}
}	
