package com.amk.cucumber.pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.amk.cucumber.utility.BasePage;
import com.amk.cucumber.utility.SeleniumCore;

public class ConstructPortfolioPage extends BasePage {

    // Static Data
    private static final String PAGE_NAME = "CONSTRUCT PORTFOLIO PAGE";
   

    // Page Locators
    private static final By constructPortfolioPageLabel = By.xpath("//div[@id='Content']/div[@class='PageHeading']");
    private final By registrationTypeDropdown = By.xpath("//dl[@id='registration_type_dropdown']/dt[@class='firstmenu']");
    private final By registrationNameInput = By.xpath("/html//input[@id='registration_name']");
    private final By custodianDropdown = By.xpath("/html//dl[@id='registration_custodian']//span");
    private final By custodianOptions = By.xpath("//dl[contains(@class, 'show-dropdown')]//a");
    private final By investmentAmountInput = By.xpath("/html//input[@id='AccountSectionInvestmentAmount']");
    private final By accountTypeDropdown = By.xpath("//dl[@id='account_type_dropdown']//dt[@class='firstmenu']");    
    private final By investmentSolutionSortedLocator = By.cssSelector("tr td[class='investment-solution sorted']");
    private final By confirmModalSelection = By.cssSelector("input#OkButton");
    private final By singleStrategyConfirmation = By.xpath("/html//input[@id='single_strategy_confirm']");
    private final By constructPortfolioConfirmation = By.xpath("/html//input[@id='construct_next']");
    private final By dropDownAccessibleStateCheck = By.xpath("//dl[@class='dropdown leave-dropdown-open']");
    private final By lastLoadedElementStateCheck = By.xpath("//tbody//tr[last()]");    
    private final By chooseInvestmentWindow = By.id("InvestmentSelectorContainer");
    private final By noEnrollTMS = By.cssSelector("#tmsOptionsNo");  
    private final By yesEnrollTMS = By.cssSelector("#tmsOptionsYes");  
    private final By confirmButton = By.cssSelector("[value='Confirm']");  
    private final By fundsLabel = By.cssSelector("#americanFundsModalLabel"); 
    private final By fundModalButton = By.cssSelector("[value='Ok'][data-dismiss='modal']");     
    private final By savosTransition = By.cssSelector("[value='SavosConductedTaxManagedTransition']");
    private final By reviewButton = By.cssSelector("[value='Review']");    
    
    public ConstructPortfolioPage(SeleniumCore seleniumCore) {
        this(seleniumCore, true);
    }

    public ConstructPortfolioPage(SeleniumCore seleniumCore, boolean pageVerification) {
        super(seleniumCore);
        if (pageVerification) {
            if (seleniumCore.isElementVisible(constructPortfolioPageLabel)) {
            	logger.info(PAGE_NAME + " verification"+SEPARATOR+ PAGE_NAME + " verification is PASSED");
            } else {
                logger.warn(PAGE_NAME + " verification"+SEPARATOR+ PAGE_NAME + " verification is FAILED");
            }
        }
    }

    public static By getLabel() {
        return constructPortfolioPageLabel;
    }

    public void selectClientRegistrationType(String clientRegistrationType, String stepName, String logMessage) {
        logger.info(stepName +" : "+ logMessage);
        this.seleniumCore.waitForElementToBeFound(registrationTypeDropdown,30,1).click();
        if (clientRegistrationType.equals("Trust")) {
            this.seleniumCore.waitForElementToBeFound(By.cssSelector("[data-group-name='Trust'] span")).click();
        } else {
            String[] regTypeData = clientRegistrationType.split(",");
            this.seleniumCore.waitForElementToBeFound(By.cssSelector("[data-group-name*='" + regTypeData[0] + "'] span")).click();
            this.seleniumCore.waitForElementToBeFound(By.xpath("//dt//li[@data-name='" + regTypeData[1].trim() + "']")).click();
        }
        customLogger(logMessage, "");
    }

    public void enterRegistrationName(String name, String stepName, String logMessage) {
        this.seleniumCore.sendKeys(registrationNameInput, name, stepName, logMessage);
    }

    public void selectClientCustodian(String clientCustodian, String stepName, String logMessage) {
        logger.info(stepName +" : "+ logMessage);
        // Wait for the dropdown options to load after selecting registration type
        this.seleniumCore.waitForElementToBeFound(By.xpath("//dl[@class='styled-ddl']"));
        // Click the dropdown and select 
        this.seleniumCore.click(custodianDropdown);
        List<WebElement> listOfCustodianDropDownElements = this.seleniumCore.findElements(custodianOptions);
        for (WebElement ele : listOfCustodianDropDownElements) {
            if (ele.getText().toLowerCase().trim().equals(clientCustodian.toLowerCase().trim())) {
                ele.click();
                break;
            }
        }
        customLogger(logMessage,"");
    }

    public void insertInvestmentAmount(String clientInvestmentAmount, String stepName, String logMessage) {
    	seleniumCore.waitForElementToBeClickable(investmentAmountInput, 10, 1);
        this.seleniumCore.sendKeys(investmentAmountInput, clientInvestmentAmount, stepName, logMessage);
        customLogger(logMessage,"");
    }

    public void selectAccountType(String clientAccountType, String stepName, String logMessage) {
    	seleniumCore.waitForJStoLoad();
        this.seleniumCore.waitForElementToBeFound(dropDownAccessibleStateCheck,10,1);
        this.seleniumCore.waitForElementToBeFound(By.xpath("//dl[@id='account_type_dropdown']//dl[contains(@class,'styled-ddl')]/dt/span"),10,1);
        this.seleniumCore.click(By.xpath("//dl[@id='account_type_dropdown']//dt[@class='firstmenu']"),"","",10,1);  
        WebElement accountType=	seleniumCore.findElement(By.xpath("//a[contains(text(),'"+clientAccountType+"')]"), 4, 1);
        accountType.click();	
       waitForLoadingData();
        customLogger(logMessage,"");
    }

    public void chooseNewInvestmentFromModal(String investmentSolution, String stepName, String logMessage) {
        this.seleniumCore.waitForElementToBeFound(lastLoadedElementStateCheck);
        this.seleniumCore.waitForElementToBeFound(investmentSolutionSortedLocator);
        this.seleniumCore.waitForElementToBeVisible(chooseInvestmentWindow);
        boolean investmentFound = false;
        List<WebElement> listOfElements = this.seleniumCore.findElements(investmentSolutionSortedLocator);
        for (WebElement ele : listOfElements) {
            if (ele.getText().equals(investmentSolution)) {
                // Using Actions moveToElement and then click works more reliably when WebElement.click
                new Actions(this.seleniumCore.getDriver()).moveToElement(ele).click().build().perform();
                investmentFound = true;
                break;
            }
        }
        if (!investmentFound) {
        	 logger.info("Choose Investment"+" "+ "Investment solution " + investmentSolution + " could not be found. Will try one more time.");
            this.seleniumCore.click(By.xpath("//td[@class= 'investment-solution sorted' and text()='" + investmentSolution + "']"));
        }
        this.seleniumCore.waitForElementToBeClickable(confirmModalSelection).click();
        logger.info(stepName+" : "+ logMessage);
        customLogger(logMessage,"");
        if(seleniumCore.isElementVisible(fundsLabel,2,1)) {
        	seleniumCore.click(fundModalButton);
        	seleniumCore.waitForJStoLoad();
        	waitForLoadingData();
        }
    }

    public void confirmSingleStrategyInvestment(String stepName, String logMessage) {
        this.seleniumCore.waitForElementToBeClickable(singleStrategyConfirmation).click();
        logger.info(stepName+" : "+ logMessage);
    }

    public FeesPage confirmClientPortfolio(String stepName, String logMessage) {
    	if(seleniumCore.isElementVisible(noEnrollTMS,3,1)) {
    		seleniumCore.click(noEnrollTMS);
    		seleniumCore.click(confirmButton);
    	}
        this.seleniumCore.click(constructPortfolioConfirmation, stepName, logMessage,10,1);
        customLogger(stepName,"");
        return new FeesPage(seleniumCore);
    }  
    
    public FeesPage confirmClientPortfolioTMS(String stepName, String logMessage) {
    	if(seleniumCore.isElementVisible(yesEnrollTMS,3,1)) {
    		seleniumCore.click(yesEnrollTMS);
    		seleniumCore.click(confirmButton);
    	}
        customLogger(stepName,"");
        waitForLoadingData();
        seleniumCore.isElementVisible(By.cssSelector("#high"), 60, 1);
        try {
        seleniumCore.click(By.cssSelector("#high"),"","",60,1);
        }catch(Exception e) {
        	seleniumCore.clickRadioButton(By.cssSelector("#high"), "", "");
        }
        seleniumCore.click(By.cssSelector("#Continue"),"","",60,1);
        this.seleniumCore.click(constructPortfolioConfirmation, stepName, logMessage,60,1);
        if(seleniumCore.isElementVisible(By.xpath("//*[text()='Client Portfolio Suitability']"), 5, 1)) {
        	seleniumCore.clickRadioButton(By.cssSelector("[class='risk-assessment-action-radio'][value='3']"), "", "");
        	seleniumCore.click(By.cssSelector("#risk_assessment_action_btn_primary"));
        }
        return new FeesPage(seleniumCore);
    } 
    
	public void deleteExistingRegistration() {		
		while (seleniumCore.isElementVisible(By.xpath("//a[text()='Delete Registration']"),2,1)) {
			seleniumCore.jsClick(seleniumCore.findElement(By.xpath("//a[text()='Delete Registration']")), "", "");
			seleniumCore.waitForJStoLoad();
			waitForLoadingData();
		}
	}
	
	public void chooseSavosInvestment() {
		HashMap<String, String> map = new HashMap<String, String>();
		List<WebElement> range = seleniumCore.findElements(By.xpath("//span[@class='guardrail-range']"));
		for (int i = 0; i < range.size(); i++) {
			if (i == 0) {
				map.put("equity", range.get(i).getText().replaceAll("[-%]", "").substring(1));
			} else {
				map.put("fi", range.get(i).getText().replaceAll("[-%]", "").substring(0, 2));
			}
		}
		ArrayList<WebElement> elements = (ArrayList<WebElement>) seleniumCore.findElements(By.xpath("//button[contains(text(),'Add Investment')]"));
		for (int i = 0; i < elements.size(); i++) {
			seleniumCore.scrollIntoView(elements.get(i));
			elements.get(i).click();
			Assert.assertTrue(PAGE_NAME, seleniumCore.isElementVisible(confirmModalSelection, 10, 1));	
			seleniumCore.waitForUILoading(1000);
			seleniumCore.findElement(By.cssSelector("#IS_grid_data_container tr:not([class*='hidden'])")).click();
			seleniumCore.click(confirmModalSelection);
			seleniumCore.waitForJStoLoad();			
			By allocationText= By.xpath("//input[.//following-sibling::input[contains(@name,'percents')   and   starts-with(@value,'0')]]");			
			if (i == 0) {
				seleniumCore.sendKeys(allocationText, map.get("equity"), "enter value in allocation ");				
			} else {
				seleniumCore.sendKeys(allocationText, map.get("fi"), "enter value in allocation");
			}
		}
	}
	
	public void reviewAndProceed() {
		seleniumCore.clickRadioButton(savosTransition, "", "");
		seleniumCore.click(reviewButton);
		seleniumCore.waitForJStoLoad();
		waitForLoadingData();
		seleniumCore.click(confirmButton);
		seleniumCore.waitForJStoLoad();
		waitForLoadingData();		
	}
}







