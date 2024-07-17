package com.amk.cucumber.pages;

import org.junit.Assert;
import org.openqa.selenium.By;

import com.amk.cucumber.utility.SeleniumCore;

public class BulkReassignPage extends BawBasePage {

	private static final String PAGE_NAME = "Bulk Assign CS Page";	

	private By searchButton = By.xpath("//button[@id='ButtonGroup1_Button0']");
	private By coachFrame = By.xpath("//iframe[@title='Bulk Reassign CS']");
	private By user = By.xpath("//select[@id='InputText0']");
	private By tableResult = By.cssSelector("#Table0-div");
	private By recordCheckbox = By.cssSelector("#Table0_0>td > input");
	private By reassignButton = By.cssSelector("#ButtonGroup2_Button0");
	private By bNum = By.cssSelector("#InputText14_0");
	private By reassignGroup = By.cssSelector("#InputText3");
	private By reassignUser = By.cssSelector("#InputText4");
	private By reassignToButton = By.cssSelector("#ButtonGroup0_Button0");
	private By searchBNumber = By.cssSelector("#InputText20");
	
	public BulkReassignPage(SeleniumCore seleniumCore) {
		this(seleniumCore, true);
	}

	public BulkReassignPage(SeleniumCore seleniumCore, boolean pageVerification) {
		super(seleniumCore);
		if (pageVerification) {
			seleniumCore.switchToFrame(coachFrame, 10, 1);
			boolean isVisible = seleniumCore.isElementVisible(searchButton);
			if (isVisible) {
				this.seleniumCore.getLogger()
						.info(PAGE_NAME + " verification" + ":" + PAGE_NAME + " verification is PASSED");
			} else {
				this.seleniumCore.getLogger()
						.warn(PAGE_NAME + " verification" + ":" + PAGE_NAME + " verification is FAILED");
			}
		}
	}

	public void searchCriteria(String value) {	
		seleniumCore.waitForElementToBeVisible(user,20,1);	
		seleniumCore.selectByValue(user, value,"","",10,1);
		logger.info("select user");
		customLogger("Select user ", value);		
		clickSearch();	
	}	
	
	public boolean validateSearchResult() {
		seleniumCore.waitForElementToBeVisible(tableResult,20,1);
		return seleniumCore.isElementVisible(tableResult);
	}
	
	public String selectRecordAndReassign() {
		seleniumCore.waitForElementToBeVisible(recordCheckbox,20,1);
		seleniumCore.clickRadioButton(recordCheckbox, "click record checkbox", "");
		customLogger("click record checkbox", "");
		String val= seleniumCore.getText(bNum);
		seleniumCore.click(reassignButton);
		logger.info("Click on reassign button");
		customLogger("Click on reassign button ", "");
		return val;
	}
	
	public void reassignToModel(String value) {	
		seleniumCore.getDriver().switchTo().activeElement();
		seleniumCore.waitForElementToBeVisible(reassignGroup, 30, 1);
		seleniumCore.selectByValue(reassignGroup, "Account Operations PC","","",10,1);
		logger.info("select reassign group");
		customLogger("Select reassign group ", "");
		seleniumCore.waitForJStoLoad();
		waitForLoadingData();
		seleniumCore.selectByValue(reassignUser, value,"","",10,1);
		logger.info("select reassign user");
		customLogger("Select reassign user ", value);
		clickReassignToButton();	
	}
	
	public void clickSearch() {		
		seleniumCore.waitForElementToBeVisible(searchButton, 30, 1);
		seleniumCore.click(searchButton, "click on search button ", "");		
		customLogger("clicked on search button ", "");		
	}
	
	public void clickReassignToButton() {		
		seleniumCore.waitForElementToBeVisible(reassignToButton, 30, 1);
		seleniumCore.click(reassignToButton, "click on reassign to button ", "");		
		customLogger("clicked on reassign to button ", "");		
	}
	
	public void searchAssignedRecord(String value) {
		seleniumCore.waitForElementToBeVisible(user,20,1);	
		seleniumCore.selectByIndex(user, 0, "", "", 10, 1);
		seleniumCore.sendKeys(searchBNumber, value);
		clickSearch();		
	}
	
	public String validateReassignedRecord() {
		seleniumCore.waitForElementToBeVisible(tableResult,20,1);
		String text= seleniumCore.getText(tableResult);
		Assert.assertTrue("group user is different", text.contains("Account Operations PC"));
		logger.info("validate group user");
		customLogger("validate group user ", "");
		return text;
	}
	
}
