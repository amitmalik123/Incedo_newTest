package com.amk.cucumber.pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import com.amk.cucumber.exceptions.DefaultException;
import com.amk.cucumber.utility.SeleniumCore;

public class BawDashboardPage extends BawBasePage {

	private static final String PAGE_NAME = "BAW DASHBOARD PAGE";

	private By assignedToMeTab = By.xpath("//font[text()='Unassigned ']");
	private By searchBNum = By.xpath("//input[@id='txtBNum']");
	private By searchButton = By.xpath("//button[text()='Search']");
	private By internalStatus = By.cssSelector("#TaskTable");
	private By openNewWorkItemButton = By.cssSelector("#ButtonGroup5_Button0");
	private By username = By.cssSelector("#username");
	protected By frame = By.xpath("//*[@data-viewid='CoachViewer']//iframe[@title]");
	private By filtersSection = By.xpath("//table[@id='section13']/tbody/tr[@class='sectionHeader twSectionTitle']");
	private By amountFilter = By.xpath("//*[@id='AmountFilterComboBox_chosen']");
	private By amountFilterSearch = amountFilter.xpath("//div[@class='chosen-drop']//input");
	private By amountFilterSelectSearch = amountFilter.xpath("//ul[@class='chosen-results']/li");
	private By saveCurrentFilterButton = By.cssSelector("#ButtonGroup8_Button0");
	private By saveFilterModel = By.cssSelector("#section5_SectionTitle> div");
	private By saveFilterNameModel = By.cssSelector("#InputText3");
	private By saveButtonModel = By.cssSelector("#ButtonGroup6_Button0");
	private By savedFilter = By.cssSelector("#InputText4");
	private By filterButton = By.cssSelector("#ButtonGroup0_Filter");
	private By resetFilterButton = By.cssSelector("#ButtonGroup0_Button0");
	private By filterAllButton = By.cssSelector("#ButtonGroup0_Button1");
	private By deleteButton = By.cssSelector("#ButtonGroup7_Button0");
	private By taskTable = By.cssSelector("#CustomHTML5 > table");

	public BawDashboardPage(SeleniumCore seleniumCore) {
		this(seleniumCore, true);
	}

	public BawDashboardPage(SeleniumCore seleniumCore, boolean pageVerification) {
		super(seleniumCore);
		if (pageVerification) {
			boolean isVisible = seleniumCore.isElementVisible(assignedToMeTab, 20, 1);
			if (isVisible) {
				logger.info(PAGE_NAME + " verification" + ":" + PAGE_NAME + " verification is PASSED");
				customLogger(PAGE_NAME, " verification is PASSED");
			} else {
				logger.warn(PAGE_NAME + " verification" + ":" + PAGE_NAME + " verification is FAILED");
				customLogger(PAGE_NAME, " verification is FAILED");
			}
		}
	}

	public String enterBNumberToSearch(String bTrackingId) {
		seleniumCore.waitForJStoLoad();
		// waitForLoadingData();
		this.seleniumCore.waitForElementToBeVisible(searchBNum);
		this.seleniumCore.sendKeys(searchBNum, bTrackingId, PAGE_NAME, " Entering B Tracking Id in Search Box");
		customLogger("Enter b number in search box ", bTrackingId);
		this.seleniumCore.click(searchButton, PAGE_NAME, " Clicking on Search Button");
		seleniumCore.waitForJStoLoad();
		waitForLoadingData();
		customLogger("Clicking on Search Button", "");
		return getCurrentWindowHandle();
	}

	public void switchToFrame() {
		seleniumCore.waitForJStoLoad();
		waitForLoadingData();
		this.seleniumCore.waitForElementToBeVisible(frame, 20, 1);
		this.seleniumCore.getDriver().switchTo().frame(this.seleniumCore.getDriver().findElement(frame));
	}

	public Object runBTrackingNum(String bTrackingId, String pageTitle) {
		seleniumCore.waitForJStoLoad();
		waitForLoadingData();
		WebElement runButton;
		if (seleniumCore.waitForElementToBeVisible(taskTable, 50, 1) == null) {
			throw new DefaultException("searched d number is not visible");
		}
		if (bTrackingId != null) {
			try {
				runButton = seleniumCore.findElement(By.cssSelector("img[onclick*='" + bTrackingId + "']"));
			} catch (Exception e) {
				runButton = this.seleniumCore.findElement(
						By.xpath("//a[text()='" + bTrackingId + "']//parent::td//preceding-sibling::td[3]"));
			}
		} else {
			try {
				runButton = seleniumCore.findElement(By.cssSelector("#TaskTable > tbody>tr>td> img"));
			} catch (Exception e) {
				runButton = this.seleniumCore
						.findElement(By.xpath("//table[@id='TaskTable']//tbody//tr[position() = (last() - 1)]/td/img"));
			}
		}
		seleniumCore.waitForUILoading(3000);
		try {
			clickRunButton(runButton);
		} catch (Exception e) {
			logger.info(e.getStackTrace()[0].getFileName() + " :: " + e.getStackTrace()[0].getClassName() + " :: "
					+ e.getStackTrace()[0].getMethodName() + " :: " + e.getStackTrace()[0].getLineNumber());
			try {
				runButton.click();
			} catch (Exception e2) {
				try {
					seleniumCore.jsClick(runButton, "", "");
				} catch (Exception e1) {
					moveToElementAndClick(runButton);
					logger.info(e1.getStackTrace()[0].getFileName() + " :: " + e1.getStackTrace()[0].getClassName()
							+ " :: " + e1.getStackTrace()[0].getMethodName() + " :: "
							+ e1.getStackTrace()[0].getLineNumber());
				}
			}
		}
		logger.info("Clicked on run button");
		customLogger("Clicked on run button", "");
		seleniumCore.waitForJStoLoad();
		waitForLoadingData();
		switchTab(pageTitle);
		logger.info("page to be switch to: " + pageTitle);
		if (pageTitle.contains("Shell Process")) {
			return new ShellProcessPage(seleniumCore);
		} else if (pageTitle.contains("Withdrawal Request")) {
			return new IRAWithdrawalRequestPage(seleniumCore);
		} else if (pageTitle.contains("NAA Coach")) {
			return new NAACoachPage(seleniumCore);
		} else {
			new DefaultException("page type is not found");
			return null;
		}
	}

	public Object runBTrackingNumAndValidate(String option) throws NullPointerException {
		List<WebElement> runButton = null;
		if (option.contains("withdrawal")) {
			runButton = seleniumCore.findElements(
					By.xpath("//td[contains(text(),'Withdrawal Request')]/parent::tr/preceding-sibling::tr[1]/td/img"));
		} else {
			runButton = seleniumCore.findElements(By.xpath("//td[@class='FontStyle3']/parent::tr/td/img"));
		}
		WebElement element = runButton.get(runButton.size() - 1);
		seleniumCore.scrollIntoView(element);
		seleniumCore.waitForUILoading(1000);
		clickRunButton(element);
		if (seleniumCore.getDriver().getWindowHandles().size() == 1) {
			clickRunButton(runButton.get(runButton.size() - 2));
		}
		logger.info("Clicked on run button");
		customLogger("Clicked on run button", "");
		seleniumCore.waitForJStoLoad();
		waitForLoadingData();
		seleniumCore.numberOfWindows(2);
		switch(option) {
		 case "transfer":
		 case "distribution":		
			switchTab("Shell Process");
			return new ShellProcessPage(seleniumCore);
		default:
			return null;
		} 
	}

	public String validateInternalStatus() {
		customLogger("Switched back to BAW window ", "");
		return seleniumCore.getText(internalStatus);
	}

	public void validateChangedUser() {
		Assert.assertNull("work item is not reassigned ", seleniumCore.findElement(internalStatus));
		logger.info("work item is not visble under current user ");
		customLogger("work item is not visble under current user ", "");
	}

	public void switchBackToUploadFile(String parentWindow) {
		seleniumCore.getDriver().switchTo().window(parentWindow);
	}

	public ShellProcessPage clickOpenNewWorkItemButton() {
		this.seleniumCore.waitForElementToBeVisible(openNewWorkItemButton, 40, 1);
		this.seleniumCore.click(openNewWorkItemButton, PAGE_NAME, "Clicking on Search Button");
		logger.info("clicked on open new workitem button ");
		customLogger("clicked on open new workitem button ", "");
		switchTab("Shell Process");
		return new ShellProcessPage(seleniumCore);
	}

	public Object clickSearchWorkItem(String text) {
		seleniumCore.waitForJStoLoad();
		waitForLoadingData();
		seleniumCore.doesTitleContainText("Process Portal", 30, 1);
		seleniumCore.switchToDefaultContent();
		logger.info("user switched to default content");
		customLogger("user switched to default content", "");
		if (!seleniumCore.isElementVisible(By.cssSelector("#collapseDashboardsMenu"), 10, 1)) {
			new DefaultException("dashboard menu is not visible");
		}		
		By searchWorkItemLink = By.xpath("//div[contains(@class,'menu_link')]/div/div/div[@class='menu-link-body']/a[@title='"+text+"']");
		WebElement ele = seleniumCore.findElement(searchWorkItemLink);
		if (ele == null)
			throw new DefaultException("element is null");
		if (text.contains("Bulk Reassign") || text.contains("Set QC Selection")) {
			seleniumCore.scrollIntoView(seleniumCore.findElement(searchWorkItemLink));
			logger.info(text + " is being scrolled into");
			customLogger(text, " is being scrolled into");
		}
		try {
			this.seleniumCore.click(searchWorkItemLink, PAGE_NAME, "Click on " + text + " tab");
		} catch (Exception e) {
			seleniumCore.jsClick(seleniumCore.findElement(searchWorkItemLink), "", "");
			logger.info(e.getLocalizedMessage());
		}
		logger.info("Click on " + text + " tab" + "");
		customLogger("Click on " + text + " tab", "");
		 
		if (text.contains("Search Work")) {	
			return new SearchWorkItemPage(seleniumCore);
		} else if (text.contains("Bulk Reassign")) {
			return new BulkReassignPage(seleniumCore);
		} else if (text.contains("Account Update")) {			
			return new AccountUpdateUtilityPage(seleniumCore);
		} else if (text.contains("Set QC Selection")) {
			return new SetQCSelectionPage(seleniumCore);
		}else if (text.contains("out List")) {
			return new OptOutListPage(seleniumCore);
		}else if (text.contains("Dashboard")) {
			waitForLoadingData();
			seleniumCore.switchToFrame(By.xpath("//iframe[@title='Dashboard']"), 60, 1);
			return null;
		} else {
			logger.info("tab option is not matching");
			return null;
		}
	}

	public void clickLogOutLink() {
		Screen screen = new Screen();
		Pattern okButton = new Pattern(System.getProperty("user.dir") + "\\fileToUpload\\logout.png");
		try {
			for (int i = 0; i < 4; i++) {
				screen.click(okButton);
				if (seleniumCore.isElementVisible(username, 5, 1))
					break;
			}
		} catch (FindFailed e1) {
			e1.printStackTrace();
		}
		logger.info("clicked on logout  " + "");
		customLogger("clicked on logout ", "");
	}

	public void clickFilterSection() {
		seleniumCore.waitForElementToBeVisible(filtersSection, 10, 1);
		seleniumCore.click(filtersSection);
		logger.info("click on filters section");
		customLogger("click on filters section ", "");
	}

	public void createFilterOnAmount(String value) {
		seleniumCore.waitForElementToBeVisible(amountFilter, 10, 1);
		seleniumCore.click(amountFilter);
		seleniumCore.waitForElementToBeVisible(amountFilterSearch, 10, 1);
		seleniumCore.sendKeys(amountFilterSearch, value, "enter amount range");
		seleniumCore.click(amountFilterSelectSearch);
		logger.info("create filter on amount parameter");
		customLogger("create filter on amount parameter ", "");
	}

	public void saveCurrentFilterButton() {
		seleniumCore.waitForElementToBeVisible(saveCurrentFilterButton, 10, 1);
		seleniumCore.click(saveCurrentFilterButton);
		logger.info("click on save current filter section");
		customLogger("click on save current filter section ", "");
	}

	public void validateSaveFilterModelAndSaveFilter(String value) {
		seleniumCore.waitForElementToBeVisible(saveFilterModel, 10, 1);
		Assert.assertTrue("save filter model is not found ", seleniumCore.isElementFound(saveFilterModel));
		seleniumCore.sendKeys(saveFilterNameModel, value, "filter name is " + value);
		seleniumCore.click(saveButtonModel);
		logger.info("click on filters section");
		customLogger("click on filters section ", "");
	}

	public void validateSavedFilter(String value) {
		seleniumCore.waitForElementToBeVisible(savedFilter, 10, 1);
		Select select = new Select(seleniumCore.findElement(savedFilter));
		List<WebElement> lst = select.getOptions();
		for (WebElement options : lst) {
			if (options.getText().equals(value)) {
				Assert.assertEquals(value, options.getText(), value);
				break;
			}
		}
	}

	public void clickFilterButton() {
		seleniumCore.waitForElementToBeVisible(filterButton, 10, 1);
		seleniumCore.click(filterButton);
		logger.info("click on filter button");
		customLogger("click on filter button  ", "");
	}

	public void validateAppliedFilterCriteria(int startValue, int endValue) {
		List<WebElement> element = seleniumCore.findElements(By.xpath("//table[@id='TaskTable']/tbody/tr"));
		for (int i = 2; i <= element.size(); i = i + 2) {
			By abc = By.xpath("//table[@id='TaskTable']/tbody/tr[" + i + "]/td[10]");

			String text = seleniumCore.findElement(abc).getText();
			Float finalValue = Float.valueOf(text.replace(",", ""));
			int fv = Math.round(finalValue);
			logger.info(fv);
			boolean checked = isInClosedRange(fv, 5000, 25000);
			Assert.assertTrue("amount is not in the selected range", checked);
		}
		logger.info("filtered data has been verified ");
		customLogger("filtered data has been verified ", "");
	}

	public void clickResetButton() {
		seleniumCore.waitForElementToBeVisible(resetFilterButton, 10, 1);
		seleniumCore.click(resetFilterButton);
		logger.info("click on reset button");
		customLogger("click on reset button  ", "");
	}

	public void validateResetFilterCriteria() {
		int number = Integer
				.valueOf(seleniumCore.findElement(By.xpath("//*[@id='CustomHTML2']/p[2]")).getText().substring(13, 15));
		for (int i = 2; i < number / 2; i = i + 2) {
			By abc = By.xpath("//table[@id='TaskTable']/tbody/tr[" + i + "]/td[10]");

			String text = seleniumCore.findElement(abc).getText();
			if (text == null) {
				Assert.assertTrue(text == null);
				break;
			}
		}
		logger.info("reset data has been verified ");
		customLogger("reset data has been verified ", "");
	}

	public void clickFilterAllButton() {
		seleniumCore.waitForElementToBeVisible(filterAllButton, 10, 1);
		seleniumCore.click(filterAllButton);
		logger.info("click on filter all button");
		customLogger("click on filter all button  ", "");
	}

	public void deleteCreatedFilter(String value) {
		seleniumCore.waitForElementToBeVisible(savedFilter, 10, 1);
		seleniumCore.click(savedFilter);
		seleniumCore.selectByValue(savedFilter, value, "", "", 5, 1);
		waitForLoadingData();
		seleniumCore.waitForElementToBeVisible(deleteButton, 10, 1);
		seleniumCore.click(deleteButton);
		logger.info("click on delete button");
		customLogger("click on delete button  ", "");
	}

	public void validateDeletedFilter(String value) {
		seleniumCore.waitForElementToBeVisible(savedFilter, 10, 1);
		Select select = new Select(seleniumCore.findElement(savedFilter));
		List<WebElement> lst = select.getOptions();
		for (WebElement options : lst) {
			Assert.assertNotEquals(value, options.getText(), value);
		}
		logger.info("created filter has been deleted");
		customLogger("created filter has been deleted  ", "");
	}

	public Object runBTrackingNumberToApproveHarvestRequest(String bTrackingId, String page) {
		By appId = By.xpath(
				"//a[text()='" + bTrackingId + "']//parent::td//preceding-sibling::td[1]//input[@type='checkbox']");
		this.seleniumCore.click(appId, PAGE_NAME, "Clicking on App ID");
		return runBTrackingNum(bTrackingId, page);
	}

	public void clickBTrackingNum(String bTrackingId, String page) {
		WebElement bNumberLink = this.seleniumCore.findElement(By.xpath("//a[text()='" + bTrackingId + "']"));
		seleniumCore.jsClick(bNumberLink, "click B#", "");
		logger.info("Clicked on b number");
		customLogger("Clicked on b number", "");
		seleniumCore.waitForJStoLoad();
		waitForLoadingData();
		switchTab(page);
		seleniumCore.waitForJStoLoad();
		waitForLoadingData();
		seleniumCore.waitForUILoading(5000);
		Assert.assertTrue("page title is not as expected", seleniumCore.doesTitleContainText(page, 10, 1));
	}

	public void validateTaskTable() {
		Assert.assertNull("B number not displaying on dashboard",
				seleniumCore.waitForElementToBeVisible(taskTable, 2, 1));
	}
}
