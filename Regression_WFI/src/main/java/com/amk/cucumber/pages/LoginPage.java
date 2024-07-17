package com.amk.cucumber.pages;

import org.openqa.selenium.By;

import com.amk.cucumber.exceptions.DefaultException;
import com.amk.cucumber.utility.BasePage;
import com.amk.cucumber.utility.SeleniumCore;

public class LoginPage extends BasePage {

    // Static Data
    private static final String PAGE_NAME = "LOGIN PAGE";

    // Page Locators
    private final By image = By.xpath("//*[@alt='eWealthManager'   or    @alt=' logo']");
    private final By usernameTextField = By.xpath("//input[contains(@id,'sername')]");
    private final By passwordTextField = By.xpath("//input[contains(@id,'assword')]");
    private final By signInButton = By.xpath("//input[@type='submit']"); 
    private final By forgotPasswordLink = By.xpath("//a[contains(@href, 'forgotpassword')]");
    private final By iAgreeInput = By.xpath("//input[@value='I Agree']");
    private final By twoStepVerificationNo = By.xpath("//input[@value='NO THANKS']");
    private final By selectRoleContinueButton = By.xpath("//input[@id='btnContinue']");
    private final By selectAdminRole = By.xpath("//input[@id='radRoles_abralc_3']");
    private final By errorMessage = By.xpath("//span[@id='errMessage']");
    private final By acceptAllCookies =By.xpath("//button[text()='Accept All Cookies']");

    /**
     * To construct the Login Page
     *
     * @param seleniumCore
     */
    public LoginPage(SeleniumCore seleniumCore) {
        this(seleniumCore, true);
    }

    /**
     * To construct the Login Page
     *
     * @param seleniumCore
     * @param pageVerification - Flag to check if the page is loaded or not
     */
    public LoginPage(SeleniumCore seleniumCore, boolean pageVerification) {
        super(seleniumCore);
        if (pageVerification) {
            boolean isVisible = seleniumCore.isElementVisible(usernameTextField, 20, 1);
            if (isVisible) {
              System.out.println(PAGE_NAME + " verification" + "," + PAGE_NAME + " verification is PASSED");
            } else {
            	System.out.println(PAGE_NAME + " verification"+ "," + PAGE_NAME + " verification is FAILED");
            }
        }
    }

    /**
     * To enter User name on Login Page
     *
     * @param username
     * @param stepName
     * @param logMessage
     */
    public void enterUsername(String username, String stepName, String logMessage) {
    //	seleniumCore.scrollIntoView(seleniumCore.findElement(usernameTextField));
    	
        seleniumCore.click(usernameTextField,"click on username text field", "", 10,1);
        this.seleniumCore.sendKeys(usernameTextField, username, false, stepName, logMessage);
    }

    /**
     * To enter Password on Login Page
     *
     * @param password
     * @param stepName
     * @param logMessage
     */
    public void enterPassword(String password, String stepName, String logMessage) {
        seleniumCore.click(image);
        seleniumCore.waitForElementToBeClickable(passwordTextField);
        this.seleniumCore.sendKeys(passwordTextField, password, false, stepName, logMessage);
    }

    /**
     * To click on Signin Page
     *
     * @param stepName
     * @param logMessage
     */
    public void clickSignin(String stepName, String logMessage) {
        this.seleniumCore.click(signInButton, stepName, logMessage);
    }

    /**
     * To click on Forgot Password link
     *
     * @param stepName
     * @param logMessage
     */
    public void clickForgotPassword(String stepName, String logMessage) {
        this.seleniumCore.click(forgotPasswordLink, stepName, logMessage);
    }

    /**
     * Login to application using user name and password
     *
     * @param username
     * @param password
     * @param stepName
     * @return HomePage
     */
    public HomePage login(String username, String password, String stepName) {
		/*
		 * try { if(this.seleniumCore.isElementFound(acceptAllCookies, 10, 1)) {
		 * seleniumCore.getDriver().switchTo().activeElement();
		 * this.seleniumCore.findElement(acceptAllCookies).click();
		 * logger.info("accept cookies"); } }catch(Exception e) {
		 * logger.warn(e.getMessage()); }
		 */    	
		try {
			if (seleniumCore.isElementFound(By.xpath("//button[text()='Confirm My Choices']"), 10, 1)) {
				seleniumCore.getDriver().switchTo().activeElement();
				seleniumCore.findElement(By.xpath("//button[text()='Confirm My Choices']")).click();
				System.out.println("Cookies accepted");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		seleniumCore.waitForUILoading(1000);
    	
        this.enterUsername(username, stepName, PAGE_NAME + ": Entering username - " + username);
        customLogger("Entering username - ", username);
       
        this.enterPassword(password, stepName, PAGE_NAME + ": Entering password" );
        customLogger("Entering password - ", "*******");
       
        this.clickSignin(stepName, PAGE_NAME + ": Clicking on Signin");
        customLogger("Clicking on Signin ", "");
		
		/*
		 * try { if
		 * (seleniumCore.isElementFound(By.xpath("//button[text()='Confirm My Choices']"
		 * ), 10, 1)) { seleniumCore.getDriver().switchTo().activeElement();
		 * seleniumCore.findElement(By.xpath("//button[text()='Confirm My Choices']")).
		 * click(); System.out.println("Cookies accepted"); } } catch (Exception e) {
		 * System.out.println(e.getMessage()); }
		 */
		 

        if (this.seleniumCore.isElementFound(iAgreeInput, 1, 1)
                || this.seleniumCore.isElementFound(twoStepVerificationNo, 1, 1)) {
            acceptTermIfExist();
            declineTwoStepVerificationIfExist();
            try {
				checkErrorMessage();
			} catch (DefaultException e) {
				e.printStackTrace();
			}

        }
        if (this.seleniumCore.isElementFound(selectRoleContinueButton, 2, 1)){	
        	this.seleniumCore.findElement(selectAdminRole).click(); 	
        	seleniumCore.waitForUILoading(1000);	
        	 this.seleniumCore.findElement(selectRoleContinueButton).click();	
        	 seleniumCore.waitForJStoLoad();	
        	 logger.info(" admin role has been selected ");   	
        	 seleniumCore.waitForUILoading(5000);	
        }  
        return new HomePage(seleniumCore);
    }

    /**
     * Login to application using user name and password
     *
     * @param username
     * @param password
     * @param stepName
     * @return HomePage
     */
  

    private void acceptTermIfExist() {
        if (this.seleniumCore.isElementFound(iAgreeInput, 5, 1)) {
            this.seleniumCore.findElement(iAgreeInput).click();
        }
    }

    private void declineTwoStepVerificationIfExist() {
        if (this.seleniumCore.isElementFound(twoStepVerificationNo, 5, 1)) {
            this.seleniumCore.findElement(twoStepVerificationNo).click();
        }
    }

    private void checkErrorMessage()  {
        if (this.seleniumCore.isElementFound(errorMessage, 5, 1)) {
        	 logger.warn(PAGE_NAME + " verification"+SEPARATOR+ PAGE_NAME + " verification is FAILED");
            throw new DefaultException("Login failed! User does not exist");
        }
    }
}
