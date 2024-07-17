package com.amk.cucumber.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.amk.cucumber.instantiator.Instantiator;
import com.amk.cucumber.utility.CommonMethods;
import com.amk.cucumber.utility.SeleniumCore;

public class TrackingCenterPage extends CommonMethods implements Instantiator<TrackingCenterPage> {

	// Static Data
	private static final String PAGE_NAME = "Tracking Center PAGE (CLIENT DETAIL)";

	// Page Locators
	private final By pageLabel = By.xpath("//*[@id='genworth-breadcrumb']//a[contains(text(),'Tracking Center')]");

	// Filters
	private final By filterType = By.xpath("//span[text()='Type']");
	private final By filterStatus = By.xpath("//div[@id='filter-1']");
	private final By filterStatusApplyBtn = By.xpath("//div[@id='filter-1']//div[text()='Apply']");
	private final By filterStatusAllCheckbox = By
			.xpath("//div[@id='filter-1']//label[text()='All']/preceding-sibling::a");
	private final By filterTypeAllCheckbox = By
			.xpath("//div[@class='checkboxContainer checkboxAllContainer']//label[text()='All']/preceding-sibling::a");
	private final By filterTypeApplyBtn = By.xpath(
			"//div[contains(@class,'filterbar')]//*[contains(text(),'Type')]//ancestor::div[contains(@class, 'content')]//div[text()='Apply']");
	private final By filterTypeRestoreDefaults = By.xpath("//a[@defaultvalues='All']");
	private By selectFilterCheckbox;
	public By yesAdvisorActions = By.xpath("//td[text()='Yes']");

	// Table
	private final By advisorActionHeader = By.xpath("//th[@id='TrackingCenterGrid_AdvisorResponse']");
	private final By firstItemInTable = By.xpath("//td[text()='No'][1]/parent::tr[1]");
//	private final By firstItemInTable = By.xpath("//td[text()='No'][1]/parent::tr[1][starts-with(@id,'B')]");
	private final By bundleIcon = By.xpath("//div[@class='bundle-icon']");
	private final By searchBox = By.cssSelector("#client_search_input");
	private final By searchbutton = By.cssSelector("#searchbutton");
	private final By recallButton = By.cssSelector("div.recall-button");
	private final By recallConfirmationMessage = By.cssSelector("div.item-confirmation");
	
	private final By brokerDealerLink = By.xpath("//*[contains(text(),'Broker-Dealer Approvals')]");
	private final By recallOkButton = By.xpath("//button/span[contains(text(),'Ok')]");
	private final By trackingCenterLink = By.xpath("//*[contains(text(),'Tracking Center Items')]");
	

	@Override
	public TrackingCenterPage getInstance() {
		return new TrackingCenterPage(seleniumCore);
	}

	/**
	 * To construct the Tracking Center Page
	 *
	 * @param seleniumCore
	 */
	public TrackingCenterPage(SeleniumCore seleniumCore) {
		this(seleniumCore, true);
	}

	/**
	 * To construct the Tracking Center Page
	 *
	 * @param seleniumCore
	 * @param pageVerification - Flag to check if the page is loaded or not
	 */
	public TrackingCenterPage(SeleniumCore seleniumCore, boolean pageVerification) {
		super(seleniumCore);
		if (pageVerification) {
			boolean isVisible = seleniumCore.isElementVisible(pageLabel, 40, 1);
			if (isVisible) {
				this.seleniumCore.getLogger().info(PAGE_NAME + " verification"+":"+ PAGE_NAME + " verification is PASSED");
			} else {
				this.seleniumCore.getLogger().info(PAGE_NAME + " verification"+":"+ PAGE_NAME + " verification is FAILED");
			}
		}
	}

	public void clickBrokerDealerTab() {
		seleniumCore.waitForJStoLoad();		
		seleniumCore.isElementVisible(brokerDealerLink, 30, 1);
		try {
		seleniumCore.click(brokerDealerLink);
		}catch(Exception e) {
			seleniumCore.jsClick(seleniumCore.findElement(brokerDealerLink), "", "");
		}
		this.seleniumCore.getLogger().info("navigate to broker dealer tab");
	}
	
	public void clickTrackingCenterTab() {
		seleniumCore.waitForElementToBeClickable(searchBox,40,1);
		seleniumCore.isElementVisible(trackingCenterLink, 40, 1);
		seleniumCore.waitForJStoLoad();		
		seleniumCore.waitForUILoading(5000);
		try {
		seleniumCore.click(trackingCenterLink);
		}catch(Exception e) {
			seleniumCore.jsClick(seleniumCore.findElement(trackingCenterLink), "", "");
		}
		this.seleniumCore.getLogger().info("navigate to tracking center tab");
		customLogger("navigate to tracking center tab","");
	}
	
	public Object searchForItemNumber(String returnObject, String lastName) {	
		this.seleniumCore.getLogger().info("search for item with last name " +":"+ lastName);
		try {
		seleniumCore.waitForJStoLoad();		
		waitForLoadingData();
		seleniumCore.waitForElementToBeFound(searchBox,20,1);
		seleniumCore.findElement(searchBox).sendKeys(lastName);		
		}catch(Exception e) {
			seleniumCore.sendKeys(searchBox, lastName);			
		}		
		this.seleniumCore.click(searchbutton);
		
		Actions action = new Actions(this.seleniumCore.getDriver());
		By gridList = By.xpath("//td[contains(text(),'"+lastName+"')]");
		seleniumCore.waitForUILoading(2000);
		this.seleniumCore.waitForElementToBeVisible(gridList,20,1);
		WebElement we = this.seleniumCore.getDriver().findElement(gridList);
		try {		
		action.moveToElement(we).click().build().perform();			
		}catch(Exception e) {
			seleniumCore.jsClick(we, "click on last name : ", lastName);			
		}
		customLogger("search for item with last name ",lastName);
		if(returnObject.equals("YES")) {
			return new ItemDetailsPage(seleniumCore);
		}
		return null;
	}
	
	public ItemDetailsPage searchForItemNumber(String bNumber) {				
		this.seleniumCore.getLogger().info("search for item with last name " +":"+ bNumber);	
		seleniumCore.waitForJStoLoad();		
		waitForLoadingData();		
		seleniumCore.waitForElementToBeFound(searchBox,20,1);
		seleniumCore.findElement(searchBox).sendKeys(bNumber);			
		this.seleniumCore.click(searchbutton);

		Actions action = new Actions(this.seleniumCore.getDriver());
		By gridList = By.xpath("//td[contains(text(),'"+bNumber+"')]");
		seleniumCore.waitForUILoading(2000);
		this.seleniumCore.waitForElementToBeVisible(gridList,20,1);
		WebElement we = this.seleniumCore.getDriver().findElement(gridList);
		try {		
		action.moveToElement(we).click().build().perform();			
		}catch(Exception e) {
			seleniumCore.jsClick(we, "click on last name : ", bNumber);			
		}		
		customLogger("search for item with b number and navigate to item details page ", bNumber);
			return new ItemDetailsPage(seleniumCore);		
	}
	
	public void clickRecallButton() {
		seleniumCore.waitForJStoLoad();
		waitForLoadingData();
		seleniumCore.isElementVisible(recallButton, 20, 1);
		seleniumCore.click(recallButton);		
		seleniumCore.isElementVisible(recallOkButton, 10, 1);
		seleniumCore.getDriver().switchTo().activeElement();		
		seleniumCore.click(recallOkButton);		
		waitForLoadingData();
		this.seleniumCore.getLogger().info("click on recall button");
		customLogger("click on recall button", "");
	}
	
	public String validateRecallText() {
		seleniumCore.waitForElementToBeClickable(searchBox,20,1);
		seleniumCore.isElementVisible(recallConfirmationMessage, 10, 1);
		return seleniumCore.getText(recallConfirmationMessage);
	}

	public void hoverOnFilterType() {
		WebElement Filter = seleniumCore.findElement(filterType);
		new Actions(seleniumCore.getDriver()).moveToElement(Filter).build().perform();		
		this.seleniumCore.getLogger().info("Hover on 'Type'"+":"+  "Expand filter list");
	}

	public void hoverOnFilterStatus() {
		WebElement Filter = seleniumCore.findElement(filterStatus);
		new Actions(seleniumCore.getDriver()).moveToElement(Filter).build().perform();		
		this.seleniumCore.getLogger().info("Hover on 'Status'"+":"+  "Expand filter list");
	}

	public TrackingCenterPage clickRestoreDefaultsForTypeFilter() {
		hoverOnFilterType();
		seleniumCore.click(filterTypeRestoreDefaults, "Click 'Restore Default' for Type filter", "Clicked");		
		
		return new TrackingCenterPage(seleniumCore);
	}

	public TrackingCenterPage selectItemTypeFilter(String typeName) {
		selectAllItemTypeFilter();
		hoverOnFilterType();
		selectFilterCheckbox = By.xpath("//label[text()='" + typeName + "']//parent::div/a");
		seleniumCore.click(selectFilterCheckbox, "Select Type filter", "Clicked " + typeName);
		this.seleniumCore.waitForElementToBeClickable(filterTypeApplyBtn);
		this.seleniumCore.click(filterTypeApplyBtn);
		return new TrackingCenterPage(seleniumCore);
	}

	public List<String> getDataFromTable(String columnName) {
		List<WebElement> clientData = seleniumCore
				.findElements(By.xpath("//td[@role='gridcell' and contains(@class,'" + columnName + "')]"));
		return parser.convertListWebElementToString(clientData);
	}

	public TrackingCenterPage selectAllItemStatusFilter() {
		hoverOnFilterStatus();
		seleniumCore.click(filterStatusAllCheckbox);
		seleniumCore.click(filterStatusApplyBtn);		
		return new TrackingCenterPage(seleniumCore);
	}

	public TrackingCenterPage selectAllItemTypeFilter() {
		hoverOnFilterType();
		seleniumCore.click(filterTypeAllCheckbox);
		seleniumCore.click(filterTypeApplyBtn);		
		return new TrackingCenterPage(seleniumCore);
	}

	public TrackingCenterPage selectItemStatusFilter(String statusFilter) {
		hoverOnFilterStatus();
		seleniumCore.click(filterStatusAllCheckbox);
		clientStatus = By.xpath("//input[@id='checkbox-clientStatus-" + statusFilter + "']//following-sibling::a");
		seleniumCore.click(clientStatus);
		seleniumCore.click(filterStatusApplyBtn);
		return new TrackingCenterPage(seleniumCore);
	}

	public ItemDetailsPage clickOnFirstItemInTable() {
		this.seleniumCore.waitForElementToBeVisible(firstItemInTable);
		this.seleniumCore.click(firstItemInTable);
		return new ItemDetailsPage(seleniumCore);
	}

	public TrackingCenterPage sortByAdvisorAction() {
		seleniumCore.click(advisorActionHeader);		
		return new TrackingCenterPage(seleniumCore);
	}

	public boolean isBundleIconDisplayed() {
		return seleniumCore.isElementVisible(bundleIcon);
	}

	public ItemDetailsPage clickOnBTrackingId(String dTrackingId) {
		String value = seleniumCore.getDriver().findElement(By.xpath("//div[@id='jqgh_TrackingCenterGrid_CreatedDT']/span/span[@sort='asc']")).getAttribute("class");
		if (!value.contains("ui-state-disabled")) {
			seleniumCore.getDriver().findElement(By.cssSelector("#jqgh_TrackingCenterGrid_CreatedDT")).click();
		}
	//	By element = By.xpath("//table//td[contains(@class, 'ExternalId') and text()='" + dTrackingId + "']");
		for (int MaxTime = 0; MaxTime < 60; MaxTime++) {
			this.seleniumCore.getDriver().navigate().refresh();
			if (this.seleniumCore.getAttribute(firstItemInTable, "id").startsWith("B"))
				break;
			seleniumCore.waitForUILoading(5000);
		}
		if (!value.contains("ui-state-disabled")) {
			seleniumCore.getDriver().findElement(By.cssSelector("#jqgh_TrackingCenterGrid_CreatedDT")).click();
		}
		this.seleniumCore.click(firstItemInTable, PAGE_NAME, "Clicking on first item from the table");
		customLogger("Clicked on B track id ", "");
		return new ItemDetailsPage(seleniumCore);
	}
}
