package com.amk.cucumber.pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.amk.cucumber.exceptions.DefaultException;
import com.amk.cucumber.utility.SeleniumCore;

public class AccountUpdateUtilityPage extends BawBasePage {

	private static final String PAGE_NAME = "Account update utility Page";	

	private By accountTextbox = By.cssSelector("input[id*=AccountNoOrAplID]");
	private By coachFrame = By.xpath("//iframe[@title='Coach']");
	private By goButton = By.cssSelector("button[id*=Button1]");
	private By taxManagementGUIDTextbox = By.cssSelector("input[id*=':TaxManagementGUID']");
	private By newTaxManagementGUIDTextbox = By.cssSelector("input[id*=':NewTaxManagementGUID']");
	private By enrollButton = By.cssSelector("button[id*='EnrollTaxManagement']");
	private By updateButton = By.cssSelector("button[id*='UpdateTaxManagement']");
	private By unenrollButton = By.cssSelector("button[id*='UnenrollTaxManagement']");
	private By alertMessage = By.cssSelector("[role='alert']");
	private By fundingAccountNoTextbox = By.cssSelector("input[id*=':FundingAccountNo']");
	private By fundingAccount = By.cssSelector("div[data-viewid='FundingAccountCell'][data-bpmids]");
	private By externalAccountNoTextbox = By.cssSelector("input[id*=':ExternalAccountNo']");
	
	public AccountUpdateUtilityPage(SeleniumCore seleniumCore) {
		this(seleniumCore, true);
	}

	public AccountUpdateUtilityPage(SeleniumCore seleniumCore, boolean pageVerification) {
		super(seleniumCore);
		if (pageVerification) {
			seleniumCore.switchToFrame(coachFrame, 10, 1);
			boolean isVisible = seleniumCore.isElementVisible(accountTextbox);
			if (isVisible) {
				this.seleniumCore.getLogger()
						.info(PAGE_NAME + " verification" + ":" + PAGE_NAME + " verification is PASSED");
			} else {
				this.seleniumCore.getLogger()
						.warn(PAGE_NAME + " verification" + ":" + PAGE_NAME + " verification is FAILED");
			}
		}
	}

	public void enterAccountNumber(String value) {	
		seleniumCore.sendKeys(accountTextbox, value);
		seleniumCore.click(goButton);
		logger.info("user search by account no and click on go button");
		customLogger("user search by account no and click on go button ", "");	
		seleniumCore.waitForJStoLoad();		
		waitForLoadingData();
	}	
	
	public void taxManagementSegment(String value, String option) {
		switch(option) {
		case "enroll":
			seleniumCore.sendKeys(taxManagementGUIDTextbox, value);
			seleniumCore.click(enrollButton);			
			logger.info("user enter tax management GUID and click on enroll button");
			customLogger("user enter tax management GUID and click on enroll button ", "");
			break;
		case "update":
			seleniumCore.click(updateButton);
			seleniumCore.sendKeys(newTaxManagementGUIDTextbox, value);
			seleniumCore.click(updateButton);			
			logger.info("user enter new tax management GUID and click on update button");
			customLogger("user enter new tax management GUID and click on update button ", "");
			break;	
		case "unenroll":
			seleniumCore.click(unenrollButton);
			seleniumCore.handleAlert("OK");			
			logger.info("user click on unenroll button");
			customLogger("user click on unenroll button ", "");
			break;	
		default:	
			logger.info("user does not do any operation in tax management section");
			customLogger("user does not do any operation in tax management section ", "");
		}		
	}
	
	public String validateAlert() {
		if(seleniumCore.isElementVisible(alertMessage, 15, 1)) {
			return seleniumCore.getText(alertMessage).toLowerCase();
		}else {
			throw new DefaultException("no tax management alert is present");
		}
	}
	
	public void enterFundingAccountNuber(String accountNumber) {
		seleniumCore.sendKeys(fundingAccountNoTextbox, accountNumber,"entering funding account number");
		seleniumCore.tabOut();
		waitForLoadingData();
		List<WebElement> elements= seleniumCore.findElements(By.xpath("//a[text()='Delete association']"));
		if(elements != null) {
			for(WebElement element : elements) {
				seleniumCore.jsClick(element, "delete already associated accounts");
				waitForLoadingData();
			}
		}
		Assert.assertEquals("funding account number is not matching", seleniumCore.getText(fundingAccount), accountNumber);
	}
	
	public void enterExternalAccountNuber(String accountNumber) {
		seleniumCore.sendKeys(externalAccountNoTextbox, accountNumber);
		seleniumCore.tabOut();
		waitForLoadingData();
		Assert.assertEquals("", seleniumCore.getText(fundingAccountNoTextbox), accountNumber);
	}
}
