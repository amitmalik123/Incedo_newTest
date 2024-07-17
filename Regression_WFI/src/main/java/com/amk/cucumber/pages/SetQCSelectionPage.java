package com.amk.cucumber.pages;

import org.junit.Assert;
import org.openqa.selenium.By;

import com.amk.cucumber.utility.SeleniumCore;

public class SetQCSelectionPage extends BawBasePage {

	private static final String PAGE_NAME = "Set QC Selection Page";	

	private By saveButton = By.xpath("//button[@id='ButtonGroup1_Button0']");
	private By coachFrame = By.xpath("//iframe[@title='Set QC Selection']");
	private By userName = By.xpath("//select[@id='ComboBox0']");
	private By workType = By.xpath("//select[@id='ComboBox6']");
	private By qcSelection = By.xpath("//select[@id='ComboBox5']");
	private By getList = By.cssSelector("#ButtonGroup1_Button1");
	
	public SetQCSelectionPage(SeleniumCore seleniumCore) {
		this(seleniumCore, true);
	}

	public SetQCSelectionPage(SeleniumCore seleniumCore, boolean pageVerification) {
		super(seleniumCore);
		if (pageVerification) {
			seleniumCore.switchToFrame(coachFrame, 10, 1);
			boolean isVisible = seleniumCore.isElementVisible(saveButton);
			if (isVisible) {
				this.seleniumCore.getLogger()
						.info(PAGE_NAME + " verification" + ":" + PAGE_NAME + " verification is PASSED");
			} else {
				this.seleniumCore.getLogger()
						.warn(PAGE_NAME + " verification" + ":" + PAGE_NAME + " verification is FAILED");
			}
		}
	}

	public void selectQcRate() {
		seleniumCore.waitForElementToBeVisible(qcSelection,20,1);	
		seleniumCore.selectByValue(qcSelection, "0","","",10,1);
		logger.info("select qc selection");
		customLogger("Select qc selection ", "");
	}
	
	public void selectUserName(String value) {	
		seleniumCore.waitForElementToBeVisible(userName,20,1);	
		seleniumCore.selectByValue(userName, value);		
		logger.info("select user");
		customLogger("Select user ", value);				
	}
	
	public void selectWorkType() {
		seleniumCore.selectByValue(workType, "Account Cash Restriction or Removal","","",10,1);
		logger.info("select work type");
		customLogger("Select work type ", "");
	}
	
	public void clickSave() {		
		seleniumCore.waitForElementToBeVisible(saveButton, 30, 1);
		seleniumCore.click(saveButton, "click on save button ", "");		
		customLogger("clicked on save button ", "");
		waitForLoadingData();
	}
	
	public void clickGetList() {		
		seleniumCore.waitForElementToBeVisible(getList, 30, 1);
		seleniumCore.click(getList, "click on get list button ", "");		
		customLogger("clicked on get list button ", "");		
	}
	
	public void validateGetListResult() {
		Assert.assertTrue("list is not displying for user name", seleniumCore.getText(By.cssSelector("#Table1")).contains("Account Cash Restriction or Removal"));		
		customLogger("list displayed for username ", "");
	}
	
}
