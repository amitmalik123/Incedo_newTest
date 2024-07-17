package com.amk.cucumber.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/feature/ewmFeature/WFI_ESIGSS.feature",
		plugin = { "pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "json:target/report/cucumber.json",  "html:target/report/cucumber.html"},
		glue = {"com.amk.cucumber.steps" },
		dryRun = false, 
		monochrome = true,
		tags="@C123987")

public class WFI_ESIGSS {
	 
}
