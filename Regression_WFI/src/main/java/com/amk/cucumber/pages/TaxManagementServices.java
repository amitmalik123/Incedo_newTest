package com.amk.cucumber.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import com.amk.cucumber.utility.BasePage;
import com.amk.cucumber.utility.SeleniumCore;

public class TaxManagementServices extends BasePage {
	private final By taxSensitivity = By.id("medium");
	private final By continueButton = By.cssSelector("#Continue");
	private final By addCustomizations = By.id("addCustomizations");
	private final By textField = By.cssSelector("input[class]:not([disabled])");
	private final By applyButton = By.xpath("//button[text()='APPLY']");
	private final By securitiesRestriction = By.xpath("//div[text()='SECURITIES RESTRICTION']");
	private final By dnb = By.cssSelector("[class='sc-kJwmPe kSanfL']");
	private final By gicsIndustry = By.xpath("//div[text()='GICS INDUSTRY RESTRICTION']");
	private final By finance = By.xpath("//div[text()='Financials']");
	private final By banks = By.xpath("//div[text()='Regional Banks']");
	private final By diversifiedFinancials = By.xpath("//div[text()='Consumer Finance']");
	private final By insurance = By.xpath("//div[text()='Reinsurance']");
	private final By annualGain = By.xpath("//div[text()='ANNUAL REALIZED GAIN BUDGET']");
	private final By noShortTermBudget = By.xpath("//span[text()='No Short Term Budget']/preceding-sibling::img");
	private final By saveCustomizations = By.xpath("//button[text()='SAVE CUSTOMIZATIONS']");
	private final By yesButton = By.xpath("//button[text()='Yes']");
	
	public TaxManagementServices(SeleniumCore seleniumCore) {
		this(seleniumCore, true);
	}

	private static final String PAGE_NAME = "TAX MANAGEMENT SERVICES PAGE";

	public TaxManagementServices(SeleniumCore seleniumCore, boolean pageVerification) {
		super(seleniumCore);
		if (pageVerification) {
			if (seleniumCore.doesUrlContainText("taxmanagement", 10, 1)) {
				waitForLoadingData();
				logger.info(PAGE_NAME + " verification" + SEPARATOR + PAGE_NAME + " verification is PASSED");
				customLogger(" verification is PASSED ", "");
			} else {
				customLogger(" verification is FAILED ", "");
				throw new RuntimeException(PAGE_NAME + " verification is FAILED");
			}
		}
	}

	public void selectTaxSensitivity(String option) {
		waitForLoadingData();
		if(option.equalsIgnoreCase("medium")) {
		By taxSensitivity = By.id("medium");
		seleniumCore.clickRadioButton(taxSensitivity, "select tax sensitivity", "");
		customLogger("select tax sensitivity", "");
		seleniumCore.click(addCustomizations);
		}else {
			By taxSensitivity = By.id("low");
			seleniumCore.clickRadioButton(taxSensitivity, "select tax sensitivity", "");
			customLogger("select tax sensitivity", "");			
		}
		waitForLoadingData();
		customLogger("click customizations link", "");
	}	
	
	public void addCustomizations() {
		Assert.assertTrue(seleniumCore.isElementVisible(securitiesRestriction));
		seleniumCore.sendKeys(textField, "100");
		logger.info("add cash as 100");
		customLogger("add cash as 100", "");
		applyButton();
		securitiesRestriction();
		industryRestriction();
		annualRealizedGain();		
	}
	
	public void applyButton() {
		seleniumCore.click(applyButton);
		logger.info("click apply buttonL");
		customLogger("click apply button", "");
	}
	
	public void securitiesRestriction() {
		seleniumCore.click(securitiesRestriction);
		seleniumCore.sendKeys(textField, "AAPL");
		logger.info("add ticker as AAPL");
		customLogger("add ticker as AAPL", "");
		seleniumCore.clickRadioButton(dnb, "select do not buy option", "");
		customLogger("select do not buy option", "");
		applyButton();
	}
	
	public void industryRestriction() {
		seleniumCore.click(gicsIndustry);
		waitForLoadingData();
		seleniumCore.click(finance);
		seleniumCore.waitForUILoading(500);
		seleniumCore.click(banks);
		seleniumCore.waitForUILoading(500);
		seleniumCore.click(diversifiedFinancials);
		seleniumCore.waitForUILoading(500);
		seleniumCore.click(insurance);
		logger.info("add data on gics industry restriction tab");
		customLogger("add data on gics industry restriction tab", "");		
	}
	
	public void annualRealizedGain() {
		seleniumCore.click(annualGain);
		seleniumCore.click(noShortTermBudget);
		logger.info("click on No Short Term Budget");
		customLogger("click on No Short Term Budget", "");	
		seleniumCore.sendKeys(textField, "10000");
		applyButton();
	}
	
	public void clickSaveCustomizations() {
		seleniumCore.click(saveCustomizations);
		logger.info("click on save customizations button");
		customLogger("click on save customizations button", "");
	}
	
	public DocuSignPage clickContinueButton(String option) {
		waitForLoadingData();
		seleniumCore.click(continueButton);
		logger.info("click on continue button");
		customLogger("click on continue button", "");
		if(option.equalsIgnoreCase("medium")) {
		seleniumCore.click(yesButton);
		}
		return new DocuSignPage(seleniumCore);	
	}
	
}	