package com.amk.cucumber.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/feature/ewmFeature/WFI_FLXGSA.feature",
		plugin = { "pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "json:target/report/cucumber.json",  "html:target/report/cucumber.html"},
		glue = {"com.amk.cucumber.steps" },
		dryRun = false, 
		monochrome = true,
		tags="@C181997")

public class WFI_FLXGSATest {
	 
}
