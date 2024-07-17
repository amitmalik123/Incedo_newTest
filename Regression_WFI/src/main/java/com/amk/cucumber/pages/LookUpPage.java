package com.amk.cucumber.pages;

import org.openqa.selenium.By;

import com.amk.cucumber.utility.BasePage;
import com.amk.cucumber.utility.SeleniumCore;

public class LookUpPage extends BasePage {

    // Static Data
    private static final String PAGE_NAME = "LOOKUP PAGE";

    // Page Locators
    private final By switchIDLink = By.xpath("//ul[@id='userMenu']/li/a[text()='Switch ID']");
    private final By lookupUserIDTextField = By.xpath("//input[@name = 'ctl00$cphContentArea$txtLookUp']");
    private final By findByLookupUserIDFindButton = By.cssSelector("#ctl00_cphContentArea_btnLookUp");
    private final By selectRoleContinueButton = By.xpath("//input[@id='btnContinue']");
    private final By selectAdminRole = By.xpath("//input[@id='radAgents']");    
    private final By selectAdvisorRole = By.cssSelector("input[id*='radRoles_']");

    /**
     * To construct the Home Page
     *
     * @param seleniumCore
     */
    public LookUpPage(SeleniumCore seleniumCore) {
        this(seleniumCore, true);
    }

    /**
     * To construct the Home Page
     *
     * @param seleniumCore
     * @param pageVerification - Flag to check if the page is loaded or not
     */
    public LookUpPage(SeleniumCore seleniumCore, boolean pageVerification) {
        super(seleniumCore);
        this.seleniumCore.waitForElementToBeVisible(switchIDLink,60,1);
        if (pageVerification) {
            boolean isVisible = seleniumCore.isElementVisible(switchIDLink);
            if (isVisible) {
            	  logger.info(PAGE_NAME + " verification"+SEPARATOR+ PAGE_NAME + " verification is PASSED");
            } else {
            	  logger.warn(PAGE_NAME + " verification"+SEPARATOR+ PAGE_NAME + " verification is FAILED");

            }
        }
    }


    public void enterLookupUserIDAndclickFind(String username, String stepName, String logMessage) {
        this.seleniumCore.sendKeys(lookupUserIDTextField, username, stepName, logMessage);
        customLogger(stepName, logMessage);
        this.seleniumCore.click(findByLookupUserIDFindButton, stepName, logMessage);
        waitForSpinnerToBeDisappear();  
        seleniumCore.waitForJStoLoad();
        waitForLoadingData();
    }
    
    public void clickSSOUserID(String userId, String stepName, String logMessage) {           
        final By ssoUser = By.xpath("//td[text()='Agent']/parent::tr/td[6]/a[1]");
        final By nameUser = By.xpath("//td[text()='Agent']/parent::tr/td[2]/a[1]");
        if(seleniumCore.isElementVisible(ssoUser)) {
        	seleniumCore.click(ssoUser, "switching to agent", "clicked on agent sso");
        }else {
        	seleniumCore.click(nameUser, "switching to agent", "clicked on agent sso");
        }        
        logger.info(stepName+SEPARATOR+ logMessage + " Pass!");
    }
	
	public void ChooseRole() {
		if (this.seleniumCore.isElementFound(selectRoleContinueButton, 1, 1)){
            this.seleniumCore.findElement(selectAdminRole).click();            
             this.seleniumCore.findElement(selectRoleContinueButton).click();
             logger.info(" admin role has been selected ");             
        }
	}
	
	public void ChooseAdvisorRole() {
		if (this.seleniumCore.isElementFound(selectRoleContinueButton, 2, 1)){
            this.seleniumCore.findElement(selectAdvisorRole).click();            
             this.seleniumCore.findElement(selectRoleContinueButton).click();
             logger.info(" admin role has been selected ");             
        }
	}
	
	public void clickSSOUser(String role, String stepName, String logMessage ) {		
		By ssoLink = By.xpath("//td[text()='"+role+"']/parent::tr/td[6]/a");
		this.seleniumCore.waitForElementToBeVisible(ssoLink,10,1);
		this.seleniumCore.click(ssoLink, stepName, logMessage);
		seleniumCore.waitForJStoLoad();
        waitForLoadingData();
	}	
	
}
