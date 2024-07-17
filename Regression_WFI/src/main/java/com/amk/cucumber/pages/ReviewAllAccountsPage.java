package com.amk.cucumber.pages;

import com.amk.cucumber.utility.BasePage;
import com.amk.cucumber.utility.SeleniumCore;

// import com.eWM.pageobjects.common.accountWizard.createNewClient.CreateDocumentsPage;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ReviewAllAccountsPage extends BasePage {

    // Static Data
    private static final String PAGE_NAME = "REVIEW ALL ACCOUNTS PAGE";

    // Page Locators
    private final By reviewAllAccountsPageLabel = By.cssSelector(".review-all-accounts-header h1");
    private final By createDocuments = By.cssSelector(".btn.btn-primary.btn-next");
    private final List<WebElement> approvalPoints = this.seleniumCore.findElements(By.cssSelector(".interview-page-summary span:first-of-type"));
    private final By requiredInformationMissingModel = By.cssSelector("#MissingInformationModal");
    private final By requiredInformationMissingModelYesButton = By.cssSelector("#create_documents_btn");

    public ReviewAllAccountsPage(SeleniumCore seleniumCore) {
        this(seleniumCore, true);
    }

    public ReviewAllAccountsPage(SeleniumCore seleniumCore, boolean pageVerification) {
        super(seleniumCore);
        
        if (pageVerification) {
            if (seleniumCore.isElementVisible(reviewAllAccountsPageLabel)) {
                logger.info(PAGE_NAME + " verification" +" : "+ PAGE_NAME + " verification is PASSED");
            } else {
                logger.warn(PAGE_NAME + " verification" +" : "+ PAGE_NAME + " verification is FAILED");
            }
        }
    }

    public void checkIfAllApproved() {
    	waitForLoadingData();
        for (WebElement ele : approvalPoints) {
            if (!ele.getCssValue("background").contains("green")) {
                logger.info("Step: " + ele.getText() +" "+ " is not completed");
            }
        }
    }

	
	public CreateDocumentsPage confirmClientsDocuments() {
		this.seleniumCore.waitForElementToBeFound(createDocuments).click();
		if(seleniumCore.isElementFound(requiredInformationMissingModel,5,1)) {
			seleniumCore.click(requiredInformationMissingModelYesButton);
		}
		logger.info("click on create documents button");
		customLogger("click on create documents button","");
		return new CreateDocumentsPage(seleniumCore);
	}
	 
}
