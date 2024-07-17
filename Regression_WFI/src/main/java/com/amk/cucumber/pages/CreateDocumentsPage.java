package com.amk.cucumber.pages;

import org.openqa.selenium.By;

import com.amk.cucumber.utility.BasePage;
import com.amk.cucumber.utility.SeleniumCore;

public class CreateDocumentsPage extends BasePage {

	// Static Data
	private static final String PAGE_NAME = "CREATE DOCUMENTS PAGE";

	// Page Locators
	private static final By CreateDocumentsPageLabel = By.cssSelector(".PageHeading");
//	private final By createDocuments = By.id("create_documents_button");
	private final By uploadAccountPaperworkModalTitle = By.cssSelector("#confirmOverwriteModalLabel");
	private final By uploadAccountPaperworkModalYesButton = By.cssSelector("#button-overwrite-approval");
	private final By goToCreateDocumentsPage = By.xpath("//button[@class='btn btn-primary btn-next']     |     //button[@id='create_documents_button']");  

	public CreateDocumentsPage(SeleniumCore seleniumCore) {
		this(seleniumCore, true);
	}

	public CreateDocumentsPage(SeleniumCore seleniumCore, boolean pageVerification) {
		super(seleniumCore);
		
		if (pageVerification) {
			if (seleniumCore.isElementVisible(CreateDocumentsPageLabel)) {
				logger.info(PAGE_NAME + " verification" + " : " + PAGE_NAME + " verification is PASSED");
			}
		}
	}

	public static By getLabel() {
		return CreateDocumentsPageLabel;
	}

	public ViewDocumentsPage createDocumentsConfirmation(String stepName, String logMessage) {
		waitForLoadingData();
		seleniumCore.isElementVisible(goToCreateDocumentsPage, 30, 1);
		this.seleniumCore.click(goToCreateDocumentsPage, stepName, logMessage);	
		customLogger(logMessage,"");
		return new ViewDocumentsPage(seleniumCore);
	}

	public void createDocumentsConfirmation() {
		seleniumCore.isElementVisible(uploadAccountPaperworkModalTitle, 10, 1);
		this.seleniumCore.click(uploadAccountPaperworkModalYesButton, "click on yes button on uploaded account paperwork", "");

	}
}
