package com.amk.cucumber.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.amk.cucumber.utility.BasePage;
import com.amk.cucumber.utility.SeleniumCore;

import lombok.Getter;

public class PortfolioDetailsPage extends BasePage {

    // Static Data
    private static final String PAGE_NAME = "PORTFOLIO DETAILS PAGE";

    // Page Locators
    private static final By portfolioDetailsPageLabel = By.xpath("//h1[text()='Portfolio Details']");

    // Navigation Bar
    @Getter
    private final By clientProfileTab = By.linkText("Client Profile");
    @Getter
    private final By constructPortfolioTab = By.linkText("Construct Portfolio");
    @Getter
    private final By feesTab = By.linkText("Fees");
    @Getter
    private final By portfolioDetailsTab = By.linkText("Portfolio Details");
    @Getter
    private final By accountSetupTab = By.linkText("Account Setup");
    @Getter
    private final By createDocumentsTab = By.linkText("Create Documents");
    @Getter
    private final By viewDocumentsTab = By.linkText("View Documents");

    private final By accountSetupButton = By.xpath("/html//button[@id='account-setup-adobe']");  

    @Getter
    private final By configurationIcon = By.xpath("//div[contains(@class,'configurationIcon')]/button");


    /**
     * To construct the Portfolio Details Page
     *
     * @param seleniumCore
     */
    public PortfolioDetailsPage(SeleniumCore seleniumCore) {
        this(seleniumCore, true);
    }

    /**
     * To construct the Portfolio Details Page
     *
     * @param seleniumCore
     * @param pageVerification - Flag to check if the page is loaded or not
     */
    public PortfolioDetailsPage(SeleniumCore seleniumCore, boolean pageVerification) {
        super(seleniumCore);
        if (pageVerification) {
            if (seleniumCore.isElementVisible(portfolioDetailsPageLabel, 20, 1)) {
                logger.info(PAGE_NAME + " verification" +" : "+ PAGE_NAME + " verification is PASSED");               
            } else {
                 logger.warn(PAGE_NAME + " verification" +" : "+ PAGE_NAME + " verification is FAILED");
            }
        }
    }

    public static By getLabel() {
        return portfolioDetailsPageLabel;
    }

    /**
     * Waits for the loading icon/spinner to disappear
     */
    private void waitUntilPageFullyLoads() {
        // SeleniumCore.getMaxWaitTime() is not enough, the page somtimes throws TimeoutException
        // so increase max wait time to 2 minutes
        int maxWaitTime = 120;
        new WebDriverWait(this.seleniumCore.getDriver(), Duration.ofSeconds(maxWaitTime)).withTimeout(Duration.ofSeconds(maxWaitTime))
                .until(driver -> !getActiveBenchmark().contains("Loading"));
    }

    public AccountSetupPage goToAccountSetup(String stepName, String logMessage) {
    	seleniumCore.waitForJStoLoad();
    	waitUntilPageFullyLoads();
    	seleniumCore.waitForElementToBeClickable(accountSetupButton, 30, 1);
    	seleniumCore.waitForElementToBeVisible(accountSetupButton, 30, 1);
        this.seleniumCore.click(accountSetupButton, stepName, logMessage);
        customLogger(logMessage,"");
        return new AccountSetupPage(seleniumCore);
    }

    public String getActiveBenchmark() {
        return this.seleniumCore
                .waitForElementToBeVisible(By.xpath("//div[@class='benchmarkDropdownButton']/button/div/div"))
                .getText();
    }   
}
