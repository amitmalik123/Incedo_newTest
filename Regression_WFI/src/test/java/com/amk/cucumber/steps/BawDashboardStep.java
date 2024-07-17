package com.amk.cucumber.steps;

import org.junit.Assert;

import com.amk.cucumber.pages.AccountUpdateUtilityPage;
import com.amk.cucumber.pages.BulkReassignPage;
import com.amk.cucumber.pages.IRAWithdrawalRequestPage;
import com.amk.cucumber.pages.NAACoachPage;
import com.amk.cucumber.pages.OptOutListPage;
import com.amk.cucumber.pages.SearchWorkItemPage;
import com.amk.cucumber.pages.SetQCSelectionPage;
import com.amk.cucumber.pages.ShellProcessPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BawDashboardStep  extends GenericStepMethods {
	
	String filterName="";
	
	@When("User search via B tracking number {string}")
	public void user_should_search_for_the_tracking_id(String option) {	
	 emptyLogger(" \n ");	 
	 switch(option) {
	 case "viaeWM":
		 if(bTrackingId== null) {
		    bawPageWindow = bawDashboardPage.enterBNumberToSearch(parentBNumber);
		    customLogger("search for parent b number ", parentBNumber);
		 }else {
			 bawPageWindow = bawDashboardPage.enterBNumberToSearch(bTrackingId);
			 customLogger("search for b number ", bTrackingId);
		 }
		 break;
	 case "directBAW":
		 bawPageWindow = bawDashboardPage.enterBNumberToSearch(bNumber);
		 customLogger("search for b number ", bNumber);
		 break;
		 default:
			 logger.info("user is doing b number search ");
	 }		
	 emptyLogger(" \n ");
	}
	
	@When("User click on run icon and switch to {string} page")
	public void user_click_on_run_icon(String pageTitle) {
		emptyLogger(" \n ");
		switch(pageTitle) {
		case "Shell Process":
			shellProcessPage = (ShellProcessPage) bawDashboardPage.runBTrackingNum(bTrackingId, pageTitle);
			break;
		case "Withdrawal Request":
			iRAWithdrawalRequestPage = (IRAWithdrawalRequestPage) bawDashboardPage.runBTrackingNum(bTrackingId, pageTitle);
			break;
		case "NAA Coach":
			naaCoachPage = (NAACoachPage) bawDashboardPage.runBTrackingNum(parentBNumber, pageTitle);
			break;
		default:
			logger.info("page is not defined");
		}	
		emptyLogger(" \n ");
	}
	
	@When("^Switch to respective tab (\\d+) with details \"(.*)\"$")
	public void switch_to_respective_tab(int switchtab, String message) {
		emptyLogger(" \n ");
		bawDashboardPage.switchWindow(switchtab);
		logger.info("user switched to "+ message);
		customLogger(message , "");
		emptyLogger(" \n ");
	}
	
	@When("Switch to respective tab with title {string}")
	public void switch_to_respective_tab_with_title(String title) {
		emptyLogger(" \n ");
		bawDashboardPage.switchTab(title);
//		logger.info("user switched to "+ message);
		emptyLogger(" \n ");
	}
	
	@When("Click on Open New WorkIteam button")
	public void click_on_Open_New_WorkIteam() {
		emptyLogger(" \n ");		
		bawPageWindow= seleniumCore.getDriver().getWindowHandle();					
		shellProcessPage=bawDashboardPage.clickOpenNewWorkItemButton();	
		emptyLogger(" \n ");
	}
	
	@When("User switch to baw page")
	public void User_switch_to_baw_page() {		
		emptyLogger(" \n ");							
		System.out.println("close the driver");
		try {
			driver.close();
			customLogger("Closed all the browser instances", "");
			bawDashboardPage.switchWindow(bawPageWindow);	
		} catch (Exception e) {
			customLogger("Not able to close all the browser instances", "");
		}	
		emptyLogger(" \n ");
	}	
	
	@Then("Click on {string} tab")
	public void click_on_search_work_item_tab(String text) {
		emptyLogger(" \n ");
		if (text.contains("Search Work")) {
			searchWorkItemPage = (SearchWorkItemPage) bawDashboardPage.clickSearchWorkItem(text);
		} else if(text.contains("Bulk Reassign")){
			bulkReassignPage = (BulkReassignPage) bawDashboardPage.clickSearchWorkItem(text);
		} else if(text.contains("Account Update")){
			accountUpdateUtilityPage = (AccountUpdateUtilityPage) bawDashboardPage.clickSearchWorkItem(text);
		} else if(text.contains("QC")){
			setQCSelectionPage = (SetQCSelectionPage) bawDashboardPage.clickSearchWorkItem(text);
		}else if(text.contains("out List")){
			optOutListPage = (OptOutListPage) bawDashboardPage.clickSearchWorkItem(text);
		} else if(text.contains("Dashboard")){
			bawDashboardPage.clickSearchWorkItem(text);
		} 
		else {
			logger.info("tab option is not matching");
		}
		emptyLogger(" \n ");
	}
	
	@When("User logout from BAW application")
	public void user_logout_from_BAW_application()  {
		emptyLogger(" \n ");
		bawDashboardPage.clickLogOutLink();
		emptyLogger(" \n ");
	}	
	
	@When("User validate internal status {string} on dashboard page")
	public void user_validate_internal_status_on_dashboard_page(String status)  {
		emptyLogger(" \n ");	
		Assert.assertTrue("Error: internal status is not validated ", bawDashboardPage.validateInternalStatus().contains(status));	
		logger.info("internal status has been validated: "+ status);
		customLogger("internal status has been validated: ", status);
		emptyLogger(" \n ");
	}
	
	@Then("User validate updated data on dashboard page")
	public void user_validate_updated_data_on_dashboard_page()  {
		emptyLogger(" \n ");			
		Assert.assertTrue("Error: data not updated on dashboard page ", bawDashboardPage.validateInternalStatus().contains(secondRow[2]));	
		logger.info("data has been updated on dashboard page");
		customLogger("data has been updated on dashboard page ", "");
		emptyLogger(" \n ");
	}
	
	@When("Validate work item on dashboard page")
	public void validate_work_item_on_dashboard_page()  {
		emptyLogger(" \n ");		
		bawDashboardPage.validateChangedUser();
		emptyLogger(" \n ");
	}
	
	@When("Validate the frame and switch to it on {string} page")
	public void validate_the_frame_and_switch_to_it(String page)  {
		emptyLogger(" \n ");
		switch(page) {
		case "bawDashboardPage":
			bawDashboardPage.switchToFrame();
			customLogger("switch to frame on baw dashboard page","");
			break;
		case "journalUtilityPage":
			journalUtilityPage.switchToFrame();
			customLogger("switch to frame on journal utility page","");
			break;	
		default: 
			logger.info("usr switched to respective frame");
		}		
		emptyLogger(" \n ");
	}
	
	@When("User creates a filter on {string} and enter value {string}")
	public void user_create_a_filter(String option, String value)  {
		emptyLogger(" \n ");		
		bawDashboardPage.clickFilterSection();
		switch(option) {
		case "amount":
			bawDashboardPage.createFilterOnAmount(value);
			break;
		default:
			logger.info("filter creation is in progress");
		}		
		bawDashboardPage.saveCurrentFilterButton();
		emptyLogger(" \n ");
	}
	
	@Then("User validate the filter model and save the filter by name {string}")
	public void user_validate_the_filter_model_and_save_the_filter_by_name(String value)  {
		emptyLogger(" \n ");
		filterName = seleniumCore.generateRandomData(6);
		bawDashboardPage.validateSaveFilterModelAndSaveFilter(filterName);
		emptyLogger(" \n ");
	}
	
	@Then("User validate saved filter {string}")
	public void user_validate_save_filter(String value)  {
		emptyLogger(" \n ");
		bawDashboardPage.validateSavedFilter(filterName);		
		emptyLogger(" \n ");
	}
	
	@When("User clicks on filter button")
	public void user_click_on_filter_button()  {
		emptyLogger(" \n ");
		bawDashboardPage.clickFilterButton();	
		emptyLogger(" \n ");
	}
	
	@Then("User validate the filterd data on amount in range {int} to {int}")
	public void user_validate_the_filterd_data_on_amount_in_range(int startvalue, int endValue)  {
		emptyLogger(" \n ");		
		bawDashboardPage.validateAppliedFilterCriteria(startvalue, endValue);
		emptyLogger(" \n ");
	}
	
	@When("User clicks on reset button")
	public void user_click_on_reset_button()  {
		emptyLogger(" \n ");
		bawDashboardPage.clickResetButton();	
		emptyLogger(" \n ");
	}
	
	@Then("User validate deactivate filter")
	public void user_validate_deactivate_filter()  {
		emptyLogger(" \n ");
		bawDashboardPage.validateResetFilterCriteria();		
		emptyLogger(" \n ");
	}
	
	@When("User clicks on flter all button")
	public void user_click_on_filter_all_button()  {
		emptyLogger(" \n ");
		bawDashboardPage.clickFilterAllButton();
		emptyLogger(" \n ");
	}
	
	@When("User delete the created filter {string}")
	public void user_delete_the_created_filter(String value)  {
		emptyLogger(" \n ");
		bawDashboardPage.deleteCreatedFilter(filterName);
		emptyLogger(" \n ");
	}
	
	@Then("User validate the deleted filter {string}")
	public void user_alidate_the_deleted__filter(String value)  {
		emptyLogger(" \n ");
		bawDashboardPage.validateDeletedFilter(filterName);
		emptyLogger(" \n ");
	}
	
	@When("User search for the tracking id and select app id checkbox and click on run")
	public void user_should_search_for_the_tracking_id_and_select_app_id_checkbox_and_click_run() {
		if (valueFor_TLHR) {

		} else {
			emptyLogger(" \n ");
			parentWindow = bawDashboardPage.enterBNumberToSearch(bTrackingId);
			emptyLogger(" \n ");
		}
	}
	
	@Then("Validate the {string} page")
	public void user_should_verify_shell_process_page(String page) {
		if (valueFor_TLHR) {

		} else {
			emptyLogger(" \n ");
			shellProcessPage  = (ShellProcessPage) bawDashboardPage.runBTrackingNumberToApproveHarvestRequest(bTrackingId, page);
			emptyLogger(" \n ");
		}
	}
	
	@Then("Establish DB connection and execute query to verify Approval Status.")
    public void establish_db_connection_and_execute_query_to_verify_approval_status() throws InterruptedException {
        if (valueFor_TLHR) {
        } else {
            emptyLogger(" \n ");
            setupDBConnection("ewm");	
            String valeFromDB = dataBaseValueVerification(dTrackingId);
            validatingTLHapprovalFromDB(valeFromDB, bTrackingId);         
            emptyLogger(" \n ");
        }
    }
	
	@Then("User click on b number link and switch to {string} page")
	public void user_click_on_b_number_link_and_switch_to (String value)  {
		emptyLogger(" \n ");
		bawDashboardPage.clickBTrackingNum(bTrackingId, value);
		emptyLogger(" \n ");
	}
	
	@Then("Run {string} old workitem and validate")
	public void Run_old_workitem_and_validate(String option) {
		emptyLogger(" \n ");
		bawDashboardPage.runBTrackingNumAndValidate(option);		
		emptyLogger(" \n ");
	}
	
	@Then("Validate archived B number on dashboard page")
	public void validate_archived_B_number_on_dashboard_page() {
		emptyLogger(" \n ");
		bawDashboardPage.validateTaskTable();	
		customLogger("archived B number is not displaying on dashboard page","");
		emptyLogger(" \n ");
	}
	
	@When("User search {string} b number {string} and validate")
	public void user_should_search_for_b_number(String workItemType, String option) {	
	 emptyLogger(" \n ");	 	
		 bawPageWindow = bawDashboardPage.enterBNumberToSearch(option);
		 customLogger("search for b number ", option);	
		 switch(workItemType) {
		 case "transfer":
		 case "distribution":
			 shellProcessPage=  (ShellProcessPage) bawDashboardPage.runBTrackingNumAndValidate(workItemType);
			 break;
		default:
			bawDashboardPage.runBTrackingNumAndValidate(workItemType);
			break;
		 }		 
	 emptyLogger(" \n ");
	}
}	
