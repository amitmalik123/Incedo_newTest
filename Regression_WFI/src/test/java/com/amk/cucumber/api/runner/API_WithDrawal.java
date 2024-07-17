package com.amk.cucumber.api.runner;


import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/feature/APIfeature/CreateACHInstruction.feature",
		plugin = { "pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" },
		glue = {"com.amk.cucumber.steps" },
		dryRun = false, monochrome = true,
		tags="@apiWithdrawals")

public class API_WithDrawal {
	 
}
