package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
//features= {".//Features/Customers.feature",".//Features/Login.feature"},//if we want to run multiple feature
  features= ".//Features/", //if we want to run all feature files
//	features=".//Features/Customers.feature",
    glue="stepDefinitions",
	dryRun=false,   //if it is "true" it will cross check every steps is having methods or not , keep it "false" to run in browser.
    monochrome=true, //it will remove unnecessary char from console window
	plugin= {"pretty","html:test-output"}, //it will generate report
	tags= {"@Sanity"}
	)

public class TestRun {

}
  