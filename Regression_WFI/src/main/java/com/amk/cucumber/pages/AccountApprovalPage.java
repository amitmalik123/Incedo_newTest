package com.amk.cucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.amk.cucumber.utility.CommonMethods;
import com.amk.cucumber.utility.SeleniumCore;

public class AccountApprovalPage extends CommonMethods  {

    // Static Data
    private static final String PAGE_NAME = "ACCOUNT APPROVAL PAGE";


    // Page Locators
    private static final By viewDocumentsPageLabel = By.xpath("//div[@id='BrokerDealApprovals']");    
    private final By checkBox = By.xpath("//input[@id='readme']");
    private final By approveButton = By.xpath("//input[@id='approve']");
    private final By rejectButton = By.cssSelector("#reject");
    private final By doneButton = By.xpath("//input[@id='done']");
    private final By commentTextbox = By.cssSelector("#Comment");
    private final By confirmationMessage = By.cssSelector("div.item-confirmation");
    private final By searchBox = By.cssSelector("#client_search_input");
	private final By searchbutton = By.cssSelector("#searchbutton");
	private final By grid = By.cssSelector("#BDApprovalListGrid");
	

    public AccountApprovalPage(SeleniumCore seleniumCore) {
        this(seleniumCore, true);
    }

    public AccountApprovalPage(SeleniumCore seleniumCore, boolean pageVerification) {
        super(seleniumCore);
        if (pageVerification) {
           
            if (seleniumCore.isElementVisible(viewDocumentsPageLabel,30,1)) {
               logger.info(PAGE_NAME + " verification"+" : "+ PAGE_NAME + " verification is PASSED");
            } else {
               logger.warn(PAGE_NAME + " verification"+" : "+  PAGE_NAME + " verification is FAILED");
            }
        }
    }

    public static By getLabel() {
        return viewDocumentsPageLabel;
    }

    /**
     * Clicks on the first document's Separate Documents button
     *
     * @param stepName
     * @param logMessage
     */
    public void clickPendingLink(String fullname,String stepName, String logMessage) {  
		this.seleniumCore.getLogger().info("search for item with last name " +":"+ fullname);	
		seleniumCore.waitForJStoLoad();		
		seleniumCore.waitForUILoading(5000);
		seleniumCore.isElementVisible(grid, 40, 1);
		seleniumCore.findElement(searchBox).sendKeys(fullname);			
		this.seleniumCore.click(searchbutton);
		seleniumCore.waitForUILoading(3000);
		Actions action = new Actions(this.seleniumCore.getDriver());
		By gridList = By.xpath("//a[contains(text(),'"+fullname+"')   and    not(@id)]");		
		this.seleniumCore.waitForElementToBeVisible(gridList,10,1);
		WebElement we = this.seleniumCore.getDriver().findElement(gridList);
		try {		
		action.moveToElement(we).click().build().perform();			
		}catch(Exception e) {
			seleniumCore.jsClick(we, "click on last name : ", fullname);			
		}
		logger.info(stepName);			
    } 
    
    public void approveRequest(String stepName, String logMessage) {  
    	this.seleniumCore.waitForElementToBeVisible(checkBox,10,1); 
    	seleniumCore.isElementVisible(checkBox,30,1);
    	waitForLoadingData();
    	seleniumCore.click(checkBox, stepName, logMessage);
    	customLogger("" ,"click on check box");
    	waitForLoadingData();
    	seleniumCore.click(approveButton, stepName, logMessage);
    	customLogger(stepName ,"");
    	this.seleniumCore.waitForElementToBeVisible(doneButton,10,1);    	
    	this.seleniumCore.waitUntilElementToBeClickable(doneButton);
    	waitForLoadingData();
    	seleniumCore.click(doneButton, stepName, logMessage);
    	seleniumCore.waitForJStoLoad();
    	waitForLoadingData();
    	customLogger("" ,"click on done button");
    } 
    
    public void rejectRequest(String stepName, String logMessage) {  
    	this.seleniumCore.waitUntilElementToBeClickable(rejectButton,30,1);
    	waitForLoadingData();
    	seleniumCore.click(rejectButton, stepName, logMessage);    	
    	seleniumCore.isElementVisible(commentTextbox,30,1);
    	this.seleniumCore.waitUntilElementToBeClickable(rejectButton,30,1);
    	waitForLoadingData();
    	seleniumCore.sendKeys(commentTextbox, "reject workitem");
    	customLogger("add comment " ,"reject workitem");
    	seleniumCore.waitForJStoLoad();
    	seleniumCore.waitForUILoading(2000);
    	waitForLoadingData();
    	seleniumCore.click(rejectButton, stepName, logMessage);
    	seleniumCore.waitForJStoLoad();
    	customLogger(stepName ,"");
    } 
    
    public String validateRejectMessage() {
    	seleniumCore.waitForJStoLoad();
    	waitForLoadingData();
    	seleniumCore.isElementVisible(confirmationMessage,20,1);
    	seleniumCore.waitForUILoading(2000);
    	return seleniumCore.getText(confirmationMessage);
    }
}
