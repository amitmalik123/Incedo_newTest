package com.amk.cucumber.utility;

import org.openqa.selenium.By;

import com.amk.cucumber.pages.AccountApprovalPage;
import com.amk.cucumber.pages.AccountListPage;
import com.amk.cucumber.pages.AccountWizardPage;
import com.amk.cucumber.pages.ClientListPage;
import com.amk.cucumber.services.Parser;

public class CommonMethods extends BasePage {

	
	protected By accountWizardLink = By
			.xpath("//div[@id='mainMenuContainer']//*[text()='Account Wizard']");
	
	protected By trackingCenterLink = By
			.xpath("//div[@id='mainMenuContainer']//*[text()='Tracking Center']");
	
	protected By accountApprovalLink = By
			.xpath("//div[@id='mainMenuContainer']//*[text()='Account Approval']");
	protected By clientStatus = By.xpath("//span[@id='inviteStatus']");
	protected By secondaryMenuAccountList = By.xpath("//ul[@class='secondaryMenu']/li[2]");
	protected By clientsTabLink = By
			.xpath("//*[@id='mainMenuWrapper']//li/a[@href='/AccountsAnalysis/Clients/ClientList']");
	protected final Parser parser = new Parser();

	public CommonMethods(SeleniumCore seleniumCore) {
		super(seleniumCore);
	}
	
	public AccountWizardPage clickAccountWizardTab() {
		this.seleniumCore.click(accountWizardLink, "Go to Client List", "click on account wizard tab");
		customLogger("click on account wizard tab", "");
		return new AccountWizardPage(seleniumCore);
	}
	
	public AccountApprovalPage clickAccountApprovalTab() {
		seleniumCore.waitForElementToBeVisible(accountApprovalLink, 10, 1);
		this.seleniumCore.click(accountApprovalLink, "Go to Client List", "click on account approval link");
		customLogger("click on account approval link", "");
		return new AccountApprovalPage(seleniumCore);
	}
	
	public ClientListPage clickClientsTab() {
		this.seleniumCore.click(clientsTabLink, "Go to Client List", "Clicked on Clients tab");
		customLogger("click on clients tab", "");
		return new ClientListPage(seleniumCore);
	}

	public AccountListPage clickAccountListTab() {
		this.seleniumCore.waitForElementToBeVisible(secondaryMenuAccountList);
		this.seleniumCore.click(secondaryMenuAccountList);
		customLogger("Clicked on Account list sub menu", "");
		return new AccountListPage(seleniumCore);
	}
}
