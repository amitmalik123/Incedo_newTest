package com.amk.cucumber.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import com.amk.cucumber.utility.CommonMethods;
import com.amk.cucumber.utility.ConfigReader;
import com.amk.cucumber.utility.SeleniumCore;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

public class BawBasePage extends CommonMethods {

	public static ConfigReader configReader = new ConfigReader();
	protected SeleniumCore seleniumCore;
	protected Logger logger = Logger.getLogger(BawBasePage.class);
	BawHomePage bawHomePage;
	BawDashboardPage bawDashboardPage;

	public BawBasePage(SeleniumCore seleniumCore) {
		super(seleniumCore);
		this.seleniumCore = seleniumCore;
		this.logger = seleniumCore.getLogger();
	}

	public void switchTab(int tabNumber, String logMessage) {
		seleniumCore.numberOfWindows(tabNumber);
		ArrayList<String> tabs = new ArrayList<>(seleniumCore.getDriver().getWindowHandles());
		seleniumCore.getDriver().switchTo().window(tabs.get(tabNumber - 1));
		logger.info("Switch to tab: " + seleniumCore.getDriver().getTitle());
		customLogger("Switched to tab title is ", seleniumCore.getDriver().getTitle());
	}

	public String getCurrentWindowHandle() {
		// Store the current window handle
		return this.seleniumCore.getDriver().getWindowHandle();
	}

	public void switchWindow(int tabNumber) {
		List<String> tabs = new ArrayList<>(seleniumCore.getDriver().getWindowHandles());
		this.seleniumCore.getDriver().switchTo().window(tabs.get(tabNumber - 1));
		logger.info("Switch to tab: " + tabNumber);
	}

	public void switchTab(String pageTitle) {
		ArrayList<String> tabs = new ArrayList<>(seleniumCore.getDriver().getWindowHandles());
		for (int i = 0; i < tabs.size(); i++) {
			seleniumCore.getDriver().switchTo().window(tabs.get(i));			
			if (seleniumCore.getDriver().getTitle().toLowerCase().contains(pageTitle.toLowerCase()))
				break;
		}
		logger.info("Switched to tab: " + seleniumCore.getDriver().getTitle());
		customLogger("Switched to tab, title is ", seleniumCore.getDriver().getTitle());
	}
	
	public int switchTab() {
		ArrayList<String> tabs = new ArrayList<>(seleniumCore.getDriver().getWindowHandles());
		customLogger("total opened windows are ", String.valueOf(tabs.size()));
		for (int i = 0; i < tabs.size(); i++) {
			seleniumCore.getDriver().switchTo().window(tabs.get(i));			
			logger.info("Switched to tab: " + seleniumCore.getDriver().getTitle());
			customLogger("tab title is ", seleniumCore.getDriver().getTitle());
		}		
		return tabs.size();
	}

	public WebElement searchWebElement(By element) {
		WebElement webElement = seleniumCore.waitForElementToBeVisible(element, 10, 1);
		return webElement;
	}

	public static void customLogger(String log, String value) {
		if (value.isEmpty())
			ExtentCucumberAdapter.addTestStepLog(" . . . . " + log);

		else
			ExtentCucumberAdapter.addTestStepLog(" . . . . " + log + " : " + value);
	}

	public static void emptyLogger(String log) {
		ExtentCucumberAdapter.addTestStepLog(" ~ " + log);

	}

	public void switchToNewTabByKeys() {
		seleniumCore.waitForUILoading(5000);
		try {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_SHIFT);
			r.keyPress(KeyEvent.VK_TAB);
			r.keyRelease(KeyEvent.VK_CONTROL);
			r.keyRelease(KeyEvent.VK_SHIFT);
			r.keyRelease(KeyEvent.VK_TAB);
		} catch (AWTException e) {
			e.printStackTrace();
		}

		this.logger.info("Switching to new Tab" + ":" + "Switched");
	}

	public void clickRunButton(WebElement runItem) {			
		action.keyDown(Keys.CONTROL).click(runItem).keyUp(Keys.CONTROL).build().perform();			
	}	
		
	public void moveToElementAndClick(WebElement runItem) {	
		action.moveToElement(runItem).keyDown(Keys.ENTER).keyUp(Keys.ENTER).build().perform();	
	}	
	public void clickTabKey() {			
		action.sendKeys(Keys.TAB).build().perform();	
	}

	public void switchWindow(String parentWindow) {
		seleniumCore.getDriver().switchTo().window(parentWindow);
	}

	public boolean isInClosedRange(Integer number, Integer lowerBound, Integer upperBound) {
		return (lowerBound <= number && number <= upperBound);
	}

	public void performSikuliClick(String imageName) {
		Screen screen = new Screen();
		Pattern image = new Pattern(System.getProperty("user.dir") + "\\fileToUpload\\" + imageName + ".PNG");
		Boolean ImageClicked = Boolean.FALSE;
		for (int i = 0; i < 25; i++) {
			try {
				screen.click(image);
				ImageClicked = Boolean.TRUE;
				break;
			} catch (Exception e) {
			}
			seleniumCore.waitForUILoading(250);
		}

		if (!ImageClicked) {
			logger.info("Image not clicked by Sikuli even after waiting");
		}

	}

	public void theBAWApprovalRerunWithBnum(String bTrackingId) throws InterruptedException {
		timeStamp();
		logger.info("--- ---  ---  ---- --- Reruning with B Track ID :: " + bTrackingId);
		bawHomePage = loginToApplicationBusinessAutomationWorkflow();
		bawDashboardPage = bawHomePage.moveToDashboard();
		WebElement runElement = this.seleniumCore
				.findElement(By.xpath("//a[text()='" + bTrackingId + "']//parent::td//preceding-sibling::td[3]"));
		Actions newTab = new Actions(this.seleniumCore.getDriver());
		newTab.keyDown(Keys.CONTROL).click(runElement).keyUp(Keys.CONTROL).build().perform();
		customLogger("Clicking on Run button", "");
		bawDashboardPage.switchTab("Shell Process");
		waitForUILoading(1000);
		customLogger("Tab Switching", "");
		timeStamp();
		approveShellHarvestRequest();
		timeStamp();
	}

	public void timeStamp() {
		Long datetime = System.currentTimeMillis();
		Timestamp timestamp = new Timestamp(datetime);
		logger.info("***** ###### ------ Current Time Stamp : : : " + timestamp);
		customLogger("***** ###### ------ Current Time Stamp : : : " + timestamp, "");
	}

	public BawHomePage loginToApplicationBusinessAutomationWorkflow() {
		String stepName = "Login To Application";
		this.seleniumCore.get(configReader.get_BawApplication_URL(), stepName,
				"Launching Application URL. " + configReader.get_BawApplication_URL());
		customLogger("Launching Application URL. ", configReader.get_BawApplication_URL());
		BawLoginPage bawLoginPage = new BawLoginPage(seleniumCore);
		return bawLoginPage.login(configReader.get_BawApplication_Username(),
				configReader.get_BawApplication_Password(), stepName);
	}
	
	public void approveShellHarvestRequest() {
		By checkbox = By.xpath("//input[@id='TLHCheckbox_checkbox']");
		 By approvalBtn = By.xpath("//button[@id='ButtonGroup31_btnActivateTLH']");
		searchWebElement(checkbox);
		this.seleniumCore.click(checkbox,"Clicking on Approval Checkbox","Clicked");
		logger.info("-- Clicked on checkbox in TLH Request approval --");
		searchWebElement(approvalBtn);
		this.seleniumCore.click(approvalBtn);
		customLogger("clicking on approval button ", "");
		logger.info("-- Clicked on Approve TLH Button --");
		this.seleniumCore.handleAlert("OK");
		logger.info("-- Alert Accepted --");
		customLogger("TLH Request Approved..", "");
	}
}