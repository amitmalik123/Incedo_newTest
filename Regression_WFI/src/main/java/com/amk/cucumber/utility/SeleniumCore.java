package com.amk.cucumber.utility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.amk.cucumber.exceptions.DefaultException;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import lombok.Getter;
import lombok.Setter;

public class SeleniumCore  {

	WebDriver driver;

	@Getter
	private Logger logger = Logger.getLogger(SeleniumCore.class);

	@Setter
	@Getter
	private static Integer maxWaitTime = 20;

	@Setter
	@Getter
	private static Integer pollTime = 1;

	Actions action;

	public SeleniumCore(WebDriver driver, Logger logger) {		
		setDriver(driver);
		setLogger(logger);
	}

	public synchronized WebDriver getDriver() {
		return driver;
	}

	
	private synchronized void setDriver(WebDriver driver) { 
		  this.driver=driver; 
	}
	 

	private synchronized void setLogger(Logger logger) {
		this.logger = logger;
	}

	/**
	 * To launch the given URL
	 *
	 * @param url
	 * @param stepName
	 * @param logMessage
	 */
	public void get(String url, String stepName, String logMessage) {
		getDriver().get(url);      
		if (this.logger != null) {
			this.logger.info(stepName + ":" + logMessage);
		}
	}
	
	public void getInNewTab(String url, String stepName, String logMessage) {
		driver.switchTo().newWindow(WindowType.TAB);
		getDriver().get(url);
		if (this.logger != null) {
			this.logger.info(stepName + ":" + logMessage);
		}
	}

	/**
	 * To click the locator on the page
	 *
	 * @param locator - The locator By object
	 */
	public void click(By locator) {
		click(locator, null, null, null, null);
	}

	/**
	 * To click the locator on the page
	 *
	 * @param locator
	 * @param stepName
	 * @param logMessage
	 */
	public void click(By locator, String stepName, String logMessage) {
		click(locator, stepName, logMessage, null, null);
	}

	/**
	 * To click the locator on the page
	 *
	 * @param locator
	 * @param stepName
	 * @param logMessage
	 * @param maxWaitTime
	 */
	public void click(By locator, String stepName, String logMessage, Integer maxWaitTime) {
		click(locator, stepName, logMessage, maxWaitTime, null);
	}

	/**
	 * To click the locator on the page
	 *
	 * @param locator
	 * @param stepName
	 * @param logMessage
	 * @param maxWaitTime
	 * @param pollTime
	 */
	public void click(By locator, String stepName, String logMessage, Integer maxWaitTime, Integer pollTime) {
		this.waitUntilElementToBeClickable(locator, maxWaitTime, pollTime).click();
		if (logMessage != null && !logMessage.isEmpty()) {
			if (this.logger != null) {
				this.logger.info(stepName + logMessage);
			}
		}
	}

	/**
	 * To click the locator on the page
	 *
	 * @param locator
	 * @param stepName
	 * @param logMessage
	 */
	public void clickRadioButton(By locator, String stepName, String logMessage) {		
		clickRadioButton(locator, stepName, logMessage, null, null);
	}

	/**
	 * To click a radion button by the locator on the page
	 *
	 * @param locator
	 * @param stepName
	 * @param logMessage
	 * @param maxWaitTime
	 */
	public void clickRadioButton(By locator, String stepName, String logMessage, Integer maxWaitTime) {
		clickRadioButton(locator, stepName, logMessage, maxWaitTime, null);
	}

	/**
	 * To click a radion button by the locator on the page
	 *
	 * @param locator
	 * @param stepName
	 * @param logMessage
	 * @param maxWaitTime
	 * @param pollTime
	 */
	public void clickRadioButton(By locator, String stepName, String logMessage, Integer maxWaitTime,
			Integer pollTime) {
		Actions action = new Actions(getDriver());
		WebElement radioBtn = this.findElement(locator, maxWaitTime, pollTime);
		action.click(radioBtn).build().perform();
		if (logMessage != null && !logMessage.isEmpty()) {
//            if (this.reporter != null) {
//                this.reporter.info(stepName, logMessage);
//            }
			if (this.logger != null) {
				this.logger.info(stepName + logMessage);
			}
		}
	}
	
	public void tabOut() {
		Actions action = new Actions(getDriver());		
		action.sendKeys(Keys.TAB).perform();		
	}
	
	/**
	 * To enter value in the text field
	 *
	 * @param locator
	 * @param valueToEnter
	 * @param clear
	 * @param logStep
	 * @param logMessage
	 */
	public void handleAlert(String button) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		try {
			Alert alert = wait.until(ExpectedConditions.alertIsPresent());
			String message = alert.getText();
			logger.info("Alert text is: " + message);
			customLogger("Alert text is: ", message);

			if (button.equalsIgnoreCase("OK")) {
				alert.accept();
				logger.info("Clicked on alert OK button");
			} else if (button.equalsIgnoreCase("Cancel")) {
				alert.dismiss();
				logger.info("Clicked on alert Cancel button");
			} else {
				logger.info("User needs to handle alert");
				alert.accept();
			}
		} catch (TimeoutException e) {
			logger.info("Alert does not exist");
		} catch (NoAlertPresentException e) {
			logger.info("No alert present");
		}
	}	

	/**
	 * To enter value in the text field
	 *
	 * @param locator
	 * @param valueToEnter
	 * @param clear
	 * @param logStep
	 * @param logMessage
	 */
	
	public void reducesize() {
		try {
			Robot robot = new Robot();
			for (int i = 0; i < 4; i++) {
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_SUBTRACT);
				robot.keyRelease(KeyEvent.VK_SUBTRACT);
				robot.keyRelease(KeyEvent.VK_CONTROL);
				}
		} catch (AWTException e) {		
			e.printStackTrace();
		}
		
	}
	
	public void sendKeys(By locator, String valueToEnter, boolean clear, String logStep, String logMessage) {
		sendKeys(locator, valueToEnter, clear, logStep, logMessage, null, null);
	}

	public String getTagName(By element) {
		String attributeProperty = getDriver().findElement(element).getTagName();
			return attributeProperty;
		}
	
	public void sendKeys(By locator,String path)
	{
		WebElement ele = this.getWait(maxWaitTime, pollTime)
	.until(ExpectedConditions.visibilityOfElementLocated(locator));
	ele.sendKeys(path);
		
	}
	
	/**
	 * Select drop down by visible text
	 *
	 * @param locator
	 * @param visibleText
	 * @param stepName
	 * @param logMessage
	 * @param maxWaitTime
	 * @param pollTime
	 */
	public void selectByVisibleText(By locator,String VisibleText) {
	Select select=new Select(findElement(locator));
	select.selectByVisibleText(VisibleText);
		
		
	}
	/**
	 * To enter value in the text field
	 *
	 * @param locator
	 * @param valueToEnter
	 * @param logStep
	 * @param logMessage
	 */
	public void sendKeys(By locator, String valueToEnter,String logMessage) {
		sendKeys(locator, valueToEnter, true, null, logMessage, null, null);
	}
	
	public void sendKeys(By locator, String valueToEnter, String logStep, String logMessage) {
		sendKeys(locator, valueToEnter, true, logStep, logMessage, null, null);
	}

	public void sendKeys(By locator, String valueToEnter, String logStep, String logMessage, Integer maxWaitTime,
			Integer pollTime) {
		sendKeys(locator, valueToEnter, true, logStep, logMessage, maxWaitTime, pollTime);
	}

	/**
	 * To enter value in the text field
	 *
	 * @param locator
	 * @param valueToEnter
	 * @param clear
	 * @param logStep
	 * @param logMessage
	 * @param maxWaitTime
	 * @param pollTime
	 */
	public void sendKeys(By locator, String valueToEnter, boolean clear, String logStep, String logMessage,
			Integer maxWaitTime, Integer pollTime) {
		WebElement ele = this.getWait(maxWaitTime, pollTime)     
				.until(ExpectedConditions.visibilityOfElementLocated(locator));
		if (clear) {
			ele.click();
			if (System.getProperty("browser") == null || (!System.getProperty("browser").equals("Safari"))) {
				ele.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
				ele.sendKeys(Keys.BACK_SPACE);
			} else {
				ele.clear();
			}
		}
		ele.sendKeys(valueToEnter);
//        if (this.reporter != null) {
//            this.reporter.info(logStep, logMessage);
//        }
		if (this.logger != null) {
			this.logger.info(logStep + logMessage);
		}
	}
	
	
	public void numberOfWindows(int noOfWindows) {
		boolean windows = this.getWait(maxWaitTime, pollTime)
				.until(ExpectedConditions.numberOfWindowsToBe(noOfWindows));
		logger.info("number of opened windows are: " + noOfWindows);
		Assert.assertTrue("number of open windows are not matching expected numbers", windows);		
	}
	
	public boolean numberOfWindows(int noOfWindows, String msg) {
		boolean windows = this.getWait(maxWaitTime, pollTime).until(ExpectedConditions.numberOfWindowsToBe(noOfWindows));
		logger.info(msg + noOfWindows);
		return windows;	
	}

	/**
	 * To check If Element is found on the page or not.
	 *
	 * @param locator     - The locator to search for
	 * @param maxWaitTime - The Max wait time
	 * @param pollTime    - The poll time
	 * @return - true-if element is found else false.
	 */
	public boolean isElementFound(final By locator, Integer maxWaitTime, Integer pollTime) {
		try {
			Wait<WebDriver> wait = getWait(maxWaitTime, pollTime);
			WebElement ele = wait.until((WebDriver driver) -> {
				try {
					return driver.findElement(locator);
				} catch (Exception e) {
					return null;
				}
			});
			return ele != null;

		} catch (Exception e) {
			logger.info(e.getStackTrace()[0].getFileName() + " :: "+ e.getStackTrace()[0].getClassName() + " : "+e.getStackTrace()[0].getMethodName() );
			return false;
		}
	}

	/**
	 * To check if Element is visible or not
	 *
	 * @param locator
	 * @return
	 */
	public boolean isElementVisible(By locator) {
		return isElementVisible(locator, null, null);
	}

	public boolean isElementFound(By locator) {
		return isElementFound(locator, maxWaitTime, pollTime);
	}

	/**
	 * To check if Element is visible or not
	 *
	 * @param locator
	 * @param maxWaitTime
	 * @param pollTime
	 * @return
	 */
	public boolean isElementVisible(By locator, Integer maxWaitTime, Integer pollTime) {
		try {
			this.getWait(maxWaitTime, pollTime).until(ExpectedConditions.visibilityOfElementLocated(locator));
			return true;
		} catch (Exception e) {			
			return false;
		}
	}
	
	/*
	 * An expectation for the URL of the current page to contain specific
	 * text.Parameters:fraction the fraction of the url that the page should be
	 * onReturns:true when the URL contains the text
	 */
	
	public boolean isUrlContains(String url, Integer maxWaitTime, Integer pollTime) {
		try {
			this.getWait(maxWaitTime, pollTime).until(ExpectedConditions.urlContains(url));
			return true;
		} catch (Exception e) {
			logger.info(e.getStackTrace()[0].getFileName() + " :: "+ e.getStackTrace()[0].getClassName() + " : "+e.getStackTrace()[0].getMethodName() );
			return false;
		}
	}

	/**
	 * To check if the Element is clickable or not
	 *
	 * @param locator
	 * @param maxWaitTime
	 * @param pollTime
	 * @return
	 */
	
	public boolean isElementClickable(By locator) {
		return isElementClickable(locator, maxWaitTime, pollTime);
	}
	
	public boolean isElementClickable(By locator, Integer maxWaitTime, Integer pollTime) {
		try {
			this.getWait(maxWaitTime, pollTime).until(ExpectedConditions.elementToBeClickable(locator));
			return true;
		} catch (Exception e) {
			logger.info(e.getStackTrace()[0].getFileName() + " :: "+ e.getStackTrace()[0].getClassName() + " : "+e.getStackTrace()[0].getMethodName() );
			return false;
		}
	}

	/**
	 * To wait until element to be clickable on the page
	 *
	 * @param locator - The Locator
	 * @return - true - if clickable, false - if not clickable
	 */
	public WebElement waitUntilElementToBeClickable(By locator) {
		return waitUntilElementToBeClickable(locator, null, null);
	}

	/**
	 * To wait until element to be clickable on the page
	 *
	 * @param locator
	 * @param maxWaitTime
	 * @param pollTime
	 * @return
	 */
	public WebElement waitUntilElementToBeClickable(By locator, Integer maxWaitTime, Integer pollTime) {
		try {
		this.getWait(maxWaitTime, pollTime).until(ExpectedConditions.elementToBeClickable(locator));
		return this.findElement(locator, maxWaitTime, pollTime);
		}catch(Exception e) {
			logger.info(e.getStackTrace()[0].getFileName() + " :: "+ e.getStackTrace()[0].getClassName() + " : "+e.getStackTrace()[0].getMethodName() );
			return null;
		}
	}

	/**
	 * To find the element on the page
	 *
	 * @param locator
	 * @return
	 */
	public WebElement findElement(By locator) {
		try {
		return getDriver().findElement(locator);
		}catch(Exception e){
			logger.info(e.getStackTrace()[0].getFileName() + " :: "+ e.getStackTrace()[0].getClassName() + " : "+e.getStackTrace()[0].getMethodName() );
			return null;
		}
	}

	/**
	 * To find the elements on the page
	 *
	 * @param locator
	 * @return
	 */
	public List<WebElement> findElements(By locator) {
		return getDriver().findElements(locator);
	}

	/**
	 * To find the element on the page
	 *
	 * @param locator
	 * @param maxWaitTime
	 * @param pollTime
	 * @return
	 */
	public WebElement findElement(By locator, Integer maxWaitTime, Integer pollTime) {
		if (isElementFound(locator, maxWaitTime, pollTime)) {
			return getDriver().findElement(locator);
		} else {
			return null;
		}
	}

	/**
	 * To get the 'Wait' object with the given Maximum Wait Time and Poll Time.
	 *
	 * @param maxWaitTime - The Maximum Wait Time
	 * @param pollTime    - The Poll Time
	 * @return - The Wait object
	 */
	public Wait<WebDriver> getWait(Integer maxWaitTime, Integer pollTime) {
		if (maxWaitTime == null) {
			maxWaitTime = SeleniumCore.maxWaitTime;
		}
		if (pollTime == null) {
			pollTime = SeleniumCore.pollTime;
		}
		return new FluentWait<>(getDriver()).withTimeout(Duration.ofSeconds(maxWaitTime))
				.pollingEvery(Duration.ofSeconds(pollTime)).ignoring(NoSuchElementException.class);
	}

	public void jsClick(WebElement element, String stepName, String logMessage) {
		JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) getDriver();
	//	javaScriptExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
		javaScriptExecutor.executeScript("arguments[0].click();", element);
		if (logMessage != null && !logMessage.isEmpty()) {
			if (this.logger != null) {
				this.logger.info(stepName + logMessage);
			}
		}
	}
	
	public void jsClick(WebElement element,  String logMessage) {
		JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) getDriver();
	//	javaScriptExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
		javaScriptExecutor.executeScript("arguments[0].click();", element);
		if (logMessage != null && !logMessage.isEmpty()) {
			if (this.logger != null) {
				this.logger.info(logMessage);
			}
		}
	}

	public WebElement waitForElementToBeClickable(By locator, Integer maxWaitTime, Integer pollTime) {
		try {
			this.getWait(maxWaitTime, pollTime).until(ExpectedConditions.elementToBeClickable(locator));
			return this.findElement(locator);
		} catch (Exception e) {
			logger.info(e.getStackTrace()[0].getFileName() + " :: "+ e.getStackTrace()[0].getClassName() + " : "+e.getStackTrace()[0].getMethodName() );
			if (this.logger != null) {
				this.logger.info("Exception" + "Element is not clickable. Locator = " + locator.toString()
						+ ", Exception is:" + e.getMessage());
			}
			return null;
		}
	}

	/**
	 * Wait for element to be found on the page
	 *
	 * @param locator
	 * @param maxWaitTime
	 * @param pollTime
	 * @return
	 */
	public WebElement waitForElementToBeFound(By locator, Integer maxWaitTime, Integer pollTime) {
		try {
			this.getWait(maxWaitTime, pollTime).until((WebDriver t) -> getDriver().findElement(locator));
			return this.findElement(locator);
		} catch (Exception e) {
//            if (this.reporter != null) {
//                this.reporter.info("Exception", "Element is not visible. Locator = " + locator.toString() + ", Exception is:" + e.getMessage());
//            }
			logger.info(e.getStackTrace()[0].getFileName() + " :: "+ e.getStackTrace()[0].getClassName() + " : "+e.getStackTrace()[0].getMethodName() );
			if (this.logger != null) {
				this.logger.info("Exception" + " Element is not visible. Locator = " + locator.toString()
						+ ", Exception is:" + e.getMessage());
			}
			return null;
		}
	}

	/**
	 * Wait for element to be found on the page
	 *
	 * @param locator
	 * @return
	 */
	public WebElement waitForElementToBeFound(By locator) {
		return waitForElementToBeFound(locator, null, null);
	}
	
	public void waitForUILoading(int delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            logger.info("Fail waiting UI" + e.getMessage());
        }
    }

	/**
	 * Wait for element to be visible on the page
	 *
	 * @param locator
	 * @param maxWaitTime
	 * @param pollTime
	 * @return
	 */
	public WebElement waitForElementToBeVisible(By locator, Integer maxWaitTime, Integer pollTime) {
		try {
			this.getWait(maxWaitTime, pollTime).until(ExpectedConditions.visibilityOfElementLocated(locator));
			return this.findElement(locator);
		} catch (Exception e) {
			logger.info(e.getStackTrace()[0].getFileName() + " :: "+ e.getStackTrace()[0].getClassName() + " : "+e.getStackTrace()[0].getMethodName() );
			if (this.logger != null) {
				this.logger.info("Exception " + "Element is not visible. Locator = " + locator.toString()
						+ ", Exception is:" + e.getMessage());
			}
			return null;
		}
	}
	/**
	 * Wait for element to be clickable on the page
	 *
	 * @param element
	 * @param maxWaitTime
	 * @param pollTime
	 * @return
	 */
	public WebElement waitForElementToBeClickable(WebElement element, Integer maxWaitTime, Integer pollTime) {
		try {
			this.getWait(maxWaitTime, pollTime).until(ExpectedConditions.elementToBeClickable(element));
			return element;
		} catch (Exception e) {
//            if (this.reporter != null) {
//                this.reporter.info("Exception", "Element is not visible. Locator = " + element.toString() + ", Exception is:" + e.getMessage());
//            }
			logger.info(e.getStackTrace()[0].getFileName() + " :: "+ e.getStackTrace()[0].getClassName() + " : "+e.getStackTrace()[0].getMethodName() );
			if (this.logger != null) {
				this.logger.info("Exception" + "Element is not visible. Locator = " + element.toString()
						+ ", Exception is:" + e.getMessage());
			}
			return null;
		}
	}

	/**
	 * Wait for element to be inVisible on the page
	 *
	 * @param locator
	 * @param maxWaitTime
	 * @param pollTime
	 * @return
	 */
	public boolean waitForElementToBeInVisible(By locator, Integer maxWaitTime, Integer pollTime) {
		boolean value=false;
		try { 
			value=  this.getWait(maxWaitTime, pollTime).until(ExpectedConditions.invisibilityOfElementLocated(locator));
			return value;
		} catch (Exception e) {
//            if (this.reporter != null) {
//                this.reporter.info("Exception", "Element is visible. Locator = " + locator.toString() + ", Exception is:" + e.getMessage());
//            }
			logger.info(e.getStackTrace()[0].getFileName() + " :: "+ e.getStackTrace()[0].getClassName() + " : "+e.getStackTrace()[0].getMethodName() );
			if (this.logger != null) {
				this.logger.info("Exception " + "Element is visible. Locator = " + locator.toString() + ", Exception is:"
						+ e.getMessage());
			}
			return value;
		}
	}

	/**
	 * Wait for element to be inVisible on the page
	 *
	 * @param element
	 * @param maxWaitTime
	 * @param pollTime
	 * @return
	 */
	public WebElement waitForElementToBeInVisible(WebElement element, Integer maxWaitTime, Integer pollTime) {
		try {
			this.getWait(maxWaitTime, pollTime).until(ExpectedConditions.invisibilityOf(element));
			return element;
		} catch (Exception e) {
//            if (this.reporter != null) {
//                this.reporter.info("Exception", "Element is visible. Element = " + element.toString() + ", Exception is:" + e.getMessage());
//            }
			logger.info(e.getStackTrace()[0].getFileName() + " :: "+ e.getStackTrace()[0].getClassName() + " : "+e.getStackTrace()[0].getMethodName() );
			if (this.logger != null) {
				this.logger.info("Exception" + "Element is visible. Element = " + element.toString() + ", Exception is:"
						+ e.getMessage());
			}
			return null;
		}
	}

	public boolean waitForElementToBeInVisible(By locator) {
		return waitForElementToBeInVisible(locator, null, null);
	}

	public WebElement waitForElementToBeInVisible(WebElement element) {
		return waitForElementToBeInVisible(element, null, null);
	}

	/*
	 * Wait for element to be clickable
	 */
	public WebElement waitForElementToBeClickable(By locator) {
		return waitForElementToBeClickable(locator, null, null);
	}

	/**
	 * Wait for element to be visible on the page
	 *
	 * @param locator
	 * @return
	 */
	public WebElement waitForElementToBeVisible(By locator) {
		return waitForElementToBeVisible(locator, null, null);
	}

	public void frameAvailableAndSwitchToIt(By locator,Integer maxWaitTime, Integer pollTime) {				
		try {
			this.getWait(maxWaitTime, pollTime).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));		
		} catch (Exception e) {   
			logger.info(e.getStackTrace()[0].getFileName() + " :: "+ e.getStackTrace()[0].getClassName() + " : "+e.getStackTrace()[0].getMethodName() );
			if (this.logger != null) {
				this.logger.info("Exception" + "Element is not visible. Locator = " + locator.toString()
						+ ", Exception is:" + e.getMessage());
			}			
		}	
}
	
	public boolean validateTextValue(By locator, Integer maxWaitTime, Integer pollTime, String value) {			
		try {  
			this.getWait(maxWaitTime, pollTime).until(ExpectedConditions.textToBePresentInElementLocated(locator, value));
			return true;
		} catch (Exception e) { 
			logger.info(e.getStackTrace()[0].getFileName() + " :: "+ e.getStackTrace()[0].getClassName() + " : "+e.getStackTrace()[0].getMethodName() );
			if (this.logger != null) {
				this.logger.info("Exception" + "Element is not visible. Locator = " + locator.toString()
						+ ", Exception is:" + e.getMessage());
			}			
		}
		return false;
	}
	
	public void waitForElementToBePresent(By locator, Integer maxWaitTime, Integer pollTime) {			
		try {  
			this.getWait(maxWaitTime, pollTime).until(ExpectedConditions.presenceOfElementLocated(locator));
			
		} catch (Exception e) {   
			logger.info(e.getStackTrace()[0].getFileName() + " :: "+ e.getStackTrace()[0].getClassName() + " : "+e.getStackTrace()[0].getMethodName() );
			if (this.logger != null) {
				this.logger.info("Exception" + "Element is not present. Locator = " + locator.toString()
						+ ", Exception is:" + e.getMessage());
			}			
		}		
	}
	
	/**
	 * Wait for element to be visible on the page
	 *
	 * @param element
	 * @return
	 */
	public WebElement waitForElementToBeClickable(WebElement element) {
		return waitForElementToBeClickable(element, null, null);
	}
	
	public void selectByValue(By element, String value) {
        logger.info("Select value from dropdown "+ value);       
        this.waitForElementToBeClickable(element,20,1).click();
        Select select = new Select(this.findElement(element));
		List<WebElement> lst = select.getOptions();		
		for (WebElement options : lst)
			if (options.getText().equals(value)) {						
				options.click();
				waitForUILoading(500);
				click(element);				
				break;
			}   
		if(validateTextValue(element, 5, 1, value)) {
			logger.info(value + " has been selected");
		customLogger(value, " has been selected");
		}
		else
			select.selectByVisibleText(value);
	}
	
	public void selectByValue(WebElement element, String value) {
        logger.info("Select value from dropdown "+ value);       
        this.waitForElementToBeClickable(element,20,1).click();
        Select select = new Select(element);
        List<WebElement> lst = select.getOptions();
        for(WebElement options: lst)       
            if (options.getText().equals(value)) {
            	options.click();   
            	element.click();
                break;
            }   
        
    }

	/**
	 * To select the drop down
	 *
	 * @param locator
	 * @param maxWaitTime
	 * @param pollTime
	 * @return
	 */
	private Select select(By locator, Integer maxWaitTime, Integer pollTime) {
		return new Select(this.waitForElementToBeVisible(locator, maxWaitTime, pollTime));
	}

	/**
	 * Select drop down by value
	 *
	 * @param locator
	 * @param value
	 * @param stepName
	 * @param logMessage
	 * @param maxWaitTime
	 * @param pollTime
	 */
	public void selectByValue(By locator, String value, String stepName, String logMessage, Integer maxWaitTime,
			Integer pollTime) {
		this.select(locator, maxWaitTime, pollTime).selectByValue(value);
		if (this.logger != null) {
			this.logger.info(stepName + logMessage);
		}
	}
	
	public void selectByValue(WebElement locator, String value, String stepName, String logMessage) {
		new Select(locator).selectByValue(value);
		if (this.logger != null) {
			this.logger.info(stepName + logMessage);
		}
	}

	/**
	 * Select drop down by visible text
	 *
	 * @param locator
	 * @param visibleText
	 * @param stepName
	 * @param logMessage
	 * @param maxWaitTime
	 * @param pollTime
	 */
	public void selectByVisibleText(By locator, String visibleText, String stepName, String logMessage,
			Integer maxWaitTime, Integer pollTime) {
		this.select(locator, maxWaitTime, pollTime).selectByVisibleText(visibleText);
//        if (this.reporter != null) {
//            this.reporter.info(stepName, logMessage);
//        }
		if (this.logger != null) {
			this.logger.info(stepName + logMessage);
		}
	}

	/**
	 * Select drop down by given index
	 *
	 * @param locator
	 * @param index
	 * @param stepName
	 * @param logMessage
	 * @param maxWaitTime
	 * @param pollTime
	 */
	public void selectByIndex(By locator, Integer index, String stepName, String logMessage, Integer maxWaitTime,
			Integer pollTime) {
//		click(locator);
	//	jsClick(findElement(locator), stepName, logMessage);
		this.select(locator, maxWaitTime, pollTime).selectByIndex(index);
		waitForUILoading(500);
//		click(locator);
//        if (this.reporter != null) {
//            this.reporter.info(stepName, logMessage);
//        }
		if (this.logger != null) {
			this.logger.info(stepName + logMessage);
		}
	}

	public String getText(By locator, Integer maxWaitTime, Integer pollTime) {
		return this.getWait(maxWaitTime, pollTime).until(ExpectedConditions.presenceOfElementLocated(locator))
				.getText();
	}

	public String getText(By locator) {
		return getText(locator, null, null);
	}

	public String getAttribute(By locator, String attributeName) {
		return getAttribute(locator, attributeName, null, null);
	}

	public String getAttribute(By locator, String attributeName, Integer maxWaitTime, Integer pollTime) {
		return this.getWait(maxWaitTime, pollTime).until(ExpectedConditions.presenceOfElementLocated(locator))
				.getAttribute(attributeName);
	}

	public WebDriver switchToFrame(By locator, Integer maxWaitTime, Integer pollTime) {
		return getDriver().switchTo().frame(this.waitForElementToBeFound(locator, maxWaitTime, pollTime));
	}

	public WebDriver switchToFrame(By locator) {
		return switchToFrame(locator, null, null);
	}

	public WebDriver switchToFrame(String name) {
		return getDriver().switchTo().frame(name);
	}

	public WebDriver switchToParentFrame() {
		return getDriver().switchTo().parentFrame();
	}

	public WebDriver switchToDefaultContent() {
		return getDriver().switchTo().defaultContent();
	}

	public synchronized void closeDriver() {
		getDriver().close();
	}

	public synchronized void quitDriver() {
		getDriver().quit();
	}

	public void scrollTop() {
		JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) getDriver();
		javaScriptExecutor.executeScript("window.scrollTo(0,0)");
	}

	public void scrollDown() {
		JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) getDriver();
		javaScriptExecutor.executeScript("window.scrollTo(0,250)");
	}
	
	public void scrollPageWidth() {
		JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) getDriver();
		javaScriptExecutor.executeScript("window.scrollTo(document.body.scrollWidth, 0)");
	}
	
	public void scrollPageHeight() {
		JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) getDriver();
		javaScriptExecutor.executeScript("window.scrollTo(0, document.body.scrollWidth)");
	}

	public void zoomOut() {
		JavascriptExecutor executor = (JavascriptExecutor) getDriver();
		executor.executeScript("document.body.style.zoom = '67%'");
	}

	/**
	 * To set specific test data that can be accessed
	 *
	 * @param context
	 */
//    public void setContext(ITestContext context) {
//        context.setAttribute("WebDriver", this.getDriver());
//        context.setAttribute("TestName", "");
//        context.setAttribute("JsonTestName", "");
//        context.setAttribute("Comment", "");
//        context.setAttribute("Browser", "");
//    }

	/**
	 * To set specific test data that can be accessed
	 *
	 * @param context
	 * @param jsonTestName
	 * @param comment
	 * @param browser
	 */
//    public void setContext(ITestContext context, String jsonTestName, String comment, String browser) {
//        context.setAttribute("WebDriver", this.getDriver());
//        context.setAttribute("JsonTestName", jsonTestName);
//        context.setAttribute("Comment", comment);
//        context.setAttribute("Browser", browser);
//    }

	public void waitDownloading(String downloadDir, String fileName) {
		Path dowloadFilePath = Paths.get(downloadDir, fileName);
		new WebDriverWait(getDriver(), Duration.ofSeconds(1000)).until(d -> dowloadFilePath.toFile().exists());
	}

	public void takeScreenshot(String name) {
		File scrFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String timeStamp = new SimpleDateFormat("HH.mm.ss").format(new Date());
		try {
			FileUtils.copyFile(scrFile, new File("./Screenshots/" + timeStamp + "_" + name + ".jpg"));
		} catch (IOException e) {
			logger.info("IO Exception occured" + e.getMessage());
		}
	}

	public void scrollToBottom() {
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	/**
	 * To return the UI attribute on an element on UI
	 *
	 * @param element
	 * @param attributeName
	 * @param stepName
	 * @param logMessage
	 * @return UI attribute
	 */
	public String getUiAttribute(By element, String attributeName, String stepName, String logMessage) {
		waitForElementToBeFound(element);
		return getUiAttribute(element, attributeName, stepName, logMessage, null);
	}

	/**
	 * To return the UI attribute on an element on UI
	 *
	 * @param element
	 * @param attributeName
	 * @param stepName
	 * @param logMessage
	 * @param pollTime
	 * @return
	 */
	public String getUiAttribute(By element, String attributeName, String stepName, String logMessage,
			Integer pollTime) {
		String attributeProperty = getDriver().findElement(element).getCssValue(attributeName);
		logger.info("Step Name: " + stepName + ":" + "Log Message: " + logMessage);
		if (attributeName.contains("color")) {
			return Color.fromString(attributeProperty).asHex();
		} else {
			return attributeProperty;
		}
	}

	public void switchFrameById(String id) {
		getDriver().switchTo().frame(id);
	}

	public void switchFrameByIndex(int index) {
		getDriver().switchTo().frame(index);
	}

	/**
	 * To check if element has some text
	 *
	 * @param locator
	 * @param text
	 * @param maxWaitTime
	 * @param pollTime
	 */
	public boolean doesElementContainText(By locator, String text, Integer maxWaitTime, Integer pollTime) {
		try {
			if (isElementFound(locator, maxWaitTime, pollTime)) {
				this.getWait(maxWaitTime, pollTime)
						.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
				return true;
			} else {
				this.logger.warn("Warning" + "Element not found." + " Element locator = " + locator.toString());
				return false;
			}
		} catch (Exception e) {
			logger.info(e.getStackTrace()[0].getFileName() + " :: "+ e.getStackTrace()[0].getClassName() + " : "+e.getStackTrace()[0].getMethodName() );
			if (this.logger != null) {
				this.logger.info("Exception" + ":" + "Element contains text. Text = " + text + " Element locator = "
						+ locator.toString() + ", Exception is:" + e.getMessage());
			}
			return false;
		}
	}

	public boolean doesElementContainTextHTML(By locator, String text, Integer maxWaitTime, Integer pollTime) {
		try {
			if (isElementFound(locator, maxWaitTime, pollTime)) {
				this.getWait(maxWaitTime, pollTime).until(new elementContainsText(text, findElement(locator)));
				return true;
			} else {
				this.logger.warn("Warning" + ":" + "Element not found." + " Element locator = " + locator.toString());
				return false;
			}
		} catch (Exception e) {
			logger.info(e.getStackTrace()[0].getFileName() + " :: "+ e.getStackTrace()[0].getClassName() + " : "+e.getStackTrace()[0].getMethodName() );
			if (this.logger != null) {
				this.logger.info("Exception" + ":" + "Element contains text. Text = " + text + " Element locator = "
						+ locator.toString() + ", Exception is:" + e.getMessage());
			}
			return false;
		}
	}

	/**
	 * To check if URL has some text
	 *
	 * @param text
	 * @param maxWaitTime
	 * @param pollTime
	 */
	public boolean doesUrlContainText(String text, Integer maxWaitTime, Integer pollTime) {
		try {
			return this.getWait(maxWaitTime, pollTime).until((WebDriver t) -> {
				try {
					String ulr = getDriver().getCurrentUrl().toLowerCase().replace("-", " ");
					return ulr != null && ulr.contains(text.toLowerCase());
				} catch (Exception e) {
					logger.info(e.getStackTrace()[0].getFileName() + " :: "+ e.getStackTrace()[0].getClassName() + " : "+e.getStackTrace()[0].getMethodName() );
					return false;
				}
			});

		} catch (Exception e) {
			if (this.logger != null) {
				this.logger.info(
						"Exception" + ":" + "URL contains text. Text = " + text + ", Exception is:" + e.getMessage());
			}
			return false;
		}
	}
	
	/**
	 * To check if Title has some text
	 *
	 * @param text
	 * @param maxWaitTime
	 * @param pollTime
	 */
	public boolean doesTitleContainText(String value, Integer maxWaitTime, Integer pollTime) {		
		try {
			return this.getWait(maxWaitTime, pollTime).until((WebDriver t) -> {
				try {
				   String title = getDriver().getTitle().toLowerCase();
					return title != null && title.contains(value.toLowerCase());
				} catch (Exception e) {
					return false;
				}
			});

		} catch (Exception e) {
			logger.info(e.getStackTrace()[0].getFileName() + " :: "+ e.getStackTrace()[0].getClassName() + " : "+e.getStackTrace()[0].getMethodName() );
			if (this.logger != null) {
				this.logger.info(
						"Exception" + ":" + "Title does not contains text. Text = " + value + ", Exception is:" + e.getMessage());
			}
			return false;
		}
	}

	/**
	 * To check if whole page has some text
	 *
	 * @param text
	 * @param maxWaitTime
	 * @param pollTime
	 */
	public boolean doesPageContainText(String text, Integer maxWaitTime, Integer pollTime) {
		try {
			this.getWait(maxWaitTime, pollTime).until(new sourceContainsText(text));
			return true;
		} catch (Exception e) {
			logger.info(e.getStackTrace()[0].getFileName() + " :: "+ e.getStackTrace()[0].getClassName() + " : "+e.getStackTrace()[0].getMethodName() );
			if (this.logger != null) {
				this.logger.info(
						"Exception" + ":" + "Page contains text. Text = " + text + ", Exception is:" + e.getMessage());
			}
			return false;
		}
	}

	/**
	 * Get open browser tabs
	 */
	public ArrayList<String> getTabs() {
		return new ArrayList<java.lang.String>(getDriver().getWindowHandles());
	}

	/**
	 * Get JavascriptExecutor object
	 */
	public JavascriptExecutor getJavascriptExecutor() {
		return (JavascriptExecutor) getDriver();
	}

	private class sourceContainsText implements ExpectedCondition<Boolean> {
		private final String text;

		public sourceContainsText(String text) {
			this.text = text.toLowerCase();
		}

		@Override
		public Boolean apply(WebDriver driver) {
			try {
				return driver.findElement(By.xpath("//html")).getAttribute("outerHTML").toLowerCase().contains(text);
			} catch (Exception e) {
				return false;
			}

		}
	}

	private class elementContainsText implements ExpectedCondition<Boolean> {
		private final String text;
		private final WebElement element;

		public elementContainsText(String text, WebElement element) {
			this.text = text.toLowerCase();
			this.element = element;
		}

		@Override
		public Boolean apply(WebDriver driver) {
			try {
				return element.getAttribute("outerHTML").toLowerCase().contains(text);
			} catch (Exception e) {
				return false;
			}

		}
	}

	public void scrollIntoView(WebElement webElement) {
		try {
		((JavascriptExecutor) this.getDriver()).executeScript("arguments[0].scrollIntoView(true);", webElement);	
		logger.info("element has been scrolled");
		}catch(Exception e) {
			throw new DefaultException("driver is not scrollable to element "+ webElement);
		}
	}

	public boolean isSelected(By element, int maxWaitTime, int pollTime) {
		try {
			this.getWait(maxWaitTime, pollTime).until(ExpectedConditions.elementToBeSelected(element));
			return findElement(element).isSelected();
		} catch (Exception e) {
			logger.info(e.getStackTrace()[0].getFileName() + " :: "+ e.getStackTrace()[0].getClassName() + " : "+e.getStackTrace()[0].getMethodName() );
			if (this.logger != null) {
				this.logger.info("Exception" + ":" + "Element is selected. Element = " + element.toString()
						+ ", Exception is:" + e.getMessage());
			}
			return false;
		}
	}
	
	public String removeAllSpecialCharacter(String value ) {
		String c= value;
		Pattern pt = Pattern.compile("[^a-zA-Z0-9]");
        Matcher match= pt.matcher(c);
        while(match.find())
        {
            String s= match.group();
        c=c.replaceAll("\\"+s, "");
        }
        System.out.println(c);
        return c;
	}
	public String generateRandomData(int size) {		
		String randowdata=RandomStringUtils.randomAlphabetic(size).toLowerCase();
		return randowdata;
	}
	
	public String generateRandomNumericData(int size) {		
		String randowdata=RandomStringUtils.randomNumeric(size);
		return randowdata;
	}
	
	public boolean waitForJStoLoad() {

		JavascriptExecutor js = (JavascriptExecutor) this.getDriver();
		WebDriverWait wait = new WebDriverWait(this.getDriver(), Duration.ofSeconds(60));
		// wait for jQuery to load
		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return ((int) js.executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					logger.info("no jquery found");
					return true;
				}
			}
		};

		// wait for Javascript to load
		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
				return js.executeScript("return document.readyState").toString().equals("complete");
			}catch (Exception e) {
				logger.info("no java script found");
				return true;
			}
		}
		};
		return wait.until(jQueryLoad) && wait.until(jsLoad);
	}
	
	public SearchContext expandRootElement(WebElement element) {
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) getDriver();
		return (SearchContext) javascriptExecutor.executeScript("return arguments[0].shadowRoot", element);
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

	public String dateCreation(int days) {
		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
		return currentDate.plusDays(days).format(formatter);
	}
	
	public String dateCreation(int days, String pattern) {
		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
		return currentDate.plusDays(days).format(formatter);
	}
	
	public String convertRGBAtoHexidecimal(String value) {
		 String  hexColor = null;
		 Pattern pattern = Pattern.compile("rgba?\\((\\d+),\\s*(\\d+),\\s*(\\d+)");
	        Matcher matcher = pattern.matcher(value);
	        if (matcher.find()) {
	            int red = Integer.parseInt(matcher.group(1));
	            int green = Integer.parseInt(matcher.group(2));
	            int blue = Integer.parseInt(matcher.group(3));
	             hexColor = String.format("#%02x%02x%02x", red, green, blue);
	            System.out.println("Background color in hexadecimal format: " + hexColor);
	        }
	       return hexColor;	        
	}
	
	 public String pdfContent(String url) throws IOException {
	    	URL pdfUrl = new URL(url);
	    	InputStream is= pdfUrl.openStream();
	    	BufferedInputStream bis= new BufferedInputStream(is);
	    	PDDocument doc= PDDocument.load(bis);
	    	PDFTextStripper strip= new PDFTextStripper();
	    	String stripText= strip.getText(doc);
	    	doc.close();
	    	return stripText;
	    }
}
