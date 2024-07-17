package com.amk.cucumber.pages;

import com.amk.cucumber.utility.BasePage;
import com.amk.cucumber.utility.SeleniumCore;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class FundingMethodPage extends BasePage {

    // Static Data
    private static final String PAGE_NAME = "FUNDING METHOD PAGE";

    // Page Locators
    private final By fundingMethodPageLabel = By.cssSelector(".label-page");

    // Funding methods
    private final By check = By.id("question_Fund_Check_tab");
    private final By transfer = By.id("question_Fund_Trans_COUNT_tab");   
    private final By checkAmountInput = By.id("question_Fund_Check_Amount");
    private final By enclosedCheckInput = By.id("question_Fund_Check_Deliv_Enclosed_tab"); 
    private final By onlineAccessAndDocumentDelivery = By.xpath("//button[@class='btn btn-primary btn-next']");
    private final By addInformationLink = By.xpath("//a[contains(text(),'Add Information')]");
    private final By deliveryFirmName = By.cssSelector("#typeAheadSelectedDeliveryFirmName");
    private final By deliveryFirmNameText = By.cssSelector("#typeAheadInput");
    private final By accountNumber = By.cssSelector("input[name=Trans_DelivAcct_AcctNum_0]");
    private final By ssnNumber = By.cssSelector("input[name*='Trans_DelivAcct_TaxNum_0'][class*='interview']");
    private final By assetDescription = By.cssSelector("input[name=Trans_Instx_MF_AssetName_0_0]");
    private final By symbol = By.cssSelector("input[name=Trans_Instx_MF_Symbol_0_0]");
    private final By mfCompany = By.cssSelector("input[name=Trans_Instx_MF_AcctNum_0_0]");
    private final By shares = By.cssSelector("#question_line_Questions_0__Trans_Instx_MF_Amt_All_0_0_tab");
    private final By saveButton = By.xpath("//button[text()='Save']");  

    public FundingMethodPage(SeleniumCore seleniumCore) {
        this(seleniumCore, true);
    }

    public FundingMethodPage(SeleniumCore seleniumCore, boolean pageVerification) {
        super(seleniumCore);
        if (pageVerification) {
            if (seleniumCore.isElementVisible(fundingMethodPageLabel,20,1)) {
                logger.info(PAGE_NAME + " verification"+" : "+ PAGE_NAME + " verification is PASSED");
            } else {
                logger.warn(PAGE_NAME + " verification"+" : "+ PAGE_NAME + " verification is FAILED");
            }
        }
    }

	public void selectFundingMethod(String fundingType, String stepName, String logMessage) {		
		String[] fundingTypeData = fundingType.split(",");		
		if (fundingTypeData[0].equals("Check")) {
			this.seleniumCore.waitForElementToBeFound(check).click();
			this.seleniumCore.sendKeys(checkAmountInput, fundingTypeData[1], stepName, logMessage);
			customLogger(stepName, fundingTypeData[0]);
			customLogger(logMessage, fundingTypeData[1]);
		} else if (fundingTypeData[2].equals("Enclosed Check")) {
			this.seleniumCore.waitForElementToBeFound(enclosedCheckInput).click();
		} else if (fundingTypeData[0].toLowerCase().contains("transfer")) {
			this.seleniumCore.waitForElementToBeFound(transfer).click();
		} else {
			logger.info("funding method is not selected");
		}
		
	}   
	
	public void selectFundingMethod(String fundingType) {		
		String[] fundingTypeData = fundingType.split(",");		
		if (fundingTypeData[0].equals("Check")) {
			this.seleniumCore.waitForElementToBeFound(check).click();
			logger.info("user select Check funding type");
			customLogger("user select Check funding type", "");
		}
		if (fundingTypeData[2].equals("Enclosed Check")) {
			this.seleniumCore.waitForElementToBeFound(enclosedCheckInput).click();
		}		
	}     
	
	public void goToOnlineAccessDocumentDelivery(String stepName, String logMessage) {
		waitForLoadingData();
		this.seleniumCore.click(onlineAccessAndDocumentDelivery, stepName, logMessage);
		waitForSpinnerToBeDisappear();
		customLogger(logMessage, "");
	}
	
	public void addinformation(String firm) {
		seleniumCore.click(addInformationLink);
		waitForLoadingData();
		seleniumCore.click(deliveryFirmName);
		seleniumCore.sendKeys(deliveryFirmNameText, firm);
		action.sendKeys(Keys.ENTER).build().perform();
		logger.info("validated create contra firm on funding page");
		customLogger("validated create contra firm on funding page", "");
	}
	 
	public void enterTransferInfo() {
		seleniumCore.sendKeys(accountNumber, "8756687678");
		seleniumCore.sendKeys(ssnNumber, "876876876");
		seleniumCore.click(deliveryFirmName);
		seleniumCore.waitForElementToBeVisible(assetDescription, 10, 1);
		seleniumCore.sendKeys(assetDescription, "IncedoAssetMarkCompany");
		seleniumCore.sendKeys(symbol, "AAPL");
		seleniumCore.sendKeys(mfCompany, "PraghPairk");
		seleniumCore.clickRadioButton(shares, "", "");
		seleniumCore.click(saveButton);
		waitForLoadingData();
	}
}
