package com.amk.cucumber.utility;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.google.common.base.Function;

public class BasePage {
	
	public static String SEPARATOR = ":";

    protected SeleniumCore seleniumCore;
    protected Logger logger;
    protected String currentURL;
    protected static ConfigReader configReader = new ConfigReader();
    protected  Actions action;
    protected  JavascriptExecutor javaScriptExecutor;
    protected DateUtil dateUtil;

    private static final int DELAY = 500;

    public BasePage(SeleniumCore seleniumCore) {
        this.seleniumCore = seleniumCore;
        this.logger = seleniumCore.getLogger();
        action=  new Actions(seleniumCore.getDriver());
        javaScriptExecutor = (JavascriptExecutor) seleniumCore.getDriver();
        dateUtil= new DateUtil();
    }
    

    public void waitForSpinnerToBeDisappear() {
        By loadingSpiner = By.id("theLoadingImage");
        try {
            this.seleniumCore.findElement(loadingSpiner);
            this.seleniumCore.waitForElementToBeInVisible(loadingSpiner);
        } catch (NoSuchElementException ex) {
            logger.info("Spinner"+SEPARATOR+ "Not found");
        }
    }

    /**
     * Wait for loading of all spinners on the page
     */
    public void waitForAllSpinnersToBeDisappear() {
        By xpath = By.xpath("//div[contains(@class,'loading-indicator-component__spinner')]");
        List<WebElement> spinners = this.seleniumCore.getDriver().findElements(xpath);
        spinners.forEach(spinner -> {
            this.seleniumCore.waitForElementToBeInVisible(spinner);
        });

        // Wait loading data on PE-2 on Create/Update Portfolio/Scenario pages
        xpath = By.xpath("//*[contains(@class, 'loading-indication-component') and contains(@class, 'isVisible')]");
        List<WebElement> loadingIndicationComponents = this.seleniumCore.getDriver().findElements(xpath);
        loadingIndicationComponents.forEach(indicator -> {
            this.seleniumCore.waitForElementToBeInVisible(indicator);
        });

    }

    public void waitForAllLoadingImagesToBeDisappear() {
        By xpath = By.xpath("//*[@id='loadingImageModal']");
        List<WebElement> images = this.seleniumCore.getDriver().findElements(xpath);
        images.forEach(img -> {
            this.seleniumCore.waitForElementToBeInVisible(img);
        });
        this.seleniumCore.waitForElementToBeInVisible(xpath);

        By loadingIcon = By.xpath("//*[@id='loading_icon']");
        List<WebElement> icons = this.seleniumCore.getDriver().findElements(loadingIcon);
        icons.forEach(img -> {
            this.seleniumCore.waitForElementToBeInVisible(img);
        });
        this.seleniumCore.waitForElementToBeInVisible(xpath);
    }
    
    public static void customLogger(String log, String value)
	{
		if(value.isEmpty())
		ExtentCucumberAdapter.addTestStepLog(" . . . . "+log);
		
		else
			ExtentCucumberAdapter.addTestStepLog(" . . . . "+log +" : "+value);
	}
	
	public static void emptyLogger(String log)
	{
		ExtentCucumberAdapter.addTestStepLog(" ~ "+log);
		
	}

    public void waitForLoadingPhraseToBeDisappear() {
        By loadingPhrase = By.xpath("//div[contains(@class, 'insp-logo-frame') and contains(text(),'....Loading')]");
        this.seleniumCore.waitForElementToBeInVisible(loadingPhrase);
    }

    public void waitForIPSpinnerToBeDisappear() {
        By loadingSpiner = By.xpath("//div[@class='lds-spinner mx-auto mb-1']");
        this.seleniumCore.waitForElementToBeInVisible(loadingSpiner);
    }

    public void waitForWealthBuilderSpinnerToDisappear() {
        By loadingSpinner = By.xpath("//*[@class='nprogress-busy']");
        this.seleniumCore.waitForElementToBeInVisible(loadingSpinner);
    }

    /**
     * Switch to the last open tab
     */
	public void switchToTheLastOpenBrowserTab() {
		System.out.println(this.seleniumCore.getDriver().getTitle());
		List<String> tabs = new ArrayList<>(seleniumCore.getDriver().getWindowHandles());
		WebDriver window = seleniumCore.getDriver().switchTo().window(tabs.get(tabs.size() - 1));
		seleniumCore.waitForUILoading(5000);
		System.out.println(this.seleniumCore.getDriver().getTitle());
		logger.info("Switching" + SEPARATOR + "Switch to " + window.getTitle());

	}

    public String switchTab(int tabNumber) {    	
    	String parentWindow= seleniumCore.getDriver().getWindowHandle();
    	 this.seleniumCore.numberOfWindows(tabNumber);
			ArrayList<String> tabs = new ArrayList<>(seleniumCore.getDriver().getWindowHandles());	
			waitForPageLoad();
			seleniumCore.getDriver().switchTo().window(tabs.get(tabNumber - 1));			
			logger.info("Switch to tab: " + ":" + tabNumber);
			seleniumCore.waitForJStoLoad();
			if(seleniumCore.isUrlContains("Documents/View/Download", 20, 1)) {					
			logger.info("curent url is :-"+this.seleniumCore.getDriver().getCurrentUrl());
			currentURL= this.seleniumCore.getDriver().getCurrentUrl();	
			}
			this.seleniumCore.getDriver().close();
			seleniumCore.getDriver().switchTo().window(parentWindow);
			
		return currentURL;
	}

    public void waitForPageLoad() {

        Wait<WebDriver> wait = new WebDriverWait(seleniumCore.getDriver(), Duration.ofSeconds(30));
        wait.until(new Function<WebDriver, Boolean>() {
            public Boolean apply(WebDriver driver) {
               logger.info("Current Window State       : "
                    + String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState")));
                return String
                    .valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
                    .equals("complete");
            }
        });
    }
    protected void takeAPicOfFailure(String failName, String testName, String browser) {
        this.seleniumCore.takeScreenshot(testName + " " + failName + " FAILED " + browser);
    }

    public boolean isElementHasClass(By elementLink, String className) {
        String val = this.seleniumCore.findElement(elementLink).getAttribute("class");
        return val.contains(className);
    }
    public boolean isTextDisplayed(String requiredText) {
        waitForAllSpinnersToBeDisappear();
        if(this.seleniumCore.isElementVisible(By.xpath("//*[contains(text(),'"+ requiredText +"')]"))) {
            logger.info("Checking for \""+ requiredText +"\" text"+SEPARATOR+ " Text is Visible");
        } else{
            logger.warn("Checking for \""+ requiredText +"\" text"+SEPARATOR+ "Text Not Visible");
            return false;
        }
        return this.seleniumCore.isElementVisible(By.xpath("//*[contains(text(),'"+ requiredText +"')]"));
    }

    public boolean isPartOfTextDisplayedInTable(String requiredText) {
        waitForAllSpinnersToBeDisappear();
        if(this.seleniumCore.isElementVisible(By.xpath("//*/text()[contains(.,'"+ requiredText +"')]/ancestor::tbody"))) {
            logger.info("Checking for \""+ requiredText +"\" text"+SEPARATOR+ " Text is Visible");
        } else{
            logger.warn("Checking for \""+ requiredText +"\" text"+SEPARATOR+ "Text Not Visible");
            return false;
        }
        return this.seleniumCore.isElementVisible(By.xpath("//*/text()[contains(.,'"+ requiredText +"')]/ancestor::tbody"));
    }

    public boolean isPartOfTextDisplayedInDiv(String requiredText) {
        waitForAllSpinnersToBeDisappear();
        if(this.seleniumCore.isElementVisible(By.xpath("//*/text()[contains(.,'"+ requiredText +"')]/ancestor::div"))) {
            logger.info("Checking for '"+ requiredText +"' text"+SEPARATOR+ " Text is Visible");
        } else{
            logger.warn("Checking for '"+ requiredText +"' text"+SEPARATOR+ "Text Not Visible");
            return false;
        }
        return this.seleniumCore.isElementVisible(By.xpath("//*/text()[contains(.,'"+ requiredText +"')]/ancestor::div"));
    }


    public boolean isElementHasClass(WebElement element, String className) {
        String val = element.getAttribute("class");
        return val.contains(className);
    }

    public String getUIAttributeValue(By element, String attribute) {
        this.seleniumCore.waitForElementToBeVisible(element);
        String value = this.seleniumCore.findElement(element).getCssValue(attribute);
        if ("color".equals(attribute)) {
            return Color.fromString(value).asHex();
        } else {
            return value;
        }
    }

    /**
     * This method create new tab, read JSON from API on URL and than close tab
     *
     * @param driver - WebDriver
     * @param url - API's url for reading
     * @return JSON content as String or ""
     */
    public String readJsonFromUrl(WebDriver driver, String url) {
        try {
            openNewEmptyTab(driver);
            switchToTheLastOpenBrowserTab();
            driver.get(url);

            return driver.findElement(By.cssSelector("pre")).getText();
        } catch (NoSuchElementException ex) {
            logger.warn("Error reading JSON from URL " + url+SEPARATOR+ ex.getMessage());
            return "";
        } finally {
            driver.close();
            switchToTheLastOpenBrowserTab();
        }
    }

    protected void openNewEmptyTab(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open('about:blank','_blank');");
    }

    public void waitForUILoading() {
        try {
            Thread.sleep(DELAY);
        } catch (InterruptedException e) {
            logger.info("Fail waiting UI"+SEPARATOR+ e.getMessage());
        }
    }

    public void waitForUILoading(int delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            logger.info("Fail waiting UI"+SEPARATOR+ e.getMessage());
        }
    }    

    public boolean checkIfThereIsAddressMatch(String[] addressItems, List<WebElement> addressLines) {
        int matched = 0;
        addressItems = Arrays.stream(addressItems).filter(Objects::nonNull).toArray(String[]::new);
        int toMatch = addressItems.length;
        for (String originalAddrItem : addressItems) {
            if (!originalAddrItem.equals("")) {
                for (WebElement line : addressLines) {
                    String lineText = line.getText();
                    lineText = lineText.replace("-", " ");
                    originalAddrItem = originalAddrItem.replace("-", " ");
                    if (lineText.toUpperCase().contains(originalAddrItem.toUpperCase())) {
                        matched++;
                        break;
                    }
                }
            } else {
                matched++;
            }
        }
        return matched == toMatch;
    }
    
    public void performSikuliClick(String imageName) {
		Screen screen = new Screen();
		Pattern image = new Pattern(System.getProperty("user.dir") + "\\fileToUpload\\" + imageName + ".PNG");
		Boolean ImageClicked = Boolean.FALSE;
		for (int i = 0; i < 15; i++) {
			try {
				screen.click(image);
				ImageClicked = Boolean.TRUE;
				break;
			} catch (Exception e) {
			}
			waitForUILoading(250);
		}

		if (!ImageClicked) {
			logger.info("Image not clicked by Sikuli even after waiting for 50 seconds");
		}
	}
    
    public void waitForLoadingData() {	
		By element= By.xpath("//iframe[@id='popupFrame']");	
		By loadIcon=By.cssSelector("div#loadingIcon");	
		By progressBar= By.cssSelector("div[class='progress-bar progress-bar-info']");	
		By loadImage= By.cssSelector("div#theLoadingImage> img");	
		if(seleniumCore.isElementVisible(element,1,1)) {	
			seleniumCore.waitForElementToBeInVisible(element, 90, 1);	
		}	
		if(seleniumCore.isElementVisible(loadImage,2,1)) {	
			seleniumCore.waitForElementToBeInVisible(loadImage, 90, 1);	
		}	
		if(seleniumCore.isElementVisible(loadIcon,2,1)) {	
			seleniumCore.waitForElementToBeInVisible(loadIcon, 90, 1);	
		}	
		if(seleniumCore.isElementVisible(progressBar,1,1)) {	
			seleniumCore.waitForElementToBeInVisible(progressBar, 90, 1);	
		}	
	}
    
    public void waitForLoadingDataOWB() {	
		By loader= By.xpath("//div[@id='loaderContainer'    and    contains(@style,'display')]");	
		By fader=By.xpath("//div[@class='fadeInContainer'  and   @style]");
		
		if(seleniumCore.isElementVisible(loader,2,1)) {	
			seleniumCore.waitForElementToBeVisible(loader, 90, 1);	
		}	
		if(seleniumCore.isElementVisible(fader,2,1)) {	
			seleniumCore.waitForElementToBeVisible(fader, 90, 1);	
		}			
	}
}
