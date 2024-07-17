package com.amk.cucumber.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.amk.cucumber.utility.SeleniumCore;

public class BawHomePage extends BawBasePage {

	// Static Data
	private static final String PAGE_NAME = "BAW HOME PAGE";
	private static final String SEPARATOR = ":";
	protected By mainMenu = By.xpath(
			"//div[@id='Portal']/div/div[2]//div[@class='ContentBox fill-vertical']/div[1]//div[@title='Actions']//div[@class='menu-button menu-button-left']/a[@role='button']");
	protected By accountUpdateUtillity = By
			.xpath("//div[@id='collapseDashboardsMenu']/div/div[2]/div[1]//a[@role='link']");
	protected By bulkReasignCs = By.xpath("//div[@id='collapseDashboardsMenu']/div/div[2]/div[2]//a[@role='link']");
	protected By bulkWorkitemCreation = By
			.xpath("//div[@id='collapseDashboardsMenu']/div/div[2]/div[3]//a[@role='link']");
	protected By dashboard = By.xpath("//a[contains(text(),'Dashboard')]");
	protected By myItemsDueToday = By.xpath("//div[@id='collapseDashboardsMenu']/div/div[2]/div[5]//a[@role='link']");
	protected By searchWorkitem = By.xpath("//div[@id='collapseDashboardsMenu']/div/div[2]/div[6]//a[@role='link']");
	protected By searchWorkitemLegacy = By
			.xpath("//div[@id='collapseDashboardsMenu']/div/div[2]/div[7]//a[@role='link']");
	protected By wfiReport = By.xpath("//div[@id='collapseDashboardsMenu']/div/div[2]/div[8]//a[@role='link']");

	protected By logout = By.xpath(
			"//div[@id='Portal']/div/div[1]//div[@class='ContentBox fill-vertical']/div[1]//div[@title='Dashboards']//div[@class='profile-actions']/div[2]/a[@role='link']");

	protected By frame = By.xpath("//*[@data-viewid='CoachViewer']//iframe[@title]");
	private By showMore = By.xpath("//a[contains(text(),'Show more')]");

	public BawHomePage(SeleniumCore seleniumCore) {
		this(seleniumCore, true);
	}

	public BawHomePage(SeleniumCore seleniumCore, boolean pageVerification) {
		super(seleniumCore);
		if (pageVerification) {
			boolean isVisible = seleniumCore.isUrlContains("ProcessPortal", 20, 1);
			if (isVisible) {
				logger.info(PAGE_NAME + " verification" + SEPARATOR + PAGE_NAME + " verification is PASSED");
			} else {
				logger.warn(PAGE_NAME + " verification" + SEPARATOR + PAGE_NAME + " verification is FAILED");
			}
		}
	}

	public String verifyPageTitle() {
		return this.seleniumCore.getDriver().getTitle();
	}

	public void openNewWorkItem(String stepName, String logMessage) throws InterruptedException {
		logger.info(stepName + SEPARATOR + "");
		By openNewWorkItemButton = By.xpath("//*[@id='ButtonGroup5_Button0']");

		this.seleniumCore.waitForElementToBeVisible(frame);
		this.seleniumCore.getDriver().switchTo().frame(this.seleniumCore.getDriver().findElement(frame));
		this.seleniumCore.getDriver().findElement(openNewWorkItemButton).click();

		switchTab(2, "Switch tab");
	}

	public void goToSearchForWorkItemPage(String stepName, String logMessage) {
		logger.info(stepName + SEPARATOR + "");
		By searchForWorkItemButton = By
				.xpath("(//div[@class='menu-link-body']/a[contains(text(),'Search Work Item')])[1]");

		switchWindow(1);
		this.seleniumCore.click(searchForWorkItemButton);
	}

	public void searchForBItem(String stepName, String bNumber, String logMessage) {
		logger.info(stepName + SEPARATOR + "");
		By bSearchInput = By.xpath("//*[@id='txtBNum']");
		By searchForBinDashboard = By.xpath("//*[@id='ButtonGroup4_Search']");
		logger.info("Search for B number" + SEPARATOR + bNumber);
		this.seleniumCore.waitForElementToBeVisible(frame);
		this.seleniumCore.getDriver().switchTo().frame(this.seleniumCore.getDriver().findElement(frame));
		this.seleniumCore.getDriver().findElement(bSearchInput).sendKeys(bNumber);
		this.seleniumCore.getDriver().findElement(searchForBinDashboard).click();
	}

	public void checkIfAlertVisible(String stepName) {
		logger.info(stepName + SEPARATOR + "");
		By alertOnDocument = By.xpath("//*[@id='TaskTable']/tbody/tr[1]/td[2]/img");
		Boolean isAlertVisible = this.seleniumCore.isElementVisible(alertOnDocument);
		Assert.assertTrue("Alert is not visible", isAlertVisible);
	}

	public void enterToBNumber(String stepName, String parentBnumber) {
		WebElement runItem = this.seleniumCore.findElement(By.xpath("//a[contains(text(),'" + parentBnumber + "')]"));
		clickRunButton(runItem);
		switchTab(2, stepName);
	}

	public BawDashboardPage moveToDashboard() {
		if (this.seleniumCore.isElementVisible(showMore,10,1)) {
			this.seleniumCore.click(showMore);
			logger.info("Click on showMore ");
			customLogger("Click on showMore ", "");
		}
		try {
			this.seleniumCore.waitForElementToBeVisible(dashboard,10,1);
			this.seleniumCore.click(dashboard, PAGE_NAME, " Clicking on dashboard");
			customLogger("Click on dashboard", "");
			logger.info("Click on dashboard ");
		}
		catch(Exception e)
		{
			logger.info(e.getStackTrace()[0].getFileName() + " :: "+ e.getStackTrace()[0].getClassName() + " : "+e.getStackTrace()[0].getMethodName() );
			customLogger(e.getStackTrace()[0].getFileName() + " :: "+ e.getStackTrace()[0].getClassName() + " : "+e.getStackTrace()[0].getMethodName(), "");
		}
		this.seleniumCore.waitForElementToBeVisible(frame);
		this.seleniumCore.getDriver().switchTo().frame(this.seleniumCore.getDriver().findElement(frame));
		return new BawDashboardPage(seleniumCore);
	}
}