package com.amk.cucumber.pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.amk.cucumber.exceptions.DefaultException;
import com.amk.cucumber.utility.BasePage;
import com.amk.cucumber.utility.SeleniumCore;

public class AccountSetupPage extends BasePage {

	// Static Data
	private static final String PAGE_NAME = "ACCOUNT SETUP PAGE";

	// Page Locators
	private static final By accountSetupPageLabel = By.cssSelector(".label-page");
	private final By addTrustee = By.cssSelector("[data-toggle='Hold_PeoplePicker_Multi_COUNT']");
	private final By addHolder = By.cssSelector("[data-toggle*='Hold_PeoplePicker']");
	private final By addNewLink = By.xpath("//*[contains(text(),'Add New')]");
	private final By existingAccount = By.xpath("//div[@class='popover-content custom-popover-content']/div[1]");	
	private final By addAddress = By.cssSelector("[data-toggle] [data-questionid*='Addr_0']");
	private final By saveAddress = By.xpath("//div[@class='modal-footer']//button[@data-save-address-url='/AccountSetup/Interview/AddAddressToDomain']");

	// Account details input fields locators
	private final By nameInput = By.cssSelector("input[name='Hold_Name_FIRSTNAME_0']");
	private final By middleNameInput = By.cssSelector("input[name='Hold_Name_MIDDLENAME_0']");
	private final By lastNameInput = By.cssSelector("input[name='Hold_Name_LASTNAME_0']");
	private final By birthDateInput = By.cssSelector("input[name='Hold_DOB_0']");
	private final By sSNInput = By.cssSelector("input[name='question.line.Questions[1].Hold_SSN_0']");
	private final By phoneInput = By.cssSelector("#question_line_Questions_0__Hold_Phone_0");
	private final By emailInput = By.cssSelector("#question_line_Questions_1__Hold_Email_0");
	private final By ssnTaxReporting = By.cssSelector("#line_Questions_0__Info_TaxNum");
	private final By address2Yrs = By.cssSelector("input[id*=Hold_PrevAddr_sect_No]");
	private final By employmentStatus = By.cssSelector("#question_line_Questions_0__Hold_Employ_Status_0_tab");
	private final By incomeSource = By.cssSelector("[name*='Hold_Employ_Inc_Source']");

	// Account location input fields
	private final By addressLineInput = By.cssSelector(".answer.col-xs-12 > input[name*='Addr_ADDRESS1_0_Modal']");
	private final By cityInput = By.cssSelector(".answer.col-xs-12 > input[name*='Addr_CITY_0_Modal']");
	private final By stateDropdown = By.cssSelector("div > input[name*='Addr_STATE_0_Modal_tab']");
	private final By zipInput = By.xpath("//input[contains(@name, 'Addr_ZIP_0_Modal')]");

	private final By optionsOfStates = By.cssSelector(".show-dropdown.styled-ddl > dd > a");
	private final By homeAddrVerificationLabel = By.id("Hold_HomeAddr_0_VerificationLabel");
	private final By verifyAddressModalSaveButton = By
			.xpath("//div[@class='modal fade in']//button[normalize-space()='Save']");
	private final By saveAccountButton = By.xpath("//button[contains(@class,'people-picker-save-button')]");
	private final By goToInformationPageButton = By.xpath("//button[@class='btn btn-next btn-default']  |   //button[@class='btn btn-next btn-primary']");
	private final By reviewAllAccounts = By.xpath("//button[contains(@data-url,'/AccountSetup/ReviewAllAccounts')]");
	private final By registrationTitle = By.xpath("//h1[@class='registration-name-title']");
	public final By goToFundingMethodPage = By.xpath("//button[@class='btn btn-primary btn-next']/span");	
	private final By trustedContact = By.cssSelector("[id*='Info_PAS_TrustedContact_N_tab']");
	private final By pershingAddress = By.cssSelector("[id*='Info_PAS_InformationSharing_N_tab']");
	private final By sourceFunds = By.cssSelector("[id*='Info_Fund_Meth_tab']");
	private final By donorSuccessionOption= By.cssSelector("#question_Donor_Succ_IABen_tab");
	private final By donorSuccessionAllocationPercentage = By.cssSelector("#question_Donor_Succ_IABen_Perc");
	private final By donorDirectingGrant = By.cssSelector("#line_Questions_0__Info_DAF_FAAuth_Full_tab");
	
	public AccountSetupPage(SeleniumCore seleniumCore) {
		this(seleniumCore, true);
	}

	public AccountSetupPage(SeleniumCore seleniumCore, boolean pageVerification) {
		super(seleniumCore);
		if (pageVerification) {
			if (seleniumCore.isElementVisible(accountSetupPageLabel)) {
				logger.info(PAGE_NAME + " verification" + " : " + PAGE_NAME + " verification is PASSED");
			} else {
				logger.warn(PAGE_NAME + " verification" + " : " + PAGE_NAME + " verification is FAILED");
			}
		}
	}

	public static By getLabel() {
		return accountSetupPageLabel;
	}

	public void clickAddNewAccount(String clientRegistrationType, String stepName) {
		if (clientRegistrationType.equals("Trust")) {
			this.seleniumCore.waitForElementToBeFound(addTrustee).click();
		} else {
			this.seleniumCore.waitForElementToBeClickable(addHolder,10,1).click();
		}
		logger.info(stepName + "");
		this.seleniumCore.waitForElementToBeClickable(addNewLink).click();
	}
	
	public void clickExistingAccount() {		
		this.seleniumCore.waitForElementToBeClickable(addHolder,10,1).click();		
		this.seleniumCore.waitForElementToBeClickable(existingAccount,5,1).click();
		logger.info("select existing account");
		customLogger("select existing account","");
		seleniumCore.waitForElementToBeClickable(saveAccountButton, 5, 1).click();
	}

	public void addAccount(String accountName, String accountMiddleName, String accountLastName,
			String accountBirthDate, String accountSSN, String stepName, String logMessage) {
		logger.info(stepName + "");
		this.seleniumCore.sendKeys(nameInput, accountName, logMessage, accountName);
		customLogger("enter first name: ",accountName);
		this.seleniumCore.sendKeys(middleNameInput, accountMiddleName, logMessage, accountName);
		customLogger("enter middle name: ",accountMiddleName);
		this.seleniumCore.sendKeys(lastNameInput, accountLastName, logMessage, accountLastName);
		customLogger("enter last name: ",accountLastName);
		this.seleniumCore.sendKeys(birthDateInput, accountBirthDate, logMessage, accountBirthDate);
		customLogger("enter dob: ",accountBirthDate);
		this.seleniumCore.sendKeys(sSNInput, accountSSN, logMessage, accountSSN);
		customLogger("enter SSN: ",accountSSN);
	}

	public void addAccountHomeAddress(String accountAddressLine, String accountCity, String accountState,
			String accountZip, String stepName, String logMessage) {
		logger.info(stepName + "");
		this.seleniumCore.waitForElementToBeFound(addAddress).click();
		if(seleniumCore.isElementVisible(addNewLink,1,1)) {
			this.seleniumCore.waitForElementToBeClickable(addNewLink).click();
		}
		this.seleniumCore.waitForElementToBeFound(addressLineInput);
		this.seleniumCore.sendKeys(addressLineInput, accountAddressLine, logMessage, accountAddressLine);
		customLogger("enter address line 1: ",accountAddressLine);
		this.seleniumCore.sendKeys(cityInput, accountCity, logMessage, accountCity);
		customLogger("enter city: ",accountCity);
		this.seleniumCore.waitForElementToBeClickable(stateDropdown,3,1);
		seleniumCore.jsClick(seleniumCore.findElement(stateDropdown), "", "");
		List<WebElement> listOfStates = this.seleniumCore.findElements(optionsOfStates);
		for (WebElement ele : listOfStates) {
			if (ele.getText().equals(accountState)) {
				ele.click();				
				break;
			}
		}
		this.seleniumCore.sendKeys(zipInput, accountZip, logMessage, accountZip);
		customLogger("enter zip: ",accountZip);
		this.seleniumCore.waitForElementToBeFound(saveAddress).click();
		customLogger("click on save button ","");
		this.seleniumCore.waitForElementToBeVisible(homeAddrVerificationLabel,3,1);
		this.seleniumCore.waitForElementToBeFound(verifyAddressModalSaveButton).click();
	}
	
	public void addCustodianInfo(String custodian) {
		if(custodian.toLowerCase().contains("pershing")) {
			seleniumCore.clickRadioButton(address2Yrs, "", "", 10, 1);
			waitForUILoading(1000);
			try {
				seleniumCore.jsClick(seleniumCore.findElement(employmentStatus), "");
			}catch(Exception e) {
				action.moveToElement(seleniumCore.findElement(employmentStatus)).click().build().perform();
			}			
			if(seleniumCore.isElementVisible(By.cssSelector("[class*='show-dropdown']"),5,1)) {
				seleniumCore.click(By.cssSelector("a[data-value='Hold_Employ_Status_Ret_0']"));
				logger.info("select employment status as Retired");
				customLogger("select employment status as Retired ","");
			}else {
				throw new DefaultException("employee status is not expanded");
			}
		}	else if(custodian.toLowerCase().contains("fidelity")) {			
			waitForUILoading(1000);
			try {
				seleniumCore.jsClick(seleniumCore.findElement(employmentStatus), "");
			}catch(Exception e) {
				action.moveToElement(seleniumCore.findElement(employmentStatus)).click().build().perform();
			}
			if(seleniumCore.isElementVisible(By.cssSelector("[class*='show-dropdown']"),5,1)) {
				seleniumCore.click(By.cssSelector("a[data-value='Hold_Employ_Status_Ret_0']"));
				logger.info("select employment status as Retired");
				customLogger("select employment status as Retired ","");
				seleniumCore.sendKeys(incomeSource, "abc", "");
			}else {
				throw new DefaultException("employee status is not expanded");
			}
		}	else {
			logger.info("custodian text box is not present");
		}
	}

	public void clickModalSaveBtn() {
		seleniumCore.waitForElementToBeFound(verifyAddressModalSaveButton).click();
	}

	public void saveAccount(String stepName, String logMessage) {
		logger.info(stepName + " : " + logMessage);
		this.seleniumCore.waitForElementToBeVisible(saveAccountButton).click();
		customLogger(logMessage,"");
	}

	public void goToInformationPage(String stepName, String logMessage) {		
		this.seleniumCore.click(goToInformationPageButton, stepName, logMessage);
		customLogger(logMessage,"");
	}

	public PortfolioDetailsPage clickPortfolioDetailsTab() {
		seleniumCore.click(By.linkText("Portfolio Details"));
		return new PortfolioDetailsPage(seleniumCore);
	}

	public void addPhoneAndEmail(String phone, String email) {
		this.seleniumCore.sendKeys(phoneInput, phone, "Add phone number", phone);
		customLogger("enter phone number: ", phone);
		this.seleniumCore.sendKeys(emailInput, email, "Add e-mail", email);
		customLogger("enter e-mail: ", email);
	}

	public void addSSNTaxReporting(String ssn) {
		this.seleniumCore.sendKeys(ssnTaxReporting, ssn, "Add ssn tax reporting", ssn);
		logger.info("ssn has been entered");
		customLogger("ssn has been entered ", ssn);
	}

	public ReviewAllAccountsPage reviewAllAccounts(String stepName, String logMessage) {
		waitForLoadingData();
		this.seleniumCore.waitForElementToBeVisible(reviewAllAccounts);
		this.seleniumCore.click(reviewAllAccounts, stepName, logMessage);
		customLogger(logMessage, "");
		return new ReviewAllAccountsPage(seleniumCore);
	}
	
	public void expandRespectiveClient(String clientType) {
		WebElement client= seleniumCore.findElement(By.xpath("(//ul[@class='nav navbar-nav white-background']/li/a[text()='"+clientType+"'])[last()]"));		
		WebElement client2=	client.findElement(By.xpath("(//ul[@class='nav navbar-nav white-background']/li/a[text()='"+clientType+"'])[last()]/following-sibling::span"));
		if(client2.getAttribute("aria-expanded").equals("false")){
			client.click();
		}
		Assert.assertTrue("", seleniumCore.getText(registrationTitle).contains(clientType));		
	}

	public void goToAccountFeaturesPage(String stepName, String logMessage) {
		logger.info(stepName + " : " + logMessage);
		this.seleniumCore.waitForElementToBeFound(goToFundingMethodPage).click();
		customLogger(logMessage, "");
	}
	
	public void accountAdditionalInfo(String custodian) {
		seleniumCore.waitForJStoLoad();
		waitForLoadingData();
		if(custodian.toLowerCase().contains("pershing")) {
			seleniumCore.click(trustedContact);
			seleniumCore.click(pershingAddress);
			/*
			 * seleniumCore.scrollPageHeight(); seleniumCore.click(sourceFunds);
			 * seleniumCore.scrollPageHeight(); seleniumCore.click(sourceFunds);
			 */
			waitForUILoading(1000);
			try {
				seleniumCore.jsClick(seleniumCore.findElement(sourceFunds), "");
			}catch(Exception e) {
				action.moveToElement(seleniumCore.findElement(sourceFunds)).click().build().perform();
			}
			if(seleniumCore.isElementVisible(By.cssSelector("[class*='show-dropdown']"),5,1)) {
				seleniumCore.click(By.cssSelector("a[data-value='Info_Fund_Meth_Gift']"));
				logger.info("select source fund as Gift");
				customLogger("select source fund as Gift","");
			}else {
				throw new DefaultException("source gift is not expanded"); 
			}
	//		seleniumCore.click(interviewSaveButton);
		}
	}
	
	public FundingMethodPage goToFundingMethodPage(String stepName, String logMessage) {
		logger.info(stepName + " : " + logMessage);
		seleniumCore.waitForJStoLoad();
		waitForLoadingData();
		this.seleniumCore.waitForElementToBeFound(By.xpath("//button[@class='btn btn-primary btn-next']/span"),20,1).click();
		customLogger(logMessage, "");
		return new FundingMethodPage(seleniumCore);
	}
	
	public void beneficiaries(String stepName) {
		seleniumCore.waitForJStoLoad();		
		seleniumCore.waitForUILoading(3000);
		this.seleniumCore.waitForElementToBeFound(By.xpath("//span[contains(text(),'Beneficiaries')]/.."),20,1).click();
		customLogger(stepName, "");
	}
	
	public void clickTMSButton() {
		seleniumCore.waitForElementToBeFound(By.xpath("//button[@class='btn btn-primary btn-next']/span"),20,1).click();
		logger.info("click on tax management services button");
		customLogger("click on tax management services button", "");
		seleniumCore.waitForJStoLoad();
		waitForLoadingData();
		seleniumCore.waitForElementToBeFound(By.xpath("//button[@class='btn btn-primary btn-next']/span"),20,1).click();
	}
	
	public void donorSuccessionPlan() {
		seleniumCore.clickRadioButton(donorSuccessionOption, "", "");
		seleniumCore.sendKeys(donorSuccessionAllocationPercentage, "5");
		logger.info("enter donor allocation percentage");
		customLogger("enter donor allocation percentage", "");
		seleniumCore.waitForElementToBeFound(By.xpath("//button[@class='btn btn-primary btn-next']/span"),20,1).click();
		waitForLoadingData();
	}
	
	public void givingFundInfo() {
		seleniumCore.clickRadioButton(donorDirectingGrant, "", "");		
		logger.info("choose donor directing grant");
		customLogger("choose donor directing grant", "");
		seleniumCore.waitForElementToBeFound(By.xpath("//button[@class='btn btn-primary btn-next']"),20,1).click();
		seleniumCore.waitForElementToBeFound(By.xpath("//button[@class='btn btn-primary btn-next']"),20,1).click();		
	}
}
