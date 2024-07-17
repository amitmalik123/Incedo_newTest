package com.amk.cucumber.pages;

import org.openqa.selenium.By;

import com.amk.cucumber.instantiator.Instantiator;
import com.amk.cucumber.utility.CommonMethods;
import com.amk.cucumber.utility.SeleniumCore;



public class FeesPage extends CommonMethods implements Instantiator<FeesPage> {

    // Static Data
    private static final String PAGE_NAME = "Fees Page";

    // Navigation
    private final By flatFee = By.xpath("//*[@id='financialAdvisorFee']   |    //*[@id='advFlatFee']");
    private final By nextButton = By.cssSelector("#next_button");    
    private final By completeAndSubmitButton = By.cssSelector("input#completeAndSubmitButton");
    private final By completeAndPrintBtn = By.cssSelector("input#completeAndPrintButton");
    private final By clientSignatureModalContinueButton = By.cssSelector("#esubmit-continue-button");
    private final By processingTimeModalContinueWithPrintButton = By.cssSelector("#print-continue-button");
    private final By signerInformationModalContinueButton = By.id("btnContinue");    
    private final By dTrackingId = By.xpath("//div[@id='divConfirmation']//b//a");
	private final By readyForSignature = By.xpath("//div[@id='divConfirmation']");
	protected By trackingCenterTab = By.xpath("//a[text()='Tracking Center' and not(@id)]");	
	private final By closeBtn = By.xpath("//span[text()='Close']");	
    private final By flatFee1 = By.xpath("/html//input[@id='advFlatFee']");
    private final By confirmClientFees = By.xpath("/html//input[@id='nextButton']");

    // Body

	protected String trackingId;
    @Override
    public FeesPage getInstance() {
        return new FeesPage(seleniumCore);
    }

    public FeesPage(SeleniumCore seleniumCore) {
        this(seleniumCore, true);
    }

    public FeesPage(SeleniumCore seleniumCore, boolean pageVerification) {
        super(seleniumCore);
       
        waitForAllLoadingImagesToBeDisappear();
        if (pageVerification) {
            boolean isFlatFee = seleniumCore.isElementVisible(flatFee, 30, 1);
            if (isFlatFee) {
                logger.info(PAGE_NAME + " verification"+SEPARATOR+ PAGE_NAME + " verification is PASSED");
            } else {
                logger.warn(PAGE_NAME + " verification"+SEPARATOR+ PAGE_NAME + " verification is FAILED");
            }
        }
    }
	 
    
    public void enterFlatFee(String fee) {
    	waitForAllLoadingImagesToBeDisappear();
        seleniumCore.waitForElementToBeVisible(flatFee);
        this.seleniumCore.sendKeys(flatFee, fee, "enter flat fee");
         seleniumCore.tabOut();
         waitForAllLoadingImagesToBeDisappear();
        logger.info("clicked on add document button");
    }

    public FeesPage clickClient(String client, String pick, String stepName, String logMessage) {
        String path = "(//a[contains(text(), " + "'" + client + "'" + ")])" + "[" + pick + "]";
        this.seleniumCore.click(By.xpath(path), stepName, logMessage);
       
        return new FeesPage(seleniumCore);
    }    
 
    public void clickNextButton() {
    	 seleniumCore.waitForElementToBeClickable(nextButton);
         this.seleniumCore.click(nextButton);
          
         logger.info("clicked on next button");
    }
    
    public DocuSignPage clickContinueOnClientSignatureModel() {
    	this.seleniumCore.getDriver().switchTo().activeElement();
		this.seleniumCore.waitForElementToBeVisible(clientSignatureModalContinueButton);
		this.seleniumCore.waitForJStoLoad();
		logger.info("Click on client signature model continue button ");
		customLogger("Click on client signature model continue button ", "");
		return new DocuSignPage(seleniumCore);
	}

    public void selectRequest(String request) {
    	seleniumCore.waitForElementToBeClickable(By.xpath("//li[contains(text(), '" + request + "')]"),
                5, 1).click();
		customLogger("Clicking on request ", request);
	}
    
    public void selectType(String type) {
    	seleniumCore.waitForJStoLoad();
    	seleniumCore.waitForUILoading(1000);
    	seleniumCore.waitForElementToBeClickable(By.xpath("//li[contains(text(), '" + type + "')]"),
                5, 1).click();    	
		customLogger("Clicking on type  ", type);
	}
    
    public void clickCompleteAndPrintBtn() {
		this.seleniumCore.waitForElementToBeClickable(completeAndPrintBtn,20,1);
		this.seleniumCore.click(completeAndPrintBtn);
		waitForSpinnerToBeDisappear();
		customLogger("Click on complete and print button ", "");		
	}
    
    public DocuSignPage clickContinueWithPrintOnProcessingTimeModel() {
    	if(seleniumCore.isElementVisible(processingTimeModalContinueWithPrintButton, 5, 1)) {
    		this.seleniumCore.getDriver().switchTo().activeElement();
    		this.seleniumCore.waitForElementToBeVisible(processingTimeModalContinueWithPrintButton);
    		this.seleniumCore.click(processingTimeModalContinueWithPrintButton);	
    		this.seleniumCore.waitForJStoLoad();
    		logger.info("Click on client signature model continue button ");
    		customLogger("Click on client signature model continue button ", "");
    	}    			
		return new DocuSignPage(seleniumCore);
	}
    
    public void clickCompleteOnClientSignatureModel() {
    	this.seleniumCore.getDriver().switchTo().activeElement();
		this.seleniumCore.waitForElementToBeVisible(clientSignatureModalContinueButton);
		this.seleniumCore.click(clientSignatureModalContinueButton);	
		this.seleniumCore.waitForJStoLoad();
		logger.info("proceed without client signature option and click on continue button ");
		customLogger("proceed without client signature option and click on continue button ", "");
	}
	
	  public void clickCompleteAndSubmitBtn() {
	  this.seleniumCore.waitForElementToBeClickable(completeAndSubmitButton,20,1);
	  this.seleniumCore.click(completeAndSubmitButton); waitForSpinnerToBeDisappear();
	  customLogger("Click on complete and submit button ", ""); 	 
	  }
	 
    
		public DocuSignPage clickCompleteOnSignerInformationModel() {
			this.seleniumCore.getDriver().switchTo().activeElement();
			if (!seleniumCore.waitForElementToBeInVisible(By.id("esig_iframe"), 10, 1)) {
				this.seleniumCore.switchFrameById("esig_iframe");
				this.seleniumCore.click(signerInformationModalContinueButton);
				logger.info("Click on signer information model continue button ");
				customLogger("Click on signer information model continue button ", "");
			}
			return new DocuSignPage(seleniumCore);
		}
    
	public String fetchDTrackingId() {
		this.seleniumCore.isElementVisible(readyForSignature, 10, 1);
		this.seleniumCore.getLogger().info(PAGE_NAME + SEPARATOR + "Ready For Signatures dialog Box is visible");
		customLogger("Ready For Signatures dialog Box is visible", "");
		trackingId = this.seleniumCore.getText(dTrackingId);
		this.seleniumCore.click(closeBtn, PAGE_NAME, "Clicking on Close button");
		customLogger("fetch D Track id and Click on Close button ", "");

		return trackingId;
	}
    
    public TrackingCenterPage clickTrackingCenterTab() {
		this.seleniumCore.click(trackingCenterTab, PAGE_NAME, "Clicking on tracking center tab");
		customLogger("Clicking on tracking center tab ", "");
		
		return new TrackingCenterPage(seleniumCore);
	}    
    
    public void enterClientFee(String clientFee, String stepName, String logMessage) {
        this.seleniumCore.waitForElementToBeFound(flatFee1);
        this.seleniumCore.sendKeys(flatFee1, clientFee, stepName, logMessage);
        customLogger(logMessage, clientFee);
    }

    public PortfolioDetailsPage confirmClientFee(String stepName, String logMessage) {
    	seleniumCore.tabOut();
        // Wait until the fee input value will be entered and registered and only then try clicking Next button
        this.seleniumCore.waitForElementToBeFound(By.xpath("//input[@id='advFlatFee' and @hasvalue='Yes']"));        
        this.seleniumCore.waitForElementToBeFound(confirmClientFees).click();
        customLogger("Click on next button on fee page ", "");
        return new PortfolioDetailsPage(seleniumCore);
    }
}
