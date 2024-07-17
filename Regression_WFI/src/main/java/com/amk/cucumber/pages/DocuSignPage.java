package com.amk.cucumber.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.amk.cucumber.utility.BasePage;
import com.amk.cucumber.utility.SeleniumCore;

public class DocuSignPage extends BasePage {

	// Static Data
	private static final String PAGE_NAME = "DocuSign PAGE";

	// Page Locators
	private final By pageImg = By.xpath("//img[@alt='DocuSign']");
	private final By continueBtn = By.xpath("//button[text()='Continue']");
	private final By finishBtn = By.xpath("//button[text()='Finish']");
	private final By sign = By.cssSelector("div[class*='signature-tab-content tab-button-yellow']");
	private final By checkbox = By.cssSelector("#disclosureAccepted");
	private final By signButton = By.cssSelector("#signButton , button[id*= 'Next']");
	private final By view = By.xpath("((//div[contains(text(),'View and accept your documents to continue.')]/parent::div/following-sibling::div)[2]/div/div/button)[2]");
	private final By accept = By.xpath("//button[contains(text(),'Accept')]");
	private final By adoptAndSign = By.xpath("//button[text()='Adopt and Sign']");
	private final By adoptAndInitial = By.xpath("//button[text()='Adopt and Initial']");
	private final By viewAddSupp = By.xpath("//button[contains(@aria-label,'Required - View, AddSupp_01')]");
	private final By sign2 = By.xpath("//div[contains(@class,'has-tab-error')]//div[contains(@class,'signature-tab-content tab-button-yellow')]");
	private final By trackingCenterLink = By.xpath("//div[@class='prompt-to-leave-modal-body']//b");

	public DocuSignPage(SeleniumCore seleniumCore) {
		super(seleniumCore);
	}

	public DocuSignPage(SeleniumCore seleniumCore, boolean pageVerification) {
		super(seleniumCore);
		if (pageVerification) {
			boolean isVisible = seleniumCore.isElementVisible(pageImg, 40, 1);
			if (isVisible) {
				logger.info(PAGE_NAME + " verification" + SEPARATOR + PAGE_NAME + " verification is PASSED");
				customLogger(" verification is PASSED", "");
			} else {
				logger.warn(PAGE_NAME + " verification" + SEPARATOR + PAGE_NAME + " verification is FAILED");
				customLogger(" verification is FAILED", "");
			}
		}
	}

	public void clickContinueButton() {
		seleniumCore.waitForJStoLoad();
		waitForPageLoad();
		if (seleniumCore.isElementVisible(checkbox, 2, 1))
			this.seleniumCore.jsClick(this.seleniumCore.getDriver().findElement(checkbox), "", "click on sign link ");
		this.seleniumCore.waitForElementToBeClickable(continueBtn,60,1);
		this.seleniumCore.click(continueBtn);
		logger.info("Clicked on continue button ");
		customLogger("Clicked on continue button ", "");
	}

	public void clickFinishButton() {
		seleniumCore.isElementVisible(finishBtn, 20, 1);	
		this.seleniumCore.waitForElementToBeClickable(finishBtn,20,1);
		this.seleniumCore.click(finishBtn);
		seleniumCore.waitForJStoLoad();
		waitForLoadingData();
		logger.info("Clicked on finish button ");
		customLogger("Clicked on finish button ", "");
	}

	public void clickSignButton() {
		this.seleniumCore.waitForElementToBeClickable(sign,10,1);
		this.seleniumCore.click(sign);
		logger.info("Clicked on sign button ");
		customLogger("Clicked on sign button ", "");
	}

	public void eSignatureSign() {
		seleniumCore.waitForJStoLoad();
		waitForLoadingData();		
		clickContinueButton();
		if (seleniumCore.isElementVisible(adoptAndSign, 2, 1))
			this.seleniumCore.jsClick(this.seleniumCore.getDriver().findElement(sign), "", "click on sign link ");
		if (seleniumCore.isElementVisible(sign, 2, 1))
			this.seleniumCore.jsClick(this.seleniumCore.getDriver().findElement(sign), "", "click on sign link ");
		if (seleniumCore.isElementVisible(adoptAndSign, 2, 1))
			this.seleniumCore.jsClick(this.seleniumCore.getDriver().findElement(adoptAndSign), "","click on adopt and sign button ");
		if (seleniumCore.isElementVisible(sign, 2, 1))
			this.seleniumCore.jsClick(this.seleniumCore.getDriver().findElement(sign), "", "click on sign link ");		
		if (seleniumCore.isElementVisible(view, 2, 1))
			this.seleniumCore.jsClick(this.seleniumCore.getDriver().findElement(view), "", "click on view link ");
		if (seleniumCore.isElementVisible(accept, 2, 1))
			this.seleniumCore.jsClick(this.seleniumCore.getDriver().findElement(accept), "", "click on accept button ");
		sign2Method();		
		clickFinishButton();
	}
	
	public void sign2Method() {
		while(true) {
			if (seleniumCore.isElementVisible(sign2, 2, 1)) {
				  this.seleniumCore.jsClick(this.seleniumCore.getDriver().findElement(sign2), "", "click on sign link ");
			}else {
				break;
			}
		}	
	}

	public void signDocument() {
		seleniumCore.waitForJStoLoad();
		waitForLoadingData();
		seleniumCore.waitForElementToBeVisible(signButton, 10, 1);
		seleniumCore.click(signButton);
		seleniumCore.waitForJStoLoad();
		waitForLoadingData();
	}
	
	public ItemDetailsPage eSignatureAdditionalAndSupplementalDocument() {		
		clickContinueButton();
		this.seleniumCore.waitForElementToBeVisible(sign, 10, 1);
		this.seleniumCore.jsClick(this.seleniumCore.getDriver().findElement(sign), "", "click on sign link ");
		this.seleniumCore.waitForElementToBeVisible(adoptAndSign, 15, 1);
		this.seleniumCore.jsClick(this.seleniumCore.getDriver().findElement(adoptAndSign), "","click on adopt and sign button ");
		this.seleniumCore.waitForElementToBeVisible(view, 15, 1);
		this.seleniumCore.jsClick(this.seleniumCore.getDriver().findElement(view), "", "click on view link ");
		this.seleniumCore.waitForElementToBeVisible(accept, 15, 1);
		this.seleniumCore.jsClick(this.seleniumCore.getDriver().findElement(accept), "", "click on accept button ");
		this.seleniumCore.waitForElementToBeVisible(viewAddSupp, 15, 1);
		this.seleniumCore.jsClick(this.seleniumCore.getDriver().findElement(viewAddSupp), "", "click on view link ");
		this.seleniumCore.waitForElementToBeVisible(accept, 15, 1);
		this.seleniumCore.jsClick(this.seleniumCore.getDriver().findElement(accept), "", "click on accept button ");
		this.seleniumCore.waitForElementToBeVisible(sign2, 15, 1);
		this.seleniumCore.jsClick(this.seleniumCore.getDriver().findElement(sign2), "","click on adopt and sign button ");
		clickFinishButton();
		this.seleniumCore.waitForElementToBeVisible(trackingCenterLink, 15, 1);
		this.seleniumCore.jsClick(this.seleniumCore.getDriver().findElement(trackingCenterLink), "", "click on tracking center link ");
		return new ItemDetailsPage(this.seleniumCore);
	}
	
	public void answerQuestions() {	
		signDocument();
		List<WebElement> elements= seleniumCore.findElements(By.xpath("//label[contains(text(),'never')]    |    //label[contains(text(),'None')]         |    //label[contains(text(),'not know')]"));
		for(WebElement element: elements) {
			seleniumCore.scrollIntoView(element);
			seleniumCore.waitForUILoading(500);
			element.click();
			seleniumCore.waitForUILoading(500);
		}		
	}
	
	public void eSign() {
		clickContinueButton();
		seleniumCore.waitForJStoLoad();
		waitForLoadingData();
		signArrow(adoptAndSign);
		clickFinishButton();
	}
	
	public void eInitial() {		
		signArrow(adoptAndInitial);
		clickFinishButton();
	}
	
	public void signArrow(By elem) {		
		List<WebElement> elements = seleniumCore.findElements(By.xpath("//*[@class='sign-arrow']/parent::div"));
		for (WebElement element : elements) {
			if (elements.size() == 0) {
				break;
			}
			seleniumCore.scrollIntoView(element);
			seleniumCore.waitForUILoading(500);
			element.click();
			seleniumCore.waitForUILoading(500);			
			if (seleniumCore.isElementVisible(elem, 2, 1))				
				this.seleniumCore.jsClick(seleniumCore.findElement(elem), "", "click on adopt and sign button ");
		}
		waitForUILoading(1000);
	}	

}
