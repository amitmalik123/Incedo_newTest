package com.amk.cucumber.pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.logging.log4j.core.appender.DefaultErrorHandler;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.amk.cucumber.exceptions.DefaultException;
import com.amk.cucumber.utility.BasePage;
import com.amk.cucumber.utility.SeleniumCore;

public class InvestmentChangePage extends BasePage{
	public InvestmentChangePage(SeleniumCore seleniumCore) {
		super(seleniumCore);
	}
	// Static Data
	
	protected String StepName="Selecting Client Type";
	protected String Visible_text="Corporate";

	// Static Data
    private static final String PAGE_NAME = "Investment Change";

    // Page Locators
    private static final By clientProfilePageLabel = By.xpath("//div[@class='pageTitleStepometer']"); 
    private final By nextBtn = By.xpath("//*[@id='nextButton']");
    private final By investmentSelectorDropdown = By.xpath("//*[@id='targetddl']");
    private By newInvestmentNameSelector;
 
    private final By newInvestmentInDropdown = By.xpath("//dl//a[text()='New investment']");
    private final By newInvestmentInDropdown1 = By.xpath("//dl//a[@data-value='NewInvestment'    and    @class]");
 
    
    private final By chooseNewInvestmentTitle = By.xpath("//div[contains(text(),'Choose a New')]");
    private By investmentSolution;
    private final By existingSolutionCombineAccounts = By.cssSelector("div#uniform-CombineAccts");
    private final By existingSolutionOkButton = By.xpath("//button[@class='formButton']/span[text()='Ok']");
    private final By clientSearchInput = By.xpath("//*[@id='client_search_input']");
    private final By goBtn = By.xpath("//*[@id='searchbutton']");
    private final By selectedInvestmentName = By.xpath("//label[@id='destModelName1']");
    private final By partialInvestmentCheckbox = By.cssSelector("#allocRdPartial1_1");
    private final By fullInvestmentCheckbox = By.cssSelector("#allocRdFull1_1");
    private final By enterAmountTextbox = By.xpath("//*[@id='allocDollar1_1']");    
    private final By tabHeader = By.xpath("//div[@class='pageTitleStepometer']");
    
    // Locators - 1. Client's risk tolerance for this Portfolio
    private final By lowRiskTolerance = By.xpath("//*[@name='1' and @value='1']");
    private final By moderateRiskTolerance = By.xpath("//*[@name='1' and @value='2']");
    private final By highRiskTolerance = By.xpath("//*[@name='1' and @value='3']");
    private final By veryHighRiskTolerance = By.xpath("//*[@name='1' and @value='4']");

    // Locators - 2. Client's investment horizon
    private final By years2 = By.xpath("//*[@name='2' and @value='1']");
    private final By years3to5 = By.xpath("//*[@name='2' and @value='2']");
    private final By years6to9 = By.xpath("//*[@name='2' and @value='3']");
    private final By years10plus = By.xpath("//*[@name='2' and @value='4']");

    // Locators - 3. Percent of Client's total net worth that this Portfolio
    // represents
    private final By percentageOver75 = By.xpath("//*[@name='3' and @value='1']");
    private final By percentage50to75 = By.xpath("//*[@name='3' and @value='2']");
    private final By percentage25to50 = By.xpath("//*[@name='3' and @value='3']");
    private final By percentageBelow25 = By.xpath("//*[@name='3' and @value='4']");
    
    private final By completeAndSubmitButton = By.cssSelector("#OnlineSubmitbutton");
    private final By clientSignatureModalContinueButton = By.xpath("//span[text()='Continue']/parent::button[@class='formButton']");
 
    private final By signerInformationModalContinueButton = By.id("btnContinue");
    private final By signerFrame = By.id("esig_iframe");       
    private final By sourceModelName = By.cssSelector("td#ModelInfo1>label");
    private final By confirmModalSelection = By.cssSelector("input#OkButton");
    private final By reviewButton = By.cssSelector("#review_button");
    private final By savosTransition = By.cssSelector("[value='SavosConductedTaxManagedTransition']");
    private final By sourceMenu = By.cssSelector("#sourceMenu dd");
    public final By newAccountNumber = By.cssSelector("[id='Src_0_1']");
    public final By beneficalOwner = By.cssSelector("input[id*='one']");
    public final By beneficalOwnerLink = By.xpath("//a[text()='Beneficial Owners']");
    public final By retainCheckbox = By.xpath("//span[contains(text(),'Retain')]/preceding-sibling::div//input");
    public final By assignNewAccount = By.xpath("//div[contains(normalize-space(),'Assign')]/div/span/input[@name='AcctNoModels[1].SelectedSrcAcct']");
    public final By customAllocation = By.cssSelector("#btnCustomAllocation1");
    
    /**
     * To construct the Client Profile Page
     *
     * @param seleniumCore
     * @param pageVerification - Flag to check if the page is loaded or not
     */
    public InvestmentChangePage(SeleniumCore seleniumCore, boolean pageVerification) {
        super(seleniumCore);
        if (pageVerification) {
            if (seleniumCore.isElementVisible(clientProfilePageLabel,40,1)) {
            	logger.info(PAGE_NAME + " verification"+SEPARATOR+ PAGE_NAME + " verification is PASSED");
            } else {
                logger.warn(PAGE_NAME + " verification"+SEPARATOR+ PAGE_NAME + " verification is FAILED");
            }
        }
    }

    public static By getLabel() {
        return clientProfilePageLabel;
    }
    
	public void selectSourceAccount(String account) {
		seleniumCore.waitForJStoLoad();
		waitForPageLoad();	
		if(seleniumCore.isElementFound(By.xpath("//div[@id='regAccountList']//span[@class='checked']"),2,1)) {
			logger.info("account number has already selected "+ account);
			customLogger("account number has already selected ", account);
		}else {
		if(seleniumCore.findElements(By.cssSelector("div[class='dv_lblRegistration']")).size()>=1    &&   seleniumCore.findElements(By.cssSelector("div[class='dv_lblRegistration'] +div[id='0'] >div")).size()>=1) {
	//		if(!seleniumCore.isElementVisible(By.cssSelector("span[class='checked']"),4,1)) {
			waitForUILoading(1000);
			By accountCheckbox = By.xpath("//label[contains(text(), '" + account + "')]/../..//span");
			this.seleniumCore.waitForElementToBeVisible(accountCheckbox);
			this.seleniumCore.click(accountCheckbox, PAGE_NAME, "Click on account with number " + account);
			logger.info("Select account number "+ account);
			customLogger("Select account number ", account);
		}
		}		
	}
	
	public void selectMultipleSourceAccount(String account) {
		seleniumCore.waitForJStoLoad();
		waitForPageLoad();		
		if(seleniumCore.findElements(By.cssSelector("div[class='dv_lblRegistration']")).size()>=1    &&   seleniumCore.findElements(By.cssSelector("div[class='dv_lblRegistration'] +div[id='0'] >div")).size()>=1) {
	//		if(!seleniumCore.isElementVisible(By.cssSelector("span[class='checked']"),4,1)) {
			waitForUILoading(1000);
			By accountCheckbox = By.xpath("//label[contains(text(), '" + account + "')]/../..//span");
			this.seleniumCore.waitForElementToBeVisible(accountCheckbox);
			this.seleniumCore.click(accountCheckbox, PAGE_NAME, "Click on account with number " + account);
			logger.info("Select account number "+ account);
			customLogger("Select account number ", account);
		}				
	}
    
	public void clickNextBtn() {
		seleniumCore.waitForJStoLoad();
		waitForPageLoad();
		WebElement nextBtn = this.seleniumCore.findElement(By.xpath("//*[@id='nextButton']"));
		seleniumCore.waitForElementToBeClickable(nextBtn, 20, 1);
		this.seleniumCore.scrollIntoView(nextBtn);
		this.seleniumCore.jsClick(nextBtn, "Click on next button", "");
		customLogger("Clicked on next button ", "");
		if (seleniumCore.isElementVisible(By.cssSelector("div#InvestmentActionModal"), 2, 1)) {
			By desInvestment = By.cssSelector("[value='DestinationInvestment']");
			seleniumCore.clickRadioButton(desInvestment, "", "");
			seleniumCore.click(By.xpath("//button[text()='OK']"));
		}
	} 
    
    public String fetchedSourceModal(String AccountNumber) {
    	 By selector = By.xpath("//*[contains(text(),'" + AccountNumber + "')]");
    	 Assert.assertTrue("account number is not verified",  this.seleniumCore.isElementFound(selector, 3, 1));           	 
    	String currentModal= seleniumCore.getText(sourceModelName);
    	logger.info("current investment solution: "+ currentModal);
    	customLogger("current investment solution: ", currentModal);
    	return currentModal;
    }
    
    public void selectNewInvestmentDestinationInvestment(String investmentName) {
    	this.seleniumCore.waitForElementToBeVisible(investmentSelectorDropdown);
    	this.seleniumCore.click(investmentSelectorDropdown, "expand investments dropdown", "expanded");
    	waitForUILoading(1000);    	
        this.seleniumCore.click(newInvestmentInDropdown, "expand New Investment list", "expanded");    	
        waitForUILoading(1000);       
        newInvestmentNameSelector = By.xpath("//dl[@id='targetdll2']//a[contains(text(),'" + investmentName + "')]");       
        this.seleniumCore.click(newInvestmentNameSelector, "click new investment option", investmentName);
        waitForUILoading(1000);
        customLogger("Selected new investment option ", investmentName);
    }
    
    public void selectExistingInvestmentDestinationInvestment(String accountNumber) {
    	this.seleniumCore.waitForElementToBeVisible(investmentSelectorDropdown);
    	this.seleniumCore.click(investmentSelectorDropdown, "expand investments dropdown", "expanded");
    	waitForUILoading(1000);    	
        List<WebElement> elements= seleniumCore.findElements(sourceMenu);
        if(elements.size()>1) {
        for(WebElement element : elements) {
        	if(!element.getText().contains(accountNumber)) {
        		element.click();
        		break;
        	}
        }   
        } else {
        	throw new DefaultException("existing investment has only 1 account to invest");
        }
    }
    
    public void selectNewInvestmentDestinationInvestmentTwo(String investmentName) {
    	this.seleniumCore.click(investmentSelectorDropdown, "expand investments dropdown", "expanded");
    	waitForUILoading(1000);
    	this.seleniumCore.click(newInvestmentInDropdown1, "expand New Investment list", "expanded");	
    	waitForUILoading(1000);       
        newInvestmentNameSelector = By.xpath("//dl[@id='targetdll2']//a[contains(text(),'" + investmentName + "')]");       
        this.seleniumCore.click(newInvestmentNameSelector, "click new investment option", investmentName);
        waitForUILoading(1000);
    }
    
    public boolean isChooseNewInvestmentModalVisible() {
    	return seleniumCore.isElementVisible(chooseNewInvestmentTitle, 30, 1);
    }
    
    public void selectSolutionType(String type) {
    	WebElement solutionType= seleniumCore.getDriver().findElement(By.cssSelector("#SolutionTypeFilter"));
    	solutionType.click();
    	seleniumCore.selectByValue(solutionType, type, "select solution type: ", type);   
    	seleniumCore.waitForUILoading(2000);
   // 	seleniumCore.tabOut();
    	customLogger("select solution type: ", type);
    }
    
    public void searchInvestmentSolution(String investmentSolutionName) {
        this.seleniumCore.sendKeys(clientSearchInput, investmentSolutionName, "Enter investment solution name to search box", "Entered");
        this.seleniumCore.click(goBtn, "Click GO btn", "Clicked");
        waitForUILoading(500);
        customLogger("Choose Investment Solution Name ","");
    }
    
    public void searchAndSelectInvestmentSolution(String InvestmentSolutionName) {        
        investmentSolution = By.xpath("//td[contains(text(),'"+InvestmentSolutionName+"')]");
        // Double click on element       
        WebElement ele = this.seleniumCore.findElement(investmentSolution);
        action.doubleClick(ele).perform();
        customLogger("Select Investment Solution by double click ", "");
        if(seleniumCore.isElementVisible(existingSolutionCombineAccounts,3,1)) {
        	seleniumCore.click(existingSolutionCombineAccounts);
        	seleniumCore.click(existingSolutionOkButton);
        }
      }
    
    public void selectNewInvestment(String oldInvestment) {
    	for(int i=1;i<=2;i++) {
    	investmentSolution = By.xpath("//*[@id='IS_grid_data_container']/tr[@data-is-tms='true']["+i+"]");
    	if(!seleniumCore.getText(investmentSolution).contains(oldInvestment)) {
    		 WebElement ele = this.seleniumCore.findElement(investmentSolution);
    		action.doubleClick(ele).perform();
            customLogger("Select new investment solution ", "");
    		break;
    	}
    	}
    }
    
    public String validateSelectedInvestmentName() {
    	 waitForUILoading(2000);
    	return seleniumCore.getText(selectedInvestmentName);
    }
    
	public void enterPartialAmount(String amount) {
		this.seleniumCore.clickRadioButton(partialInvestmentCheckbox, "Click Partial checkbox", "");
		this.seleniumCore.waitForElementToBeVisible(enterAmountTextbox,10,1);
		String investmentAmount = seleniumCore.getText(By.id("destProdMinimum1"));
		String  exactAmount= investmentAmount.replaceAll("[,():]", "").split("[.]")[0].split("[$]")[1];		
		if(Integer.parseInt(exactAmount) < Integer.parseInt(amount)) {
		this.seleniumCore.sendKeys(enterAmountTextbox, amount, "entered amount in partial amount textbox");
		} else {
			  amount = String.valueOf(Integer.parseInt(amount) + 5000);
			seleniumCore.sendKeys(enterAmountTextbox, amount, "entered amount in partial amount textbox");
		}
		seleniumCore.waitForUILoading(1000);
		seleniumCore.tabOut();
		
		customLogger("Entered amount in partial amount textbox ", amount);
	}
	
	public void click100Percentage() {		
		List<WebElement>elements2=seleniumCore.findElements(By.cssSelector("[id*='allocRdFull2']"));
		if(elements2!=null  &&  !elements2.isEmpty()) {
			for(int i=1;i<elements2.size();i++) {
				action.click(elements2.get(i)).build().perform();
				customLogger("Clicked on 100 percentage amount checkbox ", "");
			}
		}
		List<WebElement>elements=seleniumCore.findElements(By.cssSelector("[id*='allocRdFull1']"));
		if(elements!=null  &&  !elements.isEmpty()) {
			for(int i=0;i<elements.size();i++) {
				if(elements.get(i).isEnabled()) {
				action.click(elements.get(i)).build().perform();
				customLogger("Clicked on 100 percentage amount checkbox ", "");
				}
			}
		}		
	}
    
    public void checkAllRemaining() {
    	this.seleniumCore.waitForJStoLoad();
    	this.seleniumCore.waitForElementToBeVisible(nextBtn);	
    	WebElement allRemainingCheckbox = this.seleniumCore.findElement(By.cssSelector("input#allocRdFull2_1"));
    	this.seleniumCore.jsClick(allRemainingCheckbox, "clicking on all remaining checkbox ", "Clicked");
		customLogger("Clicked on  all remaining checkbox ", "");
    }    
    
    public String validateSecondaryTab() {
    	this.seleniumCore.waitForJStoLoad();
    	waitForPageLoad();  
    	seleniumCore.waitForUILoading(5000);
    	this.seleniumCore.waitForElementToBeVisible(tabHeader,30,1);        	
   // 	if(this.seleniumCore.validateTextValue(tabHeader, 5, 2, value)) 
    	 return this.seleniumCore.getText(tabHeader).trim().toLowerCase(); 
  //  	return null;
      }
    
    public void selectRadioBtnByText(String radiobuttonText) {
        By radioButton = By.xpath("//td[@class='suitabilityOptn']/text()[contains(., '" + radiobuttonText + "')]//..//span");
        this.seleniumCore.click(radioButton, "Select radio button", radiobuttonText);
    }
    
    public void selectClientRiskTolerance(String riskToleranceData) {
    	logger.info("clicking on client risk");
            switch (riskToleranceData.trim().toLowerCase()) {
                case "low":                   
                    this.seleniumCore.waitForElementToBeFound(lowRiskTolerance).click();
                    break;
                case "moderate":                    
                    this.seleniumCore.waitForElementToBeFound(moderateRiskTolerance).click();
                    break;
                case "high":                    
                    this.seleniumCore.waitForElementToBeFound(highRiskTolerance).click();
                    break;
                case "very high":                    
                    this.seleniumCore.waitForElementToBeFound(veryHighRiskTolerance).click();
                    break;
            }
            customLogger("select client risk tolerance ", riskToleranceData);
        }
    

    public void selectClientInvestmentHorizon(String investmentHorizonData) {  
    	logger.info("clicking on client investment");
        switch (investmentHorizonData.trim().toLowerCase()) {
            case "up to 2 years":
                this.seleniumCore.waitForElementToBeFound(years2).click();
                break;
            case "3-5 years":
                this.seleniumCore.waitForElementToBeFound(years3to5).click();
                break;
            case "6-9 years":
                this.seleniumCore.waitForElementToBeFound(years6to9).click();
                break;
            case "10 and more":
                this.seleniumCore.waitForElementToBeFound(years10plus).click();
                break;
        }
        customLogger("select client investment horizon ", investmentHorizonData);
    }

    public void selectClientTotalNetWorth(String percentOfClientNetWorth) {
        logger.info("clicking on client tot worth");
        switch (percentOfClientNetWorth) {
            case "<25":
                this.seleniumCore.waitForElementToBeFound(percentageBelow25).click();                
                break;
            case "25to50":
                this.seleniumCore.waitForElementToBeFound(percentage25to50).click();
                break;
            case "50to75":
                this.seleniumCore.waitForElementToBeFound(percentage50to75).click();
                break;
            case ">75":
                this.seleniumCore.waitForElementToBeFound(percentageOver75).click();
                break;
        }
        customLogger("select client total net worth ", percentOfClientNetWorth);
    }
    
    public void clickCompleteAndSubmitButton() {
    	if (this.seleniumCore.isElementVisible(completeAndSubmitButton)) {			
			this.seleniumCore.click(completeAndSubmitButton);
		}
		customLogger("Clicked on complete and submit button ", "");
    }
     
    public void clickCompleteOnClientSignatureModel() {
    	this.seleniumCore.getDriver().switchTo().activeElement();
		this.seleniumCore.waitForElementToBeVisible(clientSignatureModalContinueButton);
		this.seleniumCore.click(clientSignatureModalContinueButton);
		this.seleniumCore.waitForJStoLoad();
		logger.info("Click on client signature model continue button ");
		customLogger("Click on client signature model continue button ", "");
	}
    
    public DocuSignPage clickCompleteOnSignerInformationModel() {    
    	this.seleniumCore.getDriver().switchTo().activeElement();
    	this.seleniumCore.frameAvailableAndSwitchToIt(signerFrame,20, 2);   
		this.seleniumCore.waitForElementToBeVisible(signerInformationModalContinueButton);
		this.seleniumCore.click(signerInformationModalContinueButton);
		logger.info("Click on signer information model continue button ");
		customLogger("Click on signer information model continue button ", "");
		return new DocuSignPage(seleniumCore);
	}
    
    public void chooseSavosInvestment() {
		HashMap<String, String> map = new HashMap<String, String>();
		List<WebElement> range = seleniumCore.findElements(By.xpath("//div[@class='col-xs-12 text-center no-gutter']"));
		for (int i = 0; i < range.size(); i++) {
			if (i == 0) {
				map.put("equity", range.get(i).getText().trim().replaceAll("[-%]", "").substring(1));
			} else {
				map.put("fi", range.get(i).getText().trim().replaceAll("[-%]", "").substring(0, 2));
			}
		}
		List<WebElement> elements =  seleniumCore.findElements(By.xpath("//button[contains(text(),'Add Investment')]"));
		customLogger(String.valueOf(elements.size()), " add investment buttons are visible");
		for (int i = 0; i < elements.size(); i++) {
	//		seleniumCore.waitForUILoading(2000);
			seleniumCore.jsClick(elements.get(i), "");
	//		elements.get(i).click();
				logger.info("clicked on add investment button");
				customLogger("clicked on add investment button", "");
			if(seleniumCore.isElementVisible(By.cssSelector("#InvestmentSelectorContainer"), 3, 1)) {
				logger.info("new investment modal is not visible");
			}else {		
				javaScriptExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
				seleniumCore.waitForUILoading(500);
				javaScriptExecutor.executeScript("window.scrollTo(0, 0)");
				seleniumCore.waitForUILoading(500);
				seleniumCore.jsClick(elements.get(i), "");
				logger.info("cursor is scrolled to add investment button");
			}
			if(!seleniumCore.isElementVisible(By.cssSelector("#InvestmentSelectorContainer"), 3, 1)) {
				new DefaultException("new investment modal is not visible");
			}
			seleniumCore.findElement(By.cssSelector("#IS_grid_data_container tr[class='']")).click();
			seleniumCore.click(confirmModalSelection);
			seleniumCore.waitForJStoLoad();			
			By allocationText= By.xpath("//input[.//following-sibling::input[contains(@id,'percent')   and   starts-with(@value,'0')]]");			
			if (i == 0) {
				seleniumCore.sendKeys(allocationText, map.get("equity"), "enter value in allocation ");				
			} else {
				seleniumCore.sendKeys(allocationText, map.get("fi"), "enter value in allocation");
			}
		}
	}
    
    public void reviewAndProceed(String option) {	
    	seleniumCore.tabOut();
    	if(option.equalsIgnoreCase("included")) {
    		seleniumCore.clickRadioButton(savosTransition, "", "");
    	}
		seleniumCore.click(reviewButton);
		seleniumCore.waitForJStoLoad();
		waitForLoadingData();			
	}
    
    public boolean hiddenPartialLabel() {
    	boolean value=  seleniumCore.getAttribute(By.cssSelector("#allocRdPartialLabel1_1"), "style").contains("none");
    	logger.info("partial label is not visible");
		customLogger("partial label is not visible", "");
		return value;
    }
    
    public boolean hiddenNewAccountNumberOption() {
    	List<WebElement> elements= seleniumCore.findElements(By.xpath("//*[contains(text(),'new account number')]"));
    	if(elements.size()==0) {
    		return true;
    	}else {
    		return false;
    	}
    }
    
    public String fetchAccountNumber() {
    	String[] number = seleniumCore.getText(By.cssSelector(".gbmask")).split(": ");
    	String accNumber = number[1];
    	logger.info("retained account number: "+ accNumber);
		customLogger("retained account number", accNumber);
    	return accNumber;
    }
 
}


