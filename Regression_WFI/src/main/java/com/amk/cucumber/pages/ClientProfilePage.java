package com.amk.cucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.amk.cucumber.utility.BasePage;
import com.amk.cucumber.utility.SeleniumCore;

public class ClientProfilePage extends BasePage {
	public ClientProfilePage(SeleniumCore seleniumCore) {
		super(seleniumCore);		
	}

	// Static Data
	// private static final String PAGE_NAME = "CLIENT ACCOUNTS PAGE";
	protected String StepName = "Selecting Client Type";
	protected String Visible_text = "Corporate";

	// Page Sections

	// Page Locators

	private final By Client_Type = By.xpath("//span[contains(text(),'Client Type')]");
	private final By Client_Type_values = By.xpath("(//*[@class='selector'])[2]");
	private final By Client_Type_values2 = By.xpath("//*[@id=\"ctl00_cphContentArea_ddlClientType\"]");

	// Static Data
	private static final String PAGE_NAME = "CLIENT PROFILE PAGE (Account wizard)";

	// Page Locators
	private static final By clientProfilePageLabel = By
			.xpath("/html//table[@id='PageTitleCommon']/tbody/tr/td[1]/table//tr/td[1]/span[@class='PageHeading']");
	private final By clientTypeDropdownOptions = By.xpath(
			"/html//div[@id='dvContent']/table[1]/tbody/tr/td/table[2]//table[@class='clientTypeSection']//div[@class='selector']/select[@name='ctl00$cphContentArea$ddlClientType']/option");
	private final By nextButton = By
			.xpath("/html//div[@id='dvContent']/table[2]//input[@name='ctl00$cphContentArea$btnNext']");

	// Locators - Client type
	private final By clientTypePersonal = By.cssSelector("[value='3400']");
	private final By clientTypeCorporate = By.cssSelector("[value='3401']");
	private final By clientTypeJointFamily = By.cssSelector("[value='3402']");
	private final By clientTypeDonorAdvisedFund = By.cssSelector("[value='3403']");

	// Locators - Names
	private final By firstName = By.cssSelector("#ctl00_cphContentArea_txtFirstName");
	private final By lastName = By.cssSelector("#ctl00_cphContentArea_txtLastName");
	private final By clientName = By.cssSelector("#ctl00_cphContentArea_txtClientName");

	// Locators - 1. Client's risk tolerance for this Portfolio
	private final By lowRiskTolerance = By.id("336");
	private final By moderateRiskTolerance = By.id("337");
	private final By highRiskTolerance = By.id("338");
	private final By veryHighRiskTolerance = By.id("339");

	// Locators - 2. Client's investment horizon
	private final By years2 = By.id("340");
	private final By years3to5 = By.id("341");
	private final By years6to9 = By.id("342");
	private final By years10plus = By.id("343");

	// Locators - 3. Percent of Client's total net worth that this Portfolio
	// represents
	private final By percentageOver75 = By.id("344");
	private final By percentage50to75 = By.id("345");
	private final By percentage25to50 = By.id("346");
	private final By percentageBelow25 = By.id("347");

	// Locators - Risk Return Profile
	private final By concervativeRiskReturn = By.id("ctl00_cphContentArea_radlstManual_0");
	private final By moderateConcervativeRiskReturn = By.id("ctl00_cphContentArea_radlstManual_1");
	private final By moderateRiskReturn = By.id("ctl00_cphContentArea_radlstManual_2");
	private final By moderateGrowthRiskReturn = By.id("ctl00_cphContentArea_radlstManual_3");
	private final By growthRiskReturn = By.id("ctl00_cphContentArea_radlstManual_4");
	private final By maximumGrowthRiskReturn = By.id("ctl00_cphContentArea_radlstManual_5");

	/**
	 * To construct the Client Profile Page
	 *
	 * @param seleniumCore
	 * @param pageVerification - Flag to check if the page is loaded or not
	 */
	public ClientProfilePage(SeleniumCore seleniumCore, boolean pageVerification) {
		super(seleniumCore);
		if (pageVerification) {
			if (seleniumCore.isElementVisible(clientProfilePageLabel)) {
				logger.info(PAGE_NAME + " verification" + SEPARATOR + PAGE_NAME + " verification is PASSED");
			} else {
				logger.warn(PAGE_NAME + " verification" + SEPARATOR + PAGE_NAME + " verification is FAILED");
			}
		}
	}

	public static By getLabel() {
		return clientProfilePageLabel;
	}

	public void selectClientType(String clientTypeData, String logMessage) {
		this.seleniumCore.waitForElementToBeVisible(clientTypeDropdownOptions);		
		By advisor1= By.cssSelector("select[name*='cphContentArea$ddlAgentID']");
		if(seleniumCore.getDriver().findElements(advisor1).size()!=0) {
		Select sel1= new Select(seleniumCore.findElement(advisor1));
		sel1.selectByIndex(1);
		waitForLoadingData();
		}		
		switch (clientTypeData) {
		case "Personal":
			this.seleniumCore.click(clientTypePersonal, logMessage, clientTypeData);
			logger.info("Select client type:" + clientTypeData);
			customLogger("Select client type: ", clientTypeData);
			break;
		case "Corporate":
			this.seleniumCore.click(clientTypeCorporate, logMessage, clientTypeData);
			logger.info("Select client type:" + clientTypeData);
			customLogger("Select client type: ", clientTypeData);
			break;
		case "Joint/Family":
			this.seleniumCore.click(clientTypeJointFamily, logMessage, clientTypeData);
			logger.info("Select client type:" + clientTypeData);
			customLogger("Select client type: ", clientTypeData);
			break;
		case "Donor Advised Fund":
			this.seleniumCore.click(clientTypeDonorAdvisedFund, logMessage, clientTypeData);
			logger.info("Select client type:" + clientTypeData);
			customLogger("Select client type: ", clientTypeData);
			break;
		}	
	}

	public String fillFullClientName(String clientTypeData, String stepName, String logMessage) {
		String nameData = "ATest_" + this.seleniumCore.generateRandomData(5);	
		String surnameData = "ATest_" + this.seleniumCore.generateRandomData(5);
		logger.info("Generated User Name:" + nameData);
		// Enter full client name
		if (clientTypeData.toLowerCase().trim().equals("personal")) {
			this.seleniumCore.sendKeys(firstName, nameData, stepName, logMessage);
			this.seleniumCore.sendKeys(lastName, surnameData, stepName, logMessage);
		}else if (clientTypeData.toLowerCase().trim().contains("donar advised")) {
			this.seleniumCore.sendKeys(firstName, nameData, stepName, logMessage);			
		}else {
			this.seleniumCore.waitForElementToBeFound(clientName);
			this.seleniumCore.sendKeys(clientName, nameData, stepName, logMessage);
		}
		System.out.println("name is " + surnameData + " " + nameData);
		return surnameData + ", " + nameData;
	}

	public void selectFiduciaryRole(String role, String stepName, String logMessage) {
		if(seleniumCore.isElementVisible(By.cssSelector("#ctl00_cphContentArea_lblFuduciaryRole"),1,1)) {		
		this.seleniumCore.click(By.xpath("//label[text()='" + role + "']"), stepName, logMessage);
		logger.info(stepName + " : " + logMessage);
		customLogger("Select fiduciary role: ", role);
		};
	}

	public void selectClientRiskTolerance(String clientTypeData, String riskToleranceData, String logMessage) {
		if (!clientTypeData.toLowerCase().trim().equals("donor advised fund")) {
			switch (riskToleranceData.trim().toLowerCase()) {
			case "low":
				logger.info(logMessage + " : " + clientTypeData);
				this.seleniumCore.waitForElementToBeFound(lowRiskTolerance).click();
				customLogger(logMessage, riskToleranceData);
				break;
			case "moderate":
				logger.info(logMessage + " : " + clientTypeData);
				this.seleniumCore.waitForElementToBeFound(moderateRiskTolerance).click();
				customLogger(logMessage, riskToleranceData);
				break;
			case "high":
				logger.info(logMessage + " : " + clientTypeData);
				this.seleniumCore.waitForElementToBeFound(highRiskTolerance).click();
				customLogger(logMessage, riskToleranceData);
				break;
			case "very high":
				logger.info(logMessage + " : " + clientTypeData);
				this.seleniumCore.waitForElementToBeFound(veryHighRiskTolerance).click();
				customLogger(logMessage, riskToleranceData);
				break;
			}
		}
	}

	public void selectClientInvestmentHorizon(String investmentHorizonData, String stepName) {
		logger.info(stepName);
		switch (investmentHorizonData.trim().toLowerCase()) {
		case "up to 2 years":
			this.seleniumCore.waitForElementToBeFound(years2).click();
			customLogger(stepName, investmentHorizonData);
			break;
		case "3 to 5 years":
			this.seleniumCore.waitForElementToBeFound(years3to5).click();
			customLogger(stepName, investmentHorizonData);
			break;
		case "6 to 9 years":
			this.seleniumCore.waitForElementToBeFound(years6to9).click();
			customLogger(stepName, investmentHorizonData);
			break;
		case "10 and more":
			this.seleniumCore.waitForElementToBeFound(years10plus).click();
			customLogger(stepName, investmentHorizonData);
			break;
		}
	}

	public void selectClientTotalNetWorth(String percentOfClientNetWorth, String stepName) {
		logger.info(stepName);
		switch (percentOfClientNetWorth) {
		case "<25":
			this.seleniumCore.waitForElementToBeFound(percentageBelow25).click();
			customLogger(stepName, percentOfClientNetWorth);
			break;
		case "25to50":
			this.seleniumCore.waitForElementToBeFound(percentage25to50).click();
			customLogger(stepName, percentOfClientNetWorth);
			break;
		case "50to75":
			this.seleniumCore.waitForElementToBeFound(percentage50to75).click();
			customLogger(stepName, percentOfClientNetWorth);
			break;
		case ">75":
			this.seleniumCore.waitForElementToBeFound(percentageOver75).click();
			customLogger(stepName, percentOfClientNetWorth);
			break;
		}
	}

	public void selectClientRiskProfile(String riskReturnProfileData, String stepName) {
		logger.info(stepName);
		switch (riskReturnProfileData) {
		case "Conservative":
			this.seleniumCore.waitForElementToBeFound(concervativeRiskReturn).click();
			customLogger(stepName, riskReturnProfileData);
			break;
		case "Moderate Conservative":
			this.seleniumCore.waitForElementToBeFound(moderateConcervativeRiskReturn).click();
			customLogger(stepName, riskReturnProfileData);
			break;
		case "Moderate":
			this.seleniumCore.waitForElementToBeFound(moderateRiskReturn).click();
			customLogger(stepName, riskReturnProfileData);
			break;
		case "Moderate Growth":
			this.seleniumCore.waitForElementToBeFound(moderateGrowthRiskReturn).click();
			customLogger(stepName, riskReturnProfileData);
			break;
		case "Growth":
			this.seleniumCore.waitForElementToBeFound(growthRiskReturn).click();
			customLogger(stepName, riskReturnProfileData);
			break;
		case "Maximum Growth":
			this.seleniumCore.waitForElementToBeFound(maximumGrowthRiskReturn).click();
			customLogger(stepName, riskReturnProfileData);
			break;
		}
	}

	public ConstructPortfolioPage confirmClient(String stepName, String logMessage) {
		logger.info(stepName + " : " + logMessage);
		this.seleniumCore.click(nextButton);
		customLogger(stepName+ " and "+logMessage, "");
		return new ConstructPortfolioPage(seleniumCore);
	}

	public PortfolioDetailsPage clickPortfolioDetailsTab() {
		seleniumCore.click(By.linkText("Portfolio Details"));
		return new PortfolioDetailsPage(seleniumCore);
	}

	public void fill_client_information() {
		this.seleniumCore.waitForElementToBeVisible(Client_Type);
		this.seleniumCore.click(Client_Type_values);
		System.out.println(this.seleniumCore.getTagName(Client_Type_values2));
		this.seleniumCore.selectByVisibleText(Client_Type_values2, Visible_text);

	}

}
