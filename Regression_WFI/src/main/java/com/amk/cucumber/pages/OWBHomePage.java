package com.amk.cucumber.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebElement;

import com.amk.cucumber.utility.CommonMethods;
import com.amk.cucumber.utility.SeleniumCore;

public class OWBHomePage extends CommonMethods {

	// Static Data
	private static final String PAGE_NAME = "OWB HOME PAGE";

	// Page Locators
	private final By loginButton = By.xpath("//a[text()='Log in']");
	private final By username = By.cssSelector("[type='email']");
	private final By password = By.cssSelector("[type='password']");
	private final By signIn = By.xpath("//*[@type='submit'  and     contains(@id,'id')]");	
	private final By bNumber = By.cssSelector("#externalId");
	private final By search = By.cssSelector("#btnSearch");
	private final By viewLink = By.xpath("//button[text()='View']");
	private final By status = By.xpath("//label[text()='Status']/following-sibling::select");
	private final By saveButton = By.xpath("//button[@type='submit']    |    //button[contains(text(),'Save')]");
	private final By checkNumber = By.xpath("//button[text()='View']/parent::td/following-sibling::td[2]");
	private final By digitalDeposit = By.xpath("//div[text()='AssetMark']/ancestor::div[@class='card checkSummaryCard']//a[text()='Ready for Deposit - Digital']");
	private final By approvedDate = By.xpath("//*[text()='Approved Date']");
	private final By startBatch = By.xpath("//*[text()='Start Batch']");
	private final By depositButton = By.xpath("//button[text()='Deposit']");
	private final By markDeposit = By.xpath("//button[text()='Mark as Deposited']");
	private final By markDepositModal = By.xpath("//button[text()='Yes']");
	private final By finalStatus = By.xpath("//tbody/tr/td[7]");
	private final By addNewFirm = By.xpath("//button[contains(text(),'Add New Firm')]");
	private final By firmDetailsName = By.xpath("//span[text()='Name']/following-sibling::input");
	private final By firmACAT = By.xpath("//div[./span[contains(text(),'Is Firm ACAT')]]//span[text()='No']/preceding-sibling::input");
	private final By firmLiquidation = By.xpath("//div[./span[contains(text(),'Liquidation eSignature')]]//span[text()='No']/preceding-sibling::input");
	private final By firmInternal = By.xpath("//div[./span[contains(text(),'Internal')]]//span[text()='Active']/preceding-sibling::input");
	private final By firmExternal = By.xpath("//div[./span[contains(text(),'External')]]//span[text()='Active']/preceding-sibling::input");
	private final By firmType = By.xpath("//span[contains(text(),'Type')]/following-sibling::select");
	private final By moneyInAddNew = By.xpath("//div[./*[contains(text(),'Submission')]]/following-sibling::div//button[contains(text(),'Add New')]");
	private final By moneyInAddFax = By.xpath("//div[./*[contains(text(),'Submission')]]/following-sibling::div//a[2]");
	private final By moneyInPayeeName = By.xpath("//div[./div/span[contains(text(),'Money In')]]/following-sibling::div//span[contains(text(),'Payee Name 1')]/following-sibling::input");
	private final By moneyInAddress = By.xpath("//div[./div/span[contains(text(),'Money In')]]/following-sibling::div//span[contains(text(),'Address 1')]/following-sibling::input");
	private final By moneyInCity = By.xpath("//div[./div/span[contains(text(),'Money In')]]/following-sibling::div//span[contains(text(),'City')]/following-sibling::input");
	private final By moneyInState = By.xpath("//div[./div/span[contains(text(),'Money In')]]/following-sibling::div//span[contains(text(),'State')]/following-sibling::select");
	private final By moneyInZip5 = By.xpath("//div[./div/span[contains(text(),'Money In')]]/following-sibling::div//span[contains(text(),'Zip5')]/following-sibling::input");
	private final By moneyInZip4 = By.xpath("//div[./div/span[contains(text(),'Money In')]]/following-sibling::div//span[contains(text(),'Zip4')]/following-sibling::input");
	private final By moneyInVerifyUSPS = By.xpath("//div[./div/span[contains(text(),'Money In')]]/following-sibling::div//button[contains(text(),'Verify')]");
	private final By firmClearingFirms = By.xpath("//div[./span[contains(text(),'Clearing Firms')]]//select");
	private final By firmClearingPlusSignButton = By.xpath("//div[./span[text()='Clearing Firms']]//button");
	private final By subMethod = By.xpath("//div[./label[contains(text(),'Regular Mail')]]/input");
	private final By followPhone = By.xpath("//div[./label[contains(text(),'Phone')]]/input");
	private final By followEmail = By.xpath("//div[./*[contains(text(),'Follow up method')]]//label[contains(text(),'Email')]/preceding-sibling::input");
	private final By followAddNew = By.xpath("//div[./div/span[contains(text(),'Follow')]]/following-sibling::div//button[contains(text(),'Add New')]");
	private final By followPhoneTextbox = By.xpath("//div[./span[contains(text(),'Phone')]]/following-sibling::div//input");
	private final By followEmailTextbox = By.xpath("//div[./span[contains(text(),'Email')]]/following-sibling::div//input");
	private final By outAddNew = By.xpath("//div[./div/span[contains(text(),'Out')]]/following-sibling::div//button[contains(text(),'Add New')]");
	private final By outAddress = By.xpath("//div[./div/span[contains(text(),'Out')]]/following-sibling::div//button[contains(text(),'Add New')]/following-sibling::div/a[1]");
	private final By outWire = By.xpath("//div[./div/span[contains(text(),'Out')]]/following-sibling::div//button[contains(text(),'Add New')]/following-sibling::div/a[2]");
	private final By outACH = By.xpath("//div[./div/span[contains(text(),'Out')]]/following-sibling::div//button[contains(text(),'Add New')]/following-sibling::div/a[3]");
	private final By moneyOutPayeeName = By.xpath("//div[./div/span[contains(text(),'Money Out')]]/following-sibling::div//span[contains(text(),'Payee Name 1')]/following-sibling::input");
	private final By moneyOutAddress = By.xpath("//div[./div/span[contains(text(),'Money Out')]]/following-sibling::div//span[contains(text(),'Address 1')]/following-sibling::input");
	private final By moneyOutCity = By.xpath("//div[./div/span[contains(text(),'Money Out')]]/following-sibling::div//span[contains(text(),'City')]/following-sibling::input");
	private final By moneyOutState = By.xpath("//div[./div/span[contains(text(),'Money Out')]]/following-sibling::div//span[contains(text(),'State')]/following-sibling::select");
	private final By moneyOutZip5 = By.xpath("//div[./div/span[contains(text(),'Money Out')]]/following-sibling::div//span[contains(text(),'Zip5')]/following-sibling::input");
	private final By moneyOutZip4 = By.xpath("//div[./div/span[contains(text(),'Money Out')]]/following-sibling::div//span[contains(text(),'Zip4')]/following-sibling::input");
	private final By moneyOutVerifyUSPS = By.xpath("//div[./div/span[contains(text(),'Money Out')]]/following-sibling::div//button[contains(text(),'Verify')]");
	private final By searchFirm = By.cssSelector("[placeholder='Enter Firm Name']");
	private final By searchFirmButton = By.cssSelector("[placeholder='Enter Firm Name']+button");	
	private final By moneyOutABARouting = By.xpath("//div[./div/span[contains(text(),'Money Out')]]/following-sibling::div//span[contains(text(),'ABA Routing')]/following-sibling::input");
	private final By moneyOutBankAccount = By.xpath("//div[./div/span[contains(text(),'Money Out')]]/following-sibling::div//span[contains(text(),'Bank Account')]/following-sibling::input");
	private final By moneyOutBankAccountName = By.xpath("//div[./div/span[contains(text(),'Money Out')]]/following-sibling::div//span[contains(text(),'Bank Account Name')]/following-sibling::input");
	private final By moneyOutFFCName = By.xpath("//div[./div/span[contains(text(),'Money Out')]]/following-sibling::div//span[contains(text(),'FFC Name')]/following-sibling::input");
	private final By moneyOutFFCAccount = By.xpath("//div[./div/span[contains(text(),'Money Out')]]/following-sibling::div//span[contains(text(),'FFC Account')]/following-sibling::input");
	private final By moneyOutABARoutingACH = By.xpath("//div[./span[contains(text(),'ACH Instructions')]]/following-sibling::div//span[contains(text(),'ABA Routing')]/following-sibling::input");
	private final By moneyOutBankAccountACH = By.xpath("//div[./span[contains(text(),'ACH Instructions')]]/following-sibling::div//span[contains(text(),'Bank Account')]/following-sibling::input");
	private final By moneyOutBankAccountNameACH = By.xpath("//div[./span[contains(text(),'ACH Instructions')]]/following-sibling::div//span[contains(text(),'Bank Account Name')]/following-sibling::input");
		
	public OWBHomePage(SeleniumCore seleniumCore) {
		this(seleniumCore, true);
	}

	public OWBHomePage(SeleniumCore seleniumCore, boolean pageVerification) {
		super(seleniumCore);
		if (pageVerification) {
			waitForSpinnerToBeDisappear();
			if (seleniumCore.isElementVisible(loginButton)) {
				logger.info(PAGE_NAME + " verification" + " : " + PAGE_NAME + " verification is PASSED");
			} else {
				logger.warn(PAGE_NAME + " verification" + " : " + PAGE_NAME + " verification is FAILED");
			}
		}
	}

	public void clickAddNewFirm() {
		seleniumCore.click(addNewFirm);
		logger.info("click on add new frm button");
		customLogger("click on add new frm button", "");
	}
	
	public String enterFirmDetails() {
		String name= "Test_"+seleniumCore.generateRandomData(8);
		seleniumCore.sendKeys(firmDetailsName, name);
		seleniumCore.clickRadioButton(firmACAT, "", "");
		seleniumCore.clickRadioButton(firmLiquidation, "", "");
		seleniumCore.clickRadioButton(firmInternal, "", "");
		seleniumCore.clickRadioButton(firmExternal, "", "");
		seleniumCore.selectByValue(firmType, "MutualFund","","",2,1);
		logger.info("created contra firm name is "+ name);
		customLogger("created contra firm name is ", name);
		return name;
	}
	
	public void enterMoneyInDetails() {
		seleniumCore.sendKeys(moneyInPayeeName, seleniumCore.generateRandomData(5));
		seleniumCore.sendKeys(moneyInAddress, "10150 MEANLEY DR FL 1");
		seleniumCore.sendKeys(moneyInCity, "San diego");
		seleniumCore.selectByValue(moneyInState, "CA");
		seleniumCore.sendKeys(moneyInZip5, "92131");
		seleniumCore.sendKeys(moneyInZip4, "3008");
		seleniumCore.click(moneyInVerifyUSPS);
		waitForLoadingData();	
		waitForLoadingDataOWB();
//		String backgroundColor= seleniumCore.getDriver().findElement(moneyInVerifyUSPS).getCssValue("background-color");
//		String bg= seleniumCore.convertRGBAtoHexidecimal(backgroundColor);
//		Assert.assertEquals("verify with usps button background color is not as expected", "#4caf50", bg);
	}
	
	public void enterClearingFirms() {
		seleniumCore.waitForJStoLoad();
		waitForLoadingData();
		waitForLoadingDataOWB();
		seleniumCore.waitForElementToBeVisible(firmClearingFirms, 20, 1);
		seleniumCore.selectByVisibleText(firmClearingFirms, "0019 - VINA LLC");
		seleniumCore.click(firmClearingPlusSignButton);
		logger.info("select clearing firm");
		customLogger("select clearing firm", "");
	}
	
	public void clickLoginButton(String stepName, String logMessage) {
		seleniumCore.waitForElementToBeClickable(loginButton, 10, 1);
		this.seleniumCore.click(loginButton, stepName, logMessage);
		seleniumCore.waitForJStoLoad();
	//	waitForLoadingData();
		customLogger("Successfully clicked on " + logMessage, "");
	}
		
	public void loginOWB() {
		seleniumCore.waitForElementToBeClickable(username, 20, 1);
		seleniumCore.sendKeys(username, "Madhan.Kumar@assetmark.com");
		logger.info("enter username");
		customLogger("enter username ", "");
		seleniumCore.click(signIn);
		seleniumCore.waitForJStoLoad();
//		waitForLoadingData();
		seleniumCore.waitForElementToBeClickable(password, 20, 1);			
		seleniumCore.sendKeys(password, "Change@99522");
		logger.info("enter password");
		customLogger("enter password ", "");
		seleniumCore.waitForJStoLoad();
//		waitForLoadingData();
		seleniumCore.waitForElementToBeClickable(signIn, 20, 1);
		seleniumCore.click(signIn);		
		seleniumCore.waitForJStoLoad();
//		waitForLoadingData();
		if(seleniumCore.isElementVisible(signIn,10,1)) {
			seleniumCore.click(signIn);
		}
		logger.info("login to OWB application");
		customLogger("login to OWB application ", "");
	}
	
	public void clickCheckManagement(String tab) {
		By checkManagementTab = By.xpath("//span[contains(text(),'"+tab+"')]");
		seleniumCore.waitForElementToBeVisible(checkManagementTab, 60, 1);
		seleniumCore.scrollIntoView(seleniumCore.findElement(checkManagementTab));
		try {
		seleniumCore.click(checkManagementTab,"","",20,1);
		}catch(Exception e) {
			seleniumCore.jsClick(seleniumCore.findElement(checkManagementTab), "", "");
		}
		logger.info("click on tab "+ tab);
		customLogger("click on tab ", tab);
	}
	
	public void searchBNumber(String bNum) {
		seleniumCore.waitForElementToBeClickable(bNumber, 20, 1);
		seleniumCore.sendKeys(bNumber, bNum);
		logger.info("search for B number");
		customLogger("search for B number ", bNum);
		seleniumCore.tabOut();
		seleniumCore.waitForElementToBeClickable(search, 20, 1);
		seleniumCore.click(search);	
		logger.info("click on search button");
		customLogger("click on search button", "");
	}
	
	public void clickViewLink() {
		waitForLoadingData();
		waitForLoadingDataOWB();
		seleniumCore.waitForElementToBeVisible(viewLink, 60, 1);
		this.seleniumCore.click(viewLink);
		logger.info("click on view link");
		customLogger("click on view link ", "");
	}
	
	public void selectStatus() {
		seleniumCore.waitForJStoLoad();
		waitForLoadingData();
		waitForLoadingDataOWB();
		seleniumCore.waitForElementToBeVisible(status, 60, 1);
		seleniumCore.selectByValue(status, "ReadyForDepositToBank");
		logger.info("select status as ReadyForDepositToBank");
		customLogger("select status as ReadyForDepositToBank ", "");		
	}
	
	public void clickSaveButton() {
//		seleniumCore.click(saveButton);
		seleniumCore.scrollIntoView(seleniumCore.findElement(saveButton));
		seleniumCore.jsClick(seleniumCore.findElement(saveButton), "");
		logger.info("click on save button");
		customLogger("click on save button ", "");
		waitForLoadingData();
		waitForLoadingDataOWB();
	}
	
	public String fetchCheckNumber() {
		seleniumCore.waitForElementToBeVisible(checkNumber, 40, 1);
		String number= seleniumCore.getText(checkNumber);
		logger.info("fetch check number "+ number);
		customLogger("fetch check number ", number);
		return number;
	}
	
	public void clickDigitalDepositLink() {
		seleniumCore.waitForElementToBeVisible(digitalDeposit, 10, 1);
		this.seleniumCore.click(digitalDeposit);
		logger.info("click on digital deposit link");
		customLogger("click on digital deposit link ", "");
	}
	
	public List<String> validateCheckNumber() {
		seleniumCore.waitForElementToBeVisible(approvedDate, 20, 1);
		seleniumCore.click(approvedDate);
		seleniumCore.waitForUILoading(1000);
		seleniumCore.click(approvedDate);
		seleniumCore.waitForUILoading(2000);
		List<WebElement> checkNumbers= seleniumCore.findElements(By.xpath("//tbody/tr/td[5]"));
		List<String> values= checkNumbers.stream().map(e-> e.getText()).collect(Collectors.toList());
		return values;
	}
	
	public void startBatch(String checkNum) {
		WebElement checkbox= seleniumCore.findElement(By.xpath("//*[text()='"+checkNum+"']/preceding-sibling::td/label"));
		checkbox.click();
		seleniumCore.waitForUILoading(2000);
		if(seleniumCore.findElement(startBatch).isEnabled()) {
			seleniumCore.click(startBatch);
		}else {
			throw new ElementNotInteractableException("element is not enabled");
		}
		logger.info("click on start batch button");
		customLogger("click on start batch button ", "");
	}
	
	public void clickDeposit() {
		seleniumCore.waitForElementToBeVisible(depositButton, 60, 1);
		this.seleniumCore.click(depositButton);
		logger.info("click on deposit button");
		customLogger("click on deposit button ", "");
	}
	
	public void clickMarkDeposit() {
		seleniumCore.waitForJStoLoad();
		seleniumCore.waitForElementToBeClickable(markDeposit, 60, 1);
		this.seleniumCore.click(markDeposit);
		seleniumCore.getDriver().switchTo().activeElement();
		seleniumCore.waitForElementToBeVisible(markDepositModal, 10, 1);
		this.seleniumCore.click(markDepositModal);
		logger.info("click on mark deposit button");
		customLogger("click on mark deposit button ", "");
	}
	
	public String validateStatus() {
		seleniumCore.waitForElementToBeVisible(finalStatus, 60, 1);
		return seleniumCore.getText(finalStatus);
	}
	
	public void expandTab(String tab) {
		By checkManagementTab = By.xpath("//div[./div/span[contains(text(),'"+tab+"')]]");
		String style = seleniumCore.getAttribute(checkManagementTab, "style");
		if(style.contains("transparent"))
			seleniumCore.click(checkManagementTab);
	}
	
	public void submissionMethod() {
		seleniumCore.jsClick(seleniumCore.findElement(subMethod), "");
		seleniumCore.waitForUILoading(500);
		logger.info("click on regular mail checkbox");
		customLogger("click on regular mail checkbox ", "");
	}
	
	public void enterFollowUpDetails() {
		seleniumCore.scrollIntoView(seleniumCore.findElement(followPhone));
		seleniumCore.jsClick(seleniumCore.findElement(followPhone), "");
		seleniumCore.waitForUILoading(500);
		seleniumCore.jsClick(seleniumCore.findElement(followEmail), "");
		seleniumCore.click(followAddNew);
		seleniumCore.click(By.xpath("//div[./div/span[contains(text(),'Follow')]]/following-sibling::div//a[1]"));
		seleniumCore.click(followAddNew);
		seleniumCore.click(By.xpath("//div[./div/span[contains(text(),'Follow')]]/following-sibling::div//a[2]"));
		seleniumCore.sendKeys(followPhoneTextbox, "8565436543");
		seleniumCore.sendKeys(followEmailTextbox, "a@as.com");
		logger.info("enter data in all follow up fields");
		customLogger("enter data in all follow up fields ", "");
	}
	
	public void enterMoneyOutDetails() {		
		moneyOutAddress();
		wireInstructions();
		achInstructions();
	}
	
	public void moneyOutAddress() {
		seleniumCore.click(outAddNew);
		seleniumCore.click(outAddress);
		seleniumCore.sendKeys(moneyOutPayeeName, seleniumCore.generateRandomData(5));
		seleniumCore.sendKeys(moneyOutAddress, "10150 MEANLEY DR FL 1");
		seleniumCore.sendKeys(moneyOutCity, "San diego");
		seleniumCore.selectByValue(moneyOutState, "CA");
		seleniumCore.sendKeys(moneyOutZip5, "92131");
		seleniumCore.sendKeys(moneyOutZip4, "3008");
		String backgroundColorBefore = seleniumCore.getDriver().findElement(moneyOutVerifyUSPS).getCssValue("background-color");
		String bg= seleniumCore.convertRGBAtoHexidecimal(backgroundColorBefore);
		Assert.assertEquals("verify with usps button background color is not as expected", "#f44336", bg);
		seleniumCore.click(moneyOutVerifyUSPS);
		waitForLoadingData();
		waitForLoadingDataOWB();
//		String backgroundColor= seleniumCore.getDriver().findElement(moneyOutVerifyUSPS).getCssValue("background-color");
//		String bgAfter = seleniumCore.convertRGBAtoHexidecimal(backgroundColor);
//		Assert.assertEquals("verify with usps button background color is not as expected", "#4caf50", bgAfter);
	}
	
	public void wireInstructions() {
		seleniumCore.click(outAddNew);
		seleniumCore.click(outWire);
		seleniumCore.sendKeys(moneyOutABARouting, "073904887");
		seleniumCore.sendKeys(moneyOutBankAccount, "876786879");
		seleniumCore.sendKeys(moneyOutBankAccountName, "CA");
		seleniumCore.sendKeys(moneyOutFFCName, "92131");
		seleniumCore.sendKeys(moneyOutFFCAccount, "3008");		
	}
	
	public void achInstructions() {
		seleniumCore.click(outAddNew);
		seleniumCore.click(outACH);
		seleniumCore.sendKeys(moneyOutABARoutingACH, "054000807");
		seleniumCore.sendKeys(moneyOutBankAccountACH, "876786879");
		seleniumCore.sendKeys(moneyOutBankAccountNameACH, "CA");	
		seleniumCore.tabOut();
		seleniumCore.waitForUILoading(500);
	}
	
	public void searchContraFirm(String value, String option) {
		waitForLoadingData();
		waitForLoadingDataOWB();
		seleniumCore.waitForElementToBeClickable(searchFirm, 30, 1);
		seleniumCore.sendKeys(searchFirm, value);
		seleniumCore.tabOut();
		seleniumCore.waitForUILoading(3000);
		seleniumCore.jsClick(seleniumCore.findElement(searchFirmButton), "", "");
//		seleniumCore.click(searchFirmButton,"","",10,1);
		customLogger("search contra firm", value);
		logger.info("search contra firm "+ value);
		waitForLoadingDataOWB();
		seleniumCore.waitForElementToBeVisible(By.cssSelector("div.table-responsive"), 5, 1);
		Assert.assertTrue("searched contra firm is not present", seleniumCore.getText(By.cssSelector("div.table-responsive")).contains(value));
		By updateFirmLink = By.xpath("//a[text()='"+option+"']");
		seleniumCore.waitForElementToBeClickable(updateFirmLink).click();		
		waitForLoadingData();
		waitForLoadingDataOWB();
	} 
	
	public List<String> selectCriteria(String option) {
		List<String> instructions= new ArrayList<String>();
		List<WebElement> elements= seleniumCore.findElements(By.xpath("//tr[./td[text()='Applies if "+option+"']]//input"));
		for(int i=0;i< Math.min(2, elements.size()); i++) {
			elements.get(i).click();
			instructions.add(elements.get(i).findElement(By.xpath("./parent::td/following-sibling::td")).getText());
		}
		clickSaveButton();
		return instructions;
	}
	public void validateClearingFirms() {
		seleniumCore.waitForJStoLoad();
		waitForLoadingData();
		waitForLoadingDataOWB();
		seleniumCore.waitForElementToBeVisible(firmClearingFirms, 20, 1);
		seleniumCore.selectByVisibleText(firmClearingFirms, "0001 - MARION ACAT BETA");		
		logger.info("select clearing firm but did not add");
		customLogger("select clearing firm but did not add", "");
		Assert.assertFalse("clearing firm is visible without adding", seleniumCore.getText(By.xpath("//thead[./*[contains(text(),'DTC')]]/following-sibling::tbody")).contains("MARION"));
	}
	
	public void validateSmubmissionSection() {
		seleniumCore.click(moneyInAddNew);
		seleniumCore.click(moneyInAddFax);
		clickSaveButton();
		Assert.assertTrue("fax validation is not working", seleniumCore.getText(By.cssSelector("[class*=alert-danger]>ul>li")).contains("The Fax field is required"));
		seleniumCore.click(By.xpath("//div[./*[contains(text(),'Fax')]]//*[text()='delete']"));
		seleniumCore.sendKeys(By.xpath("//div[./*[contains(text(),'eSignature accepted')]]//p"), "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
	}
	
	public void validateFollowupTab() {
		seleniumCore.sendKeys(By.xpath("//div[./div/*[contains(text(),'Email')]]//textarea"), "okiju Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
		seleniumCore.tabOut();
		Assert.assertTrue("max 100 chars validation is not working on email field", seleniumCore.getText(By.xpath("//div[./div/*[contains(text(),'Email')]]//div[@class='validation-message']")).contains("Max 100 chars"));
		seleniumCore.sendKeys(By.xpath("//div[./div/*[contains(text(),'Phone')]]//textarea"), "okiju Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
		Assert.assertFalse("max 100 chars validation is not working on email field", seleniumCore.isElementVisible(By.xpath("//div[./div/*[contains(text(),'Phone')]]//div[@class='validation-message']"),1,1));
	}
	
}
