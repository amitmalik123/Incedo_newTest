package com.amk.cucumber.pages;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.openqa.selenium.By;

import com.amk.cucumber.exceptions.DefaultException;
import com.amk.cucumber.utility.SeleniumCore;

public class SearchWorkItemPage extends BawBasePage {

	private static final String PAGE_NAME = "Search Work Item PAGE";
	
//	private By coachTitle = By.xpath("//a[@title='Search Work Item'    and     @tabindex]");
	private By custodianAccountTextField = By.xpath("//input[@id='text-input-SearchTrackingCenterCV1:AccountNumber']");
	private By searchButton = By.xpath("//button[@id='button-button-SearchTrackingCenterCV1:Search']");
	private By coachFrame = By.xpath("//*[@title='Coach']");
	private By detailsLink = By.xpath("//a[text()='Details'  and    not(@title)][1]");
	private By historyLink = By.xpath("//a[text()='History']");
	private By externalIdTextField = By.xpath("//input[@id='text-input-SearchTrackingCenterCV1:ExternalID']");
	private By searchedResults = By.xpath("//div[@class='outerTable']//tbody");
	private By taskStartDate = By.xpath("//p[contains(@id,'outputtext-text-WorkItemHistory1:TaskStartDate1')]");
	private By parentBNumber = By.xpath("//div[@data-viewid='ParentBNumberCell'   and   starts-with(text(),'B')]");
	private By searchWorkItemHistoryText = By.xpath("//table[@class='table table-bordered']/tbody");
	
	public SearchWorkItemPage(SeleniumCore seleniumCore) {
		this(seleniumCore, true);
	}

	public SearchWorkItemPage(SeleniumCore seleniumCore, boolean pageVerification) {	
		super(seleniumCore);	
		if (pageVerification) {	
			seleniumCore.switchToFrame(coachFrame, 60, 1);	
			boolean isVisible = seleniumCore.isElementVisible(searchButton);	
			if (isVisible) {	
				this.seleniumCore.getLogger().info(PAGE_NAME + " verification" + ":" + PAGE_NAME + " verification is PASSED");	
			} else {	
				this.seleniumCore.getLogger().warn(PAGE_NAME + " verification" + ":" + PAGE_NAME + " verification is FAILED");	
				throw new DefaultException("search work item page is not displaying");	
			}	
		}	
	}

	public void enterAccountNumberAndClickSearch(String accountNumber) {	
		seleniumCore.sendKeys(custodianAccountTextField, accountNumber, "entering account number ");		
		clickSearch();	
	}	
	
	public void clickDetailsLink(String option) {
		switch(option) {
		case "details":
			this.seleniumCore.waitForElementToBeVisible(detailsLink,20,1);	
			seleniumCore.click(detailsLink, "click on details link ", "");	
			seleniumCore.waitForUILoading(5000);
			switchTab("Shell Process");				
			customLogger("Clicked on details link ", "");
			break;
		case "history":
			this.seleniumCore.waitForElementToBeVisible(historyLink,20,1);	
			seleniumCore.click(historyLink, "click on history link ", "");	
			seleniumCore.waitForJStoLoad();			
			logger.info("clicked on history link");
			customLogger("Clicked on history link ", "");
			seleniumCore.waitForUILoading(5000);
			switchTab("SearchWorkItemHistory");				
			break;
		default:
			logger.info("user clicked on "+ option);
		}		
					
	}
	
	
	public void enterExternalIdAndClickSearch(String bNumber) {	
		seleniumCore.waitForElementToBeVisible(externalIdTextField, 30, 1);
		seleniumCore.sendKeys(externalIdTextField, bNumber, "entering external id ");
		customLogger("entered external id ", bNumber);	
		clickSearch();	
	}
	
	public void clickSearch() {		
		seleniumCore.waitForElementToBeVisible(searchButton, 30, 1);
		seleniumCore.click(searchButton, "click on search button ", "");		
		customLogger("clicked on search button ", "");		
	}
	
	public void validateSearchedResultData(String parameterToValidate, String value) {	
		seleniumCore.waitForJStoLoad();
		seleniumCore.waitForElementToBeVisible(searchedResults, 30, 1);
		switch(parameterToValidate) {
		case "dateValidation":			
			String date= dateUtil.dateFormatConversion(Integer.parseInt(value));		
			Assert.assertTrue("created record has not been validated ", seleniumCore.getText(searchedResults).contains(date));			
			logger.info("creation date has been validated ");	
			customLogger("creation date has been validated ", "");		
			break;
		case "internal Status":
			Assert.assertTrue("internal status has not been validated ", seleniumCore.getText(searchedResults).contains(value));			
			logger.info("internal status has been validated " );	
			customLogger("internal status has been validated ", "");		
			break;	
		default :	
			logger.info("result has been validated ");	
	}	
	}
	
	public void ValidateStartDateOrder() {
		seleniumCore.frameAvailableAndSwitchToIt(coachFrame, 10, 1);
		List<String> getStartDate= seleniumCore.findElements(taskStartDate).stream().map(e -> e.getText()).collect(Collectors.toList());		
		List<String> getSortedStartDate= getStartDate.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());		
		Assert.assertTrue("start date is not in sorted order ", getStartDate.equals(getSortedStartDate));
		logger.info("time stamp is in sorted  order ");	
		customLogger("time stamp is in sorted  order ", "");
	}
	
	public String fetchParentBNumber() {	
		seleniumCore.waitForJStoLoad();
		waitForLoadingData();
		if(!seleniumCore.isElementVisible(detailsLink, 6, 1)) {	
			clickSearch();	
		}		         			
		seleniumCore.waitForElementToBeVisible(detailsLink, 20, 1);	
	//	seleniumCore.scrollPageWidth();	
		if(parentBNumber== null) {	
			throw new DefaultException("parent B number is not generated");	
		}	
		String bNum = seleniumCore.getText(parentBNumber);		
		logger.info("fetched parent b number.." + bNum);	
		customLogger("fetch parent b number ", bNum);	
		return bNum;	
	}
	
	public String fetchWorkItemText() {
		seleniumCore.waitForJStoLoad();	
		waitForLoadingData();
		seleniumCore.getDriver().navigate().refresh();		
		seleniumCore.switchToFrame(By.xpath("//iframe[@title='Coach']"), 30, 1);
		seleniumCore.waitForElementToBeVisible(searchWorkItemHistoryText, 20, 1);	
		return seleniumCore.getText(searchWorkItemHistoryText);		
	}
	
}
