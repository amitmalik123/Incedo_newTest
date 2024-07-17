package com.amk.cucumber.pages;

import org.junit.Assert;
import org.openqa.selenium.By;

import com.amk.cucumber.utility.SeleniumCore;

public class OptOutListPage extends BawBasePage {

	private static final String PAGE_NAME = "Opt Out List Page";	

	private By coachFrame = By.xpath("//iframe[@title='Opt-out List']");
	private By agent = By.cssSelector("#AgentID");
	private By stopAgent = By.cssSelector("#ButtonGroup1_AddAgent");
	private By resumeAgent = By.cssSelector("#ButtonGroup1_OptOut");
		
	public OptOutListPage(SeleniumCore seleniumCore) {
		this(seleniumCore, true);
	}

	public OptOutListPage(SeleniumCore seleniumCore, boolean pageVerification) {
		super(seleniumCore);
		if (pageVerification) {
			seleniumCore.switchToFrame(coachFrame, 10, 1);
			boolean isVisible = seleniumCore.isElementVisible(agent);
			if (isVisible) {
				this.seleniumCore.getLogger()
						.info(PAGE_NAME + " verification" + ":" + PAGE_NAME + " verification is PASSED");
			} else {
				this.seleniumCore.getLogger()
						.warn(PAGE_NAME + " verification" + ":" + PAGE_NAME + " verification is FAILED");
			}
		}
	}

	public void enterAgentId(String value) {
	//	String value="AGADEM";
		seleniumCore.sendKeys(agent, value);		
		logger.info("select user");
		customLogger("Select user ", value);		
	}	
	
	public void clickStopAgent() {
		seleniumCore.click(stopAgent);
		waitForLoadingData();
		if(seleniumCore.getText(By.cssSelector("#CustomHTML1")).contains("already exist in the opted-out list")) {
			logger.info("agent already exist in opted-out list");
			customLogger("agent already exist in opted-out list", "");
		}else {
		Assert.assertTrue("agent has not successfully Opted out", seleniumCore.getText(By.cssSelector("#CustomHTML1")).contains("successfully Opted out"));
		logger.info("agent has successfully Opted out");
		customLogger("agent has successfully Opted out", "");
		}	
	}
	
	public void clickResumeAgent() {
		seleniumCore.click(resumeAgent);
		waitForLoadingData();
		Assert.assertTrue("agent has not successfully Opted back in", seleniumCore.getText(By.cssSelector("#CustomHTML1")).contains("successfully opted back in"));
		logger.info("agent has successfully Opted back in");
		customLogger("agent has successfully Opted back in", "");
	}

	
}
