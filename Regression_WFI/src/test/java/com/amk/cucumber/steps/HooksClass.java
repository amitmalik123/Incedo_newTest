package com.amk.cucumber.steps;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class HooksClass extends GenericStepMethods {

	@Before
	public void startmethod(Scenario scenario) {
		logger.info("initilize the driver for test case: "+ scenario.getName());
		customLogger("initilize the driver for test case: "+ scenario.getName(), "");
		setup();
	}	
	
	
	/*
	 * @After public void teardown() { System.out.println("quiting the driver"); try
	 * { driver.close(); driver.quit();
	 * customLogger("Closed all the browser instances", ""); if
	 * (configReader.get_ExecutionType().contains("REMOTE")) { bsLocal.stop(); } }
	 * catch (Exception e) {
	 * customLogger("Not able to close all the browser instances", ""); } }
	 */
	 	 
	  

	@AfterStep()
	public void addScreenshot(Scenario scenario) throws IOException {
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		byte[] fileContent = FileUtils.readFileToByteArray(screenshot);
		scenario.attach(fileContent, "image/png", "screenshot");
	}
}
